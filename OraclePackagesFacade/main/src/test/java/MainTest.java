import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import sun.applet.Main;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class MainTest {

    static Logger logger = LogManager.getLogger(MainTest.class);

    @Test
    public void test() throws IOException {

        ClassLoader classLoader = getClass().getClassLoader();

        CharStream charStream = CharStreams.fromStream(
                classLoader.getResourceAsStream("emp_mgmt.sql"));

        TokenSource tokenSource = new PlsqlLexer(charStream);

        TokenStream tokenStream = new CommonTokenStream(tokenSource);

        PlsqlParser parser = new PlsqlParser(tokenStream);

        String[] names = parser.getRuleNames();

        ATN atn = parser.getATN();

        String s = parser.getSerializedATN();

        logger.info("s = {}",s);
    }

}
