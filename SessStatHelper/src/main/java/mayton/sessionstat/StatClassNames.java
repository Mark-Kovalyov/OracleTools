package mayton.sessionstat;

public enum StatClassNames {

    USER(1,"User"),
    REDO(2,"Redo"),
    ENQUEUE(4,"Enqueue"),
    CACHE(8,"Cache"),
    OS(16,"OS"),
    RAC(32,"Real Application Clusters"),
    SQL(64,"SQL"),
    DEBUG(128,"Debug");

    public int n;
    public String desc;

    StatClassNames(int n,String desc) {
        this.n = n;
        this.desc = desc;
    }

    public static String decodeClass(int n) {
        StringBuilder sb = new StringBuilder();
        for(StatClassNames scn : StatClassNames.values()) {
            if ((scn.n & n ) != 0) {
                sb.append(scn.name());
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
