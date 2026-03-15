package com.narxoz.rpg.bridge;

public class FireEffect implements EffectImplementor {
    @Override
    public int computeDamage(int basePower) {
        return Math.max(0, (int) Math.round(basePower * 1.2));
    }

    @Override
    public String getEffectName() {
        return "Fire";
    }
}
