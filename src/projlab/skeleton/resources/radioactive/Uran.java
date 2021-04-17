package projlab.skeleton.resources.radioactive;

import projlab.skeleton.map.Asteroid;

/**
 * Az urán nyersanyagot jelképező osztály
 */
public class Uran extends Radioactive {
    
    private int exposedCount = 0;

    public void setExposedCount(int exposedCount) {
        this.exposedCount = exposedCount;
    }

    public void reaction(Asteroid a) {
        if (exposedCount >= 3) {
            this.reaction(a);
        }
    }
}
