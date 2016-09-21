/* The following code was generated by JFlex 1.4.3 on 21/09/16 15:49 */

package Compi;

import java_cup.runtime.*;
import java_cup.runtime.ComplexSymbolFactory.Location;

/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 21/09/16 15:49 from the specification file
 * <tt>jflex/Scanner.jflex</tt>
 */
class Scanner implements java_cup.runtime.Scanner {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\5\1\7\25\0\1\5\1\41\3\0\1\36\1\37\1\0"+
    "\1\24\1\23\1\10\1\32\1\22\1\33\1\4\1\6\12\1\1\0"+
    "\1\21\1\34\1\31\1\35\2\0\32\0\1\27\1\0\1\30\1\0"+
    "\1\3\1\0\1\16\1\42\1\45\1\52\1\14\1\15\1\50\1\54"+
    "\1\47\1\2\1\44\1\17\1\2\1\46\1\43\2\2\1\12\1\20"+
    "\1\11\1\13\1\51\1\53\1\55\2\2\1\25\1\40\1\26\uff82\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7"+
    "\4\3\1\10\1\11\1\12\1\13\1\14\1\15\1\16"+
    "\1\17\1\20\1\21\1\22\1\23\1\24\1\25\2\1"+
    "\1\26\5\3\3\0\7\3\1\27\1\30\1\31\1\32"+
    "\1\33\1\34\1\35\1\36\4\3\1\37\3\3\1\40"+
    "\1\5\1\0\6\3\1\41\7\3\1\42\1\3\1\43"+
    "\4\3\1\44\3\3\1\45\3\3\1\46\1\47\1\50"+
    "\1\51\2\3\1\52\1\53\1\54\3\3\1\55\1\56";

  private static int [] zzUnpackAction() {
    int [] result = new int[106];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\56\0\134\0\212\0\56\0\270\0\346\0\56"+
    "\0\u0114\0\u0142\0\u0170\0\u019e\0\56\0\56\0\56\0\56"+
    "\0\56\0\56\0\56\0\56\0\u01cc\0\u01fa\0\u0228\0\u0256"+
    "\0\u0284\0\56\0\u02b2\0\u02e0\0\u030e\0\u033c\0\u036a\0\u0398"+
    "\0\u03c6\0\u03f4\0\u0422\0\u0450\0\u047e\0\u04ac\0\u04da\0\u0508"+
    "\0\u0536\0\u0564\0\u0592\0\u05c0\0\56\0\56\0\56\0\56"+
    "\0\56\0\56\0\56\0\56\0\u05ee\0\u061c\0\u064a\0\u0678"+
    "\0\212\0\u06a6\0\u06d4\0\u0702\0\u0422\0\56\0\u0730\0\u075e"+
    "\0\u078c\0\u07ba\0\u07e8\0\u0816\0\u0844\0\212\0\u0872\0\u08a0"+
    "\0\u08ce\0\u08fc\0\u092a\0\u0958\0\u0986\0\212\0\u09b4\0\212"+
    "\0\u09e2\0\u0a10\0\u0a3e\0\u0a6c\0\212\0\u0a9a\0\u0ac8\0\u0af6"+
    "\0\212\0\u0b24\0\u0b52\0\u0b80\0\212\0\212\0\212\0\212"+
    "\0\u0bae\0\u0bdc\0\212\0\212\0\212\0\u0c0a\0\u0c38\0\u0c66"+
    "\0\212\0\212";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[106];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\4\1\2\1\5\1\6\1\7\1\6"+
    "\1\10\1\11\1\12\1\4\1\13\1\14\3\4\1\15"+
    "\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25"+
    "\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\35"+
    "\1\36\2\4\1\37\1\4\1\40\1\4\1\41\1\4"+
    "\1\42\2\4\57\0\1\3\2\0\1\43\52\0\3\4"+
    "\5\0\10\4\21\0\14\4\5\0\1\6\1\0\1\6"+
    "\54\0\1\44\1\0\1\45\46\0\3\4\5\0\1\4"+
    "\1\46\6\4\21\0\14\4\1\0\3\4\5\0\3\4"+
    "\1\47\4\4\21\0\14\4\1\0\3\4\5\0\6\4"+
    "\1\50\1\4\21\0\13\4\1\51\1\0\3\4\5\0"+
    "\5\4\1\52\1\53\1\4\21\0\1\4\1\54\12\4"+
    "\31\0\1\55\55\0\1\56\55\0\1\57\55\0\1\60"+
    "\55\0\1\61\63\0\1\62\56\0\1\63\46\0\1\64"+
    "\25\0\3\4\5\0\1\4\1\65\6\4\21\0\1\4"+
    "\1\66\12\4\1\0\3\4\5\0\6\4\1\67\1\4"+
    "\21\0\1\4\1\70\12\4\1\0\3\4\5\0\4\4"+
    "\1\71\3\4\21\0\4\4\1\72\7\4\1\0\3\4"+
    "\5\0\10\4\21\0\1\4\1\73\12\4\1\0\3\4"+
    "\5\0\10\4\21\0\12\4\1\74\1\4\1\0\1\75"+
    "\54\0\7\44\1\76\46\44\10\45\1\77\45\45\1\0"+
    "\3\4\5\0\2\4\1\100\5\4\21\0\14\4\1\0"+
    "\3\4\5\0\1\101\7\4\21\0\14\4\1\0\3\4"+
    "\5\0\7\4\1\102\21\0\14\4\1\0\3\4\5\0"+
    "\1\103\7\4\21\0\14\4\1\0\3\4\5\0\6\4"+
    "\1\104\1\4\21\0\14\4\1\0\3\4\5\0\10\4"+
    "\21\0\1\4\1\105\12\4\1\0\3\4\5\0\1\4"+
    "\1\106\6\4\21\0\14\4\1\0\3\4\5\0\3\4"+
    "\1\107\4\4\21\0\14\4\1\0\3\4\5\0\10\4"+
    "\21\0\1\4\1\110\12\4\1\0\3\4\5\0\5\4"+
    "\1\111\2\4\21\0\14\4\1\0\3\4\5\0\10\4"+
    "\21\0\4\4\1\112\7\4\1\0\3\4\5\0\1\113"+
    "\7\4\21\0\14\4\1\0\3\4\5\0\10\4\21\0"+
    "\5\4\1\114\6\4\1\0\3\4\5\0\10\4\21\0"+
    "\5\4\1\115\6\4\6\45\1\76\1\45\1\77\45\45"+
    "\1\0\3\4\5\0\3\4\1\116\4\4\21\0\14\4"+
    "\1\0\3\4\5\0\2\4\1\117\5\4\21\0\14\4"+
    "\1\0\3\4\5\0\3\4\1\120\4\4\21\0\14\4"+
    "\1\0\3\4\5\0\3\4\1\121\4\4\21\0\14\4"+
    "\1\0\3\4\5\0\7\4\1\122\21\0\14\4\1\0"+
    "\3\4\5\0\5\4\1\123\2\4\21\0\14\4\1\0"+
    "\3\4\5\0\5\4\1\124\2\4\21\0\14\4\1\0"+
    "\3\4\5\0\6\4\1\125\1\4\21\0\14\4\1\0"+
    "\3\4\5\0\7\4\1\126\21\0\14\4\1\0\3\4"+
    "\5\0\1\127\7\4\21\0\14\4\1\0\3\4\5\0"+
    "\3\4\1\130\4\4\21\0\14\4\1\0\3\4\5\0"+
    "\10\4\21\0\10\4\1\131\3\4\1\0\3\4\5\0"+
    "\6\4\1\132\1\4\21\0\14\4\1\0\3\4\5\0"+
    "\1\4\1\133\6\4\21\0\14\4\1\0\3\4\5\0"+
    "\1\4\1\134\6\4\21\0\14\4\1\0\3\4\5\0"+
    "\3\4\1\135\4\4\21\0\14\4\1\0\3\4\5\0"+
    "\1\136\7\4\21\0\14\4\1\0\3\4\5\0\10\4"+
    "\21\0\2\4\1\137\11\4\1\0\3\4\5\0\7\4"+
    "\1\140\21\0\14\4\1\0\3\4\5\0\10\4\21\0"+
    "\5\4\1\141\6\4\1\0\3\4\5\0\10\4\21\0"+
    "\6\4\1\142\5\4\1\0\3\4\5\0\3\4\1\143"+
    "\4\4\21\0\14\4\1\0\3\4\5\0\10\4\21\0"+
    "\4\4\1\144\7\4\1\0\3\4\5\0\10\4\21\0"+
    "\4\4\1\145\7\4\1\0\3\4\5\0\10\4\21\0"+
    "\4\4\1\146\7\4\1\0\3\4\5\0\3\4\1\147"+
    "\4\4\21\0\14\4\1\0\3\4\5\0\2\4\1\150"+
    "\5\4\21\0\14\4\1\0\3\4\5\0\1\4\1\151"+
    "\6\4\21\0\14\4\1\0\3\4\5\0\3\4\1\152"+
    "\4\4\21\0\14\4";

  private static int [] zzUnpackTrans() {
    int [] result = new int[3220];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\2\1\1\11\2\1\1\11\4\1\10\11"+
    "\5\1\1\11\10\1\3\0\7\1\10\11\11\1\1\11"+
    "\1\0\53\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[106];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
	public Scanner(java.io.InputStream r, ComplexSymbolFactory sf){
		this(r);
		this.sf=sf;
	}
	public Symbol symbol(String plaintext,int code){
	    return sf.newSymbol(plaintext,code,new Location("",yyline+1, yycolumn +1,yychar), new Location("",yyline+1,yycolumn+yylength(),yychar));
	}
	public Symbol symbol(String plaintext,int code,String number){
	    return sf.newSymbol(plaintext,code,new Location("",yyline+1, yycolumn +1,yychar), new Location("",yyline+1,yycolumn+yylength(),yychar),number);
	}
	public Symbol symbol(String plaintext,int code,Integer number){
	    return sf.newSymbol(plaintext,code,new Location("",yyline+1, yycolumn +1,yychar), new Location("",yyline+1,yycolumn+yylength(),yychar),number);
	}
	public Symbol symbol(String plaintext,int code,float number){
	    return sf.newSymbol(plaintext,code,new Location("",yyline+1, yycolumn +1,yychar), new Location("",yyline+1,yycolumn+yylength(),yychar),number);
	}
	private ComplexSymbolFactory sf;


  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  Scanner(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  Scanner(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 120) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead > 0) {
      zzEndRead+= numRead;
      return false;
    }
    // unlikely but not impossible: read 0 characters, but not at end of stream    
    if (numRead == 0) {
      int c = zzReader.read();
      if (c == -1) {
        return true;
      } else {
        zzBuffer[zzEndRead++] = (char) c;
        return false;
      }     
    }

	// numRead < 0
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      yychar+= zzMarkedPosL-zzStartRead;

      boolean zzR = false;
      for (zzCurrentPosL = zzStartRead; zzCurrentPosL < zzMarkedPosL;
                                                             zzCurrentPosL++) {
        switch (zzBufferL[zzCurrentPosL]) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn++;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 44: 
          { return symbol("EXTERN",sym.EXTERN);
          }
        case 47: break;
        case 13: 
          { return  symbol("MUSTACHE_C",sym.MUSTACHE_C);
          }
        case 48: break;
        case 3: 
          { return  symbol("ID",sym.ID, yytext());
          }
        case 49: break;
        case 31: 
          { return  symbol("IF",sym.IF);
          }
        case 50: break;
        case 12: 
          { return  symbol("MUSTACHE_A",sym.MUSTACHE_A);
          }
        case 51: break;
        case 21: 
          { return  symbol("PORCENT",sym.PORCENT);
          }
        case 52: break;
        case 26: 
          { return symbol("MEN_IGUAL",sym.MEN_IGUAL);
          }
        case 53: break;
        case 7: 
          { return  symbol("MUL",sym.MUL);
          }
        case 54: break;
        case 11: 
          { return  symbol("PAR_A",sym.PAR_A);
          }
        case 55: break;
        case 9: 
          { return  symbol("COLON",sym.COLON);
          }
        case 56: break;
        case 30: 
          { return symbol("NO_IGUAL",sym.NO_IGUAL);
          }
        case 57: break;
        case 43: 
          { return  symbol("RETURN",sym.RETURN);
          }
        case 58: break;
        case 35: 
          { return  symbol("ELSE",sym.ELSE);
          }
        case 59: break;
        case 15: 
          { return  symbol("CORCH_C",sym.CORCH_C);
          }
        case 60: break;
        case 40: 
          { return symbol("BREAK",sym.BREAK);
          }
        case 61: break;
        case 17: 
          { return  symbol("SUM",sym.SUM);
          }
        case 62: break;
        case 29: 
          { return symbol("OR",sym.OR);
          }
        case 63: break;
        case 10: 
          { return  symbol("PAR_C",sym.PAR_C);
          }
        case 64: break;
        case 19: 
          { return  symbol("MENOR",sym.MENOR);
          }
        case 65: break;
        case 25: 
          { return symbol ("RESASIG",sym.RESASIG);
          }
        case 66: break;
        case 34: 
          { return  symbol("TRUE", sym.TRUE);
          }
        case 67: break;
        case 22: 
          { return  symbol("NEGAC",sym.NEGAC);
          }
        case 68: break;
        case 16: 
          { return  symbol("ASIG",sym.ASIG);
          }
        case 69: break;
        case 5: 
          { /* no hace nada */
          }
        case 70: break;
        case 36: 
          { return symbol("BOOL",sym.BOOL);
          }
        case 71: break;
        case 37: 
          { return symbol("VOID",sym.VOID);
          }
        case 72: break;
        case 18: 
          { return  symbol("RES",sym.RES);
          }
        case 73: break;
        case 14: 
          { return  symbol("CORCH_A",sym.CORCH_A);
          }
        case 74: break;
        case 28: 
          { return symbol("AND",sym.AND);
          }
        case 75: break;
        case 23: 
          { return symbol("IGUAL",sym.IGUAL);
          }
        case 76: break;
        case 24: 
          { return symbol ("SUMASIG",sym.SUMASIG);
          }
        case 77: break;
        case 20: 
          { return  symbol("MAYOR",sym.MAYOR);
          }
        case 78: break;
        case 45: 
          { return symbol("INTEGER",sym.INTEGER);
          }
        case 79: break;
        case 27: 
          { return symbol("MAY_IGUAL",sym.MAY_IGUAL);
          }
        case 80: break;
        case 42: 
          { return symbol("WHILE",sym.WHILE);
          }
        case 81: break;
        case 38: 
          { return  symbol("FALSE",sym.FALSE);
          }
        case 82: break;
        case 33: 
          { return  symbol("FOR",sym.FOR);
          }
        case 83: break;
        case 4: 
          { return  symbol("PUNTO",sym.PUNTO);
          }
        case 84: break;
        case 8: 
          { return  symbol("SEMICOLON",sym.SEMICOLON);
          }
        case 85: break;
        case 1: 
          { System.err.println("Illegal character: "+yytext());
          }
        case 86: break;
        case 41: 
          { return  symbol("CLASS",sym.CLASS);
          }
        case 87: break;
        case 46: 
          { return symbol("CONTINUE",sym.CONTINUE);
          }
        case 88: break;
        case 6: 
          { return  symbol("DIV",sym.DIV);
          }
        case 89: break;
        case 32: 
          { return symbol("REAL",sym.REAL, new Float(yytext()));
          }
        case 90: break;
        case 39: 
          { return  symbol("FLOAT",sym.FLOAT);
          }
        case 91: break;
        case 2: 
          { return symbol("NUM",sym.NUM, new Integer(yytext()));
          }
        case 92: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            zzDoEOF();
              {     return sf.newSymbol("EOF",sym.EOF);
 }
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
