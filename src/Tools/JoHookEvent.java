package Tools;

import java.awt.Component;

public class JoHookEvent {

    private final Object hookSource;

    public JoHookEvent(Object hookSource) {
        this.hookSource = hookSource;
    }

    public boolean isEvent(Component com) {
        if (hookSource != null) {
            return hookSource == com;
        } else {
            return false;
        }
    }

}