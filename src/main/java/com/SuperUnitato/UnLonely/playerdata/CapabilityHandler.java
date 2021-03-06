package com.SuperUnitato.UnLonely.playerdata;

import com.SuperUnitato.UnLonely.Reference;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CapabilityHandler {
	
	public static final ResourceLocation MONEY_CAP = new ResourceLocation(Reference.MOD_ID, "money");
	public static final ResourceLocation SHOP_CAP = new ResourceLocation(Reference.MOD_ID, "shops");
	
	 @SubscribeEvent
	 public void attachCapability(AttachCapabilitiesEvent<Entity> event)

	 {

	 if (!(event.getObject() instanceof EntityPlayer)) return;
	 	
	 	event.addCapability(SHOP_CAP, new ShopProvider());
	 	event.addCapability(MONEY_CAP, new MoneyProvider());

	 }
	 
	}

