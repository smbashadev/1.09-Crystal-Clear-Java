# 🧒 Palindrome in Java

A **palindrome** is a word or String that looks **the same when read from left to right and right to left**.

### Examples

```text
MADAM
```

Forward:

```text
M A D A M
```

Backward:

```text
M A D A M
```

✅ Same → **Palindrome**

Another example:

```text
LEVEL
```

Forward:

```text
L E V E L
```

Backward:

```text
L E V E L
```

✅ Palindrome

But:

```text
JAVA
```

Forward:

```text
J A V A
```

Backward:

```text
A V A J
```

❌ Not a palindrome.

---

# 1. Basic Idea

To check whether a String is a palindrome:

```text
Original String
      ↓
Reverse the String
      ↓
Compare Original and Reverse
      ↓
Are they equal?
   ↙          ↘
 YES           NO
 ↓              ↓
Palindrome    Not Palindrome
```

For example:

```text
Original = MADAM
Reverse  = MADAM

MADAM.equals(MADAM)
        ↓
      true
        ↓
   Palindrome
```

---

# 2. `toCharArray()`

Java provides:

```java
toCharArray()
```

It converts a String into a **character array**.

For example:

```java
String s = "MADAM";

char[] chars = s.toCharArray();
```

Now:

```text
String:
"MADAM"

        toCharArray()
             ↓

Array:
┌───┬───┬───┬───┬───┐
│ M │ A │ D │ A │ M │
└───┴───┴───┴───┴───┘
  0   1   2   3   4
```

Now we can easily access each character using its index.

---

# 3. Loop From End to Beginning

To create the reverse String, we start from the **last character** and move toward the first character.

For:

```text
MADAM
```

indexes are:

```text
Character: M   A   D   A   M
Index:     0   1   2   3   4
```

We start at:

```text
4
```

and move:

```text
4 → 3 → 2 → 1 → 0
```

So we get:

```text
M → A → D → A → M
```

which gives:

```text
MADAM
```

---

# 4. Complete Palindrome Program

```java
import java.util.Scanner;

class Palindrome {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a String: ");
        String original = sc.nextLine();

        char[] chars = original.toCharArray();

        String reverse = "";

        for (int i = chars.length - 1; i >= 0; i--) {
            reverse = reverse + chars[i];
        }

        if (original.equals(reverse)) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not a Palindrome");
        }

        sc.close();
    }
}
```

---

# 5. Example 1 — Palindrome

### Input

```text
Enter a String: MADAM
```

The program creates:

```text
Original = MADAM
Reverse  = MADAM
```

Then:

```java
original.equals(reverse)
```

becomes:

```java
"MADAM".equals("MADAM")
```

Result:

```text
true
```

### Output

```text
Palindrome
```

---

# 6. Example 2 — Not a Palindrome

### Input

```text
Enter a String: JAVA
```

The program creates:

```text
Original = JAVA
Reverse  = AVAJ
```

Now:

```java
"JAVA".equals("AVAJ")
```

Result:

```text
false
```

### Output

```text
Not a Palindrome
```

---

# 7. Understanding the Loop

This is the most important part:

```java
for (int i = chars.length - 1; i >= 0; i--) {
    reverse = reverse + chars[i];
}
```

Suppose:

```text
chars = {'M', 'A', 'D', 'A', 'M'}
```

`chars.length` is:

```text
5
```

The last index is:

```text
5 - 1 = 4
```

Therefore:

```text
i = 4
```

Then:

```text
i = 3
i = 2
i = 1
i = 0
```

The characters are picked like this:

```text
i = 4 → M
i = 3 → A
i = 2 → D
i = 1 → A
i = 0 → M
```

So:

```text
reverse = "MADAM"
```

---

# 8. Why `equals()`?

At the end we have two Strings:

```text
original
reverse
```

We need to compare their **values**.

Therefore we use:

```java
original.equals(reverse)
```

For example:

```text
original = "MADAM"
reverse  = "MADAM"
```

```java
original.equals(reverse)
```

returns:

```text
true
```

---

## ❌ Don't Use `==` Here

For comparing String contents, use:

```java
.equals()
```

not:

```java
==
```

Because:

```text
equals() → compares String values
==       → compares references
```

So for palindrome checking:

```java
if (original.equals(reverse))
```

is the appropriate comparison.

---

# 🧠 Real-Life Example

Imagine the word:

```text
LEVEL
```

You stand in front of a mirror.

You read it normally:

```text
LEVEL
```

The reflected/reversed order is:

```text
LEVEL
```

They are the same.

Therefore:

```text
LEVEL → Palindrome
```

But:

```text
JAVA
```

reversed becomes:

```text
AVAJ
```

They are different.

Therefore:

```text
JAVA → Not Palindrome
```

---

# 🎯 Remember the Complete Process

```text
             User enters String
                    ↓
              "MADAM"
                    ↓
             toCharArray()
                    ↓
        ┌─────────────────────┐
        │ M A D A M           │
        │ 0 1 2 3 4           │
        └─────────────────────┘
                    ↓
        Loop from 4 → 0
                    ↓
              "MADAM"
                    ↓
             Reverse String
                    ↓
       Original.equals(Reverse)
                    ↓
              ┌─────┴─────┐
             true        false
              ↓             ↓
        Palindrome     Not Palindrome
```

### ⭐ Golden Rule

> **Palindrome checking = Original String + Reverse String + `equals()` comparison.**

And the four key pieces are:

```text
toCharArray()
      ↓
Convert String → char[]

Loop from end → beginning
      ↓
Create reverse String

equals()
      ↓
Compare original and reverse
```

**If they are equal → Palindrome.**
