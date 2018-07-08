grammar Plsql;

// --------------------- Parser rules: --------------------------------------

prog: package_definition;

package_definition : 'create' replace_option? 'package' ORACLE_NAME 'as' package_definition_body 'end' ORACLE_NAME? ';' ;

replace_option : 'or replace' ;

package_definition_body : procedure_or_function+ ;

procedure_or_function : procedure_def | function_def ;

procedure_def : 'procedure' ORACLE_NAME optional_argument_list;

function_def  : 'function' ORACLE_NAME optional_argument_list 'return' ORACLE_TYPE ;

optional_argument_list : '(' argument (',' argument)+ ')' ;

argument : ORACLE_NAME OPTIONAL_IN_OUT? ORACLE_TYPE;

// --------------------- Lexer rules: ----------------------------

OPTIONAL_IN_OUT : 'in' | 'out' ;

ORACLE_NAME : ('a'..'z') ;

ORACLE_TYPE : 'varchar2' | LARGE_OBJECT_DATATYPES ;

LARGE_OBJECT_DATATYPES : 'BLOB' | 'CLOB' | 'NCLOB' | 'BFILE' ;

WHITESPACE          : (' ' | '\t') ;

NEWLINE             : ('\r'? '\n' | '\r')+ ;
