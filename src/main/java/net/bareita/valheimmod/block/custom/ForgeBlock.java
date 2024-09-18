package net.bareita.valheimmod.block.custom;

import net.bareita.valheimmod.util.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class ForgeBlock extends Block {
    public ForgeBlock(Properties pProperties) {
        super(pProperties);
    }





//    private boolean isPickaxe(ItemStack pStack) {
//        return pStack.getItem() instanceof PickaxeItem;
//    }
//    @Override
//    protected ItemInteractionResult useItemOn(ItemStack pStack, BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHitResult) {
//        if(pStack.is(ModTags.Items.METAL_PICKAXES)) {
//            pStack.setDamageValue(0);
//
//        }
//        return ItemInteractionResult.SUCCESS;
//    }
}
