package dto;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	ServerSocket serverSocket;

			public Server(String path,String fname)
			{
				try 
				{
					System.out.println("Sending From Server");
					serverSocket = new ServerSocket(6000);
					Socket socket = serverSocket.accept();
					System.out.println("Client Request Accepted ");
					DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
					String fullPath=path+"/AttendanceSystemService/fingerprint/"+fname;
					File file = new File(fullPath);
					FileInputStream fin = new FileInputStream(file);
					dout.writeUTF(file.getName());
					dout.writeInt(fin.available());
					
					byte data[];
					int length;
					while((length = fin.available()) > 0 ){
						data = new byte[length];
						fin.read(data);
						dout.write(data);
					}
					
					fin.close();
					dout.flush();
					System.out.println(file.getName()+" sent");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		// TODO Auto-generated constructor stub
				
			}
			
			public Server() 
			{
				try 
				{
					System.out.println("Sending From Server");
					serverSocket = new ServerSocket(6000);
					Socket socket = serverSocket.accept();
					System.out.println("Client Request Accepted ");
					DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
//					String fullPath=path+"/AttendanceSystemService/fingerprint/"+fname;
					File file = new File("/home/administrator/apache-tomcat-7.0.64/webapps/AttendanceSystemService/fingerprint/1511001.raw");
					FileInputStream fin = new FileInputStream(file);
					dout.writeUTF(file.getName());
					dout.writeInt(fin.available());
					
					byte data[];
					int length;
					while((length = fin.available()) > 0 ){
						data = new byte[length];
						fin.read(data);
						dout.write(data);
					}
					
					fin.close();
					dout.flush();
					System.out.println(file.getName()+" sent");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		// TODO Auto-generated constructor stub
	}
			
			public static void main(String[] args) {
				 new Server();
			}

}
