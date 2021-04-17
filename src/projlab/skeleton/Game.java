package projlab.skeleton;

import projlab.skeleton.map.Field;
import projlab.skeleton.participants.Participant;
import projlab.skeleton.utils.BillOfResources;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * A játékot eltároló objektum
 */
public class Game {

    /**
     * A singleton design pattern instance tagváltozója
     */
    private static Game instance;
    /**
     * A játékpálya mezői
     */
    private final ArrayList<Field> fields = new ArrayList<>();
    /**
     * A játékban résztvevők listája
     */
    private final ArrayList<Participant> participants = new ArrayList<>();
    public int effectedCount;
    /**
     * A játékhoz szükséges nyersanyagokat tároló objektum
     */
    private BillOfResources winBill;

    /**
     * Privát konstruktor a singleton design patternhez
     */
    private Game() {
    }

    /**
     * Visszaadja az osztály singleton instance-ét
     * @return Az osztály singleton instance-e
     */
    public static Game getInstance() {
        if (instance == null)
            instance = new Game();
        return instance;
    }

    /**
     * Elindítja a játékot, egyelőre semmit nem csinál
     */
    public void startGame() {
    }

    /**
     * Befejezi a játékot, egyelőre semmit nem csinál
     */
    public void endGame() {
    }

    /**
     * Leellenőrzi, hogy a játék véget ért-e
     * @return Véget ért-e a játék
     */
    public boolean checkGameEnd() {
        boolean end = new Scanner(System.in).next().equals("I");
        return end;
    }

    /**
     * Leellenőrzi, hogy van-e elég nyersanyag a játék megnyeréséhez
     * @return Van-e elég nyersanyag a játék megnyeréséhez
     */
    public boolean checkEnoughResources() {
        boolean enough = new Scanner(System.in).next().equals("I");
        return enough;
    }

    /**
     * Lefuttat egy napkitörést a játékpályán
     */
    public void solarFlare() {
        // Menjünk végig az összes mezőn és futtassunk le rajtuk egy napkitörést
        for (Field field : fields) {
            field.solarFlare();
        }
    }

    /**
     * Hozzáad egy mezőt a játékpályához
     * @param field A hozzáadandó metódus
     */
    public void addField(Field field) {
        fields.add(field);
    }

    /**
     * Eltávolít egy résztvevőt a játékból
     * @param participant Az eltávolítandó résztvevő
     */
    public void removeParticipant(Participant participant) {
        participants.remove(participant);
    }

    /**
     * Hozzáad egy résztvevőt a játékjoz
     * @param participant A hozzáadandó résztvevő
     */
    public void addParticipant(Participant participant) {
        participants.add(participant);
    }

}
