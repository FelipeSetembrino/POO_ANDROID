package pt.isel.poo.first_counter;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CounterActivity extends Activity implements ModelListener {

    // Modelo
    //private int counterValue = 0;
    private Model model = new Model();

    // Vista
    private TextView counter;
    private CircleView circleView;

    public CounterActivity() { }

    public void onChange(int newValue) {
        counter.setText(""+newValue);
        circleView.setRadius(newValue);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // setup model
        model.setListener(this);

        // setup view
        LinearLayout global = new LinearLayout(this);
        final LinearLayout control = new LinearLayout(this);
        LinearLayout files = new LinearLayout(this);

        Button inc = new Button(this);
        inc.setText(" + ");
        inc.setTextSize(30);
        Button dec = new Button(this);
        dec.setText(" - ");
        dec.setTextSize(30);
        Button reset = new Button(this);
        reset.setText(" reset ");
        reset.setTextSize(30);
        Button save = new Button(this);
        save.setText("save");
        save.setTextSize(30);
        Button load = new Button(this);
        load.setText("load");
        load.setTextSize(30);

        counter = new TextView(this);
        counter.setText("0");
        counter.setTextSize(30);

        circleView = new CircleView(this);

        // control
        control.setOrientation(LinearLayout.HORIZONTAL);
        control.addView(inc);
        control.addView(dec);
        control.addView(reset);

        // add file related buttons
        files.addView(save);
        files.addView(load);

        global.setOrientation(LinearLayout.VERTICAL);
        global.addView(control);  // linha 1
        global.addView(files);
        global.addView(counter);
        global.addView(circleView);

        // setup behaviour

        //circleView.onTouchEvent(...)

        inc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                model.inc();
            }
        });
        dec.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                model.dec();
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                model.reset();
            }
        });
        save.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                try {
                    OutputStream file =
                        openFileOutput("data.txt", MODE_PRIVATE);
                    DataOutputStream data =
                        new DataOutputStream(file);
                    data.writeInt(model.value());
                    data.close();
                } catch (IOException e) {
                    Log.e("Counter", "erro a abrir para escrita");
                }
            }
        });
        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    InputStream file = openFileInput("data.txt");
                    DataInputStream input =
                        new DataInputStream(file);
                    int value = input.readInt();
                    input.close();
                    model.set(value);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        setContentView(global);
    }
}
