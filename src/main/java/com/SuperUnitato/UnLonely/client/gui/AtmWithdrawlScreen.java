package com.SuperUnitato.UnLonely.client.gui;

import java.io.IOException;

import com.SuperUnitato.UnLonely.Reference;
import com.SuperUnitato.UnLonely.packets.PacketCreator;
import com.SuperUnitato.UnLonely.playerdata.SumPacketInstance;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;

public class AtmWithdrawlScreen extends GuiScreen{
	
	final ResourceLocation screen = new ResourceLocation(Reference.MOD_ID, "textures/gui/mainscreen.png");
	
	int guiHeight = 250;
	int guiWidth = 125;
	
	int buttonWidth = 106;
	int buttonHeight = 21;
	
	GuiButton onedollar;
	GuiButton fivedollar;
	GuiButton tendollar;
	GuiButton twentydollar;
	GuiButton fiftydollar;
	GuiButton onehundreddollar;
	
	final int ONEDOLLAR = 6;
	final int FIVEDOLLAR = 7;
	final int TENDOLLAR = 8;
	final int TWENTYDOLLAR = 9;
	final int FIFTYDOLLAR = 10;
	final int ONEHUNDREDDOLLAR = 11;
	
	String title = "Withdrawl";

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks){
		int centerX = (width / 2) - (guiWidth / 2);
		int centerY = (height/2) - (guiHeight/2);
		Minecraft.getMinecraft().renderEngine.bindTexture(screen);
		drawTexturedModalRect(centerX, centerY, 0, 0, guiWidth, guiHeight);
		fontRendererObj.drawString(title, (width / 2) - fontRendererObj.getStringWidth(title) / 2, centerY + 5, 0x504745);
		super.drawScreen(mouseX, mouseY, partialTicks);
		super.updateScreen();
	}
	
	@Override
	public void initGui(){
		int buttonCenterX = (width / 2) - (buttonWidth / 2);
		int buttonCenterY = (height / 2) - (buttonHeight / 5);
		int oneY = buttonCenterY - 90;
		int fiveY = buttonCenterY - 60;
		int tenY = buttonCenterY - 30;
		int twentyY = buttonCenterY;
		int fiftyY = buttonCenterY + 30;
		int onehundredY = buttonCenterY + 60;
		
		buttonList.clear();
		buttonList.add(onedollar = new GuiAtmButton(ONEDOLLAR, buttonCenterX, oneY, null));
		buttonList.add(fivedollar = new GuiAtmButton(FIVEDOLLAR, buttonCenterX, fiveY, null));
		buttonList.add(tendollar = new GuiAtmButton(TENDOLLAR, buttonCenterX, tenY, null));
		buttonList.add(twentydollar = new GuiAtmButton(TWENTYDOLLAR, buttonCenterX, twentyY, null));
		buttonList.add(fiftydollar = new GuiAtmButton(FIFTYDOLLAR, buttonCenterX, fiftyY, null));
		buttonList.add(onehundreddollar = new GuiAtmButton(ONEHUNDREDDOLLAR, buttonCenterX, onehundredY, null));
		super.updateScreen();
		super.initGui();
	}
	
	@Override
	public void actionPerformed(GuiButton Button) throws IOException{
		SumPacketInstance.INSTANCE.sendToServer(new PacketCreator(Button.id));
		super.actionPerformed(Button);
	}
	
	@Override
    public boolean doesGuiPauseGame()
    {
        return false;
    }	
}
