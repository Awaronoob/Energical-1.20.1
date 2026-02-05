package net.awaronoob.energical.block.custom;

import net.awaronoob.energical.block.entity.custom.ItemDisplayBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.datafix.fixes.BlockEntityShulkerBoxColorFix;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class ItemDisplayBlock extends BaseEntityBlock {

    public static final VoxelShape SHAPE = Block.box(0, 0, 0, 16, 12, 16);

    public ItemDisplayBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }

    @Override
    public void onRemove(BlockState pState, Level pLevel, BlockPos pPos,
                         BlockState pNewState, boolean pIsMoving) {

        if(pState.getBlock() != pNewState.getBlock()) {
            if(pLevel.getBlockEntity(pPos) instanceof ItemDisplayBlockEntity itemDisplayBlockEntity) {
                itemDisplayBlockEntity.drops();
                pLevel.updateNeighbourForOutputSignal(pPos, this);
            }
        }

        super.onRemove(pState, pLevel, pPos, pNewState, pIsMoving);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos,
                                 Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        ItemStack itemstack = pPlayer.getItemInHand(pHand);

        if (pLevel.getBlockEntity(pPos) instanceof ItemDisplayBlockEntity itemDisplayBlockEntity) {
            if(itemDisplayBlockEntity.inventory.getStackInSlot(0).isEmpty() && itemstack.isEmpty()) {
                itemDisplayBlockEntity.inventory.insertItem(0, itemstack.copy(), false);
                itemstack.shrink(1);
                pLevel.playSound(pPlayer, pPos, SoundEvents.ITEM_PICKUP, SoundSource.BLOCKS, 1f, 2f);
            } else if(itemstack.isEmpty()) {
                ItemStack stackOnItemDisplay = itemDisplayBlockEntity.inventory.extractItem(0, 1, false);
                if (stackOnItemDisplay != ItemStack.EMPTY) {
                    pPlayer.setItemInHand(InteractionHand.MAIN_HAND, stackOnItemDisplay);
                    itemDisplayBlockEntity.clearContents();
                    pLevel.playSound(pPlayer, pPos, SoundEvents.ITEM_PICKUP, SoundSource.BLOCKS, 1f, 1f);
                }
            }
        }

        return InteractionResult.SUCCESS;

    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new ItemDisplayBlockEntity(blockPos, blockState);
    }
}
