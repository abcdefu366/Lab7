package Classes;

import static java.lang.Long.valueOf;

public class Coordinates {
    private Long x;
    private Long y;
    public void setX(Long x) {
        if (x == null) {
            throw new IllegalArgumentException("Координата по x не может быть null");
        }
        else {
            if (x > 357) {
                throw new IllegalArgumentException("Максимальное значение x: 357");
            } else {
                this.x = x;
            }
        }
    }
    public void setY(Long y) {
        if (y == null) {
            throw new IllegalArgumentException("Координата по y не может быть null");
        }
        else {
            this.y = y;
        }
    }

    @Override
    public String toString() {
        return "Координаты: x = " + x + ", y = " + y;
    }
    public Coordinates(Long x, Long y) {
        setX(x);
        setY(y);
    }
    public Long getX() {
        return x;
    }
    public Long getY() {
        return y;
    }
}
