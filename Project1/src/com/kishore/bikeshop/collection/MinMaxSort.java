package com.kishore.bikeshop.collection;
import java.util.*;
public class MinMaxSort implements Comparator<BikeShop>
{
	public int compare(BikeShop i,BikeShop j)
	{
		return (i.getPrice()>j.getPrice())?1:-1;
	}

}
