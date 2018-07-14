import java.io.*;
import java.util.Scanner;

public class Main{
	public static void main(String[] args) throws IOException{
		int time = 0;
		int tellerLine = 0;
		int arrival = 0;
		int transactionTime = 0;
		String name = " ";
		int leaveTime = 0;
		
		if(args.length < 2){
			System.out.println("Error");
			System.exit(1);
		}

		Scanner in = new Scanner(new File(args[0]));
		PrintWriter out = new PrintWriter(new FileWriter(args[1]));

		//create 5 queues to correspond to 5 different tellers
		Queue teller1 = new Queue();
		Queue teller2 = new Queue();
		Queue teller3 = new Queue();
		Queue teller4 = new Queue();
		Queue teller5 = new Queue();

		while(in.hasNext()){
			String line = in.nextLine().trim() + " ";
			String[] content = line.split("\\s+");
			//stores line #, name, arrival time, and transcation time into 4 seperate 
			//variables corresponding to each line from output file
			for(int i = 0; i < content.length; i++){
				tellerLine = Integer.parseInt(content[i]);
				i++;
				name = content[i];
				i++;
				arrival = Integer.parseInt(content[i]);
				i++;
				transactionTime = Integer.parseInt(content[i]);
			}
			//stores a person in a queue depending on which line they are waiting in
			if(tellerLine == 1){
				teller1.enqueue(tellerLine,name,arrival,transactionTime);
			}
			if(tellerLine == 2){
				teller2.enqueue(tellerLine,name,arrival,transactionTime);
			}
			if(tellerLine == 3){
				teller3.enqueue(tellerLine,name,arrival,transactionTime);
			}
			if(tellerLine == 4){
				teller4.enqueue(tellerLine,name,arrival,transactionTime);
			}
			if(tellerLine == 5){
				teller5.enqueue(tellerLine,name,arrival,transactionTime);
			}
		}//end of while lopp
		//for loop goes in a continuous loop until all queues are empty
		for(int i = time; i <= time; time++){
			//only for teller1
			/*if the person at the front of the queue has finished, remove them and check if there is
			  a next person in line*/
			finishedTransaction(teller1,time,out);
			/*if there is a next person in line start their transaction,calculate their departure time
			  and store it in the node*/
			arriving(teller1,time,leaveTime,out);
			//only for teller2---------------------------------
			finishedTransaction(teller2,time,out);
			arriving(teller2,time,leaveTime,out);
			//only for teller3---------------------------------
			finishedTransaction(teller3,time,out);
			arriving(teller3,time,leaveTime,out);
			//only for teller4---------------------------------
			finishedTransaction(teller4,time,out);
			arriving(teller4,time,leaveTime,out);
			//only for teller5---------------------------------
			finishedTransaction(teller5,time,out);
			arriving(teller5,time,leaveTime,out);

			//if all queues are empty then increment i and break out of the loop
			if(teller1.isEmpty() && teller2.isEmpty() && teller3.isEmpty()
				&& teller4.isEmpty() && teller5.isEmpty()){
				i++;
			}

		}//end of for loop
		in.close();
		out.close();
	}//end of main

	public static void finishedTransaction(Queue teller,int time, PrintWriter out){
		if(!teller.isEmpty() && time == teller.peekTransaction()){
			out.println(teller.peekTeller() + " " + teller.peekName() + " ends " + time);
			teller.dequeue();
			/* checks to see if there is a next person in line, if there is replace the time they
			arrived with the current time*/
			if(!teller.isEmpty() && time >= teller.peekArrival()){
				teller.replaceFirst(teller.peekTeller(),teller.peekName(),time,teller.peekTransaction());
			}
		}
	}

	public static void arriving(Queue teller,int time,int leaveTime,PrintWriter out){
		if(!teller.isEmpty() && time == teller.peekArrival()){
			out.println(teller.peekTeller() + " " + teller.peekName() + " " + "begins " + time);
			leaveTime = time + teller.peekTransaction();
			teller.replaceFirst(teller.peekTeller(),teller.peekName(),teller.peekArrival(),leaveTime);
		}
	}
}