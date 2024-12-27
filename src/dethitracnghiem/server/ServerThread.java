/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dethitracnghiem.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class ServerThread implements Runnable {
    private Socket socket;
    private String name;
    
    public ServerThread(Socket socket, String name) {
        this.socket = socket;
        this.name = name;
        
        new Thread(this).start();
    }

    private boolean isValidIP(String ip) {
        String ipv4Regex = "^((25[0-5]|2[0-4][0-9]|[0-1]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[0-1]?[0-9][0-9]?)$";
        
        if(ip.equalsIgnoreCase("localhost")) {
            return true;
        } 
        
        return ip.matches(ipv4Regex);
    }
    
    private boolean isValidPort(String port) {
        try {
            int p = Integer.parseInt(port);
            
            return p >= 1 && p <= 65535;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    @Override
    public void run() {
        try {
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            
            String receive = dis.readUTF();
            
            System.out.println("Received from client: " + receive);
            
            String receiveArray[] = receive.split("///");
            
            int flag = Integer.parseInt(receiveArray[0]);
            switch (flag) {
                case 1:
                    if (isValidIP(receiveArray[1]) && isValidPort(receiveArray[2])) {
                        System.out.println("Adress: " + receiveArray[1] + "\nPort: " + receiveArray[2]);
                        dos.writeUTF("Connected");
                    } else {
                        System.err.println("Invalid address or port: " + receiveArray[1] + ", " + receiveArray[2]);
                        dos.writeUTF("Connected fail");
                    }
                    
                    break;
                case 2:
                    System.out.print("Database connection request: " + receive);
                    
                    if (DBConnection.getConnect(name) == true) {
                        dos.writeUTF("Connected to Database");
                    } else {
                        dos.writeUTF("Connected to Database fail");
                    }
                    
                    break;
                default:
                    System.out.println("Unknown flag: " + flag);
                    dos.writeUTF("Invalid request");
                    
                    break;
            }
        } catch (IOException e) {
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                socket.close();
                System.out.println("Connection closed for " + name);
            } catch (IOException e) {
                Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
}
