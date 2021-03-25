import java.util.List;

public class FileQuestionProvider {

	List<Question> questions; // Rempli depuis le fichier
	
	public FileQuestionProvider(String file) {
		// TODO Auto-generated constructor stub
	}

	public Question getQuestion() {
		// Question random
		return questions.get(0);
	}

}
