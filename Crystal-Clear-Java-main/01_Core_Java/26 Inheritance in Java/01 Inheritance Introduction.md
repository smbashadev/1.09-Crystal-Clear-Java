# 🧒 Inheritance in Java

**Inheritance** is one of the major pillars of **Object-Oriented Programming (OOP)**.

The easiest way to understand it is:

> 🧠 **Inheritance allows one class to acquire the properties and behaviors of another class.**

It helps us **reuse existing code** instead of writing the same code again.

---

# 1. What Is Inheritance?

Imagine a parent and child.

A parent may have:

```text
Name
Age
House
```

The child may get some characteristics from the parent.

Similarly, in Java:

```text
Parent Class
     ↓
 Child Class
```

The child class can use members inherited from the parent, subject to Java's access rules.

---

# 2. Parent Class 👨

The class whose properties and behaviors are inherited is called the **parent class**.

It is also commonly called:

* Superclass
* Base class

Example:

```java id="z4e1jv"
class Animal {

    String name;

    void eat() {
        System.out.println("Animal is eating");
    }
}
```

Here:

```text id="j8z2ar"
Animal
   ↓
Parent class
```

---

# 3. Child Class 👶

The class that inherits from the parent is called the **child class**.

It is also commonly called:

* Subclass
* Derived class

Example:

```java id="z7x8k5"
class Dog extends Animal {

    void bark() {
        System.out.println("Dog is barking");
    }
}
```

Here:

```text id="v8f6y9"
Animal
  ↓
Parent

Dog
  ↓
Child
```

---

# 4. The `extends` Keyword

This is the keyword that establishes class inheritance:

```java id="9x0t7b"
class Dog extends Animal
```

Read it as:

> **Dog extends Animal.**

In simple words:

> **Dog is inheriting from Animal.**

The relationship becomes:

```text id="7j5nqk"
Animal
   ↑
   │ extends
   │
  Dog
```

---

# 5. Properties

A class can contain data members.

For example:

```java id="f0o3zq"
class Animal {

    String name;
    int age;
}
```

Here:

```text id="f5q7yq"
name → property
age  → property
```

A child class can inherit accessible properties from its parent.

For example:

```java id="3jq1lo"
class Dog extends Animal {
}
```

A `Dog` object can use inherited members such as `name` and `age` when they are accessible.

---

# 6. Behaviors

Methods represent behaviors.

Example:

```java id="2ah5qb"
class Animal {

    void eat() {
        System.out.println("Animal is eating");
    }

    void sleep() {
        System.out.println("Animal is sleeping");
    }
}
```

Here:

```text id="0g1d9b"
eat()   → behavior
sleep() → behavior
```

A child class can inherit these accessible methods.

---

# 7. Complete Simple Example

```java id="d0tb2k"
class Animal {

    String name = "Tommy";

    void eat() {
        System.out.println("Animal is eating");
    }
}

class Dog extends Animal {

    void bark() {
        System.out.println("Dog is barking");
    }
}

class Demo {

    public static void main(String[] args) {

        Dog d = new Dog();

        System.out.println(d.name);

        d.eat();

        d.bark();
    }
}
```

### Output

```text id="5s2j5j"
Tommy
Animal is eating
Dog is barking
```

---

# 8. What Happened Here?

We have:

```text id="iyr6y7"
             Animal
               │
        ┌──────┴──────┐
        │             │
       name          eat()
        │             │
        └──────┬──────┘
               ↓
              Dog
               │
              bark()
```

`Dog` gets the accessible members from `Animal`.

So:

```java id="3j1b4u"
d.name
```

comes from `Animal`.

And:

```java id="w4a7kt"
d.eat();
```

comes from `Animal`.

While:

```java id="x8k3bs"
d.bark();
```

belongs to `Dog` itself.

---

# 9. Why Do We Need Inheritance?

Imagine we have:

```text id="k4p8x2"
Animal
 ├── eat()
 ├── sleep()
 └── breathe()
```

Now we create:

```text id="n3l1hz"
Dog
 ├── eat()
 ├── sleep()
 ├── breathe()
 └── bark()
```

If we don't use inheritance, we might have to write:

```text id="u8c4ma"
eat()
sleep()
breathe()
```

again inside `Dog`.

That's unnecessary repetition.

With inheritance:

```text id="r7m0wx"
Animal
  ↓
Dog
```

Dog can reuse the common functionality.

---

# 10. Code Reusability ♻️

This is one of the major benefits of inheritance.

Suppose:

```java id="h2w4yd"
class Animal {

    void eat() {
        System.out.println("Eating");
    }
}
```

Then:

```java id="w0z5bx"
class Dog extends Animal {
}
```

We don't need to rewrite `eat()` inside `Dog`.

We can simply use:

```java id="1m3x8a"
Dog d = new Dog();

d.eat();
```

So:

```text id="7j9p4c"
Write once
   ↓
Parent class
   ↓
Reuse in child
```

That's **code reusability**.

---

# 11. Is-A Relationship

Inheritance represents an **Is-A relationship**.

For example:

```text id="q1m7nx"
Dog IS-A Animal
```

because:

```java id="v6f8j2"
class Dog extends Animal
```

Similarly:

```text id="a4c9kp"
Cat IS-A Animal
Car IS-A Vehicle
Employee IS-A Person
```

when those relationships are modeled using inheritance.

---

# 12. Think Like a Fifth-Class Student 🧒

Imagine:

```text id="x8z3va"
ANIMAL
```

is a big box containing common things:

```text id="6u5m8n"
Animal
 ├── eat
 ├── sleep
 └── breathe
```

Now `Dog` says:

> "I am an Animal, so I can use those common things. I will also have my own special behavior."

```text id="q9r2ks"
Dog
 ├── eat       ← inherited
 ├── sleep     ← inherited
 ├── breathe   ← inherited
 └── bark      ← Dog's own
```

That's inheritance.

---

# 13. Visual Memory 🧠

```text id="6e2q9j"
                 PARENT
                Animal
                   │
             ┌─────┴─────┐
             │           │
          Properties   Behaviors
             │           │
          name, age   eat(), sleep()
             │           │
             └─────┬─────┘
                   ↓
                 CHILD
                  Dog
                   │
             ┌─────┴─────┐
             ↓           ↓
        Inherited      Own
        members       members
           ↓             ↓
        eat()          bark()
        name
```

---

# ⭐ Golden Rule

> **Inheritance is an OOP mechanism in which a child class acquires accessible properties and behaviors from a parent class using the `extends` keyword, providing code reusability and establishing an Is-A relationship.**

### 🧠 Remember Forever:

```text id="c9q4tm"
Parent
   ↓
extends
   ↓
Child
   ↓
Reuse properties + behaviors
   ↓
Code reusability
   ↓
Is-A relationship
```

### 🔥 Interview Answer

> **Inheritance is an OOP pillar that allows a child class to acquire accessible properties and behaviors of a parent class using the `extends` keyword. It promotes code reusability and represents an Is-A relationship.**
