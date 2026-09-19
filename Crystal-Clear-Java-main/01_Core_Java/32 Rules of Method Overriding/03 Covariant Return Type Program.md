# 🧒 Covariant Return Type Program

Let's understand **covariant return type** using your example:

```text
TrainingInstitute
       ↓
     KodNest

Fresher
       ↓
 TrainedFresher
```

The key idea is:

> **The child class can override a method and return a more specific child type than the parent method.**

---

## 1. Create `TrainingInstitute`

```java
class TrainingInstitute {

    TrainingInstitute getInstitute() {
        return new TrainingInstitute();
    }
}
```

The parent method returns:

```text
TrainingInstitute
```

---

## 2. Create `KodNest`

```java
class KodNest extends TrainingInstitute {

}
```

Therefore:

```text
KodNest IS-A TrainingInstitute
```

---

## 3. Create `Fresher`

```java
class Fresher {

    Fresher getFresher() {
        return new Fresher();
    }
}
```

The method returns:

```text
Fresher
```

---

## 4. Create `TrainedFresher`

```java
class TrainedFresher extends Fresher {

}
```

Therefore:

```text
TrainedFresher IS-A Fresher
```

---

# 5. Covariant Return Type

Now let's override the method:

```java
class Fresher {

    Fresher getFresher() {
        return new Fresher();
    }
}

class TrainedFresher extends Fresher {

    @Override
    TrainedFresher getFresher() {
        return new TrainedFresher();
    }
}
```

Look carefully:

```text
Parent method:
Fresher getFresher()

Child method:
TrainedFresher getFresher()
```

Is this allowed?

### Yes! ✅

Because:

```text
TrainedFresher
       ↓
      IS-A
       ↓
    Fresher
```

Therefore `TrainedFresher` is a **covariant return type**.

---

# 6. Complete Program

```java
class TrainingInstitute {

    TrainingInstitute getInstitute() {
        return new TrainingInstitute();
    }
}

class KodNest extends TrainingInstitute {

    @Override
    KodNest getInstitute() {
        return new KodNest();
    }
}

class Fresher {

    Fresher getFresher() {
        return new Fresher();
    }
}

class TrainedFresher extends Fresher {

    @Override
    TrainedFresher getFresher() {
        return new TrainedFresher();
    }
}

class Demo {

    public static void main(String[] args) {

        TrainingInstitute t = new KodNest();

        TrainingInstitute institute = t.getInstitute();

        System.out.println(institute.getClass().getSimpleName());


        Fresher f = new TrainedFresher();

        Fresher fresher = f.getFresher();

        System.out.println(fresher.getClass().getSimpleName());
    }
}
```

### Output

```text
KodNest
TrainedFresher
```

---

# 7. Understand the First Example

We have:

```java
TrainingInstitute t = new KodNest();
```

So:

```text
Reference → TrainingInstitute
Object    → KodNest
```

Then:

```java
t.getInstitute();
```

At runtime, `KodNest`'s overridden method executes:

```java
KodNest getInstitute()
```

It returns:

```text
KodNest object
```

Even though the parent method originally returns:

```text
TrainingInstitute
```

This is valid because:

```text
KodNest IS-A TrainingInstitute
```

---

# 8. Understand the Second Example

We have:

```java
Fresher f = new TrainedFresher();
```

So:

```text
Reference → Fresher
Object    → TrainedFresher
```

Then:

```java
f.getFresher();
```

The overridden method in `TrainedFresher` executes:

```java
TrainedFresher getFresher()
```

It returns a:

```text
TrainedFresher object
```

Because:

```text
TrainedFresher IS-A Fresher
```

this is a valid **covariant return type**.

---

# 🧠 Easy Diagram

```text
TrainingInstitute
       ↑
       │ IS-A
       │
    KodNest

Parent:
TrainingInstitute getInstitute()

Child:
KodNest getInstitute()

       ↓
Covariant Return Type ✅
```

And:

```text
Fresher
   ↑
   │ IS-A
   │
TrainedFresher

Parent:
Fresher getFresher()

Child:
TrainedFresher getFresher()

       ↓
Covariant Return Type ✅
```

---

# ⭐ Golden Rule

Remember this pattern:

```java
class Parent {

    Parent fun() {
        return new Parent();
    }
}

class Child extends Parent {

    @Override
    Child fun() {
        return new Child();
    }
}
```

This is valid because:

```text
Child IS-A Parent
```

Therefore:

> **In method overriding, a child can return a more specific reference type than the parent method. This is called a covariant return type.**

### Your example:

```text
TrainingInstitute → KodNest
       ↓
Parent return       Child return

Fresher → TrainedFresher
       ↓
Parent return       Child return
```

**Same return type → valid ✅**
**Child/subtype return type → valid (covariant) ✅**
**Unrelated return type → invalid ❌**
