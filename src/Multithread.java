import java.util.*;
import java.lang.*;

public class Multithread extends Thread {
	private static long hyperthreadTime ;
	private static long singleThreadTime ;
	private ArrayList<Double> data = new ArrayList<Double> ();
	private static ArrayList<String> countThread = new ArrayList<String> ();
	
	
    Multithread(String name) {
    	super(name);
    	revise(name);
    }
	 
     void revise(String name) {
    	if (countThread.contains(name) == false ) {
    		countThread.add(name);
    	}
    		
    }
     public void run() {
    	 long initialTime;
    	 long endTime;
    	 double result;
    	 long period;
    	 
    	 if(this.getName() == "1" || this.getName() == "2") {
    		//start task operation time
    		  initialTime = System.nanoTime();
    		  result = workload_test1();
    		//end task operation time
       	     endTime = System.nanoTime();
       	//get the time taken to do the task
              period = endTime - initialTime;
        	 hyperthreadTime += period;
    	 }
    	 else {
    		//start task operation time
    		  initialTime = System.nanoTime();
    		 result = workload_test2();	
    		//end task operation time
    		  endTime = System.nanoTime();
    		//get the time taken to do the task
    	          period = endTime - initialTime;
    	    	 singleThreadTime += period;
    	 }
         
         System.out.println("Thread "+this.getName()+" result: "+result+" time taken: "+period+" nanosecond ");
    	 
        }
         /* workload without "Synchronized". Both threads are allowed  to do the task simultaneously. Since the threads can 
	        do the tasks simultaneously, it is  considered multithreading (hyperthreading)                 */
    	 double workload_test1 () {
         	double a = 0;
         	double b = 1;
         	
         	for (int i = 0; i < this.data.size(); ++i) {
         		for(int v = 0; v < 5; v++) {
         			b *= this.data.get(i);
         		}
         		a += b;
         	}
         	 double result = a;
         	 return result;
            
    	}
    	 /* workload with "Synchronized". Only one thread is allowed at a time to do the task. Since the threads can't 
    	   do the tasks simultaneously, it is not considered multithreading (hyperthreading)                 */
    	synchronized double workload_test2 () {
          	
          	double a = 0;
          	double b = 1;
          	
          	for (int i = 0; i < this.data.size(); ++i) {
          		for(int v = 0; v < 5; v++) {
          			b *= this.data.get(i);
          		}
          		a += b;
          	}
          	 double result = a;
          	 return result;
     	}

	public ArrayList<Double> getData() {
		return data;
	}
	
	static void toPrint() {
		System.out.println("\nThread with multithreading(hyperthreading) enabled  : 1, 2 Total time taken:"
				+ " "+hyperthreadTime+" nanosecond Average time: "+(hyperthreadTime/2)+" nanosecond ");
		System.out.println("Thread with multithreading(hyperthreading) disabled : 3, 4 "
				+ "Total time taken: "+singleThreadTime+" nanosecond Average time: "+(singleThreadTime/2)+" nanosecond ");
	}   
}
