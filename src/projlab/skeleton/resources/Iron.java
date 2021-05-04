package projlab.skeleton.resources;

import projlab.skeleton.utils.ObjectCatalog;
import projlab.skeleton.utils.TesterEventHandler;

/**
 * A vas nyersanyagot jelképező osztály
 */
public class Iron extends Resource {

    @Override
    public String toString() {
        return "type: Iron\n" +
                "name: " + ObjectCatalog.getName(this);
    }

}
