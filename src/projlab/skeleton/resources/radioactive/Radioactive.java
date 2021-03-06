package projlab.skeleton.resources.radioactive;

import projlab.skeleton.map.Asteroid;
import projlab.skeleton.resources.Resource;

/**
 * A radioaktív nyersanyagokat jelképező absztrakt osztály
 */
public abstract class Radioactive extends Resource {
    /**
     * Ha az aszteroida, amiben a nyersanyag van napközeli és a nyersanyag felszínre kerül,
     * akkor a nyersanyag úgy reagál, hogy felrobbantja az aszteroidát
     *
     * @param a Az az aszteroida, amiben a nyersanyag van
     */
    @Override
    public void reaction(Asteroid a) {
        a.explode();
    }

}
