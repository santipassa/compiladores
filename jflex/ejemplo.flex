%%
%class Classify
%standalone
Digit =  [0-9]
Letter = [a-zA-Z]
Whitespace = [ \t\n]+
%%
{Whitespace}   {/* Do nothing! */}
{Digit}+       {System.out.printf("number [%s]\n", yytext());}
{Letter}({Letter}|{Digit})*
{System.out.printf("word [%s]\n", yytext());}
.              {System.out.printf("symbol [%s]\n", yytext());}
