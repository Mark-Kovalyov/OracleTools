package mayton.sessionstat;

import javax.annotation.Nonnull;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public interface SessionWriteHelper {

    void write(@Nonnull List<SessionStatWithLabel> sessionStatsWithLabel, @Nonnull OutputStream stream) throws IOException;

}
