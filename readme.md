# Basic Interpreter for C like language

Author: __Orkhan Huseynli__, BSIT 2018, "ADA" University

Steps implemented:

* Lexing  - Process of tokenizing input string.
* Parsing - Process of analyzing token list given by Lexer and creating parse tree (AST). Used LL(k) parsing algorithm.
* TypeChecking - Checking if the program is well typed (NOT IMPLEMENTED YET)
* Evaluation - Process of evaluting expression and statement           


Test codes that interpreter is able to process:

#### 1. Basic if else evaluation
```
int main() {
  string name = "Orkhan"; string res;
  int privilege = 1;
  if (privilege == 0) {
     res = "Hello, " + name;
  } else {
     res = "you don't have privilege for the operation";
  }
  return res;
}

```

#### 2. Basic while loop evalution

```
int main() {
  int count = 0;
  string res = "Iteration: ";
  while (count < 10) {
    res = res + "," + count;
    count++;
  }
  return res;
}
```

#### 3. Basic eval error example

```
int main() {
  int x;
  int y;
  x = 12;
  return x + y;  
}
```

#### 4. Basic parse error example

```
int main() {
  int x;
  int y
  x = 12;
  return x + y;  
}
```