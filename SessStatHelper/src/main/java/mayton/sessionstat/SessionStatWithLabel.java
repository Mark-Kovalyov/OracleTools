package mayton.sessionstat;

/**
 *
 *
 * @author mayton
 */
public class SessionStatWithLabel {

    private SessionStat sessionStat;
    private String label;

    public SessionStatWithLabel(SessionStat sessionStat, String label) {
        this.sessionStat = sessionStat;
        this.label = label;
    }

    public SessionStat getSessionStat() {
        return sessionStat;
    }

    public void setSessionStat(SessionStat sessionStat) {
        this.sessionStat = sessionStat;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
