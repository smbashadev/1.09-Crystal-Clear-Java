# 🧒 Rule of Method Overriding: Return Type

When a child class **overrides** a parent method, the return type must follow certain rules.

The basic rule is:

> 🧠 **The child method can have the same return type or a compatible return type.**

For **non-primitive/reference types**, this is called a **covariant return type**.

---

## 1. Same Return Type ✅

Parent:

```java
class Parent {

    Object getData() {
        return new Object();
    }
}
```

Child:

```java
class Child extends Parent {

    @Override
    Object getData() {
        return new Object();
    }
}
```

Both return:

```text
Parent → Object
Child  → Object
```

✅ Same return type → valid overriding.

---

# 2. Compatible Return Type — Covariant Return Type ⭐

Suppose the parent returns:

```java
Animal
```

and the child returns:

```java
Dog
```

where:

```text
Dog IS-A Animal
```

Then the child is allowed to return `Dog`.

### Parent

```java
class Animal {
}
```

```java
class Parent {

    Animal getAnimal() {
        return new Animal();
    }
}
```

### Child

```java
class Dog extends Animal {
}
```

```java
class Child extends Parent {

    @Override
    Dog getAnimal() {
        return new Dog();
    }
}
```

This is valid because:

```text
Dog
 ↓
IS-A
 ↓
Animal
```

So:

```text
Parent method → Animal
Child method  → Dog
```

`Dog` is a more specific type than `Animal`.

This is called a:

> **Covariant return type**

---

# 3. What Does "Covariant" Mean?

Don't let the word scare you. 😄

Just remember:

```text
Parent returns → General type
Child returns  → More specific child type
```

Example:

```text
Animal
   ↑
   │
  Dog
```

Therefore:

```text
Parent → Animal
Child  → Dog
```

✅ Valid.

---

# 4. Complete Program

```java
class Animal {

}

class Dog extends Animal {

}

class Parent {

    Animal getAnimal() {
        return new Animal();
    }
}

class Child extends Parent {

    @Override
    Dog getAnimal() {
        return new Dog();
    }
}

class Demo {

    public static void main(String[] args) {

        Parent p = new Child();

        Animal a = p.getAnimal();

        System.out.println(a);
    }
}
```

Here:

```text
Parent.getAnimal()
        ↓
Animal

Child.getAnimal()
        ↓
Dog
```

And:

```text
Dog IS-A Animal
```

Therefore the overriding is valid.

---

# 5. Why Only Non-Primitive Types?

**Covariant return types apply to reference/non-primitive types**, such as:

```text
Animal
Dog
Object
String
Employee
Manager
```

They can have an **IS-A relationship**.

For example:

```text
Dog IS-A Animal
Manager IS-A Employee
```

But primitive types don't work this way.

For example:

```java
class Parent {

    int getValue() {
        return 10;
    }
}
```

You cannot override it with:

```java
class Child extends Parent {

    @Override
    long getValue() {       // ❌
        return 10;
    }
}
```

Even though `int` can normally be converted to `long`, this is **not** a covariant return type.

The return type must be the same for primitive return types.

---

# 6. Invalid Example ❌

Parent:

```java
class Parent {

    Animal getAnimal() {
        return new Animal();
    }
}
```

Suppose:

```java
class Cat {
}
```

and `Cat` does **not** extend `Animal`.

Then:

```java
class Child extends Parent {

    @Override
    Cat getAnimal() {       // ❌
        return new Cat();
    }
}
```

Why?

Because:

```text
Cat IS-A Animal ❌
```

There is no valid parent-child relationship between them.

---

# 🧠 Easy Diagram

### Valid:

```text
        Animal
          ↑
          │
         Dog

Parent → Animal
Child  → Dog

Dog IS-A Animal
      ↓
Covariant return type ✅
```

### Invalid:

```text
        Animal

        Cat

Cat IS-A Animal ❌

Parent → Animal
Child  → Cat

Covariant return type ❌
```

---

# ⭐ Return Type Rules — Quick Table

| Parent return type | Child return type | Valid?                    |
| ------------------ | ----------------- | ------------------------- |
| `int`              | `int`             | ✅                         |
| `int`              | `long`            | ❌                         |
| `Animal`           | `Animal`          | ✅                         |
| `Animal`           | `Dog`             | ✅                         |
| `Animal`           | `Cat`             | ✅ if `Cat extends Animal` |
| `Animal`           | `String`          | ❌ if unrelated            |

---

# 🔥 Golden Rule

For **method overriding**:

```text
Primitive return type
       ↓
Same return type only
```

For **non-primitive/reference return type**:

```text
Same type
    OR
Child/subtype of parent's return type
    ↓
Covariant return type
```

### Remember:

> **Parent returns Animal → Child can return Dog, because Dog IS-A Animal.**

```text
Same return type       → ✅
Compatible return type → ✅
IS-A relationship      → ✅
Covariant return type  → Non-primitive/reference types
```
