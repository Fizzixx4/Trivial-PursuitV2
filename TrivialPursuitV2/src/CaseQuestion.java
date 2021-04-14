import java.util.Scanner;

public class CaseQuestion implements Case{
	
	private final FileQuestionProvider provider;
	
	public CaseQuestion(FileQuestionProvider provider) {
		this.provider = provider;
	}
	
	public boolean action() {
		boolean isReponseCorrecte = provider.getQuestion().demande();
		return isReponseCorrecte; 
	}
}
