## 🧒 Pre-defined Methods

**Pre-defined methods** are methods that are **already written and provided through Java's standard libraries/APIs**.

You don't need to write their internal code yourself. You simply **call them when you need their functionality**.

### 🧰 Think of them as ready-made tools

```text
Java team writes method
        ↓
Java provides it
        ↓
You call the method
        ↓
Java performs the task
```

---

## 1️⃣ `println()`

Used to **print something and move to the next line**.

```java
System.out.println("Hello");
System.out.println("Java");
```

Output:

```text
Hello
Java
```

---

## 2️⃣ `print()`

Used to **print something without automatically moving to the next line**.

```java
System.out.print("Hello ");
System.out.print("Java");
```

Output:

```text
Hello Java
```

---

## 3️⃣ `equals()`

Used to **compare the contents of objects**, commonly Strings.

```java
String a = "Java";
String b = "Java";

System.out.println(a.equals(b));
```

Output:

```text
true
```

Think:

```text
"Java"
   ↓
equals()
   ↓
"Java"
   ↓
true
```

For `String`, `equals()` checks whether the **text/content is equal**.

---

## 4️⃣ `toLowerCase()`

Used to convert a String to **lowercase**.

```java
String name = "JAVA";

System.out.println(name.toLowerCase());
```

Output:

```text
java
```

Think:

```text
"JAVA"
   ↓
toLowerCase()
   ↓
"java"
```

---

## 🔍 All Four Together

```java
class Demo {
    public static void main(String[] args) {

        System.out.println("Hello Java");

        System.out.print("Hello ");
        System.out.print("World");

        String a = "Java";
        String b = "Java";

        System.out.println(a.equals(b));

        String name = "JAVA";
        System.out.println(name.toLowerCase());
    }
}
```

Output:

```text
Hello Java
Hello Worldtrue
java
```

---

## 🧠 Remember

| Method          | Purpose                         |
| --------------- | ------------------------------- |
| `println()`     | Print + next line               |
| `print()`       | Print + stay on same line       |
| `equals()`      | Compare object/content equality |
| `toLowerCase()` | Convert String to lowercase     |

### 🔑 Golden Rule

> **Pre-defined method = Already provided by Java API → We call it → Java performs the functionality.**

```text
println()       → Print
print()         → Print
equals()        → Compare
toLowerCase()   → Convert to lowercase
```
