# Student Progress Checklist

## Phase 1: Understanding
- [ ] Read `README.md`
- [ ] Read `ASSIGNMENT.md`
- [ ] Review Bridge pattern basics
- [ ] Review Composite pattern basics
- [ ] Inspect all TODOs in `src/`

## Phase 2: Composite Implementation
- [ ] Complete `CombatNode` interface behavior
- [ ] Implement `HeroUnit` and `EnemyUnit`
- [ ] Implement `PartyComposite` and `RaidGroup`
- [ ] Support nested groups
- [ ] Verify `printTree()` output is readable

## Phase 3: Bridge Implementation
- [ ] Complete `EffectImplementor`
- [ ] Implement `PhysicalEffect`, `FireEffect`, `IceEffect`, `ShadowEffect`
- [ ] Complete abstract `Skill`
- [ ] Implement `SingleTargetSkill` and `AreaSkill`
- [ ] Verify skills and effects vary independently

## Phase 4: Integration
- [ ] Complete `RaidEngine.runRaid(...)`
- [ ] Handle dead nodes correctly
- [ ] Use deterministic seed
- [ ] Ensure engine depends on abstractions only

## Phase 5: Demo + UML
- [ ] Update `Main.java` with full demo
- [ ] Show at least one nested raid structure
- [ ] Show Bridge combinations clearly
- [ ] Create Bridge UML diagram
- [ ] Create Composite UML diagram

## Phase 6: Final Check
- [ ] Compile project successfully
- [ ] Run demo successfully
- [ ] Verify output is clear and complete
- [ ] Confirm all required files are included
