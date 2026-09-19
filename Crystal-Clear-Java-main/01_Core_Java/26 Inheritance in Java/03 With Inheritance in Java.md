# 🧒 With Inheritance in Java

Now let's solve the **duplicate-code problem** from the previous example.

We have three types of robots:

* 🥊 `FighterRobot`
* ⚽ `PlayerRobot`
* 👨‍🏫 `TeacherRobot`

All of them are robots, so they have some **common behaviors**.

Instead of writing those common methods three times, we create one **parent class** called `Robot`.

---

# 1. Robot — Parent Class 🤖

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

These are **common methods**.

All robots can:

```text
walk()
talk()
charge()
```

So we keep them in the parent class.

---

# 2. FighterRobot — Child Class 🥊

A Fighter Robot is a Robot.

So we write:

```java
class FighterRobot extends Robot {

    void fight() {
        System.out.println("Fighter robot is fighting");
    }
}
```

`FighterRobot` automatically gets the accessible common methods from `Robot`.

It also has its own specialized method:

```text
fight()
```

So:

```text
FighterRobot
 ├── walk()    ← inherited
 ├── talk()    ← inherited
 ├── charge()  ← inherited
 └── fight()   ← specialized
```

---

# 3. PlayerRobot — Child Class ⚽

A Player Robot is also a Robot.

```java
class PlayerRobot extends Robot {

    void play() {
        System.out.println("Player robot is playing");
    }
}
```

It gets:

```text
walk()
talk()
charge()
```

from `Robot`.

And it has its own:

```text
play()
```

So:

```text
PlayerRobot
 ├── walk()    ← inherited
 ├── talk()    ← inherited
 ├── charge()  ← inherited
 └── play()    ← specialized
```

---

# 4. TeacherRobot — Child Class 👨‍🏫

A Teacher Robot is also a Robot.

```java
class TeacherRobot extends Robot {

    void teach() {
        System.out.println("Teacher robot is teaching");
    }
}
```

It gets the common methods from `Robot`.

It also has its own specialized method:

```text
teach()
```

So:

```text
TeacherRobot
 ├── walk()    ← inherited
 ├── talk()    ← inherited
 ├── charge()  ← inherited
 └── teach()   ← specialized
```

---

# 5. Complete Program

```java
class Robot {

    // Common methods
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

class FighterRobot extends Robot {

    // Specialized method
    void fight() {
        System.out.println("Fighter robot is fighting");
    }
}

class PlayerRobot extends Robot {

    // Specialized method
    void play() {
        System.out.println("Player robot is playing");
    }
}

class TeacherRobot extends Robot {

    // Specialized method
    void teach() {
        System.out.println("Teacher robot is teaching");
    }
}

class Demo {

    public static void main(String[] args) {

        FighterRobot fighter = new FighterRobot();

        fighter.walk();
        fighter.talk();
        fighter.charge();
        fighter.fight();

        PlayerRobot player = new PlayerRobot();

        player.walk();
        player.talk();
        player.charge();
        player.play();

        TeacherRobot teacher = new TeacherRobot();

        teacher.walk();
        teacher.talk();
        teacher.charge();
        teacher.teach();
    }
}
```

---

# 6. Output

```text
Robot is walking
Robot is talking
Robot is charging
Fighter robot is fighting

Robot is walking
Robot is talking
Robot is charging
Player robot is playing

Robot is walking
Robot is talking
Robot is charging
Teacher robot is teaching
```

---

# 7. Understand the Structure 🧠

The relationship looks like this:

```text
                         Robot
                       PARENT CLASS
                           │
             ┌─────────────┼─────────────┐
             ↓             ↓             ↓
       FighterRobot   PlayerRobot   TeacherRobot
          CHILD          CHILD          CHILD
             │             │             │
          fight()        play()        teach()
```

The parent contains:

```text
COMMON METHODS
```

The children contain:

```text
SPECIALIZED METHODS
```

---

# 8. Common vs Specialized Methods

| Robot      | Specialized Child |
| ---------- | ----------------- |
| `walk()`   | `fight()`         |
| `talk()`   | `play()`          |
| `charge()` | `teach()`         |

### Common methods

These are useful for **all robots**:

```java
walk();
talk();
charge();
```

Therefore, they belong in:

```java
class Robot
```

### Specialized methods

These are specific to a particular robot:

```text
FighterRobot → fight()
PlayerRobot  → play()
TeacherRobot → teach()
```

Therefore, each child keeps its own special behavior.

---

# 9. Why Is This Better? ♻️

### Without inheritance

We had:

```text
FighterRobot → walk(), talk(), charge()
PlayerRobot  → walk(), talk(), charge()
TeacherRobot → walk(), talk(), charge()
```

The methods were repeated.

❌ Duplicate code.

### With inheritance

We have:

```text
Robot
 ├── walk()
 ├── talk()
 └── charge()
```

and:

```text
FighterRobot → fight()
PlayerRobot  → play()
TeacherRobot → teach()
```

The common code is written **only once**.

✅ Code reusability.

---

# 🧒 Fifth-Class Example

Think about a school.

Every student may have common activities:

```text
Student
 ├── eat()
 ├── sleep()
 └── study()
```

But different students may have special activities:

```text
SportsStudent → play()
MusicStudent  → sing()
ArtStudent    → draw()
```

Similarly:

```text
                 Robot
                   │
          Common abilities
       walk / talk / charge
                   │
       ┌───────────┼───────────┐
       ↓           ↓           ↓
    Fighter      Player      Teacher
      ↓            ↓            ↓
    fight()      play()      teach()
```

---

# ⭐ Golden Rule

> **With inheritance, common properties and behaviors are placed in a parent class, while child classes inherit the common functionality and add their own specialized functionality.**

### 🧠 Remember Forever

```text
             PARENT
              Robot
                ↓
        Common methods
     walk / talk / charge
                ↓
      ┌─────────┼─────────┐
      ↓         ↓         ↓
   Fighter    Player    Teacher
      ↓         ↓         ↓
   fight()    play()    teach()
```

### 🔥 Interview Answer

> **Inheritance allows child classes such as `FighterRobot`, `PlayerRobot`, and `TeacherRobot` to reuse common functionality from a parent `Robot` class using `extends`, while each child can provide its own specialized behavior.**
