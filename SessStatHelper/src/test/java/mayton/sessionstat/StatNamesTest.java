package mayton.sessionstat;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StatNamesTest {

    @Test
    public void testCsv(){
        assertEquals("'recursive calls','db block gets'," +
                "'consistent gets','physical reads','redo size'," +
                "'bytes sent via SQL*Net to client'," +
                "'bytes received via SQL*Net from client'," +
                "'SQL*Net roundtrips to/from client'," +
                "'sorts (memory)','sorts (disk)'," +
                "'rows fetched via callback'" ,StatNames.formatCsvDesc());
    }

}
