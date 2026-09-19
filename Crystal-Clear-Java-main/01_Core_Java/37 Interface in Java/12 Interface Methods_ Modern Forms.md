# 🧒 Interface Methods: Modern Forms

In modern Java, an interface can contain different kinds of methods. The three important forms in your notes are:

1. **Abstract methods**
2. **Static methods**
3. **Default methods**

---

## 1️⃣ Abstract Method

An abstract method contains **only the method declaration**, without a body.

```java
interface Trainer {

    void teach();
}
```

It is automatically:

```java
public abstract void teach();
```

The implementing class must provide the implementation:

```java
class JavaTrainer implements Trainer {

    @Override
    public void teach() {
        System.out.println("Teaching Java");
    }
}
```

### Remember

```text
Interface
   ↓
abstract method
   ↓
No body
   ↓
Implementing class provides body
```

---

# 2️⃣ Static Method

An interface can contain a **static method with a body**.

```java
interface Trainer {

    static void rules() {
        System.out.println("Trainer rules");
    }
}
```

A static interface method belongs to the **interface itself**.

Call it using the interface name:

```java
Trainer.rules();
```

### Important

Don't call it through an implementing-class object:

```java
JavaTrainer t = new JavaTrainer();

t.rules();   // ❌
```

Use:

```java
Trainer.rules();   // ✅
```

---

# 3️⃣ Default Method

An interface can also contain a **default method with a body**.

```java
interface Trainer {

    default void prepare() {
        System.out.println("Trainer prepares");
    }
}
```

A default method provides a **default implementation**.

An implementing class can simply inherit it:

```java
class JavaTrainer implements Trainer {

}
```

Then:

```java
JavaTrainer t = new JavaTrainer();

t.prepare();
```

Output:

```text
Trainer prepares
```

---

## 4️⃣ Default Method Can Be Overridden

The implementing class can also provide its own implementation.

```java
class JavaTrainer implements Trainer {

    @Override
    public void prepare() {
        System.out.println("Java Trainer prepares Java lessons");
    }
}
```

Now:

```java
JavaTrainer t = new JavaTrainer();

t.prepare();
```

Output:

```text
Java Trainer prepares Java lessons
```

So a default method means:

> **The interface provides a ready-made implementation, but the implementing class can override it if required.**

---

# ⭐ All Three Together

```java
interface Trainer {

    // Abstract method
    void teach();

    // Static method
    static void rules() {
        System.out.println("Trainer rules");
    }

    // Default method
    default void prepare() {
        System.out.println("Trainer prepares");
    }
}

class JavaTrainer implements Trainer {

    @Override
    public void teach() {
        System.out.println("Teaching Java");
    }

    @Override
    public void prepare() {
        System.out.println("Preparing Java lessons");
    }
}

class Demo {

    public static void main(String[] args) {

        JavaTrainer t = new JavaTrainer();

        t.teach();

        t.prepare();

        Trainer.rules();
    }
}
```

### Output

```text
Teaching Java
Preparing Java lessons
Trainer rules
```

---

# 🧠 Quick Comparison

| Type            | Has Body? | Implementing Class                                             |
| --------------- | --------- | -------------------------------------------------------------- |
| Abstract method | ❌ No      | Must implement                                                 |
| Static method   | ✅ Yes     | Not inherited as an instance method; call using interface name |
| Default method  | ✅ Yes     | Can inherit or override                                        |

### Easy Memory Trick

```text
ABSTRACT
   ↓
No body
   ↓
Child MUST implement


STATIC
   ↓
Has body
   ↓
Call using InterfaceName.method()


DEFAULT
   ↓
Has body
   ↓
Child can use OR override
```

### 🔥 Interview Answer

> **An interface can contain abstract, static, and default methods. Abstract methods define a contract without an implementation, static methods belong to the interface and are called using the interface name, and default methods provide a default implementation that implementing classes can inherit or override.**
