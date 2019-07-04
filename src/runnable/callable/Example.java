package runnable.callable;

import java.util.concurrent.FutureTask;

public class Example {

	public static void main(String[] args) throws Exception {

		RunnableImpl ri = new RunnableImpl();
		Thread t1 = new Thread(ri);
		System.out.println("starting RunnableImpl");
		t1.start();
		// calling ri.run() here would never execute "started"
		System.out.println("started RunnableImpl");
		//waits for t1 to complete:
		t1.join();

		System.out.println("starting CallableImpls");
		CallableImpl ci = new CallableImpl();
		FutureTask<String> ft = new FutureTask<>(ci);
		Thread t2 = new Thread(ft);
		t2.start();
		// thread continues and prints the following line
		System.out.println("started CallableImpls");
		// thread blocks untill it gets its result and then prints it out
		System.out.println("futureString: " + ft.get());

	}

}
