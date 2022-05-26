package labyrinthe;

import java.io.IOException;
import java.util.Scanner;

public class Game {
	static Hero hero = new Hero(3, 0, "Toto");
	static World world;
	static Exercice exercice;
		static Exercice2 exercice2;
	
	public static void main(String[] args) {

		
		

		Scanner userInput = new Scanner(System.in);

		try {
			world = new World("carte.txt");
			exercice = new Exercice("test1.txt");
			exercice2 = new Exercice2("test2.txt");

			System.out.println("Bienvenue a toi guerrier " + hero.getName());

			do {

				world.showWorld(hero);
				System.out.println(hero.getName() + " se situe en: " + "X " + hero.getX() + " ,Y " + hero.getY());
				System.out.println("Selectionne un point cardinaux pour te déplacer dans ce labyrinth");
				System.out.println("Touche N pour NORD");
				System.out.println("Touche S pour SUD");
				System.out.println("Touche O pour OUEST");
				System.out.println("Touche E pour EST");
				System.out.println("Touche A pour effectuer le test 1");
				System.out.println("Touche B pour effectuer le test 2");

				String response = userInput.nextLine();

				moveHero(response);

			} while (hero.getX() != 9 || hero.getY() != 2);

			System.out.println("bravo");
			System.out.println("Votre hero se situe en: " + "X " + hero.getX() + " ,Y " + hero.getY());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void moveHero(String key) {
		switch (key) {
		case "n":

			if (world.isPositionReachable(hero.getX(), hero.getY() - 1)) {
				hero.setY(hero.getY() - 1);

			} else {
				System.out.println("position non atteignable");
			} 

			break;

		case "s":
			if (world.isPositionReachable(hero.getX(), hero.getY() + 1)) {
				hero.setY(hero.getY() + 1);
			} else {
				System.out.println("position non atteignable");
			}

			break;

		case "o":
			if (world.isPositionReachable(hero.getX() - 1, hero.getY())) {
				hero.setX(hero.getX() - 1);
			} else {
				System.out.println("position non atteignable");
			}

			break;

		case "e":
			if (world.isPositionReachable(hero.getX() + 1, hero.getY())) {
				hero.setX(hero.getX() + 1);
			} else {
				System.out.println("position non atteignable");
			}

			break;

		case "a":

			exercice.showTest(hero);
			world.showWorld(hero);

			break;

		case "b":

			exercice2.showTest(hero);

			break;

		default:
			System.out.println("commande non reconnue ");

			break;
		}
	}

}
