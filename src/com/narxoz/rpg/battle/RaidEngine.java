package com.narxoz.rpg.battle;

import com.narxoz.rpg.bridge.Skill;
import com.narxoz.rpg.composite.CombatNode;

import java.util.Random;

public class RaidEngine {
    private static final int MAX_ROUNDS = 20;
    private Random random = new Random(1L);

    public RaidEngine setRandomSeed(long seed) {
        this.random = new Random(seed);
        return this;
    }

    public RaidResult runRaid(CombatNode teamA, CombatNode teamB, Skill teamASkill, Skill teamBSkill) {
        if (teamA == null || teamB == null) {
            throw new IllegalArgumentException("Teams must not be null.");
        }
        if (teamASkill == null || teamBSkill == null) {
            throw new IllegalArgumentException("Skills must not be null.");
        }
        if (!teamA.isAlive() || !teamB.isAlive()) {
            throw new IllegalArgumentException("Both teams must be alive before the raid starts.");
        }

        RaidResult result = new RaidResult();
        result.addLine("Raid started: " + teamA.getName() + " vs " + teamB.getName());

        int round = 0;

        while (teamA.isAlive() && teamB.isAlive() && round < MAX_ROUNDS) {
            round++;
            result.addLine("");
            result.addLine("=== Round " + round + " ===");

            int beforeB = teamB.getHealth();
            boolean critA = random.nextInt(100) < 10;
            int extraA = critA ? Math.max(1, teamASkill.getBasePower() / 2) : 0;

            result.addLine(teamA.getName() + " uses " + teamASkill.getSkillName()
                    + " [" + teamASkill.getEffectName() + "] on " + teamB.getName()
                    + (critA ? " (CRITICAL STRIKE!)" : ""));

            teamASkill.cast(teamB);
            if (critA) {
                teamB.takeDamage(extraA);
            }

            int dealtA = Math.max(0, beforeB - teamB.getHealth());
            result.addLine("Damage dealt by " + teamA.getName() + ": " + dealtA);
            result.addLine(teamA.getName() + " HP=" + teamA.getHealth() + " | " + teamB.getName() + " HP=" + teamB.getHealth());

            if (!teamB.isAlive()) {
                break;
            }

            int beforeA = teamA.getHealth();
            boolean critB = random.nextInt(100) < 10;
            int extraB = critB ? Math.max(1, teamBSkill.getBasePower() / 2) : 0;

            result.addLine(teamB.getName() + " uses " + teamBSkill.getSkillName()
                    + " [" + teamBSkill.getEffectName() + "] on " + teamA.getName()
                    + (critB ? " (CRITICAL STRIKE!)" : ""));

            teamBSkill.cast(teamA);
            if (critB) {
                teamA.takeDamage(extraB);
            }

            int dealtB = Math.max(0, beforeA - teamA.getHealth());
            result.addLine("Damage dealt by " + teamB.getName() + ": " + dealtB);
            result.addLine(teamA.getName() + " HP=" + teamA.getHealth() + " | " + teamB.getName() + " HP=" + teamB.getHealth());
        }

        result.setRounds(round);

        if (teamA.isAlive() && !teamB.isAlive()) {
            result.setWinner(teamA.getName());
        } else if (!teamA.isAlive() && teamB.isAlive()) {
            result.setWinner(teamB.getName());
        } else if (!teamA.isAlive() && !teamB.isAlive()) {
            result.setWinner("Draw");
        } else {
            if (teamA.getHealth() > teamB.getHealth()) {
                result.setWinner(teamA.getName());
            } else if (teamB.getHealth() > teamA.getHealth()) {
                result.setWinner(teamB.getName());
            } else {
                result.setWinner("Draw");
            }
            result.addLine("Maximum rounds reached.");
        }

        result.addLine("");
        result.addLine("Raid finished. Winner: " + result.getWinner());
        return result;
    }
}