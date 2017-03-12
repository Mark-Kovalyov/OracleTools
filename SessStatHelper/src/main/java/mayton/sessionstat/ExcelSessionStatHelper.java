package mayton.sessionstat;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.annotation.Nonnull;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.util.List;

public class ExcelSessionStatHelper implements SessionWriteHelper {

    public void refreshColors(Sheet sheet){

    }


    @Override
    public void write(@Nonnull List<SessionStatWithLabel> sessionStatsWithLabel, @Nonnull OutputStream stream) throws IOException {
        Workbook wb = new XSSFWorkbook();

        Sheet sheet = wb.createSheet("Sheet1");

        Row row = sheet.createRow(0);

        String[] headers = new String[]{
                "Recursive calls",
                "Db block gets",
                "Consistent gets",
                "Physical reads",
                "Redo size",
                "Bytes sent via SQL*Net to client",
                "Bytes received via SQL*Net from client",
                "SQL*Net roundtrips to/from client",
                "Sorts (memory)",
                "Sorts (disk)",
                "Rows processed"
        };
        int col = 1;
        for (String header : headers) {
            Cell cell = row.createCell(col);
            cell.setCellValue(header);
            col++;
        }

        SessionStat sum = new SessionStat();
        Cell cell = null;
        int rowCnt = 1;

        for (SessionStatWithLabel sl : sessionStatsWithLabel) {
            SessionStat s = sl.getSessionStat();
            row = sheet.createRow(rowCnt);
            col = 0;
            // Label
            cell = row.createCell(col);
            cell.setCellValue(sl.getLabel());
            col++;
            // Recursive calls
            cell = row.createCell(col);
            long recCalls = s.getRecursiveCalls();
            cell.setCellValue(recCalls);
            sum.setRecursiveCalls(sum.getRecursiveCalls() + recCalls);
                XSSFCellStyle style1 = (XSSFCellStyle) wb.createCellStyle();
                style1.setFillForegroundColor(new XSSFColor(new java.awt.Color(128, 0, 128)));
                style1.setFillPattern(CellStyle.SOLID_FOREGROUND);
            col++;
            // BLock gets
            cell = row.createCell(col);
            long blockGets = s.getDbBlockGets();
            cell.setCellValue(blockGets);
            sum.setDbBlockGets(sum.getDbBlockGets() + blockGets);
            col++;

            cell = row.createCell(col);
            long consGets = s.getConsistentGets();
            cell.setCellValue(consGets);
            sum.setConsistentGets(sum.getConsistentGets() + consGets);
            col++;

            cell = row.createCell(col);
            long phReads = s.getPhysicalReads();
            cell.setCellValue(phReads);
            sum.setConsistentGets(sum.getPhysicalReads());
            col++;

            cell = row.createCell(col);
            cell.setCellValue(s.getRedoSize());
            col++;

            cell = row.createCell(col);
            cell.setCellValue(s.getBytesSentViaSQLNetToClient());
            col++;

            cell = row.createCell(col);
            cell.setCellValue(s.getBytesReceivedViaSQLNetFromClient());
            col++;

            cell = row.createCell(col);
            cell.setCellValue(s.getSQLNetRoundtripsToFromClient());
            col++;

            cell = row.createCell(col);
            cell.setCellValue(s.getSortsMemory());
            col++;

            cell = row.createCell(col);
            cell.setCellValue(s.getSortsDisk());
            col++;

            cell = row.createCell(col);
            cell.setCellValue(s.getRowsProcessed());
            col++;


            rowCnt++;
        }

        /*row = sheet.createRow(rowCnt);

        col = 0;

        cell = row.createCell(col);
        cell.setCellValue("Sum:");
        col++;

        cell = row.createCell(col);
        cell.setCellValue(sum.getRecursiveCalls());
        col++;

        cell = row.createCell(col);
        cell.setCellValue(sum.getDbBlockGets());
        col++;*/

        wb.write(stream);
        wb.close();
    }

}
