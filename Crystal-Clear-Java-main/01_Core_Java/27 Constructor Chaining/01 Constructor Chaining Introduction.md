# 🧒 Constructor Chaining in Java

**Constructor Chaining** means:

> 🧠 **When one constructor calls another constructor, so that constructors execute one after another in a chain.**

In inheritance, the chain normally goes:

```text
Parent Constructor
       ↓
Child Constructor
```

The important keyword is:

```java
super();
```

---

# 1. Parent Constructor

Let's create a parent class:

```java
class Parent {

    Parent() {
        System.out.println("Parent constructor");
    }
}
```

The constructor:

```java
Parent()
```

belongs to the `Parent` class.

---

# 2. Child Constructor

Now create a child class:

```java
class Child extends Parent {

    Child() {
        System.out.println("Child constructor");
    }
}
```

Here:

```text
Parent
   ↓
Child
```

---

# 3. What Happens When We Create a Child Object?

Suppose we write:

```java
Child c = new Child();
```

Many beginners think:

> "Only the `Child` constructor will execute."

❌ That's not correct.

Java first executes the **parent constructor**, then the **child constructor**.

```text
Child object creation
        ↓
Parent constructor
        ↓
Child constructor
```

---

# 4. Why Does Parent Constructor Execute First?

Because the child object contains the inherited part associated with its parent.

Java ensures the parent construction happens before the child construction.

The child constructor automatically begins with a call to:

```java
super();
```

if you don't explicitly write another constructor invocation.

---

# 5. Automatic `super()`

Look at this program:

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

class Demo {

    public static void main(String[] args) {

        Child c = new Child();
    }
}
```

We didn't write:

```java
super();
```

inside `Child()`.

But Java conceptually inserts an implicit:

```java
super();
```

as the first statement of the child constructor, provided the parent has an accessible no-argument constructor.

So you can think of the child constructor as:

```java
Child() {

    super();

    System.out.println("Child constructor");
}
```

---

# 6. Output

```text
Parent constructor
Child constructor
```

Notice the order:

```text
1️⃣ Parent constructor
2️⃣ Child constructor
```

---

# 7. Explicit `super()`

We can also write it ourselves:

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

Now the `super()` call is clearly visible.

Output is still:

```text
Parent constructor
Child constructor
```

---

# 8. Why Is `super()` Important?

`super()` means:

> **Call the constructor of my immediate parent class.**

For:

```java
class Child extends Parent
```

this:

```java
super();
```

means:

```text
Call Parent()
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

# 9. Multilevel Constructor Chaining

Constructor chaining becomes even more interesting with multiple inheritance levels.

Consider:

```text
Animal
   ↓
Carnivorous
   ↓
Tiger
```

Each class has a constructor.

```java
class Animal {

    Animal() {
        System.out.println("Animal constructor");
    }
}
```

```java
class Carnivorous extends Animal {

    Carnivorous() {
        System.out.println("Carnivorous constructor");
    }
}
```

```java
class Tiger extends Carnivorous {

    Tiger() {
        System.out.println("Tiger constructor");
    }
}
```

Now:

```java
Tiger t = new Tiger();
```

The constructors execute in this order:

```text
Animal constructor
        ↓
Carnivorous constructor
        ↓
Tiger constructor
```

---

# 10. Complete Multilevel Example

```java
class Animal {

    Animal() {
        System.out.println("Animal constructor");
    }
}

class Carnivorous extends Animal {

    Carnivorous() {
        System.out.println("Carnivorous constructor");
    }
}

class Tiger extends Carnivorous {

    Tiger() {
        System.out.println("Tiger constructor");
    }
}

class Demo {

    public static void main(String[] args) {

        Tiger t = new Tiger();
    }
}
```

### Output

```text
Animal constructor
Carnivorous constructor
Tiger constructor
```

---

# 11. Why This Is Called a Chain 🔗

Look at:

```text
Tiger()
  ↓
Carnivorous()
  ↓
Animal()
```

The call travels up the inheritance hierarchy first.

Then control returns downward:

```text
Animal()
  ↓
Carnivorous()
  ↓
Tiger()
```

So the actual execution order is:

```text
Animal constructor
       ↓
Carnivorous constructor
       ↓
Tiger constructor
```

This sequence is called **constructor chaining**.

---

# 🧒 Easy Real-Life Example

Imagine building a three-floor house.

```text
Animal      → Ground floor
Carnivorous → First floor
Tiger       → Second floor
```

You cannot properly build the upper floor before the lower structure is ready.

Similarly:

```text
Parent constructor
       ↓
Child constructor
```

The parent portion is initialized first.

---

# ⭐ Important Rules

### Rule 1

Constructors are **not inherited**.

```text
Parent constructor
       ↓
❌ inherited by Child
```

Instead, the child constructor **invokes** the parent constructor.

---

### Rule 2

`super()` calls the immediate parent constructor.

```java
super();
```

means:

```text
Call immediate parent's no-argument constructor
```

---

### Rule 3

If a child constructor does not explicitly invoke a constructor using `this(...)` or `super(...)`, Java inserts an implicit `super()` call.

---

### Rule 4

The parent constructor executes **before** the child constructor.

```text
Parent()
   ↓
Child()
```

---

# 🧠 Remember Forever

```text
             Parent
                ↓
       Parent Constructor
                ↓
             super()
                ↓
       Child Constructor
```

### One-line memory trick:

> **Child object → Parent constructor first → Child constructor next.**

### 🔥 Interview Answer

> **Constructor chaining is the process in which constructors execute in a sequence through an inheritance hierarchy. When a child object is created, the child constructor invokes the immediate parent constructor using `super()`. If no explicit constructor invocation is written, an implicit `super()` is inserted when applicable. Therefore, the parent constructor executes before the child constructor.**
