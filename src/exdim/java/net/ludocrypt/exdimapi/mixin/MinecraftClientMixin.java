package net.ludocrypt.exdimapi.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.ludocrypt.exdimapi.ExtraDims;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.sound.MusicSound;

@Environment(EnvType.CLIENT)
@Mixin(MinecraftClient.class)
public class MinecraftClientMixin {

	@Shadow
	public ClientPlayerEntity player;

	@Shadow
	public ClientWorld world;

	@Environment(EnvType.CLIENT)
	@Inject(method = "getMusicType", at = @At("HEAD"), cancellable = true)
	private void exDimApi_getMusicType(CallbackInfoReturnable<MusicSound> ci) {
		if (this.player != null) {
			ExtraDims.EXTRA_DIMENSIONS.forEach((id, dim) -> {
				dim.MUSIC_SOUND_CONTROLLER.accept(dim, ((MinecraftClient) (Object) this), ci);
			});
		}
	}
}
