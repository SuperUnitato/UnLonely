package com.SuperUnitato.UnLonely.proxy;

import com.SuperUnitato.UnLonely.blocks.BlockAtm;

import items.ItemFiftyDollar;
import items.ItemFiveDollar;
import items.ItemOneDollar;
import items.ItemOnehundredDollar;
import items.ItemTenDollar;
import items.ItemTwentyDollar;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks {

	public static Block atm;

	public static void init() {

		atm = new BlockAtm();

	}

	public static void register() {

		registerBlock(atm);

	}

	private static void registerBlock(Block block) {

		GameRegistry.register(atm);
		ItemBlock item = new ItemBlock(block);
		item.setRegistryName(block.getRegistryName());
		GameRegistry.register(item);

	}

	public static void registerRenders() {

		registerRender(atm);

	}

	private static void registerRender(Block block) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0,
				new ModelResourceLocation(block.getRegistryName(), "inventory"));
	}

}
