package pt.isel.poo.tp2_poo.view;

import android.graphics.Canvas;

import pt.isel.poo.tp2_poo.model.Figure;
import pt.isel.poo.tp2_poo.model.Pixel;

/**
 * A Classe PixelView, derivada de FigureView, é responsável
 * pela representação visual dos objetos do tipo Pixel.
 */

public class PixelView extends FigureView {

    PixelView(Figure f) {
        super(f);
    }

    @Override
    void draw(Canvas c) {
        Pixel pixel = (Pixel) getFigure();
        c.drawCircle(pixel.getStart().getX(), pixel.getStart().getY(), 2, paint);

    }

}
