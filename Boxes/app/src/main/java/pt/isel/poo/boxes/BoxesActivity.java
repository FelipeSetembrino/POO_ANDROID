package pt.isel.poo.boxes;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;


/**
 * Acts as the "Controller" for the application in the MVC division standard.
 */
public class BoxesActivity extends Activity {
    private static final String[] KEYS = {"HIGHSCORE","NAME","POINTS","POSITIONS","HEIGHT",
            "WIDTH","LEVEL"};
    private static final String FILE_NAME = "HighScores.txt";
    TextView topScore;
    TextView currScore;
    Board view;
    Boxes model;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        model = new Boxes();

        model.setListener(new Boxes.Listener() {
                              @Override
                              public void onPointsChanged(int points) {
                                  model.setPoints(points);
                                  currScore.setText("Points: " + model.getPoints());
                              }

                              @Override
                              public void onHighscoreChanged(int points) {
                                  changeHighscore(points);
                              }
        });

        loadHighScore();

        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);

        topScore = new TextView(this);
        topScore.setText("Top points: "+ model.getHighscore()+ " by "+ model.getName());
        topScore.setTextSize(25);
        topScore.setGravity(Gravity.CENTER);

        currScore = new TextView(this);
        currScore.setText("Points: " + model.getPoints());
        currScore.setTextSize(30);
        currScore.setGravity(Gravity.CENTER);

        view = new Board(this, model);

        setContentView(root);
        root.addView(topScore);
        root.addView(currScore);
        root.addView(view);

    }

    private void changeHighscore(int points){
        final int point = points;
        final EditText edit = new EditText(this);
        edit.setHint("your name");
        edit.setSingleLine();

                 new AlertDialog.Builder(this,AlertDialog.THEME_HOLO_LIGHT)
                .setCancelable(false) //forcing the user to submit a name
                .setTitle("New top score")
                .setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        model.setName(edit.getText().toString());
                        model.setHighscore(point);
                        topScore.setText("Top points: "+ model.getHighscore()+ " by "+ model.getName());
                    }
                })
                .setView(edit).show();
    }

    @Override
    protected void onRestoreInstanceState(Bundle state) {
       int highscore = state.getInt(KEYS[0]);
       String name = state.getString(KEYS[1]);
       int points = state.getInt(KEYS[2]);
       int [] positions = state.getIntArray(KEYS[3]);
       int height = state.getInt(KEYS[4]);
       int width = state.getInt(KEYS[5]);
       int level = state.getInt(KEYS[6]);
        model.setHighscore(highscore);
        model.setName(name);
        model.createGrid(height,width,level,points);
        topScore.setText("Top points: "+ model.getHighscore()+ " by "+ model.getName());
        currScore.setText("Points: " + model.getPoints());
        model.loadPositions(positions);
        super.onRestoreInstanceState(state);
    }

    @Override
    protected void onSaveInstanceState(Bundle state) {
        super.onSaveInstanceState(state);
        state.putInt(KEYS[0],model.getHighscore());
        state.putString(KEYS[1],model.getName());
        state.putInt(KEYS[2],model.getPoints());
        state.putInt(KEYS[4],model.getBoardHeight());
        state.putInt(KEYS[5],model.getBoardWidth());
        state.putInt(KEYS[6],model.getLevel());
        model.savePositions();
        state.putIntArray(KEYS[3],model.getPosition());
        saveHighscore();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        saveHighscore();
    }

    private void saveHighscore()  {
        try {
            OutputStream out = openFileOutput(FILE_NAME, MODE_PRIVATE);
            PrintWriter pw = new PrintWriter(out);
            pw.println(model.getName());
            pw.print(model.getHighscore());
            pw.close();
        } catch(FileNotFoundException  e) {
            e.getMessage();
        }
    }



    private void loadHighScore(){
        try{
            InputStream in = openFileInput(FILE_NAME);
            Scanner sc = new Scanner(in);
            String name = sc.nextLine();
            model.setName(name);
            int highscore = sc.nextInt();
            model.setHighscore(highscore);
            sc.close();
        } catch (FileNotFoundException e) {
            Toast.makeText(BoxesActivity.this,"Error loading top",Toast.LENGTH_SHORT).show();
        }
    }
}
