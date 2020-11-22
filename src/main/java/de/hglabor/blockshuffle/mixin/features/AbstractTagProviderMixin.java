package de.hglabor.blockshuffle.mixin.features;

import net.minecraft.data.server.AbstractTagProvider;
import net.minecraft.tag.Tag;
import net.minecraft.util.registry.Registry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractTagProvider.class)
public abstract class AbstractTagProviderMixin<T> {

    @Inject(method = "getOrCreateTagBuilder", at = @At("HEAD"))
    private void injected(Tag.Identified<T> identified, CallbackInfoReturnable<AbstractTagProvider.ObjectBuilder<T>> cir) {
        System.out.println("triggered");
    }


}
