package android.isel.poo.pooisel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    //Adição view da tela:
    private int TX_BUTTON_SIZE = 20;

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
        button1.setText("Button 1");
        button1.setTextSize(TX_BUTTON_SIZE);
        //Botão 2
        Button button2 = new Button(this);
        button2.setText("Button 2");
        button2.setTextSize(TX_BUTTON_SIZE);
        //Botão 3
        Button button3 = new Button(this);
        button3.setText("Button 3");
        button3.setTextSize(TX_BUTTON_SIZE);
        //Radio Button
        RadioButton radio_button = new RadioButton(this);
        radio_button.setText("Radio Button 1");
        radio_button.setTextSize(TX_BUTTON_SIZE);
            //Exemplo Radio Button
            /*
            private void createRadioButton() {
            final RadioButton[] rb = new RadioButton[5];
            RadioGroup rg = new RadioGroup(this); //create the RadioGroup
            rg.setOrientation(RadioGroup.HORIZONTAL);//or RadioGroup.VERTICAL
            for(int i=0; i<5; i++){
               rb[i]  = new RadioButton(this);          
               rb[i].setText(" " + ContactsActivity.phonetype.get(i)
                    + "    " + ContactsActivity.phone.get(i));
               rb[i].setId(i + 100);
               rg.addView(rb[i]);
            }
            ll.addView(rg);//you add the whole RadioGroup to the layout

            }
            */


        //Adicionando os botões no Control:
        control.addView(button1);
        control.addView(button2);
        control.addView(button3);

        //Adicionando botões radio no radio_layout
        radio_layout.addView(radio_button);

        //Adicionando Control no Global:
        global.addView(control);
        global.addView(radio_layout);

        //Iniciando tela:
        setContentView(global);


    }
}
