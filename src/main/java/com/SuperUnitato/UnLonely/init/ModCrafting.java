package com.SuperUnitato.UnLonely.init;


import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModCrafting {

	public static void register() {

		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.tendollar), Items.IRON_INGOT,
				new ItemStack(Items.DYE, 1, 2), Items.PAPER);
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.tendollar, 2), ModItems.twentydollar);
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.tendollar), ModItems.fivedollar, ModItems.fivedollar);
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.twentydollar), Items.GOLD_INGOT, Items.PAPER,
				new ItemStack(Items.DYE, 1, 2));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.twentydollar), ModItems.tendollar, ModItems.tendollar);
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.fiftydollar), Items.DIAMOND, Items.PAPER,
				new ItemStack(Items.DYE, 1, 2));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.fiftydollar, 2), ModItems.onehundreddollar);
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.fivedollar, 2), ModItems.tendollar);
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.onedollar, 5), ModItems.fivedollar);
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.onehundreddollar), ModItems.fiftydollar,
				ModItems.fiftydollar);
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.fivedollar), ModItems.onedollar, ModItems.onedollar,
				ModItems.onedollar, ModItems.onedollar, ModItems.onedollar);

		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.atm), "IGI", "IPI", "IRI", 'I', Blocks.IRON_BLOCK, 'G',
				Blocks.GLASS_PANE, 'P', Items.PAPER, 'R', Blocks.REDSTONE_BLOCK);

	}

}
