package com.SuperUnitato.UnLonely.playerdata;

import com.SuperUnitato.UnLonely.Reference;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CapabilityHandler {
	
	public static final ResourceLocation MONEY_CAP = new ResourceLocation(Reference.MOD_ID, "money");
	
	 @SubscribeEvent
	 public void attachCapability(AttachCapabilitiesEvent.Entity event)

	 {

	 if (!(event.getEntity() instanceof EntityPlayer)) return;

	 event.addCapability(MONEY_CAP, new MoneyProvider());

	 }
	 
	 @SubscribeEvent
	 public void onPlayerClone(PlayerEvent.Clone event)

	 {

	  EntityPlayer player = event.getEntityPlayer();

	  IMoney money = player.getCapability(MoneyProvider.MONEY_CAP, null);

	  IMoney oldMoney = event.getOriginal().getCapability(MoneyProvider.MONEY_CAP, null);



	  money.setBalance(oldMoney.getBalance());

	 }

	}

