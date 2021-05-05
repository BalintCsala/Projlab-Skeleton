package projlab.skeleton.resources;

import projlab.skeleton.utils.ObjectCatalog;
import projlab.skeleton.utils.TesterEventHandler;

/**
 * A kén nyersanyagot jelképező osztály
 */
public class Sulfur extends Resource {

    @Override
    public String toString() {
        return "type: Sulfur\n" +
                "name: " + ObjectCatalog.getName(this);
    }
}
