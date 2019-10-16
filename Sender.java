import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Sender implements Runnable {
	private static final int port = 7780;

	@Override
	public void run() {
		try {
			DatagramSocket datagramSocket = new DatagramSocket();
			InetAddress addr = InetAddress.getByName("localhost");
			String msg = "bird";
			DatagramPacket request = new DatagramPacket(msg.getBytes(), msg.getBytes().length, addr, port);
			// envia request
			datagramSocket.send(request);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
