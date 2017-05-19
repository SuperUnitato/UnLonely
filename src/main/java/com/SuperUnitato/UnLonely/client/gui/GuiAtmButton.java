package com.SuperUnitato.UnLonely.client.gui;

import com.SuperUnitato.UnLonely.Reference;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;

public class GuiAtmButton extends GuiButton{
	
	final ResourceLocation buttons = new ResourceLocation(Reference.MOD_ID, "textures/gui/atmbuttons.png");
	
	static int buttonWidth = 106;
	static int buttonHeight = 19;
	
	//HX is hovered, X is not hovered
	static int oneX = 9;
	static int fiveX = 9;
	static int tenX = 10;
	static int twentyX = 11;
	static int fiftyX = 13;
	static int onehundX = 13;
	static int oneHX = 130;
	static int fiveHX = 131;
	static int tenHX = 134;
	static int twentyHX = 133;
	static int fiftyHX = 133;
	static int onehundHX = 135;
	
	//HY is hovered, Y is not hovered
	static int oneY = 13;
	static int fiveY = 37;
	static int tenY = 64;
	static int twentyY = 89;
	static int fiftyY = 117;
	static int onehundY = 145;
	static int oneHY = 11;
	static int fiveHY = 37;
	static int tenHY = 64;
	static int twentyHY = 89;
	static int fiftyHY = 115;
	static int onehundHY = 145;
	

	public GuiAtmButton(int buttonId, int x, int y, String buttonString) {
		super(buttonId, x, y, buttonWidth, buttonHeight, buttonString);
	}

	@Override
	public void drawButton(Minecraft mc, int mouseX, int mouseY) {
			
			mc.renderEngine.bindTexture(buttons);
			//ones
			if(this.id == 0 || this.id == 6){
				hovered = getHover(mouseX, xPosition, buttonWidth, mouseY, yPosition, buttonHeight);
				if(hovered){
					//given hovered pos in the .png file
					drawTexturedModalRect(xPosition, yPosition, oneHX, oneHY, buttonWidth, buttonHeight);
				} else {
					//given unhovered pos in the .png file
					drawTexturedModalRect(xPosition, yPosition, oneX, oneY, buttonWidth, buttonHeight);
				}
			}
			
			//fives
			if(this.id == 1 || this.id == 7){
				hovered = getHover(mouseX, xPosition, buttonWidth, mouseY, yPosition, buttonHeight);
				if(hovered){
					drawTexturedModalRect(xPosition, yPosition, fiveHX, fiveHY, buttonWidth, buttonHeight);
				} else {
					drawTexturedModalRect(xPosition, yPosition, fiveX, fiveY, buttonWidth, buttonHeight);
				}
			}
			
			//tens
			if(this.id == 2 || this.id == 8){
				hovered = getHover(mouseX, xPosition, buttonWidth, mouseY, yPosition, buttonHeight);
				if(hovered){
					drawTexturedModalRect(xPosition, yPosition, tenHX, tenHY, buttonWidth, buttonHeight);
				} else {
					drawTexturedModalRect(xPosition, yPosition, tenX, tenY, buttonWidth, buttonHeight);
				}
			}
			
			//twenties
			if(this.id == 3 || this.id == 9){
				hovered = getHover(mouseX, xPosition, buttonWidth, mouseY, yPosition, buttonHeight);
				if(hovered){
					drawTexturedModalRect(xPosition, yPosition, twentyHX, twentyHY, buttonWidth, buttonHeight);
				} else {
					drawTexturedModalRect(xPosition, yPosition, twentyX, twentyY, buttonWidth, buttonHeight);
				}
			}
			
			//fifty
			if(this.id == 4 || this.id == 10){
				hovered = getHover(mouseX, xPosition, buttonWidth, mouseY, yPosition, buttonHeight);
				if(hovered){
					drawTexturedModalRect(xPosition, yPosition, fiftyHX, fiftyHY, buttonWidth, buttonHeight);
				} else {
					drawTexturedModalRect(xPosition, yPosition, fiftyX, fiftyY, buttonWidth, buttonHeight);
				}
			}
			
			//onehundred
			if(this.id == 5 || this.id == 11){
				hovered = getHover(mouseX, xPosition, buttonWidth, mouseY, yPosition, buttonHeight);
				if(hovered){
					drawTexturedModalRect(xPosition, yPosition, onehundHX, onehundHY, buttonWidth, buttonHeight);
				} else {
					drawTexturedModalRect(xPosition, yPosition, onehundX, onehundY, buttonWidth, buttonHeight);
				}
			}
	}
	
	public boolean getHover(int mouseX, int xPosition, int buttonWidth, int mouseY, int yPosition, int buttonHeight){
		if(mouseX >= xPosition && mouseX <= xPosition + buttonWidth && mouseY >= yPosition && mouseY <= yPosition + buttonHeight){
			return true;
		} else {
			return false;
		}
	}

}
