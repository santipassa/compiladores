package Example;

import java_cup.runtime.*;
import java_cup.runtime.ComplexSymbolFactory.Location;
%%
%cup
%line
%column
%char
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

/* macros */
num = [0-9]+
alpha = [a-zA-Z]
id = [a-z][a-z0-9]*
real = ([0-9]+"."[0-9]+)
whitespace = [ \t\n]+
comentariounalinea =  "//".*[\n]
comentariovariaslineas = "/*"(.|whitespace)*"*/"
%%
/* codigo asociado */
"true" {return  symbol("TRUE", sym.TRUE);}
"false" {return  symbol("FALSE",sym.FALSE);}
"_" {return  symbol("GUION_BAJO",sym.GUION_BAJO);}
";" {return  symbol("SEMICOLON",sym.SEMICOLON);}
"," {return  symbol("COLON",sym.COLON);}
"." {return  symbol("PUNTO",sym.PUNTO);}
")" {return  symbol("PAR_C",sym.PAR_C);}
"(" {return  symbol("PAR_A",sym.PAR_A);}	
"{" {return  symbol("MUSTACHE_A",sym.MUSTACHE_A);}
"}" {return  symbol("MUSTACHE_C",sym.MUSTACHE_C);}
"[" {return  symbol("CORCH_A",sym.CORCH_A);}
"]" {return  symbol("CORCH_C",sym.CORCH_C);}
"=" {return  symbol("ASIG",sym.ASIG);}
"==" {return symbol("IGUAL",sym.IGUAL);}
"+" {return  symbol("SUM",sym.SUM);}
"-" {return  symbol("RES",sym.RES);}
"+=" {return symbol ("SUMASIG",sym.SUMASIG);}
"-=" {return symbol ("RESASIG",sym.RESASIG);}
"<" {return  symbol("MENOR",sym.MENOR);}
">" {return  symbol("MAYOR",sym.MAYOR);}
"*" {return  symbol("MUL",sym.MUL);}
"/" {return  symbol("DIV",sym.DIV);}
"%" {return  symbol("PORCENT",sym.PORCENT);}
">=" {return symbol("MAY_IGUAL",sym.MAY_IGUAL);}
"<=" {return symbol("MEN_IGUAL",sym.MEN_IGUAL);}
"&&" {return symbol("AND",sym.AND);}
"||" {return symbol("OR",sym.OR);}
"!=" {return symbol("NO_IGUAL",sym.NO_IGUAL);}
"!" {return  symbol("NEGAC",sym.NEGAC);}
"++" {return symbol("INC",sym.INC);}
"--" {return symbol("DEC",sym.DEC);}
"bool" {return symbol("BOOL",sym.BOOL);}
"break"	{return symbol("BREAK",sym.BREAK);}
"class" {return  symbol("CLASS",sym.CLASS);}
"continue" {return symbol("CONTINUE",sym.CONTINUE);}
"else" 	{return  symbol("ELSE",sym.ELSE);}
"float" {return  symbol("FLOAT",sym.FLOAT);}
"for"   {return  symbol("FOR",sym.FOR);}
"if"    {return  symbol("IF",sym.IF);}
"integer" {return symbol("INTEGER",sym.INTEGER);}
"return" {return  symbol("RETURN",sym.RETURN);}
"void"	{return symbol("VOID",sym.VOID);}
"while" {return symbol("WHILE",sym.WHILE);}
"extern" {return symbol("EXTERN",sym.EXTERN);}
"_" {return symbol("EXTERN",sym.EXTERN);}
{num} {return symbol("NUM",sym.NUM,new Integer(yytext()));}
{id} {return  symbol("ID",sym.ID);}
{real} {return symbol("REAL",sym.REAL);}
{alpha} {return symbol("ALPHA",sym.ALPHA);}
{whitespace} {/* no hace nada */}
{comentariounalinea} {/* no hace nada */}
{comentariovariaslineas} {/* no hace nada */}
. { System.err.println("Illegal character: "+yytext()); }
