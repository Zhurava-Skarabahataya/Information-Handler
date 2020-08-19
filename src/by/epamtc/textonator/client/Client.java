package by.epamtc.textonator.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import by.epamtc.textonator.DAO.TextDAOImpl;
import by.epamtc.textonator.DAO.exception.DAOException;
import by.epamtc.textonator.DAO.reader.ResourceProvider;
import by.epamtc.textonator.bean.Text;
import by.epamtc.textonator.logic.FileParsingExecutor;
import by.epamtc.textonator.main.exception.LogicException;

public class Client {

	private static final int serverPort = 6666;
	private static final String localhost = "127.0.0.1";
	
	public static void main(String[] args) throws LogicException, DAOException, IOException {
		
		Socket socket = null;
		
		InetAddress ipAddress;
		try {
			
			ipAddress = InetAddress.getByName(localhost);
			socket = new Socket(ipAddress, serverPort);
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		ObjectOutputStream out = null;
		ObjectInputStream in = null;
		
		try {
			out = new ObjectOutputStream(socket.getOutputStream());
			in = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
			
		System.out.println("The connection is on.");
		
		String filePath = ResourceProvider.getInstance().getFilePath();
		
		try {
			out.writeObject(filePath);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Text text = null;
		
		try {
			text = (Text) in.readObject();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		out.close();

	}

}
