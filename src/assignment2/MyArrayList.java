package assignment2;

/**
 * Our expandable array class
 * generic: can hold any type
 */
 
public class MyArrayList<T>{

	// underlying array
	private T[] data;
	
	// how many items in data array currently
	private int size;
	
	// constructor
	// create an empty array of some default initial capacity
	@SuppressWarnings("unchecked")
	public MyArrayList(){
		data = (T [])new Object[5];  
		size = 0;
	}
	
	// actual length of the array
	public int size(){
		return size;
	}

	/***
	 * returns a representation of the arraylist 
	 */
	public String toString(){
		StringBuilder s = new StringBuilder("a MyArrayList with " + 
											size + " items:");
		for (int i=0; i<size; i++)
			s.append("\n  ["+i+"]: "+data[i]);
		return s.toString();
		
	}

	// return the item at index i
	/***
	 * 
	 * @param i for specified index
	 * @return The element at specified index
	 */
	public T get(int i){
		
		//check whether i is a valid index
		// return item if valid
		// otherwise?
		
		if(i < 0 || i > size) { // Throw error if index specified is less than 0 or greater than size of array
			throw new IndexOutOfBoundsException("Index " + i + " is out of bounds!");
		}
		return this.data[i];
		
	}
	
	/***
	 * 
	 * @param i specified index
	 * @param x specified element
	 * Method sets an item at index i to be x
	 */
	public void set(int i, T x){
		// check whether i is a valid index
		if(i < 0 || i > size) { // Throw error if index specified is less than 0 or greater than size of array
			throw new IndexOutOfBoundsException("Index " + i + " is out of bounds!");
		}
		// set item if valid
		this.data[i] = x;
		
		// otherwise?
	
	
	}
	
	/**
	 * Method appends an element x to the end of the array	 		 
	 * @param x element specified
	 */
	public void add(T x){
		//check whether capacity has reached
		if (size == data.length){
			//if yes: expand array 
			
			// create a new array, double the size
			T [] data2 = (T []) new Object[size*2];
			
			// copy over from old array
			for (int i = 0; i<size; i++){
				data2[i] = data[i];
			}

			//old data?
			data = data2;
		}
		
		// now we can add + update size
		data[size] = x;
		size++;
		
	}
	
	// Remove and return element at position i
	// shift elements to remove the gap
	// Other variations: remove an item x?
	/***
	 * 
	 * @param i the specified index
	 * @return the element at the specified index i  
	 */
	public T remove(int i){
		
		T item = data[i];
		
		if(i < 0 || i >= this.size) { // Throw error if index specified is less than 0 or greater than size of array
			throw new IndexOutOfBoundsException("Index " + i + " is out of bounds!");
		}
		
		T[] tempArray = (T []) new Object[data.length];
		
		if(i == (size-1)) {
			for(int x=0; x<this.size;x++) {
				tempArray[x] = data[x];
			}
				size--;
				this.data = tempArray;
				return item;
		}

		int secondIndex=i+1;
		for(int x=0; x < this.size; x++) {				
			if(x<i) {
				tempArray[x] = data[x];
			}else {
				tempArray[x] = data[secondIndex];
				secondIndex++;
			}
			
		}
		size--;
		this.data = tempArray;
		return item;
	}
	
	/***
	 * Method inserts an element at the specified index and shifts any elements over if necessary
	 * @param i specified index
	 * @param x specified element to insert
	 */
	public void insert(int i, T x){
		
		if(i < 0 || i > this.size) { // Throw error if index specified is less than 0 or greater than size of array
			throw new IndexOutOfBoundsException("Index " + i + " is out of bounds!");
		}
		if(i == (this.size-1) ) {
			add(x); 
		}
		
		if(this.size == data.length) {
			
			// create a new array, double the size
			T [] data2 = (T []) new Object[this.size*2];
			
			// copy over from old array
			for (int y = 0; y<this.size; y++){
				data2[y] = data[y];
			}
			
			this.data = data2;
		}
		
		int position = this.size;
		for(int y=0; y<=(this.size-i);y++) {
			data[position+1] = data[position];
			position--;
			//System.out.println("" + data);
		}
		data[i] = x;
		
		size++;
	}

	
	
	
	/***
	 * Method returns the first occurence of the specified element in the arraylist, else -1 if not available
	 * @param x element to find
	 * @return the index of the specified element
	 */
	public int indexOf(T x){
		
		for(int i=0; i<size; i++) {
			if(data[i] == x) {
				return i;
			}
			
		}		
		return -1;
	}
	

}

