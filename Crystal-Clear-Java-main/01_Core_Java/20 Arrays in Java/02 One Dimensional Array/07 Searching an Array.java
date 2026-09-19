## 🧒 One-Dimensional Array — Searching an Array

**Searching an array** means:

> 🔍 **Checking whether a particular value exists inside the array.**

For example, we have:

```text
10  20  30  40  50
```

If the user searches for:

```text
30
```

Java should say:

```text
30 exists in the array
```

If the user searches for:

```text
99
```

Java should say:

```text
99 does not exist in the array
```

---

## 1️⃣ Complete Program

```java
import java.util.Scanner;

class ArraySearch {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Integer array
        int[] numbers = {10, 20, 30, 40, 50};

        // Search value
        System.out.print("Enter a number to search: ");
        int search = sc.nextInt();

        boolean found = false;

        // Search the array
        for (int i = 0; i < numbers.length; i++) {

            if (numbers[i] == search) {
                found = true;
                break;
            }
        }

        // Result
        if (found) {
            System.out.println(search + " exists in the array.");
        } else {
            System.out.println(search + " does not exist in the array.");
        }

        sc.close();
    }
}
```

---

# 2️⃣ Example — Value Exists ✅

Array:

```text
10  20  30  40  50
```

User enters:

```text
Enter a number to search: 30
```

Java checks:

```text
numbers[0] → 10 → 10 == 30 ❌
numbers[1] → 20 → 20 == 30 ❌
numbers[2] → 30 → 30 == 30 ✅
```

Now `found` becomes:

```java
found = true;
```

Output:

```text
30 exists in the array.
```

---

# 3️⃣ Example — Value Doesn't Exist ❌

User enters:

```text
Enter a number to search: 99
```

Java checks every element:

```text
10 == 99 ❌
20 == 99 ❌
30 == 99 ❌
40 == 99 ❌
50 == 99 ❌
```

Nothing matches.

Therefore:

```java
found = false;
```

Output:

```text
99 does not exist in the array.
```

---

# 4️⃣ Why Do We Use a `for` Loop?

We don't know where the value is located.

So we check **each element one by one**:

```text
Array
 ↓
10 → Check
 ↓
20 → Check
 ↓
30 → Check
 ↓
40 → Check
 ↓
50 → Check
```

This is called **array traversal**.

---

# 5️⃣ What Does `found` Mean?

We create:

```java
boolean found = false;
```

Think of `found` as a **yes/no flag** 🚩.

Initially:

```text
found = false
```

Meaning:

> "I haven't found the number yet."

When we find it:

```java
found = true;
```

Meaning:

> "Yes! The number exists."

---

# 6️⃣ Why `==`?

We use:

```java
if (numbers[i] == search)
```

`==` checks whether the two integer values are equal.

Example:

```text
30 == 30 → true
30 == 50 → false
```

---

# 7️⃣ Why `break`?

When we find the number:

```java
found = true;
break;
```

`break` means:

> **Stop the loop immediately.**

If we already found `30`, there is no need to continue searching.

```text
10 → ❌
20 → ❌
30 → ✅
       ↓
     BREAK
       ↓
    Stop loop
```

---

# 🧠 Complete Flow

```text
Integer Array
     ↓
Ask search value
     ↓
Scanner
     ↓
for loop
     ↓
Check each element
     ↓
Is element == search value?
       /       \
     YES        NO
      ↓          ↓
   found=true   Continue
      ↓
    break
      ↓
Check found
    /    \
 TRUE    FALSE
  ↓        ↓
Exists   Doesn't exist
```

---

# 🔑 Remember

> **Searching an array = checking elements one by one to see whether a particular value exists.**

```text
Array → Scanner → Loop → Compare → Found / Not Found
```

### ⭐ Interview Answer

> **Array searching is the process of checking whether a specified value exists in an array. We can use a `for` loop to traverse the array and compare each element with the search value. A boolean variable can be used to track whether the value was found.**
