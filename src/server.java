import java.net.*;
import java.nio.charset.Charset;
import java.io.*;
import java.io.File;
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

	        
	        
			// creation of socket object 
		ServerSocket ss = new ServerSocket(4999);
		while( !ss.isClosed() ){
		Socket s = ss.accept();
		Thread thread = new Handler(s);	
		thread.start();
		
		
		
		
		
		
		// String st;
	     //   while ((st = br.readLine()) != null)
	       // 	System.out.println(st);
		//welcome message when the server is spun up 
	        
	        
	        System.out.println("This is the end of the program");
		}
		
	}

	private static void handleConnection(Socket s) throws IOException {
		System.out.println("client connected Welcome to the VOID");

		//New string using a stringbuilder
		StringBuilder rawInput_ = new StringBuilder(); 
		//Get the inputstream from the socket request
		//then read the inputstream into the string
		try(Reader reader = new BufferedReader(new InputStreamReader(s.getInputStream(), 
				Charset.defaultCharset()))){
			int c = 0; 
			while((c = reader.read()) != -1) {
				rawInput_.append((char)c);
			}
		}

		String[] lines = rawInput_.toString().split("\\n"); 
		//********File + path to look for **********
		String fileRequest = lines[0].replace("HTTP/1.1", "").replace("GET ", "").trim();
		
		System.out.println("Looking for file: " + fileRequest);
		
		// test if the file is there an is exist method 
				File file = new File("D:\\Java\\sockets\\Test.txt");
				boolean exists = file.exists();
				PrintStream stream = new PrintStream(System.out);
				if (file.exists()== true && file.equals(fileRequest)) {
				
				stream.println("The file  "+ file +" does the file exist ->" +exists);
				//BufferedReader br = new BufferedReader(new FileReader(file));
				stream.flush();
				
				}
				
					//if (!file.equals(fileRequest)) {
				{
					File nFile = new File(fileRequest);
					stream.println("Creating new file...."+fileRequest);
					FileWriter myWriter = new FileWriter(fileRequest);
					 
					myWriter.write("Hey you are makign a new text file congrats");
				     
					myWriter.close();
				      System.out.println("Successfully wrote to the file.");
					//BufferedReader br = new BufferedReader(new FileReader(file));
					stream.flush();
				}
		
		//InputStreamReader  in = new InputStreamReader(s.getInputStream());
		//BufferedReader bf = new BufferedReader(in);
		
		
		//String str = bf.readLine();
		//System.out.println("Client: "+ str);
		
	//	PrintWriter pr = new PrintWriter(s.getOutputStream());
	//	pr.println("sugoi, it does");
	//	pr.flush();
		s.close();
	}

}
