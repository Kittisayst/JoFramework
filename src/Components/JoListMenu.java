package Components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JPanel;
import theme.JoTheme;

public class JoListMenu extends JPanel {

    public JoListMenu() {
        initcomponent();
    }

    @Override
    protected void paintComponent(Graphics g) {
        setOpaque(false);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        int x = 0, y = 0, w = getWidth(), h = getHeight(), ax = 10, ay = 10;
        g2.setColor(getBackground());
        g2.fill(new RoundRectangle2D.Float(x, y, w, h, ax, ay));
        super.paintComponent(g);
    }

    private void initcomponent() {
        setLayout(new FlowLayout());
        Dimension defaultSize = new Dimension(150, 45);
        setPreferredSize(defaultSize);
        setBackground(JoTheme.Primary);
        JoButton btn = new JoButton();
        btn.setText("OKs");
        btn.setPreferredSize(defaultSize);
        JoButton btn2 = new JoButton();
        btn2.setPreferredSize(defaultSize);
        btn2.setText("OK2s");
        add(btn);
        add(btn2);
        setPreferredSize(new Dimension(getPreferredSize().getSize().width, defaultSize.getSize().height * getComponentCount()));
    }

}
