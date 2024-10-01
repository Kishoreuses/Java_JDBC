package com.kishore.bikeshop.collection.main;

public class NoProduct extends Exception
{
    String msg;
	public NoProduct(String msg) 
	{
		this.msg=msg;
	}
	@Override
	public String toString() {
		return  msg;
	}
	
	 
}
