package com.narxoz.rpg.composite;

import java.util.List;

public interface CombatNode {
    String getName();
    int getHealth();
    int getAttackPower();
    void takeDamage(int amount);
    boolean isAlive();
    List<CombatNode> getChildren();
    void printTree(String indent);
}