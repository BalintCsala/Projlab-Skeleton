package projlab.skeleton.utils;

import java.util.HashMap;

public class TesterEventHandler {

    private TesterEventHandler() {}

    public static final HashMap<TesterEventDescription, TesterEventListener> listeners = new HashMap<>();

    public static void registerListener(String[] description, TesterEventListener listener) {
        registerListener(description, description.length, listener);
    }

    public static void registerListener(String[] description, int minLength, TesterEventListener listener) {
        listeners.put(new TesterEventDescription(description, minLength), listener);
    }

    public static void fireEvent(TesterEvent event) {
        for (TesterEventDescription description : listeners.keySet()) {
            if (event.matches(description)) {
                listeners.get(description).accept(event.cmd);
            }
        }
    }

}
