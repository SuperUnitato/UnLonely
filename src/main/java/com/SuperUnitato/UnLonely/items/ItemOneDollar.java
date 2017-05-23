package com.SuperUnitato.UnLonely.items;

import com.SuperUnitato.UnLonely.Reference;
import com.SuperUnitato.UnLonely.UnLonely;

import net.minecraft.item.Item;

public class ItemOneDollar extends Item {
	
	public ItemOneDollar(){
		
		setUnlocalizedName(Reference.UnLonelyItems.ONEDOLLAR.getUnlocalizedName());
		setRegistryName(Reference.UnLonelyItems.ONEDOLLAR.getRegistryName());
		
		setCreativeTab(UnLonely.tabUnLonely);
		
	}

}
