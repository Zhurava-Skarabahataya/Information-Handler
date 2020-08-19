package by.epamtc.textonator.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import by.epamtc.textonator.DAO.reader.ResourceProvider;
import by.epamtc.textonator.bean.Text;
import by.epamtc.textonator.logic.FileParsingExecutor;
import by.epamtc.textonator.main.Main;
import by.epamtc.textonator.main.exception.LogicException;

public class Server {

	private static final int port = 6666;

	public static void main(String[] args) throws LogicException {
		ServerSocket serverSocket = null;
		try {
			InetAddress ia;
			ia = InetAddress.getByName("localhost");

			serverSocket = new ServerSocket(port, 0, ia);

			System.out.println("Server started\n\n");

			Socket socket = serverSocket.accept();
			System.out.println("Client accepted");

			serve(socket);

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (serverSocket != null)
				try {
					serverSocket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}

	}

	private static void serve(Socket socket) throws IOException, LogicException {

		ObjectOutputStream out = null;
		ObjectInputStream in = null;

		out = new ObjectOutputStream(socket.getOutputStream());
		in = new ObjectInputStream(socket.getInputStream());

		String filePath = null;
		
		try {
			filePath = (String) in.readObject();
			
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		System.out.println("SERVER GET PATH" + filePath);
		
		FileParsingExecutor executor = FileParsingExecutor.getInstance();
		executor.executeFileParsing();
		System.out.println("HEREEEEEEE");
		Text text = Text.getInstance();
		out.writeObject(text);
		out.flush();
		out.close();
		in.close();
	}

}
