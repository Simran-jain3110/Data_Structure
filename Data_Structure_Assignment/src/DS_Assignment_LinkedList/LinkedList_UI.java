package DS_Assignment_LinkedList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class LinkedList_UI{

   public static void main(String[] args) {
 
	  LinkedListDemo<String> list = new LinkedListDemo<>(); 
	  Iterator<String> itr = list.iterator();
      Scanner scan = new Scanner(System.in);
      System.out.println("\t\t\t\t\tLinked List Menu ");

      
      while (true) {
    	  System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
    	  System.out.println("Select the option to perform the specfic operation on the given Data Stucture\n");
    	  System.out.println("1. Insert \t" +"2. Insert at postion \t" +"3. Delete \t" +"4. Delete at postion \t"+"5. Center \t"+"\n\n6. Reverse\t"+"7. Size\t" +"\t\t8.Iterator\t"+"9. Traverse/Print\t"+"10.Exit\t");
    	  System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
    	  System.out.println("Enter your choice: \t ");
    	  int choice = scan.nextInt();
    	  System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");

    	  try {
			switch(choice)
			{
			case 1:
				System.out.println("Enter an element to add : ");
		         list.insert(scan.next());
		         break;
		         
		     
		    	case 2:
				System.out.println("Entre the element and the postion at which you want to add  :");
				list.insertAtPosition(scan.next(), scan.nextInt());
				break;
		
			case 3:
				System.out.println("Deleted element is : "+list.delete());
				break;
				
			case 4:
				System.out.println("Entre the position at which you want to delete the elmenent :");
				list.deleteAtPosition(scan.nextInt());
				break;
				
			case 5:
				String mid = list.getMiddleElement();
				System.out.println("Centre element is :"+mid);
				break;
				
			case 6:
				System.out.println("Reversed list:");
				list.reverseListList();
				list.printList();
				break;
				
			case 7:
				int listSize = list.size();
				System.out.println("Size is : " +listSize);
				break;
				
			case 8:
				System.out.println("Traversing through the list using iterator :");
				while(itr.hasNext()) {
				System.out.print(itr.next()+"  ");
						}
				break;
				
			case 9:
				System.out.println("Printing the list without iteratot :");
			    list.printList();
				break;
			
			case 10:
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
    		  System.out.println(e.getMessage());
    	  }
    	  catch(NoSuchElementException e)
    	  {
    		  System.out.println(e.getMessage());
    		  
    	  }
      }
	}
	  
}


