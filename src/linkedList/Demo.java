package linkedList;

public class Demo {

	public static void main(String[] args) {
		
		LinkedList test = new LinkedList(4);
		
		test.push(3);
		test.push(2);
		test.push(1);
		Object work = test.get();
		
		
		System.out.println(test.getSize());
		
		

	}

}
