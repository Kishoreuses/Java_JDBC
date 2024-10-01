package com.kishore.bikeshop.collection;

public class BikeShop
{
	 private String brand;
	 private String model;
	 private String cusname;
	 private String id;
	 private int price;
	 public BikeShop()
	 {
		 this.brand=null;
		 this.model=null;
		 this.price=0;
		 this.cusname=null;
		 this.id=null;
	 }
	 public void setBrand(String brand)
	 {
		 this.brand=brand;
	 }
	 public void setModel(String model)
	 {
		 this.model=model;
	 }
	 public void setPrice(int price)
	 {
		 this.price=price;
	 }
	 public void setCusname(String cusname)
	 {
		 this.cusname=cusname;
	 }
	 public void setId(String id)
	 {
		 this.id=id;
	 }
	 public String getBrand()
	 {
		 return brand;
	 }
	 public String getModel()
	 {
		 return model;
	 }
	 public int getPrice()
	 {
		 return price;
	 }
	 public String getCusname()
	 {
		 return cusname;
	 }
	 public String getId()
	 {
		 return id;
	 }
	 public String toString() 
	 {
		return "[id="+id+", cusname="+cusname+",brand=" + brand + ", model=" + model+", price=" + price+"]\n";
	 }
	 
}
