package mayton.sessionstat;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import javax.annotation.Nonnull;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

import static jdk.nashorn.internal.objects.Global.print;

public class CSVSessionStatHelper {

    public static void write(@Nonnull List<SessionStat> sessionStats,@Nonnull Writer writer) throws IOException {
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
        for(SessionStat s : sessionStats){
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

    }

}
