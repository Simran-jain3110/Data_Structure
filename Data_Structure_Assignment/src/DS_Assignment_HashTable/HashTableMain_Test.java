package DS_Assignment_HashTable;

import java.util.Iterator;

public class HashTableMain_Test {
	 public static void main(String[] args) {
		  HashTableSeparateChaining<String,String> table = new HashTableSeparateChaining();
		  
		  table.put("1","Sim");
		  table.put("2","jain");
		  table.put("3","Sidd");
		  table.put("4","kallu");
		  table.put("5","sajal");
		  System.out.println("Printing.....");
		  System.out.println(table);
		  System.out.println("Removing from table at key 3: "+table.remove("1"));
		  System.out.println(table);
		  System.out.println("Does my table contains key 1 :" +table.containsKey("1"));
	      System.out.println("Geeting value by key 1 : "+ table.get("1"));
	      System.out.println("Size is : "+ table.size());
	      System.out.println("Checking Iterator : ");
	      Iterator itr = table.iterator();
	      while(itr.hasNext())
	      {
	    	  System.out.println(itr.next());
	      }
	      
	      System.out.println("Printing....");
	      table.printHashTable();
		  
		  
		
	}
}
