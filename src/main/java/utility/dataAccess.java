package utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class dataAccess {

	private String dataFilePath;
	private FileOutputStream outStream;
	private FileInputStream inStream;

	public dataAccess(String dataFilePath) {
		this.dataFilePath = dataFilePath;
	}

	public void saveObject(Object obj) throws IOException {
		outStream = new FileOutputStream(this.dataFilePath);
		ObjectOutputStream persister = new ObjectOutputStream(outStream);
		persister.writeObject(obj);
		persister.close();
	}

	public Object loadObject() throws IOException, ClassNotFoundException {
		inStream = new FileInputStream(this.dataFilePath);
		ObjectInputStream accesser = new ObjectInputStream(inStream);
		Object obj = accesser.readObject();
		accesser.close();
		return obj;
	}

}
