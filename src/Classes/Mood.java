package Classes;

public enum Mood {
    SADNESS(1),
    SORROW(2),
    LONGING(3);
    private final int description;
    Mood(int description) {
        this.description = description;
    }
    public static Mood getMood(int description) {
        if (description == 1) {
            return Mood.SADNESS;
        }
        if (description == 2) {
            return Mood.SORROW;
        }
        if (description == 3) {
            return Mood.LONGING;
        }
        return null;
    }
}
