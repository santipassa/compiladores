import java_cup.runtime.ComplexSymbolFactory.Location
%%
%public
%class analisisLexico
%unicode
%line
%column
%class Scanner
%{
	public Scanner(java.io.InputStream r, ComplexSymbolFactory sf){
		this(r);
		this.sf=sf;
	}
	public Symbol symbol(String plaintext,int code){
	    return sf.newSymbol(plaintext,code,new Location("",yyline+1, yycolumn +1,yychar), new Location("",yyline+1,yycolumn+yylength(),yychar));
	}
	public Symbol symbol(String plaintext,int code,Integer number){
	    return sf.newSymbol(plaintext,code,new Location("",yyline+1, yycolumn +1,yychar), new Location("",yyline+1,yycolumn+yylength(),yychar),number);
	}
	private ComplexSymbolFactory sf;
%}
%eofval{
    return sf.newSymbol("EOF",sym.EOF);
%eofval}
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
"true" {return TRUE}
"false"{return FALSE}
";" {return SEMICOLON}
")" {return PAR_C;}
"(" {return PAR_A;}	
"{" {return MUSTACHE_A;}
"}" {return MUSTACHE_C;}
'"' {return COMILLA_DOBLE;}
"[" {return CORCH_A;}
"]" {return CORCH_C;}
"=" {return ASIG;}
"==" {return IGUAL;}
"+" {return SUM;}
"-" {return RES;}
"<" {return MENOR;}
">" {return MAYOR;}
"*" {return MUL;}
"/" {return DIV;}
"%" {return PORCENT;}
">=" {return MAY_IGUAL;}
"<=" {return MEN_IGUAL;}
"&&" {return AND;}
"||" {return OR;}
"!=" {return NO_IGUAL;}
"!" {return NEGAC;}
"++" {return INC;}
"--" {return DEC;}
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
{whitespace} {/* no hace nada */}
{comentariounalinea} {System.out.println ("Se reconoce un comentario de una linea: "+ yytext() );}
{comentariovariaslineas} {System.out.println ("Se reconoce un comentario de varias lineas: " + yytext() );}
