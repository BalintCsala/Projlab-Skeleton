package projlab.skeleton.resources;

import projlab.skeleton.map.Asteroid;
import projlab.skeleton.utils.ObjectCatalog;
import projlab.skeleton.utils.TesterEventHandler;

/**
 * A vízjég nyersanyagot jelképező osztály
 */
public class WaterIce extends Resource {
    /**
     * Ha az aszteroida, amiben a nyersanyag van napközeli és a nyersanyag felszínre kerül,
     * akkor a nyersanyag úgy reagál, hogy elszublimál(eltűnik)
     *
     * @param a Az az aszteroida, amiben a nyersanyag van
     */
    @Override
    public void reaction(Asteroid a) {
        a.setResource(null);
    }

    @Override
    public String toString() {
        return "type: WaterIce\n" +
                "name: " + ObjectCatalog.getName(this);
    }

}
