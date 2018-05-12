package pt.isel.poo.tp2_poo.model;

/**
 * A Classe Point é responsável pelos métodos e campos relativos ao objeto point. Este é a
 * coordenada bi-espacial (eixo x,y) onde ocorreu a interação do utilizador com a aplicação,
 * sendo desta forma indispensável para a funcionalidade da super-classe Figure.
 */

public class Point {

    private int x;
    private int y;

    protected Point() {
    }

    protected Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    protected void set(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

    protected int fromString(String str, int idx) {
        idx += 1;
        int c = str.indexOf(',', idx);
        x = Integer.parseInt(str.substring(idx, c++));
        int p = str.indexOf(')', idx);
        y = Integer.parseInt(str.substring(c, p));
        return p;
    }

}
