class Queue{
	private Node lastNode;

	//sets last node as null
	public Queue(){
		lastNode = null;
	}
	//isEmpty method
	public boolean isEmpty(){
		return lastNode == null;
	}
	//dequeueAll method
	public void dequeueAll(){
		lastNode = null;
	}
	//enqueue method
	public void enqueue(int tellerLine, String name, int enTime, int trTime){
		Node newNode = new Node(tellerLine, name, enTime, trTime);

		if(isEmpty()){
			newNode.next = newNode;
		}
		else{
			newNode.next = lastNode.next;
			lastNode.next = newNode;
		}
		lastNode = newNode;
	}
	//dequeue method
	public void dequeue(){
		if(!isEmpty()){
			Node first = lastNode.next;

			if(first == lastNode){
				lastNode = null;
			}
			else{
				lastNode.next = first.next;
			}
		}
	}
	//this method replaces the first node in the queue with a new node
	public void replaceFirst(int l, String n, int a, int t){
		if(!isEmpty()){
			Node replace = new Node(l,n,a,t);
			Node first = lastNode.next;
			if(first == lastNode){
				replace.next = replace;
				lastNode = replace;
			}
			else{
				replace.next = first.next;
				lastNode.next = replace;
			}
		}
	}
	//returns the teller line the node contains
	public int peekTeller(){
		int n = 0;
		if(!isEmpty()){
			Node first = lastNode.next;
			n = first.getTellerLine();
		}
		return n;
	}
	//returns the arrival time the node contains
	public int peekArrival(){
		int n = 0;
		if(!isEmpty()){
			Node first = lastNode.next;
			n = first.getArrivalTime();
		}
		return n;
	}
	//returns the transaction time the node contains
	public int peekTransaction(){
		int n = 0;
		if(!isEmpty()){
			Node first = lastNode.next;
			n = first.getTransactionTime();
		}
		return n;
	}
	//returns the name the node contains
	public String peekName(){
		String n = " ";
		if(!isEmpty()){
			Node first = lastNode.next;
			n = first.getName();
		}
		return n;
	}
}