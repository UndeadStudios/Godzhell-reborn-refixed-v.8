public enum Emotion {

    HAPPY(9850),
    HAPPY_TALK(9850),
    CALM(9830),
    CALM_CONTINUED(590),
    DEFAULT(9803),
    EVIL(592),
    EVIL_CONTINUED(593),
    DELIGHTED_EVIL(594),
    ANNOYED(9808),
    DISTRESSED(596),
    DISTRESSED_CONTINUED(597),
    DISORIENTED_LEFT(600),
    DISORIENTED_RIGHT(601),
    UNINTERESTED(602),
    SLEEPY(603),
    PLAIN_EVIL(604),
    LAUGHING(605),
    LAUGHING_2(608),
    LONGER_LAUGHING(606),
    LONGER_LAUGHING_2(607),
    EVIL_LAUGH_SHORT(609),
    SLIGHTLY_SAD(610),
    SAD(9760),
    VERY_SAD(611),
    OTHER(612),
    NEAR_TEARS(598),
    NEAR_TEARS_2(613),
    ANGRY_1(9781),
    ANGRY_2(9782),
    ANGRY_3(9783),
    ANGRY_4(9784);

	private int emoteId;

	private Emotion(int emoteId) {
		this.emoteId = emoteId;
	}

	public int getEmoteId() {
		return emoteId;
	}
}
