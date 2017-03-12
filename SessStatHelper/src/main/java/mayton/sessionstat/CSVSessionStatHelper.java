package mayton.sessionstat;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import javax.annotation.Nonnull;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.List;

import static jdk.nashorn.internal.objects.Global.print;

public class CSVSessionStatHelper implements SessionWriteHelper {

    @Override
    public void write(@Nonnull List<SessionStatWithLabel> sessionStatsWithLabel, @Nonnull OutputStream os) throws IOException {
        PrintWriter writer = new PrintWriter(os);
        CSVPrinter csvPrinter = CSVFormat.DEFAULT.withHeader(
                "recursiveCalls",
                "dbBlockGets",
                "consistentGets",
                "physicalReads",
                "redoSize",
                "bytesSentViaSQLNetToClient",
                "bytesReceivedViaSQLNetFromClient",
                "SQLNetRoundtripsToFromClient",
                "sortsMemory",
                "sortsDisk",
                "rowsProcessed"
        ).print(writer);
        for(SessionStatWithLabel ss : sessionStatsWithLabel){
            SessionStat s = ss.getSessionStat();
            csvPrinter.print(s.getRecursiveCalls());
            csvPrinter.print(s.getDbBlockGets());
            csvPrinter.print(s.getConsistentGets());
            csvPrinter.print(s.getPhysicalReads());
            csvPrinter.print(s.getRedoSize());
            csvPrinter.print(s.getBytesSentViaSQLNetToClient());
            csvPrinter.print(s.getBytesReceivedViaSQLNetFromClient());
            csvPrinter.print(s.getSQLNetRoundtripsToFromClient());
            csvPrinter.print(s.getSortsMemory());
            csvPrinter.print(s.getSortsDisk());
            csvPrinter.print(s.getRowsProcessed());
            csvPrinter.println();
        }
        csvPrinter.close();
        writer.flush();
    }

}
