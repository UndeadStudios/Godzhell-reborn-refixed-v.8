import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class OptionDialogue extends Dialogue {

	private String[] lines;

	private List<Consumer<client>> consumers = new ArrayList<>();

	public OptionDialogue() {
		
	}
	
	public OptionDialogue(String option1, Consumer<client> consumer1, String option2, Consumer<client> consumer2) {
		lines = new String[] { option1, option2 };
		consumers.add(consumer1);
		consumers.add(consumer2);
	}

	public OptionDialogue(String option1, Consumer<client> consumer1, String option2, Consumer<client> consumer2,
			String option3, Consumer<client> consumer3) {
		lines = new String[] { option1, option2, option3 };
		consumers.add(consumer1);
		consumers.add(consumer2);
		consumers.add(consumer3);
	}

	public OptionDialogue(String option1, Consumer<client> consumer1, String option2, Consumer<client> consumer2,
			String option3, Consumer<client> consumer3, String option4, Consumer<client> consumer4) {
		lines = new String[] { option1, option2, option3, option4 };
		consumers.add(consumer1);
		consumers.add(consumer2);
		consumers.add(consumer3);
		consumers.add(consumer4);
	}

	public OptionDialogue(String option1, Consumer<client> consumer1, String option2, Consumer<client> consumer2,
			String option3, Consumer<client> consumer3, String option4, Consumer<client> consumer4, String option5,
			Consumer<client> consumer5) {
		lines = new String[] { option1, option2, option3, option4, option5 };
		consumers.add(consumer1);
		consumers.add(consumer2);
		consumers.add(consumer3);
		consumers.add(consumer4);
		consumers.add(consumer5);
	}

	
	
	@Override
	public void execute() {
		switch (getNext()) {
		case 0:
			DialogueManager.sendOption(getPlayer(), lines);
			break;
		default:
			Consumer<client> consumer = consumers.get(getNext() - 1);
			if (consumer != null) {
				consumer.accept(getPlayer());
			}
			setNext(-1);
			break;
		}
	}

	public void setLines(String[] lines) {
		this.lines = lines;
	}
	
	public List<Consumer<client>> getConsumers() {
		return consumers;
	}
	
	@Override
	public boolean clickButton(int id) {
		setNext(-1);
		
		switch (getOption()) {
		case 0:
			switch (id) {
			case 9157:
			case 9167:
			case 9178:
			case 9190:
				setNext(1);
				break;
			case 9158:
			case 9168:
			case 9179:
			case 9191:
				setNext(2);
				break;
			case 9169:
			case 9180:
			case 9192:
				setNext(3);
				break;
			case 9181:
			case 9193:
				setNext(4);
				break;
			case 9194:
				setNext(5);
				break;
			}
		}
		
		if (getNext() > consumers.size() && !consumers.isEmpty()) {
			setNext(-1);
		}

		if (getNext() > 0) {
			execute();
		}

		return getNext() > 0;
	}
}