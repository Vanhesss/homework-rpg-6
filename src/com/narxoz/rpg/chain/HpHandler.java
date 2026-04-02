package com.narxoz.rpg.chain;

import com.narxoz.rpg.arena.ArenaFighter;

public class HpHandler extends DefenseHandler {

    @Override
    public void handle(int incomingDamage, ArenaFighter target) {
        if (incomingDamage <= 0) {
            return;
        }

        target.takeDamage(incomingDamage);
        System.out.println("[HP] " + target.getName() + " took " + incomingDamage + " damage.");
    }
}
