package com.my.testmod.util;

import com.my.testmod.Tutorial;
import com.my.testmod.client.gui.RubyChestScreen;
import net.minecraft.client.gui.ScreenManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = Tutorial.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {
    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event)
    {
        ScreenManager.registerFactory(ModContainerTypes.RUBY_CHEST.get(), RubyChestScreen::new);



    }
}
