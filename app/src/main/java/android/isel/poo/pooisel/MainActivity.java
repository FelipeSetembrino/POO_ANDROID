package android.isel.poo.pooisel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Adição view da tela:
    private int TX_BUTTON_SIZE = 20;
    private int TX_RADIO_SIZE = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // setup view
        LinearLayout global = new LinearLayout(this);
        LinearLayout control = new LinearLayout(this);
        LinearLayout radio_layout = new LinearLayout(this);
        LinearLayout drawing_layout = new LinearLayout(this);

        //Iniciando a orientação das View
        global.setOrientation(LinearLayout.VERTICAL);
        control.setOrientation(LinearLayout.HORIZONTAL);
        radio_layout.setOrientation(LinearLayout.HORIZONTAL);
        drawing_layout.setOrientation(LinearLayout.HORIZONTAL);

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

        //Adicionando Control no Global:
        global.addView(control);
        global.addView(radio_layout);
        global.addView(drawing_layout);

        //Iniciando tela:
        setContentView(global);

        //Selecionando desenho no RadioButton
        radio_button[0].setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Log.e("Line", "Line clicked");
            }
        });

        radio_button[1].setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Log.e("Rect", "Rect clicked");
            }
        });

        radio_button[2].setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Log.e("Pixel", "Pixel clicked");
            }
        });

        radio_button[3].setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Log.e("Circle", "Circle clicked");
            }
        });

    }
}
