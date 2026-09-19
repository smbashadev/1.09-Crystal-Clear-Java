# 🧒 Methods in Inheritance

When inheritance is used, a child class can have **three important kinds of methods**:

1. **Inherited Method**
2. **Overridden Method**
3. **Specialized Method**

Let's understand them using your example:

```text
Tendulkar
   ↓
Arjun
```

Think of **Tendulkar** as the parent class and **Arjun** as the child class.

---

# 1. Inherited Method

An **inherited method** is a method that comes from the parent and is used by the child **as it is**, without changing its implementation.

### Example

```java
class Tendulkar {

    void play() {
        System.out.println("Playing cricket");
    }
}

class Arjun extends Tendulkar {
}
```

Now:

```java
Arjun a = new Arjun();

a.play();
```

### Output

```text
Playing cricket
```

`play()` was written in `Tendulkar`.

`Arjun` didn't write or change it.

So:

```text
Tendulkar
   │
   └── play()
          ↓
      inherited
          ↓
       Arjun
```

### 🧠 Remember

> **Inherited method = Parent method used as it is by the child.**

---

# 2. Overridden Method

Sometimes the child **gets a method from the parent but wants to provide its own implementation**.

This is called **method overriding**.

For example, suppose Tendulkar has:

```java
class Tendulkar {

    void role() {
        System.out.println("Tendulkar is a batsman");
    }
}
```

Now Arjun also has a `role()` method:

```java
class Arjun extends Tendulkar {

    @Override
    void role() {
        System.out.println("Arjun is a cricketer");
    }
}
```

Here the method name and parameters are the same:

```text
Parent → role()
Child  → role()
```

But the child provides a different implementation.

---

# 3. Complete Overriding Example

```java
class Tendulkar {

    void role() {
        System.out.println("Tendulkar is a batsman");
    }
}

class Arjun extends Tendulkar {

    @Override
    void role() {
        System.out.println("Arjun is a cricketer");
    }
}

class Demo {

    public static void main(String[] args) {

        Arjun a = new Arjun();

        a.role();
    }
}
```

### Output

```text
Arjun is a cricketer
```

Why?

Because `Arjun` has overridden the inherited `role()` method.

---

# 4. Specialized Method

A **specialized method** is a method that exists **only in the child**.

It does not exist in the parent.

For example:

```java
class Arjun extends Tendulkar {

    void smoke() {
        System.out.println("Arjun's specialized method");
    }
}
```

There is no `smoke()` method in `Tendulkar`.

Therefore:

```text
Tendulkar
   ❌ smoke()

Arjun
   ✅ smoke()
```

This is a **specialized method**.

---

# 5. All Three Together

Let's put everything into one program.

```java
class Tendulkar {

    // Inherited method
    void play() {
        System.out.println("Playing cricket");
    }

    // Method that can be overridden
    void role() {
        System.out.println("Tendulkar is a batsman");
    }
}

class Arjun extends Tendulkar {

    // Overridden method
    @Override
    void role() {
        System.out.println("Arjun is a cricketer");
    }

    // Specialized method
    void smoke() {
        System.out.println("Arjun's specialized method");
    }
}

class Demo {

    public static void main(String[] args) {

        Arjun a = new Arjun();

        // Inherited method
        a.play();

        // Overridden method
        a.role();

        // Specialized method
        a.smoke();
    }
}
```

### Output

```text
Playing cricket
Arjun is a cricketer
Arjun's specialized method
```

---

# 6. Understand Each Method

## `play()` → Inherited Method

```java
void play() {
    System.out.println("Playing cricket");
}
```

It exists in `Tendulkar`.

`Arjun` uses it **without changing it**.

```text
Tendulkar
   ↓
 play()
   ↓
Arjun
```

✅ **Inherited**

---

## `role()` → Overridden Method

Parent:

```java
void role() {
    System.out.println("Tendulkar is a batsman");
}
```

Child:

```java
@Override
void role() {
    System.out.println("Arjun is a cricketer");
}
```

The child changes the implementation.

```text
Tendulkar
   ↓
 role()
   ↓
Arjun
   ↓
changes implementation
```

✅ **Overridden**

---

## `smoke()` → Specialized Method

```java
void smoke() {
    System.out.println("Arjun's specialized method");
}
```

This method exists only in `Arjun`.

```text
Tendulkar
   ❌ smoke()

Arjun
   ✅ smoke()
```

✅ **Specialized**

---

# 🧠 Easy Comparison

| Type            | Parent has method? | Child has method? | Child changes implementation? |
| --------------- | ------------------ | ----------------- | ----------------------------- |
| **Inherited**   | ✅                  | Uses it           | ❌ No                          |
| **Overridden**  | ✅                  | ✅                 | ✅ Yes                         |
| **Specialized** | ❌                  | ✅                 | Not applicable                |

---

# 🎯 One Simple Story

Imagine Tendulkar teaches Arjun three things.

### 1️⃣ `play()`

Tendulkar says:

> "This is how I play."

Arjun simply uses it.

```text
play()
↓
Same implementation
```

➡️ **Inherited method**

---

### 2️⃣ `role()`

Tendulkar says:

> "My role is batsman."

Arjun says:

> "My role is different."

So Arjun changes the implementation.

```text
role()
↓
Different implementation
```

➡️ **Overridden method**

---

### 3️⃣ `smoke()`

Arjun has something that Tendulkar's class doesn't have:

```text
smoke()
```

➡️ **Specialized method**

---

# ⭐ Remember Forever

```text
              Tendulkar
                  │
        ┌─────────┴─────────┐
        │                   │
      play()              role()
        │                   │
   use as it is       change implementation
        │                   │
        ↓                   ↓
    INHERITED            OVERRIDDEN

                  Arjun
                    │
                    └── smoke()
                         ↓
                    SPECIALIZED
```

### 🔥 Golden Rule

> **Inherited = Parent's method + use as it is.**

> **Overridden = Parent's method + child changes its implementation.**

> **Specialized = New method that exists only in the child.**
