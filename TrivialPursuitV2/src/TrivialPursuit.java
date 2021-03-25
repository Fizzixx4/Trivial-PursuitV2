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
			if(i%2==0) {
				cases[i]= new CaseQuestion(new FileQuestionProvider("C:\\questions.txt"));//*
			} else {
				cases[i]= new CaseRejouer();
			}
		}
	}

	public void start() {
		int currentPionIndex = rand.nextInt(pions.length);
		for (int i= 0 ; i < 15; i++) {
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
