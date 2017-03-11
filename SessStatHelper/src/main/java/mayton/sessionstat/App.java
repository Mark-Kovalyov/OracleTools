package mayton.sessionstat;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

import static java.lang.System.out;

/**
 * @author mayton
 */
public class App 
{
    public static void main( String[] args ) throws Exception {
        Class.forName("oracle.jdbc.OracleDriver");
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:scott/tiger@127.0.0.1:1521/XE");

        SessionStat ss1 = SessionStatUtils.readSessionStat(conn);
        out.println(ss1.toString());

        CallableStatement cst = conn.prepareCall("BEGIN dbms_stats.gather_schema_stats('SCOTT'); END;");
        cst.execute();
        cst.close();

        SessionStat ss2 = SessionStatUtils.readSessionStat(conn);
        out.println(ss2.toString());

        SessionStat diff = SessionStatUtils.calculateDifference(ss1,ss2);

        out.println(diff.toString());

        conn.close();
    }
}
