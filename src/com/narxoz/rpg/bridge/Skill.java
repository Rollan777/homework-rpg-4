package com.narxoz.rpg.bridge;

import com.narxoz.rpg.composite.CombatNode;

public abstract class Skill {
    private final String skillName;
    private final int basePower;
    private final EffectImplementor effect;

    protected Skill(String skillName, int basePower, EffectImplementor effect) {
        this.skillName = skillName;
        this.basePower = basePower;
        this.effect = effect;
    }

    public String getSkillName() {
        return skillName;
    }

    public int getBasePower() {
        return basePower;
    }

    public String getEffectName() {
        return effect.getEffectName();
    }

    protected int resolvedDamage() {
        return effect.computeDamage(basePower);
    }

    public abstract void cast(CombatNode target);
}
