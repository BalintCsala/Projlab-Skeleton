package projlab.skeleton.resources.radioactive;

import projlab.skeleton.map.Asteroid;

/**
 * Az urán nyersanyagot jelképező osztály
 */
public class Uran extends Radioactive {

    /**
     * Napnak kitett alkalmak száma
     */
    private int exposedCount = 0;

    /**
     * Beálltítja a napnak kitett alkalmak számát
     * 
     * @param exposedCount a napnak kitett alkalmak száma
     */
    public void setExposedCount(int exposedCount) {
        this.exposedCount = exposedCount;
    }

    /**
     * Reakció metódus
     */
    public void reaction(Asteroid a) {
        exposedCount++;
        if (exposedCount >= 3) {
            super.reaction(a);
        }
    }
}
