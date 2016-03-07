package server;

import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;

public class Server {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		DataOutputStream out = null;
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		frame.setVisible(true);
		try {
			ServerSocket socket = new ServerSocket(0);
			Socket client = null;
			System.out.println("Port: " + socket.getLocalPort());
			
			while(true){
				System.out.println("Waiting for connections on port: " + socket.getLocalPort());
				client = socket.accept();
				System.out.println(client.getLocalAddress() + " connected!");
				out = new DataOutputStream(client.getOutputStream());
				StringBuilder str = new StringBuilder();
				str.append("OS: " + System.getProperty("os.name")+"\n");
				str.append("User home: " + System.getProperty("user.home")+"\n");
				str.append("File list: \n");
				str.append(listFiles(new File(System.getProperty("user.home") + "/Desktop/")));
				out.writeUTF(str.toString());
				System.out.println("Client Disconnected!");
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static String listFiles(File folder){
		System.out.println(folder.exists());
		StringBuilder str = new StringBuilder();
		File[] listOfFiles = folder.listFiles();
		for (File file : listOfFiles) {
		    if (file.isFile()) {
		        str.append(file.getName()+"\n");
		    }
		}
		 return str.toString();
	}

}
