package pt.isel.poo.first_counter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;

public class CircleView extends View {

    private static final int INITIAL_RADIUS = 20;
    private int MARGIN=10;

    public CircleView(Context context) {
        super(context);
    }

    private Paint border = new Paint();
    private Paint defaultPaint = new Paint();
    @Override
    protected void onDraw(Canvas canvas) {
        border.setColor(Color.LTGRAY);
        canvas.drawRect(
            0,0,
            canvas.getWidth(), canvas.getHeight(),
            border
        );
        canvas.drawCircle(
           canvas.getWidth()/2,
           canvas.getHeight()/2,
           radius,
           defaultPaint
        );
    }

    private int radius=INITIAL_RADIUS;

    /*
    public void addToRadius(int delta) {
        Log.i("CircleView", "+" + delta);
        radius += delta;
        // invalida a vista e pede ao Android
        // para redesenhar
        invalidate();
    }

    public void resetRadius() {
        radius = 20;
        invalidate();
    }

    public void resetRadius(int counterValue) {
        radius = counterValue*20+20;
        invalidate();
    }*/

    public void setRadius(int radius) {
        this.radius = INITIAL_RADIUS+radius*MARGIN;
        invalidate();
    }
}
