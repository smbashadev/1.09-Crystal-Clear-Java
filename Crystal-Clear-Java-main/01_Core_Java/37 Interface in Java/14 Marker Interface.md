# 🧒 Marker Interface

A **Marker Interface** is an interface that contains **no methods and no fields**. It is used to **mark/tag a class** so that Java or a framework can give special treatment to objects of that class.

---

## 1️⃣ Empty Interface

An ordinary interface contains method declarations:

```java
interface Animal {

    void eat();
}
```

But a marker interface is **empty**:

```java
interface MyMarker {
}
```

There is:

* ❌ No abstract method
* ❌ No default method
* ❌ No static method
* ❌ No variables

It simply acts as a **tag**.

```text
MyMarker
   ↓
Empty interface
   ↓
Acts as a tag/marker
```

---

# 2️⃣ Why Is It Called a Marker?

Imagine a school putting a sticker on certain students:

```text
Student
   ↓
"Special Permission" tag
   ↓
Special treatment
```

Similarly:

```java
class Student implements MyMarker {
}
```

The class has been **marked/tagged**.

Some Java APIs or frameworks can check whether an object implements a particular marker interface and then provide special behavior.

---

# 3️⃣ `Serializable` Example ⭐

One famous marker interface is:

```java
java.io.Serializable
```

Example:

```java
import java.io.Serializable;

class Employee implements Serializable {

    int id;
    String name;
}
```

`Serializable` doesn't require you to implement a method.

Instead:

```text
Employee
   ↓
implements Serializable
   ↓
Marked as serializable
   ↓
Java serialization mechanism can process it
```

So the interface acts as a **capability/marker**.

---

# 4️⃣ `Cloneable` Example

Another classic example is:

```java
java.lang.Cloneable
```

Example:

```java
class Employee implements Cloneable {

    int id;
}
```

`Cloneable` is also an empty interface.

It signals to Java's cloning mechanism that objects of this class are eligible for cloning through `Object.clone()`.

```text
Employee
   ↓
implements Cloneable
   ↓
Marked as cloneable
```

---

# 5️⃣ Important: No Methods to Implement

Compare these:

### Normal interface

```java
interface Animal {

    void eat();
}
```

Implementing class must provide:

```java
public void eat() {
    // implementation
}
```

### Marker interface

```java
interface MyMarker {
}
```

Implementing class:

```java
class Dog implements MyMarker {
}
```

Nothing needs to be implemented.

---

# ⭐ Marker Interface vs Normal Interface

| Marker Interface             | Normal Interface                                          |
| ---------------------------- | --------------------------------------------------------- |
| Empty interface              | Usually contains method contracts                         |
| No methods to implement      | Implementing class may need to implement abstract methods |
| Acts as a tag/marker         | Defines a contract                                        |
| Can trigger special handling | Defines expected behavior                                 |
| `Serializable`               | `Runnable`                                                |
| `Cloneable`                  | `Comparable`                                              |

---

# 🧠 Easy Memory Trick

Think:

```text
MARKER INTERFACE
       ↓
    Empty
       ↓
     Tag
       ↓
Class gets marked
       ↓
Special treatment/capability
```

### 🔥 Interview Answer

> **A marker interface is an empty interface used to mark or tag a class. It does not define methods that the implementing class must implement. The marker can be recognized by Java or other APIs to provide special treatment or indicate a particular capability. Common examples include `Serializable` and `Cloneable`.**
