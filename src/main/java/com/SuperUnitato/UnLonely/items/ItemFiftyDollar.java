package com.SuperUnitato.UnLonely.items;

import com.SuperUnitato.UnLonely.Reference;
import com.SuperUnitato.UnLonely.UnLonely;

import net.minecraft.item.Item;

public class ItemFiftyDollar extends Item {
	
	public ItemFiftyDollar(){
		
		setUnlocalizedName(Reference.UnLonelyItems.FIFTYDOLLAR.getUnlocalizedName());
		setRegistryName(Reference.UnLonelyItems.FIFTYDOLLAR.getRegistryName());
		
		setCreativeTab(UnLonely.tabUnLonely);
		
	}

}
