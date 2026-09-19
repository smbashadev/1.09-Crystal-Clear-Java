# 🧒 Abstract Class Cannot Be Instantiated

The most important restriction of an **abstract class** is:

> 🔒 **We cannot directly create an object of an abstract class.**

---

## 1. Example

```java
abstract class Animal {

    void eat() {
        System.out.println("Animal eats");
    }
}
```

This is **not allowed**:

```java
Animal a = new Animal();   // ❌ Compile-time error
```

Why?

Because `Animal` is declared as:

```java
abstract class Animal
```

So Java does not allow:

```text
abstract class
     ↓
new Animal()
     ↓
❌ Not allowed
```

---

## 2. But Reference Is Allowed ✅

We can create a reference variable:

```java
Animal a;
```

This is valid.

And the reference can point to a concrete child object:

```java
class Dog extends Animal {
}
```

```java
Animal a = new Dog();   // ✅
```

Here:

```text
Reference → Animal
Object    → Dog
```

---

## 3. Why Is This Useful?

This allows **runtime polymorphism**.

```java
abstract class Animal {

    abstract void sound();
}

class Dog extends Animal {

    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}

class Cat extends Animal {

    @Override
    void sound() {
        System.out.println("Cat meows");
    }
}
```

Now:

```java
Animal a = new Dog();
a.sound();

a = new Cat();
a.sound();
```

Output:

```text
Dog barks
Cat meows
```

The abstract class provides the **common parent reference**, while different child objects provide the actual behavior.

---

# ⭐ Remember

```text
Abstract class
      ↓
Direct object creation ❌

Abstract class reference
      ↓
Allowed ✅

Abstract reference
      ↓
Child object
      ↓
Runtime polymorphism ✅
```

### Interview Answer

> **An abstract class cannot be instantiated directly, meaning we cannot create its object using `new`. However, we can create a reference variable of the abstract class type and use it to refer to an object of a concrete child class.**
