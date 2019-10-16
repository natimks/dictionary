import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Server implements Runnable {
	private int port = 7780;
	private DatagramSocket datagramSocket;

	public Server() {
		try {
			datagramSocket = new DatagramSocket(port);
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (true) {
			byte buffer[] = new byte[1000];
			DatagramPacket request = new DatagramPacket(buffer, buffer.length);
			try {
				datagramSocket.receive(request);
				String msg = new String(request.getData());
				System.out.println("Palavra recebida: " + msg);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
