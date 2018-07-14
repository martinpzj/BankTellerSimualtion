class Node{
	private int tellerLine;
	private String name;
	private int arrivalTime;
	private int transactionTime;
	public Node next;

	public Node(int tellerLine, String name, int arrivalTime, int transactionTime){
		this.tellerLine = tellerLine;
		this.name = name;
		this.arrivalTime = arrivalTime;
		this.transactionTime = transactionTime;
		next = null;
	}

	public int getTellerLine(){
		return tellerLine;
	}

	public String getName(){
		return name;
	}

	public int getArrivalTime(){
		return arrivalTime;
	}

	public int getTransactionTime(){
		return transactionTime;
	}

}