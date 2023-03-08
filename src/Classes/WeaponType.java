package Classes;

public enum WeaponType {
    PISTOL(1),
    KNIFE(2),
    MACHINE_GUN(3);
    private final int description;
    WeaponType(int description) {
        this.description = description;
    }
    public static WeaponType getWeaponType(int description) {
        if (description == 1) {
            return WeaponType.PISTOL;
        }
        if (description == 2) {
            return WeaponType.KNIFE;
        }
        if (description == 3) {
            return WeaponType.MACHINE_GUN;
        }
        return null;
    }
}
