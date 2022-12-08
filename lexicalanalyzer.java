import java.io.*;
import java.io.File;

  public class lexicalanalyzer {

    /* Variables */
    static int charType;
    static char lexeme[] = new char[100];
    static char followingChar;
    static int lexLen;
    static int token;
    static int followingToken;
    static File in_fp;
    static int info;
    static Reader reader;
  
    /* Character classes */
    static int LET = 0; // letter 
    static int DIG = 1; // digit 
    static int NEWLINE = 7; // newline
    static int OPENCLOSE = 44; // open or close brackets/parentheses
    static int OPS = 45;  // operators 
    static int SYM = 46; //symbols
    static int START = 8;  // start of code
    static int END = 9; // end of the code
    static int UNKNOWN = 99; // tokens that are unknown 
  
    /* Token codes */
    static int INT_LIT = 10; // int literal
    static int IDENT = 11; // identifier 
    static int TYPE_STRING = 42; // string type
    static int TYPE_CHAR = 44;  // char type 
    static int TYPE_INT = 45; // int type
    static int TYPE_FLOAT = 46; // float type
  
    // operators
    static int ADD_OP = 16; // add operation
    static int SUB_OP = 17;  // subtraction operation
    static int MULT_OP = 18; // multiply operation
    static int DIV_OP = 19;  // divide operation 
    static int MOD_OP = 20; // modulus operation
    static int ASSIGN_OP = 21; // assigning operation
    static int AND_OP = 40; // and operation 
    static int OR_OP = 41;   // or operation
  
    // comparing
    static int LESS_THAN = 22;  // <
    static int GREATER_THAN = 23;  // >
    static int LESS_THAN_EQUAL = 24; // <=
    static int GREATER_THAN_EQUAL = 25;  // >=
    static int EQUAL_TO = 30;  // =
    static int NOT_EQUAL = 31; // !=
  
    // symbols
    static int LEFT_PAREN = 26; // (
    static int RIGHT_PAREN = 27;  // )
    static int LEFT_BRACKET = 28; // [
    static int RIGHT_BRACKET = 29;  // ]
    static int SEMI = 32;  // ;
    static int COMMA = 33;  // ,
    static int DOT = 34;  // .
    static int AMP = 35;  // &
    static int DOL = 36;  // $
    static int FINISHER = 89 // #  used at the end of a statement 
  
    static int IF_CODE = 37; // if statments
    static int LOOP = 38; // for loops
    static int WHILE = 39; // while loops 
  
    static String keywords[] = new String[] { "phor", "during", "match", "aswell, condition" }; // for, while, switch, and, condition
  
// lookup - a function to look up operators, symbols, and parentheses and return the token
int lookup(char ch) {
  switch (ch) {
  case '(':
    addChar();
    followingToken = LEFT_PAREN;
    break;
  case ')':
    addChar();
    followingToken = RIGHT_PAREN;
    break;
  case '[':
    addChar();
    followingToken = LEFT_BRACKET;
    break;
  case ']':
    addChar();
    followingToken = RIGHT_BRACKET;
    break;
  case '+':
    addChar();
    followingToken = ADD_OP;
    break;
  case '-':
    addChar();
    followingToken = SUB_OP;
    break;
  case '*':
    addChar();
    followingToken = MULT_OP;
    break;
  case '/':
    addChar();
    followingToken = DIV_OP;
    break;
  case '=':
    addChar();
    getChar();
    if (followingChar == "="){
      addChar();
      followingToken = EQUALS_TO;  
    } else if (followingChar == " "){
      addChar();
      followingToken = ASSIGN_OP;
    }
    break;
  case '%':
    addChar();
    followingToken = MOD_OP;
    break;
  case ';':
    addChar();
    followingToken = SEMI;
    break;
  case ',':
    addChar();
    followingToken = COMMA;
    break;
  case '.':
    addChar();
    followingToken = DOT;
    break;
  case '<':
    addChar();
    getChar();
    if (followingChar == '=') {
      addChar();
      followingToken = LESS_EQUAL_TO;
    }
    else if (followingChar == " "){
      addChar();
      followingToken = LESS_THAN;
    }
    break;
  case '>':
    addChar();
    getChar();
    if (followingChar == '=') {
      addChar();
      followingToken = GREATER_EQUAL_TO;
    }
    else if (followingChar == " "){
      addChar();
      followingToken = GREATER_THAN;
    }
    break;

  case '#':
    addChar();
    getChar();
    if(followingChar == " "){
      addChar();
      followingToken = "FINISHER"; // used at the end of statement 
    } else if (followingChar == "START"){  //start of program
      followingToken = START;
    } else if (followingChar == "END"){ // end of program
      addChar();
      followingToken = END;
    }
    break;  
  case '!':
    addChar();
    getChar();
    if (followingChar == '=') {
        addChar();
        followingToken = NOT_EQUAL_TO;
    }
    break;
  case '@':
    addChar();
    followingToken = AMP;
    break;
  case '$':
    addChar();
    followingToken = DOL;
    break;
  //  if token/lexeme does not match any of  the cases, it is set as UNKNOWN
  default:
    addChar();
    followingToken = UNKOWN;
    break;
  }
  return followingToken;
}

// lex function 
public static int lex(){
  lexLen = 0;
  getNonBlank();

    switch (charType) {
    case LET:
      addChar();
      getChar();
      while (charType == LET || chaype == DIG || followingChar ==  "_" ) {
       addChar();
       getChar();
      }

      if (String.equals (lexeme, "&&")) {
        followingToken = AND_OP;
      }      
      else if (String.equals (lexeme, "~")) {
        followingToken = OR_OP;
      }  
      else if (String.equals (lexeme, "SS")) {
        followingToken = TYPE_STRING;
      } 
      else if (String.equals(lexeme, "CC")) {
        followingToken = TYPE_CHAR;
      } 
      else if (String.equals (lexeme, "II")) {
        followingToken = TYPE_INT;
      }
       else if (String.equals (lexeme, "FF")) {
        followingToken = TYPE_FLOAT;
      } 
      else {
        followingToken =  IDENT;
      }
      break;
        
    case DIG:
      addChar(); 
      getChar();
      while (followingChar == DIG){
        addChar();
        getChar();
      }
      followingToken= INT_LIT;
   
    case STRING:
      addChar();
      getChar();
      while (charType != STRING) {
        addChar();
        getChar();
      }
      addChar();
      getChar();
      followingToken = TYPE_STRING;
      break;
  
    case CHAR:
      addChar();
      getChar();
      while (charType != CHAR) {
        addChar();
        getChar();
      }
      addChar();
      getChar();
      followingToken = TYPE_CHAR;
      if (lexLen > 1) {
        System.out.println("Character is too long");
      }
      break;
  
    case SEMI:
      followingToken = SEMI;
      addChar();
      getChar();
      break;
  
    case NEWLINE:
      followingToken = NEWLINE;
      addChar();
      getChar();
      break;
          
    case UNKOWNN:
      lookup(followingChar);
      getChar();
      break;
    
    case EOF:
      followingToken = EOF;
      lexeme[0] = 'E';
      lexeme[1] = 'O';
      lexeme[2] = 'F';
      lexeme[3] =  '\0';
      break;
    }
    str = new String(lexeme);
    System.out.println("Next token: " + followingToken);
    System.out.println("Next lexeme: " + str);
    return followingToken;
}

//addchar
public static void addChar() {
  if (lexLen <= 98) {
    lexeme[lexLen++] = followingChar;
    lexeme[lexLen] = '\0';
  } else {
    printf("LEXEME IS TO LONG \n");
  }
}
// getnonblank
void getNonBlank() {
  while (Character.isSpaceChar(followingChar)) {
    getChar();
  }
}

// getchar
public static void getChar() {
  info = reader.read(); 
  info = (char) info;

  if(info == 1){
    followingChar = info;
    if (Character.isDigit(followingChar)) {
      charType = DIG;
    } 
    else if (Character.isLetter(followingChar)) {
      charType = LET;
    
   } 
  else if (followingChar  == '(' || followingChar  == ')' || followingChar  == '['  || followingChar  == ']'){
    charType = OPENCLOSE;
  } 
  else if  (followingChar  == '@' || followingChar  == '$' || followingChar  == '&'){
    charType = SYM;
  } 
  else if  (followingChar  == '-' || followingChar  == '+' || followingChar  == '/' || followingChar  == '%' || followingChar  == '*'  || followingChar  == '='){
    charType = OPS;
  }
   else {
    charType = UNKNOWN;
  }

  }
  else {
    charType = EOF;
  }
}
}
