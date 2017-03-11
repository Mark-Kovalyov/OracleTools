package mayton.sessionstat;

/**
 * Oracle Session Stat entity.
 *
 * Simply depends on v$sesstat or gv$sesstat
 *
 * Do not forget give rights to
 * <PRE>
 * SQL> GRANT SELECT ON SYS.V$SESSTAT TO username
 * SQL> GRANT SELECT ON SYS.V$STATNAME TO username
 * </PRE>
 *
 * @see "https://docs.oracle.com/cd/B28359_01/server.111/b28320/stats002.htm#i375475"
 */
public class SessionStat {

    private long recursiveCalls;
    private long dbBlockGets;
    private long consistentGets;
    private long physicalReads;
    private long redoSize;
    private long bytesSentViaSQLNetToClient;
    private long bytesReceivedViaSQLNetFromClient;
    private long SQLNetRoundtripsToFromClient;
    private long sortsMemory;
    private long sortsDisk;
    private long rowsProcessed;

    public SessionStat(){

    }

    public SessionStat(long recursiveCalls, long dbBlockGets, long consistentGets, long physicalReads, long redoSize, long bytesSentViaSQLNetToClient, long bytesReceivedViaSQLNetFromClient, long SQLNetRoundtripsToFromClient, long sortsMemory, long sortsDisk, long rowsProcessed) {
        this.setRecursiveCalls(recursiveCalls);
        this.setDbBlockGets(dbBlockGets);
        this.setConsistentGets(consistentGets);
        this.setPhysicalReads(physicalReads);
        this.setRedoSize(redoSize);
        this.setBytesSentViaSQLNetToClient(bytesSentViaSQLNetToClient);
        this.setBytesReceivedViaSQLNetFromClient(bytesReceivedViaSQLNetFromClient);
        this.setSQLNetRoundtripsToFromClient(SQLNetRoundtripsToFromClient);
        this.setSortsMemory(sortsMemory);
        this.setSortsDisk(sortsDisk);
        this.setRowsProcessed(rowsProcessed);
    }

    /**
     * Number of recursive calls generated at both the user and system level. Oracle maintains tables used for
     * internal processing. When Oracle needs to make a change to these tables, it internally generates an
     * internal SQL statement, which in turn generates a recursive call.
     */
    public long getRecursiveCalls() {
        return recursiveCalls;
    }

    /**
     * Number of times a CURRENT block was requested.
     */
    public long getDbBlockGets() {
        return dbBlockGets;
    }

    /**
     * Number of times a consistent read was requested for a block.
     */
    public long getConsistentGets() {
        return consistentGets;
    }

    /**
     * Total number of data blocks read from disk. This value can be greater than the value of
     * "physical reads direct" plus "physical reads cache" as reads into process private buffers
     * also included in this statistic.
     */
    public long getPhysicalReads() {
        return physicalReads;
    }

    /**
     * Total amount of redo generated in bytes
     */
    public long getRedoSize() {
        return redoSize;
    }

    /**
     * Total number of bytes sent to the client from the foreground processes
     */
    public long getBytesSentViaSQLNetToClient() {
        return bytesSentViaSQLNetToClient;
    }

    /**
     * Total number of bytes received from the client over Oracle Net Services
     */
    public long getBytesReceivedViaSQLNetFromClient() {
        return bytesReceivedViaSQLNetFromClient;
    }

    /**
     * Total number of Oracle Net Services messages sent to and received from the client
     */
    public long getSQLNetRoundtripsToFromClient() {
        return SQLNetRoundtripsToFromClient;
    }

    /**
     * Number of sort operations that were performed completely in memory and did not require any disk writes<br>
     *
     * You cannot do much better than memory sorts, except maybe no sorts at all. Sorting is usually caused
     * by selection criteria specifications within table join SQL operations.
     */
    public long getSortsMemory() {
        return sortsMemory;
    }

    /**
     * Number of sort operations that required at least one disk write<br>
     *
     * Sorts that require I/O to disk are quite resource intensive. Try increasing the size of the
     * initialization parameter SORT_AREA_SIZE. For more information, see "SORT_AREA_SIZE".
     */
    public long getSortsDisk() {
        return sortsDisk;
    }

    /**
     * Rows fetched via callback. Useful primarily for internal debugging purposes.
     */
    public long getRowsProcessed() {
        return rowsProcessed;
    }

    public void setRecursiveCalls(long recursiveCalls) {
        this.recursiveCalls = recursiveCalls;
    }

    public void setDbBlockGets(long dbBlockGets) {
        this.dbBlockGets = dbBlockGets;
    }

    public void setConsistentGets(long consistentGets) {
        this.consistentGets = consistentGets;
    }

    public void setPhysicalReads(long physicalReads) {
        this.physicalReads = physicalReads;
    }

    public void setRedoSize(long redoSize) {
        this.redoSize = redoSize;
    }

    public void setBytesSentViaSQLNetToClient(long bytesSentViaSQLNetToClient) {
        this.bytesSentViaSQLNetToClient = bytesSentViaSQLNetToClient;
    }

    public void setBytesReceivedViaSQLNetFromClient(long bytesReceivedViaSQLNetFromClient) {
        this.bytesReceivedViaSQLNetFromClient = bytesReceivedViaSQLNetFromClient;
    }

    public void setSQLNetRoundtripsToFromClient(long SQLNetRoundtripsToFromClient) {
        this.SQLNetRoundtripsToFromClient = SQLNetRoundtripsToFromClient;
    }

    public void setSortsMemory(long sortsMemory) {
        this.sortsMemory = sortsMemory;
    }

    public void setSortsDisk(long sortsDisk) {
        this.sortsDisk = sortsDisk;
    }

    public void setRowsProcessed(long rowsProcessed) {
        this.rowsProcessed = rowsProcessed;
    }

    @Override
    public String toString() {
        return "SessionStat{" +
                "\n recursiveCalls=" + recursiveCalls +
                ", \n dbBlockGets=" + dbBlockGets +
                ", \n consistentGets=" + consistentGets +
                ", \n physicalReads=" + physicalReads +
                ", \n redoSize=" + redoSize +
                ", \n bytesSentViaSQLNetToClient=" + bytesSentViaSQLNetToClient +
                ", \n bytesReceivedViaSQLNetFromClient=" + bytesReceivedViaSQLNetFromClient +
                ", \n SQLNetRoundtripsToFromClient=" + SQLNetRoundtripsToFromClient +
                ", \n sortsMemory=" + sortsMemory +
                ", \n sortsDisk=" + sortsDisk +
                ", \n rowsProcessed=" + rowsProcessed +
                '}';
    }
}
