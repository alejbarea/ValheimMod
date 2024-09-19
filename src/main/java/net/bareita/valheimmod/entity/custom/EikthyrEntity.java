package net.bareita.valheimmod.entity.custom;

import net.bareita.valheimmod.entity.ModEntities;
import net.bareita.valheimmod.entity.ai.EikthyrAttackGoal;
import net.bareita.valheimmod.item.ModItems;
import net.bareita.valheimmod.sound.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.OutgoingChatMessage;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.BossEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.WitherSkull;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LightLayer;
import org.jetbrains.annotations.Nullable;


public class EikthyrEntity extends Monster {


    private static final EntityDataAccessor<Boolean> ATTACKING = SynchedEntityData.defineId(EikthyrEntity.class, EntityDataSerializers.BOOLEAN);
    private final ServerBossEvent bossEvent = (ServerBossEvent)new ServerBossEvent(
            this.getDisplayName(), BossEvent.BossBarColor.PURPLE, BossEvent.BossBarOverlay.PROGRESS
    )
            .setDarkenScreen(true);

    public EikthyrEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.defineSynchedData(new SynchedEntityData.Builder(this));
    }

    @Override
    public void startSeenByPlayer(ServerPlayer pServerPlayer) {
        super.startSeenByPlayer(pServerPlayer);
        this.bossEvent.addPlayer(pServerPlayer);
    }

    @Override
    public void stopSeenByPlayer(ServerPlayer pServerPlayer) {
        super.stopSeenByPlayer(pServerPlayer);
        this.bossEvent.removePlayer(pServerPlayer);
    }


    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new WaterAvoidingRandomStrollGoal(this, 1.1D));
        this.goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, 3f));
        this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this,Player.class,10,true,false,null)); // Target only when hurt
        this.goalSelector.addGoal(3, new EikthyrAttackGoal(this, 1.0D, false)); // Attack when provoked

    }

    public void summonLightningAttack(int lightningCount, double radius) {
        if (!this.level().isClientSide()) { // Make sure it's server-side
            ServerLevel serverLevel = (ServerLevel) this.level();

            for (int i = 0; i < lightningCount; i++) {
                // Generate random positions around the mob
                double offsetX = Math.floor((random.nextDouble() - 0.5) * 2 * radius);
                double offsetZ = Math.floor((random.nextDouble() - 0.5) * 2 * radius);

                BlockPos lightningPos = this.blockPosition().offset((int) offsetX, 0, (int) offsetZ);

                // Create the LightningBolt entity at the random position
                LightningBolt lightningBolt = EntityType.LIGHTNING_BOLT.create(serverLevel);
                if (lightningBolt != null) {
                    lightningBolt.moveTo(lightningPos.getX(), lightningPos.getY(), lightningPos.getZ());
                    serverLevel.addFreshEntity(lightningBolt);
                }
            }
        }
    }


    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 500D)
                .add(Attributes.FOLLOW_RANGE, 24D)
                .add(Attributes.MOVEMENT_SPEED, 0.4f)
                .add(Attributes.ARMOR_TOUGHNESS, 5f)
                .add(Attributes.ATTACK_KNOCKBACK, 6f)
                .add(Attributes.ATTACK_DAMAGE, 20f)
                .add(Attributes.FLYING_SPEED, 20f);
    }

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public final AnimationState attackAnimationState = new AnimationState();
    public int attackAnimationTimeout = 0;


    @Override
    public void tick() {
        super.tick();
        this.bossEvent.setProgress(this.getHealth() / this.getMaxHealth());
        if(this.level().isClientSide()) {
            setupAnimationStates();
        }
        if (this.tickCount % 200 == 0) {
            summonLightningAttack(5, 10); // Summons 5 lightning strikes within a radius of 10 blocks
        }
    }
    private void setupAnimationStates() {
        if(this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.tickCount);
        } else {
            --this.idleAnimationTimeout;
        }

        if(this.isAttacking() && attackAnimationTimeout <= 0) {
            attackAnimationTimeout = 80; // Length in ticks of the animation
            attackAnimationState.start(this.tickCount);
        } else {
            --this.idleAnimationTimeout;
        }

        if(!this.isAttacking()) {
            attackAnimationState.stop();
        }
    }

    @Override
    protected void updateWalkAnimation(float pPartialTick) {
        float f;
        if(this.getPose() == Pose.STANDING) {
            f = Math.min(pPartialTick*6F, 1F);
        } else {
            f = 0;
        }
        this.walkAnimation.update(f, 0.2f);
    }

    public void setAttacking(boolean attacking) {
        this.entityData.set(ATTACKING, attacking);
    }

    public boolean isAttacking() {
        return this.entityData.get(ATTACKING);
    }



    @Override
    protected void defineSynchedData(SynchedEntityData.Builder pBuilder) {
        super.defineSynchedData(pBuilder);
        pBuilder.define(ATTACKING,false);
    }


    @Override
    protected @Nullable SoundEvent getAmbientSound() {
        return ModSounds.EIKTHYR_AMBIENT.get();
    }

    @Override
    protected @Nullable SoundEvent getHurtSound(DamageSource pDamageSource) {
        return ModSounds.EIKTHYR_HURT.get();
    }

    @Override
    protected @Nullable SoundEvent getDeathSound() {
        return ModSounds.EIKTHYR_DEATH.get();
    }

    @Override
    public boolean hurt(DamageSource pSource, float pAmount) {
        if (pSource.is(DamageTypeTags.IS_LIGHTNING) || pSource.is(DamageTypeTags.IS_FIRE)) {
            // Ignore the damage from lightning bolts
            return false;
        }

        // Handle other damage types as normal
        return super.hurt(pSource, pAmount);
    }

    @Override
    public boolean isOnFire() {
        return false;
    }
}
