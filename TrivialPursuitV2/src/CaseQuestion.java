
public class CaseQuestion implements Case{
	
	private final FileQuestionProvider provider;
	
	public CaseQuestion(FileQuestionProvider provider) {
		this.provider = provider;
	}
	
	public boolean action() {
		boolean isReponseCorrecte = provider.getQuestion().demande();
		if(isReponseCorrecte) {
			System.out.println("Correct!");
		}
		else {
			System.out.println("Mauvaise réponse, c'est au tour du prochain joueur");
		}
		return isReponseCorrecte; 
	}
}