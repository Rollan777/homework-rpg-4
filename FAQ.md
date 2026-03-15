# FAQ

## 1) Is this a continuation of previous homework?
Yes. You are extending the same RPG context, but this project is self-contained.

## 2) Why not use Strategy instead of Bridge?
Bridge is required because you are separating two changing dimensions:
- Skill abstraction hierarchy
- Effect implementor hierarchy

## 3) Can a composite contain another composite?
Yes. Nested groups are required.

## 4) How should composite damage distribution work?
Use a simple deterministic approach (for example, split evenly across alive children). Document your choice.

## 5) Must I reuse HW3 BattleEngine?
You can reuse ideas, but this assignment expects the provided `RaidEngine` starter to be completed.

## 6) Do I need unit tests?
Not mandatory, but strongly recommended. Main demo must clearly prove behavior.

## 7) How many Bridge combinations should I show?
At minimum:
- One skill with two different effects
- Two different skills sharing one effect

## 8) What should UML include?
Bridge and Composite diagrams with classes, interfaces, relations, and key methods.
