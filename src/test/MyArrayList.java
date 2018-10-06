package test;

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

	// this function returns a copy of the arraylist 
	public String toString(){
		StringBuilder s = new StringBuilder("a MyArrayList with " + 
											size + " items:");
		for (int i=0; i<size; i++)
			s.append("\n  ["+i+"]: "+data[i]);
		return s.toString();
		
	}

	// return the item at index i

	// this function returns the item at index i 
	public T get(int i){
		
		//check whether i is a valid index
		if(i < 0 || i > size) { // throw an error if the index is less than 0 or greater than the size of the array 
			throw new IndexOutOfBoundsException("Index " + i + " is invalid.");
		}
		// return item if valid
		return this.data[i];
		
	}
	
	// this function sets an item at index i to be x
	public void set(int i, T x){
		// check whether i is a valid index
		if(i < 0 || i > size) { // throw an error if the index is less than 0 or greater than the size of the array 
			throw new IndexOutOfBoundsException("Index " + i + " is invalid.");
		}
		// set item if valid
		this.data[i] = x;
	}
	
	
	// this method adds element x to the end of array 
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
	
	 // this function removes an element at a specifed index 
	public T remove(int i){
		
		T element = data[i];
		
		// check index 
		if(i < 0 || i >= this.size) { // Throw error if index specified is less than 0 or greater than size of array
			throw new IndexOutOfBoundsException("Index " + i + " is invalid.");
		}
		
		T[] newArray = (T []) new Object[data.length];
		
		// Remove and return element at position i
		if(i == (size-1)) {
			for(int x=0; x<this.size;x++) {
				newArray[x] = data[x]; }
				size--;
				this.data = newArray;
				return element; }

		int indexTwo=i+1;
		for(int x=0; x < this.size; x++) {				
			if(x<i) {
				newArray[x] = data[x];
			}else {
				newArray[x] = data[indexTwo];
				indexTwo++; }	
		}
		size--;
		this.data = newArray;
		return element; }
	
	// this method inserts and element at a specific index 
	 // Insert x at position i, shift elements if necessary 
	public void insert(int i, T x){
		// check the index 
		if(i < 0 || i > this.size) { // Throw error if index specified is less than 0 or greater than size of array
			throw new IndexOutOfBoundsException("Index " + i + " is invalid.");
		}
		// if the index is the end, append to the end 
		if(i == (this.size-1) ) {
			add(x); 
		}
		
		if(this.size == data.length) {
			// create a new array and double the size
			T [] input2 = (T []) new Object[this.size*2];
			
			// copy over from old array
			for (int y = 0; y<this.size; y++){
				input2[y] = data[y];
			}
			
			this.data = input2;
		}
		
		int pos = this.size;
		for(int y=0; y<=(this.size-i);y++) {
			data[pos+1] = data[pos];
			pos--; }
		data[i] = x;
		size++; }

	// this function searches for x 
	public int indexOf(T x){
		// search for x
		for(int i=0; i<size; i++) {
			if(data[i] == x) {
				// return the index for its first occurence
				return i;
			}
		}	
		// return -1 if not found 		
		return -1;
		
		
	}
}
