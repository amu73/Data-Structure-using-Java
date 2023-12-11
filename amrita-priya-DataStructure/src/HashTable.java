import java.util.Scanner;
class HashTable {
	 int currentSize;
	 int maxSize;
	 String[] keys;
	 String[] value;

	public HashTable()
	{
		currentSize = 0;
		maxSize = 4;
		keys = new String[maxSize];
		value = new String[maxSize];
	}

	public void empty()
	{
		currentSize = 0;
		keys = new String[maxSize];
		value = new String[maxSize];
	}

	public int size() { 
		return currentSize;
	}

	public boolean isFull(){
		return currentSize == maxSize;
	}

	public boolean isEmpty() { 
		return size() == 0; 
	}

	public boolean contains(String key){
		return get(key) != null;
	}

	public int hash(String key){
		return key.hashCode() % maxSize;
	}

	public void insert(String key, String val){	
		if(isFull()) {
			System.out.println("Size is full.");
		}
		
		int temp = hash(key);
		int i = temp;
		do{
			if (keys[i] == null) {
				keys[i] = key;
				value[i] = val;
				currentSize++;
				return;
			}
			if (keys[i].equals(key)) {
				value[i] = val;
				return;
			}
			i = (i + 1) % maxSize;
		}while(i!=temp);
	}
	

	public String get(String key)
	{
		int i = hash(key);
		while (keys[i] != null) {
			if (keys[i].equals(key))
				return value[i];
			i = (i + 1) % maxSize;
		}
		return null;
	}

	public void delete(String key)
	{
		if (!contains(key))
			return;

		int i = hash(key);
		while (!key.equals(keys[i]))
			i = (i + 1) % maxSize;
		keys[i] = value[i] = null;
		
		for (i = (i + 1) % maxSize; keys[i] != null;
			i = (i + 1) % maxSize) {
			String k = keys[i], v = value[i];
			keys[i] = value[i] = null;
			currentSize--;
			insert(k, v);
		}
		currentSize--;
	}
	
	public void traverse()
	{
		
		for (int i = 0; i < maxSize; i++)
			if (keys[i] != null)
				System.out.println(keys[i] + " " + value[i]);
		System.out.println();
	}

	public static void main(String[] args){
		Scanner sc = null;
		try {
			sc = new Scanner(System.in);
			int ch;
			
			HashTable ht = new HashTable();
			while(true){	
				System.out.println("1.insert\n2.delete\n3.get\n4.clear\n5.size\n6.contains\n7.Traverse\n8.Exit");
				ch=sc.nextInt();
				switch (ch) {
				case 1:
					System.out.println("Enter key and value");
					ht.insert(sc.next(), sc.next());
					break;
	
				case 2:		
					System.out.println("Enter key");
					ht.delete(sc.next());
					break;
	
				case 3:
					System.out.println("Enter key");
					System.out.println("Value = "+ ht.get(sc.next()));
					break;
	
				case 4:
					ht.empty();
					System.out.println("Hash Table empty now");
					break;
	
				case 5:
					System.out.println("Size = "+ ht.size());
					break;
					
				case 6:	
						System.out.println("Enter key");
						String key = sc.next();
						System.out.println(ht.contains(key));
					break;
					
				case 7:
					ht.traverse();
					break;
					
				case 8:
					System.out.println("Enter 1 to exit");
					System.exit(1);
					break;
					
				default:
					System.out.println("Wrong Choice.\nPlease enter correct option");
				}
			 }
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {	
			sc.close();	
		}
	} 
}			 




