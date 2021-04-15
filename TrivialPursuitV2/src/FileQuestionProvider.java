import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class FileQuestionProvider {
	
	private Random rand = new Random();
	List<Question> questions = new ArrayList();
	  
	
	public FileQuestionProvider(String fichier) {
		try
		{
			FileInputStream fichierQuestions = new FileInputStream(fichier);   
			Scanner scanner = new Scanner(fichierQuestions);  
			Question questionCourante = null;
			
			while(scanner.hasNextLine())
			{
				String line = scanner.nextLine();
				if(line.startsWith("Q:")) {
					line = line.replace(",","\n");
					questionCourante = new Question (line.substring(2));
					questions.add(questionCourante);
				}
				else if(line.startsWith("R:")) {
					questionCourante.addReponse(line.substring(2));
				}
				else {
					continue;
				}
			}
	    }
		    catch(IOException e)
		    {
		      e.printStackTrace();
		    }
	}

	public Question getQuestion() {
		int indexAleatoire = rand.nextInt(questions.size());
		return questions.get(indexAleatoire);
	}
}