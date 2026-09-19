# 🧒 Character Frequency in Java

**Character frequency** means:

> **Finding how many times a particular character appears in a String.**

For example:

```text
"banana"
```

If we want to find the frequency of:

```text
'a'
```

we count:

```text
b a n a n a
  ↑   ↑   ↑
  1   2   3
```

So:

```text
Frequency of 'a' = 3
```

---

# 1. Basic Idea

We need two things from the user:

1. A **String**
2. A **character to search for**

Then:

```text
String
  ↓
toCharArray()
  ↓
Character Array
  ↓
Loop through every character
  ↓
Compare each character
  ↓
If it matches → increase count
  ↓
Final count = frequency
```

---

# 2. `toCharArray()`

Suppose:

```java
String s = "banana";
```

We convert it into a character array:

```java
char[] chars = s.toCharArray();
```

Now we have:

```text
String:

banana


Character Array:

┌───┬───┬───┬───┬───┬───┐
│ b │ a │ n │ a │ n │ a │
└───┴───┴───┴───┴───┴───┘
  0   1   2   3   4   5
```

Now we can use a loop to examine each character.

---

# 3. Character Comparison

Suppose the user wants to find:

```text
'a'
```

We compare every character with `'a'`.

```text
b == a ? → No
a == a ? → Yes
n == a ? → No
a == a ? → Yes
n == a ? → No
a == a ? → Yes
```

Every time we get `Yes`, we increase the count.

---

# 4. The `count` Variable

We start with:

```java
int count = 0;
```

Think of `count` as a **small counter**.

Initially:

```text
count = 0
```

When we find `'a'`:

```text
count = 1
```

Find another `'a'`:

```text
count = 2
```

Find another:

```text
count = 3
```

Finally:

```text
count = 3
```

Therefore, the frequency of `'a'` is **3**.

---

# 5. Complete Program

```java
import java.util.Scanner;

class CharacterFrequency {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a String: ");
        String input = sc.nextLine();

        System.out.print("Enter a character: ");
        char searchChar = sc.next().charAt(0);

        char[] chars = input.toCharArray();

        int count = 0;

        for (int i = 0; i < chars.length; i++) {

            if (chars[i] == searchChar) {
                count++;
            }
        }

        System.out.println("Frequency of '" + searchChar + "' = " + count);

        sc.close();
    }
}
```

---

# 6. Example

### Input

```text
Enter a String: banana
Enter a character: a
```

The program checks:

```text
b → not a
a → a found → count = 1
n → not a
a → a found → count = 2
n → not a
a → a found → count = 3
```

### Output

```text
Frequency of 'a' = 3
```

---

# 7. Understanding the Loop

The important part is:

```java
for (int i = 0; i < chars.length; i++) {

    if (chars[i] == searchChar) {
        count++;
    }
}
```

Let's use:

```text
banana
```

The array is:

```text
Index:     0   1   2   3   4   5
Character: b   a   n   a   n   a
```

The loop starts:

```text
i = 0
```

Check:

```text
chars[0] == 'a'
b == a
```

❌ No.

Next:

```text
i = 1
```

```text
a == a
```

✅ Yes.

So:

```text
count++
```

Now:

```text
count = 1
```

The loop continues until every character has been checked.

---

# 8. Why `==` Is Used Here?

Notice:

```java
chars[i] == searchChar
```

Both are **characters (`char`)**.

For example:

```text
chars[i] → 'a'
searchChar → 'a'
```

So we can use:

```java
==
```

to compare the characters.

This is different from comparing two String objects, where `.equals()` is normally used to compare their contents.

---

# 9. Another Example

Suppose:

```text
String = "programming"
Character = 'm'
```

Characters:

```text
p r o g r a m m i n g
            ↑ ↑
            m m
```

There are two `m`s.

Therefore:

```text
Frequency of 'm' = 2
```

---

# 10. If the Character Does Not Exist

Suppose:

```text
String = "banana"
Character = 'z'
```

The program checks every character:

```text
b → no
a → no
n → no
a → no
n → no
a → no
```

Nothing matches.

The counter remains:

```text
count = 0
```

Output:

```text
Frequency of 'z' = 0
```

---

# 🧠 Real-Life Example

Imagine a teacher has the names:

```text
BANANA
```

and asks:

> "How many times does the letter A appear?"

You point at each letter:

```text
B → ❌
A → ✅
N → ❌
A → ✅
N → ❌
A → ✅
```

Then count the ✅ marks:

```text
3
```

That's exactly what our Java program does.

---

# 🎯 Complete Flow

```text
           User enters String
                   ↓
              "banana"
                   ↓
          User enters character
                   ↓
                  'a'
                   ↓
            toCharArray()
                   ↓
        ┌─────────────────────┐
        │ b a n a n a         │
        └─────────────────────┘
                   ↓
              Start loop
                   ↓
        Compare each character
                   ↓
        Is character == 'a'?
             ↙          ↘
           YES           NO
            ↓             ↓
        count++         continue
            ↓
         Next character
                   ↓
             End of loop
                   ↓
            count = 3
                   ↓
     Frequency of 'a' = 3
```

# ⭐ Remember Forever

> **Character frequency = Count how many times a particular character appears in a String.**

The four most important lines are:

```java
char[] chars = input.toCharArray();

int count = 0;

if (chars[i] == searchChar) {
    count++;
}
```

### 🧠 Golden Memory Trick

**String → `toCharArray()` → Loop → Compare → `count++` → Frequency**

And remember:

```text
count = 0
   ↓
character found
   ↓
count++
   ↓
character found
   ↓
count++
   ↓
...
   ↓
Final count = frequency
```
