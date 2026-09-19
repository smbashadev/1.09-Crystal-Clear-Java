## 🧒 One-Dimensional Array Program — Print Five Names

We already have an array containing **five names**. Now we want to **print all five names**.

Think of it as five boxes:

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

        // Create and store five names
        String[] names = {
            "Basha",
            "Rahul",
            "Priya",
            "John",
            "Anu"
        };

        // Print five names
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

## 🧠 How It Works

The array contains:

```text
names[0] → Basha
names[1] → Rahul
names[2] → Priya
names[3] → John
names[4] → Anu
```

When we write:

```java
System.out.println(names[0]);
```

Java goes to **index 0** and prints the name stored there.

---

## ⭐ Better Way: Use a `for` Loop

Instead of writing `println()` five times, we can use a loop:

```java
class Names {

    public static void main(String[] args) {

        String[] names = {
            "Basha",
            "Rahul",
            "Priya",
            "John",
            "Anu"
        };

        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i]);
        }
    }
}
```

Output:

```text
Basha
Rahul
Priya
John
Anu
```

### 🔑 Remember

```text
Array
  ↓
Five names
  ↓
Index starts at 0
  ↓
for loop visits each index
  ↓
Print each name
```

> **Array + loop = Easy way to process many values.**
