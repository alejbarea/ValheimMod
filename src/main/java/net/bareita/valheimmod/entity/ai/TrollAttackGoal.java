package net.bareita.valheimmod.entity.ai;

import net.bareita.valheimmod.entity.custom.TrollEntity;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;

public class TrollAttackGoal extends MeleeAttackGoal {
    private final TrollEntity entity;
    private int attackDelay = 40;
    private int ticksUntilNextAttack = 40;
    private boolean shouldCountTillNextAttack = false;
    private int ATTACK_RANGE = 5;
    public TrollAttackGoal(PathfinderMob pMob, double pSpeedModifier, boolean pFollowingTargetEvenIfNotSeen) {
        super(pMob, pSpeedModifier, pFollowingTargetEvenIfNotSeen);
        this.entity = ((TrollEntity) pMob);
    }

    @Override
    protected void checkAndPerformAttack(LivingEntity pEnemy) {
        if (isEnemyWithinAttackDistance(pEnemy)) {
            this.shouldCountTillNextAttack = true;

            if(isTimeToStartAttackAnimation()) {
                this.entity.setAttacking(true);
            }

            if(isTimeToAttack()) {
                this.mob.getLookControl().setLookAt(pEnemy.getX(), pEnemy.getEyeY(), pEnemy.getZ());
                performAttack(pEnemy);
            }
        } else {
            resetAttackCooldown();
            this.shouldCountTillNextAttack = false;
            this.entity.setAttacking(false);
            this.entity.attackAnimationTimeout = 0;
        }
    }

    private boolean isEnemyWithinAttackDistance(LivingEntity pEnemy) {
        int diffX = Math.abs(pEnemy.getBlockX() - this.entity.getBlockX());
        int diffY = Math.abs(pEnemy.getBlockY() - this.entity.getBlockY());;
        int diffZ = Math.abs(pEnemy.getBlockZ() - this.entity.getBlockZ());;

        return diffX + diffY + diffZ <= this.ATTACK_RANGE; // Make a private int called attack range (I have mine set to 5 and it works alright)
    }

    protected void resetAttackCooldown() {
        this.ticksUntilNextAttack = this.adjustedTickDelay(attackDelay * 2);
    }

    protected boolean isTimeToAttack() {
        return this.ticksUntilNextAttack <= 0;
    }

    protected boolean isTimeToStartAttackAnimation() {
        return this.ticksUntilNextAttack <= attackDelay;
    }

    protected int getTicksUntilNextAttack() {
        return this.ticksUntilNextAttack;
    }


    protected void performAttack(LivingEntity pEnemy) {
        this.resetAttackCooldown();
        this.mob.swing(InteractionHand.MAIN_HAND);
        this.mob.doHurtTarget(pEnemy);
    }

    @Override
    public void start() {
        super.start();
        this.attackDelay = 40;
        this.ticksUntilNextAttack = 40;
    }

    @Override
    public void tick() {
        super.tick();
        if(this.shouldCountTillNextAttack) {
            this.ticksUntilNextAttack = Math.max(this.ticksUntilNextAttack - 1, 0);
        }
    }

    @Override
    public void stop() {
        this.entity.setAttacking(false);
        super.stop();
    }
}

