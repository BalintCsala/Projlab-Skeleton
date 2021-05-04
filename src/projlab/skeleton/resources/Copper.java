package projlab.skeleton.resources;

import projlab.skeleton.utils.ObjectCatalog;
import projlab.skeleton.utils.TesterEventHandler;

/**
 * A réz nyersanyagot jelképező osztály
 */
public class Copper extends Resource {

    @Override
    public String toString() {
        return "type: Copper\n" +
                "name: " + ObjectCatalog.getName(this);
    }


}
