package com.SuperUnitato.UnLonely.playerdata;

import com.SuperUnitato.UnLonely.packets.PacketCreator;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;

public class EventHandler {

	@SubscribeEvent
	 public void onPlayerLogsIn(PlayerLoggedInEvent event)
	 {
		 EntityPlayer player = event.player;
		
		 IMoney money = player.getCapability(MoneyProvider.MONEY_CAP, null);
		 IShop shops = player.getCapability(ShopProvider.SHOP_CAP, null);
		 
		 SumPacketInstance.INSTANCE.sendToServer(new PacketCreator(-1));
	 }
	
	@SubscribeEvent
	public void onPlayerClone(PlayerEvent.Clone event)
	{
		 EntityPlayer player = event.getEntityPlayer();
		 
		 IMoney money = player.getCapability(MoneyProvider.MONEY_CAP, null);
		 IMoney oldMoney = event.getOriginal().getCapability(MoneyProvider.MONEY_CAP, null);
		 money.setBalance(oldMoney.getBalance());
		 
		 IShop shops = player.getCapability(ShopProvider.SHOP_CAP, null);
		 IShop oldShops = event.getOriginal().getCapability(ShopProvider.SHOP_CAP, null);
		 shops.setShopCount(oldShops.getShopCount());
	}
}
