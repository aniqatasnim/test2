 Used the lazyLex replit code and extrastuff.ipynb and coded it in Java. 


* A: We are defining the rules for recognizing lexemes and having these lexemes/token being identified in a special way. In lexicalanalyzer.java, there is a class called lexicalanalyzer and inside there, there are static variables, character classes, token codes, operators, comparing vars, and regular symbols all being either an int or char type. These lexeme/tokens range from letters (a-zA-Z), digits(0-9),  regular symbols ($,&,@) arithetic symbols (-,+,=,*,), opening and closing brackets/parentheses([],{}), etc.

* B: We are defining production rules for the language and syntax of operators, operands,loops, variable declaration, selection statments, etc. One production rule for the language could be starting the program with #START and ending it with #END. The syntax of the production of the language can be found in syntaxanalyzer.java where we have a function for different types of operands, such as functions called statement, ifstmt, whileloop, assigning, expression, term, boolexpr, etc. Since we cannot use keywords: while, for,do, if int, etc...  I replaced them with synonyms of those keyword ({ "phor", "during", "match", "aswell, condition" }.... phor being for). 

* C: show whether every rule set in your language conforms to the standard of an LL Grammar. Is this a grammar that can be solved top down or bottom up. Answering two Qs: if it has left hand recursion and if its pairwise disjoint. 
- tell if its PD and if it has LHR --> if it is, it doesnt comform to

* D: Make sure it is not ambigious Grammar -->. making sure there is not two way to make a sentence. 

* E: should be OOP, and comments in the code 

* F: take in the list of token, 

* G: Creating test case files 

* H:  create and LR Parse Table 



b. (15 Points) Define production rules for implementing the mathematical syntax of operators and operands, loops, variable declaration, selection statements
• Enforce a non PEMDAS (BODMAS) order of operation, must have at least 6 levels of precedence
• Keywords cannot use the words while, for, do, if, int, short, long
i. Keywords should be unique, if others share your same words, you
may lose more points than this problem is worth
• You must clearly state the structure of your language with production
rules
c. (10 points) Show whether every rule set in your language conforms to the
standard of an LL Grammar.
d. (5 points) Make sure it is not ambiguous grammar
e. (15 points) Write a program that process all lexemes in a file by recognizing all
tokens in a file, and produces a list of those tokens in order
• If a group of characters is not defined in your language your program
should print an error message stating what went wrong and terminate
(stop running)
• This program should be written in an Object-Oriented fashion
• This program should have comments to describe each method that is
defined
f. (10 points) Write a program or an extension to the above program that
determines if the tokens conform to the correct syntax.
g. (10 points) Create 4 test files that have different names where each should have
30 or more lexemes that can be converted into tokens
• 1 with a at least 5 lexical errors based on the rules you defined
i. Detail each error and say why it doesn’t work
• 1 with at least 5 syntax errors based on the rules you defined i. Detail each error and say why it doesn’t work
• 2 with no errors at all based on the language you created
h. (20 points) Create a LR (1) parse table for your language. And show the trace of 4
code samples. Each must have 6 or more tokens.
• Table must be provided, and the rules must be listed
• 2 code samples must have errors
• Show were these samples fail and pass the test
