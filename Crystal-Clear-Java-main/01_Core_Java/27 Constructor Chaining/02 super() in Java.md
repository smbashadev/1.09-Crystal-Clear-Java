# 🧒 `super()` in Java

Think of `super()` as a **special message from the child constructor to its parent constructor**.

> 🧠 **`super()` means: "Parent, please run your constructor first."**

The basic flow is:

```text
Child Object Created
        ↓
   Child Constructor
        ↓
      super()
        ↓
 Parent Constructor
```

But there is an even deeper flow because **every Java class ultimately comes from `Object`**.

---

# 1. What is `super()`?

`super()` is used inside a constructor to call the **immediate parent class's constructor**.

Example:

```java
class Parent {

    Parent() {
        System.out.println("Parent constructor");
    }
}

class Child extends Parent {

    Child() {
        super();

        System.out.println("Child constructor");
    }
}
```

When we create:

```java
Child c = new Child();
```

the `super()` inside `Child()` calls:

```java
Parent()
```

---

# 2. Parent Constructor

Look at:

```java
class Parent {

    Parent() {
        System.out.println("Parent constructor");
    }
}
```

This is the constructor of `Parent`.

The child can call it using:

```java
super();
```

So:

```text
Child()
   ↓
super()
   ↓
Parent()
```

---

# 3. What About the `Object` Constructor?

This is **very important**. 🧠

In Java, every class ultimately inherits from the built-in:

```java
Object
```

So the hierarchy looks like:

```text
Object
   ↓
Parent
   ↓
Child
```

Even if you don't write:

```java
extends Object
```

Java's class hierarchy ultimately reaches `Object`.

---

# 4. Complete Constructor Flow

Suppose we have:

```java
class Parent {

    Parent() {
        System.out.println("Parent constructor");
    }
}

class Child extends Parent {

    Child() {
        super();

        System.out.println("Child constructor");
    }
}
```

Now:

```java
Child c = new Child();
```

The flow starts from the top of the inheritance hierarchy.

Conceptually:

```text
Child object creation
        ↓
Child()
        ↓
super()
        ↓
Parent()
        ↓
super()
        ↓
Object()
```

Then constructors complete back down the chain:

```text
Object constructor
        ↓
Parent constructor
        ↓
Child constructor
```

---

# 5. Visualize It as a Family 👨‍👦

Imagine:

```text
             Object
                ↓
             Parent
                ↓
             Child
```

`Child` says:

> "Before I finish my construction, my parent should be constructed."

So:

```text
Child
 ↓
super()
 ↓
Parent
```

But `Parent` also ultimately has `Object` above it:

```text
Child
 ↓
Parent
 ↓
Object
```

Therefore the constructor chain reaches `Object` first.

---

# 6. Complete Program

```java
class Parent {

    Parent() {
        System.out.println("Parent constructor");
    }
}

class Child extends Parent {

    Child() {
        super();

        System.out.println("Child constructor");
    }
}

class Demo {

    public static void main(String[] args) {

        Child c = new Child();
    }
}
```

### Output

```text
Parent constructor
Child constructor
```

You don't normally see:

```text
Object constructor
```

because Java's `Object()` constructor doesn't print anything.

But it participates in the constructor chain.

---

# 7. Three-Level Example

Let's make the hierarchy bigger:

```text
Object
   ↓
Animal
   ↓
Tiger
```

Code:

```java
class Animal {

    Animal() {
        System.out.println("Animal constructor");
    }
}

class Tiger extends Animal {

    Tiger() {
        super();

        System.out.println("Tiger constructor");
    }
}

class Demo {

    public static void main(String[] args) {

        Tiger t = new Tiger();
    }
}
```

The actual conceptual chain is:

```text
Object
   ↓
Animal
   ↓
Tiger
```

When:

```java
Tiger t = new Tiger();
```

is executed:

```text
Tiger()
   ↓
super()
   ↓
Animal()
   ↓
super()
   ↓
Object()
```

Then the output-producing constructors execute:

```text
Animal constructor
Tiger constructor
```

---

# 8. `super()` Is Usually Automatic

Consider:

```java
class Parent {

    Parent() {
        System.out.println("Parent constructor");
    }
}

class Child extends Parent {

    Child() {
        System.out.println("Child constructor");
    }
}
```

We didn't write:

```java
super();
```

But Java automatically inserts a call to the parent's no-argument constructor at the beginning of the child constructor, **provided such a constructor is accessible**.

Conceptually, Java treats it like:

```java
class Child extends Parent {

    Child() {

        super();

        System.out.println("Child constructor");
    }
}
```

So:

```text
No explicit super()
        ↓
Compiler inserts super()
        ↓
Parent constructor
```

---

# 9. `super()` Must Be First

If you explicitly write `super()`, it must be the **first statement** in the constructor.

✅ Correct:

```java
Child() {

    super();

    System.out.println("Child constructor");
}
```

❌ Incorrect:

```java
Child() {

    System.out.println("Child constructor");

    super();
}
```

The second version gives a compilation error.

---

# 10. Why Does Parent Come First?

Think about building a house. 🏠

You can't properly build the upper floor before establishing the lower structure.

Similarly:

```text
Object
   ↓
Parent
   ↓
Child
```

The parent portion must be initialized before the child constructor completes its work.

Therefore:

> **Parent constructor executes before child constructor.**

---

# ⭐ Remember Forever

### Inheritance hierarchy:

```text
Object
   ↓
Parent
   ↓
Child
```

### Constructor flow:

```text
Create Child object
        ↓
Child constructor
        ↓
super()
        ↓
Parent constructor
        ↓
super()
        ↓
Object constructor
```

### Actual visible execution:

```text
Object constructor
        ↓
Parent constructor
        ↓
Child constructor
```

(`Object()` normally produces no visible output.)

---

## 🧠 Golden Rule

> **`super()` means "call my immediate parent's constructor."**

And remember:

```text
Child
  ↓
super()
  ↓
Parent
  ↓
super()
  ↓
Object
```

### 🔥 Interview Answer

> **`super()` is a constructor invocation used to call the immediate parent class's constructor. During child-object creation, constructor chaining proceeds up the inheritance hierarchy to `Object`, and then constructors execute from parent to child. If a child constructor does not explicitly invoke another constructor using `this()` or `super()`, Java inserts an implicit `super()` when an accessible no-argument parent constructor is available.**
