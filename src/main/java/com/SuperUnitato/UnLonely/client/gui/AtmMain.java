package com.SuperUnitato.UnLonely.client.gui;

import java.io.IOException;

import com.SuperUnitato.UnLonely.Reference;
import com.SuperUnitato.UnLonely.playerdata.IMoney;
import com.SuperUnitato.UnLonely.playerdata.MoneyProvider;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ResourceLocation;

public class AtmMain extends GuiScreen{
	
	final ResourceLocation screen = new ResourceLocation(Reference.MOD_ID, "textures/gui/mainscreen.png");
	int guiHeight = 250;
	int guiWidth = 125;
	
	GuiButton deposit;
	GuiButton withdrawl;
	final int DEPOSIT = 0;
	final int WITHDRAWL = 1;
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks){
		
		int ammount = Minecraft.getMinecraft().player.getCapability(MoneyProvider.MONEY_CAP, null).getBalance();
		//String SAmmount = Integer.toString(ammount);
		
		int centerX = (width/2) - (guiWidth/2);
		int centerY = (height/2) - (guiHeight/2);
		Minecraft.getMinecraft().renderEngine.bindTexture(screen);
		drawTexturedModalRect(centerX, centerY, 0, 0, guiWidth, guiHeight);
		fontRendererObj.drawString("SuperU Banking", (width / 2) - fontRendererObj.getStringWidth("SuperU Banking") / 2, centerY + 5, 0x504745);
		fontRendererObj.drawString("You currently have $" + ammount, (width / 2) - fontRendererObj.getStringWidth("You Currently have $ " + ammount) / 2, centerY + 75, 0x2be367);
		
		super.drawScreen(mouseX, mouseY, partialTicks);
		super.updateScreen();
	}
	
	@Override
	public void initGui(){
		int buttonCenterX = (width / 2) - (guiWidth / 2) + (width / 30);
		int buttonCenterY = (height / 2) - (guiHeight / 2) + 20;
		buttonList.clear();
		buttonList.add(deposit = new GuiButton(DEPOSIT, buttonCenterX, buttonCenterY, 100, 20, "Deposit"));
		buttonList.add(withdrawl = new GuiButton(WITHDRAWL, buttonCenterX, buttonCenterY + 85, 100, 20, "Withdrawl"));
		super.initGui();
		super.updateScreen();
	}
	
	@Override
	public void actionPerformed(GuiButton Button) throws IOException{
		switch (Button.id){
		
		case DEPOSIT:
			Minecraft.getMinecraft().displayGuiScreen(new AtmDepositScreen());
				break;
				
		case WITHDRAWL:
			Minecraft.getMinecraft().displayGuiScreen(new AtmWithdrawlScreen());
				break;
		
		}
		super.actionPerformed(Button);
	}
	
	@Override
    public boolean doesGuiPauseGame()
    {
        return false;
    }
	
}
