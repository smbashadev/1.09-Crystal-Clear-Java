# 🧒 Cyclic Inheritance in Java

**Cyclic Inheritance** means classes try to inherit from each other in a **circle**.

> 🧠 **A class cannot be both a parent and a child of itself, directly or indirectly.**

Java **does not permit cyclic inheritance**.

---

# 1. Simple Example

Suppose we create two classes:

```java
class Parent extends Child {
}
```

and:

```java
class Child extends Parent {
}
```

Now look at the relationship:

```text
Parent
  ↓
extends
  ↓
Child
  ↓
extends
  ↓
Parent
```

The inheritance comes back to `Parent`.

That's a **cycle** 🔄.

---

# 2. Why Is This a Problem?

Imagine asking:

> "Who is the parent of `Parent`?"

We get:

```text
Parent → Child
```

But then:

> "Who is the parent of `Child`?"

We get:

```text
Child → Parent
```

So Java would have:

```text
Parent
   ↓
Child
   ↓
Parent
   ↓
Child
   ↓
...
```

It never ends. 🔄

Java therefore rejects this relationship.

---

# 3. Invalid Program ❌

```java
class Parent extends Child {

}

class Child extends Parent {

}
```

This results in a **compile-time error**.

The reason is that the inheritance hierarchy becomes cyclic.

---

# 4. Think of a Family Tree 👨‍👩‍👦

Normally, a family tree goes in one direction:

```text
Grandparent
     ↓
  Parent
     ↓
   Child
```

That's normal.

But imagine:

```text
Parent
  ↓
Child
  ↓
Parent
```

Now the family tree has formed a circle.

That doesn't make sense.

Java similarly doesn't allow an inheritance circle.

---

# 5. Direct Cyclic Inheritance

The simplest invalid situation is:

```text
A → B
↑   ↓
└───┘
```

For example:

```java
class A extends B {
}

class B extends A {
}
```

❌ Not allowed.

---

# 6. Indirect Cyclic Inheritance

A cycle can also involve more than two classes.

For example:

```java
class A extends B {
}

class B extends C {
}

class C extends A {
}
```

The relationship is:

```text
A
↓
B
↓
C
↓
A
```

Again, we return to where we started.

❌ Java does not allow this.

---

# 7. What Normal Inheritance Looks Like

Normal inheritance has a clear direction:

```text
Animal
   ↓
Mammal
   ↓
Dog
```

It stops at `Dog`.

There is no path back to `Animal`.

That's valid.

```java
class Animal {
}

class Mammal extends Animal {
}

class Dog extends Mammal {
}
```

✅ Valid.

---

# 8. Cyclic vs Normal Inheritance

| Normal Inheritance        | Cyclic Inheritance              |
| ------------------------- | ------------------------------- |
| Has a clear direction     | Forms a circle                  |
| Parent → Child            | Parent → Child → Parent         |
| Allowed ✅                 | Not allowed ❌                   |
| Hierarchy eventually ends | Hierarchy never has a valid end |
| Example: `Animal → Dog`   | Example: `Parent ↔ Child`       |

---

# 🧠 Visual Memory

### ✅ Correct

```text
Parent
   ↓
Child
   ↓
Grandchild
```

### ❌ Wrong

```text
Parent
   ↓
Child
   ↓
Parent
   ↺
```

---

# ⭐ Remember Forever

> **Cyclic inheritance occurs when inheritance forms a cycle, either directly or indirectly. Java does not permit it because a class cannot ultimately inherit from itself.**

### Your example:

```text
Parent
   ↓
Child
   ↓
Parent
```

❌ **Not permitted**

### 🔥 Interview Answer

> **Cyclic inheritance is an inheritance relationship in which classes depend on each other in a cycle. For example, if `Parent extends Child` and `Child extends Parent`, a cyclic inheritance is created. Java does not permit cyclic inheritance because a class cannot inherit from itself, directly or indirectly.**
