package n1exercici5;

import java.io.*;

public class SerialitzaFitxer {

	public static void main(String[] args) {
		
		
		try {
			Persona p = new Persona("Pepito Grillo",45);
			Persona p2 = (Persona) serialitzaDeserialitza(p);
			if(p.edat==p2.edat && p.nom.equals(p2.nom)) {
				System.out.println("El fitxer s'ha serialitzat i desserialitzat de forma correcta");
			}
		} catch(ClassNotFoundException e) {
			System.out.println("Error en trobar classe");
			e.printStackTrace();
		} catch(IOException e) {
			System.out.println("Error IO");
			e.printStackTrace();
		}
		
		
		

	}

	
	//############################## metodes ##############################
	
	
	
	public static Object serialitzaDeserialitza(Object obj) throws IOException, ClassNotFoundException {
		Object obj2 = null;
		if (obj==null) {
			System.out.println("Aquest objecte es null");
		} else {
			 FileOutputStream fileOutputStream
		      = new FileOutputStream("personaSerialitzada.ser");
		    ObjectOutputStream objectOutputStream 
		      = new ObjectOutputStream(fileOutputStream);
		    objectOutputStream.writeObject(obj);
		    objectOutputStream.flush();
		    objectOutputStream.close();
		    
		    FileInputStream fileInputStream
		      = new FileInputStream("personaSerialitzada.ser");
		    ObjectInputStream objectInputStream
		      = new ObjectInputStream(fileInputStream);
		    obj2 = objectInputStream.readObject();
		    objectInputStream.close();
		    
		}
		return obj2;
	}
}
