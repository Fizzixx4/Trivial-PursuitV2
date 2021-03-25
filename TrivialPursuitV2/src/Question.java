import java.util.Scanner;

public class Question {

	private final Scanner sc = new Scanner(System.in);
	
	public boolean demande() {
		System.out.println("Question: o/n");
		String response = sc.nextLine();
		return "o".equalsIgnoreCase(response);
	}

}
