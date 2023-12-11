import java.util.Scanner;
public class LinkedList {
	Node head;
	int size = 0;
	class Node{
		 int data;
		 Node next;
		 Node(int data){
			this.data = data;
			this.next = null;
		}
	}

	//insert
	public void insert(int data) {	
		Node newNode = new Node(data);
		if(head == null) {
			head = newNode;
			return;
		}
		newNode.next = head;
		head = newNode;
		size++;
	}
	//Insert at position
	 public void insertPosition(int pos, int data) {
	        Node new_node = new Node(data);
	        new_node.data = data;
	        new_node.next = null;
	        if(pos < 1 || pos > size + 1)
	            System.out.println("Invalid\n");

	        else if(pos == 1){
	            new_node.next = head;
	            head = new_node;
	            size++;
	        }
	        else
	        {
	            Node temp = head;

	            while(--pos > 1){
	                temp = temp.next;
	            }
	            new_node.next= temp.next;
	            temp.next = new_node;
	            size++;
	        }
	    }
	 
	
	//delete
	public void delete() {
		if(head == null) {
			System.out.println("Linked List is Empty");
			return;
		}
		head = head.next;
		
	}
	//delete at position
	public void deleteAtPosition(int index) {
		if(head == null) {
			System.out.println("Linked List is Empty");
			return;
		}
		Node tempNode = head;
		if(index==0) {
			head = tempNode.next;
			return;
		}
		for(int i = 0;tempNode != null && i< index;i++) {
			tempNode = tempNode.next;
		}
		if(tempNode == null || tempNode.next == null) {
			return;
		}
		Node next = tempNode.next.next;
		tempNode.next = next;
		
	}
	//center of linked list
	public void center() {
		Node slow_ptr = head;
		Node fast_ptr = head;
		while(fast_ptr != null && fast_ptr.next != null) {
			fast_ptr = fast_ptr.next.next;
			slow_ptr = slow_ptr.next;
		}
		System.out.println("The Center of LinkedList is " + slow_ptr.data);
	}
	//sorting using bubble sort
	public void sort() {
		Node current = head;
		LinkedList.Node index = null;
		int temp;
		if(head == null) {
			return;
		}
		else {
			while(current != null) {
				index = current.next;
				while(index != null) {
					if(current.data > index.data) {
						temp = current.data;
						current.data = index.data;
						index.data = temp;
					}
					index = index.next;
				}
			current = current.next;	
			}	
		}
	}
	//reverse LL
	public void reverse_LL() {
		if (head == null || head.next == null) {
			return;
		}
		Node prevNode  = head;
		Node currNode = head.next;

		while(currNode != null) {
			Node nextNode = currNode.next;
			currNode.next = prevNode;
			//update
			prevNode = currNode;
			currNode = nextNode;
		}
		head.next = null;
		head = prevNode;
	}
	
	//size of LL
	public int getCount()
	{
		Node temp = head;
		int count = 0;
		while(temp != null) {
			count++;
			temp = temp.next;
		}
		return count;
	}
	//iterator operation
	public void iterator(int n) {
			
			if(head == null) {
				System.out.println("Linked List is empty");
				return;
			}
			Node currNode = head;
			while(currNode.data != n) {
				System.out.print(currNode.data+"->");
				currNode = currNode.next;
			}
			System.out.println("NULL");
			
		}
		
	//printing the elements
	public void traverse() {
		
		if(head == null) {
			System.out.println("Linked List is empty");
			return;
		}
		Node currNode = head;
		while(currNode != null) {
			System.out.print(currNode.data+"->");
			currNode = currNode.next;
		}
		System.out.println("NULL");
		
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean option = true;
		String str;		
		int ch;
		LinkedList list = new LinkedList();	 
			
		 while(option) { 
			 try {
	
				System.out.println("1.insert \n2.insertAtPosition\n3.delete\n4.deleteAtPosition\n5.Center\n6.Sort\n7.Reverse\n8.Size\n9.Iterator\n10.Traverse\n11.Exit");
				System.out.println("Enter your choice");
				ch = sc.nextInt();
				switch(ch) {
				case 1 :						
					System.out.println("Enter element to insert:");
					int data = sc.nextInt();
					list.insert(data);	
					break;
				case 2: 
					System.out.println("Enter element and index no.:");
					int element = sc.nextInt();
					int index = sc.nextInt();
					list.insertPosition(index,element);					
					break;
				case 3:
					list.delete();
					break;
				case 4:
					System.out.println("Enter element and index no.:");
					int idx = sc.nextInt();	
					list.deleteAtPosition(idx);	
					break;
				case 5:
					list.center();
					break;
				case 6:
					list.sort();	 
					break;
				case 7:
					list.reverse_LL();
					break;
				case 8:
					System.out.println("Size of Linked List is "+ list.getCount());
					break;
				case 9:
					System.out.println("Enter no:");
					int itr = sc.nextInt();
					list.iterator(itr);
					
					break;
				case 10:
					list.traverse();
					break;
				case 11:
					System.out.println("Enter 1 to exit");
					System.exit(1);
				default:
					System.out.println("You have entererd wrong choice.\nPlease enter correct option");
				}
		 }	
		
		catch(Exception e) {
			System.out.println(e);
			System.out.println("Wrong Input");
			System.out.println("Do you want to continue: (y/n)");
			sc.nextLine();
			str = sc.next();
			switch(str) {
				case "y":
					option = true;
					break;
				case "n":
					option = false;
					sc.close();	
					break;
				}
			}
		}
	}
}			 



