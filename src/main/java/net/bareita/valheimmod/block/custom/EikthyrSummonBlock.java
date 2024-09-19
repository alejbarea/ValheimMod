package net.bareita.valheimmod.block.custom;

import net.bareita.valheimmod.entity.ModEntities;
import net.bareita.valheimmod.entity.custom.DeerEntity;
import net.bareita.valheimmod.entity.custom.EikthyrEntity;
import net.bareita.valheimmod.item.ModItems;
import net.bareita.valheimmod.util.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class EikthyrSummonBlock extends Block{

    public EikthyrSummonBlock(Properties p_49795_) {
        super(p_49795_);
    }



        protected ItemInteractionResult useItemOn(ItemStack pStack, BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHitResult) {
        if(pStack.is(ModTags.Items.DEER_TROPHY)) {
            EikthyrEntity deer = new EikthyrEntity(ModEntities.EIKTHYR.get(), pLevel);
            deer.setPos(pPos.getX(), pPos.getY(), pPos.getZ());
            pLevel.addFreshEntity(deer);
        } else {
            pPlayer.sendSystemMessage(Component.literal("You need a deer trophy!"));
        }
        return ItemInteractionResult.SUCCESS;
    }
}
