package init;

import com.SuperUnitato.UnLonely.playerdata.IMoney;
import com.SuperUnitato.UnLonely.playerdata.Money;
import com.SuperUnitato.UnLonely.playerdata.storage;

import net.minecraftforge.common.capabilities.CapabilityManager;

public class ModPlayerData {
	
	public static void register(){
		CapabilityManager.INSTANCE.register(IMoney.class, new storage(), Money.class);
	}

}
