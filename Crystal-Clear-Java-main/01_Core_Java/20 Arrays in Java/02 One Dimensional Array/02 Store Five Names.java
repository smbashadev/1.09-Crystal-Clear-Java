## 🧒 One-Dimensional Array Program — Store Five Names

We can use a **one-dimensional `String` array** to store five student names.

Think of it like **5 boxes in one row**:

```text
Index:    0        1        2        3        4
        ┌──────┬──────┬──────┬──────┬──────┐
        │ Basha│ Rahul│ Priya│ John │ Anu  │
        └──────┴──────┴──────┴──────┴──────┘
```

---

### ✅ Complete Program

```java
class Names {

    public static void main(String[] args) {

        // Declaration and creation
        String[] names = new String[5];

        // Store five names
        names[0] = "Basha";
        names[1] = "Rahul";
        names[2] = "Priya";
        names[3] = "John";
        names[4] = "Anu";

        // Access and print names
        System.out.println(names[0]);
        System.out.println(names[1]);
        System.out.println(names[2]);
        System.out.println(names[3]);
        System.out.println(names[4]);
    }
}
```

### Output

```text
Basha
Rahul
Priya
John
Anu
```

---

### 🧠 What Happened?

**1. Create an array of 5 spaces:**

```java
String[] names = new String[5];
```

**2. Store names using indexes:**

```text
names[0] → Basha
names[1] → Rahul
names[2] → Priya
names[3] → John
names[4] → Anu
```

**3. Access the names:**

```java
System.out.println(names[0]);
```

This prints:

```text
Basha
```

### 🔑 Remember

> **Array stores multiple values of the same type.**

> **One-dimensional array = values arranged in one row.**

> **Five elements → indexes 0, 1, 2, 3, 4.**
