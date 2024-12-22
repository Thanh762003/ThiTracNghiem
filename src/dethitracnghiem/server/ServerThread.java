/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dethitracnghiem.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

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

    @Override
    public void run() {
        try {
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            String receive = dis.readUTF();
            String receiveArray[] = receive.split("///");
            //int flag = flag(receiveArray[0]);
            switch (Integer.parseInt(receiveArray[0])) {
                case 1:
                    if (receiveArray[1].equals("localhost") && receiveArray[2].equals("1433")) {
                        System.out.println("Arrdress: " + receiveArray[1] + "\nPort: " + receiveArray[2]);
                        dos.writeUTF("Connected");
                    } else {
                        dos.writeUTF("Connected fail");
                    }
                    break;
                case 2:
                    System.out.print(receive);
                    if (ConnectDB.getConnect(receive) == true) {
                        dos.writeUTF("Connected");
                    } else {
                        dos.writeUTF("Connected fail");
                    }
                    break;
            }
        } catch (Exception e) {
        }
    }
    
    
}
