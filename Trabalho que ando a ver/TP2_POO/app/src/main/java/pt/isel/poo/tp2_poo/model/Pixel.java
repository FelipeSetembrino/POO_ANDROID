package pt.isel.poo.tp2_poo.model;

/**
 * Classe Pixel, derivada de Figure, é responsável pelos objetos Pixel,
 * sendo que dispõe de campos e metodos relacionados com o mesmo (para além
 * dos métodos de Figure aqui redefinidos).
 */

public class Pixel extends Figure {

    private final static char LETTER = 'P';

    Pixel() {

    }

    public Pixel(int x, int y) {
        super(x, y);
    }

    @Override
    char getLetter() {
        return LETTER;
    }

    @Override
    public void setEnd(int x, int y) {
        getStart().set(x, y);
    }

}
