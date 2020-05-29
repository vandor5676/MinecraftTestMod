package com.my.testmod.events;

import com.my.testmod.Tutorial;
import com.my.testmod.util.RegistryHandler;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Tutorial.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class TestJumpEvent {
    @SubscribeEvent
    public static void  TestJumpEvent(LivingEvent.LivingJumpEvent event)
    {
        //Tutorial.LOGGER.info("Jump event fired!");
        LivingEntity livingEntity = event.getEntityLiving();
        //World world = livingEntity.getEntityWorld();

        //world.setBlockState(livingEntity.getPosition().add(0,5,0) , RegistryHandler.RUBY_BLOCK.get().getDefaultState());

        //livingEntity.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST,600,3));
       // livingEntity.setGlowing(true);
    }
}
