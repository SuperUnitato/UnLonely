package com.SuperUnitato.UnLonely.packets;

import com.SuperUnitato.UnLonely.Reference;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class PacketCreator implements IMessage{
	
	public PacketCreator(){
		
	}
	
	  protected int toSend;
	  
	  public PacketCreator(int toSend) {
	    this.toSend = toSend;
	  }

	  @Override
	  public void toBytes(ByteBuf buf) {
	    // Writes the int into the buf
	    buf.writeInt(toSend);
	  }
 
	  @Override
	  public void fromBytes(ByteBuf buf) {
	    // Reads the int back from the buf. Note that if you have multiple values, you must read in the same order you wrote.
	    toSend = buf.readInt();
	  }
	  
	  

}
