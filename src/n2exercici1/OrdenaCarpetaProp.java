package n2exercici1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Properties;

public class OrdenaCarpetaProp {

	public static void main(String[] args) {
		
		//Creem un fitxer .properties
		try (OutputStream fitxerConfig = new FileOutputStream("fitxerConfig.properties")){
			
			Properties prop = new Properties();
			
			//Assignem els parametres
			prop.setProperty("DirectoriLlegir", "C:\\Users\\marti\\Documents\\UNIVERSITAT");
			prop.setProperty("CamiFitxerOutput","fitxerOutput.txt");
			
			//Guardem els parametres al fitxer .properties
			prop.store(fitxerConfig, null);
			
		} catch(IOException e) {
			System.out.println("Error al crear el fitxer de configuracio");
			e.printStackTrace();
		}
		
		
		
		//llegim el fitxer properties i cridem els mètodes a partir dels paràmetres 
		
		try (InputStream input = new FileInputStream("fitxerConfig.properties")) {
			
			Properties prop = new Properties();
			prop.load(input);
			File carpetaOrdenar = new File(prop.getProperty("DirectoriLlegir"));
			
			FileWriter fitxerOutput = new FileWriter(prop.getProperty("CamiFitxerOutput"));
			escriuCarpetaRecursiu(carpetaOrdenar,fitxerOutput);
			fitxerOutput.close();
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		
		System.out.println("No hi ha hagut cap excepcio");
		
	}
	
	
	
	
	
	//############################## metodes ###################################
	

	
	public static void escriuCarpetaRecursiu(File carpetaOrdenar, FileWriter fitxerOutput) {
		File fitxers[] = carpetaOrdenar.listFiles();
		
		
		Arrays.sort(fitxers, (f1, f2) -> {
			int i=0;
	         if (f1.isDirectory() && !f2.isDirectory()) {
	            i = -1;
	         } else if (!f1.isDirectory() && f2.isDirectory()) {
	            i = 1;
	         } else {
	            i = f1.compareTo(f2);
	         }
	         return i;
	      });
		
		
		for (File fitxer : fitxers) {
			if(!fitxer.isHidden()) {
				if(fitxer.isDirectory()) {
					try {
						escriureFitxer("D: " + fitxer.getName() + "\r\n", fitxerOutput);
					} catch(IOException e) {
						System.out.println("Ha fallat l'escriptura d'algun nom de directori");
						e.printStackTrace();
					}
					escriuCarpetaRecursiu(fitxer,fitxerOutput);
					
				} else {
					try {
						escriureFitxer("F: " + fitxer.getName() + "\r\n", fitxerOutput);
					} catch(IOException e) {
						System.out.println("Ha fallat l'escriptura d'algun nom de fitxer");
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	static void escriureFitxer(String frase, FileWriter out) throws IOException {
		
		for(int i=0 ; i<frase.length() ; i++) {
			out.write(frase.charAt(i));
		}
	}

}
