# 🧒 `default` Access Specifier in Java

In Java, when we **do not write any access specifier** such as `public`, `protected`, or `private`, Java gives the member **default access**.

> 🧠 **Default means: accessible only within the same package.**

Think of it like:

```text
default
   ↓
Same package → ✅
Different package → ❌
```

---

## 1. Example of Default Variable

```java
class Student {

    int age = 25;   // default access

}
```

Notice that we didn't write:

```java
public
protected
private
```

We simply wrote:

```java
int age = 25;
```

Therefore, `age` has **default access**.

---

# 2. Same Package → Accessible ✅

Suppose both classes are inside `pack1`.

### `Student.java`

```java
package pack1;

public class Student {

    int age = 25;
}
```

Here:

```java
int age = 25;
```

has default access.

Now another class in the **same package**:

### `Demo.java`

```java
package pack1;

class Demo {

    public static void main(String[] args) {

        Student s = new Student();

        System.out.println(s.age);
    }
}
```

### Output

```text
25
```

Why?

Both classes are in:

```text
pack1
```

Therefore:

```text
Student
   ↓
default age
   ↓
Demo (same package)
   ↓
ACCESS ✅
```

---

# 3. Different Package → Not Accessible ❌

Suppose `Student` is in:

```text
pack1
```

and `Demo` is in:

```text
pack2
```

### `Student.java`

```java
package pack1;

public class Student {

    int age = 25;
}
```

### `Demo.java`

```java
package pack2;

import pack1.Student;

class Demo {

    public static void main(String[] args) {

        Student s = new Student();

        System.out.println(s.age);  // ❌ Compile-time error
    }
}
```

This produces a **compile-time error** because `age` has default access.

```text
pack1
  ↓
Student
  ↓
default age
  ↓
pack2
  ↓
ACCESS ❌
```

---

# 4. Why Is It Called Package-Level Access?

Because default access is limited to the **same package**.

```text
┌──────────────────────┐
│       pack1          │
│                      │
│  Student             │
│     ↓                │
│  default age         │
│     ↓                │
│  Demo                │
│                      │
│  ACCESS ✅            │
└──────────────────────┘

          ❌

┌──────────────────────┐
│       pack2          │
│                      │
│  OtherClass          │
│                      │
│  ACCESS ❌            │
└──────────────────────┘
```

---

# 5. Default Method

Default access also applies to methods.

```java
package pack1;

public class Student {

    void display() {

        System.out.println("Hello Student");
    }
}
```

Another class in the same package:

```java
package pack1;

class Demo {

    public static void main(String[] args) {

        Student s = new Student();

        s.display();
    }
}
```

Output:

```text
Hello Student
```

Because `Demo` and `Student` are in the same package.

---

# 6. Complete Program

### `Student.java`

```java
package pack1;

public class Student {

    int age = 25;

    void display() {

        System.out.println("Age = " + age);
    }
}
```

### `Demo.java`

```java
package pack1;

class Demo {

    public static void main(String[] args) {

        Student s = new Student();

        System.out.println(s.age);

        s.display();
    }
}
```

### Output

```text
25
Age = 25
```

Both the variable and method are accessible because they have **default access** and the classes are in the same package.

---

# 🧠 Easy Comparison

| Access      | Same Class | Same Package | Child in Different Package | Different Package |
| ----------- | ---------- | ------------ | -------------------------- | ----------------- |
| `public`    | ✅          | ✅            | ✅                          | ✅                 |
| `protected` | ✅          | ✅            | ✅                          | ❌*                |
| `default`   | ✅          | ✅            | ❌                          | ❌                 |
| `private`   | ✅          | ❌            | ❌                          | ❌                 |

*For `protected`, a subclass in another package can access the inherited protected member through the subclass relationship, subject to Java's protected-access rules.

---

# ⭐ Remember Forever

### Default means:

> **No access modifier is written.**

Example:

```java
int age = 25;
```

```java
void display() {
}
```

### Golden Rule:

```text
default
   ↓
Same package → ✅
Different package → ❌
```

### 🔥 Interview Answer

> **Default access is the access level provided when no access modifier is specified. A default member can be accessed only by classes within the same package and cannot be directly accessed from a different package.**
