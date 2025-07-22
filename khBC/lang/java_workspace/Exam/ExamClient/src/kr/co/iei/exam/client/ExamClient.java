package kr.co.iei.exam.client;

import java.io.DataInputStream;

import java.io.DataOutputStream;

import java.io.IOException;

import java.io.InputStream;

import java.io.OutputStream;

import java.net.Socket;

public class ExamClient {

public void timeClient() {

String serverIp = "127.0.0.1";

int serverPort = 9999;

Socket socket = null;

DataInputStream dis = null;

DataOutputStream dos = null;

try {

socket = new Socket(serverIp, serverPort);

InputStream in = socket.getInputStream();

OutputStream out = socket.getOutputStream();

dis = new DataInputStream(in);

dos = new DataOutputStream(out);

String serverMsg = dis.readUTF();


System.out.println(serverMsg);

String time =  dis.readUTF();
System.out.println(time);

} catch (IOException e) {

e.printStackTrace();

}finally {

try {

dis.close();

dos.close();

socket.close();

} catch (IOException e) {

e.printStackTrace();

}

}

}

}