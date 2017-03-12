package mayton.sessionstat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;
import static java.sql.DriverManager.getConnection;
import static mayton.sessionstat.SessionStatUtils.calculateDifference;
import static mayton.sessionstat.SessionStatUtils.readSessionStat;

/**
 * @author mayton
 */
public class App 
{
    static Logger logger = LoggerFactory.getLogger(App.class);
    
    public static void main( String[] args ) throws Exception {
        Class.forName("oracle.jdbc.OracleDriver");
        String user = "SCOTT";
        String pwd  = "tiger";
        Connection conn = getConnection("jdbc:oracle:thin:"+user+"/"+pwd+"@127.0.0.1:1521/XE");


        SessionStat ss1 = readSessionStat(conn);
        logger.info(ss1.toString());

        CallableStatement cst = conn.prepareCall("BEGIN dbms_lock.sleep(15); END;");
        cst.execute();
        cst.close();

        SessionStat ss2 = readSessionStat(conn);
        logger.info(ss2.toString());

        cst = conn.prepareCall("BEGIN dbms_stats.gather_schema_stats('"+user+"'); END;");
        cst.execute();
        cst.close();

        SessionStat ss3 = readSessionStat(conn);

        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(
                "SELECT object_name," +
                " SUBOBJECT_NAME " +
                "FROM USER_OBJECTS order by 1,2");
        while(rs.next()){
            String owner = rs.getString(1);
            String name = rs.getString(2);
            logger.info("{}, {}",owner,name);
        }
        rs.close();
        st.close();

        SessionStat ss4 = readSessionStat(conn);

        conn.close();

        List<SessionStatWithLabel> stats = new ArrayList<>();
        stats.add(new SessionStatWithLabel(calculateDifference(ss1,ss2),"Dbms_Lock.sleep(15)"));
        stats.add(new SessionStatWithLabel(calculateDifference(ss2,ss3),"Gather stats"));
        stats.add(new SessionStatWithLabel(calculateDifference(ss3,ss4),"Enumerate dba_objects"));
        stats.add(new SessionStatWithLabel(calculateDifference(ss1,ss4),"Sum:"));

        new CSVSessionStatHelper().write(stats, System.out);
        new ExcelSessionStatHelper().write(stats, new FileOutputStream("out5.xlsx"));
    }
}
