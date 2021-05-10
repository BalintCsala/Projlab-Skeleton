package projlab.skeleton.graphics;

/**
 * Kirajzolja a hátteret, a nagy aszteroidát, meghívja a szomszédok rajzolását, a nyilak rajzolását
 * Gyakorlatilag lekéri az aktív aszteroidát és a tulajdonságai alapján felépíti a pályát
 */

public abstract class GameDrawer<T> {

    /**
     * Rajzoló metódus
     * 
     * @param object kirajzolandó objektum
     * @param x koordináták
     * @param y koordináták
     * @throws Exception kivételkezelés
     */
    public abstract void draw(T object, int x, int y) throws Exception;

}
