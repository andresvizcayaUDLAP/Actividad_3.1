package Ejercicio_5;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

public class Menu {
	private Scanner scan;
	private int wins, losses;
	private int option;
	private String name;
	
	public Menu() {
		scan = new Scanner(System.in);
		wins = 0;
		mainMenu();
	}
	
	private void mainMenu() {
		System.out.print("Write your name: ");
		name = scan.next();
		do {
			System.out.println("1. Play");
			System.out.println("2. Exit");
			System.out.print("Choose an option: ");
			option = Integer.parseInt(scan.next());	
			switch(option) {
			case 1: play(); break;
			case 2: statistics(); break; 
			default: System.out.println("Choose a valid option"); break;
			}
		} while(option!=3);
	}
	
	private void play() {
		RockPaperScissors game = new RockPaperScissors();
		if(game.getResult()) {
			wins++;
		} else {
			losses++;
		}
	}
	
	private void statistics() {
		System.out.println("Score: " + wins);
		File file = new File(name + ".data");
		if(file.exists()) {
			Path fileName = Path.of(file.getPath());
			try {
				read(fileName);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				System.out.println("Generating statistics");
				create();
			} catch (IOException e) {
	            e.printStackTrace();
	        }
		}
		
	}
	
	private void create() throws IOException {
		PrintWriter writer = new PrintWriter(name + ".data");
		writer.println("Wins: " + wins);
		writer.println("Losses: " + losses);
		writer.close();
	}
	
	private void read(Path fileName) throws IOException {
		String str = Files.readString(fileName);
		try {
			write(str.split("\n"));
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private void write(String[] str) throws IOException {
		String winsString = str[0].split(" ")[1];
		String lossesString = str[0].split(" ")[1];
		int winsBefore = Integer.parseInt(winsString.split("")[0]);
		int lossesBefore = Integer.parseInt(lossesString.split("")[0]);
		PrintWriter writer = new PrintWriter(name + ".data");
		writer.println("Wins: " + wins + winsBefore);
		writer.println("Losses: " + losses + lossesBefore);
		writer.close();
	}
}
