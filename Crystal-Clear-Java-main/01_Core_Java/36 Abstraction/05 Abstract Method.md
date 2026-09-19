# 🧒 Abstract Method

An **abstract method** is a method for which we define **what the method should be called and what it should return**, but we don't provide its implementation in the parent class.

In simple words:

> 🧠 **Parent says "this method must exist," and the child class decides "how it works."**

---

# 1. Abstract Method Has Only a Method Signature

An abstract method contains a **method signature**, but **no method body**.

### Syntax

```java
abstract returnType methodName();
```

Example:

```java
abstract void start();
```

Here:

```text id="9qv5dy"
abstract → keyword
void     → return type
start    → method name
()       → parameter list
;        → no method body
```

There is **no `{ }` body**.

---

# 2. Normal Method vs Abstract Method

### Normal Method

```java
void start() {

    System.out.println("Vehicle started");
}
```

It has:

```text id="5t8y5w"
Method signature
      +
Method body
```

### Abstract Method

```java
abstract void start();
```

It has:

```text id="r8w2v4"
Method signature
      +
No method body
```

---

# 3. Abstract Method Is a Mandatory Method

Suppose the parent says:

```java
abstract class Vehicle {

    abstract void start();
}
```

The parent is basically telling its concrete child:

> **"You must provide `start()`."**

For example:

```java
class Car extends Vehicle {

    @Override
    void start() {

        System.out.println("Car starts");
    }
}
```

The child provides the implementation.

---

# 4. Child Class Provides Implementation

Parent:

```java
abstract class Vehicle {

    abstract void start();
}
```

Child:

```java
class Car extends Vehicle {

    @Override
    void start() {

        System.out.println("Car starts with a key");
    }
}
```

So:

```text id="q5w8ge"
Vehicle
   │
   └── abstract start()
             ↓
       "You must implement me"
             ↓
           Car
             ↓
       start() implementation
```

---

# 5. Complete Program

```java
abstract class Vehicle {

    abstract void start();
}

class Car extends Vehicle {

    @Override
    void start() {

        System.out.println("Car starts with a key");
    }
}

class Demo {

    public static void main(String[] args) {

        Vehicle v = new Car();

        v.start();
    }
}
```

### Output

```text
Car starts with a key
```

Here:

```java
Vehicle v = new Car();
```

is also an example of **runtime polymorphism**.

---

# 6. What If Child Doesn't Implement It?

Suppose:

```java
abstract class Vehicle {

    abstract void start();
}
```

and:

```java
class Car extends Vehicle {

}
```

❌ This is not allowed because `Car` is a concrete class and has not implemented the inherited abstract method.

The compiler will require `Car` to implement:

```java
void start()
```

---

# 7. But an Abstract Child Can Delay Implementation

There is one important exception.

An **abstract child class** doesn't have to implement the abstract method immediately.

```java
abstract class Vehicle {

    abstract void start();
}
```

Then:

```java
abstract class Car extends Vehicle {

}
```

This is valid.

Why?

Because `Car` is also abstract.

The responsibility can be passed to a further concrete child:

```java
class SportsCar extends Car {

    @Override
    void start() {

        System.out.println("SportsCar starts");
    }
}
```

So:

```text id="c3c5z4"
Vehicle
   ↓
abstract start()
   ↓
abstract Car
   ↓
concrete SportsCar
   ↓
implements start()
```

---

# 8. If a Class Contains an Abstract Method...

This is an important Java rule:

> 🔥 **If a class contains at least one abstract method, that class must be declared abstract.**

Invalid:

```java
class Vehicle {

    abstract void start();   // ❌
}
```

The class itself is not abstract.

Correct:

```java
abstract class Vehicle {

    abstract void start();   // ✅
}
```

---

# 🧠 Why?

An abstract method has no implementation:

```java
abstract void start();
```

So Java doesn't want you creating a normal concrete class that has an incomplete method.

Therefore:

```text id="6o8r0v"
Abstract method
      ↓
Class must be abstract
```

---

# ⭐ Important Rules

| Rule                                              | Result |
| ------------------------------------------------- | ------ |
| Abstract method has a body                        | ❌      |
| Abstract method has no body                       | ✅      |
| Abstract method ends with `;`                     | ✅      |
| Child concrete class implements it                | ✅      |
| Child doesn't implement it                        | ❌      |
| Abstract child can leave it unimplemented         | ✅      |
| Class containing abstract method must be abstract | ✅      |

---

# 🔥 Remember Forever

```text id="u6y0lq"
abstract void start();
        ↓
Method signature
        ↓
No body
        ↓
Mandatory for concrete child
        ↓
Child provides implementation
```

And the biggest rule:

```text id="r7h8zj"
If class contains
abstract method
      ↓
class MUST be abstract
```

### Interview Answer

> **An abstract method is a method declared with the `abstract` keyword that contains only a method signature and no implementation body. It acts as a mandatory contract for concrete subclasses, which must provide its implementation. If a class contains an abstract method, the class itself must be declared abstract.**
