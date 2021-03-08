import java.util.Random;

public class Pion {
	
	private Random rand = new Random();
	private String nom;
	private int position;

	public Pion(String nom) {
		this.nom = nom;	
		this.position = 0;
	}

	public String getNom() {
		return nom;
	}
	
	public int bouger() {
		this.position += rand.nextInt(6)+1;
		if(this.position > 41) {
			this.position -= 42;
		}
		return this.position;
	}

}
