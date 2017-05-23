package com.SuperUnitato.UnLonely.packets;


import com.SuperUnitato.UnLonely.init.ModItems;
import com.SuperUnitato.UnLonely.playerdata.IMoney;
import com.SuperUnitato.UnLonely.playerdata.MoneyProvider;
import com.SuperUnitato.UnLonely.playerdata.SumPacketInstance;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageHandler implements IMessageHandler<PacketCreator, IMessage>{
	
	private int slot;
	
	ItemStack one = new ItemStack(ModItems.onedollar);
	ItemStack five = new ItemStack(ModItems.fivedollar);
	ItemStack ten = new ItemStack(ModItems.tendollar);
	ItemStack twenty = new ItemStack(ModItems.twentydollar);
	ItemStack fifty = new ItemStack(ModItems.fiftydollar);
	ItemStack onehundred = new ItemStack(ModItems.onehundreddollar);
	
	@Override
	public IMessage onMessage(PacketCreator message, MessageContext ctx) {
		
		EntityPlayerMP serverPlayer = ctx.getServerHandler().playerEntity;
		IMoney money = serverPlayer.getCapability(MoneyProvider.MONEY_CAP, null);
		int ID = message.toSend;

		//money seems to be null
		if(!(money != null)){
			System.out.println("money bad");
		}
		
		switch(ID){
			//deposits
			case 0:
				if(serverPlayer.inventory.hasItemStack(one)){
					slot = serverPlayer.inventory.getSlotFor(one);
					serverPlayer.inventory.decrStackSize(slot, 1);
					money.addBalance(1);
					SumPacketInstance.INSTANCE.sendTo(new PacketCreator(ID), serverPlayer);
				} else {
					
				}
				break;
				
			case 1:
				if(serverPlayer.inventory.hasItemStack(five)){
					slot = serverPlayer.inventory.getSlotFor(five);
					serverPlayer.inventory.decrStackSize(slot, 1);
					money.addBalance(5);
				} else {
					
				}
				
				break;
			
			case 2:
				if(serverPlayer.inventory.hasItemStack(ten)){
						slot = serverPlayer.inventory.getSlotFor(ten);
						serverPlayer.inventory.decrStackSize(slot, 1);
						money.addBalance(10);
				} else {
					
				}
				break;
				
			case 3:
				if(serverPlayer.inventory.hasItemStack(twenty)){
						slot = serverPlayer.inventory.getSlotFor(twenty);
						serverPlayer.inventory.decrStackSize(slot, 1);
						money.addBalance(20);
				} else {
					
				}
				break;
				
			case 4:
				if(serverPlayer.inventory.hasItemStack(fifty)){
					slot = serverPlayer.inventory.getSlotFor(fifty);
					serverPlayer.inventory.decrStackSize(slot, 1);
					money.addBalance(50);
					System.out.println(money.getBalance());
				} else {
					
				}
				break;
				
			case 5:
				if(serverPlayer.inventory.hasItemStack(onehundred)){
					slot = serverPlayer.inventory.getSlotFor(onehundred);
					serverPlayer.inventory.decrStackSize(slot, 1);
					money.addBalance(100);
				} else {
					
				}
				break;
				
			//withdrawls
			case 6:
				if(money.getBalance() >= 1){
					serverPlayer.inventory.addItemStackToInventory(new ItemStack(ModItems.onedollar, 1));
					money.takeBalance(1);
				} else {
					
				}
				break;
				
			case 7:
				if(money.getBalance() >= 5){
					serverPlayer.inventory.addItemStackToInventory(new ItemStack(ModItems.fivedollar, 1));
					money.takeBalance(5);
				} else {
					
				}
				break;
				
			case 8:
				if(money.getBalance() >= 10){
					serverPlayer.inventory.addItemStackToInventory(new ItemStack(ModItems.tendollar, 1));
					money.takeBalance(10);
				} else {
					
				}
				break;
				
			case 9:
				if(money.getBalance() >= 20){
					serverPlayer.inventory.addItemStackToInventory(new ItemStack(ModItems.twentydollar, 1));
					money.takeBalance(20);
				} else {
					
				}
				break;
				
			case 10:
				if(money.getBalance() >= 50){
					serverPlayer.inventory.addItemStackToInventory(new ItemStack(ModItems.fiftydollar, 1));
					money.takeBalance(50);
				} else {
					
				}
				break;
				
			case 11:
				if(money.getBalance() >= 100){
					serverPlayer.inventory.addItemStackToInventory(new ItemStack(ModItems.onehundreddollar, 1));
					money.takeBalance(100);
				} else {
					
				}
				break;
		}
		return null;
	}
}
