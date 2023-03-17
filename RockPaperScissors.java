package Ejercicio_5;
import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {
	Scanner scan = new Scanner(System.in);
	Random random = new Random();
	private String[] options = {"rock", "paper", "scissors"};
	private String choice;
	private String selected;
	private boolean win;
	
	public RockPaperScissors() {
		select();
	}
	
	private void select() {
		choice = options[random.nextInt(3)];
		System.out.println();
		System.out.println("Rock | Paper | Scissors");
		System.out.print("Select an option: ");
		selected = scan.next().toLowerCase();
		play();
	}
	
	private void play() {
		if(selected.equals("rock") && choice.equals("paper")) {
			System.out.println("GAME OVER");
			win = false;
		} else if(selected.equals("rock") && choice.equals("scissors")) {
			System.out.println("YOU WIN!");
			win =  true;
		} else if(selected.equals("paper") && choice.equals("rock")) {
			System.out.println("YOU WIN!");
			win = true;
		} else if(selected.equals("paper") && choice.equals("scissors")) {
			System.out.println("GAME OVER");
			win = false;
		} else if(selected.equals("scissors") && choice.equals("rock")) {
			System.out.println("GAME OVER");
			win = false;
		} else if(selected.equals("scissors") && choice.equals("paper")) {
			System.out.println("YOU WIN!");
			win = true;
		} else {
			System.out.println("TIE");
			select();
		}
	}
	
	public boolean getResult() {
		return win;
	}
}
