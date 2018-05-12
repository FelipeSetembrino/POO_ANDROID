package pt.isel.poo.tp2_poo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import pt.isel.poo.tp2_poo.model.Sketch;
import pt.isel.poo.tp2_poo.model.Pixel;
import pt.isel.poo.tp2_poo.model.Figure;
import pt.isel.poo.tp2_poo.model.Circle;
import pt.isel.poo.tp2_poo.model.Line;
import pt.isel.poo.tp2_poo.model.Rect;
import pt.isel.poo.tp2_poo.model.Point;
import pt.isel.poo.tp2_poo.view.SketchView;

/**
 * Classe responsável pela função de Controller (no modelo MVC) nesta aplicação, sendo esta mesma
 * responsável pela criação da aplicação, para além de ponto intermédio entre view e model.
 */

public class SketchController extends Activity {

    public RadioButton circle, line, pixel, rect;

    private static SketchView view;
    private static Sketch model = new Sketch();

    private static final String FILE_NAME = "Sketch.txt";

    @Override
    protected void onCreate(Bundle state) {
        super.onCreate(state);

        LinearLayout main = new LinearLayout(this);
        main.setOrientation(LinearLayout.VERTICAL);

        final LinearLayout optionButtons = new LinearLayout(this);
        optionButtons.setOrientation(LinearLayout.HORIZONTAL);

        @SuppressLint("AppCompatCustomView")
        class TxtButton extends Button implements View.OnClickListener {
            TxtButton(String txt) {
                super(SketchController.this);
                setText(txt);
                optionButtons.addView(this);
                setOnClickListener(this);
            }

            @Override
            public void onClick(View v) {
                click();
            }

            void click() {
            }

        }

        Button reset = new TxtButton("Reset") {
            @Override
            void click() {
                onReset();
            }
        };

        Button load = new TxtButton("Load") {
            @Override
            void click() {
                onLoad();
            }
        };

        Button save = new TxtButton("Save") {
            @Override
            void click() {
                onSave();
            }
        };

        main.addView(optionButtons);

        final RadioGroup selectionButtons = new RadioGroup(this);
        selectionButtons.setOrientation(LinearLayout.HORIZONTAL);

        @SuppressLint("AppCompatCustomView")
        class selectionButton extends RadioButton implements View.OnClickListener {
            selectionButton(String txt) {
                super(SketchController.this);
                setText(txt);
                selectionButtons.addView(this);
                setOnClickListener(this);
            }

            @Override
            public void onClick(View v) {
                click();
            }

            void click() {
            }

        }

        line = new selectionButton("Line");
        rect = new selectionButton("Rect");
        pixel = new selectionButton("Pixel");
        circle = new selectionButton("Circle");
        line.toggle();

        main.addView(selectionButtons);

        view = new SketchView(this);
        main.addView(view);

        setContentView(main);

    }

    private void onSave() {
        try {
            OutputStream out = openFileOutput(FILE_NAME, MODE_PRIVATE);
            model.save(out);
            Toast.makeText(this, "Saved.", Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            Toast.makeText(this, "Erro", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }

    private void onLoad() {
        try {
            InputStream in = openFileInput(FILE_NAME);
            model.load(in);
            Toast.makeText(this, "Loaded.", Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            Toast.makeText(this, "Erro.", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
        view.reload(model);
    }

    private void onReset() {
        view.clear();
        model.getList().clear();
    }

    public Figure createSelectedFigure(int x, int y) {
        if (circle.isChecked()) {
            Circle c = new Circle(x, y);
            model.add(c);
            return c;
        }
        if (line.isChecked()) {
            Line l = new Line(x, y);
            model.add(l);
            return l;
        }
        if (pixel.isChecked()) {
            Pixel p = new Pixel(x, y);
            model.add(p);
            return p;
        }
        if (rect.isChecked()) {
            Rect r = new Rect(x, y);
            model.add(r);
            return r;
        }
        return null;
    }

}
