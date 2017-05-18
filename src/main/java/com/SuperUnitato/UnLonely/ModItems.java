package com.SuperUnitato.UnLonely;

import items.ItemFiftyDollar;
import items.ItemFiveDollar;
import items.ItemOneDollar;
import items.ItemOnehundredDollar;
import items.ItemTenDollar;
import items.ItemTwentyDollar;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {

	public static Item onedollar;
	public static Item fivedollar;
	public static Item tendollar;
	public static Item twentydollar;
	public static Item fiftydollar;
	public static Item onehundreddollar;

	public static void init() {

		onedollar = new ItemOneDollar();
		fivedollar = new ItemFiveDollar();
		tendollar = new ItemTenDollar();
		twentydollar = new ItemTwentyDollar();
		fiftydollar = new ItemFiftyDollar();
		onehundreddollar = new ItemOnehundredDollar();

	}

	public static void register() {

		GameRegistry.register(onedollar);
		GameRegistry.register(fivedollar);
		GameRegistry.register(tendollar);
		GameRegistry.register(twentydollar);
		GameRegistry.register(fiftydollar);
		GameRegistry.register(onehundreddollar);

	}

	public static void registerRenders() {

		registerRender(onedollar);
		registerRender(fivedollar);
		registerRender(tendollar);
		registerRender(twentydollar);
		registerRender(fiftydollar);
		registerRender(onehundreddollar);

	}

	private static void registerRender(Item item) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0,
				new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}

}
