## 🧒 One-Dimensional Array — Lift Weight Problem 🛗

Imagine a lift has a rule:

> **The lift can carry a maximum of 600 kg.**

Several people enter the lift. We need to:

1. Ask how many people there are.
2. Take each person's weight.
3. Store the weights in a **1D `double` array**.
4. Calculate the total weight.
5. Check whether the total is **≤ 600 kg**.

---

## 1️⃣ Example

Suppose there are 4 people:

```text
Person 1 → 60.5 kg
Person 2 → 75.0 kg
Person 3 → 80.5 kg
Person 4 → 65.0 kg
```

Total:

```text
60.5 + 75.0 + 80.5 + 65.0
= 281.0 kg
```

Since:

```text
281.0 ≤ 600
```

✅ **Lift Allowed**

---

# 2️⃣ Complete Program

```java
import java.util.Scanner;

class LiftWeight {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Number of people
        System.out.print("Enter number of people: ");
        int numberOfPeople = sc.nextInt();

        // Create double array
        double[] weights = new double[numberOfPeople];

        // Total weight
        double totalWeight = 0;

        // Input weights
        System.out.println("Enter weights of people in kg:");

        for (int i = 0; i < weights.length; i++) {
            weights[i] = sc.nextDouble();
            totalWeight = totalWeight + weights[i];
        }

        // Display total weight
        System.out.println("Total weight = " + totalWeight + " kg");

        // Check lift capacity
        if (totalWeight <= 600) {
            System.out.println("Lift Allowed");
        } else {
            System.out.println("Lift Not Allowed");
        }

        sc.close();
    }
}
```

---

# 3️⃣ Sample Execution — Allowed ✅

### Input

```text
Enter number of people: 4
Enter weights of people in kg:
60.5
75
80.5
65
```

### Calculation

```text
60.5 + 75 + 80.5 + 65
          ↓
       281.0 kg
```

### Output

```text
Total weight = 281.0 kg
Lift Allowed
```

---

# 4️⃣ Sample Execution — Not Allowed ❌

Suppose 5 people enter:

```text
150
140
130
120
100
```

Total:

```text
150 + 140 + 130 + 120 + 100
= 640 kg
```

The maximum allowed weight is:

```text
600 kg
```

Therefore:

```text
640 > 600
```

Output:

```text
Total weight = 640.0 kg
Lift Not Allowed
```

---

# 5️⃣ Understanding the Array

We use:

```java
double[] weights = new double[numberOfPeople];
```

Why `double`?

Because a person's weight can contain decimal values:

```text
60.5 kg
75.2 kg
82.75 kg
```

The array might look like:

```text
Index:     0       1       2       3
         ┌──────┬──────┬──────┬──────┐
weights  │ 60.5 │ 75.0 │ 80.5 │ 65.0 │
         └──────┴──────┴──────┴──────┘
```

---

# 6️⃣ Why Use a Loop?

Instead of writing:

```java
weights[0] = sc.nextDouble();
weights[1] = sc.nextDouble();
weights[2] = sc.nextDouble();
weights[3] = sc.nextDouble();
```

we use:

```java
for (int i = 0; i < weights.length; i++) {
    weights[i] = sc.nextDouble();
}
```

This works for **any number of people**.

If the user enters `10`, the loop runs 10 times.

If the user enters `50`, the loop runs 50 times.

---

# 7️⃣ Calculating Total Weight

We start with:

```java
double totalWeight = 0;
```

Then:

```java
totalWeight = totalWeight + weights[i];
```

For example:

```text
Starting total = 0

Add 60.5
Total = 60.5

Add 75
Total = 135.5

Add 80.5
Total = 216.0

Add 65
Total = 281.0
```

---

# 8️⃣ Checking the 600 kg Limit

Finally:

```java
if (totalWeight <= 600) {
    System.out.println("Lift Allowed");
} else {
    System.out.println("Lift Not Allowed");
}
```

Think:

```text
             Total Weight
                  ↓
             <= 600 kg?
              /      \
            YES       NO
             ↓         ↓
      Lift Allowed   Lift Not Allowed
```

---

# 🧠 Complete Flow

```text
Number of people
       ↓
Create double array
       ↓
Take weights using Scanner
       ↓
for loop
       ↓
Store each weight
       ↓
Calculate total
       ↓
Is total <= 600?
      /       \
    YES        NO
     ↓          ↓
  Allowed    Not Allowed
```

### 🔑 Remember

> **Scanner → Array → Loop → Total → Condition**

And:

> **`double[]` is used because weights can contain decimal values.**

> **600 kg is the maximum capacity.**

> **If total weight ≤ 600 → Allowed.**

> **If total weight > 600 → Not Allowed.**
