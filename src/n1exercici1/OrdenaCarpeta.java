package n1exercici1;


import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class OrdenaCarpeta {

	public static void main(String[] args) {
		
		
		File carpeta = new File(args[0]);
		File[] fitxers = carpeta.listFiles();
		Arrays.sort(fitxers, (f1,f2)->f1.compareTo(f2));
			
			
		for (File fitxer : fitxers) {
			if(!fitxer.isHidden()) {
				if(!fitxer.isDirectory()) {
					System.out.println(fitxer.getName());
				}
			}
		}
	}
}


