package lock;

public class NotifyWait {

	public static void main(String... args) {
		NotifyWait nw = new NotifyWait();
		Object obj = new Object();

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				synchronized (obj) {
					System.out.println("t1 start");
					try {
						obj.wait();
						System.out.println("t1 middle");

					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("t1 end");

				}
			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				synchronized (obj) {
					System.out.println("t2 start");
					try {
						obj.wait();
						System.out.println("t2 middle");

					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					System.out.println("t2 end");

				}
			}
		});
		t1.start();
		t2.start();
		System.out.println("all done");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		synchronized (obj) {
			obj.notifyAll();
		}

	}

}
