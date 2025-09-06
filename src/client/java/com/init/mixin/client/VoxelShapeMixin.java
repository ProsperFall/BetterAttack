package com.init.mixin.client;

import com.init.AttackThoughGrassClientSide;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(VoxelShape.class)
public class VoxelShapeMixin {
	@Inject(method = "raycast", at = @At("RETURN"), cancellable = true)
	private void reCheckReturnValue(Vec3d start, Vec3d end, BlockPos pos, CallbackInfoReturnable<BlockHitResult> cir) {
		ClientWorld world = MinecraftClient.getInstance().world;
		ClientPlayerEntity player = MinecraftClient.getInstance().player;
		boolean needCheck = false;
		if(player != null && world != null) {
			ItemStack itemStack = player.getStackInHand(Hand.MAIN_HAND);
			if(AttackThoughGrassClientSide.contain(AttackThoughGrassClientSide.weapon, new StringBuilder(itemStack.getItem().toString())))
			{
				needCheck = true;
			}
		}
		if(cir.getReturnValue() != null && world != null && needCheck){
			BlockHitResult blockHitResult = cir.getReturnValue();
			BlockPos blockPos = blockHitResult.getBlockPos();
			BlockState blockState = world.getBlockState(blockPos);
			Block block = blockState.getBlock();

			if(AttackThoughGrassClientSide.contain(AttackThoughGrassClientSide.blocksAllowedToIgnore,new StringBuilder(block.toString()))){
				cir.setReturnValue(null);
			}
		}
	}
}