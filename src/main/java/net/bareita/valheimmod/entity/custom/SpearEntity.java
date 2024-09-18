package net.bareita.valheimmod.entity.custom;

import net.bareita.valheimmod.entity.ModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Blaze;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.bareita.valheimmod.item.ModItems;
import net.minecraft.world.phys.EntityHitResult;

public class SpearEntity extends ThrowableItemProjectile {
    private int damage;
    private float attackDamage;
    private char spearType;
    public SpearEntity(EntityType<? extends ThrowableItemProjectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public SpearEntity(Level pLevel) {
        super(ModEntities.SPEAR_ENTITY.get(), pLevel);
    }

    public SpearEntity(Level pLevel, LivingEntity livingEntity, int damage, float attackDamage, char spearType) {
        super(ModEntities.SPEAR_ENTITY.get(), livingEntity,pLevel);
        this.damage = damage;
        this.attackDamage = attackDamage;
        this.spearType = spearType;
    }



    @Override
    protected Item getDefaultItem() {
        if(spearType == 's') {
            return ModItems.SPEAR.get();
        } else {
            return ModItems.BRONZE_SPEAR.get();
        }


    }

    @Override
    protected void onHitBlock(BlockHitResult pResult) {
        if(!this.level().isClientSide()) {
            this.level().broadcastEntityEvent(this, ((byte) 3));
            ItemStack itemStack;
            if(spearType == 's') {
                itemStack = new ItemStack(ModItems.SPEAR.get());
            } else {
                itemStack = new ItemStack(ModItems.BRONZE_SPEAR.get());
            }

            itemStack.setDamageValue(this.damage+1);
            ItemEntity itemEntity = new ItemEntity(this.level(), this.getX(), this.getY(), this.getZ(), itemStack);
            this.level().addFreshEntity(itemEntity);
            this.remove(RemovalReason.DISCARDED);
        }
        super.onHitBlock(pResult);
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        super.onHitEntity(pResult);
        Entity entity = pResult.getEntity();
        entity.hurt(this.damageSources().thrown(this, this.getOwner()), this.attackDamage);
    }
}
