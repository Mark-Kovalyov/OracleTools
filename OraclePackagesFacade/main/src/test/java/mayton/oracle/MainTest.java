package mayton.oracle;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

public class MainTest {

    static Logger logger = LoggerFactory.getLogger(MainTest.class);


    InputStream getResource(String name) {
        ClassLoader classLoader = getClass().getClassLoader();
        return classLoader.getResourceAsStream(name);
    }

    @Test
    public void test() throws IOException {

        CharStream charStream = CharStreams.fromStream(getResource("emp_mgmt.sql"));

        TokenSource tokenSource = new PlsqlLexer(charStream);

        TokenStream tokenStream = new CommonTokenStream(tokenSource);

        PlsqlParser parser = new PlsqlParser(tokenStream);

        assertEquals("Plsql.g4",parser.getGrammarFileName());

        Vocabulary voc = parser.getVocabulary();

        String[] names = parser.getRuleNames();

        assertEquals(9,names.length);
        assertEquals("prog",names[0]);

        for(String rule : names) {
            logger.info("rule = {}", rule);
        }

        ATN atn = parser.getATN();

        String s = parser.getSerializedATN();



        //assertEquals("",s);

        //logger.info("s = {}",s);
    }

}
