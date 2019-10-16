import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Init {
	private final static int poolSize = 5;

	public static void main(String[] args) {

		
		Server server = new Server();

		ExecutorService pool = Executors.newFixedThreadPool(poolSize);
		try {
			while (true) {
				Thread thread = new Thread(server);
				try {
					Thread.sleep(100000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Thread t = new Thread(new Sender());
				t.start();
				pool.execute(server);
			}
		} finally {
			pool.shutdown();
		}
	}
}
