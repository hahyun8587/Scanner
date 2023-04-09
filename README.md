# Compiler Scanner 

## Supporting Operators
- Arithmatic operators: +, -, *, /
- Relational operators: <, >, =, <=, >=, !=
- Assignment oeprators: = 
- Logical operators: !
- Increment and Decrement operators: ++, --

<br>

## Supporting Types
- integer
- float
  
<br>

## Usage
### compilation 
```console
user@scanner:~$ javac *.java
```
<br>

### execution
```console
user@scanner:~$ java SmallScan <program-file-to-scan> <dfa-file>
```  
<br>

## Customization       
### Customizing DFA
You can customize your own DFA by filling up the tables below and writing dfa file in <code>dfa.txt</code> format.    
<br>

Transition Matrix
| |+|-|<|>|=|!|.|_|"|;|letter|digit|op|ws|sc|other|  
|--- |---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|---|  
|0| | | | | | | | | | | | | | | | |
|1| | | | | | | | | | | | | | | | |
|2| | | | | | | | | | | | | | | | |
|3| | | | | | | | | | | | | | | | |
|...| | | | | | | | | | | | | | | | |  
<br>
  
Final State Array  
| |0|1|2|3|...|
|---|---|---|---|---|---|
|isFinal| | | | | |  
<br>

Retract Array  
| |0|1|2|3|...|
|---|---|---|---|---|---|
|retract| | | | | |
<br>

After you made your own dfa file, you need to modify <code>UnreservedStates.java</code> file according to your unreserved states. Unreserved states indicates the final states that returns unreserved tokens such as id, number, string literal, and etc.   
<br>

### Customizing Reserved Words
You can add your own keywords to <code>Keywords.java</code> file.  
You can add your own special characters to <code>SpecialCharacters.java</code> file.  
You can add your own statement terminators to <code>StatementTerminator.java</code> file.

