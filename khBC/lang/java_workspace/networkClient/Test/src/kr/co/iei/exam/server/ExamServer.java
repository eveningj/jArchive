package kr.co.iei.exam.server;

import java.io.DataInputStream;

import java.io.DataOutputStream;

import java.io.IOException;

import java.io.InputStream;

import java.io.OutputStream;

import java.net.ServerSocket;

import java.net.Socket;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ExamServer {

public void timeServer() {

int port = 9999;

ServerSocket serverSocket = null;

DataInputStream dis = null;

DataOutputStream dos = null;

try {

serverSocket = new ServerSocket(port);


Socket clientSocket = serverSocket.accept();

InputStream in = clientSocket.getInputStream();

OutputStream out = clientSocket.getOutputStream();

dis = new DataInputStream(in);

dos = new DataOutputStream(out);


dos.writeUTF("[서버 연결 성공]");

Calendar c = Calendar.getInstance();
long thisTime = c.getTimeInMillis();
Date date = new Date(thisTime);



SimpleDateFormat sdf = new SimpleDateFormat("aa hh:mm:ss");



String now = sdf.format(date);

System.out.println(now);
dos.writeUTF("[현재시간] : "+now);

} catch (IOException e) {

e.printStackTrace();

}finally {

try {

dis.close();

dos.close();

serverSocket.close();

} catch (IOException e) {

e.printStackTrace();

}

}

}

}