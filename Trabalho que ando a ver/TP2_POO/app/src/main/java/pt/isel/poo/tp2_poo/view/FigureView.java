package pt.isel.poo.tp2_poo.view;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import pt.isel.poo.tp2_poo.model.Figure;

/**
 * A super-classe abstrata FigureView é responsável por ter métodos/campos
 * comuns a todos os objectos derivados de FigureView.
 */

public abstract class FigureView {

    protected Figure elem;

    protected static Paint paint = new Paint();

    static {
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(3);
    }

    FigureView(Figure f) {
        elem = f;
    }

    Figure getFigure() {
        return elem;
    }

    abstract void draw(Canvas c);

}
