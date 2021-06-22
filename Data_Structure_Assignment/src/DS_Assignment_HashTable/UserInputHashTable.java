package DS_Assignment_HashTable;

	import java.util.InputMismatchException;
	import java.util.Iterator;
	import java.util.NoSuchElementException;
	import java.util.Scanner;

	public class UserInputHashTable {
		public static void main(String[] args) {
			 
			  HashTableSeparateChaining<String,String> table = new HashTableSeparateChaining();
			  Iterator<String> itr = table.iterator();
		      Scanner scan = new Scanner(System.in);
		      System.out.println("\t\t\t\t\t HashTable menu ");
		      
		      while (true) {
		    	  System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
		    	  System.out.println("Select the option to perform the specfic operation on the given Data Stucture\n");
		    	  System.out.println("1. Insert \t" +"2. Delete \t" +"3. Contains \t"+"\t4. Get Value by key \t"+"\n\n5. Size \t"+"6. Print/Traverse\t" +"7. Iterator \t"+"9. Exit\t");
		    	  System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");

		    	  System.out.println("\nEnter your choice: \t ");
		    	  int choice = scan.nextInt();
		    	  System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");

		    	  try {
					switch(choice)
					{
					case 1:
						System.out.println("Enter key and value : ");
						table.put(scan.next(), scan.next());
				         break;
				         
				     
				    case 2:
				    	  System.out.println("Entry the key to remove : ");
				    	  System.out.println("Valued removed is :"+table.remove(scan.next()));
						  break;
				
					case 3:
						System.out.println("Entre a key to check weather the table contains it or not :");
	                    boolean contain =  table.containsKey(scan.next());
	                    System.out.println(contain);
						break;
						
					case 4:
						System.out.println("Entre a key to get value associated with it ");
						String val= table.get(scan.next());
						System.out.println("Value of the specfied key is : "+ val);
						break;
						
					case 5:
						int tableSize = table.size();
						System.out.println("Size is : " +tableSize);
						break;
						
					case 6:
						System.out.println("Printing without iteratot :");
					    table.printHashTable();
						break;
						
					case 7:
						System.out.println("Traversing hashtable using iterator :");
						while(itr.hasNext()) {
						System.out.print(itr.next()+"  ");	}
						break;
						
					case 8:
						 System.out.println("Exiting ....  :)");
				           System.exit(0);
					
					default:
							System.out.println("\nWrong Choice!!");
							return;
					}
				}catch(IllegalStateException e)
				{
					System.out.println(e.getMessage());
					System.out.println("Try again..");
				}
		    	  catch(InputMismatchException e)
		    	  {
		    		  System.out.println("Exception raised : wrong input");
		    	  }
		    	  catch(IllegalArgumentException e)
		    	  {
		    		  System.out.println(e.getMessage());
		    		  
		    	  }
		      }
			}
			  
	}


