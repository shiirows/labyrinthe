package labyrinthe;

public class Hero {

	private String name;

	private int x;
	private int y;

	Hero(int x, int y, String name) {

		this.setX(x);
		this.setY(y);
		this.name = name;

	}

	public String getName() {
		return name;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}
