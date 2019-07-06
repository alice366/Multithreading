package able;

import java.util.concurrent.Callable;

public class CallableImpl implements Callable<String> {

	@Override
	public String call() throws Exception {
		System.out.println("CallableImpl in thread...");
		Thread.sleep(10000);
		return "String del Futuro";
	}

}
