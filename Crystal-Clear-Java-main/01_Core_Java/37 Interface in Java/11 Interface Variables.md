# 🧒 Interface Variables

Variables declared inside a Java **interface** are automatically:

```text
public + static + final
```

So an interface variable is essentially a **public constant**.

---

## 1. `public`

Interface variables are automatically `public`.

```java
interface Calculator {

    int MAX = 100;
}
```

Java treats it as:

```java
interface Calculator {

    public int MAX = 100;
}
```

Therefore, it can be accessed from outside the interface:

```java
System.out.println(Calculator.MAX);
```

---

## 2. `static`

Interface variables are automatically `static`.

```java
interface Calculator {

    int MAX = 100;
}
```

is treated as:

```java
public static int MAX = 100;
```

Therefore, we access it using the **interface name**:

```java
Calculator.MAX
```

We don't need to create an object.

---

## 3. `final`

Interface variables are automatically `final`.

```java
interface Calculator {

    int MAX = 100;
}
```

means:

```java
public static final int MAX = 100;
```

Therefore, this is not allowed:

```java
Calculator.MAX = 200;   // ❌
```

Because the value of a `final` variable cannot be changed.

---

# 4. Interface Variables Are Constants ⭐

Because interface variables are:

```text
public
static
final
```

they are commonly called **constants**.

Example:

```java
interface MathConstants {

    double PI = 3.14159;
}
```

This is equivalent to:

```java
interface MathConstants {

    public static final double PI = 3.14159;
}
```

Access it using:

```java
System.out.println(MathConstants.PI);
```

---

# 5. Complete Program

```java
interface Calculator {

    int MAX = 100;
    double PI = 3.14159;
}

class Demo {

    public static void main(String[] args) {

        System.out.println(Calculator.MAX);
        System.out.println(Calculator.PI);

        // Calculator.MAX = 200;   // ❌ Cannot modify
    }
}
```

### Output

```text
100
3.14159
```

---

# 🧠 Easy Memory Trick

Whenever you see a variable inside an interface:

```java
int MAX = 100;
```

Automatically think:

```text
public
   +
static
   +
final
   ↓
CONSTANT
```

So:

```java
interface Test {

    int x = 10;
}
```

is effectively:

```java
interface Test {

    public static final int x = 10;
}
```

### 🔥 Interview Answer

> **Variables declared inside an interface are implicitly `public`, `static`, and `final`. Therefore, they are constants, can be accessed using the interface name, and their values cannot be modified.**
