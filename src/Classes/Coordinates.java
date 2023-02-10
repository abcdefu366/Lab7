package Classes;

public class Coordinates {
    private long x;
    private long y;

    public void setX(long x) {
        if (x > 357) {
            throw new IllegalArgumentException("Максимальное значение x: 357");
        }
        else {
            this.x = x;
        }
    }
    public void setY(long y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Координаты: x = " + x + ", y = " + y;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Coordinates)) return false;
        Coordinates other = (Coordinates) o;
        return (other.x == x && other.y == y);
    }
    public Coordinates(long x, long y) {
        setX(x);
        setY(y);
    }
}
