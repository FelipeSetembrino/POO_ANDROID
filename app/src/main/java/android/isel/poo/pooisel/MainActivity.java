package android.isel.poo.pooisel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // setup view
        LinearLayout global = new LinearLayout(this);
        LinearLayout control = new LinearLayout(this);

        //Crinado os butões:
        //Botão 1
        Button button1 = new Button(this);
        button1.setText("Button 1");
        button1.setTextSize(30);
        //Botão 2
        Button button2 = new Button(this);
        button2.setText("Button 2");
        button2.setTextSize(30);
        //Botão 3
        Button button3 = new Button(this);
        button3.setText("Button 3");
        button3.setTextSize(30);

        //Iniciando a orientação das View
        global.setOrientation(LinearLayout.VERTICAL);
        control.setOrientation(LinearLayout.HORIZONTAL);

        


    }
}
