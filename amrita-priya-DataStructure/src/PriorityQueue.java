import java.util.InputMismatchException;
import java.util.Scanner;
public class PriorityQueue {
	int maxsize = 5;
	int data[] = new int[maxsize];
	int front;
	//Enqueue operation
	public void enQueue(int value) {
		if(!isFull()) {
			if(front == 0) {
				data[front] = value;
				front++;
			}
			else {
				int i;
				for(i=front-1;i>=0;i--) {
					if(value>data[i]) {
						data[i+1] = data[i];
					}
					else {
						break;
					}
				}
				data[i+1] = value;
				front++;
			}
		}
		else {
			System.out.println("Priority Queue is full ");
		}
	}
	//dequeue operation
	public int deQueue() {		
		if(front != -1) {
			int x = data[--front];
			return x;
		}
		else {
			System.out.println("Priority queue is empty");
			return 0;
		}
	}
	
	public int peek() {
		if(!isEmpty())
			return data[front];
		else {
			System.out.println("Priority queue is empty");
			return 0;
		}
	}
	public void contains(int search) {
		int flag = 0;
		for(int i=0;i<=front;i++) {
			if(data[i] == search) {
				flag =1;
			}
		}
		if (flag == 1) {
			System.out.println(search+" is present");
		}
		else {
			System.out.println(search+" is not present");
		}
	}
	//size of priority queue
	public int size() {
		int count = 0;
		for(int i=0;i<front;i++) {
			count++;
		}
		return count;
	}
	//middle element
	public int center() {
		if(front == 0) {
			System.out.println("Priority Queue is empty");
			return 0;
		}
		else
		{
			int length = front;
			int res = data[length/2];
			return res;
		}
	
	}
	//reverse
	public void reverse() {
		if(front == 0) {
			System.out.println("Priority Queue is empty");
		}
		else {
			for(int i=front-1;i>=0;i--) {
				System.out.println(data[i]+" ");
			}
		}
	}
	
	public boolean isFull(){
		return front == maxsize;
	}
	public boolean isEmpty(){
		return front != maxsize;
	}

	//traverse
	public void traverse() {
		
		for(int i = 0;i<front;i++) {
			System.out.println(data[i]+" ");
		}
	}	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PriorityQueue p = new PriorityQueue();
		boolean option = true;
		String str;		
		int ch;	
		while(option) {
			try {
				System.out.println("1.Enqueue \n2.Dequeue\n3.Peek\n4.Contains\n5.Size\n6.Reverse\n7.Center\n8.Traverse\n9.Exit");
				System.out.println("Enter your choice");
		        ch=sc.nextInt();
	
				switch(ch) {
				
				case 1 :
					try {
						System.out.println("Enter element to enqueue:");
						int data = sc.nextInt();
						p.enQueue(data);
					}catch(InputMismatchException e) {
						System.out.println(e);
					}
					break;
					
				case 2:
					System.out.println("Deleted element is "+p.deQueue()); 
					break;
					
				case 3:
					System.out.println("Peek element is "+ p.peek());
					break;
					
				case 4:
					try {
						System.out.println("Enter element to search ");
						int search = sc.nextInt();
						p.contains(search);
					}catch(InputMismatchException e) {
						System.out.println(e);
					}
					break;
					
				case 5:
					System.out.println("Size of Priority queue is "+p.size());
					break;
					
				case 6:
					System.out.println("Reverse priority queue is: ");
					p.reverse();
					break;
					
				case 7:
					System.out.println("Center is "+p.center());
					break;
	
				case 8:
					p.traverse();
					break;
				
				case 11:
					System.out.println("Enter 1 to exit");
					System.exit(1);
					break;
					
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

