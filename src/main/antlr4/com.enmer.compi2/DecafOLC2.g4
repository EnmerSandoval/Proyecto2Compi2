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
     | 'break' ';'
     | 'continue' ';'
     | 'return' expr? ';'
     | expr ';'
     | ';'
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
     | 'new' tipoBase '[' expr ']'
     | IDENT
     | '(' expr ')'
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

 INT_LIT     : [0-9]+ ;
 FLOAT_LIT   : [0-9]+ '.' [0-9]* ;
 CHAR_LIT    : '\'' ( ~['\\] | '\\' . ) '\'' ;
 STRING_LIT  : '"' ( ~["\\] | '\\' . )* '"' ;

 IDENT
     : [a-zA-Z_] [a-zA-Z_0-9]*
     ;

 WS          : [ \t\r\n]+ -> skip ;
 LINE_COMMENT: '//' ~[\r\n]* -> skip ;
 COMMENT     : '/*' .*? '*/' -> skip ;

 PLUS    : '+' ;
 MINUS   : '-' ;
 STAR    : '*' ;
 DIV     : '/' ;
 MOD     : '%' ;
