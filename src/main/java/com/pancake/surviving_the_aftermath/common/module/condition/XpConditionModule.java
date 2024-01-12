package com.pancake.surviving_the_aftermath.common.module.condition;

import com.mojang.serialization.Codec;
import com.pancake.surviving_the_aftermath.api.module.IConditionModule;
import com.pancake.surviving_the_aftermath.common.init.ModAftermathModule;
import net.minecraft.world.entity.player.Player;

public class XpConditionModule extends PlayerConditionModule{
    public static final String IDENTIFIER = "xp_condition";
    public static final Codec<XpConditionModule> CODEC = Codec.INT.fieldOf("xp").xmap(XpConditionModule::new, XpConditionModule::xp).codec();
    public int xp;

    public XpConditionModule(int xp) {
        this.xp = xp;
    }
    public XpConditionModule() {
    }

    @Override
    public boolean checkCondition(Player player) {
        return player.experienceLevel >= xp;
    }

    @Override
    public Codec<? extends IConditionModule> codec() {
        return CODEC;
    }

    @Override
    public IConditionModule type() {
        return ModAftermathModule.XP_CONDITION.get();
    }
}
