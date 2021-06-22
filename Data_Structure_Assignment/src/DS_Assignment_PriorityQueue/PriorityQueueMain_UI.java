package DS_Assignment_PriorityQueue;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class PriorityQueueMain_UI {
	public static void main(String[] args) {
		 
		CustomePriorityQueue<String> pqueue = new CustomePriorityQueue<>();

		  Iterator<String> itr = pqueue.iterator();
	      Scanner scan = new Scanner(System.in);
	      System.out.println("\t\t\t\t\t Priority_Queue Menu ");
	     do{
	    	  System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
	    	  System.out.println("Select the option to perform the specfic operation on the given Data Stucture\n");
	    	  System.out.println("1.Enqueue \t" +"2. Dequeue \t" +"\t3. Peek \t" +"\t4. Contains \t"+"5. Size \t"+"\n\n6. Iterator\t"+"7. Reverse\t" +"\t8. Traverse/Print\t"+"9. Exit\t");
	    	  System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");

	    	  System.out.println("Enter your choice: \t ");
	    	  int choice = scan.nextInt();
	    	  System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");

	    	  try {
				switch(choice)
				{
				case 1:
					System.out.println("Enter an item and its priority : ");
					pqueue.add(scan.next(), scan.nextInt());
			        break;
			         
			     
			    	case 2:
			    		pqueue.remove();
					break;
			
				case 3:
					System.out.println("Retrieving the first  :" + pqueue.peek() );
					break;
					
				case 4:
					System.out.println("Entre a element to check weather the Priority Queue contains it or not :");
                    boolean contain = pqueue.contains(scan.next());
                    System.out.println(contain);
					break;
					
				case 5:
					int size = pqueue.size();
					System.out.println("Size is : " +size);
					break;
					
				case 6:
					System.out.println("Traversing through the list using iterator :");
					while(itr.hasNext()) {
					System.out.print(itr.next()+"  ");	}
					break;
					
					
				case 7:
					System.out.println("Reversed list:");
					pqueue.reversePQueue();
					pqueue.print();
					break;
					
				case 8:
					System.out.println("Printing the list without iteratot :");
					pqueue.print();
					break;
					
				case 9:
					 System.out.println("Exiting ....  :)");
			           System.exit(0);
				
				default:
						System.out.println("\nWrong Choice!!");
						return;
				}
			 }
	    	  catch(InputMismatchException e1) {
					System.out.println(e1.getMessage());
					System.out.println("Mismatched....Please Entre a valid value");
				}
	    	  catch(NoSuchElementException e2)
	  		    {
				System.out.println(e2.getMessage());	
				}
	    	
				catch(IllegalStateException e3)
				{
					System.out.println(e3.getMessage());}
	             }  
	     while (true); 
	      } 
		

}
