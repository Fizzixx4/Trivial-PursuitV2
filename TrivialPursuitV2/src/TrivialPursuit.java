import java.util.Random;

public class TrivialPursuit {

	private static final int NB_CASES = 42;
	
	private Random rand = new Random();
	private Pion[] pions;
	private Case[] cases;
	
	public TrivialPursuit(Pion... pions) {
		this.pions = pions;
		this.cases = new Case[NB_CASES];
		for(int i = 0; i < NB_CASES; i++) {
			cases[i]= new Case();
		}
	}

	public void start() {
		int currentPionIndex = rand.nextInt(pions.length);
		for (int i= 0 ; i < 10; i++) {
			Pion pion = pions[currentPionIndex];
			int newPosition = pion.bouger();
			System.out.println(String.format("%s bouge case %d", pion.getNom(), newPosition));

			Case newCase = cases[newPosition];
			boolean rejoue = newCase.action();
			
			if (!rejoue) {
				currentPionIndex++;
				if (currentPionIndex >= pions.length) {
					currentPionIndex -= pions.length;
				}
			}
		}
	}
	
}
