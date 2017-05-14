package com.SuperUnitato.UnLonely.client.gui;

import java.io.IOException;

import com.SuperUnitato.UnLonely.Reference;
import com.SuperUnitato.UnLonely.packets.MessageHandler;
import com.SuperUnitato.UnLonely.packets.PacketCreator;
import com.SuperUnitato.UnLonely.playerdata.SumPacketInstance;

import init.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;

public class AtmDepositScreen extends GuiScreen{
	
	final ResourceLocation screen = new ResourceLocation(Reference.MOD_ID, "textures/gui/mainscreen.png");
	
	int guiHeight = 250;
	int guiWidth = 125;
	
	int centerX = (width / 2) + 192;
	int centerY = (height/2) + 10;
	
	int oneButtonPosX = centerX;
	int oneButtonPosY = centerY + 15 ;
	int fiveButtonPosX = centerX;
	int fiveButtonPosY = centerY + 45;
	int tenButtonPosX = centerX;
	int tenButtonPosY = centerY + 75;
	int twentyButtonPosX = centerX;
	int twentyButtonPosY = centerY + 105;
	int fiftyButtonPosX = centerX;
	int fiftyButtonPosY = centerY + 135;
	int onehundredButtonPosX = centerX;
	int onehundredButtonPosY = centerY + 165;
	
	GuiButton onedollar;
	GuiButton fivedollar;
	GuiButton tendollar;
	GuiButton twentydollar;
	GuiButton fiftydollar;
	GuiButton onehundreddollar;
	
	final int ONEDOLLAR = 0;
	final int FIVEDOLLAR = 1;
	final int TENDOLLAR = 2;
	final int TWENTYDOLLAR = 3;
	final int FIFTYDOLLAR = 4;
	final int ONEHUNDREDDOLLAR = 5;
	
	String title = "Deposit";
	
	static int ID = 0;

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks){
		drawDefaultBackground();
		int centerX = (width / 2) - (guiWidth / 2);
		int centerY = (height/2) - (guiHeight/2);
		Minecraft.getMinecraft().renderEngine.bindTexture(screen);
		drawTexturedModalRect(centerX, centerY, 0, 0, guiWidth, guiHeight);
		fontRendererObj.drawString(title, (width / 2) - fontRendererObj.getStringWidth(title) / 2, centerY + 5, 0x504745);
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
	@Override
	public void initGui(){
		buttonList.clear();
		buttonList.add(onedollar = new GuiButton(ONEDOLLAR, oneButtonPosX, oneButtonPosY, 100, 20, "1"));
		buttonList.add(fivedollar = new GuiButton(FIVEDOLLAR, fiveButtonPosX, fiveButtonPosY, 100, 20, "5"));
		buttonList.add(tendollar = new GuiButton(TENDOLLAR, tenButtonPosX, tenButtonPosY, 100, 20, "10"));
		buttonList.add(twentydollar = new GuiButton(TWENTYDOLLAR, twentyButtonPosX, twentyButtonPosY, 100, 20, "20"));
		buttonList.add(fiftydollar = new GuiButton(FIFTYDOLLAR, fiftyButtonPosX, fiftyButtonPosY, 100, 20, "50"));
		buttonList.add(onehundreddollar = new GuiButton(ONEHUNDREDDOLLAR, onehundredButtonPosX, onehundredButtonPosY, 100, 20, "100"));
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
