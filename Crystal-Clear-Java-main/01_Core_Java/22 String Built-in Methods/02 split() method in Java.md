# 🧒 `split()` Method in Java

The `split()` method is used when we have **one big String** and want to **break it into smaller Strings**.

Think about a sentence written on a piece of paper:

```text
"Java Python HTML CSS"
```

We can tell Java:

> “Whenever you find a space, cut the String there.”

Java will give us separate pieces:

```text
Java
Python
HTML
CSS
```

---

# 1. What is `split()`?

`split()` is a built-in method of the `String` class.

It is used for:

> **Splitting one String into multiple smaller Strings.**

### Syntax

```java
String[] variable = string.split("delimiter");
```

For example:

```java
String[] words = "Java Python HTML CSS".split(" ");
```

---

# 2. What is a Delimiter?

A **delimiter** is the character or symbol that tells Java:

> **“Cut the String here.”**

For example:

```text
Java,Python,HTML,CSS
```

Here the comma:

```text
,
```

is the delimiter.

So:

```java
String[] languages = "Java,Python,HTML,CSS".split(",");
```

Java sees:

```text
Java , Python , HTML , CSS
     ↑       ↑      ↑
   cut     cut    cut
```

The result becomes:

```text
Java
Python
HTML
CSS
```

---

# 3. `split()` Returns `String[]`

This is very important.

`split()` does **not** return one String.

It returns:

```text
String[]
```

which means:

> **An array of Strings.**

Example:

```java
String[] names = "Basha,Ravi,John".split(",");
```

Now `names` is a String array:

```text
names
 ↓
┌─────────┬─────────┬─────────┐
│  Basha  │  Ravi   │  John   │
└─────────┴─────────┴─────────┘
    0         1         2
```

---

# 4. Simple Program

```java
class SplitDemo {

    public static void main(String[] args) {

        String s = "Java,Python,HTML,CSS";

        String[] result = s.split(",");

        System.out.println(result[0]);
        System.out.println(result[1]);
        System.out.println(result[2]);
        System.out.println(result[3]);
    }
}
```

### Output

```text
Java
Python
HTML
CSS
```

---

# 5. What Happened Step-by-Step?

We started with:

```java
String s = "Java,Python,HTML,CSS";
```

Think of it as:

```text
Java , Python , HTML , CSS
```

Then:

```java
String[] result = s.split(",");
```

Java uses comma as the delimiter:

```text
Java , Python , HTML , CSS
     ↑       ↑      ↑
    cut     cut    cut
```

The result is:

```text
result[0] → "Java"
result[1] → "Python"
result[2] → "HTML"
result[3] → "CSS"
```

---

# 6. Array Output

We can also print the array using a loop.

```java
class SplitDemo {

    public static void main(String[] args) {

        String s = "Java,Python,HTML,CSS";

        String[] result = s.split(",");

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
```

### Output

```text
Java
Python
HTML
CSS
```

This is useful because we don't need to manually write:

```java
result[0]
result[1]
result[2]
result[3]
```

The loop handles all elements.

---

# 7. Splitting a Sentence

A very common example is splitting a sentence using a space.

```java
class SplitDemo {

    public static void main(String[] args) {

        String sentence = "Java is very easy";

        String[] words = sentence.split(" ");

        for (int i = 0; i < words.length; i++) {
            System.out.println(words[i]);
        }
    }
}
```

### Output

```text
Java
is
very
easy
```

Here:

```text
" "
```

is the delimiter.

Java cuts whenever it finds a space.

---

# 8. Visual Understanding

Original String:

```text
Java is very easy
```

Delimiter:

```text
         ↓   ↓    ↓
Java | is | very | easy
```

After splitting:

```text
words[0] → "Java"
words[1] → "is"
words[2] → "very"
words[3] → "easy"
```

So:

```text
One String
     ↓
  split()
     ↓
String[]
     ↓
Multiple Strings
```

---

# 9. Splitting Using `-`

The delimiter doesn't have to be a comma.

Example:

```java
String s = "10-20-30-40";

String[] numbers = s.split("-");
```

Result:

```text
numbers[0] → "10"
numbers[1] → "20"
numbers[2] → "30"
numbers[3] → "40"
```

Notice something important:

> Even though `10`, `20`, `30`, and `40` look like numbers, `split()` returns **Strings**.

So:

```text
"10" → String
"20" → String
"30" → String
"40" → String
```

If you need integers, you must convert them.

---

# 10. `split()` With Scanner Input

You can also use `Scanner`.

For example, the user enters:

```text
Java,Python,HTML
```

Program:

```java
import java.util.Scanner;

class SplitScannerDemo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter languages separated by comma:");

        String input = sc.nextLine();

        String[] languages = input.split(",");

        for (int i = 0; i < languages.length; i++) {
            System.out.println(languages[i]);
        }

        sc.close();
    }
}
```

### Input

```text
Java,Python,HTML
```

### Output

```text
Java
Python
HTML
```

---

# 🧠 11. Real-Life Example

Imagine a teacher has this list:

```text
Basha,Ravi,John,Ali
```

The teacher says:

> “Every comma means one student's name has ended.”

Java cuts it:

```text
Basha | Ravi | John | Ali
```

Then Java stores the pieces in a String array:

```text
┌────────┬────────┬────────┬────────┐
│ Basha  │ Ravi   │ John   │ Ali    │
└────────┴────────┴────────┴────────┘
    0        1        2        3
```

That's exactly what `split()` does.

---

# ⭐ Your Four Points

### `split()`

Used to break a String into smaller Strings.

```java
s.split(",");
```

### Delimiter

The character/pattern that tells Java where to split.

Examples:

```text
","  → comma
" "  → space
"-"  → hyphen
":"  → colon
```

### Splitting String

Example:

```text
Java,Python,HTML
```

becomes:

```text
Java
Python
HTML
```

### Returns `String[]`

The result is a **String array**:

```java
String[] result = s.split(",");
```

### Array output

You can access individual pieces:

```java
result[0]
result[1]
result[2]
```

or traverse them:

```java
for (int i = 0; i < result.length; i++) {
    System.out.println(result[i]);
}
```

---

# 🎯 Remember Forever

```text
        "Java,Python,HTML"
                  ↓
              split(",")
                  ↓
             String[]
                  ↓
        ┌───────┬────────┬──────┐
        │ Java  │ Python │ HTML │
        └───────┴────────┴──────┘
           0        1       2
```

### 🧠 Golden Rule

> **`split()` breaks one String using a delimiter and returns the pieces as a `String[]` array.**

Easy memory:

**`split()` → Cut → Pieces → `String[]`**.
