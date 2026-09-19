# 🧒 Three Types of Interface Methods

Your three points can be remembered as:

```text
Abstract Method → Child provides body
Static Method   → Interface provides body
Default Method  → Interface provides common body
```

---

## 1️⃣ Abstract Interface Method

An abstract interface method has **no body**.

```java
interface Trainer {

    void teach();
}
```

The implementing class **must provide the body**:

```java
class JavaTrainer implements Trainer {

    @Override
    public void teach() {

        System.out.println("Teaching Java");
    }
}
```

Flow:

```text
Interface
   ↓
abstract teach()
   ↓
No body
   ↓
Implementing class
   ↓
Provides body
```

---

## 2️⃣ Static Interface Method

A static interface method has a body and belongs to the **interface itself**.

```java
interface Trainer {

    static void rules() {

        System.out.println("Follow trainer rules");
    }
}
```

We don't need an implementing-class object.

Call it using the **interface name**:

```java
Trainer.rules();
```

Flow:

```text
Trainer
   ↓
static rules()
   ↓
Trainer.rules()
```

❌ Not:

```java
JavaTrainer t = new JavaTrainer();
t.rules();
```

---

## 3️⃣ Default Interface Method

A default method provides a **common method body**.

```java
interface Trainer {

    default void prepare() {

        System.out.println("Trainer prepares");
    }
}
```

An implementing class can use this method without writing its own implementation:

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

So the common implementation is shared by implementing classes.

---

## 4️⃣ Default Method Can Be Overridden

Although the default implementation is available to implementing classes, a class can provide its own implementation.

```java
class JavaTrainer implements Trainer {

    @Override
    public void prepare() {

        System.out.println("Java Trainer prepares Java lessons");
    }
}
```

Now the class-specific implementation executes.

---

# ⭐ Complete Comparison

| Method       | Body in Interface? | Who Provides Implementation?                                 | How Called?                           |
| ------------ | ------------------ | ------------------------------------------------------------ | ------------------------------------- |
| **Abstract** | ❌ No               | Implementing class                                           | Through object/reference              |
| **Static**   | ✅ Yes              | Interface itself                                             | `InterfaceName.method()`              |
| **Default**  | ✅ Yes              | Interface provides common implementation; class can override | Through implementing object/reference |

---

# 🧠 Easy Memory Trick

```text
ABSTRACT
   ↓
No body
   ↓
Implementing class provides body


STATIC
   ↓
Interface has body
   ↓
No object required
   ↓
InterfaceName.method()


DEFAULT
   ↓
Interface has common body
   ↓
Implementing classes can share it
   ↓
Can override when needed
```

### 🔥 One-line interview answer

> **An abstract interface method requires implementing classes to provide the body, a static interface method belongs to the interface and is called using the interface name without an object, and a default interface method provides a common implementation that implementing classes can inherit or override.**
