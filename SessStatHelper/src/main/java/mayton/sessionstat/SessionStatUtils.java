package mayton.sessionstat;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.NotThreadSafe;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.stream.Collectors;

import static mayton.sessionstat.StatNames.*;

@NotThreadSafe
public class SessionStatUtils {

    static Logger logger = LoggerFactory.getLogger(SessionStatUtils.class);

    private static String statisticStatement = null;

    static {
        String statisticNames = Arrays.stream(StatNames.values())
                .map((v) -> "'" + v + "'")
                .collect(Collectors.joining(","));

        statisticStatement =
                "SELECT " +
                        "SN.NAME, " +
                        "SS.VALUE " +
                " FROM " +
                        "V$SESSTAT SS," +
                        "V$STATNAME SN " +
                " WHERE SID = SYS_CONTEXT('USERENV','SID') AND " +
                "        SS.STATISTIC# = SN.STATISTIC# AND" +
                "        SN.NAME IN (" + statisticNames + ")";
    }

    @Nonnull
    static SessionStat readSessionStat(@Nonnull Connection conn) throws SQLException{
        if (!conn.isClosed()) {
            SessionStat stat = new SessionStat();
            PreparedStatement preparedStatement = conn.prepareStatement(statisticStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){

                String  statisticName = rs.getString(1);
                long    value         = rs.getLong(2);

                if (statisticName == RECURSIVE_CALLS.name()){
                    stat.setRecursiveCalls(value);
                    continue;
                }
                if (statisticName == DB_BLOCK_GETS.name()){
                    stat.setDbBlockGets(value);
                    continue;
                }
                if (statisticName == CONSISTENT_GETS.name()){
                    stat.setConsistentGets(value);
                    continue;
                }
                if (statisticName == PHYSICAL_READS.name()){
                    stat.setPhysicalReads(value);
                    continue;
                }
                if (statisticName == REDO_SIZE.name()){
                    stat.setRedoSize(value);
                    continue;
                }
                if (statisticName == BYTES_SENT_VIA_SQLNET_TO_CLIENT.name()){
                    stat.setBytesSentViaSQLNetToClient(value);
                    continue;
                }
                if (statisticName == BYTES_RECEIVED_VIA_SQLNET_FROM_CLIENT.name()){
                    stat.setBytesReceivedViaSQLNetFromClient(value);
                    continue;
                }
                if (statisticName == SQLNET_ROUNDTRIPS_TO_FROM_CLIENT.name()){
                    stat.setSQLNetRoundtripsToFromClient(value);
                    continue;
                }
                if (statisticName == SORTS_MEMORY.name()){
                    stat.setSortsMemory(value);
                    continue;
                }
                if (statisticName == SORTS_DISK.name()){
                    stat.setSortsDisk(value);
                    continue;
                }
                if (statisticName == ROWS_FETCHED_VIA_CALLBACK.name()){
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
                s2.getSQLNetRoundtripsToFromClient()     - s1.getSQLNetRoundtripsToFromClient(),
                s2.getSortsMemory()    - s1.getSortsMemory(),
                s2.getSortsDisk()      - s1.getSortsDisk(),
                s2.getRowsProcessed()  - s1.getRowsProcessed()
        );
    }

}
