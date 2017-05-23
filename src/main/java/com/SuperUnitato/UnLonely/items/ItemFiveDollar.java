package com.SuperUnitato.UnLonely.items;

import com.SuperUnitato.UnLonely.Reference;
import com.SuperUnitato.UnLonely.UnLonely;

import net.minecraft.item.Item;

public class ItemFiveDollar extends Item {
	
	public ItemFiveDollar(){
		
		setUnlocalizedName(Reference.UnLonelyItems.FIVEDOLLAR.getUnlocalizedName());
		setRegistryName(Reference.UnLonelyItems.FIVEDOLLAR.getRegistryName());
		
		setCreativeTab(UnLonely.tabUnLonely);
		
	}

}