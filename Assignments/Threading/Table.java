/*Jasurbek Mamurov U2010164 Lab#11 Table*/

class Table{
	//for printing table
	synchronized void printTable(int n) {
	//check for the number
	if(n == 5){
		System.out.println("Table of Number : 5");
	}
	else if(n == 10){
		System.out.println("Table of Number : 10");
	}
		for(int i = 1; i <= 10; i++)
			System.out.println(n + " * " + i + " = " + i*n);
	}
}

// 1st thread class
class MyThread_1 extends Thread{
	// create table
	Table table = new Table();
	int number;
	//constructor
	MyThread_1(Table table, int number){
		this.table = table;
		this.number = number;
	}
	//print table function
	public void run() {
		table.printTable(number);		
	}
}

// 2nd thread class
class MyThread_2 extends Thread{

	// create table
	Table table = new Table();
	int number;
	//constructor
	MyThread_2(Table table, int number){
		this.table = table;
		this.number = number;
	}
	//print table function
	public void run() {
		table.printTable(number);			
	}
}


