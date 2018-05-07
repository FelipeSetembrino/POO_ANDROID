package pt.isel.poo.boxes;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

/**
 * Acts as the "View" for the application in the MVC division standard.
 */
public class Board extends View {

    public static Boxes model;
    private static final Paint paint = new Paint();

    static {
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.FILL);
    }

    public Board(Context context, Boxes model) {
        super(context);
        this.model = model;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int boxHeight = getHeight() / model.getBoardHeight();
        int boxWidth = getWidth() / model.getBoardWidth();
        for (int l = 0; l < model.getBoardHeight(); l++) {
            for (int c = 0; c < model.getBoardWidth(); c++) {
                if (!model.isInvisible(l, c)) {
                    canvas.drawRect(c * boxWidth, l * boxHeight, (c + 1) * boxWidth, (l + 1) * boxHeight, paint);
                }
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            int x = (int) event.getX();
            int y = (int) event.getY();
            model.touch(yToGrid(y), xToGrid(x));
            postInvalidateDelayed(0);
        }
        return false;
    }

    private int xToGrid(int x) {
        return x / (getWidth() / model.getBoardWidth());
    }

    private int yToGrid(int y) {
        return y / (getHeight() / model.getBoardHeight());
    }

}
