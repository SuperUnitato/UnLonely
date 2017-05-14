package com.SuperUnitato.UnLonely.playerdata;

public class Money implements IMoney{

	public int balance = 0;
	
	@Override
	public int getBalance() {
		return balance;
	}

	@Override
	public void setBalance(int ammount) {
		this.balance = ammount;
	}

	@Override
	public void addBalance(int ammount) {
		this.balance += ammount;
	}

	@Override
	public void takeBalance(int ammount) {
		this.balance -= ammount;
	}

}
