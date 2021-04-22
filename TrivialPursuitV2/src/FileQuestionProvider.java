import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class FileQuestionProvider {
	
	List<Question> questions = new ArrayList<Question>();
	Question questionCourante = null;
	Iterator<Question> iterator = null;
	
	public FileQuestionProvider(String fichier) throws FileNotFoundException {
		try (Scanner scanner = new Scanner(new File(fichier))) {
			while(scanner.hasNextLine()) {
				String line = scanner.nextLine();
				if(line.startsWith("Q:")) {
					line = line.replace(",","\n");
					questionCourante = new Question (line.substring(2));
					questions.add(questionCourante);
				}
				else if(line.startsWith("R:")) {
					questionCourante.addReponse(line.substring(2));
				}
			}
		}
		iterator = questions.iterator();
	}
	
	public Question getQuestion() {
		if (iterator.hasNext()) {
			questionCourante = iterator.next();
		}
		if (!iterator.hasNext()) { 
			iterator = questions.iterator(); 
		}
		return questionCourante;
	}
}