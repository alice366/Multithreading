package runnable.callable;

public class RunnableImpl implements Runnable {
	@Override
	public void run() {
		for (int x = 1; x <= 3; x++) {
			System.out.println("RunnableImpl in thread..." + x);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
