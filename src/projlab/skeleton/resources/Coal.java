package projlab.skeleton.resources;

import projlab.skeleton.utils.ObjectCatalog;
import projlab.skeleton.utils.TesterEventHandler;

/**
 * A szén nyersanyagot jelképező osztály
 */
public class Coal extends Resource {

    @Override
    public String toString() {
        return "type: Coal\n" +
                "name: " + ObjectCatalog.getName(this);
    }
}
