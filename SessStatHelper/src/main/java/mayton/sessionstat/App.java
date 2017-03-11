package mayton.sessionstat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;
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
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:scott/tiger@127.0.0.1:1521/XE");

        SessionStat ss1 = readSessionStat(conn);
        logger.info(ss1.toString());

        CallableStatement cst = conn.prepareCall("BEGIN dbms_lock.sleep(30); END;");
        cst.execute();
        cst.close();

        SessionStat ss2 = readSessionStat(conn);
        logger.info(ss2.toString());

        cst = conn.prepareCall("BEGIN dbms_stats.gather_schema_stats('SCOTT'); END;");
        cst.execute();
        cst.close();

        SessionStat ss3 = readSessionStat(conn);

        conn.close();

        List<SessionStat> stats = new ArrayList<SessionStat>();
        stats.add(calculateDifference(ss1,ss2));
        stats.add(calculateDifference(ss2,ss3));

        CSVSessionStatHelper.write(stats,new PrintWriter(System.out));
    }
}
