package com.narxoz.rpg.chain;

import com.narxoz.rpg.arena.ArenaFighter;

public class BlockHandler extends DefenseHandler {
    private final double blockPercent;

    public BlockHandler(double blockPercent) {
        this.blockPercent = blockPercent;
    }

    @Override
    public void handle(int incomingDamage, ArenaFighter target) {
        int blockedAmount = (int) (incomingDamage * blockPercent);
        int remainingDamage = Math.max(0, incomingDamage - blockedAmount);
        System.out.println("[Block] " + target.getName() + " blocked " + blockedAmount + " damage.");
        passToNext(remainingDamage, target);
    }
}
