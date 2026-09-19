# 🧒 Default Class & Default Constructor in Java

This topic connects **three important ideas**:

1. Every Java class ultimately gets features from the **`Object` class**.
2. A class with **no constructor written** gets a compiler-provided default constructor.
3. That constructor implicitly calls **`super()`**, which calls the parent-class constructor.

Let's understand it step by step.

---

## 1. The `Object` Class

In Java, the class:

```java
Object
```

is the **root class** of the Java class hierarchy.

For example:

```java
class Dog {
}
```

Conceptually, Java treats it as:

```java
class Dog extends Object {
}
```

So:

```text
Object
   ↑
  Dog
```

`Dog` is a child/subclass of `Object`.

---

# 2. Dog Class Without a Constructor

Suppose we write:

```java
class Dog {

    void bark() {
        System.out.println("Dog is barking");
    }
}
```

We did not write any constructor.

Therefore, the compiler provides a **default constructor** conceptually:

```java
Dog() {
    super();
}
```

So you can think of the class as:

```java
class Dog {

    Dog() {
        super();
    }

    void bark() {
        System.out.println("Dog is barking");
    }
}
```

You didn't write that constructor, but the compiler provides the default constructor because you didn't define any constructor.

---

# 3. What Is `super()`?

`super()` is used to call the **constructor of the immediate parent class**.

Since:

```java
class Dog extends Object
```

the parent of `Dog` is `Object`.

Therefore:

```java
super();
```

inside the `Dog` constructor means:

```text
Dog constructor
      ↓
super()
      ↓
Object constructor
```

---

# 4. Object Creation

Now create a Dog object:

```java
Dog d = new Dog();
```

What happens?

```text
new Dog()
    ↓
Dog object is created
    ↓
Dog constructor executes
    ↓
super() executes
    ↓
Object constructor executes
    ↓
Dog constructor completes
```

Then the object is ready to use.

---

# 5. Complete Simple Program

```java
class Dog {

    void bark() {
        System.out.println("Dog is barking");
    }
}

class Demo {

    public static void main(String[] args) {

        Dog d = new Dog();

        d.bark();
    }
}
```

Output:

```text
Dog is barking
```

Even though we didn't write:

```java
Dog() {
    super();
}
```

the compiler provides the default constructor conceptually.

---

# 6. See the Hidden Constructor

Your code:

```java
class Dog {

    void bark() {
        System.out.println("Dog is barking");
    }
}
```

Think of it approximately as:

```java
class Dog extends Object {

    Dog() {
        super();
    }

    void bark() {
        System.out.println("Dog is barking");
    }
}
```

Therefore:

```java
Dog d = new Dog();
```

can work.

---

# 7. Why Does `super()` Matter?

Because `Dog` has a parent:

```text
Object
  ↑
 Dog
```

When the `Dog` constructor executes, the parent constructor is initialized first through:

```java
super();
```

So the constructor chain is:

```text
Object constructor
       ↓
Dog constructor
       ↓
Dog object ready
```

For a deeper inheritance chain:

```text
Object
  ↑
Animal
  ↑
Dog
```

the constructor chain conceptually starts from the top:

```text
Object()
   ↓
Animal()
   ↓
Dog()
```

---

# 8. Very Important Rule ⭐

If you don't write **any constructor** in `Dog`:

```java
class Dog {
}
```

the compiler provides a default constructor conceptually like:

```java
Dog() {
    super();
}
```

The `super()` call invokes the no-argument constructor of the immediate superclass.

Since `Dog` directly extends `Object` when no other superclass is specified, that means `Object()`.

---

# 9. What If We Write Our Own Constructor?

Suppose:

```java
class Dog {

    Dog() {
        System.out.println("Dog constructor");
    }
}
```

Now the programmer has defined a constructor.

The compiler no longer provides the **automatic default constructor**.

However, because we didn't explicitly write `super()`, Java implicitly inserts a call to the no-argument superclass constructor at the beginning, assuming one is accessible.

Conceptually:

```java
Dog() {
    super();
    System.out.println("Dog constructor");
}
```

So:

```text
Object()
   ↓
Dog()
   ↓
Dog constructor body
```

---

# 10. Default Constructor vs `super()`

Don't confuse these two:

### Default constructor

A constructor **automatically supplied by the compiler when no constructor is declared**.

Example:

```java
class Dog {
}
```

Conceptually:

```java
Dog() {
    super();
}
```

### `super()`

A constructor invocation that calls the **immediate parent class's no-argument constructor**.

```java
super();
```

So:

```text
Default constructor
      ↓
contains an implicit super() call
      ↓
calls parent constructor
```

---

# 🧠 Real-Life Example

Imagine a family:

```text
Grandparent
     ↓
   Parent
     ↓
    Dog
```

When the Dog is created, the parent side must be initialized through the constructor chain.

In Java:

```text
Object
  ↓
Dog
```

So:

```text
new Dog()
   ↓
Dog()
   ↓
super()
   ↓
Object()
```

---

# ⭐ Remember This Forever

```text
class Dog {
}
```

means:

```text
No constructor written
        ↓
Compiler provides default constructor
        ↓
Dog()
        ↓
super()
        ↓
Object()
```

And:

```java
Dog d = new Dog();
```

means:

```text
Create Dog object
       ↓
Call Dog constructor
       ↓
Call Object constructor through super()
       ↓
Finish Dog construction
```

### 🔥 One-line interview answer

> **When no constructor is declared in a class, the compiler provides a default constructor. That constructor implicitly invokes `super()`, which calls the no-argument constructor of the immediate superclass. For a class like `Dog` with no explicit superclass, the superclass is `Object`.**
