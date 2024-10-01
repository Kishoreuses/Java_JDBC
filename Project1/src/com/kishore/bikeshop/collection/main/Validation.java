package com.kishore.bikeshop.collection.main;

public class Validation extends Exception 
{
   String msg;
   Validation(String msg)
   {
	   this.msg=msg;
   }
@Override
   public String toString() {
	return msg;
}
   
}

