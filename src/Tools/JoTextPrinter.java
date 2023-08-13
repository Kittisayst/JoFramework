package Tools;

import java.awt.Color;
import java.awt.Font;
import java.awt.print.PrinterException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class JoTextPrinter {

    private final JTextPane textPane;
    private Font font = new Font("Phetsarath OT", 0, 12);
    private Document text;

    public JoTextPrinter() {
        textPane = new JTextPane();
        textPane.setFont(font);
        text = textPane.getStyledDocument();
    }

    public void Print() {
        try {
            textPane.print();
        } catch (PrinterException ex) {
            Logger.getLogger(JoTextPrinter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addText(String value, SimpleAttributeSet attributeSet) {
        try {
            text.insertString(text.getLength(), value, attributeSet);
        } catch (BadLocationException ex) {
            Logger.getLogger(JoTextPrinter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addTextCustom(String value, SimpleAttributeSet attributeSet, StyleConstants constants) {
        try {
            text.insertString(text.getLength(), value, attributeSet);
        } catch (BadLocationException ex) {
            Logger.getLogger(JoTextPrinter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addText(String value, FontStyle style) {
        SimpleAttributeSet attributeSet;
        try {
            switch (style) {
                case Bold:
                    attributeSet = newStyle();
                    StyleConstants.setBold(attributeSet, true);
                    text.insertString(text.getLength(), value, attributeSet);
                    break;
                case Italic:
                    attributeSet = newStyle();
                    StyleConstants.setItalic(attributeSet, true);
                    text.insertString(text.getLength(), value, attributeSet);
                    break;
                case Underline:
                    attributeSet = newStyle();
                    StyleConstants.setUnderline(attributeSet, true);
                    text.insertString(text.getLength(), value, attributeSet);
                    break;
            }
        } catch (BadLocationException ex) {
            Logger.getLogger(JoTextPrinter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addText(String value, Color color) {
        SimpleAttributeSet attributeSet;
        try {
            attributeSet = newStyle();
            StyleConstants.setForeground(attributeSet, color);
            text.insertString(text.getLength(), value, attributeSet);
        } catch (BadLocationException ex) {
            Logger.getLogger(JoTextPrinter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addText(String value, int Size) {
        SimpleAttributeSet attributeSet;
        try {
            attributeSet = newStyle();
            StyleConstants.setFontSize(attributeSet, Size);
            text.insertString(text.getLength(), value, attributeSet);
        } catch (BadLocationException ex) {
            Logger.getLogger(JoTextPrinter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public SimpleAttributeSet newStyle() {
        return new SimpleAttributeSet();
    }

    public enum FontStyle {
        Bold,
        Italic,
        Underline
    }

    public int getTextCount() {
        return text.getLength();
    }

    public Font getFont() {
        return font;
    }

    public void setFont(Font font) {
        this.font = font;
    }

    public Document getText() {
        return text;
    }

    public void setText(Document text) {
        this.text = text;
    }

}
