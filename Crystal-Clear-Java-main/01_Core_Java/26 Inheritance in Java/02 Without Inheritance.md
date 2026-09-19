# 🧒 Without Inheritance

Let's understand **why inheritance is needed** by first seeing the problem when we **don't use inheritance**.

Imagine we have three different types of robots:

* 🥊 **Fighter Robot**
* ⚽ **Player Robot**
* 👨‍🏫 **Teacher Robot**

All three robots have some **common behaviors**.

For example:

```text
Fighter Robot → walk(), talk(), charge()
Player Robot  → walk(), talk(), charge()
Teacher Robot → walk(), talk(), charge()
```

If we don't use inheritance, we may end up writing the same methods again and again.

---

# 1. Fighter Robot

```java
class FighterRobot {

    void walk() {
        System.out.println("Robot is walking");
    }

    void talk() {
        System.out.println("Robot is talking");
    }

    void charge() {
        System.out.println("Robot is charging");
    }

    void fight() {
        System.out.println("Fighter robot is fighting");
    }
}
```

The Fighter Robot has:

```text
walk()
talk()
charge()
fight()
```

---

# 2. Player Robot

Now we create a Player Robot.

```java
class PlayerRobot {

    void walk() {
        System.out.println("Robot is walking");
    }

    void talk() {
        System.out.println("Robot is talking");
    }

    void charge() {
        System.out.println("Robot is charging");
    }

    void play() {
        System.out.println("Player robot is playing");
    }
}
```

Notice something?

We copied:

```java
walk()
talk()
charge()
```

again.

---

# 3. Teacher Robot

Now let's create a Teacher Robot.

```java
class TeacherRobot {

    void walk() {
        System.out.println("Robot is walking");
    }

    void talk() {
        System.out.println("Robot is talking");
    }

    void charge() {
        System.out.println("Robot is charging");
    }

    void teach() {
        System.out.println("Teacher robot is teaching");
    }
}
```

Again we copied:

```java
walk()
talk()
charge()
```

---

# 4. The Problem 🚨

Look at the three classes:

```text
FighterRobot
 ├── walk()
 ├── talk()
 ├── charge()
 └── fight()

PlayerRobot
 ├── walk()
 ├── talk()
 ├── charge()
 └── play()

TeacherRobot
 ├── walk()
 ├── talk()
 ├── charge()
 └── teach()
```

The same methods appear in **three different classes**.

```text
walk()   → repeated 3 times
talk()   → repeated 3 times
charge() → repeated 3 times
```

This creates **duplicate code**.

---

# 5. Why Is Duplicate Code a Problem?

Imagine we later decide that the robot should say:

```text
"Robot is walking using AI"
```

Now we have to change `walk()` in:

```text
FighterRobot
PlayerRobot
TeacherRobot
```

That's annoying. 😵

If there are 20 robot classes, we may have to change the same method in 20 places.

---

# 6. Visualize the Problem

```text
             COMMON ROBOT BEHAVIOR
                  ❌ No reuse
                     │
        ┌────────────┼────────────┐
        ↓            ↓            ↓
   FighterRobot  PlayerRobot  TeacherRobot
        │            │            │
     walk()        walk()        walk()
     talk()        talk()        talk()
    charge()      charge()      charge()
        │            │            │
        ↓            ↓            ↓
     Duplicate     Duplicate     Duplicate
       code          code          code
```

This is exactly the problem that inheritance helps solve.

---

# 7. The Better Idea

Instead of writing common methods inside every robot class, we can create one common parent:

```java
class Robot {

    void walk() {
        System.out.println("Robot is walking");
    }

    void talk() {
        System.out.println("Robot is talking");
    }

    void charge() {
        System.out.println("Robot is charging");
    }
}
```

Then:

```java
class FighterRobot extends Robot {

    void fight() {
        System.out.println("Fighter robot is fighting");
    }
}
```

```java
class PlayerRobot extends Robot {

    void play() {
        System.out.println("Player robot is playing");
    }
}
```

```java
class TeacherRobot extends Robot {

    void teach() {
        System.out.println("Teacher robot is teaching");
    }
}
```

Now:

```text
                    Robot
                      │
             ┌────────┼────────┐
             ↓        ↓        ↓
         Fighter    Player   Teacher
         Robot      Robot     Robot
             │        │        │
           fight()  play()   teach()
```

Common methods are written **once** in `Robot`.

---

# ⭐ The Main Lesson

### Without inheritance:

```text
Repeated methods
      ↓
Duplicate code
      ↓
More maintenance
```

### With inheritance:

```text
Common methods
      ↓
Parent class
      ↓
Child classes
      ↓
Code reusability ♻️
```

### 🧠 Remember Forever

> **Without inheritance, common functionality may have to be repeated in multiple classes, resulting in duplicate code. Inheritance allows us to place common functionality in a parent class and reuse it in child classes.**
