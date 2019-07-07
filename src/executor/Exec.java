package executor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Exec implements Callable<String> {

	@Override
	public String call() throws Exception {
		Thread.sleep(2000);
		return Thread.currentThread().getName();
	}

	public static void main(String... strings) throws InterruptedException, ExecutionException {
		ExecutorService executor = Executors.newFixedThreadPool(4);
		Callable<String> callable = new Exec();
		List<Future<String>> list = new ArrayList<Future<String>>();

		for (int i = 0; i < 10; i++) {
			Future<String> fts = executor.submit(callable);
			list.add(fts);
		}

		for (Future<String> fus : list) {

			System.out.println(new Date() + " : " + fus.get());

		}
		executor.shutdown();
	}

}
