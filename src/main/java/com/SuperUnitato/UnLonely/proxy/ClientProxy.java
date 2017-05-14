package com.SuperUnitato.UnLonely.proxy;


import com.SuperUnitato.UnLonely.packets.MessageHandler;
import com.SuperUnitato.UnLonely.packets.PacketCreator;
import com.SuperUnitato.UnLonely.playerdata.SumPacketInstance;

import init.ModBlocks;
import init.ModItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.relauncher.Side;
import scala.collection.parallel.ParIterableLike.Sum;

public class ClientProxy implements CommonProxy {

	@Override
	public void init() {
		ModItems.registerRenders();
		ModBlocks.registerRenders();
		SumPacketInstance.INSTANCE.registerMessage(MessageHandler.class, PacketCreator.class, 1, Side.CLIENT);
	}

}
