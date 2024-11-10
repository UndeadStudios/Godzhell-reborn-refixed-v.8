/**
 * Arrow creating constants
 * @author Micheal
 *
 */

public enum ArrowData {
    Bronze(1, 60.5, 39, 882, false),
    BronzeDart(10, 68, 819, 806, true),
    Iron(15, 75.5, 40, 884, false),
    IronDart(22, 80, 820, 807, true),
    Steel(30, 85.5, 41, 886, false),
    SteelDart(37, 100, 821, 808, true),
    Mithril(45, 112.5, 42, 888, false),
    MithDart(52, 130, 822, 809, true),
    Adamant(60, 150.0, 43, 890, false),
    AdamDart(67, 165, 823, 810, true),
    Rune(75, 187.5, 44, 892, false),
    RuneDart(81, 204, 824, 811, true),
    Dragon(90, 210, 11237, 11212, false),
    DragDart(95, 260, 11232, 11230, true);

    private int level;
    private int arrowData, arrowType;
    private double experience;
    private boolean feather;

    private ArrowData(int level, double experience, int arrowHead, int arrowType, boolean feather) {
        this.level = level;
        this.experience = experience;
        this.arrowData = arrowHead;
        this.arrowType = arrowType;
        this.feather = feather;
    }

    public boolean requiresFeather() {
        return feather;
    }

    public int getLevelReq() {
        return level;
    }

    public double getExperience() {
        return experience;
    }

    public int getArrowData() {
        return arrowData;
    }

    public int getArrowType() {
        return arrowType;
    }

}
