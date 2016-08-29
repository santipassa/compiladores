import java_cup.runtime.Symbol;
%%
%public
%class analisisLexico
%unicode
%line
%column
%class Scanner
%{

	private ComplexSymbolFactory sf;

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
whitespace = [ \t\n]+
comentariounalinea =  "//".*[\n]
comentariovariaslineas = "/*"(.|whitespace)*"*/"
%%
"true" {return  new symbol("TRUE", sym.TRUE);}
"false" {return new symbol("FALSE",sym.FALSE);}
";" {return new symbol("SEMICOLON",sym.SEMICOLON);}
")" {return new symbol("PAR_C",sym.PAR_C);}
"(" {return new symbol("PAR_A",sym.PAR_A);}	
"{" {return new symbol("MUSTACHE_A",sym.MUSTACHE_A);}
"}" {return new symbol("MUSTACHE_C",sym.MUSTACHE_C);}
"[" {return new symbol("CORCH_A",sym.CORCH_A);}
"]" {return new symbol("CORCH_C",sym.CORCH_C);}
"=" {return new symbol("ASIG",sym.ASIG);}
"==" {return new symbol("IGUAL",sym.IGUAL);}
"+" {return new symbol("SUM",sym.SUM);}
"-" {return new symbol("RES",sym.RES;}
"<" {return new symbol("MENOR",sym.MENOR);}
">" {return new symbol("MAYOR",sym.MAYOR);}
"*" {return new symbol("MUL",sym.MUL);}
"/" {return new symbol("DIV",sym.DIV);}
"%" {return new symbol("PORCENT",sym.PORCENT);}
">=" {return new symbol("MAY_IGUAL",sym.MAY_IGUAL);}
"<=" {return new symbol("MEN_IGUAL",sym.MEN_IGUAL);}
"&&" {return new symbol("AND",sym.AND);}
"||" {return new symbol("OR",sym.OR);}
"!=" {return new symbol("NO_IGUAL",sym.NO_IGUAL);}
"!" {return new symbol("NEGAC",sym.NEGAC);}
"++" {return new symbol("INC",sym.INC);}
"--" {return new symbol("DEC",sym.DEC);}
"bool"    {return new symbol("BOOL",sym.BOOL);}
"break"	{return new symbol("BREAK",sym.BREAK);}
"class" {return new symbol("CLASS",sym.CLASS);}
"continue" {return new symbol("CONTINUE",sym.CONTINUE);}
"else" 	{return new symbol("ELSE",sym.ELSE);}
"float" {return new symbol("FLOAT",sym.FLOAT);}
"for"   {return new symbol("FOR",sym.FOR);}
"if"    {return new symbol("IF",sym.IF);}
"integer" {return new symbol("INTEGER",sym.INTEGER);}
"return" {return new symbol("RETURN",sym.RETURN);}
"void"	{return new symbol("VOID",sym.VOID);}
"while" {return new symbol("WHILE",sym.WHILE);}
"extern" {return new symbol("EXTERN",sym.EXTERN);}
{num}    {return new symbol("NUM",sym.NUM,new Integer(yytext()));}
{id}	  {return new symbol("ID",sym.ID);}
{real}    {return new symbol("REAL",sym.REAL);}
{whitespace} {/* no hace nada */}
{comentariounalinea} { }
{comentariovariaslineas} { }
. { System.err.println("Illegal character: "+yytext()); }
