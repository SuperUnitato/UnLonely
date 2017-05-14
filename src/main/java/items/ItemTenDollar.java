package items;

import com.SuperUnitato.UnLonely.Reference;
import com.SuperUnitato.UnLonely.UnLonely;

import net.minecraft.item.Item;

public class ItemTenDollar extends Item {
	
	public ItemTenDollar(){
		
		setUnlocalizedName(Reference.UnLonelyItems.TENDOLLAR.getUnlocalizedName());
		setRegistryName(Reference.UnLonelyItems.TENDOLLAR.getRegistryName());
		
		setCreativeTab(UnLonely.tabUnLonely);
	}

}
