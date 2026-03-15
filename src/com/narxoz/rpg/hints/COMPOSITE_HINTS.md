# Composite Pattern Hints

## Goal
Treat single units and groups through one shared interface (`CombatNode`).

## Mapping
- Component: `CombatNode`
- Leaf: `HeroUnit`, `EnemyUnit` (via `UnitLeaf`)
- Composite: `PartyComposite`, `RaidGroup`

## Key Behavior
- Composite delegates operations to children.
- Aggregations (`getHealth`, `getAttackPower`) should reflect alive members.
- Nested composites must work recursively.

## What To Avoid
- Engine logic that checks concrete class type with `instanceof`.
- Separate code paths for unit vs group in battle logic.

## Check Yourself
- Can the same engine method receive either a single leaf or a nested group?
- Does tree printing show hierarchy clearly?
