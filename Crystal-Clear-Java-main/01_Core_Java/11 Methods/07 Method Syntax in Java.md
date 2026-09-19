## 🧒 Method Syntax in Java

A Java method is written using a particular structure.

### Basic syntax

```java id="h7k2mp"
returnType methodName(parameters) {
    // set of statements
}
```

Think of it like:

```text id="r9w3ka"
Return Type
     ↓
Method Name
     ↓
Parameters / Arguments
     ↓
Set of Statements
```

---

## 1️⃣ Return Type

The **return type** tells Java:

> **What type of value will this method give back?**

Examples:

```java id="4j6x8q"
int       → returns an integer
double    → returns a decimal value
String    → returns text
boolean   → returns true/false
void      → returns nothing
```

Example:

```java id="k3p7vz"
int add() {
    return 10;
}
```

Here:

```text id="q2m8yf"
int
 ↓
Method returns an integer
```

### `void`

If the method doesn't return a value:

```java id="x6n4rt"
void display() {
    System.out.println("Hello");
}
```

`void` means:

> **Nothing is returned.**

---

## 2️⃣ Method Name

The **method name** identifies the method.

Example:

```java id="m7c3xp"
void display() {
}
```

Here:

```text id="y8q5sn"
display
   ↑
Method name
```

We use the method name when calling it:

```java id="j4v9kc"
display();
```

Good method names usually describe the task:

```text id="a5k8qm"
add()
calculateSquare()
displayStudent()
checkEven()
```

---

## 3️⃣ Parameters / Arguments

Parameters are values that a method can **receive as input**.

Example:

```java id="p2r6zw"
void greet(String name) {
    System.out.println("Hello " + name);
}
```

Here:

```text id="k6s3vt"
String name
     ↑
Parameter
```

When we call it:

```java id="x8n4qd"
greet("Basha");
```

`"Basha"` is the **argument** supplied to the method.

### Simple distinction

```text id="z5m7qa"
Parameter → variable in method definition
Argument  → actual value passed during method call
```

---

## 4️⃣ Set of Statements

Inside `{ }`, we write the statements that perform the method's task.

Example:

```java id="w3c9kp"
void add() {

    int a = 10;
    int b = 20;
    int sum = a + b;

    System.out.println(sum);
}
```

These statements:

```text id="v7x2ms"
int a = 10;
int b = 20;
int sum = a + b;
System.out.println(sum);
```

perform the **specific task** of adding and displaying two numbers.

---

# 💻 Complete Example

```java id="n6t4yr"
class Demo {

    static int add(int a, int b) {

        int sum = a + b;

        return sum;
    }

    public static void main(String[] args) {

        int result = add(10, 20);

        System.out.println(result);
    }
}
```

Let's break this method:

```java id="u2v8mq"
static int add(int a, int b) {
    int sum = a + b;
    return sum;
}
```

| Part               | Meaning                                              |
| ------------------ | ---------------------------------------------------- |
| `static`           | Method can be called without creating an object here |
| `int`              | Return type                                          |
| `add`              | Method name                                          |
| `int a, int b`     | Parameters                                           |
| `int sum = a + b;` | Statement                                            |
| `return sum;`      | Sends result back                                    |

When we call:

```java id="d8k3wp"
add(10, 20);
```

```text id="p4m7xs"
10 → a
20 → b
 ↓
a + b
 ↓
30
 ↓
return 30
```

---

## 🧠 Golden Formula

```text id="x9q2mb"
returnType methodName(parameters) {
        statements;
        statements;
        return value;   // if required
}
```

### Remember:

```text id="a3f7nk"
RETURN TYPE
    ↓
"What will I get back?"

METHOD NAME
    ↓
"What task am I asking for?"

PARAMETERS
    ↓
"What input does it need?"

STATEMENTS
    ↓
"What does the method actually do?"
```

**Interview definition:**

> A Java method consists of a method declaration containing elements such as the return type, method name, and parameters, followed by a body containing the statements that perform a specific task.
