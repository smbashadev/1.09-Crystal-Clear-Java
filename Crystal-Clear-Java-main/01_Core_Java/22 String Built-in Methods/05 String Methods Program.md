# 🧒 String Methods Program

Let's create **one complete Java program** that demonstrates all the String methods you listed:

1. `length()`
2. `charAt()`
3. `indexOf()`
4. `contains()`
5. `substring(start, end)`
6. `substring(start)`

We will use one String so that you can understand how each method works.

---

## 1. Complete Program

```java
class StringMethodsProgram {

    public static void main(String[] args) {

        String s = "Java Programming";

        // 1. length()
        System.out.println("Length: " + s.length());

        // 2. charAt()
        System.out.println("Character at index 2: " + s.charAt(2));

        // 3. indexOf()
        System.out.println("Index of 'P': " + s.indexOf('P'));

        // 4. contains()
        System.out.println("Contains Java: " + s.contains("Java"));

        // 5. substring(start, end)
        System.out.println("Substring: " + s.substring(0, 4));

        // 6. substring(start)
        System.out.println("Substring from index 5: " + s.substring(5));
    }
}
```

### Output

```text
Length: 16
Character at index 2: v
Index of 'P': 5
Contains Java: true
Substring: Java
Substring from index 5: Programming
```

---

# 2. Understand the String First

Our String is:

```java
String s = "Java Programming";
```

Let's number every character.

```text
Character:  J  a  v  a     P  r  o  g  r  a  m  m  i  n  g
Index:      0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15
```

⚠️ Notice:

> **String indexing starts from `0`.**

There are 16 characters, so the last index is `15`.

---

# 3. `length()`

### Purpose

`length()` tells us:

> **How many characters are in the String?**

```java
System.out.println(s.length());
```

There are 16 characters:

```text
J a v a _ P r o g r a m m i n g
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
```

Therefore:

```text
16
```

### Remember

```text
length() → COUNT
```

---

# 4. `charAt()`

### Purpose

`charAt()` tells us:

> **Which character is present at this index?**

Example:

```java
s.charAt(2)
```

Look at index `2`:

```text
Character:  J  a  v  a
Index:      0  1  2  3
                  ↑
                  v
```

Therefore:

```text
v
```

### Remember

```text
charAt(index) → CHARACTER
```

---

# 5. `indexOf()`

### Purpose

`indexOf()` tells us:

> **At which index does a particular character/String first appear?**

Example:

```java
s.indexOf('P')
```

Our String:

```text
J a v a   P r o g r a m m i n g
0 1 2 3 4 5 6 7 8 9...
          ↑
          P
```

`P` is at index `5`.

Therefore:

```text
5
```

### Remember

```text
indexOf() → WHERE?
```

---

# 6. `contains()`

### Purpose

`contains()` checks:

> **Does this String contain a particular sequence of characters?**

Example:

```java
s.contains("Java")
```

Our String is:

```text
Java Programming
```

It contains `"Java"`.

Therefore:

```text
true
```

Try:

```java
s.contains("Python")
```

It would return:

```text
false
```

### Remember

```text
contains() → IS IT PRESENT?
```

---

# 7. `substring(start, end)`

This is one of the **most important String methods**.

### Syntax

```java
substring(start, end)
```

Example:

```java
s.substring(0, 4)
```

The important rule is:

> **Start index is included, end index is excluded.**

Think:

```text
start ✅
end   ❌
```

Our String:

```text
J  a  v  a     P  r...
0  1  2  3  4  5  6...
↑              ↑
start          end
```

So:

```java
s.substring(0, 4)
```

takes:

```text
index 0 → J
index 1 → a
index 2 → v
index 3 → a
index 4 → STOP
```

Result:

```text
Java
```

### Remember

```text
substring(start, end)
       ↓
START included
END excluded
```

---

# 8. `substring(start)`

There is another form:

```java
substring(start)
```

Here we provide **only the starting index**.

Java takes everything from that index **until the end of the String**.

Example:

```java
s.substring(5)
```

Our String:

```text
J a v a   P r o g r a m m i n g
0 1 2 3 4 5 6 7 8 9...
          ↑
        start
```

Starting from index `5`:

```text
P r o g r a m m i n g
```

Result:

```text
Programming
```

### Remember

```text
substring(start)
       ↓
START → END
```

---

# 9. `substring(start, end)` vs `substring(start)`

| Method                  | Meaning               | Example           | Result        |
| ----------------------- | --------------------- | ----------------- | ------------- |
| `substring(start, end)` | Start to before end   | `substring(0, 4)` | `Java`        |
| `substring(start)`      | Start to String's end | `substring(5)`    | `Programming` |

### Easy trick

```text
substring(0, 4)
          ↑
     STOP BEFORE 4
```

But:

```text
substring(5)
          ↑
   GO UNTIL THE END
```

---

# 🧠 10. All Six Methods in One Picture

```text
String:
"Java Programming"

length()
   ↓
How many?
   ↓
16


charAt(2)
   ↓
Which character?
   ↓
v


indexOf('P')
   ↓
Where?
   ↓
5


contains("Java")
   ↓
Is it present?
   ↓
true


substring(0, 4)
   ↓
Take part
   ↓
Java


substring(5)
   ↓
Take from 5 to end
   ↓
Programming
```

---

# 🎯 Memory Trick

Remember these six questions:

```text
length()
   ↓
HOW MANY?

charAt()
   ↓
WHICH CHARACTER?

indexOf()
   ↓
WHERE?

contains()
   ↓
IS IT THERE?

substring(start, end)
   ↓
TAKE THIS PART

substring(start)
   ↓
TAKE FROM HERE TO END
```

### ⭐ Golden Rule

> **`length()` counts, `charAt()` picks, `indexOf()` finds, `contains()` checks, and `substring()` takes a part of the String.**

And the most important `substring()` rule:

> **`substring(start, end)` → start is included, end is excluded.**
