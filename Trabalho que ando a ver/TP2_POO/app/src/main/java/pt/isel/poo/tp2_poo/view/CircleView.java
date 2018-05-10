package pt.isel.poo.tp2_poo.view;

import android.graphics.Canvas;

import pt.isel.poo.tp2_poo.model.Circle;
import pt.isel.poo.tp2_poo.model.Figure;

/**
 * A Classe CircleView, derivada de FigureView, é responsável
 * pela representação visual dos objetos do tipo Circle.
 */

public class CircleView extends FigureView {

    CircleView(Figure f) {
        super(f);
    }

    @Override
    void draw(Canvas c) {
        Circle circle = (Circle) getFigure();
        c.drawCircle(circle.getStart().getX(), circle.getStart().getY(), circle.getRadius(), paint);
    }

}
