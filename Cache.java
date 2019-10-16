import java.util.Hashtable;
import java.util.Map;

public class Cache {
	private Map<String, String> buffer;
	private ReentrantLock mutex = new ReentrantLock();

	public Cache() {
		buffer = new Hashtable<>();
	}



	// place value into buffer
	public void set(int value) {
		try {

			mutex.lock();

			while (buffer != -1) {
				mutex.unlock();
				mutex.lock();
			}

			System.out.printf("Producer writes\t%2d", value);
			buffer = value;
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			mutex.unlock();
		}
	} // end method set

	// return value from buffer
	public int get() {
		int value = -1;
		try {
			mutex.lock();
			while (buffer == -1) {
				mutex.unlock();
				mutex.lock();
			}
			value = buffer;
			buffer = -1;
			System.out.printf("Consumer reads\t%2d", value);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			mutex.unlock();
		}
		return value;
	} // end method get
}
