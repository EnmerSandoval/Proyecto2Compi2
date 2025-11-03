grammar DecafOLC2;

programa
    : claseDecl+ EOF
    ;

claseDecl
    : 'class' IDENT ( 'extends' IDENT )? '{' miembroClase* '}'
    ;

miembroClase
    : campoDecl
    | constructorDecl
    | metodoDecl
    ;

campoDecl
    : modificador* tipo listaVars ';'
    | modificador* 'var' IDENT ('=' expr)? ';'
    ;

listaVars
    : varInit (',' varInit)*
    ;

varInit
    : IDENT ('=' expr)?
    ;

constructorDecl
    : modificador* IDENT '(' params? ')' bloque
    ;

metodoDecl
    : modificador* tipo IDENT '(' params? ')' bloque
    | modificador* 'void' IDENT '(' params? ')' bloque
    ;

params
    : param (',' param)*
    ;

param
    : tipo IDENT
    ;

tipo
    : tipoBase dims?
    ;

tipoBase
    : 'int'
    | 'float'
    | 'char'
    | 'boolean'
    | 'String'
    | IDENT
    ;

dims
    : ('[' ']')+
    ;

modificador
    : 'public'
    | 'private'
    | 'protected'
    | 'final'
    ;

bloque
    : '{' sentencia* '}'
    ;

sentencia
    : bloque
    | ifStmt
    | whileStmt
    | doWhileStmt
    | forStmt
    | switchStmt
    | printStmt
    | 'break' ';'
    | 'continue' ';'
    | 'return' expr? ';'
    | expr ';'
    | ';'
    ;

printStmt
    : 'print' '(' (expr (',' expr)*)? ')' ';'
    ;

ifStmt
    : 'if' '(' expr ')' sentencia ('else' sentencia)?
    ;

whileStmt
    : 'while' '(' expr ')' sentencia
    ;

doWhileStmt
    : 'do' sentencia 'while' '(' expr ')' ';'
    ;

forStmt
    : 'for' '(' forInit? ';' expr? ';' forUpdate? ')' sentencia
    ;

forInit
    : campoDecl
    | expr (',' expr)*
    ;

forUpdate
    : expr (',' expr)*
    ;

switchStmt
    : 'switch' '(' expr ')' '{' switchItem* '}'
    ;

switchItem
    : switchLabel sentencia*
    ;

switchLabel
    : 'case' literal ':'
    | 'default' ':'
    ;


expr
    : asignacionExpr
    ;

asignacionExpr
    : orExpr (opAsig asignacionExpr)?
    ;

opAsig
    : '='
    | '+=' | '-=' | '*=' | '/=' | '%='
    ;

orExpr
    : andExpr ( '||' andExpr )*
    ;

andExpr
    : igualdadExpr ( '&&' igualdadExpr )*
    ;

igualdadExpr
    : relExpr ( ('==' | '!=') relExpr )*
    ;

relExpr
    : aditivoExpr ( ('<' | '>' | '<=' | '>=') aditivoExpr )*
    ;

aditivoExpr
    : multExpr (('+'|'-') multExpr)*
    ;

multExpr
    : unaryExpr (('*'|'/'|'%') unaryExpr)*
    ;

unaryExpr
    : ('+'|'-'|'!') unaryExpr
    | postfixExpr
    ;

postfixExpr
    : primaria postfixOp*
    ;

postfixOp
    : '.' IDENT '(' args? ')'
    | '.' IDENT
    | '[' expr ']'
    ;

primaria
    : literal
    | 'new' tipoBase '(' args? ')'
    | 'new' tipoBase ('[' expr ']')+
    | IDENT
    | '(' expr ')'
    | 'this'
    | 'super'
    ;

args
    : expr (',' expr)*
    ;

literal
    : INT_LIT
    | FLOAT_LIT
    | CHAR_LIT
    | STRING_LIT
    | 'true'
    | 'false'
    | 'null'
    ;


IDENT
    : LETTER (LETTER | DIGIT | '_')*
    ;

INT_LIT
    : DIGIT+
    ;

FLOAT_LIT
    : DIGIT+ '.' DIGIT* EXPONENT?
    | DIGIT+ EXPONENT
    ;

CHAR_LIT
    : '\'' ( ESC_SEQ | ~['\\\r\n] ) '\''
    ;

STRING_LIT
    : '"' ( ESC_SEQ | ~["\\\r\n] )* '"'
    ;

WS
    : [ \t\r\n\f]+ -> skip
    ;

LINE_COMMENT
    : '//' ~[\r\n]* -> skip
    ;

COMMENT
    : '/*' .*? '*/' -> skip
    ;


fragment DIGIT     : [0-9] ;
fragment LETTER    : [a-zA-Z_] ;
fragment EXPONENT  : [eE] [+\-]? DIGIT+ ;
fragment ESC_SEQ   : '\\' ( ['"\\nrtbf] | 'u' HEX HEX HEX HEX ) ;
fragment HEX       : [0-9a-fA-F] ;
