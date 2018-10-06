package linkedList;

public class LinkedList {
	
	Node first;
	Node tail;
	int size=0;
	
	class Node{
		Node next = null;
		Object data;
		
		public Node(Object d) {
			this.data = d;
		}
		
		public Node() {
			// test
		}

	}
	
	public LinkedList() {
		Node newNode = new Node();
		first = newNode;
		tail = newNode;
	}
	
	public LinkedList(Object d) {
		Node newNode = new Node(d);
		//newNode.data = d;
		first = newNode;
		tail = newNode;
		size++;
	}
	
	public int getSize() {
		return this.size;
	}
	public Object get() {
		return first.data;
	}
	
	public void push(Object d) { //Push element to the front of the list
		Node node = new Node(d);
		node.next = first;
		first = node;
		size++;
	}
	
	public void append(Object d) { //Add element to the end
		
		Node tempNode = first;
		
		while(tempNode.next != null) {
			tempNode = tempNode.next;
		}
		
		Node newNode = new Node(d);
		
		//newNode.data = d;
		tempNode.next = newNode;
		first = newNode;
		size++;
	}
	

}
