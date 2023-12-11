import java.util.*;
public class Stack {
	int size = 3;
	int arr[] = new int[size];
	int top = -1;
	public boolean isFull() {
		return (size-1 == top);
	}
	public boolean isEmpty() {
		return (top == -1);
	}
	
	public void push(int data) {
		if(!isFull()) {
			top++;
			arr[top] = data;
			System.out.println("Element Pushed : "+data);
			}
		else {
			System.out.println("Stack is full:Overflow");
		}
	
	}
	
	public int pop() {
		if(isEmpty()) {
			System.out.println("Stack is empty");
			return -1;
		}
		else {
			int data = arr[top];
			top--;
			return data;
		}
			
	}
	
	public int peek() {
		return arr[top];
	}
	public void contains(int search) {
		int flag = 0;
		for(int i=0;i<=top;i++) {
			if(arr[i] == search) {
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
	
	public int center(){
		if(top == 0) {
			System.out.println("Stack is empty");
			return 0;
		}
		else
		{
			int length = top+1;
			return arr[length/2];
		}
	}
	public int size() {
		return top+1;
	}
	
	public void reverse() {
		if(!isEmpty()){
			int t;
			for(int i=0;i<size()/2;i++){
				t=arr[i];
				arr[i]=arr[size()-i-1];
				arr[size()-i-1]=t;
			}
			System.out.println(":Stack has been reversed");
		}
		else{
		System.out.println(":Stack is empty");
		}
	}
	
	
	public void sort() {
		int temp;
		for(int i=0;i<size();i++){
			for(int j=i+1;j<size();j++){
				if(arr[i]<arr[j]){
					temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
		System.out.println("Sorted;");
		}
	
	//iterating LL
	public void iterator(int n) {
		System.out.println("Printing Stack elements:");
		for(int i=top;i>=n;i--) {
			System.out.println(arr[i]+" ");
		}
	}

	//printing LL
	public void traverse() {
		if(isEmpty()) {
			System.out.println("Stack is empty");;
		}
		else {
			System.out.println("Printing Stack elements:");
			for(int i=top;i>=0;i--) {
				System.out.print(arr[i]+" ");
			}
			System.out.println();
		}
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean option = true;
		String str;		
		int ch;	
		Stack stack = new Stack();
	
		while(option) {
			try {
				
				System.out.println("1.Push \n2.Pop\n3.Peek\n4.Contains\n5.Size\n6.Center\n7.Sort\n8.Reverse\n9.Iterator\n10.Traverse\n11.Exit");
				System.out.println("Enter your choice");
		        ch=sc.nextInt();
		        
				switch(ch) {
					case 1 :
						System.out.println("Enter element to push:");
						int data = sc.nextInt();
						stack.push(data);
						break;
						
					case 2:
						System.out.println("Popped element is "+stack.pop());
						stack.pop();
						break;
						
					case 3:
						System.out.println("Peek element is "+stack.peek());
						break;
						
					case 4:
						System.out.println("Enter element to search:");
						int search = sc.nextInt();
						stack.contains(search);
						break;
						
					case 5:System.out.println("Size is "+stack.size());
						break;
						
					case 6:
						System.out.println("Center is "+stack.center());	
						break;
						
					case 7:
						stack.sort();
						break;
						
					case 8:
						System.out.println("Elements are reversed");
						stack.reverse();
						break;
						
					case 9:
						System.out.println("Enter element upto which you want to iterate:");
						int itr = sc.nextInt();
						stack.iterator(itr);
						break;
					case 10:
						stack.traverse();
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
