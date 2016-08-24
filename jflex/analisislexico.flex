%%
%public
%class analisisLexico
%standalone
%unicode
%line
%column

%{

%}  
/*macros*/
num =  [0-9]
id = [a-z][a-z0-9]*
real = ([0-9]+"."[0-9]+)
bool = "bool"
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
whitespace = [ \t\n]+
comentariounalinea =  "//".*[\n]
comentariovariaslineas = "/*"(.|whitespace)*"*/"

%%
{bool}    {System.out.println("Se reconoció la palabra reservada bool: " + yytext() );}
{break}	{System.out.println("Se reconoció la palabra reservada break: " + yytext() );}
{class} {System.out.println("Se reconoció la palabra reservada class: " + yytext() );}
{continue} {System.out.println("Se reconoció la palabra reservada continue: " + yytext() );}
{else} 	{System.out.println("Se reconoció la palabra reservada else: " + yytext() );}
{false} {System.out.println("Se reconoció la palabra reservada false: " + yytext() );}
{float} {System.out.println("Se reconoció la palabra reservada float: " + yytext() );}
{for}   {System.out.println("Se reconoció la palabra reservada for: " + yytext() );}
{if}    {System.out.println("Se reconoció la palabra reservada if: " + yytext() );}
{integer} {System.out.println("Se reconoció la palabra reservada integer: " + yytext() );}
{return} {System.out.println("Se reconoció la palabra reservada return: " + yytext() );}
{true}  {System.out.println("Se reconoció la palabra reservada true: " + yytext() );}
{void} 	{System.out.println("Se reconoció la palabra reservada void: " + yytext() );}
{while} {System.out.println("Se reconoció la palabra reservada while: " + yytext() );}
{extern} {System.out.println("Se reconoció la palabra reservada extern: " + yytext() );}
{num}    {System.out.println("Se reconoció el número: " + yytext() );}
{id}	  {System.out.println("Se reconoció el id: " + yytext() );}
{real}    {System.out.println("Se reconoció el número real: " + yytext() );}
{whitespace} {System.out.println("Se reconoció un espacio en blanco: "+ yytext() );}
{comentariounalinea} {System.out.println ("Se reconoce un comentario de una linea: "+ yytext() );}
{comentariovariaslineas} {System.out.println ("Se reconoce un comentario de varias lineas: " + yytext() );}
