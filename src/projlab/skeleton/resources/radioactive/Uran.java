package projlab.skeleton.resources.radioactive;

import projlab.skeleton.map.Asteroid;
import projlab.skeleton.utils.ObjectCatalog;
import projlab.skeleton.utils.TesterEventHandler;

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

    @Override
    public String toString() {
        return "type: Uran\n" +
                "name: " + ObjectCatalog.getName(this) + "\n" +
                "exposedCount: " + exposedCount;
    }
}
