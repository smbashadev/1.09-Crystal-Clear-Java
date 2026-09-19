# 🧒 Interface Object / Reference

The key rule is:

> 🔒 **We cannot create an object directly from an interface, but we can create an interface reference that points to an object of an implementing class.**

---

## 1. Cannot Instantiate an Interface ❌

Suppose we have:

```java
interface Animal {

    void eat();
}
```

We cannot do:

```java
Animal a = new Animal();   // ❌ Compile-time error
```

An interface is a contract, not a class from which we directly create an object.

```text
Interface
   ↓
new Interface()
   ↓
❌ Not allowed
```

---

# 2. Interface Reference ✅

Although we cannot create an interface object, we **can create an interface reference**:

```java
Animal a;
```

This is completely valid.

```text
Animal a
   ↓
Interface reference ✅
```

But by itself, `a` doesn't refer to any object yet.

---

# 3. Implementing Class Object ✅

Create a class that implements the interface:

```java
class Dog implements Animal {

    @Override
    public void eat() {

        System.out.println("Dog eats");
    }
}
```

Now:

```java
Animal a = new Dog();
```

This is valid.

Here:

```text
Reference type → Animal
Object type    → Dog
```

Diagram:

```text
          Animal
        (interface)
             ↑
             │ implements
             │
            Dog
          (object)
```

---

# 4. Polymorphism ⭐

This is one of the major uses of an interface reference.

Suppose we have another implementation:

```java
class Cat implements Animal {

    @Override
    public void eat() {

        System.out.println("Cat eats");
    }
}
```

Now the same interface reference can point to different objects:

```java
Animal a;

a = new Dog();
a.eat();

a = new Cat();
a.eat();
```

### Output

```text
Dog eats
Cat eats
```

The reference is:

```java
Animal a;
```

but the actual object changes:

```text
       Animal reference
              │
       ┌──────┴──────┐
       ↓             ↓
   Dog object     Cat object
       ↓             ↓
    Dog.eat()      Cat.eat()
```

This is **runtime polymorphism**.

---

# 5. Complete Program

```java
interface Animal {

    void eat();
}

class Dog implements Animal {

    @Override
    public void eat() {

        System.out.println("Dog eats");
    }
}

class Cat implements Animal {

    @Override
    public void eat() {

        System.out.println("Cat eats");
    }
}

class Demo {

    public static void main(String[] args) {

        // Animal a = new Animal();   // ❌ Cannot instantiate interface

        Animal a;                     // ✅ Interface reference

        a = new Dog();                // ✅ Implementing class object
        a.eat();

        a = new Cat();                // ✅ Another implementation
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

# 🧠 Interface vs Abstract Class

The pattern is very similar:

### Abstract class

```java
Animal a = new Dog();
```

### Interface

```java
Animal a = new Dog();
```

In both cases:

```text
Parent-type reference
        ↓
Child/implementing class object
        ↓
Runtime polymorphism
```

---

# ⭐ Three Important Rules

### 1️⃣ Interface object

```java
new Animal();
```

❌ Not allowed.

### 2️⃣ Interface reference

```java
Animal a;
```

✅ Allowed.

### 3️⃣ Interface reference + implementing class object

```java
Animal a = new Dog();
```

✅ Allowed.

And:

```java
a.eat();
```

➡️ `Dog`'s implementation executes.

---

# 🔥 Golden Rule

```text
Interface
    ↓
Cannot instantiate ❌
    ↓
Can create reference ✅
    ↓
Reference can point to implementing-class object
    ↓
Runtime polymorphism ✅
```

### Interview Answer

> **An interface cannot be instantiated directly, but we can create a reference variable of the interface type. That reference can point to an object of a class that implements the interface, such as `Animal a = new Dog();`. This allows us to achieve runtime polymorphism.**
