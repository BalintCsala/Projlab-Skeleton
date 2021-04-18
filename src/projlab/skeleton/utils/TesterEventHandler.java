package projlab.skeleton.utils;

import java.util.HashMap;

public class TesterEventHandler {

    private TesterEventHandler() {}

    public static final HashMap<String[], TesterEventListener> listeners = new HashMap<>();

    public static void registerListener(String[] description, TesterEventListener listener) {
        listeners.put(description, listener);
    }

    public static void fireEvent(TesterEvent event) {
        for (String[] description : listeners.keySet()) {
            if (event.matches(description)) {
                listeners.get(description).accept(event.cmd);
            }
        }
    }

}
