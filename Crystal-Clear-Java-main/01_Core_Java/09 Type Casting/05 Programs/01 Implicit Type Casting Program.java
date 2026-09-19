## 🧒 Implicit Type Casting Program

**Implicit type casting** means:

> **Java automatically converts a smaller/wider-compatible data type into a larger data type.**
> We **do not need to write `(type)`**.

Think of it like this:

**Small box 📦 → Bigger box 📦**

Java can safely put the smaller value into the bigger type.

### 🔄 Common widening order

```text
byte → short → int → long → float → double
```

### Simple program

```java
class ImplicitCasting {
    public static void main(String[] args) {

        byte b = 10;

        short s = b;       // byte → short
        int i = s;         // short → int
        long l = i;        // int → long
        float f = l;      // long → float
        double d = f;     // float → double

        System.out.println("byte   = " + b);
        System.out.println("short  = " + s);
        System.out.println("int    = " + i);
        System.out.println("long   = " + l);
        System.out.println("float  = " + f);
        System.out.println("double = " + d);
    }
}
```

### Output

```text
byte   = 10
short  = 10
int    = 10
long   = 10
float  = 10.0
double = 10.0
```

### 🧠 What is happening?

```text
byte b = 10;
     ↓
short s = b;
     ↓
int i = s;
     ↓
long l = i;
     ↓
float f = l;
     ↓
double d = f;
```

At every step, **Java automatically performs the conversion**.

Notice that we didn't write:

```java
short s = (short)b;   // ❌ Not required
int i = (int)s;       // ❌ Not required
```

Instead:

```java
short s = b;          // ✅
int i = s;            // ✅
```

### ⭐ Why is it called "Implicit"?

**Implicit = automatic**

You don't explicitly tell Java:

> "Please convert this byte into a short."

Java understands the assignment and performs the conversion automatically.

### 🔑 Interview Answer

> **Implicit type casting is the automatic conversion of a value from a narrower type to a wider compatible type. It is also called widening conversion, and the programmer normally does not need to use the cast operator.**

### 🧠 Easy Memory Trick

```text
BYTE
 ↓
SHORT
 ↓
INT
 ↓
LONG
 ↓
FLOAT
 ↓
DOUBLE
```

**Small → Big = Implicit → Automatic → Widening** ✅
