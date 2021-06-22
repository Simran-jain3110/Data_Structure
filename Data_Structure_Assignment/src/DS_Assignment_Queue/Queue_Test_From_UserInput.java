package DS_Assignment_Queue;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

import DS_Assignment_Stack.DemoStack;

public class Queue_Test_From_UserInput {
	public static void main(String[] args) {
		 
		QueueDemo<String> queue = new QueueDemo<>();
		  Iterator<String> itr = queue.iterator();
	      Scanner scan = new Scanner(System.in);
	      System.out.println("\n\t\t\t\t\tQueue Menu ");
	      
	      while (true) {
	    	  System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
	    	  System.out.println("Select the option to perform the specfic operation on the given Data Stucture\n");
	    	  System.out.println("1.Enqueue \t" +"2. Dequeue \t" +"\t3. Peek \t" +"\t4. Contains \t"+"5. Size \t"+"\n\n6. Iterator\t"+"7. Reverse\t" +"\t8. Traverse/Print\t"+"9. Exit\t");
	    	  System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
              System.out.println("\nEnter your choice: \t ");
	    	  int choice = scan.nextInt();
	    	  System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");

	    	  try {
				switch(choice)
				{
				case 1:
					System.out.println("Enter an element to add : ");
					 queue.enQueue(scan.next());
			         break;
			         
			     
			    	case 2:
					System.out.println("Dequeued  :" + queue.deQueue());
					break;
			
				case 3:
					System.out.println("Retrieving the first  :" + queue.peek() );
					break;
					
				case 4:
					System.out.println("Entre a element to check weather the Queue contains it or not :");
                    boolean contain = queue.contains(scan.next());
                    System.out.println(contain);
					break;
					
				case 5:
					int stackSize = queue.size();
					System.out.println("Size is : " +stackSize);
					break;
					
				case 6:
					System.out.println("Traversing through the list using iterator :");
					while(itr.hasNext()) {
					System.out.print(itr.next()+"  ");	}
					break;
					
					
				case 7:
					System.out.println("Reversed list:");
					queue.reverseQueue(queue);
					queue.printQueue();
					break;
					
				case 8:
					System.out.println("Printing the list without iteratot :");
					queue.printQueue();
					break;
					
				case 9:
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
