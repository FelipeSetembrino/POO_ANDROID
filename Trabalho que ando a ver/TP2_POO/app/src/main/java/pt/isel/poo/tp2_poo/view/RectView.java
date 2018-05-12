package pt.isel.poo.tp2_poo.view;

import android.graphics.Canvas;

import pt.isel.poo.tp2_poo.model.Figure;
import pt.isel.poo.tp2_poo.model.Rect;

/**
 * A Classe RectView, derivada de FigureView,  e responsável
 * pela representação visual dos objetos do tipo Rect.
 */

public class RectView extends FigureView {

    RectView(Figure f) {
        super(f);
    }

    @Override
    void draw(Canvas c) {
        Rect rect = (Rect) getFigure();
        c.drawRect(rect.getStart().getX(), rect.getStart().getY(), rect.getEnd().getX(), rect.getEnd().getY(), paint);
    }


}
