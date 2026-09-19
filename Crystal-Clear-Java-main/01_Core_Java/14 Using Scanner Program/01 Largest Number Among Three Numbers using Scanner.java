## 🧒 Largest Number Among Three Numbers

We want to write a program that:

> **Takes three numbers from the user and finds the largest number.**

We will use:

```text
Scanner
   ↓
Three numbers: x, y, z
   ↓
Comparison
   ↓
&&
   ↓
if / else-if / else
   ↓
Largest number
```

---

# 1️⃣ Take Three Numbers Using `Scanner`

```java
Scanner sc = new Scanner(System.in);

int x = sc.nextInt();
int y = sc.nextInt();
int z = sc.nextInt();
```

Suppose the user enters:

```text
x = 30
y = 50
z = 20
```

Now Java has:

```text
x → 30
y → 50
z → 20
```

---

# 2️⃣ Compare the Numbers

We need to ask:

> **Is `x` bigger than both `y` and `z`?**

We write:

```java
x > y && x > z
```

### What does `&&` mean?

`&&` means **AND**.

Both conditions must be `true`.

```text
x > y     AND     x > z
```

For:

```text
x = 30
y = 50
z = 20
```

Check:

```text
30 > 50 → false
30 > 20 → true

false && true
      ↓
    false
```

So `x` is **not** the largest.

---

# 3️⃣ `if`

We first check whether `x` is the largest:

```java
if (x > y && x > z) {
    System.out.println("x is largest");
}
```

If both conditions are true, `x` is the largest.

---

# 4️⃣ `else-if`

If `x` isn't the largest, check `y`:

```java
else if (y > x && y > z) {
    System.out.println("y is largest");
}
```

If both conditions are true, `y` is the largest.

---

# 5️⃣ `else`

If neither `x` nor `y` is larger than the other two, then `z` is the largest **under the assumption that the numbers are distinct**.

```java
else {
    System.out.println("z is largest");
}
```

---

# 💻 Complete Program

```java
import java.util.Scanner;

class LargestNumber {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter x: ");
        int x = sc.nextInt();

        System.out.print("Enter y: ");
        int y = sc.nextInt();

        System.out.print("Enter z: ");
        int z = sc.nextInt();

        if (x > y && x > z) {
            System.out.println("Largest number = " + x);

        } else if (y > x && y > z) {
            System.out.println("Largest number = " + y);

        } else {
            System.out.println("Largest number = " + z);
        }

        sc.close();
    }
}
```

---

# 🔍 Example

Suppose:

```text
x = 40
y = 70
z = 50
```

Java checks:

### Step 1

```text
x > y && x > z

40 > 70 → false
40 > 50 → false

false && false
      ↓
    false
```

Go to `else-if`.

### Step 2

```text
y > x && y > z

70 > 40 → true
70 > 50 → true

true && true
     ↓
   true
```

Therefore:

```text
Largest number = 70
```

---

# 🔄 Program Flow

```text
             Start
               ↓
        Read x, y, z
               ↓
     x > y && x > z ?
          ↙       ↘
       TRUE       FALSE
        ↓            ↓
    x largest   y > x && y > z ?
                    ↙       ↘
                 TRUE       FALSE
                  ↓            ↓
             y largest     z largest
```

---

# 🧠 Understand `&&`

This is extremely important.

```text
A && B
```

means:

> **A AND B must both be true.**

| A     | B     | A && B   |
| ----- | ----- | -------- |
| true  | true  | **true** |
| true  | false | false    |
| false | true  | false    |
| false | false | false    |

So:

```java
x > y && x > z
```

means:

> "`x` must be greater than **both** `y` and `z`."

---

## ⚠️ Small Important Point

The above program works cleanly when the numbers are **different**.

For example:

```text
x = 50
y = 50
z = 30
```

The program would go to `else` and print `z`, which would be incorrect.

If you want a **fully correct program that also handles equal numbers**, use `>=`:

```java
if (x >= y && x >= z) {
    System.out.println("Largest number = " + x);

} else if (y >= x && y >= z) {
    System.out.println("Largest number = " + y);

} else {
    System.out.println("Largest number = " + z);
}
```

This correctly handles cases such as `50, 50, 30`.

---

### 🔑 Memory Trick

```text
Three numbers
     ↓
Check x against y & z
     ↓
Check y against x & z
     ↓
Otherwise z
     ↓
Largest number
```

> **`&&` = AND = both comparisons must be true.**
