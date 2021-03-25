

public class Main {

	public static void main(String[] args) {
		Pion pion1 = new Pion("Thibaut");
		Pion pion2 = new Pion("Grégory");
		Pion pion3 = new Pion("Cassandra");
		TrivialPursuit game = new TrivialPursuit(pion1, pion2, pion3);
		game.start();
		
	}	

}
