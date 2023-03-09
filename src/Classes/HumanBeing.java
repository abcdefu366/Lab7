package Classes;

import java.util.Comparator;
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
        if (name == null || name.equals("")) {
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
        return String.format(Colors.GREEN + "HumanBeing:" + Colors.RESET + "\n" +
                Colors.WHITE + "Id - " + Colors.RED + id + "\n" +
                Colors.WHITE + " Name - " + Colors.RED + name + "\n" +
                Colors.WHITE + " Coordinates " + Colors.RED + coordinates + "\n" +
                Colors.WHITE + " Creation date - " + Colors.RED + creationDate + "\n" +
                Colors.WHITE + " RealHero - " + Colors.RED + realHero + "\n" +
                Colors.WHITE + " HasToothpick - " + Colors.RED + hasToothpick + "\n" +
                Colors.WHITE + " ImpactSpeed = " + Colors.RED + impactSpeed + "\n" +
                Colors.WHITE + " WeaponType - " + Colors.RED + weaponType + "\n" +
                Colors.WHITE + " Mood - " + Colors.RED + mood + "\n" +
                Colors.WHITE + " Car - " + Colors.RED + car + Colors.RESET + "\n");
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

    public class SortByName implements Comparator {
        @Override
        public int compare(Object o1, Object o2) {
            HumanBeing humanBeingOne = (HumanBeing) o1;
            HumanBeing humanBeingTwo = (HumanBeing) o2;
            return humanBeingOne.getName().compareTo(humanBeingTwo.getName());
        }
    }
    public static class SortById implements Comparator {
        @Override
        public int compare(Object o1, Object o2) {
            HumanBeing humanBeingOne = (HumanBeing) o1;
            HumanBeing humanBeingTwo = (HumanBeing) o2;
            return humanBeingOne.getId().compareTo(humanBeingTwo.getId());
        }
    }
    public static class SortByX_Coordinate implements Comparator {
        @Override
        public int compare(Object o1, Object o2) {
            HumanBeing humanBeingOne = (HumanBeing) o1;
            HumanBeing humanBeingTwo = (HumanBeing) o2;
            return humanBeingOne.getCoordinates().getX().compareTo(humanBeingTwo.getCoordinates().getX());
        }
    }
    public static class SortByY_Coordinate implements Comparator {
        @Override
        public int compare(Object o1, Object o2) {
            HumanBeing humanBeingOne = (HumanBeing) o1;
            HumanBeing humanBeingTwo = (HumanBeing) o2;
            return humanBeingOne.getCoordinates().getY().compareTo(humanBeingTwo.getCoordinates().getY());
        }
    }
    public static class SortByRealHero implements Comparator {
        @Override
        public int compare(Object o1, Object o2) {
            HumanBeing humanBeingOne = (HumanBeing) o1;
            HumanBeing humanBeingTwo = (HumanBeing) o2;
            return humanBeingOne.getRealHero().compareTo(humanBeingTwo.getRealHero());
        }
    }
    public static class SortByHasToothpick implements Comparator {
        @Override
        public int compare(Object o1, Object o2) {
            HumanBeing humanBeingOne = (HumanBeing) o1;
            HumanBeing humanBeingTwo = (HumanBeing) o2;
            return humanBeingOne.getHasToothpick().compareTo(humanBeingTwo.getHasToothpick());
        }
    }
    public static class SortByImpactSpeed implements Comparator {
        @Override
        public int compare(Object o1, Object o2) {
            HumanBeing humanBeingOne = (HumanBeing) o1;
            HumanBeing humanBeingTwo = (HumanBeing) o2;
            return humanBeingOne.getImpactSpeed().compareTo(humanBeingTwo.getImpactSpeed());
        }
    }
    public static class SortByWeaponType implements Comparator {
        @Override
        public int compare(Object o1, Object o2) {
            HumanBeing humanBeingOne = (HumanBeing) o1;
            HumanBeing humanBeingTwo = (HumanBeing) o2;
            return humanBeingOne.getWeaponType().compareTo(humanBeingTwo.getWeaponType());
        }
    }
    public static class SortByMood implements Comparator {
        @Override
        public int compare(Object o1, Object o2) {
            HumanBeing humanBeingOne = (HumanBeing) o1;
            HumanBeing humanBeingTwo = (HumanBeing) o2;
            return humanBeingOne.getMood().compareTo(humanBeingTwo.getMood());
        }
    }
    public static class SortByCar implements Comparator {
        @Override
        public int compare(Object o1, Object o2) {
            HumanBeing humanBeingOne = (HumanBeing) o1;
            HumanBeing humanBeingTwo = (HumanBeing) o2;
            return humanBeingOne.getCar().getCool().compareTo(humanBeingTwo.getCar().getCool());
        }
    }
}
