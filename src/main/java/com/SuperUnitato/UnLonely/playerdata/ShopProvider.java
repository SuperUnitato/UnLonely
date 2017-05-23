package com.SuperUnitato.UnLonely.playerdata;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class ShopProvider implements ICapabilitySerializable<NBTBase>{
	
	@CapabilityInject(IShop.class)
	
	public static final Capability<IShop> SHOP_CAP = null;
	
	private IShop instance = SHOP_CAP.getDefaultInstance();

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		return capability == SHOP_CAP;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		return capability == SHOP_CAP ? SHOP_CAP.<T> cast(this.instance) : null;
	}

	@Override
	public NBTBase serializeNBT() {
		return SHOP_CAP.getStorage().writeNBT(SHOP_CAP, this.instance, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt) {
		SHOP_CAP.getStorage().readNBT(SHOP_CAP, this.instance, null, nbt);
	}

}
