package projlab.skeleton.resources;

import projlab.skeleton.utils.ObjectCatalog;
import projlab.skeleton.utils.TesterEventHandler;

/**
 * Az alumínium nyersanyagot jelképező osztály
 */
public class Aluminium extends Resource {

    @Override
    public String toString() {
        return "type: Aluminium\n" +
                "name: " + ObjectCatalog.getName(this);
    }
}
