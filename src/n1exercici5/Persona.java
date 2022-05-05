package n1exercici5;

import java.io.Serializable;

public class Persona implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String nom;
	public int edat;
	
	public Persona(String nom, int edat) {
		this.nom = nom;
		this.edat = edat;
	}

	public Persona() {
		
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setEdat(int edat) {
		this.edat = edat;
	}
	
	
	
}
