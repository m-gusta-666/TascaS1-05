package n1exercici3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class OrdenaCarpeta {

	public static void main(String[] args) {
		
		
		File carpetaOrdenar = new File(args[0]);
		try {
			FileWriter fitxerOutput = new FileWriter(args[1]);
			escriuCarpetaRecursiu(carpetaOrdenar,fitxerOutput);
			fitxerOutput.close();
			
			
		} catch(IOException e) {
			System.out.println("Ha fallat la creacio del FileWriter");
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
