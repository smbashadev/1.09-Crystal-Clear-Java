# 🧒 `final` Keyword in Java

The `final` keyword means:

> 🔒 **"Don't change this."**

Java uses `final` in three important places:

```text
final
 ├── Variable → cannot change its value
 ├── Method   → cannot override it
 └── Class    → cannot extend it
```

---

# 1. `final` Variable

A `final` variable behaves like a **constant**.

Once a value is assigned, it cannot be changed.

### Example

```java
class Demo {

    public static void main(String[] args) {

        final int x = 100;

        System.out.println(x);
    }
}
```

### Output

```text
100
```

Here:

```java
final int x = 100;
```

means:

```text
x = 100
   ↓
Cannot assign another value ❌
```

---

## Attempt to Modify `final` Variable ❌

```java
class Demo {

    public static void main(String[] args) {

        final int x = 100;

        System.out.println(x);

        x = 200;   // ❌ Compile-time error
    }
}
```

The problem is:

```text
final x = 100
       ↓
x = 200
       ↓
Modification ❌
```

Once initialized, a final variable cannot be reassigned.

---

# 2. `final` Method

A `final` method:

> 🔒 **Cannot be overridden by a child class.**

### Parent

```java
class Parent {

    final void display() {

        System.out.println("Parent display()");
    }
}
```

Now create a child:

```java
class Child extends Parent {

    // ❌ Cannot override final method

    // void display() {
    //     System.out.println("Child display()");
    // }
}
```

The parent says:

```text
final display()
      ↓
"Child, you cannot override me." 🔒
```

---

## Complete Program

```java
class Parent {

    final void display() {

        System.out.println("Parent display()");
    }
}

class Child extends Parent {

}

class Demo {

    public static void main(String[] args) {

        Child c = new Child();

        c.display();
    }
}
```

### Output

```text
Parent display()
```

The child **inherits** the final method, but it **cannot override** it.

### Important distinction

```text
final method
     ↓
Can be inherited → ✅
Can be overridden → ❌
```

---

## Attempt to Override `final` Method ❌

```java
class Parent {

    final void display() {

        System.out.println("Parent");
    }
}

class Child extends Parent {

    @Override
    void display() {       // ❌ Compile-time error

        System.out.println("Child");
    }
}
```

Java reports an error because `display()` is final in the parent.

---

# 3. `final` Class

A `final` class:

> 🔒 **Cannot be extended by another class.**

Example:

```java
final class Parent {

    void display() {

        System.out.println("Hello");
    }
}
```

Now:

```java
class Child extends Parent {   // ❌ Compile-time error

}
```

Because:

```text
final Parent
     ↓
Cannot extend
     ↓
Child ❌
```

---

## Complete Program

```java
final class Parent {

    void display() {

        System.out.println("Parent display()");
    }
}

class Demo {

    public static void main(String[] args) {

        Parent p = new Parent();

        p.display();
    }
}
```

### Output

```text
Parent display()
```

The class can still be instantiated normally.

`final` only prevents **inheritance**.

---

# 4. Attempt to Extend `final` Class ❌

```java
final class Parent {

}

class Child extends Parent {   // ❌ Compile-time error

}
```

The compiler rejects this because:

```text
Parent = final
   ↓
Cannot be extended
```

---

# 🧠 All Three Together

Think of `final` as **three different locks**:

```text
┌──────────────────────────────┐
│          final               │
├──────────────────────────────┤
│ Variable → 🔒 Value          │
│ Method   → 🔒 Overriding     │
│ Class    → 🔒 Inheritance    │
└──────────────────────────────┘
```

### `final` Variable

```java
final int x = 10;
```

```text
x = 20 ❌
```

---

### `final` Method

```java
final void display() {
}
```

```text
Child overriding ❌
```

---

### `final` Class

```java
final class Parent {
}
```

```text
class Child extends Parent ❌
```

---

# ⭐ Important Interview Point

`final` does **not** mean the same thing everywhere.

| Usage            | Meaning                              |
| ---------------- | ------------------------------------ |
| `final` variable | Value/reference cannot be reassigned |
| `final` method   | Cannot be overridden                 |
| `final` class    | Cannot be extended                   |

---

# 🔥 Easy Memory Trick

Remember:

> **Variable → Value**
> **Method → Override**
> **Class → Extend**

```text
final variable
      ↓
Don't CHANGE the value 🔒

final method
      ↓
Don't OVERRIDE the method 🔒

final class
      ↓
Don't EXTEND the class 🔒
```

### One-line interview answer

> **The `final` keyword is used to restrict modification: a final variable cannot be reassigned, a final method cannot be overridden, and a final class cannot be extended.**
