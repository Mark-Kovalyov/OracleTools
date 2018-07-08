package mayton.oracle;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

public class BaseAntlr4Test {

    protected ParseTreeListener treeListener;
    protected Parser parser;
    protected Lexer lexer;
    protected ParseTreeVisitor visitor;

}
