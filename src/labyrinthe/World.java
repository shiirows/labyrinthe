package labyrinthe;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
public class World {

	ArrayList<String> labyrinth = new ArrayList<String>();

	String heroBlaze = "H";

	World(String fileName) throws IOException {

		BufferedReader reader;

		try {
			reader = new BufferedReader(new FileReader("carte.txt"));
			String line = reader.readLine();
			while (line != null) {
				labyrinth.add(line);
				// read next line
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showWorld(Hero hero) {

		for (int i = 0; i < labyrinth.size(); i++) {
			if (hero.getY() == i) {
				System.out.print(labyrinth.get(i).subSequence(0, hero.getX()));
				System.out.print(heroBlaze);
				System.out.println(labyrinth.get(i).subSequence(hero.getX() + 1, labyrinth.get(i).length()));

			} else {
				System.out.println(labyrinth.get(i));
			}

		}
	}

	public boolean isPositionReachable(int x, int y) {
		// permet de limiter le déplacement du hero en dehor de la carte
		if (y == -1 || y > labyrinth.size() || x == -1 || x > labyrinth.get(y).length()) {
			System.out.println("votre hero ne peux pas s'enfuire ");
			return false;
		}
		
		
        // on différencie les zones accessible
		return labyrinth.get(y).charAt(x) == ' ';

	}

}
