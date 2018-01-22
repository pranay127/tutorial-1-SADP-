package userinterface;
 import java.io.*;  
 import java.net.*;  
 import java.util.Scanner;
 public class client {  
     public static void main(String[] args) {  
     try{      
     Socket s=new Socket("localhost",3333);  
     DataInputStream dis=new DataInputStream(s.getInputStream());
     DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
     String str ="";
     Scanner sc = new Scanner(System.in);
     System.out.println("Server connected ");
     while(str.compareTo("quit")!=0)
     {
     	System.out.print("Me : ");
     	str = sc.nextLine();
 	    dout.writeUTF(str);
 	    dout.flush();
 	    str=(String)dis.readUTF();
 	    System.out.print("Server : ");
 	    System.out.println(str);
 	    
    }
     System.out.println("Server disconnected ");
     dout.close();  
     s.close();  
     }catch(Exception e){System.out.println(e);}  
     }  
 }
