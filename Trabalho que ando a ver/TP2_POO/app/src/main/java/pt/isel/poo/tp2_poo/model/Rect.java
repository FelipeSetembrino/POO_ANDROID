package pt.isel.poo.tp2_poo.model;

/**
 * Classe Rect, derivada de Line, é responsável pelos objetos Rect,
 * sendo que dispõe de campos e metodos relacionados com o mesmo (para além
 * dos métodos de Line aqui redefinidos).
 */

public class Rect extends Line {

    private final static char LETTER = 'R';

    Rect() {

    }

    public Rect(int x, int y) {
        super(x, y);
    }

    @Override
    char getLetter() {
        return LETTER;
    }

    @Override
    public void setEnd(int x, int y) {
        end.set(x, y);
    }

}
