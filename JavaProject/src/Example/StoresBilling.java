package Example;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

class StoresBilling {
public int pno;
public String pname;
public int pquantity;
public double price;
public double totalprice;

	public StoresBilling(int pno, String pname, int pquantity, double price) {
	this.pno = pno;
	this.pname = pname;
	this.pquantity = pquantity;
	this.price = price;
	
}
	
	public int getPno() {
		return pno;
	}

	public String getPname() {
		return pname;
	}

	public int getPquantity() {
		return pquantity;
	}
    
	public void setPquantity(int pquantity) {
		this.pquantity = pquantity;
	}

	public double getPrice() {
		return price;
	}
	
	
	public String toString() {
		return "StoresBilling [pno=" + pno + ", pname=" + pname + ", pquantity=" + pquantity + ", price=" + price + "]";
	}

 }
 class Products {
	
	private static Scanner s;
public static void main(String[] args) {
		List<StoresBilling> c = new ArrayList<StoresBilling>();
		s = new Scanner(System.in);
		 double totalcost=0.0;
        System.out.println("*****************************************WELCOME TO SUPER STORES*****************************************");
        
        
        //format of date and time
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy  HH:mm:ss");
        Date d=new Date();
        Calendar cal = Calendar.getInstance();
        String[]days=new String[] {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
        System.out.println("Date:"+f.format(d)+"  "+days[cal.get(Calendar.DAY_OF_WEEK)-1]);
int p;
do {
	System.out.println("1.INSERT");
    System.out.println("2.DISPLAY");
    System.out.println("3.SEARCH");
    System.out.println("4.DELETE");
    System.out.println("5.UPDATE");
    System.out.println("6.Count");
    System.out.println("7.Exit");
    System.out.print("Enter your choice : ");
    p = s.nextInt();
    switch(p) {
    //insert operation
    case 1:
System.out.println("ENTER PRODUCT NUMBER:");
int pno=s.nextInt();
System.out.println("ENTER PRODUCT NAME: ");
String pname=s.next();
System.out.println("ENTER PRODUCT QUANTITY:");
int pquantity=s.nextInt();
System.out.println("ENTER PRODUCT RATE:");
double price=s.nextDouble();
    StoresBilling sb1 = new StoresBilling(pno, pname, pquantity, price );
    c.add(sb1);
    totalcost += sb1.getPrice()*sb1.getPquantity();
     System.out.println("__________________________________________________________________________________");
    System.out.println("Record Inserted Successfully!");
    System.out.println("Total Cost :  $"+totalcost);
    System.out.println("__________________________________________________________________________________");
    break;
    case 2:  //display operation
    System.out.println("__________________________________________________________________________________");
    Iterator<StoresBilling> i=c.iterator();
    while(i.hasNext()) {
    	StoresBilling sb= i.next();
    	System.out.println(sb);
    }
    
    System.out.println("__________________________________________________________________________________");
    break ;
    case 3:
    	//search operation
    	boolean found=false;
    	System.out.println("ENTER PRODUCT NUMBER TO SEARCH:");
        pno= s.nextInt();
    	System.out.println("__________________________________________________________________________________");
    	i=c.iterator();
    	while(i.hasNext()) {
    		StoresBilling sb = i.next();
    		if(sb.getPno()==pno) {
    			System.out.println(sb);
    			found = true;
    		}
    	}
    	if(!found) {
    		System.out.println("Record Not Found!");
    	}
    	System.out.println("__________________________________________________________________________________");
    	break;
    case 4:
    	//delete operation
    	found = false;
    	System.out.println("ENTER PRODUCT NUMBER TO DELETE:");
    	pno=s.nextInt();
    	System.out.println("__________________________________________________________________________________");
    	i=c.iterator();
    	while(i.hasNext()) {
    		StoresBilling sb = i.next();
    		if(sb.getPno()==pno) {
    			i.remove();
    			found = true;
    			totalcost -= sb.pquantity*sb.getPrice();
}
    		 }
    	
    	if(!found) {
    		System.out.println("Record Not Found!");
    	}
    	else {
    		System.out.println("Record Deleted Successfully!");
    	}
    	System.out.println("Total Amount   $:"+totalcost);
    	System.out.println("__________________________________________________________________________________");
    	break;
    case 5:
    	//update operation
    	found=false;
    	System.out.println("ENTER PRODUCT NUMBER TO UPDATE:");
    	pno=s.nextInt();
    	ListIterator<StoresBilling> l = c.listIterator();
    	while(l.hasNext()) {
    		StoresBilling sb = l.next();
    		if(sb.getPno()==pno) {
    			System.out.println("ENTER NEW PRODUCT NAME:");
    			pname=s.next();
    			System.out.println("ENTER NEW PRODUCT QUATITY:");
    			pquantity=s.nextInt();
    			System.out.println("ENTER NEW PRODUCT RATE:");
    			price=s.nextFloat();
    			l.set(new StoresBilling(pno,pname,pquantity,price));
    			found = true;
    			totalcost=0.0;
        		for(StoresBilling billing :c) {
        			totalcost += billing.getPquantity()*billing.getPrice();
    		}
    		}
    		
    	}
    	
    	System.out.println("__________________________________________________________________________________");
    	if(!found) {
    		System.out.println("Record Not Found!");
    	}
    	else {
    		System.out.println("Record Updated Successfully!");
    	}
        System.out.println("Total Amount   $:"+totalcost);
    	System.out.println("__________________________________________________________________________________");
    	break;
  
    case 6:
    	System.out.println("Total Number Of Products:" +c.size());
    	System.out.println("__________________________________________________________________________________");
    	break;
    case 7:
    	System.exit(0);
    	System.out.println("__________________________________________________________________________________");
        break;
   
    }
 
}
while(p!=0);
	System.out.println("**************************  THANK YOU FOR PURCHASING  **************************");
	System.out.println("******************  VISIT AGAIN  ******************");
}
}	
 	


