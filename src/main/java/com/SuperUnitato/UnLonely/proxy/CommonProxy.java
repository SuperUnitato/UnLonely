package com.SuperUnitato.UnLonely.proxy;

import com.SuperUnitato.UnLonely.packets.MessageHandler;
import com.SuperUnitato.UnLonely.packets.PacketCreator;
import com.SuperUnitato.UnLonely.playerdata.CapabilityHandler;
import com.SuperUnitato.UnLonely.playerdata.EventHandler;
import com.SuperUnitato.UnLonely.playerdata.IMoney;
import com.SuperUnitato.UnLonely.playerdata.IShop;
import com.SuperUnitato.UnLonely.playerdata.Money;
import com.SuperUnitato.UnLonely.playerdata.SumPacketInstance;
import com.SuperUnitato.UnLonely.playerdata.MoneyStorage;
import com.SuperUnitato.UnLonely.playerdata.Shop;
import com.SuperUnitato.UnLonely.playerdata.ShopStorage;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;

public class CommonProxy {
	
	public void preInit(FMLPreInitializationEvent event){
		
	}
	
	public void init(FMLInitializationEvent event){
		
		EventHandler EHandler = new EventHandler();
		MinecraftForge.EVENT_BUS.register(EHandler);
		
		CapabilityHandler CHandler = new CapabilityHandler();
		MinecraftForge.EVENT_BUS.register(CHandler);
		
		CapabilityManager.INSTANCE.register(IMoney.class, new MoneyStorage(), Money.class);
		CapabilityManager.INSTANCE.register(IShop.class, new ShopStorage(), Shop.class);
		
		SumPacketInstance.INSTANCE.registerMessage(MessageHandler.class, PacketCreator.class, 0, Side.SERVER);
		SumPacketInstance.INSTANCE.registerMessage(MessageHandler.class, PacketCreator.class, 1, Side.CLIENT);
	}
	
	public void postInit(FMLPostInitializationEvent event){
		
	}
}
