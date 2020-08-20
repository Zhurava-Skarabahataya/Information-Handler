package by.epamtc.textonator.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import by.epamtc.textonator.DAO.reader.ResourceProvider;
import by.epamtc.textonator.bean.Text;
import by.epamtc.textonator.client.exception.ClientException;

public class Client {

	private static final int serverPort = 6666;
	private static final String localhost = "127.0.0.1";

	public static void main(String[] args) throws ClientException {

		Socket socket = null;

		InetAddress ipAddress;
		try {

			ipAddress = InetAddress.getByName(localhost);
			socket = new Socket(ipAddress, serverPort);

		} catch (UnknownHostException e) {
			throw new ClientException(e);
		} catch (IOException e) {
			throw new ClientException(e);

		}

		ObjectOutputStream out = null;
		ObjectInputStream in = null;

		try {
			out = new ObjectOutputStream(socket.getOutputStream());
			in = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e) {
			throw new ClientException(e);
		}

		System.out.println("The connection is on.");

		String filePath = ResourceProvider.getInstance().getFilePath();

		try {
			out.writeObject(filePath);
			out.flush();
			out.close();
		} catch (IOException e) {
			throw new ClientException(e);
		}

		Text text = null;

		try {
			text = (Text) in.readObject();
			in.close();
			socket.close();

		} catch (ClassNotFoundException | IOException e) {
			throw new ClientException(e);
		}

	}

}
