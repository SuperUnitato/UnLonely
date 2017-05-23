package com.SuperUnitato.UnLonely.items;

import com.SuperUnitato.UnLonely.Reference;
import com.SuperUnitato.UnLonely.UnLonely;

import net.minecraft.item.Item;

public class ItemOnehundredDollar extends Item {
	
	public ItemOnehundredDollar(){
		
		setUnlocalizedName(Reference.UnLonelyItems.ONEHUNDREDDOLLAR.getUnlocalizedName());
		setRegistryName(Reference.UnLonelyItems.ONEHUNDREDDOLLAR.getRegistryName());
		
		setCreativeTab(UnLonely.tabUnLonely);
		
	}

}
