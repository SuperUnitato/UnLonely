package com.SuperUnitato.UnLonely.proxy;

import com.SuperUnitato.UnLonely.packets.MessageHandler;
import com.SuperUnitato.UnLonely.packets.PacketCreator;
import com.SuperUnitato.UnLonely.playerdata.SumPacketInstance;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.relauncher.Side;

public class ServerProxy implements CommonProxy{

	@Override
	public void init() {
		SumPacketInstance.INSTANCE.registerMessage(MessageHandler.class, PacketCreator.class, 0, Side.SERVER);
	}

}
