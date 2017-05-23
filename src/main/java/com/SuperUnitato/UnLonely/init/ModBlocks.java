package com.SuperUnitato.UnLonely.init;

import com.SuperUnitato.UnLonely.Reference;
import com.SuperUnitato.UnLonely.blocks.BlockAtm;


import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
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
		final ModelResourceLocation atm = new ModelResourceLocation(Reference.MOD_ID, "textures/gui/mainscreen.png");
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, atm);
	}

}

