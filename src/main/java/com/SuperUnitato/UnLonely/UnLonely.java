package com.SuperUnitato.UnLonely;

import com.SuperUnitato.UnLonely.client.gui.MoneyOverlay;
import com.SuperUnitato.UnLonely.init.ModBlocks;
import com.SuperUnitato.UnLonely.init.ModCrafting;
import com.SuperUnitato.UnLonely.init.ModItems;
import com.SuperUnitato.UnLonely.packets.MessageHandler;
import com.SuperUnitato.UnLonely.packets.PacketCreator;
import com.SuperUnitato.UnLonely.playerdata.SumPacketInstance;
import com.SuperUnitato.UnLonely.proxy.CommonProxy;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION, acceptedMinecraftVersions = Reference.ACCEPTED_VERSIONS)

public class UnLonely {
	
	@Instance
	public static UnLonely instnace;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
	@EventHandler
	public void PreInit(FMLPreInitializationEvent event)
	{	
		
		ModItems.init();
		ModItems.register();
		ModBlocks.init();
		ModBlocks.register();
		proxy.preInit(event);

	}
	
	@EventHandler
	public void Init(FMLInitializationEvent event)
	{
		ModCrafting.register();
		SumPacketInstance.INSTANCE.registerMessage(MessageHandler.class, PacketCreator.class, 0, Side.SERVER);
		SumPacketInstance.INSTANCE.registerMessage(MessageHandler.class, PacketCreator.class, 1, Side.CLIENT);
		proxy.init(event);
		
	}
	
	@EventHandler
	public void PostInit(FMLPostInitializationEvent event)
	{
		MinecraftForge.EVENT_BUS.register(new MoneyOverlay());
		proxy.postInit(event);
	}
	
	public static CreativeTabs tabUnLonely = new CreativeTabs("tab_unlonely"){
		
		@Override
		public ItemStack getTabIconItem(){
			return new ItemStack(ModItems.fiftydollar);
		}
		
	};

}
