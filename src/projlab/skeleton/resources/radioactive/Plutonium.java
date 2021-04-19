package projlab.skeleton.resources.radioactive;

import projlab.skeleton.utils.ObjectCatalog;
import projlab.skeleton.utils.TesterEventHandler;

/**
 * A plutónium nyersanyagot jelképező osztály
 */
public class Plutonium extends Radioactive {

    @Override
    public String toString() {
        return "type: Plutonium\n" +
                "name: " + ObjectCatalog.getName(this);
    }
}
