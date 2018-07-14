# BankTellerSimualtion
Simulation of five bank teller lines that outputs customer's arrival time and departure time.
Used a circular linked list queue written fron scratch 
## Run Commands:
```
make
java -jar BankTeller.jar input.txt output.txt
```
## Input
The input is in the following format:
4 Jefferson 25 8
- Customer waits in Teller 4's line
- Customer name is Jefferson
- Arrives 25 minutes after simulation started
- Has a banking transaction that will take 8 minutes
## Output
Output file contains a line given the time at which each customer begins her transaction at a Teller, and another line giving the time at which each customer ends her transaction with a Teller.

