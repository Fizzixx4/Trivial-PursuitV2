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
			
			while(scanner.hasNextLine())
			{
			  String line = scanner.nextLine();
			  if(line.startsWith("E:")) {
				  line = line.replace(",","\n");
				  Question question = new Question (line.substring(2,line.length()-2),line.substring(line.length()-1));
				  questions.add(question);
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