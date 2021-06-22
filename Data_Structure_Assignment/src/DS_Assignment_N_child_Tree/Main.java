package DS_Assignment_N_child_Tree;

import java.util.Iterator;
import java.util.List;

public class Main {
	
public static void main(String[] args) {
	// Create a new Integer type node
	  System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");

	System.out.println("Inserting Data and displaying..");
	Node<Integer> root = new Node<Integer>(1);
	Node<Integer> node1 = new Node<Integer>(2);
	Node<Integer> node2 = new Node<Integer>(12);
	Node<Integer> node3 = new Node<Integer>(22);
	Node<Integer> node4 = new Node<Integer>(42);
	Node<Integer> node5 = new Node<Integer>(23);
	Node<Integer> node6 = new Node<Integer>(65);
	//root.children.get(0).children.add(new Node<Integer>(5));

	//System.out.println(root);
	
	root.children.add(node1);
	root.children.add(node2);
	root.children.add(node3);
	
	node1.children.add(node4);
	node1.children.add(node5);
	node1.children.add(node6);
	//root.addChild(new Node<Integer>(100));
	//node3.addChild(new Node<Integer>(900));	 
		
	
	// Create a tree, providing the root node
	Tree<Integer> tree = new Tree<Integer>(root);
	 tree.print(root);
	 
	  System.out.println("\n---------------------------------------------------------------------------------------------------------------------------------------------------\n");

	System.out.println("Remving child at index 1 of root");
	
	System.out.println("Removed element is : "+ root.removeChildAt(1));
	System.out.println("Displaying tree after deletion ");
	tree.print(root);
	

	
	  System.out.println("\n---------------------------------------------------------------------------------------------------------------------------------------------------\n");
	
	System.out.println("Removing a perticular node");
	root.removeChild(node3);
	node1.removeChild(node5);
	System.out.println("Tree after removing node 3 and node 5 i.e 22 and 23");
	tree.print(root);

	/*System.out.println("*************");
	
	System.out.println("Removing all children");
	//removing all the children of root
	root.removeChildren();
	//removing all the children of a perticular node
	node1.removeChildren();
	System.out.println("Displaying tree after deletion ");
	tree.print(root);
	
	*/
	
	  System.out.println("\n---------------------------------------------------------------------------------------------------------------------------------------------------\n");
	 boolean bol1=tree.contains(7);
	 System.out.println("Contains 7 ? : "+bol1);
	 boolean bol2=tree.contains(42);
	System.out.println("Contains 42 ? : "+bol2);
	
	  System.out.println("\n---------------------------------------------------------------------------------------------------------------------------------------------------\n");
	System.out.println("Getting element by value");
	int num = tree.getNumberOfDescendants(node1);
	System.out.println("NO's of chlid of this node1 i.e 2 are :"+num);
	System.out.println("Chlidren as follows :");
	tree.getElementsByValue(node1);
	
	// true if the given key was found in the tree
	  System.out.println("\n---------------------------------------------------------------------------------------------------------------------------------------------------\n");
	System.out.println("Check wheather given key is found or not and if true then print it else null");
	boolean find =tree.find(node1, 42);
	System.out.println("The node with data 42 is present ? :"+ find);
	Node<Integer> ne = tree.findNode(node1,42);
	System.out.println(ne);
	
	//Get elements by level
	  System.out.println("\n---------------------------------------------------------------------------------------------------------------------------------------------------\n");
	System.out.println("Get elements by level");
	tree.getElementsByLevel();
	
   //Traverse/Print breadth first
	  System.out.println("\n---------------------------------------------------------------------------------------------------------------------------------------------------\n");
	System.out.println("Breadth first (level order) is as follows : ");
    tree.PrintBreadthFirst(root);
	System.out.println("Level order traversal competed");
	
	//Traverse/print Depth first
	  System.out.println("\n---------------------------------------------------------------------------------------------------------------------------------------------------\n");
     System.out.println("Depth first travesal is as follws :");
	 List<Node<Integer>> preOrder = tree.getPreOrderTraversal();
	 System.out.println(preOrder); 
	 System.out.println("completed");
	 
	 //Iterator Depth first
	  System.out.println("\n---------------------------------------------------------------------------------------------------------------------------------------------------\n");
	 System.out.println("Depth Iteartor checking..");
	 Iterator itr = tree.iterator();
	 
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
	  //Iterator Depth first
		  System.out.println("\n---------------------------------------------------------------------------------------------------------------------------------------------------\n");
	  System.out.println("Breadth Iterator checking");
	  Iterator itr2 = tree.iterator1();
	  //System.out.println(itr2.hasNext());
         while(itr2.hasNext()){
	        System.out.println(itr2.next());	
	      }
   	  System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");

	
	System.out.println("Size of thr tree :"+tree.size());
	

}
}
