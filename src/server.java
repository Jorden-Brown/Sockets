import java.net.*;
import java.io.*;

public class server {

	public static void main(String[] args) throws IOException{
		ServerSocket ss = new ServerSocket(4999);
		Socket s = ss.accept();
		
		System.out.println("client connected Welcome to the VOID");

		InputStreamReader  in = new InputStreamReader(s.getInputStream());
		BufferedReader bf = new BufferedReader(in);
		
		String str = bf.readLine();
		System.out.println("Client: "+ str);
	}

}
