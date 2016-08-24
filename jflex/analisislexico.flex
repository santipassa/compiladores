%public
%class Lexer
%standalone
%unicode
%line
%column

%{

%}  
/*macros*/
num =  [0-9]
num =  [0-9]
letra = [a-zA-Z]
palabra = [a-zA-Z][a-z]+
id = [a-z][a-z0-9]*
real = ([0-9]+"."[0-9]*)|([0-9]*"."[0-9]+)
bool = bool
break = break
class = class
continue = continue
else = else
false = false
float = float
for = for
if = if
integer = integer
return = return
true = true
void = void
while = while
extern = extern
Whitespace = [ \t\n]+

%%
/*patrones a reconocer y accion asociada*/
{num}    {System.out.println("Se reconoció el número: "+ + yytext() );}
. {}





