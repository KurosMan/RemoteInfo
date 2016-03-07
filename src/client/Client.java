package client;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ip = "79.169.253.228";
		int port = 3650;
		DataInputStream in = null;
		try {
			Socket socket = new Socket(ip,port);
			in = new DataInputStream(socket.getInputStream());
			String result = in.readUTF();
			System.out.println(result);
			socket.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
