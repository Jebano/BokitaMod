package jebano.bokitamod.handlers;

import jebano.bokitamod.Main;
import jebano.bokitamod.item.EmptyPepperSpray;
import jebano.bokitamod.item.PepperSpray;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.IForgeRegistryEntry;

@EventBusSubscriber(modid = "bokitamod", bus = EventBusSubscriber.Bus.MOD)
public class RegistryHandler {
	@SubscribeEvent
	public static void onItemRegistry(RegistryEvent.Register<Item> event) {
		ItemGroup main = Main.ITEM_GROUP;
		event.getRegistry().registerAll(
				setRegistryName("empty_pepper_spray", new EmptyPepperSpray(new Item.Properties().maxStackSize(1).group(main))),
				setRegistryName("pepper_spray", new PepperSpray(new Item.Properties().maxStackSize(1).group(main))));
	}

	@SubscribeEvent
	public static void onEntityTypeRegistry(RegistryEvent.Register<EntityType<?>> event) {
	}

	@SubscribeEvent
	public static void onSoundEventRegistry(RegistryEvent.Register<SoundEvent> event) {
	}

	public static <T extends IForgeRegistryEntry<?>> T setRegistryName(String name, T entry) {
		entry.setRegistryName(Main.createResource(name));
		return entry;
	}
}