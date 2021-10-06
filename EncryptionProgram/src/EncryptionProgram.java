import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class EncryptionProgram {

	private Scanner scanner; // USER INPUT
	private Random random; 
	private ArrayList<Character>list; 
	private ArrayList<Character>randomizedList; 
	private char character; 
	private String line; 
	private char[] letters;
	
	
	EncryptionProgram() {
		scanner = new Scanner(System.in);
		random = new Random(); 
		 list = new ArrayList();
		 randomizedList  = new ArrayList(); 
		 character = ' '; 
		 
		 newKey(); 
		 askQuestion(); 
	}
	
	private void askQuestion() {
		// Setting up program questions 
		
		while(true) {
			System.out.println("*************************************************");
			System.out.println("What do you want to do");
			System.out.println("(N)ewKey, (G)etKey, (E)ncrypt, (D)ecrypt, (Q)uit ");
			char response = Character.toUpperCase(scanner.nextLine().charAt(0)); 
			
			
			switch (response) {
			case 'N':
				newKey();
				break;
			case 'G':
				getKey();
				break;
			case 'E':
				encrypt();
				break; 
			case 'D':
				decrypt();
				break;
			case 'Q':
				exitProgram();
				break;
			default:
				System.out.println("not a key");
					
			}
		}
		
	}
	
	private void newKey() {
		
		character = ' '+1;
		list.clear();
		randomizedList.clear();
		
		// ASCII TABLE 32 : 126
		for (int i = 32; i < 127; i++) { 
			list.add(Character.valueOf(character)); 
			character++;
		}
		
		randomizedList = new ArrayList(list); // copying the list array elements 
			
		Collections.shuffle(randomizedList); 
		System.out.println("A new Key has been generated");
		
	}
	private void getKey() {
		System.out.println("Key: ");
		
		for (Character x: list) {
			System.out.print(x);
			
		}
		
		for (Character x: randomizedList) {
			System.out.print(x);
		}
		System.out.println();
		
	}
	
	private void encrypt() {
		System.out.println("Enter message to be encrypted");
		String message = scanner.nextLine();
		
		letters = message.toCharArray();
		
		for (int i =0; i < letters.length; i++) {
			for (int j =0; j < list.size(); j++) {
				// find matching letters from the get generated key 
				if (letters[i] == list.get(j)) {
					letters[i] = randomizedList.get(j);
					break;
				}
			}
		}
		System.out.println("Encrypted: ");
		for (char x: letters) {
			System.out.print(x);
		}
		System.out.println();
		
	}
	
	private void decrypt() {
		System.out.println("Enter message to be decrypt");
		String message = scanner.nextLine();
		
		letters = message.toCharArray();
		
		for (int i =0; i < letters.length; i++) {
			for (int j =0; j < randomizedList.size(); j++) {
				// find matching letters from the get generated key 
				if (letters[i] == randomizedList.get(j)) {
					letters[i] = list.get(j);
					break;
				}
			}
		}
		System.out.println("Decrypted: ");
		for (char x: letters) {
			System.out.print(x);
		}
		System.out.println();
		
	}
	
	
	private void exitProgram() {
		System.out.println("quitting ***");
		System.exit(0);
	}

}
