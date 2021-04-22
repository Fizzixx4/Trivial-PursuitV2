import java.io.FileNotFoundException;
import java.util.Random;

public class TrivialPursuit {
	
	private Random rand = new Random();
	private Pion[] pions;
	private Case[] cases;
	
	private Case[] loadCases() throws FileNotFoundException {
		CaseQuestion caseHistoire = new CaseQuestion(new FileQuestionProvider("C:\\Users\\gkoch\\eclipse-workspace\\TrivialPursuitV2\\src\\QuestionsHistoire.txt"));
		CaseQuestion caseSciences = new CaseQuestion(new FileQuestionProvider("C:\\Users\\gkoch\\eclipse-workspace\\TrivialPursuitV2\\src\\QuestionsSciences.txt"));
		CaseQuestion caseGeographie = new CaseQuestion(new FileQuestionProvider("C:\\Users\\gkoch\\eclipse-workspace\\TrivialPursuitV2\\src\\QuestionsGeographie.txt"));
		CaseQuestion caseLitterature = new CaseQuestion(new FileQuestionProvider("C:\\Users\\gkoch\\eclipse-workspace\\TrivialPursuitV2\\src\\QuestionsLitterature.txt"));
		CaseQuestion caseDivertissement = new CaseQuestion(new FileQuestionProvider("C:\\Users\\gkoch\\eclipse-workspace\\TrivialPursuitV2\\src\\QuestionsDivertissement.txt"));
		CaseQuestion caseSport = new CaseQuestion(new FileQuestionProvider("C:\\Users\\gkoch\\eclipse-workspace\\TrivialPursuitV2\\src\\QuestionsSport.txt"));
		CaseRejouer caseRejouer = new CaseRejouer();
		return new Case[] {
				caseGeographie, caseRejouer, caseLitterature, caseSport, caseRejouer, caseDivertissement, caseSciences,
				caseDivertissement, caseRejouer, caseGeographie, caseHistoire, caseRejouer, caseSport, caseLitterature,
				caseSport, caseRejouer, caseDivertissement, caseSciences, caseRejouer, caseHistoire, caseGeographie,
				caseHistoire, caseRejouer, caseSport, caseLitterature, caseRejouer, caseSciences, caseDivertissement,
				caseSciences, caseRejouer, caseHistoire, caseGeographie, caseRejouer, caseLitterature, caseSport,
				caseLitterature, caseRejouer, caseSciences, caseDivertissement, caseRejouer, caseGeographie, caseHistoire
		};
	}
	
	public TrivialPursuit(Pion... pions) throws FileNotFoundException {
		this.pions = pions;
		this.cases = this.loadCases();
	}

	public void start() {
		int currentPionIndex = rand.nextInt(pions.length);
		for (int i= 0 ; i < 50; i++) {
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
