package com.github.rochedo.planetsandstars.mixin.common;

import com.github.rochedo.planetsandstars.api.PlayerExtension;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public abstract class MixinPlayerEntity extends LivingEntity implements PlayerExtension {
    private boolean require_oxygen = true;
    private boolean radioactivity_resistence = false;

    protected MixinPlayerEntity(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "writeCustomDataToNbt", at = @At("RETURN"))
    private void pas_writeDroidToPlayerTag(NbtCompound tag, CallbackInfo ci) {
        tag.putBoolean("planetsandstars:require_oxygen", require_oxygen);
        tag.putBoolean("planetsnadstars:radioactivity_resistence", radioactivity_resistence);
    }

    @Inject(method = "readCustomDataFromNbt", at = @At("RETURN"))
    private void pas_readDroidFromPlayerTag(NbtCompound tag, CallbackInfo ci) {
        require_oxygen = tag.getBoolean("planetsandstars:require_oxygen");
        radioactivity_resistence = tag.getBoolean("planetsandstars:radioactivity_resistence");
    }

    @Override
    public boolean getRequireOxygen() {
        return require_oxygen;
    }

    @Override
    public boolean getRadioactivityResistance() {
        return radioactivity_resistence;
    }

    public void setRequire_oxygen(boolean require_oxygen) {
        this.require_oxygen = require_oxygen;
    }

    public void setRadioactivity_resistence(boolean radioactivity_resistence) {
        this.radioactivity_resistence = radioactivity_resistence;
    }
}
