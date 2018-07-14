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
		Node newNode = new Node(tellerline, name, entime, trtime);

		if(isEmpty()){
			newNode.getNext() = newNode;
		}
		else{
			newNode.getNext() = lastNode.getNext();
			lastNode.getNext() = newNode;
		}
		lastNode = newNode;
	}
	//dequeue method
	public void dequeue(){
		if(!isEmpty()){
			Node first = lastNode.getNext();

			if(first == lastNode){
				lastNode = null;
			}
			else{
				lastNode.getNext() = first.getNext()
			}
		}
	}
	
}