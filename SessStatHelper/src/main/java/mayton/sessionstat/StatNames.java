package mayton.sessionstat;

/**
 * Gathered from Oracle Database 11g Express Edition Release 11.2.0.2.0 - 64bit Production
 *
 * @author mayton
 */
public enum StatNames {

    RECURSIVE_CALLS("recursive calls"),
    DB_BLOCK_GETS("db block gets"),
    CONSISTENT_GETS("consistent gets"),
    PHYSICAL_READS("physical reads"),
    REDO_SIZE("redo size"),
    BYTES_SENT_VIA_SQLNET_TO_CLIENT("bytes sent via SQL*Net to client"),
    BYTES_RECEIVED_VIA_SQLNET_FROM_CLIENT("bytes received via SQL*Net from client"),
    SQLNET_ROUNDTRIPS_TO_FROM_CLIENT("SQL*Net roundtrips to/from client"),
    SORTS_MEMORY("sorts (memory)"),
    SORTS_DISK("sorts (disk)"),
    /**
     * "rows processed" in SQL*Plus
     */
    ROWS_FETCHED_VIA_CALLBACK("rows fetched via callback");

    public final String desc;

    StatNames(String desc) {
        this.desc = desc;
    }

    public static String formatCsvDesc() {
        // TODO: Replace with Stream
        StringBuilder sb = new StringBuilder();
        for(StatNames statNames : StatNames.values()) {
            sb.append("'");
            sb.append(statNames.desc);
            sb.append("',");
        }
        String res = sb.toString();
        return res.substring(0,res.length() - 1);
    }
}
