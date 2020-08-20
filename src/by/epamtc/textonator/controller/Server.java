package by.epamtc.textonator.controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import by.epamtc.textonator.bean.Text;
import by.epamtc.textonator.controller.exception.ControllerException;
import by.epamtc.textonator.logic.FileParsingExecutor;
import by.epamtc.textonator.main.exception.LogicException;

public class Server {

	private static final int port = 6666;

	public static void main(String[] args) throws ControllerException {
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
			throw new ControllerException(e);
		} catch (IOException e) {
			throw new ControllerException(e);
		} finally {
			if (serverSocket != null)
				try {
					serverSocket.close();
				} catch (IOException e) {
					throw new ControllerException(e);
				}
		}

	}

	private static void serve(Socket socket) throws ControllerException {

		ObjectOutputStream out = null;
		ObjectInputStream in = null;

		try {
			out = new ObjectOutputStream(socket.getOutputStream());
			in = new ObjectInputStream(socket.getInputStream());
			
		} catch (IOException e1) {
			throw new ControllerException(e1);
		}

		String filePath = null;

		try {
			filePath = (String) in.readObject();

		} catch (ClassNotFoundException | IOException e) {
			throw new ControllerException(e);
			
		} finally {
			
			try {
				in.close();
			} catch (IOException e) {
				throw new ControllerException(e);
			}
		}

		FileParsingExecutor executor = FileParsingExecutor.getInstance();

		try {
			executor.executeFileParsing();
		} catch (LogicException e) {
			throw new ControllerException(e);
		}

		Text text = Text.getInstance();

		try {
			out.writeObject(text);
			out.flush();
			out.close();
			
		} catch (IOException e) {
			throw new ControllerException(e);
		}
	}

}
