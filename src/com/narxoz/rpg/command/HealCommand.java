package com.narxoz.rpg.command;

import com.narxoz.rpg.arena.ArenaFighter;

public class HealCommand implements ActionCommand {
    private final ArenaFighter target;
    private final int healAmount;
    private int actualHealApplied;

    public HealCommand(ArenaFighter target, int healAmount) {
        this.target = target;
        this.healAmount = healAmount;
    }

    @Override
    public void execute() {
        int previousHealth = target.getHealth();
        int potionsBefore = target.getHealPotions();
        target.heal(healAmount);
        if (potionsBefore > target.getHealPotions()) {
            actualHealApplied = target.getHealth() - previousHealth;
        } else {
            actualHealApplied = 0;
        }
    }

    @Override
    public void undo() {
        target.takeDamage(actualHealApplied);
    }

    @Override
    public String getDescription() {
        return "Heal for " + healAmount + " HP";
    }
}
