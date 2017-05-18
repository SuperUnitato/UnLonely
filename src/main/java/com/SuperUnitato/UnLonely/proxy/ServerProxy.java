package com.SuperUnitato.UnLonely.proxy;

import com.SuperUnitato.UnLonely.packets.MessageHandler;
import com.SuperUnitato.UnLonely.packets.PacketCreator;
import com.SuperUnitato.UnLonely.playerdata.CapabilityHandler;
import com.SuperUnitato.UnLonely.playerdata.EventHandler;
import com.SuperUnitato.UnLonely.playerdata.IMoney;
import com.SuperUnitato.UnLonely.playerdata.Money;
import com.SuperUnitato.UnLonely.playerdata.SumPacketInstance;
import com.SuperUnitato.UnLonely.playerdata.storage;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;

public class ServerProxy extends CommonProxy{
	
	@Override
	public void preInit(FMLPreInitializationEvent event){
		
		super.preInit(event);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		
		super.init(event);
	}

	@Override
	public void postInit(FMLPostInitializationEvent event){
		super.postInit(event);
	}


}
