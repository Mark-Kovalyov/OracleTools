grammar Plsql;

// --------------------- Parser rules: --------------------------------------

prog: package_definition;

package_definition : 'create' replace_option? 'package' ORACLE_NAME 'as' package_definition_body 'end' ORACLE_NAME? ';' ;

replace_option : 'or replace' ;

package_definition_body : procedure_or_function+ ;

procedure_or_function : procedure_def | function_def ;

procedure_def : 'procedure' ORACLE_NAME optional_argument_list;

function_def  : 'function' ORACLE_NAME optional_argument_list 'return' ORACLE_TYPES ;

optional_argument_list : '(' argument (',' argument)+ ')' ;

argument : ORACLE_NAME OPTIONAL_IN_OUT? ORACLE_TYPES;

// --------------------- Lexer rules: ----------------------------

INT : '0'..'9'+ ;

OPTIONAL_IN_OUT : 'IN' | 'OUT' | 'IN OUT' ;

ORACLE_NAME : ('a'..'z') ;

LENGTH_CLAUSE : '(' INT ')' ;

NUMBER_LENGTH_PRECISION_CLAUSE : ('(' INT (',' INT) ? ')');

ORACLE_TYPES : NUMERIC_DATATYPES |
               CHARACTER_DATATYPYES |
               LARGE_OBJECT_DATATYPES |
               DATE_DATATYPES |
               ROWID_DATATYPES |
               RAW_DATATYPES |
               XML_DATATYPES ;

CHARACTER_DATATYPYES : 'CHAR' LENGTH_CLAUSE? |
                       'VARCHAR' LENGTH_CLAUSE? |
                       'VARCHAR2' LENGTH_CLAUSE? |
                       'NVARCHAR' LENGTH_CLAUSE? |
                       'NVARCHAR2' LENGTH_CLAUSE? ;


NUMERIC_DATATYPES : NUMBER_DATATYPE | 'BINARY_FLOAT' | 'BINARY_DOUBLE' ;

NUMBER_DATATYPE : 'NUMBER' NUMBER_LENGTH_PRECISION_CLAUSE? ;

LARGE_OBJECT_DATATYPES : 'BLOB' | 'CLOB' | 'NCLOB' | 'BFILE' ;

RAW_DATATYPES : 'RAW' | 'LONG RAW' ;

DATE_DATATYPES : 'DATE' | 'TIMESTAMP' | 'TIMESTAMP WITH TIME ZONE' | 'TIMESTAMP WITH LOCAL TIME ZONE' ;

ROWID_DATATYPES : 'ROWID' | 'UROWID' ;

WHITESPACE          : (' ' | '\t') ;

NEWLINE             : ('\r'? '\n' | '\r')+ ;

XML_DATATYPES : 'XMLTYPE' | 'URITYPE';