package Tools;

import Components.JoLableIcon;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JoIconTransparent {

    public JoIconTransparent(JoLableIcon lableIcon, Color color) {
        lableIcon.setCursor(new Cursor(Cursor.HAND_CURSOR) {
        });
        lableIcon.setJoIconColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), 125));
        lableIcon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                lableIcon.setJoIconColor(new Color(color.getRed(), color.getGreen(), color.getBlue()));
                super.mouseEntered(e);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lableIcon.setJoIconColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), 125));
                super.mouseExited(e);
            }

        });
    }

}
