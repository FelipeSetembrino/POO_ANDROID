package pt.isel.poo.tp2_poo.model;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Classe responsável por provocar alterações no model (sendo que desempenha o papel
 * de Model no modelo MVC) após ações do utilizador na aplicação. Esta Classe guarda as figuras
 * numa LinkedList no momento do seu desenho, sendo que contém um campo que representa a
 * Collection das mesmas. Para além disso, acaba por ser cómodo que o processo de "guardar" e de
 * "carregar" ocorra, previamente, nesta classe, com os métodos save() e load(), respetivamente.
 */

public class Sketch implements Iterable<Figure> {

    private LinkedList<Figure> figures = new LinkedList<>();

    public Sketch() {
    }

    public void add(Figure f) {
        figures.add(f);
    }

    public void save(OutputStream out) {
        PrintWriter pw = new PrintWriter(out);
        pw.println(figures.size());
        for (Figure c : figures)
            pw.println(Character.toString(c.getLetter()) + " " + c);
        pw.close();
    }

    public void load(InputStream in) {
        Scanner s = new Scanner(in);
        int count = s.nextInt();
        s.nextLine();
        Figure f = null;
        for (; count > 0; count--) {
            String line = s.nextLine();
            switch (line.charAt(0)) {
                case 'C':
                    f = new Circle();
                    break;
                case 'L':
                    f = new Line();
                    break;
                case 'P':
                    f = new Pixel();
                    break;
                case 'R':
                    f = new Rect();
                    break;
            }
            f.fromString(line, 2);
            add(f);
        }
        s.close();
    }

    @Override
    public Iterator<Figure> iterator() {
        return figures.iterator();
    }

    public LinkedList<Figure> getList() {
        return figures;
    }
}
