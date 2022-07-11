import java.net.*;
import java.io.*;

public class server {

	private static final class Handler extends Thread {
		private Socket s;
		public Handler(Socket s) { 
			this.s = s;
		}
		public void run() { try {
			handleConnection(s);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
	}

	public static void main(String[] args) throws IOException{
		ServerSocket ss = new ServerSocket(4999);
		while( !ss.isClosed() ){
		Socket s = ss.accept();
		Thread thread = new Handler(s);	
		thread.start();
		//welcome message when the server is spun up 
		
		}
		
	}

	private static void handleConnection(Socket s) throws IOException {
		System.out.println("client connected Welcome to the VOID");

		InputStreamReader  in = new InputStreamReader(s.getInputStream());
		BufferedReader bf = new BufferedReader(in);
		
		
		String str = bf.readLine();
		System.out.println("Client: "+ str);
		
		PrintWriter pr = new PrintWriter(s.getOutputStream());
		pr.println("sugoi, it does");
		pr.flush();
		s.close();
	}

}
// jorden brown 