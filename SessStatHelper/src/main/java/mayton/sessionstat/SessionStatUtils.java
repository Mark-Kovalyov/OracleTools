package mayton.sessionstat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.NotThreadSafe;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import static java.util.Collections.unmodifiableMap;
import static mayton.sessionstat.StatNames.*;

@NotThreadSafe
public class SessionStatUtils {

    static Logger logger = LoggerFactory.getLogger(SessionStatUtils.class);

    static String statisticNumScope = null;

    static String statisticStatement = null;

    static {
        StringBuilder sb = new StringBuilder();
        for(StatNames v : StatNames.values()){
            sb.append(v.getStatNum());
            sb.append(",");
        }
        statisticNumScope = sb.toString();
        statisticNumScope = statisticNumScope.substring(0,statisticNumScope.length() - 1);
        statisticStatement =
                "SELECT STATISTIC#,VALUE " +
                "FROM V$SESSTAT " +
                "WHERE SID = SYS_CONTEXT('USERENV','SID') AND " +
                "STATISTIC# IN ("+statisticNumScope+")";
        logger.info(statisticStatement);
    }

    @Nonnull
    static SessionStat readSessionStat(@Nonnull Connection conn) throws SQLException{
        if (!conn.isClosed()) {
            SessionStat stat = new SessionStat();
            PreparedStatement preparedStatement = conn.prepareStatement(statisticStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                long statisticNum = rs.getLong(1);
                long value        = rs.getLong(2);
                if (statisticNum == RECURSIVE_CALLS.getStatNum()){
                    stat.setRecursiveCalls(value);
                    continue;
                }
                if (statisticNum == DB_BLOCK_GETS.getStatNum()){
                    stat.setDbBlockGets(value);
                    continue;
                }
                if (statisticNum == CONSISTENT_GETS.getStatNum()){
                    stat.setDbBlockGets(value);
                    continue;
                }
                if (statisticNum == PHYSICAL_READS.getStatNum()){
                    stat.setSortsMemory(value);
                    continue;
                }
                if (statisticNum == REDO_SIZE.getStatNum()){
                    stat.setRedoSize(value);
                    continue;
                }
                if (statisticNum == BYTES_SENT_VIA_SQLNET_TO_CLIENT.getStatNum()){
                    stat.setBytesSentViaSQLNetToClient(value);
                    continue;
                }
                if (statisticNum == BYTES_RECEIVED_VIA_SQLNET_FROM_CLIENT.getStatNum()){
                    stat.setBytesReceivedViaSQLNetFromClient(value);
                    continue;
                }
                if (statisticNum == SQLNET_ROUNDTRIPS_TO_FROM_CLIENT.getStatNum()){
                    stat.setSQLNetRoundtripsToFromClient(value);
                    continue;
                }
                if (statisticNum == SORTS_MEMORY.getStatNum()){
                    stat.setSortsMemory(value);
                    continue;
                }
                if (statisticNum == SORTS_DISK.getStatNum()){
                    stat.setSortsDisk(value);
                    continue;
                }
                if (statisticNum == ROWS_FETCHED_VIA_CALLBACK.getStatNum()){
                    stat.setRowsProcessed(value);
                    continue;
                }
            }
            return stat;
        } else {
            logger.warn("The connection is closed! Empty stat entity will return!");
            return new SessionStat();
        }
    }

    @Nonnull
    static SessionStat calculateDifference(SessionStat s1,SessionStat s2){
        return new SessionStat(
                s2.getRecursiveCalls() - s1.getRecursiveCalls(),
                s2.getDbBlockGets()    - s1.getDbBlockGets(),
                s2.getConsistentGets() - s1.getConsistentGets(),
                s2.getPhysicalReads()  - s1.getPhysicalReads(),
                s2.getRedoSize()       - s1.getRedoSize(),
                s2.getBytesSentViaSQLNetToClient()       - s1.getBytesSentViaSQLNetToClient(),
                s2.getBytesReceivedViaSQLNetFromClient() - s1.getBytesReceivedViaSQLNetFromClient(),
                s2.getRowsProcessed()  - s1.getRowsProcessed(),
                s2.getSQLNetRoundtripsToFromClient()     - s1.getSQLNetRoundtripsToFromClient(),
                s2.getSortsMemory()    - s1.getSortsMemory(),
                s2.getSortsDisk()      - s1.getSortsDisk()
        );
    }

}
