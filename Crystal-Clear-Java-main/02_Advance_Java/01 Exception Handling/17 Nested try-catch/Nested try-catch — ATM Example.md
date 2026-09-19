# 🧒 17. Nested try-catch — ATM Example

### 1. Basic Idea

A **nested try-catch** means putting one `try-catch` structure **inside another `try` or `catch` block**.

In this ATM example, the program gives the customer a chance to enter the PIN **two times**.

```text
ATM Transaction
      ↓
First PIN attempt
      ↓
Correct?
   ↙       ↘
 YES        NO
 ↓           ↓
Success    Second attempt
             ↓
          Correct?
          ↙     ↘
        YES      NO
         ↓        ↓
      Success   Blocked
```

---

### 2. Why Nested try-catch Is Used Here

The ATM has **two different levels of problems**.

The first wrong PIN does not immediately block the account.

Instead:

```text
First wrong PIN
      ↓
Give another chance
```

But if the second PIN is also wrong:

```text
Second wrong PIN
      ↓
Account blocked for 24 hours
```

Nested exception handling helps represent this different handling at different levels.

---

### 3. ATM Real-World Example

Imagine entering a PIN at an ATM.

```text
Attempt 1
 ↓
Wrong PIN
 ↓
"Please enter PIN again"
 ↓
Attempt 2
 ↓
Wrong PIN again
 ↓
Account blocked for 24 hours
```

If the first PIN is correct:

```text
Attempt 1
 ↓
Correct PIN
 ↓
Transaction continues
```

---

### 4. First Attempt

The ATM first asks for the PIN.

```text
Enter PIN
   ↓
Check first input
```

There are two possibilities:

```text
Correct → continue
Wrong   → second attempt
```

---

### 5. Correct First PIN

If the first PIN is correct:

```text
First attempt
      ↓
Correct PIN
      ↓
Transaction continues
```

There is no need for the second attempt.

---

### 6. Wrong First PIN

If the first PIN is wrong:

```text
First attempt
      ↓
Wrong PIN
      ↓
First exception
      ↓
"Wrong PIN, Please enter pin again"
```

The customer receives another opportunity.

---

### 7. Second Attempt

After the first wrong PIN, the program asks for the PIN again.

```text
Second attempt
      ↓
Read second PIN
```

Again, there are two possibilities:

```text
Correct → transaction continues
Wrong   → account blocked
```

---

### 8. Why Is the Second Attempt Different?

The first wrong PIN is treated as a **warning**.

The second wrong PIN is treated as a **serious failure**.

```text
1st wrong PIN
     ↓
Try again

2nd wrong PIN
     ↓
Block account
```

---

### 9. Basic Nested Structure

A simplified structure looks like this:

```java
try {

    // first attempt

    try {

        // second attempt

    }
    catch (Exception e) {

        // second exception handling

    }

}
catch (Exception e) {

    // first exception handling

}
```

The inner `try-catch` is placed inside the outer `try`.

---

### 10. Understanding Outer and Inner

In:

```java
try {

    try {

        // inner code

    }
    catch (Exception e) {

        // inner catch

    }

}
catch (Exception e) {

    // outer catch

}
```

the first `try` is the **outer try**.

The second `try` is the **inner try**.

```text
Outer try
   ↓
   Inner try
      ↓
   Inner catch
   ↓
Outer catch
```

---

## 17.1 ATM Transaction

### 11. ATM Transaction Flow

The complete ATM transaction is:

```text
Start transaction
      ↓
Enter first PIN
      ↓
Check PIN
      ↓
Correct?
   ↙       ↘
 YES        NO
 ↓           ↓
Success    First exception
             ↓
       Enter second PIN
             ↓
          Correct?
          ↙     ↘
        YES      NO
         ↓        ↓
      Success   Blocked
```

---

### 12. First Attempt — Correct PIN

Suppose the correct PIN is:

```text
1234
```

The customer enters:

```text
1234
```

The PIN matches.

Therefore:

```text
Correct PIN
     ↓
Transaction continues
```

This produces **Output 1**.

---

### 13. First Attempt — Wrong PIN

Suppose the customer enters:

```text
1111
```

when the correct PIN is:

```text
1234
```

The values do not match.

Therefore:

```text
1111 ≠ 1234
```

The first attempt fails.

The program displays:

```text
Wrong PIN, Please enter pin again
```

---

### 14. Second Attempt — Correct PIN

The customer now enters:

```text
1234
```

The PIN is correct.

Therefore:

```text
First attempt → Wrong
Second attempt → Correct
```

The transaction can continue.

This produces **Output 2**.

---

### 15. Second Attempt — Wrong PIN

Suppose the customer enters:

```text
1111
```

again.

Then:

```text
First attempt → Wrong
Second attempt → Wrong
```

The ATM blocks the account.

```text
Account blocked for 24 hours
```

This produces **Output 3**.

---

## 17.2 First Exception

### 16. First Exception Meaning

The first exception represents:

```text
Wrong first PIN
```

The ATM does not block the account immediately.

Instead, it gives the customer another opportunity.

---

### 17. First Exception Message

The required message is:

```text
Wrong PIN, Please enter pin again
```

This tells the customer:

```text
Your first PIN was incorrect.
You still have another attempt.
```

---

### 18. First Exception Flow

```text
First PIN
   ↓
Wrong
   ↓
First exception
   ↓
Catch
   ↓
Wrong PIN, Please enter pin again
   ↓
Second attempt
```

---

### 19. Why Does the Program Continue?

The first exception is handled.

Once the exception is handled, the program can continue with the second-attempt logic.

```text
Exception
   ↓
Handled
   ↓
Second attempt
```

The first wrong PIN therefore does not immediately terminate the transaction.

---

### 20. First Catch

Conceptually:

```java
catch (Exception e) {

    System.out.println(
        "Wrong PIN, Please enter pin again"
    );

}
```

The `catch` block receives the exception and displays the appropriate message.

---

## 17.3 Second Exception

### 21. Second Exception Meaning

The second exception occurs when the customer enters an invalid PIN **again**.

```text
First attempt → Wrong
Second attempt → Wrong
```

Now there is no additional attempt.

The account is blocked.

---

### 22. Second Exception Message

The required result is:

```text
Invalid PIN, Blocked for 24 Hours
```

or the final output can communicate:

```text
Account blocked for 24 hours
```

The important idea is:

```text
Second wrong PIN
      ↓
Account blocked
```

---

### 23. Second Exception Flow

```text
Second PIN
   ↓
Wrong
   ↓
Second exception
   ↓
Inner catch
   ↓
Invalid PIN, Blocked for 24 Hours
```

---

### 24. Why Use an Inner Catch?

The second attempt has a different consequence from the first attempt.

```text
First wrong PIN
      ↓
Try again

Second wrong PIN
      ↓
Block account
```

The inner exception handling can therefore deal specifically with the second failure.

---

### 25. Nested Exception Flow

The overall structure can be understood as:

```text
Outer try
   ↓
First PIN attempt
   ↓
First exception
   ↓
Outer/associated handling
   ↓
Second attempt
   ↓
Inner try
   ↓
Second exception
   ↓
Inner catch
   ↓
Account blocked
```

The exact placement of the inner `try-catch` determines which handler receives the exception.

---

## 17.4 Three Outputs

### 26. Output 1 — Correct First Attempt

Input:

```text
1234
```

Correct PIN:

```text
1234
```

Flow:

```text
First attempt
      ↓
Correct
      ↓
Transaction continues
```

The second attempt is not needed.

---

### 27. Output 1 — Meaning

```text
Correct PIN first attempt
```

means:

```text
Attempt 1 → Correct
Attempt 2 → Not required
```

The customer successfully passes PIN verification immediately.

---

### 28. Output 2 — Wrong First, Correct Second

First input:

```text
1111
```

Correct PIN:

```text
1234
```

Result:

```text
Wrong PIN, Please enter pin again
```

Second input:

```text
1234
```

Result:

```text
Correct PIN
```

Flow:

```text
1111
 ↓
Wrong
 ↓
Try again
 ↓
1234
 ↓
Correct
 ↓
Transaction continues
```

---

### 29. Output 3 — Wrong Twice

First input:

```text
1111
```

Result:

```text
Wrong PIN, Please enter pin again
```

Second input:

```text
2222
```

Result:

```text
Invalid PIN, Blocked for 24 Hours
```

Flow:

```text
1111
 ↓
Wrong
 ↓
Try again
 ↓
2222
 ↓
Wrong again
 ↓
Account blocked
```

---

### 30. Three Scenarios Together

```text
SCENARIO 1
Correct → Correct PIN
           ↓
       Transaction

SCENARIO 2
Wrong → Try again → Correct
                     ↓
                 Transaction

SCENARIO 3
Wrong → Try again → Wrong
                     ↓
              Account blocked
```

---

### 31. Simple ATM Program Structure

A beginner-friendly structure can be represented as:

```java
try {

    // First PIN attempt

    try {

        // Second PIN attempt

    }
    catch (Exception e) {

        System.out.println(
            "Invalid PIN, Blocked for 24 Hours"
        );

    }

}
catch (Exception e) {

    System.out.println(
        "Wrong PIN, Please enter pin again"
    );

}
```

The actual condition and PIN-checking code determines when each exception is produced.

---

### 32. Important Understanding of Nested try-catch

Nested `try-catch` does **not** mean that both catches execute for the same exception.

Normally:

```text
Exception occurs
      ↓
Nearest suitable handler
      ↓
That handler executes
```

Once the exception is handled, propagation stops.

---

### 33. First Wrong, Second Correct

Remember this flow:

```text
First try
   ↓
Wrong PIN
   ↓
First exception handled
   ↓
Second try
   ↓
Correct PIN
   ↓
Transaction continues
```

---

### 34. Wrong Twice

Remember this flow:

```text
First try
   ↓
Wrong PIN
   ↓
First exception handled
   ↓
Second try
   ↓
Wrong PIN again
   ↓
Second exception
   ↓
Second handler
   ↓
Account blocked for 24 hours
```

---

### 35. Memory Trick

Remember the ATM rule:

```text
1st wrong → TRY AGAIN
2nd wrong → BLOCK
```

And:

```text
Correct first → SUCCESS
Wrong first + Correct second → SUCCESS
Wrong first + Wrong second → BLOCKED
```

---

### 36. Complete Lifetime Understanding

```text
                         ATM TRANSACTION
                                ↓
                       First PIN entered
                                ↓
                         Is PIN correct?
                         ↙             ↘
                      YES               NO
                       ↓                 ↓
                 Transaction       First exception
                   continues              ↓
                                   "Wrong PIN,
                                  Please enter
                                  pin again"
                                         ↓
                                  Second PIN entered
                                         ↓
                                  Is PIN correct?
                                  ↙             ↘
                               YES               NO
                                ↓                 ↓
                          Transaction       Second exception
                            continues             ↓
                                      "Invalid PIN,
                                      Blocked for
                                      24 Hours"
                                                 ↓
                                      Account blocked
                                      for 24 hours
```

**Core memory rule:**

> **The ATM gives the customer two opportunities. A correct first PIN succeeds immediately. A wrong first PIN allows a second attempt. If the second PIN is correct, the transaction continues; if it is wrong again, the account is blocked for 24 hours.**
