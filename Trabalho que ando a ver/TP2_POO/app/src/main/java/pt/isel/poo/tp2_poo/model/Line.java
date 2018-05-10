package pt.isel.poo.tp2_poo.model;

/**
 * Classe Line, derivada de Figure, é responsável pelos objetos Line,
 * sendo que dispõe de campos e metodos relacionados com o mesmo (para além
 * dos métodos de Figure aqui redefinidos).
 */

public class Line extends Figure {

    private final static char LETTER = 'L';

    Point end;

    Line() {

    }

    public Line(int x, int y) {
        super(x, y);
        end = new Point(x, y);
    }

    @Override
    char getLetter() {
        return LETTER;
    }

    @Override
    public void setEnd(int x, int y) {
        end.set(x, y);
    }

    @Override
    public String toString() {
        return super.toString() + " " + end.toString();
    }

    @Override
    protected int fromString(String str, int idx) {
        idx = super.fromString(str, idx) + 2;
        end = new Point();
        return end.fromString(str, idx);
    }

    public Point getEnd() {
        return end;
    }

}
