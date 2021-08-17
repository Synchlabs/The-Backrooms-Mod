package net.ludocrypt.exdimapi.util;

import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.ludocrypt.exdimapi.api.ExtraDimension;
import net.minecraft.client.MinecraftClient;
import net.minecraft.sound.MusicSound;

@FunctionalInterface
public interface MusicController {

	public void accept(ExtraDimension dim, MinecraftClient client, CallbackInfoReturnable<MusicSound> ci);

}
