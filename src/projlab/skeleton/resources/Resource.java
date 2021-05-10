package projlab.skeleton.resources;

import projlab.skeleton.graphics.Drawable;
import projlab.skeleton.graphics.ResourceDrawer;
import projlab.skeleton.map.Asteroid;

/**
 * A nyersanyagokat jelképező absztrakt osztály
 */
public abstract class Resource {

    /**
     * A nyersanyag drawere
     */
    private ResourceDrawer resourceDrawer=new ResourceDrawer();

    /**
     * A napközeli aszteroidán felszínre kerülő nyersanyag reakcióját feldolgozó metódus
     *
     * @param a Az az aszteroida, amiben a nyersanyag van
     */
    public void reaction(Asteroid a) {
    }
}
