package pt.isel.poo.tp2_poo.model;

/**
 * Super-classe abstrata de todos os objetos derivados de Figure. Nesta classe localizam-se métodos
 * e campos comuns a todas as subclasses de Figure. É de realçar também a existência de métodos
 * relativos às funcionalidades de "guardar" e "carregar" da aplicação, presentes aqui e
 * redefinidos em (quase) todas as classes derivadas.
 */

public abstract class Figure {

    private Point start;

    Figure() {

    }

    Figure(int x, int y) {
        start = new Point(x, y);
    }

    char getLetter() {
        return ' ';
    }

    public Point getStart() {
        return start;
    }

    public abstract void setEnd(int x, int y);

    @Override
    public String toString() {
        return start.toString();
    }

    protected int fromString(String str, int idx) {
        start = new Point();
        start.fromString(str, idx);
        return start.fromString(str, idx);
    }

}