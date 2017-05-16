package com.SuperUnitato.UnLonely.playerdata;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTPrimitive;
import net.minecraft.nbt.NBTTagFloat;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

public class storage implements Capability.IStorage<IMoney>{

	@Override
	public NBTBase writeNBT(Capability<IMoney> capability, IMoney instance, EnumFacing side) {
		return new NBTTagInt(instance.getBalance());
	}

	@Override
	public void readNBT(Capability<IMoney> capability, IMoney instance, EnumFacing side, NBTBase nbt) {
		instance.setBalance(((NBTPrimitive) nbt).getInt());
	}

	

}
