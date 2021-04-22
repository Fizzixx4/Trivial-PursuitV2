import java.util.Scanner;

public class Question {
	
	String enonce;
	String reponseCorrecte;
	
	public Question() {}
	
	public Question(String enonce) {
		this.enonce = enonce;
	}
	
	public void addReponse (String reponse) {
		this.reponseCorrecte = reponse;
	}

	private final Scanner sc = new Scanner(System.in);
	
	public boolean demande() {
		System.out.println(this.enonce);
		String response = sc.nextLine();
		return this.reponseCorrecte.equalsIgnoreCase(response);
	}
}