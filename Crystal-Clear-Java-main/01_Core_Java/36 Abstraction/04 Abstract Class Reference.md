# 🧒 Abstract Class Reference

An **abstract class reference** is simply a reference variable whose type is an abstract class.

The important pattern is:

```java
AbstractClass reference = new ChildClass();
```

This is completely valid and is commonly used to achieve **runtime polymorphism**.

---

## 1. Abstract Class Reference

Suppose we have:

```java
abstract class Animal {

    abstract void eat();
}
```

We **cannot** create an object directly:

```java
Animal a = new Animal();   // ❌
```

But we **can create a reference**:

```java
Animal a;
```

✅ This is allowed.

---

# 2. Abstract Reference + Child Object

Now create a child class:

```java
class Dog extends Animal {

    @Override
    void eat() {

        System.out.println("Dog eats");
    }
}
```

Now:

```java
Animal a = new Dog();
```

This means:

```text
Reference type → Animal
Object type    → Dog
```

Diagram:

```text
        Animal
      abstract
          ↑
          │ extends
          │
         Dog
       object
```

---

# 3. Calling the Method

Now:

```java
a.eat();
```

Although the reference type is:

```text
Animal
```

the actual object is:

```text
Dog
```

So the overridden method in `Dog` executes.

```text
a.eat()
   ↓
Dog object
   ↓
Dog.eat()
```

Output:

```text
Dog eats
```

This is **runtime polymorphism**.

---

# 4. Complete Program

```java
abstract class Animal {

    abstract void eat();
}

class Dog extends Animal {

    @Override
    void eat() {

        System.out.println("Dog eats");
    }
}

class Cat extends Animal {

    @Override
    void eat() {

        System.out.println("Cat eats");
    }
}

class Demo {

    public static void main(String[] args) {

        Animal a;

        a = new Dog();
        a.eat();

        a = new Cat();
        a.eat();
    }
}
```

### Output

```text
Dog eats
Cat eats
```

---

# 5. Where Is Polymorphism? ⭐

Look at:

```java
Animal a;
```

The same abstract reference can point to different child objects:

```java
a = new Dog();
```

then:

```java
a = new Cat();
```

So:

```text
             Animal reference
                    │
          ┌─────────┴─────────┐
          ↓                   ↓
      Dog object          Cat object
          ↓                   ↓
      Dog.eat()           Cat.eat()
```

One reference:

```text
Animal a
```

has **multiple forms** depending on the object it refers to.

That's runtime polymorphism.

---

# 🧠 Remember the 3 Things

### 1️⃣ Abstract class object

```java
Animal a = new Animal();
```

❌ Not allowed.

### 2️⃣ Abstract class reference

```java
Animal a;
```

✅ Allowed.

### 3️⃣ Abstract reference + child object

```java
Animal a = new Dog();
```

✅ Allowed.

And:

```java
a.eat();
```

➡️ Child's overridden method executes.

---

# 🔥 Golden Rule

> **An abstract class cannot be instantiated, but its reference can be created and can refer to an object of a concrete child class. This parent-type reference to different child objects is used to achieve runtime polymorphism.**

```text
Abstract class reference
          ↓
   Child class object
          ↓
Overridden method executes
          ↓
Runtime Polymorphism
```
