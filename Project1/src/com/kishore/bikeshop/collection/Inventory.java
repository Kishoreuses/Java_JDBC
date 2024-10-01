package com.kishore.bikeshop.collection;
import com.kishore.bikeshop.collection.main.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class Inventory 
{
	  public List<BikeShop> list=new ArrayList<>();
	  Connection con;
	  Statement stmt;
	  ResultSet rs;
	  String qry=null;
	  public Connection getDBConnection()
	  {
			 Connection con=null;
			 try
			 {
				 Class.forName("com.mysql.cj.jdbc.Driver");
				 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bikeshop","Kishore","");
			 }
			 catch(Exception e)
			 {
				 System.out.println(e);
			 }
			 return con;
	  }
	  public void add(BikeShop b)
	  {
		b.setId(generateId(b));
		//list.add(b);
		try
		{
			con=getDBConnection();
			stmt=con.createStatement();
			qry="Insert into details(ID,Cus_Name,Brand,Model,Price) Values('"+b.getId()+"','"+b.getCusname()+"','"+b.getBrand()+"','"+b.getModel()+"','"+b.getPrice()+"')";
			int count=stmt.executeUpdate(qry);
			if(count==1)
				System.out.println("1 row is updated");
			else
				throw new Exception("No row is updated");
		}
		catch(Exception e)
		{
			System.out.println("No row is updated");
		}
	  }
	  public void clientremove(String id)throws NoProduct
	  {
//		  int flag=0;
//		  for(int i=0;i<list.size();i++)
//		  {
//			  if(val.equalsIgnoreCase(list.get(i).getModel()) || val.equalsIgnoreCase(list.get(i).getModel()) )
//			  {
//				  list.remove(i);
//				  flag=1;
//				  System.out.println("Successfully ordered");
//				  break;
//			  }
//		  }
//		  if(flag==0)
//			  throw new NoProduct("Bikes does not found");
		  try
		  {
		   con=getDBConnection();
		   stmt=con.createStatement();
		   qry="delete from details where ID='"+id+"'";
		   int count=stmt.executeUpdate(qry);
		   if(count==1)
			   System.out.println("1 row is deleted");
		   else
			   throw new Exception("Id does not found");
		  }
		  catch(Exception e)
		  {
			  System.out.println(e);
		  }
	  }
	  public void adminremove(String id)
	  {
		  try
		  {
		   con=getDBConnection();
		   stmt=con.createStatement();
		   qry="delete from details where ID='"+id+"'";
		   int count=stmt.executeUpdate(qry);
		   if(count==1)
			   System.out.println("1 row is deleted");
		   else
			   throw new Exception("Id does not found");
		  }
		  catch(Exception e)
		  {
			  System.out.println(e);
		  }
//		  int flag=0;
//		  for(int i=0;i<list.size();i++)
//		  {
//			  if(id.equalsIgnoreCase(list.get(i).getId()))
//			  {
//				  list.remove(i);
//				  flag=1;
//				  System.out.println("Successfully removed");
//				  break;
//			  }
//		  }
//		  if(flag==0)
//			  throw new NoProduct("id does not found");
	  }
	  public void clientsearch(String val)
	  {
//		  int flag=0;
//		  for(int i=0;i<list.size();i++)
//			  if(val.equalsIgnoreCase(list.get(i).getModel()) || val.equalsIgnoreCase(list.get(i).getBrand()))
//			  {
//				  System.out.println(list.get(i));
//				  flag=1;
//			  }
//		  if(flag==0)
//			  System.out.println("The given product "+val+" does not found");
	  }
	  public BikeShop adminsearch(String id)
	  {
		  con=getDBConnection();
		  
//		  for(int i=0;i<list.size();i++)
//			  if(id.equalsIgnoreCase(list.get(i).getId()))
//				 return list.get(i);
		  return null;
	  }
	  public void show()throws NoProduct
      {
//		  if(list.size()==0)
//			  throw new NoProduct("No Products Found");
//		  else
//		      for(BikeShop b:list)
//		    	  System.out.print(b);
	  try
	  {
		  con=getDBConnection();
		  stmt=con.createStatement();
		  rs=stmt.executeQuery("select * from details");
		  while(rs.next())
			  System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getInt(5));
	  }
	  catch(Exception e)
	  {
            System.out.println("No Product found");  
	  }
}
	  public String generateId(BikeShop obj)
	  {
		  String name=obj.getCusname();
		  String model=obj.getModel();
		  String id=name.substring(0,2).toUpperCase()+model.substring(0,2).toUpperCase();
		  return id;
	  }
	public void update(String id) 
	{
		Scanner sc=new Scanner(System.in);
		int ch;
		try
		{
		  con=getDBConnection();
		  stmt=con.createStatement();
		  System.out.print("Enter to update 1.cusname 2.brand 3.model 4.price 5.exit");
		  ch=sc.nextInt();
		  switch(ch)
		  {
		    case 1:
		    {
			   //b.setCusname(sc.next());
			   qry="update details set Cus_Name='"+sc.next()+"' where ID='"+id+"'";
			   break;
		    }
		    case 2:
		    {
			  // b.setBrand(sc.next());
			   qry="update details set Brand='"+sc.next()+"' where ID='"+id+"'";
			   break;
		    }
		    case 3:
		    {
			   //b.setModel(sc.next());
			   qry="update details set Model='"+sc.next()+"' where ID='"+id+"'";
			   break;
		    }
		    case 4:
		    {
			  // b.setPrice(sc.nextInt());
			   qry="update details set Price='"+sc.nextInt()+"' where ID='"+id+"'";
			   break;
		    }
		    default:
		    {
			   System.out.println("Invalid choice");
		    }
		  }
		  int count=stmt.executeUpdate(qry);
		  if(count==1)
			  System.out.println("1 row is updated");
		  else
			  throw new Exception("No row is updated");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
   }

		

}

