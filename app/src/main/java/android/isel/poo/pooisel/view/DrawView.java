package android.isel.poo.pooisel.view;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import android.widget.Switch;

/**
 * Created by felip on 09/05/2018.
 */

public class DrawView extends View {

    public DrawView(Context context) {
        super(context);
    }

    private Paint border = new Paint();
    @Override
    protected void onDraw(Canvas canvas) {
        border.setColor(Color.rgb(152, 251, 152));
        canvas.drawRect(
                0, 0,
                canvas.getWidth(), canvas.getHeight(),
                border
        );
    }

    public void drawFigure(int figure_selected){
        switch (figure_selected){
            case 0: break;
            case 1: break;
            case 2: break;
            case 3: break;
        }
    }

    public void reloadModel (){
    }

}
