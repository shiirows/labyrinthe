package labyrinthe;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Exercice {

	World world;
	ArrayList<String> test = new ArrayList<String>();

	Exercice(String fileName) throws IOException {

		BufferedReader reader;

		try {
			world = new World("carte.txt");
			reader = new BufferedReader(new FileReader("test1.txt"));
			String line = reader.readLine();
			while (line != null) {
				test.add(line);
				// read next line
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showTest(Hero hero) {

		for (int i = 0; i < test.size(); i++) {

			if (test.get(i).matches("N") && world.isPositionReachable(hero.getX(), hero.getY() - 1)) {
				hero.setY(hero.getY() - 1);

			} else if (test.get(i).matches("S") && world.isPositionReachable(hero.getX(), hero.getY() + 1)) {
				hero.setY(hero.getY() + 1);

			} else if (test.get(i).matches("O") && world.isPositionReachable(hero.getX() - 1, hero.getY())) {
				hero.setX(hero.getX() - 1);

			} else if (test.get(i).matches("E") && world.isPositionReachable(hero.getX() + 1, hero.getY())) {
				hero.setX(hero.getX() + 1);
			} else {
				System.out.println("point cardinnaux non définie");
			}

		}

	}
}
