package com.SuperUnitato.UnLonely.playerdata;

public class Shop implements IShop{

	public int shopCount = 0;
	
	@Override
	public void addShop() {
		shopCount++;
	}

	@Override
	public int getShopCount() {
		return this.shopCount;
	}

	@Override
	public void takeShop() {
		shopCount--;
	}

	@Override
	public void clearShops() {
		shopCount = 0;
	}

	@Override
	public void setShopCount(int num) {
		shopCount = num;
	}

}
