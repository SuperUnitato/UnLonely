package com.SuperUnitato.UnLonely.packets;


import com.SuperUnitato.UnLonely.init.ModItems;
import com.SuperUnitato.UnLonely.playerdata.IMoney;
import com.SuperUnitato.UnLonely.playerdata.MoneyProvider;
import com.SuperUnitato.UnLonely.playerdata.SumPacketInstance;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageHandler implements IMessageHandler<PacketCreator, IMessage>{
	
	private int slot;
	
	//neeed to add shops capability
	
	ItemStack one = new ItemStack(ModItems.onedollar);
	ItemStack five = new ItemStack(ModItems.fivedollar);
	ItemStack ten = new ItemStack(ModItems.tendollar);
	ItemStack twenty = new ItemStack(ModItems.twentydollar);
	ItemStack fifty = new ItemStack(ModItems.fiftydollar);
	ItemStack onehundred = new ItemStack(ModItems.onehundreddollar);
	
	@Override
	public IMessage onMessage(PacketCreator message, MessageContext ctx) {
		
		if(ctx.side.isServer()){
			EntityPlayerMP serverPlayer = ctx.getServerHandler().playerEntity;
		
		
			IMoney money = serverPlayer.getCapability(MoneyProvider.MONEY_CAP, null);
			int ID = message.toSend;
			
			switch(ID){
				//for syncing on log in
				case -1:
					final int ammount = money.getBalance();
					SumPacketInstance.INSTANCE.sendTo(new PacketCreator(-1, ammount), serverPlayer);
					break;
					
				//deposits
				case 0:
					if(serverPlayer.inventory.hasItemStack(one)){
							slot = serverPlayer.inventory.getSlotFor(one);
							serverPlayer.inventory.decrStackSize(slot, 1);
							money.addBalance(1);	
							SumPacketInstance.INSTANCE.sendTo(message, serverPlayer);
					} 
					break;
					
				case 1:
					if(serverPlayer.inventory.hasItemStack(five)){
							slot = serverPlayer.inventory.getSlotFor(five);
							serverPlayer.inventory.decrStackSize(slot, 1);
							money.addBalance(5);
							SumPacketInstance.INSTANCE.sendTo(message, serverPlayer);
					} 
					break;
				
				case 2:
					if(serverPlayer.inventory.hasItemStack(ten)){
							slot = serverPlayer.inventory.getSlotFor(ten);
							serverPlayer.inventory.decrStackSize(slot, 1);
							money.addBalance(10);
							SumPacketInstance.INSTANCE.sendTo(message, serverPlayer);
					}
					break;
					
				case 3:
					if(serverPlayer.inventory.hasItemStack(twenty)){
							slot = serverPlayer.inventory.getSlotFor(twenty);
							serverPlayer.inventory.decrStackSize(slot, 1);
							money.addBalance(20);
							SumPacketInstance.INSTANCE.sendTo(message, serverPlayer);
					}
					break;
					
				case 4:
					if(serverPlayer.inventory.hasItemStack(fifty)){
							slot = serverPlayer.inventory.getSlotFor(fifty);
							serverPlayer.inventory.decrStackSize(slot, 1);
							money.addBalance(50);
							SumPacketInstance.INSTANCE.sendTo(message, serverPlayer);
					} 
					break;
					
				case 5:
					if(serverPlayer.inventory.hasItemStack(onehundred)){
							slot = serverPlayer.inventory.getSlotFor(onehundred);
							serverPlayer.inventory.decrStackSize(slot, 1);
							money.addBalance(100);
							SumPacketInstance.INSTANCE.sendTo(message, serverPlayer);
					} 
					break;
					
				//withdrawls
				case 6:
					if(money.getBalance() >= 1){
							serverPlayer.inventory.addItemStackToInventory(new ItemStack(ModItems.onedollar, 1));
							money.takeBalance(1);
							SumPacketInstance.INSTANCE.sendTo(message, serverPlayer);
					}
					break;
					
				case 7:
					if(money.getBalance() >= 5){
							serverPlayer.inventory.addItemStackToInventory(new ItemStack(ModItems.fivedollar, 1));
							money.takeBalance(5);
							SumPacketInstance.INSTANCE.sendTo(message, serverPlayer);
					}
					break;
					
				case 8:
					if(money.getBalance() >= 10){
							serverPlayer.inventory.addItemStackToInventory(new ItemStack(ModItems.tendollar, 1));
							money.takeBalance(10);
							SumPacketInstance.INSTANCE.sendTo(message, serverPlayer);
					} 
					break;
					
				case 9:
					if(money.getBalance() >= 20){
							serverPlayer.inventory.addItemStackToInventory(new ItemStack(ModItems.twentydollar, 1));
							money.takeBalance(20);
							SumPacketInstance.INSTANCE.sendTo(message, serverPlayer);
					} 
					break;
					
				case 10:
					if(money.getBalance() >= 50){
							serverPlayer.inventory.addItemStackToInventory(new ItemStack(ModItems.fiftydollar, 1));
							money.takeBalance(50);
							SumPacketInstance.INSTANCE.sendTo(message, serverPlayer);
					}
					break;
					
				case 11:
					if(money.getBalance() >= 100){
							serverPlayer.inventory.addItemStackToInventory(new ItemStack(ModItems.onehundreddollar, 1));
							money.takeBalance(100);
							SumPacketInstance.INSTANCE.sendTo(message, serverPlayer);
					}
					break;
			}
		//client side
		} else if(ctx.side.isClient()){
			
			EntityPlayerSP serverPlayer = Minecraft.getMinecraft().player;
	
			IMoney money = serverPlayer.getCapability(MoneyProvider.MONEY_CAP, null);
			int ID = message.toSend;
			
			//no need to check since the packet is sent from server side where the conditions have been checked
			
			switch(ID){
			//sync
			case -1:
				money.setBalance(message.ammount);
				break;
			
				//deposits
				case 0:
						money.addBalance(1);	
					break;
					
				case 1:
						money.addBalance(5);
					break;
				
				case 2:
					money.addBalance(10);
					break;
					
				case 3:
					money.addBalance(20);
					break;
					
				case 4:
					money.addBalance(50); 
					break;
					
				case 5:
					money.addBalance(100);
					break;
					
				//withdrawls
				case 6:
					money.takeBalance(1);
					break;
					
				case 7:
					money.takeBalance(5);
					break;
					
				case 8:
					money.takeBalance(10);
					break;
					
				case 9:
					money.takeBalance(20);
					break;
					
				case 10:
					money.takeBalance(50);
					break;
					
				case 11:
					money.takeBalance(100);
					break;
		}
	}
		return null;
	}}
