package mayton.oracle;

import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import static org.junit.Assert.assertEquals;

public class TestPlsql {

    private void assertResult(String input, int expected) throws ParseException, IOException {
        final Reader r = new StringReader(input + "\n");
        try {
            assertEquals(expected, new Plsql(r).parseOneLine());
        } finally {
            r.close();
        }
    }

    @Test
    public void add() throws ParseException, IOException {
        assertResult("2+2", 4);
    }

    @Test
    public void unary() throws ParseException, IOException {
        assertResult("-2 + 5", 3);
    }

    @Test
    public void whitespace() throws ParseException, IOException {
        assertResult("\t\r- 12 \t + -25\t", -37);
    }

    @Test
    public void empty() throws ParseException, IOException {
        assertResult("", 0);
    }

    @Test(expected=TokenMgrError.class)
    public void invalidToken() throws ParseException, IOException {
        assertResult("caneva12pas", -37);
    }

    @Test(expected=ParseException.class)
    public void invalidSyntax() throws ParseException, IOException {
        assertResult("11 41", -37);
    }

}
