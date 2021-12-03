/*
 * Jasurbek Mamurov
 * U2010164
 * Lab #11
 * Driver
 * */

public class DriverThreading {

    public static void main(String[] args) {
       Table table = new Table();
		// 1st thread
		MyThread_1 thread_1 = new MyThread_1(table, 5);
		// 2nd thread
		MyThread_2 thread_2 = new MyThread_2(table, 10);
		// start threads
		thread_1.start();
		thread_2.start();

    }
}