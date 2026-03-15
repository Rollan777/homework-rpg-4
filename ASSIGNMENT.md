# Homework 4: Detailed Assignment Instructions

## Background Story
The game studio is launching a new raid mode. Raids include single units, parties, and nested squads. Skills also need multiple damage styles (physical, fire, ice, shadow) without creating dozens of duplicated skill classes.

Your job: implement **Bridge** and **Composite** to solve these architecture problems cleanly.

---

## Part 1: Composite Pattern - Raid Team Hierarchy

### The Problem
Your raid engine should treat a single fighter and a group of fighters the same way.

### Your Tasks
1. Complete `CombatNode` interface in `composite/CombatNode.java`.
2. Implement leaf units:
   - `HeroUnit`
   - `EnemyUnit`
3. Implement composites:
   - `PartyComposite`
   - `RaidGroup`
4. Support nesting (a `RaidGroup` can contain `PartyComposite` and other `RaidGroup` objects).

### Required Behavior
- `getAttackPower()` on composites returns the sum of alive children attack power.
- `takeDamage(int amount)` on composites distributes damage to alive children.
- `isAlive()` on composites returns true when at least one child is alive.
- `printTree(String indent)` prints readable hierarchy.

---

## Part 2: Bridge Pattern - Skills and Effects

### The Problem
You need multiple skill types and multiple effect types. Creating class-per-combination causes class explosion.

### Your Tasks
1. Complete `EffectImplementor` interface.
2. Implement effect classes:
   - `PhysicalEffect`
   - `FireEffect`
   - `IceEffect`
   - `ShadowEffect`
3. Complete abstract `Skill` class with effect delegation.
4. Implement refined abstractions:
   - `SingleTargetSkill`
   - `AreaSkill`

### Required Behavior
- Skills and effects vary independently.
- Any skill can use any effect implementor.
- `AreaSkill` can be applied against a composite target.

---

## Part 3: Integration - RaidEngine

### The Problem
The engine must operate on abstraction types only, not concrete `HeroUnit` or `EnemyUnit` classes.

### Your Tasks
1. Complete `RaidEngine.runRaid(...)` logic.
2. Ensure deterministic behavior using `setRandomSeed(long seed)`.
3. Implement round-based simulation:
   - Team A attacks Team B
   - Team B attacks Team A
   - Stop when one side has no alive nodes
4. Log battle steps in `RaidResult`.

### Rules
- Engine depends only on `CombatNode` and `Skill` abstractions.
- Dead nodes do not attack.
- AOE skill should affect all alive leaves under a target composite.

---

## Part 4: Main Demo

Complete `Main.java` to demonstrate:
1. Bridge combinations:
   - Same skill with different effects
   - Same effect with different skills
2. Composite hierarchy:
   - At least 1 nested group (group inside group)
3. Full raid simulation:
   - Run one battle and print winner, rounds, and log

---

## Part 5: UML Diagrams

Create two UML class diagrams:
1. Bridge diagram (`Skill`, `EffectImplementor`, concrete implementations)
2. Composite diagram (`CombatNode`, leaf/composite classes, engine dependency)

Diagrams must show:
- Classes/interfaces
- Inheritance/implementation
- Key methods
- Associations/dependencies

---

## Grading Rubric (Total: 100 points)

### Composite Pattern (30 points)
- Correct `CombatNode` abstraction: 8
- Leaf implementations: 8
- Composite nesting and aggregation: 14

### Bridge Pattern (30 points)
- Correct bridge interfaces/abstractions: 10
- 2+ skill abstractions and 3+ effect implementors: 12
- Independent variation proven in demo: 8

### Integration in RaidEngine (20 points)
- Uses abstractions only: 8
- Correct battle flow and end conditions: 8
- Deterministic run with seed: 4

### UML Diagrams (10 points)
- Bridge diagram correctness: 5
- Composite diagram correctness: 5

### Code Quality + Demo (10 points)
- Readable code, naming, encapsulation: 5
- Demo clarity and output quality: 5

---

## Common Pitfalls
- Making `RaidEngine` depend on concrete leaf classes.
- Hardcoding effect logic inside concrete skill classes.
- Treating composite like a plain list without component contract.
- Forgetting to skip dead units in round logic.

## Academic Integrity
You may discuss concepts and read references, but implementation must be your own.
