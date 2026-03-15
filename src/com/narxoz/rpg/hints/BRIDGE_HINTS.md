# Bridge Pattern Hints

## Goal
Separate skill abstraction from effect implementation so both can evolve independently.

## Mapping
- Abstraction: `Skill`
- Refined Abstractions: `SingleTargetSkill`, `AreaSkill`
- Implementor: `EffectImplementor`
- Concrete Implementors: `PhysicalEffect`, `FireEffect`, `IceEffect`, `ShadowEffect`

## What To Avoid
- Hardcoding fire/ice/shadow calculations inside each skill class.
- Creating classes like `FireSlash`, `IceSlash`, `FireStorm`, `IceStorm`.

## Check Yourself
- Can one skill work with multiple effects without code duplication?
- Can one effect be reused by multiple skills?
