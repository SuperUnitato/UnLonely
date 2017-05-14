package com.SuperUnitato.UnLonely.packets;

import com.SuperUnitato.UnLonely.playerdata.IMoney;
import com.SuperUnitato.UnLonely.playerdata.MoneyProvider;

import init.ModItems;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageHandler implements IMessageHandler<PacketCreator, IMessage>{
	
	private int inventorySlots = 35;
	
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
		
		if(serverPlayer != null){
			System.out.println("not null");
		}
		
		switch(ID){
			//deposits
			case 0:
				if(serverPlayer.inventory.hasItemStack(one)){
					for(int i = 0; i < inventorySlots; i++){
						if(serverPlayer.inventory.getStackInSlot(i) == one){
							money.addBalance(1);
							serverPlayer.inventory.removeStackFromSlot(i);
							break;
						}
					}
				} else {
					
				}
				break;
				
			case 1:
				if(serverPlayer.inventory.hasItemStack(five)){
					for(int i = 0; i < inventorySlots; i++){
						if(serverPlayer.inventory.getStackInSlot(i) == five){
							money.addBalance(5);
							serverPlayer.inventory.removeStackFromSlot(i);
							break;
						}
					}
				} else {
					
				}
				
				break;
			
			case 2:
				if(serverPlayer.inventory.hasItemStack(ten)){
					for(int i = 0; i < inventorySlots; i++){
						if(serverPlayer.inventory.getStackInSlot(i) == ten){
							money.addBalance(10);
							serverPlayer.inventory.removeStackFromSlot(i);
							break;
						}
					}
				} else {
					
				}
				break;
				
			case 3:
				if(serverPlayer.inventory.hasItemStack(twenty)){
					for(int i = 0; i < inventorySlots; i++){
						if(serverPlayer.inventory.getStackInSlot(i) == twenty){
							money.addBalance(20);
							serverPlayer.inventory.removeStackFromSlot(i);
							break;
						}
					}
				} else {
					
				}
				break;
				
			case 4:
				if(serverPlayer.inventory.hasItemStack(fifty)){
					for(int i = 0; i < inventorySlots; i++){
						if(serverPlayer.inventory.getStackInSlot(i).isItemEqual(fifty)){
							System.out.println("70");
							money.addBalance(50);
							serverPlayer.inventory.removeStackFromSlot(i);
							break;
						}
					}
				} else {
					
				}
				break;
				
			case 5:
				if(serverPlayer.inventory.hasItemStack(onehundred)){
					for(int i = 0; i < inventorySlots; i++){
						if(serverPlayer.inventory.getStackInSlot(i) == onehundred){
							money.addBalance(100);
							serverPlayer.inventory.removeStackFromSlot(i);
							break;
						}
					}
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