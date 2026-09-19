# 🧒 Constructor Execution Order

When we create an object of a child class, Java does **not** immediately execute the child constructor.

First, Java goes **up the inheritance hierarchy**.

The basic order is:

```text
Object Constructor
       ↓
Parent Constructor
       ↓
Child Constructor
```

> 🧠 **Bottom-up call, top-down execution.**

---

## 1. Simple Example

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

### Output

```text
Parent constructor
Child constructor
```

The `Object` constructor also participates in the chain, but it doesn't print anything by default.

---

# 2. Why Does `Object` Come First?

Every Java class ultimately has `Object` as its ancestor.

So the hierarchy is:

```text
Object
   ↓
Parent
   ↓
Child
```

When we create:

```java
Child c = new Child();
```

Java conceptually follows:

```text
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

Then the constructors execute back down:

```text
Object()
   ↓
Parent()
   ↓
Child()
```

---

# 3. Complete Flow 🧠

Think of it like climbing stairs:

```text
          Object
            ↑
          Parent
            ↑
          Child
```

When a `Child` object is created:

### Step 1

Java reaches `Object`.

```text
Object constructor
```

### Step 2

Then `Parent` constructor executes.

```text
Parent constructor
```

### Step 3

Finally, `Child` constructor executes.

```text
Child constructor
```

Therefore:

```text
Object constructor
       ↓
Parent constructor
       ↓
Child constructor
```

---

# 4. Multilevel Example

Suppose:

```text
Object
   ↓
Animal
   ↓
Mammal
   ↓
Dog
```

When we create:

```java
Dog d = new Dog();
```

the constructor execution order is:

```text
Object constructor
       ↓
Animal constructor
       ↓
Mammal constructor
       ↓
Dog constructor
```

---

# ⭐ Remember Forever

### Constructor Execution Order

```text
Object
  ↓
Parent
  ↓
Child
```

### Golden Rule 🧠

> **The highest parent constructor executes first, and the child constructor executes last.**

Or remember:

```text
Object → Parent → Child
```

**Parent is constructed before Child.**
