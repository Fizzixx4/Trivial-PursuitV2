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
			int indexQuestion = 0;
			
			while(scanner.hasNextLine())
			{
				String line = scanner.nextLine();
				if(line.startsWith("Q:")) {
					Question question = new Question ();
					questions.add(question);
					line = line.replace(",","\n");
				  	questions.get(indexQuestion).enonce = line.substring(2);
				}
				else if(line.startsWith("R:")) {
					 questions.get(indexQuestion).reponseCorrecte = line.substring(2);
					 indexQuestion++;
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