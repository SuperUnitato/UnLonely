package com.SuperUnitato.UnLonely.client.gui;

import java.io.IOException;

import com.SuperUnitato.UnLonely.Reference;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;

public class AtmMain extends GuiScreen{
	
	final ResourceLocation screen = new ResourceLocation(Reference.MOD_ID, "textures/gui/mainscreen.png");
	int guiHeight = 250;
	int guiWidth = 125;
	
	int centerX = (width/2) + 165;
	int centerY = (height/2) + 45;
	
	int depositButtonX = centerX;
	int depositButtonY = centerY;
	int withdrawlButtonX = centerX;
	int withdrawlButtonY = centerY + 85;
	
	GuiButton deposit;
	GuiButton withdrawl;
	final int DEPOSIT = 0;
	final int WITHDRAWL = 1;
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks){
		drawDefaultBackground();
		int centerX = (width/2) - (guiWidth/2);
		int centerY = (height/2) - (guiHeight/2);
		Minecraft.getMinecraft().renderEngine.bindTexture(screen);
		drawTexturedModalRect(centerX, centerY, 0, 0, guiWidth, guiHeight);
		fontRendererObj.drawString("SuperU Banking", (width / 2) - fontRendererObj.getStringWidth("SuperU Banking") / 2, centerY + 5, 0x504745);
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
	@Override
	public void initGui(){
		buttonList.clear();
		buttonList.add(deposit = new GuiButton(DEPOSIT, depositButtonX, depositButtonY, 100, 20, "Deposit"));
		buttonList.add(withdrawl = new GuiButton(WITHDRAWL, withdrawlButtonX, withdrawlButtonY, 100, 20, "Withdrawl"));
		super.initGui();
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
