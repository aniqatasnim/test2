import java.io.*;
import java.io.File;

public class syntaxanalyzer extends lexicalanalyzer {
  
  // public static int getNextToken(){
  //     if self.current < len(self.tokens):
  //           self.current += 1
  //   }

// <stmt> --> <if_stmt> | <while_stmt> | <as_s> | <block> 
    public static void statement() {
        switch (followingToken) {
	case ifstmt: 
		ifstmt();
		break;
	case whileloop: 
		whileloop();
		break;
	case loop:
		loop();
		break;
	case boolexpr:
		boolexpr();
		break;
	case assigning:
		assigning();
		break;
	case block:
		block();
		break;
	default :
		error();
		break;
      	}
    }
// <if_stmt> -->  `if``(`<bool_expr>`)` <stmt> [ `else` <stmt> ]
 public static void ifstmt(){
    if(followingToken == IF_CODE){
      lex();
      
      if(followingToken == LEFT_PAREN){
        lex();
        boolexpr();
          
          if(followingToken == RIGHT_PAREN){
            lex();
            statement();
            (if followingToken != FINISHER){
                error();
            }
          }
          else{
            error();
          }
      } 
      else {
        error();
      }
      
  }
    else {
      error();
    }
  }
  
// <while_loop> -->  `while``(`<bool_expr>`)` <stmt> 
   public static void whileloop(){
    if(followingToken == WHILE){
      lex();
      
      if(followingToken == LEFT_PAREN){
        lex();
        boolexpr();
          
          if(followingToken == RIGHT_PAREN){
            lex();
            statement();
          }
          else{
            error();
          }
      } 
      else {
        error();
      }
      
    }
      else {
        error();
      }
  }
// <as_s>  --> `id` `=` <expr>
  public static void assigning() {
          if (followingToken == TYPE_INT) {
              lex();
            if(followingToken == IDENT){
              lex();
              if(followingToken == ASSIGN_OP){
                lex();
                expression();
                (if followingToken != FINISHER){
                    error();
              }
              else{
                error();
              }
            }
            else{
              error();
            }
          }
        else{
          error();
        }
 }
  
// <expr> --> <term> { (`+`|`-`) <term> }
  public static void expression(){
    term();
    if(followingToken == ADD_OP || followingToken == SUB_OP){
      lex();
      term();
      (if followingToken != FINISHER){
        error();
    }
  }

// <term> --> <factor> { (`*`|`\`|`%`) <factor> }
  public static void term(){
    factor();
    if(followingToken == MULT_OP || followingToken == DIV_OP || followingToken == MOD_OP){
      lex();
      factor();
    }
    
  }

// <factor> --> `id` | `int_lit` | `float_lit` | `(` <expr> `)`
public static void factor(){
  if(followingToken == IDENT || followingToken == INT_LIT || followingToken == TYPE_FLOAT){
    lex();
    expression();
  }
}
  
// <bool_expr> --> <band> { `OR` <band> }
  public static void boolexpr(){
    band();
    if(followingToken == OR_OP){
      lex();
      band();
    }
  }
  
// <band> --> <beq> { `AND` <beq> }
  public static void band(){
    beq();
    if(followingToken == AND_OP){
      lex();
      beq(); 
      
    }
  }
  
// <beq> --> <brel> { (`!=`|`==`) <brel> }
  public static void beq(){
    brel();
    if(followingToken == NOT_EQUAL_TO || followingToken == EQUAL_TO){
      lex();
      brel();
    }
  }
  
// <brel> --> <expr> { (`<=`|`>=` | `<` | `>`) <expr> }
  public static void brel(){
    expression();
    if(followingToken == LESS_THAN_EQUAL || followingToken == GREATER_THAN_EQUAL || followingToken == LESS_THAN || followingToken == GREATER_THAN){
      lex();
      expression();
    }
  }
  
// <term> --> <not> { (`*`|`\`|`%`) <bnot> }
public static void bterm(){
    bfactor();
    if(followingToken == MULT_OP || followingToken == DIV_OP || followingToken == MOD_OP){
      lex();
    bfactor();
    }
}
  
// bfactor
  public static void bfactor(){
      if (followingToken == IDENT|| followingToken == INT_LIT) {
        lex();
    } else {
        if (followingToken == LEFT_PAREN) {
            lex();
            boolexpr();
            if (followingToken == RIGHT_PAREN)
                lex();
            else
                error();
        } else {
            error();
        }
    }
  }
  
// <block> --> `{` { <stmt>`;` } `}`
public static void block(){
  if(followingToken == LEFT_BRACKET){
    lex();
    while(followingToken == IF_CODE || followingToken == IF_CODE || followingToken == WHILE || followingToken == IDENT  || followingToken == LEFT_BRACKET){
      statement();
      if(followingToken ==  SEMI){
        lex();
      }
      else{
        error();
      }
      
    }
    if(followingToken == RIGHT_BRACKET){
      lex();
    }
    else{
      error();
    }
  }
  else{
    error();
  }
}

// forloop
   public static void loop() {
	  	if (followingToken == LOOP) {
  			lex();
    		if (followingToken == LEFT_PAREN ){
          lex();
              if(followingToken == INT_TYPE){
                lex();
                if(followingToken == IDENT){
                if(followingToken == RIGHT_PAREN){
                  lex();
                  statement();
                }
                }
              }
            }
  		}
  	
    }
  
  public static void error(){
    System.out.println("SYNTAX ERROR HAS BEEN FOUND");
  }
}
