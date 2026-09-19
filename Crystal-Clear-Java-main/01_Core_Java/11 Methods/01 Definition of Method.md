## 🧒 Definition of Method in Java

A **method** is simply a **set of statements written together to perform a specific task**.

### 🔹 Simple Definition

> **A method is a set of statements that performs a specific task.**

Think of a method like a **machine** 🏭.

You give it something → it performs a task → it may give you a result.

```text id="d7p3a1"
        Method
          ↓
   Set of Statements
          ↓
    Specific Task
          ↓
       Result
```

---

## 🔹 Example

Suppose we want to add two numbers.

Without a method:

```java id="zqk5s8"
int a = 10;
int b = 20;

int sum = a + b;

System.out.println(sum);
```

Now we can put the statements responsible for addition inside a method:

```java id="k5p1nw"
static void add() {
    int a = 10;
    int b = 20;
    int sum = a + b;

    System.out.println(sum);
}
```

Here:

```text id="6h3q4v"
add()
 ↓
Set of statements
 ↓
Addition task
```

The method's **specific task** is:

> **Adding two numbers and displaying the result.**

---

## 🧠 Why use a Method?

Imagine you need to perform the same task **10 times**.

Instead of writing the same statements 10 times:

```text id="8q5k2c"
Statements
Statements
Statements
Statements
...
```

You can write them **once inside a method** and call the method whenever needed.

```text id="a7x9q2"
        Method
       add()
         ↓
   Addition statements
         ↓
   Call whenever needed
```

### 🔑 Memory Trick

> **Method = Set of Statements + Specific Task**

Examples:

```text id="b4m8x1"
add()       → addition task
subtract()  → subtraction task
display()   → display task
calculate() → calculation task
```

**Interview answer:**

> A **method in Java is a set of statements grouped together to perform a specific task.**
