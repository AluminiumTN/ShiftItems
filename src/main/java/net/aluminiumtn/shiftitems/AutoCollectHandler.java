package net.aluminiumtn.shiftitems;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.entity.BlockEntity;

public class AutoCollectHandler {
    public static void register() {
        PlayerBlockBreakEvents.BEFORE.register(AutoCollectHandler::onBlockBreak);
    }

    private static boolean onBlockBreak(World world, PlayerEntity player, BlockPos pos, BlockState state, BlockEntity blockEntity) {
        if (!world.isClient) {
            if (player.isSneaking()) {
                Block block = state.getBlock();
                ItemStack stack = new ItemStack(block.asItem());

                if (!stack.isEmpty()) {

                    if (!player.getInventory().insertStack(stack)) {
                        player.dropItem(stack, false); 
                    }

             
                    world.setBlockState(pos, state.getFluidState().getBlockState(), 3); 
                    
           
                    return false; 
                }
            }
        }
        return true; 
    }
}

