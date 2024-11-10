import java.util.Optional;

public class Skilling {

    client player;

    private Optional<Skill> skill = Optional.empty();

    public Skilling(client player) {
        this.player = player;
    }

    public void add(Event event, int ticks) {
        EventManager.getSingleton().addEvent(player,event, ticks);
    }

    public void stop() {
        EventManager.getSingleton().stopEvents(player);
        skill = Optional.empty();
    }

    public boolean isSkilling() {
        return skill.isPresent();
    }

    public Skill getSkill() {
        return skill.orElse(null);
    }

    public void setSkill(Skill skill) {
        this.skill = Optional.of(skill);
    }

}
