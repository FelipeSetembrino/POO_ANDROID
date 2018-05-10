package pt.isel.poo.tp2_poo.view;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

import java.util.LinkedList;

import pt.isel.poo.tp2_poo.SketchController;
import pt.isel.poo.tp2_poo.model.Circle;
import pt.isel.poo.tp2_poo.model.Figure;
import pt.isel.poo.tp2_poo.model.Line;
import pt.isel.poo.tp2_poo.model.Pixel;
import pt.isel.poo.tp2_poo.model.Rect;
import pt.isel.poo.tp2_poo.model.Sketch;

/**
 * Classe responsável pela interação entre utilizador e aplicação, sendo que desempenha o papel de
 * View (no model MVC). Através da mesma são registadas as ações do utilizador e também a
 * re-pintura do view aquando de alterações no model da aplicação.
 */

public class SketchView extends View {

    private static Paint paint = new Paint();

    private LinkedList<FigureView> views = new LinkedList<>();

    private SketchController ctrl;

    static {
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);
    }

    public SketchView(SketchController ctrl) {
        super(ctrl);
        this.ctrl = ctrl;
    }

    private FigureView createView(Figure f) {
        if (f instanceof Circle) {
            return new CircleView(f);
        }
        if (f instanceof Line) {
            if (f instanceof Rect) {
                return new RectView(f);
            }
            return new LineView(f);
        }
        if (f instanceof Pixel) {
            return new PixelView(f);
        }
        return null;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        android.graphics.Rect drawArea = new android.graphics.Rect(5, 5, getWidth() - 5, getHeight() - 5);
        canvas.drawRect(0, 0, getWidth(), getHeight(), paint);
        canvas.clipRect(drawArea);
        for (FigureView fv : views) {
            fv.draw(canvas);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                Figure f = ctrl.createSelectedFigure((int) event.getX(), (int) event.getY());
                FigureView fv = createView(f);
                views.add(fv);
                invalidate();
                return true;
            case MotionEvent.ACTION_MOVE:
                views.getLast().getFigure().setEnd((int) event.getX(), (int) event.getY());
                invalidate();
                return true;
            case MotionEvent.ACTION_UP:
                return true;
        }
        return super.onTouchEvent(event);
    }

    public void clear() {
        views.clear();
        invalidate();
    }

    public void reload(Sketch model) {
        for (Figure f : model) {
            views.add(createView(f));
        }
        invalidate();
    }

}
