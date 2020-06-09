package com.my.testmod.util;

import com.my.testmod.Tutorial;
import com.my.testmod.container.RubyChestContainer;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModContainerTypes {

    public static final DeferredRegister<ContainerType<?>> CONTAINER_TYPES = new DeferredRegister<>(ForgeRegistries.CONTAINERS, Tutorial.MOD_ID);

    public static final RegistryObject<ContainerType<RubyChestContainer>> RUBY_CHEST = CONTAINER_TYPES.register("ruby_chest", ()-> IForgeContainerType.create(RubyChestContainer::new));

}
