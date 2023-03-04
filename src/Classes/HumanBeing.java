package Classes;

import java.util.Date;
import java.util.UUID;

public class HumanBeing {
    private Long id;
    private String name;
    private Coordinates coordinates;
    private java.util.Date creationDate;
    private Boolean realHero;
    private Boolean hasToothpick;
    private Integer impactSpeed;
    private WeaponType weaponType = null;
    private Mood mood;
    private Car car;

    public Long getId() {
        return id;
    }
    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("name не может быть null, Строка не может быть пустой");
        }
        else {
            this.name = name;
        }
    }
    public void setCoordinates(Coordinates coordinates) {
        if (coordinates == null) {
            throw new IllegalArgumentException("coordinates не может быть null");
        }
        else {
            this.coordinates = coordinates;
        }
    }
    public void setRealHero(Boolean realHero) {
        if (realHero == null) {
            throw new IllegalArgumentException("realHero не может быть null");
        }
        else {
            this.realHero = realHero;
        }
    }
    public void setHasToothpick(Boolean hasToothpick) {
        if (hasToothpick == null) {
            throw new IllegalArgumentException("hasToothpick не может быть null");
        }
        else {
            this.hasToothpick = hasToothpick;
        }
    }
    public void setImpactSpeed(Integer impactSpeed) {
        if (impactSpeed == null) {
            throw new IllegalArgumentException("impactSpeed не может быть null");
        }
        else {
            this.impactSpeed = impactSpeed;
        }
    }
    public void setWeaponType(WeaponType weaponType) {
        this.weaponType = weaponType;
    }
    public void setMood(Mood mood) {
        if (mood == null) {
            throw new IllegalArgumentException("mood не может быть null");
        }
        else {
            this.mood = mood;
        }
    }
    public void setCar(Car car) {
        if (car == null) {
            throw new IllegalArgumentException("car не может быть null");
        }
        else {
            this.car = car;
        }
    }
    @Override
    public String toString() {
        return String.format(Colors.GREEN + "HumanBeing:\n" + Colors.RESET +
                Colors.WHITE + "Id - " + Colors.RED + id +
                Colors.WHITE + " Name - " + Colors.RED + name +
                Colors.WHITE + " Coordinates " + Colors.RED + coordinates +
                Colors.WHITE + " Creation date - " + Colors.RED + creationDate +
                Colors.WHITE + " RealHero - " + Colors.RED + realHero +
                Colors.WHITE + " HasToothpick - " + Colors.RED + hasToothpick +
                Colors.WHITE + " ImpactSpeed = " + Colors.RED + impactSpeed +
                Colors.WHITE + " WeaponType - " + Colors.RED + weaponType +
                Colors.WHITE + " Mood - " + Colors.RED + mood +
                Colors.WHITE + " Car - " + Colors.RED + car + Colors.RESET);
    }
    public HumanBeing(String name, Coordinates coordinates, Boolean realHero, Boolean hasToothpick, Integer impactSpeed, WeaponType weaponType, Mood mood, Car car) {
        setName(name);
        setCoordinates(coordinates);
        setRealHero(realHero);
        setHasToothpick(hasToothpick);
        setImpactSpeed(impactSpeed);
        setWeaponType(weaponType);
        setMood(mood);
        setCar(car);
        creationDate = new Date();
        UUID forId = UUID.randomUUID();
        id = Math.abs(forId.getMostSignificantBits());
    }
    public String getName() {
        return name;
    }
    public Coordinates getCoordinates() {
        return coordinates;
    }
    public Boolean getRealHero() {
        return realHero;
    }
    public Boolean getHasToothpick() {
        return hasToothpick;
    }
    public Integer getImpactSpeed() {
        return impactSpeed;
    }
    public WeaponType getWeaponType() {
        return weaponType;
    }
    public Mood getMood() {
        return mood;
    }
    public Car getCar() {
        return car;
    }
}
