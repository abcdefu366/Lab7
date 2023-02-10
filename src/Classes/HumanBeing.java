package Classes;

import java.util.Date;

public class HumanBeing {
    private Integer id;
    private String name;
    private Coordinates coordinates;
    private java.util.Date creationDate;
    private Boolean realHero;
    private Boolean hasToothpick;
    private Integer impactSpeed;
    private WeaponType weaponType = null;
    private Mood mood;
    private Car car;

    public void setId(Integer id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("id не может быть null, Значение id должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически");
        }
        else {
            this.id = id;
        }
    }
    public void setName(String name) {
        if (name.equals(null)) {
            throw new IllegalArgumentException("name не может быть null, Строка не может быть пустой");
        }
        else {
            this.name = name;
        }
    }
    public void setCoordinates(Coordinates coordinates) {
        Coordinates coordinates1 = new Coordinates(0, 0);
        if (coordinates.equals(coordinates1)) {
            throw new IllegalArgumentException("coordinates не может быть null");
        }
        else {
            this.coordinates = coordinates;
        }
    }

    public void setCreationDate(Date creationDate) {
        if (creationDate == null) {
            throw new IllegalArgumentException("creationDate не может быть null, Значение этого поля должно генерироваться автоматически");
        }
        else {
            this.creationDate =   creationDate;
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
    public HumanBeing(Integer id, String name, Coordinates coordinates, Date creationDate, Boolean realHero, Boolean hasToothpick, Integer impactSpeed, WeaponType weaponType, Mood mood, Car car) {
        setId(id);
        setName(name);
        setCoordinates(coordinates);
        setCreationDate(creationDate);
        setRealHero(realHero);
        setHasToothpick(hasToothpick);
        setWeaponType(weaponType);
        setMood(mood);
        setCar(car);
    }
}
