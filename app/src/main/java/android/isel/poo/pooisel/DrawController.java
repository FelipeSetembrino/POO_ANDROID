package android.isel.poo.pooisel;

import android.isel.poo.pooisel.modelo.model;
import android.isel.poo.pooisel.view.DrawView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class DrawController extends AppCompatActivity {

    //Adição view da tela:
    private int TX_BUTTON_SIZE = 20;
    private int TX_RADIO_SIZE = 20;
    private int figure_selected;

    model model = new model();

    //Toast t = Toast.makeText(this, "line", Toast.LENGTH_LONG); Objeto de mensagens no ecrã do phone
    //t.show();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // setup view
        LinearLayout global = new LinearLayout(this);
        LinearLayout control = new LinearLayout(this);
        LinearLayout radio_layout = new LinearLayout(this);

        //Iniciando a orientação das View
        global.setOrientation(LinearLayout.VERTICAL);
        control.setOrientation(LinearLayout.HORIZONTAL);
        radio_layout.setOrientation(LinearLayout.HORIZONTAL);

        //Crinado os butões:
        //Botão 1
        Button button1 = new Button(this);
        button1.setText("RESET");
        button1.setTextSize(TX_BUTTON_SIZE);
        //Botão 2
        Button button2 = new Button(this);
        button2.setText("LOAD");
        button2.setTextSize(TX_BUTTON_SIZE);
        //Botão 3
        Button button3 = new Button(this);
        button3.setText("SAVE");
        button3.setTextSize(TX_BUTTON_SIZE);
        //Radio Button
        RadioButton[] radio_button = new RadioButton[4];
        RadioGroup radio_group = new RadioGroup(this);
        radio_group.setOrientation(LinearLayout.HORIZONTAL);

        radio_button[0]  = new RadioButton(this);
        radio_button[0].setText("Line");
        radio_button[0].setTextSize(TX_RADIO_SIZE);
        radio_group.addView(radio_button[0]);

        radio_button[1]  = new RadioButton(this);
        radio_button[1].setText("Rect");
        radio_button[1].setTextSize(TX_RADIO_SIZE);
        radio_group.addView(radio_button[1]);

        radio_button[2]  = new RadioButton(this);
        radio_button[2].setText("Pixel");
        radio_button[2].setTextSize(TX_RADIO_SIZE);
        radio_group.addView(radio_button[2]);

        radio_button[3]  = new RadioButton(this);
        radio_button[3].setText("Circle");
        radio_button[3].setTextSize(TX_RADIO_SIZE);
        radio_group.addView(radio_button[3]);

        //Adicionando os botões no Control:
        control.addView(button1);
        control.addView(button2);
        control.addView(button3);

        //Adicionando botões radio no radio_layout
        radio_layout.addView(radio_group);

        //Adiciona a área de desenho do drawinglayout
        final DrawView draw_layout = new DrawView(this);


        //Adicionando Control no Global:
        global.addView(control);
        global.addView(radio_layout);
        global.addView(draw_layout);

        //Iniciando tela:
        setContentView(global);

        //Selecionando desenho no RadioButton
        //Line
        final DrawController controle = new DrawController();
        radio_button[0].setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                model.addFigureSelected(0);
                figure_selected = 0;
            }
        });
        //Rect
        radio_button[1].setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                model.addFigureSelected(1);
                figure_selected = 1;
            }
        });
        //Pixel
        radio_button[2].setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                model.addFigureSelected(2);
                figure_selected = 2;
            }
        });
        //Circle
        radio_button[3].setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                model.addFigureSelected(3);
                figure_selected = 3;
            }
        });

        //Executar ação quando draw_layout tocada

        draw_layout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                draw_layout.drawFigure(figure_selected, x, y);
                return false;
            }
        });

    }

}
