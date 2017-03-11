package mayton.sessionstat;

/**
 * Hard-coded constants relevant to
 *
 * @author mayton
 */
public enum StatNames {

    // gathered from Oracle Database 11g Express Edition Release 11.2.0.2.0 - 64bit Production
    RECURSIVE_CALLS("recursive calls",  8),
    DB_BLOCK_GETS("db block gets",     66),
    CONSISTENT_GETS("consistent gets", 70),
    PHYSICAL_READS("physical reads" ,  75),
    REDO_SIZE("redo size",            175),
    BYTES_SENT_VIA_SQLNET_TO_CLIENT("bytes sent via SQL*Net to client",             579),
    BYTES_RECEIVED_VIA_SQLNET_FROM_CLIENT("bytes received via SQL*Net from client", 580),
    SQLNET_ROUNDTRIPS_TO_FROM_CLIENT("SQL*Net roundtrips to/from client",  581),
    SORTS_MEMORY("sorts (memory)",    589),
    SORTS_DISK("sorts (disk)",        590),
    ROWS_FETCHED_VIA_CALLBACK("rows fetched via callback",  381);  // "rows processed" in SQL*Plus

    private final String name;
    private final int statNum;

    StatNames(String name,int statNum) {
        this.name = name;
        this.statNum = statNum;
    }

    public String getName(){
        return name;
    }

    public int getStatNum(){
        return statNum;
    }
}
