# 🧒 String Built-in Methods

Java gives us many **built-in methods** to work with Strings.

Think of a String as a **word made from characters**:

```text
"Hello Java"
```

Java gives us methods to ask questions like:

* How many characters are there?
* What character is at a particular position?
* Where does a particular character occur?
* Does this String contain a particular word?
* Give me a particular part of the String.

The important methods here are:

1. `length()`
2. `charAt()`
3. `indexOf()`
4. `contains()`
5. `substring()`

---

# 1. `length()`

## 🧠 What does `length()` do?

`length()` tells us the **number of characters** present in a String.

### Syntax

```java
string.length();
```

Example:

```java
String name = "Basha";

System.out.println(name.length());
```

Output:

```text
5
```

Because:

```text
B  a  s  h  a
1  2  3  4  5
```

There are **5 characters**.

---

## ⚠️ Spaces are also counted

```java
String s = "Hello Java";

System.out.println(s.length());
```

Output:

```text
10
```

Why?

```text
H e l l o _ J a v a
1 2 3 4 5 6 7 8 9 10
```

The space is also a character.

### 🧠 Remember

> `length()` → **How many characters?**

---

# 2. `charAt()`

## 🧠 What does `charAt()` do?

`charAt()` gives us the **character at a particular index**.

Remember:

> **String index starts from 0.**

For:

```text
"Java"
```

the indexes are:

```text
Character:  J    a    v    a
Index:      0    1    2    3
```

So:

```java
String s = "Java";

System.out.println(s.charAt(0));
```

Output:

```text
J
```

And:

```java
System.out.println(s.charAt(2));
```

Output:

```text
v
```

---

## Complete Program

```java
class CharAtDemo {

    public static void main(String[] args) {

        String s = "Java";

        System.out.println(s.charAt(0));
        System.out.println(s.charAt(1));
        System.out.println(s.charAt(2));
        System.out.println(s.charAt(3));
    }
}
```

### Output

```text
J
a
v
a
```

### 🧠 Remember

> `charAt(index)` → **Give me the character at this position.**

---

# 3. `indexOf()`

## 🧠 What does `indexOf()` do?

`indexOf()` tells us the **index/position where a character or String first occurs**.

Example:

```java
String s = "Java";

System.out.println(s.indexOf('a'));
```

Output:

```text
1
```

Why?

```text
Character:  J    a    v    a
Index:      0    1    2    3
                  ↑
                 'a'
```

The first `'a'` is at index `1`.

---

## Repeated Character

Consider:

```java
String s = "Java";
```

There are two `a`s:

```text
Character:  J    a    v    a
Index:      0    1    2    3
                  ↑         ↑
```

Now:

```java
System.out.println(s.indexOf('a'));
```

Output:

```text
1
```

`indexOf()` normally gives the **first occurrence**.

---

## Searching for a String

You can also search for a String:

```java
String s = "Java Programming";

System.out.println(s.indexOf("Programming"));
```

Output:

```text
5
```

Because:

```text
Java_Programming
    ↑
    index 4 = space
    index 5 = P
```

### 🧠 Remember

> `indexOf()` → **Where does it first occur?**

---

# 4. `contains()`

## 🧠 What does `contains()` do?

`contains()` checks whether a particular sequence of characters is present inside a String.

It gives:

```text
true
```

or:

```text
false
```

Example:

```java
String s = "Java Programming";

System.out.println(s.contains("Java"));
```

Output:

```text
true
```

Because `"Java"` exists inside the String.

---

### Another Example

```java
String s = "Java Programming";

System.out.println(s.contains("Python"));
```

Output:

```text
false
```

Because `"Python"` does not exist.

---

## Complete Program

```java
class ContainsDemo {

    public static void main(String[] args) {

        String s = "Java Programming";

        System.out.println(s.contains("Java"));
        System.out.println(s.contains("Programming"));
        System.out.println(s.contains("Python"));
    }
}
```

### Output

```text
true
true
false
```

### 🧠 Remember

> `contains()` → **Is it present?**

---

# 5. `substring()`

## 🧠 What does `substring()` do?

`substring()` takes out a **part of a String**.

Imagine a String is a long piece of cake 🍰.

`substring()` lets us take a smaller piece from it.

Example:

```java
String s = "Java Programming";

System.out.println(s.substring(5));
```

Output:

```text
Programming
```

Why?

Indexes:

```text
 J a v a _ P r o g r a m m i n g
 0 1 2 3 4 5 6 7 8 9 ...
         ↑
       start
```

Starting from index `5`, we get:

```text
Programming
```

---

# 6. `substring(beginIndex, endIndex)`

There is another form:

```java
substring(beginIndex, endIndex)
```

Example:

```java
String s = "Java Programming";

System.out.println(s.substring(0, 4));
```

Output:

```text
Java
```

### Very Important Rule

The **begin index is included**.

The **end index is excluded**.

Remember:

> **Start included, end excluded.**

For:

```java
s.substring(0, 4)
```

Java takes:

```text
0  → J ✅
1  → a ✅
2  → v ✅
3  → a ✅
4  → stop ❌
```

Result:

```text
Java
```

---

# 7. Complete `substring()` Program

```java
class SubstringDemo {

    public static void main(String[] args) {

        String s = "Java Programming";

        System.out.println(s.substring(5));
        System.out.println(s.substring(0, 4));
    }
}
```

### Output

```text
Programming
Java
```

---

# 🧠 8. All Five Methods Together

Let's use one String:

```java
String s = "Java Programming";
```

### `length()`

```java
s.length();
```

👉 **How many characters?**

---

### `charAt()`

```java
s.charAt(2);
```

👉 **Which character is at index 2?**

Answer:

```text
v
```

---

### `indexOf()`

```java
s.indexOf("Programming");
```

👉 **Where does `"Programming"` start?**

Answer:

```text
5
```

---

### `contains()`

```java
s.contains("Java");
```

👉 **Does `"Java"` exist?**

Answer:

```text
true
```

---

### `substring()`

```java
s.substring(5);
```

👉 **Give me the String starting from index 5.**

Answer:

```text
Programming
```

---

# 📊 Quick Comparison

| Method        | Simple Question         | Example                 | Result |
| ------------- | ----------------------- | ----------------------- | ------ |
| `length()`    | How many characters?    | `"Java".length()`       | `4`    |
| `charAt()`    | What character is here? | `"Java".charAt(2)`      | `v`    |
| `indexOf()`   | Where does it occur?    | `"Java".indexOf('a')`   | `1`    |
| `contains()`  | Is it present?          | `"Java".contains("av")` | `true` |
| `substring()` | Give me part of it      | `"Java".substring(1,3)` | `av`   |

---

# 🎯 One Complete Program

```java
class StringMethodsDemo {

    public static void main(String[] args) {

        String s = "Java Programming";

        System.out.println("Length: " + s.length());

        System.out.println("Character: " + s.charAt(2));

        System.out.println("Index: " + s.indexOf("Programming"));

        System.out.println("Contains Java: " + s.contains("Java"));

        System.out.println("Substring: " + s.substring(5));
    }
}
```

### Output

```text
Length: 16
Character: v
Index: 5
Contains Java: true
Substring: Programming
```

---

# 🧠 Remember These 5 Words

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

substring()
   ↓
GIVE ME A PART
```

### ⭐ Golden Memory Trick

> **`length()` counts, `charAt()` picks, `indexOf()` finds, `contains()` checks, and `substring()` extracts.**
