package n1exercici4;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class LecturaFitxer {

	public static void main(String[] args) {
		
		llegirFitxer(args[0]);
	
	}	
		
	//################################## metodes #####################################
	
	
	static void llegirFitxer(String nomFitxer) {
		
		FileInputStream fitxer = null;
		BufferedReader br = null;
		String linea = null;
		
		try {
			
			fitxer = new FileInputStream(nomFitxer);
			br = new BufferedReader(new InputStreamReader(fitxer));
			linea = br.readLine();
			
			while(linea!=null) {
				System.out.println(linea);
				linea = br.readLine();
			}
			
		} catch(FileNotFoundException e) {
			System.out.println("No s'ha trobat el fitxer");
		} catch (IOException e) {
			System.out.println("IOException!!!!");
		}
	}
	
}
