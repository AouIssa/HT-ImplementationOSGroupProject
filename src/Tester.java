import java.util.*;

public class Tester  {

	public static void main(String[] args) {
	
    //Create threads for group with multithreading enabled
	Multithread t1 = new Multithread ("1");
	Multithread t2 = new Multithread ("2");
	
	//Create threads for group with multithreading disabled
	Multithread t3 = new Multithread ("3");
	Multithread t4 = new Multithread ("4");
	
	//Enter dataset for tasks
	t1.getData().add(45.00);
	t1.getData().add(75.00);
	t1.getData().add(456.00);
	t1.getData().add(47.99);
	t1.getData().add(23.9876);
	t1.getData().add(129.99);
	t1.getData().add(123.76);
	
	t2.getData().add(45.00);
	t2.getData().add(75.00);
	t2.getData().add(456.00);
	t2.getData().add(47.99);
	t2.getData().add(23.9876);
	t2.getData().add(129.99);
	t2.getData().add(123.76);
	
	t3.getData().add(45.00);
	t3.getData().add(75.00);
	t3.getData().add(456.00);
	t3.getData().add(47.99);
	t3.getData().add(23.9876);
	t3.getData().add(129.99);
	t3.getData().add(123.76);
	
	t4.getData().add(45.00);
	t4.getData().add(75.00);
	t4.getData().add(456.00);
	t4.getData().add(47.99);
	t4.getData().add(23.9876);
	t4.getData().add(129.99);
	t4.getData().add(123.76);
	
	t1.start();
	t2.start();
	t3.start();
	t4.start();
	
	//Wait for all the threads to be done with tasks before printing average and total time taken
	while(t1.isAlive() || t2.isAlive() || t3.isAlive() || t4.isAlive() ) {
		
	}
	Multithread.toPrint();
	}
}
