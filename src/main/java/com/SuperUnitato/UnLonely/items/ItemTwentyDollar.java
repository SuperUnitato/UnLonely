package com.SuperUnitato.UnLonely.items;

import com.SuperUnitato.UnLonely.Reference;
import com.SuperUnitato.UnLonely.UnLonely;

import net.minecraft.item.Item;

public class ItemTwentyDollar extends Item {
	
	public ItemTwentyDollar(){
		
		setUnlocalizedName(Reference.UnLonelyItems.TWENTYDOLLAR.getUnlocalizedName());
		setRegistryName(Reference.UnLonelyItems.TWENTYDOLLAR.getRegistryName());
		
		setCreativeTab(UnLonely.tabUnLonely);
	}

}
