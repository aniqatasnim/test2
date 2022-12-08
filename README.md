 Used the lazyLex replit code and extrastuff.ipynb and coded it in Java. 


* A: We are defining the rules for recognizing lexemes and having these lexemes/token being identified in a special way. In lexicalanalyzer.java, there is a class called lexicalanalyzer and inside there, there are static variables, character classes, token codes, operators, comparing vars, and regular symbols all being either an int or char type. These lexeme/tokens range from letters (a-zA-Z), digits(0-9),  regular symbols ($,&,@) arithetic symbols (-,+,=,*,), opening and closing brackets/parentheses([],{}), etc.

* B: We are defining production rules for the language and syntax of operators, operands,loops, variable declaration, selection statments, etc. One production rule for the language could be starting the program with #START and ending it with #END. The syntax of the production of the language can be found in syntaxanalyzer.java where we have a function for different types of operands, such as functions called statement, ifstmt, whileloop, assigning, expression, term, boolexpr, etc. Since we cannot use keywords: while, for,do, if int, etc...  I replaced them with synonyms of those keyword ({ "phor", "during", "match", "aswell, condition" }.... phor being for). The keywords can be found in lexicalanalyzer.java so if the user were to use any conditional, they would haveto. use. phor, during, math, aswell, or condition.

* C. If your language conforms to the standard of an LL Grammar, answering two questions, if it has left hand recursion and if it's pairwise disjoint. Not all grammars can be parsed top-down, but most context-free grammars can be parsed bottomup. In syntaxanalyzer.java there are functions that have left hand recursion, where the function either calls itself or another function within it, it being direct or indirect left recursion. For The pairwise disjoint test is mentions that for each nonterminal A that has more than one RHS, and for each pair of rules, A : i and A : j, it must be true that FIRST( i) ∩ FIRST( j) = ∅. 

* D: make sure it is not ambigious Grammar --> making sure there is not two way to make a sentence... there should not be two ways to make a sentence
because a statement should only a specific format and should be in. the correct syntax.

* E: program that processes all lexemes in a file and produces a list of those token in order and is in a object-oriented fashion --> lexicalanaylyzer.java

* F: write a program that determinse if the token conforms to the correct syntax --> syntaxanalyzer.java

* G: Creating test case files --> test1.txt, test2.txt, test3.txt, and test4.txt

* H:  create and LR Parse Table --> pdf/png (wasn't too sure how to do this :/ )
