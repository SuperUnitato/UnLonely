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
	boolean check;

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks){
		drawDefaultBackground();
		int centerX = (width / 2) - (guiWidth / 2);
		int centerY = (height/2) - guiHeight/2;
		Minecraft.getMinecraft().renderEngine.bindTexture(screen);
		drawTexturedModalRect(centerX, centerY, 0, 0, guiWidth, guiHeight);
		fontRendererObj.drawString(title, (width / 2) - fontRendererObj.getStringWidth(title) / 2, centerY + 5, 0x504745);
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
	@Override
	public void initGui(){
		buttonList.clear();
		buttonList.add(onedollar = new GuiButton(ONEDOLLAR, 0, 0, 100, 20, "1"));
		buttonList.add(fivedollar = new GuiButton(FIVEDOLLAR, 0, 0, 100, 20, "5"));
		buttonList.add(tendollar = new GuiButton(TENDOLLAR, 0, 0, 100, 20, "10"));
		buttonList.add(twentydollar = new GuiButton(TWENTYDOLLAR, 0, 0, 100, 20, "20"));
		buttonList.add(fiftydollar = new GuiButton(FIFTYDOLLAR, 0, 0, 100, 20, "50"));
		buttonList.add(onehundreddollar = new GuiButton(ONEHUNDREDDOLLAR, 0, 0, 100, 20, "100"));
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
