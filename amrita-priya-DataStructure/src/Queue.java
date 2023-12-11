import java.util.*;
public class Queue {
	 int maxSize = 3;
	 int front;
	 int rear = -1;
	 int currentSize = 0;
	 int queueArray[] = new int[maxSize];

	public void enQueue(int data) {
		if(isQueueFull()) {
			System.out.println("Queue is Full.");
		}
		else {
			rear++;
			queueArray[rear] = data;
			System.out.println(data+" is added in Queue");
			currentSize++;
		}
		
	}
	public void deQueue() {
		if(isQueueEmpty()) {
			System.out.println("Queue is Empty");
		
		}
		else {
			System.out.println("Deleted element is "+queueArray[front]);
			rear--;
			front++;	
			currentSize--;	
		}
		
	}

	public boolean isQueueEmpty() {
		
		return rear == -1;
	}
	

	public boolean isQueueFull() {
		
		return rear == maxSize-1;
	}
	public int peek() {
		if(isQueueEmpty()) {
			System.out.println("Empty Queue");
			return -1;
		}
		return queueArray[0];
	}
	
	public void contains(int search) {
		int flag = 0;
		for(int i=0;i<=rear;i++) {
			if(queueArray[i] == search) {
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
	
	public void sort() { 
		int temp;
		for(int i=0;i<size();i++) {
			for(int j = i+1;j<size();j++) {
				if(queueArray[i]<queueArray[j]) {
					temp = queueArray[i];
					queueArray[i] = queueArray[j];
					queueArray[j] = temp;
				}
			}
		}
		System.out.println("Sorted");		
	}

	public void reverse() {
		
		if(!isQueueEmpty()) {
			int t;
			for(int i=0;i<size()/2;i++) {
				t = queueArray[i];
				queueArray[i] = queueArray[size()-i-1];
				queueArray[size()-i-1] = t; 
			}
			System.out.println("Queue is reversed");
		}
		else {
			System.out.println("Queue is empty");
		}
		
	}

	public int size() {
		return currentSize;
	}
	public int center(){
		if(currentSize == 0) {
			System.out.println("Queue is empty");
			return 0;
		}
		else
		{
			int length = currentSize;
			return queueArray[length/2];
		}
	}
	public void iterator(int itr) {
		if(isQueueEmpty()) {
			System.out.println("Empty");
		}
		else
			System.out.println("Elements in Queue till iterator :");
			for(int i = front;i<=itr;i++) {
				System.out.print(queueArray[i]+"->");
			}
			System.out.println();
		
	}
	
	public void traverse() {
		if(isQueueEmpty()) {
			System.out.println("Empty");
		}
		else
			System.out.println("Elements in Queue:");
			for(int i = rear;i>=0;i--) {
				System.out.print(queueArray[i]+" ");
			}
			System.out.println();	
	}
	
	public static void main(String[] args) {
		 
		Scanner sc = new Scanner(System.in);
		boolean option = true;
		
		try {
			int ch;			
			Queue queue = new Queue();		
			while(option) {
				System.out.println("1.enQueue \n2.deQueue\n3.Peek\n4.Contains\n5.Size\n6.Center\n7.Sort\n8.Reverse\n9.Iterator\n10.Traverse\n11.Exit");
				System.out.println("Enter your choice");
		        ch=sc.nextInt();
		              
				switch(ch) {
				case 1 :					
					System.out.println("Enter element to enqueue:");
					int data = sc.nextInt();
					queue.enQueue(data);				
					break;
					
				case 2:
					queue.deQueue();
					break;
				case 3:
					System.out.println("Peek element is "+queue.peek());
					break;
				case 4:
					System.out.println("Enter element to search:");
					int search = sc.nextInt();
					queue.contains(search);		
					break;
				case 5:
					System.out.println("Size is "+ queue.size());
					break;
				case 6:
					System.out.println("Center is "+queue.center());
					break;
				case 7:
					queue.sort();	
					break;
				case 8:
					queue.reverse();
					break;
				case 9:
					System.out.println("Enter element upto iterate:");
					int itr = sc.nextInt();
					queue.iterator(itr);
					break;
				case 10:
					queue.traverse();
					break;
				case 11:
					System.out.println("Enter 1 to exit");
					System.exit(1);
				default:
					System.out.println("You have entererd wrong choice.\nPlease enter correct option");
				}
			}
			
		}
		catch(Exception e) {
			//flag = false;
			//System.out.println(e);
			System.out.println("Wrong Input");
			System.out.println("Do you want to continue: (y/n)");
			String str = sc.nextLine();
			switch(str) {
			case "y":
				option = true;
				break;
			case "n":
				option = false;
				break;
//			default:
//				System.out.println("x");
		}
			
			
		}
	
			sc.close();	
		}
		
	
}

				
				