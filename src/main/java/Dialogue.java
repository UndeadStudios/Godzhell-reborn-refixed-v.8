
public abstract class Dialogue {

	protected int next = 0;
	protected int option;
	protected client player;

	public boolean clickButton(int id) {
		return false;
	}

	public void end() {
		next = -1;
	}

	public abstract void execute();

	public int getNext() {
		return next;
	}

	public int getOption() {
		return option;
	}

	public client getPlayer() {
		return player;
	}

	public void setNext(int next) {
		this.next = next;
	}

	public void setOption(int option) {
		this.option = option;
	}

	public void setPlayer(client player) {
		this.player = player;
	}

}
