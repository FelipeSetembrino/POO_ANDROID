package pt.isel.poo.tp2_poo.model;

/**
 * Classe Circle, derivada de Figure, é responsável pelos objetos Circle,
 * sendo que dispõe de campos e metodos relacionados com o mesmo (para além
 * dos métodos de Figure aqui redefinidos).
 */

public class Circle extends Figure {

    private final static char LETTER = 'C';

    private int radius;

    Circle() {

    }

    public Circle(int x, int y) {
        super(x, y);
    }

    @Override
    char getLetter() {
        return LETTER;
    }

    @Override
    public void setEnd(int x, int y) {
        radius = (int) Math.sqrt(Math.pow(getStart().getX() - x, 2) + Math.pow(getStart().getY() - y, 2));
    }

    @Override
    public String toString() {
        return super.toString() + " |" + radius + "|";
    }

    @Override
    protected int fromString(String str, int idx) {
        idx = super.fromString(str, idx);
        int e = str.indexOf('|', idx + 1);
        int f = str.indexOf('|', e + 1);
        radius = Integer.parseInt(str.substring(e + 1, f));
        return e;
    }

    public int getRadius() {
        return radius;
    }

}
