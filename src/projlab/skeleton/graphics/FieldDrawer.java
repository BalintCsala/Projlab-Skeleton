package projlab.skeleton.graphics;

/**
 * absztrakt ősosztály a teleporthoz, illetve a aszteroidához
 */
public abstract class FieldDrawer extends GameDrawer {
    public abstract void draw(int x, int y, boolean nearSun) ;
}
