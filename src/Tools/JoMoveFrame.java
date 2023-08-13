package Tools;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class JoMoveFrame {

    int X = 0, Y = 0;

    public void Move(JDialog dialog) {

    }

    public void Move(JDialog dialog, JComponent comMove) {
        comMove.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                X = me.getX();
                Y = me.getY();
                super.mousePressed(me);
            }
        });
        comMove.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent me) {
                dialog.setLocation(me.getXOnScreen() - X, me.getYOnScreen() - Y);
                super.mouseDragged(me);
            }
        });
    }

    public void Move(JFrame dialog) {

    }

    public void Move(JFrame dialog, JComponent comMove) {
        comMove.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                X = me.getX();
                Y = me.getY();
                super.mousePressed(me);
            }
        });
        comMove.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent me) {
                dialog.setLocation(me.getXOnScreen() - X, me.getYOnScreen() - Y);
                super.mouseDragged(me);
            }
        });
    }
}
