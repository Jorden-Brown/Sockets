import java.net.*;
import java.io.*;

public class socket {

	public static void main(String[] args) throws IOException{
		
		Socket s = new Socket("localhost", 4999);
		
		PrintWriter pr = new PrintWriter(s.getOutputStream());
		pr.println("Subarashi, does it work??");
		pr.flush();
		
		
		InputStreamReader  in = new InputStreamReader(s.getInputStream());
		BufferedReader bf = new BufferedReader(in);
		
		
		String str = bf.readLine();
		System.out.println("server: "+ str);
		
	}

}
// jorden brown there will finally be changes 