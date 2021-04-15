import java.util.Scanner;

public class Question {
	
	String enonce;
	String reponseCorrecte;
	
	public Question() {}
	
	public Question(String enonce,String reponseCorrecte) {
		this.enonce = enonce;
		this.reponseCorrecte = reponseCorrecte;
	}

	private final Scanner sc = new Scanner(System.in);
	
	public boolean demande() {
		System.out.println(this.enonce);
		String response = sc.nextLine();
		return this.reponseCorrecte.equalsIgnoreCase(response);
	}

}