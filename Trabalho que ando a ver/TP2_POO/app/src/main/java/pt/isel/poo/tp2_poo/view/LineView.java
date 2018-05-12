package pt.isel.poo.tp2_poo.view;

import android.graphics.Canvas;

import pt.isel.poo.tp2_poo.model.Figure;
import pt.isel.poo.tp2_poo.model.Line;

/**
 * A Classe LineView, derivada de FigureView, é responsável
 * pela representação visual dos objetos do tipo Line.
 */

public class LineView extends FigureView {

    LineView(Figure f) {
        super(f);
    }

    @Override
    void draw(Canvas c) {
        Line line = (Line) getFigure();
        c.drawLine(line.getStart().getX(), line.getStart().getY(), line.getEnd().getX(), line.getEnd().getY(), paint);
    }

}
