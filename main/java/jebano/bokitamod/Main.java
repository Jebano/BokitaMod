package jebano.bokitamod;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jebano.bokitamod.item.BokitaItems;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("bokitamod")
public class Main {
	public static final String MOD_ID = "bokitamod";
	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);
	public static final ItemGroup ITEM_GROUP = new ItemGroup(MOD_ID) {
		@Override
		public ItemStack createIcon() {
			return new ItemStack(BokitaItems.EMPTY_PEPPER_SPRAY);
		}
	};

	public Main() {
		MinecraftForge.EVENT_BUS.register(this);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onCommonSetup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onClientSetup);
	}

	private void onCommonSetup(FMLCommonSetupEvent event) {
	}

	private void onClientSetup(FMLClientSetupEvent event) {
	}

	public static ResourceLocation createResource(String name) {
		return new ResourceLocation(MOD_ID, name);
	}

	public static ResourceLocation getEntityTexture(Entity entity) {
		return createResource("textures/entity/" + entity.getType().getRegistryName().getPath() + ".png");
	}
}