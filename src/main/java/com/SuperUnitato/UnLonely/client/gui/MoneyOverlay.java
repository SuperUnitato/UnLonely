package com.SuperUnitato.UnLonely.client.gui;

import com.SuperUnitato.UnLonely.playerdata.IMoney;
import com.SuperUnitato.UnLonely.playerdata.MoneyProvider;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class MoneyOverlay extends GuiScreen{

	@SubscribeEvent
	public void renderOverlay(RenderGameOverlayEvent event){
		if(event.getType() == RenderGameOverlayEvent.ElementType.TEXT ){
			Minecraft mc = Minecraft.getMinecraft();
			final int ammount = mc.player.getCapability(MoneyProvider.MONEY_CAP, null).getBalance();
			String SAmmount = Integer.toString(ammount);
			int y = mc.currentScreen.height;
			fontRendererObj.drawString("$ " + SAmmount, (width / 2) - fontRendererObj.getStringWidth(SAmmount) / 2, 0, 0xe0cc21);
		}
	}

}
