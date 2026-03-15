package com.narxoz.rpg;

import com.narxoz.rpg.battle.RaidEngine;
import com.narxoz.rpg.battle.RaidResult;
import com.narxoz.rpg.bridge.AreaSkill;
import com.narxoz.rpg.bridge.FireEffect;
import com.narxoz.rpg.bridge.IceEffect;
import com.narxoz.rpg.bridge.PhysicalEffect;
import com.narxoz.rpg.bridge.ShadowEffect;
import com.narxoz.rpg.bridge.SingleTargetSkill;
import com.narxoz.rpg.bridge.Skill;
import com.narxoz.rpg.composite.EnemyUnit;
import com.narxoz.rpg.composite.HeroUnit;
import com.narxoz.rpg.composite.PartyComposite;
import com.narxoz.rpg.composite.RaidGroup;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Homework 4 Demo: Bridge + Composite ===\n");

        HeroUnit warrior = new HeroUnit("Arthas", 140, 30);
        HeroUnit mage = new HeroUnit("Jaina", 90, 40);
        HeroUnit priest = new HeroUnit("Anduin", 100, 15);

        EnemyUnit goblin = new EnemyUnit("Goblin", 70, 20);
        EnemyUnit orc = new EnemyUnit("Orc", 120, 25);
        EnemyUnit necromancer = new EnemyUnit("Necromancer", 80, 35);

        PartyComposite heroes = new PartyComposite("Heroes");
        heroes.add(warrior);
        heroes.add(mage);
        heroes.add(priest);

        PartyComposite frontline = new PartyComposite("Frontline");
        frontline.add(goblin);
        frontline.add(orc);

        PartyComposite backline = new PartyComposite("Backline");
        backline.add(necromancer);

        RaidGroup enemies = new RaidGroup("Enemy Raid");
        enemies.add(frontline);
        enemies.add(backline);

        System.out.println("--- Team Structures ---");
        heroes.printTree("");
        enemies.printTree("");

        Skill slashFire = new SingleTargetSkill("Slash", 20, new FireEffect());
        Skill slashIce = new SingleTargetSkill("Slash", 20, new IceEffect());
        Skill stormFire = new AreaSkill("Storm", 15, new FireEffect());
        Skill strikePhysical = new SingleTargetSkill("Strike", 18, new PhysicalEffect());
        Skill novaShadow = new AreaSkill("Nova", 14, new ShadowEffect());

        System.out.println("\n--- Bridge Preview ---");
        System.out.println(slashFire.getSkillName() + " using " + slashFire.getEffectName());
        System.out.println(slashIce.getSkillName() + " using " + slashIce.getEffectName());
        System.out.println(stormFire.getSkillName() + " using " + stormFire.getEffectName());
        System.out.println(strikePhysical.getSkillName() + " using " + strikePhysical.getEffectName());
        System.out.println(novaShadow.getSkillName() + " using " + novaShadow.getEffectName());

        RaidEngine engine = new RaidEngine().setRandomSeed(42L);
        RaidResult result = engine.runRaid(heroes, enemies, slashFire, stormFire);

        System.out.println("\n--- Raid Result ---");
        System.out.println("Winner: " + result.getWinner());
        System.out.println("Rounds: " + result.getRounds());
        for (String line : result.getLog()) {
            System.out.println(line);
        }

        System.out.println("\n=== Demo Complete ===");
    }
}