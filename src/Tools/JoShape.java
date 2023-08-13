package Tools;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics2D;

public class JoShape {

    public void Arrow(Component com, Graphics2D g2) {
        int space = 10;
        int x1 = 200 / 2;
        int y1 = 200 / 2;
        int x2 = 200;
        int y2 = 200 / 2;
        //========= >
        g2.setColor(Color.WHITE);
        //drawLine(int x1, int y1, int x2, int y2)
        g2.drawLine(space, 75, 50, y2);

        g2.drawLine(space, 125, 50, y2);
    }

}
