# 🧒 `super()` Rules in Java

The `super()` keyword is used when a **child constructor needs to call the constructor of its parent class**.

> 🧠 **`super()` means: "Call my immediate parent constructor."**

It is an important part of **constructor chaining**.

---

## 1. `super()` Calls the Parent Constructor

Suppose we have:

```java
class Parent {

    Parent() {
        System.out.println("Parent constructor");
    }
}
```

Now create a child:

```java
class Child extends Parent {

    Child() {

        super();

        System.out.println("Child constructor");
    }
}
```

Here:

```java
super();
```

means:

```text
Child constructor
       ↓
     super()
       ↓
Parent constructor
```

So `super()` is used for **parent constructor invocation**.

---

# 2. Constructor Chaining

When the child constructor calls the parent constructor using `super()`, constructors execute in a chain.

```text
Child()
   ↓
super()
   ↓
Parent()
```

When the object is created:

```java
Child c = new Child();
```

the output is:

```text
Parent constructor
Child constructor
```

The parent constructor executes first.

---

# 3. Complete Program

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

---

# 4. Why Does `Parent` Execute First?

Look at the inheritance:

```text
Parent
   ↓
Child
```

When we create:

```java
new Child();
```

Java needs to construct the parent part before completing the child construction.

So the flow is:

```text
Create Child object
       ↓
Child constructor starts
       ↓
super()
       ↓
Parent constructor executes
       ↓
Back to Child constructor
       ↓
Child constructor continues
```

---

# 5. `super()` Must Be the First Statement

Just like `this()`, an explicit `super()` constructor invocation must be the **first statement** in a constructor.

### ✅ Correct

```java
Child() {

    super();

    System.out.println("Child constructor");
}
```

### ❌ Incorrect

```java
Child() {

    System.out.println("Child constructor");

    super();
}
```

The second program gives a **compile-time error**.

---

# 6. `super()` Can Be Automatic

You don't always have to write `super()` yourself.

For example:

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

Although we didn't write:

```java
super();
```

Java implicitly inserts a call to the parent's no-argument constructor at the beginning of `Child()`, when an accessible no-argument parent constructor is available.

Conceptually:

```java
Child() {

    super();

    System.out.println("Child constructor");
}
```

---

# 7. `super()` vs `this()`

This is extremely important. ⭐

| Keyword   | Calls               | Where?       |
| --------- | ------------------- | ------------ |
| `this()`  | Another constructor | Same class   |
| `super()` | Parent constructor  | Parent class |

### `this()`

```text
Student()
   ↑
this()
   ↑
Student(String)
```

Same class.

### `super()`

```text
Child()
   ↓
super()
   ↓
Parent()
```

Parent-child relationship.

---

# 8. Multilevel Constructor Chaining

Suppose we have:

```text
Object
   ↓
Animal
   ↓
Tiger
```

When we create:

```java
Tiger t = new Tiger();
```

the constructor chain ultimately reaches `Object`.

Conceptually:

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

The execution order is:

```text
Object constructor
       ↓
Animal constructor
       ↓
Tiger constructor
```

`Object()` normally produces no visible output because its constructor doesn't print anything.

---

# 🧠 Real-Life Example

Imagine a child joining a family.

The child says:

> "Before I complete my own setup, my parent needs to complete theirs."

That's similar to:

```text
Child()
  ↓
super()
  ↓
Parent()
```

---

# ⭐ Remember Forever

### `super()` means:

> **Call the immediate parent constructor.**

### Three important points:

```text
1️⃣ Calls parent constructor
2️⃣ Helps in constructor chaining
3️⃣ Must be first statement when explicitly written
```

### Visual memory:

```text
        Parent
           ↑
        super()
           ↑
         Child
```

Or simply:

```text
Child Constructor
       ↓
     super()
       ↓
Parent Constructor
```

### 🔥 Interview Answer

> **`super()` is used inside a child constructor to invoke the constructor of its immediate parent class. It is part of constructor chaining, and when explicitly used, it must be the first statement in the constructor. If an accessible no-argument parent constructor exists and no explicit constructor invocation is written, Java inserts an implicit `super()` call.**
