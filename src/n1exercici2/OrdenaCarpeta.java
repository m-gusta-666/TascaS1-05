package n1exercici2;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class OrdenaCarpeta {

	
	public static void main(String[] args) {
	
		imprimeixCarpetaRecursiu(new File(args[0]));
	}
	
	
	
	
	
	//############################## metodes ###################################
	
	
	
	public static void imprimeixCarpetaRecursiu(File carpeta) {
		File fitxers[] = carpeta.listFiles();
		
		
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
					System.out.println("D: " + fitxer.getName());
					imprimeixCarpetaRecursiu(fitxer);
				} else {
					System.out.println("F: " + fitxer.getName());
				}
			}
		}
	}
}
