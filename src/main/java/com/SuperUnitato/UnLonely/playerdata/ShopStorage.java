package com.SuperUnitato.UnLonely.playerdata;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTPrimitive;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

public class ShopStorage implements Capability.IStorage<IShop>{
	
	@Override
	public NBTBase writeNBT(Capability<IShop> capability, IShop instance, EnumFacing side) {
		return new NBTTagInt(instance.getShopCount());
	}

	@Override
	public void readNBT(Capability<IShop> capability, IShop instance, EnumFacing side, NBTBase nbt) {
		instance.setShopCount(((NBTPrimitive) nbt).getInt());
	}


}
