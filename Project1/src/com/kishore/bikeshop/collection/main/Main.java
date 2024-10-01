package com.kishore.bikeshop.collection.main;
import com.kishore.bikeshop.collection.*;
import java.util.*;

public class Main 
{
 static List<Login> logins=new ArrayList<>();
 public static void main(String[] args)
 {
	 Login l;
	 Inventory inv=new Inventory();
	 Scanner sc=new Scanner(System.in);
	 int op;
	 System.out.println("****Welcome to Bike Villa****");
	 do
	 {
		 System.out.print("1.Login 2.Signup 3.Exit: ");
		 op=sc.nextInt();
	     switch(op)
	     {
	        case 1:
	        {
	    	  System.out.print("Enter  your User name: ");
	    	  l=check(sc.next());
	    	  if(l!=null)
	    		  if(l.getRole().equals("admin"))
	    			  ainventory(inv);
	    		  else
	    			  cinventory(inv);
	    	  else
	    		  System.out.println("You have no account");
	    	  break;
	        }
	        case 2:
	        {
	        	System.out.print("Enter your Username: ");
	            String name=sc.next();
	            if(logins.contains(name))
	          	  System.out.println("You have already an account");
	            else
	            {
	            	l=new Login();
		            l.setUn(name);
		            System.out.print("Enter your password: ");
	            	l.setPwd(sc.next());
	            	System.out.print("Enter your role: ");
	            	l.setRole(sc.next());
	            	logins.add(l);
	            }
	            break;
	        }
	        default:
	        	if(op!=3)
	        		System.out.println("Invalid option");
	     }
	 }while(op!=3);
  }
 
 
 
  public static Login check(String name)
  {
	  Scanner sc=new Scanner(System.in);
	  Login l = null;
	  if(logins.size()==0)
		  return null;
	  else
	  {
		  for(int i=0;i<logins.size();i++)
			  if(name.equals(logins.get(i).getUn()))
			  {
				  l=logins.get(i);
				  break;
			  }
		  if(l!=null)
			  do
			  {
				  System.out.print("Enter the password correctly: ");
		          String pwd=sc.next();
		          try 
		          {
		              if(pwd.equals(l.getPwd()))
		        		  return l;
		              else
			              throw new Validation("Your password is incorrect Please: ");
		          }
		          catch(Validation v)
		          {
		        	  System.out.print(v);
		          }
		      }while(true);
		  else
			  return null;
	  }
  }
  
  
  
  public static void ainventory(Inventory inv)
  {
	  BikeShop b=new BikeShop();
	  Scanner sc=new Scanner(System.in);
	  int op;
	  do
	    {
		  System.out.print("\n1.Add 2.Update 3.remove 4.Search 5.Show 6.Logout: ");
		  op=sc.nextInt();
		  switch(op)
		  {
		   case 1:
		   {
			  //b=new BikeShop();
			  System.out.print("Enter the cusname,brand,model,price of bike: ");
			  b.setCusname(sc.next());
			  b.setBrand(sc.next());
			  b.setModel(sc.next());
			  b.setPrice(sc.nextInt());
			  inv.add(b);
			  break;
		   }
		   case 2:
		   {
			  System.out.print("Enter the id to update: ");
			  String id=sc.next();
			  inv.update(id);
			  //b=inv.adminsearch(id);
//			  if(b==null)
//				  System.out.println("Id does not found to update");
//			  else
//			  {
//				  int ch;
//				  System.out.print("Enter to update 1.cusname 2.brand 3.model 4.sno 5.price 6.exit");
//				  ch=sc.nextInt();
//				  switch(ch)
//				  {
//				    case 1:
//				    {
//					   b.setCusname(sc.next());
//					   break;
//				    }
//				    case 2:
//				    {
//					   b.setBrand(sc.next());
//					   break;
//				    }
//				    case 3:
//				    {
//					   b.setModel(sc.next());
//					   break;
//				    }
//				    case 4:
//				    {
//					   b.setSno(sc.next());
//					   break;
//				    }
//				    case 5:
//				    {
//					   b.setPrice(sc.nextInt());
//					   break;
//				    }
//				    default:
//				    {
//					   System.out.println("Invalid choice");
//				    }
//				  }
		      //}
			  break;
			  }
		   case 3:
		   {
			  System.out.print("Enter the id to remove: ");
			  String id=sc.next();
			   inv.adminremove(id);
	
			  break;
		   }
		   case 4:
		   {
			  System.out.print("Enter the id to display: ");
			  b=inv.adminsearch(sc.next());
			  if(b==null)
				  System.out.print("The given id  does not found");
			  else
			      System.out.println(b);
			  break;
		   }
		   case 5:
		   {
			   int op2;
//			   do {
//			   System.out.print("Price: 1.Min to max  2.Max to Min: ");
//		       op2=sc.nextInt();
//			   if(op2==1) {Collections.sort(inv.list,new MinMaxSort());break;}
//			   else if(op2==2) {Collections.sort(inv.list,new MaxMinSort());break;}
//			   else{System.out.print("Option is invalid Please enter the option correctly: ");}
//			   }while(true);
			   try
			   {
			     inv.show();
			   }
			   catch(NoProduct e)
			   {
				   System.out.println(e);
			   }
			  break;
		   }
		   default:
			  if(op!=6)
				  System.out.println("Invalid option");
	  }
	 }while(op!=6);
  }
  
  
  
  public static void cinventory(Inventory inv)
  {
	  BikeShop b;
	  Scanner sc=new Scanner(System.in);
	  int op;
	  do
	    {
		  System.out.print("\n1.Sell 2.Buy 3.Search 4.Show 5.Logout: ");
		  op=sc.nextInt();
		  switch(op)
		  {
		   case 1:
		   {
			  b=new BikeShop();
			  System.out.print("Enter the cusname,brand,model,price of bike: ");
			  b.setCusname(sc.next());
			  b.setBrand(sc.next());
			  b.setModel(sc.next());
			  b.setPrice(sc.nextInt());
			  inv.add(b);
			  break;
		   }
		   case 2:
		   {
			  System.out.print("Enter the id to remove: ");
			  String id=sc.next();
			  try
			  {
			   inv.clientremove(id);
			  }
			  catch(NoProduct e)
			  {
				  System.out.println(e);
			  }
			  break;
		   }
		   case 3:
		   {
			  System.out.print("Enter the Brand or model of bike to display: ");
			  inv.clientsearch(sc.next());
			  break;
		   }
		   case 4:
		   {
//			   int op2;
//			   do {
//			   System.out.print("Price: 1.Min to max  2.Max to Min: ");
//			   op2=sc.nextInt();
//			   if(op2==1) {Collections.sort(inv.list,new MinMaxSort());break;}
//			   else if(op2==2) {Collections.sort(inv.list,new MaxMinSort());break;}
//			   else{System.out.print("Option is invalid Please enter the option correctly: ");}
//			   }while(true);
			   try
			   {
			    inv.show();
			   }
			   catch(NoProduct e)
			   {
				   System.out.println(e);
			   }
			  break;
		   }
		   default:
			  if(op!=5)
				  System.out.println("Invalid option");
	  }
	 }while(op!=5);
  }
}

