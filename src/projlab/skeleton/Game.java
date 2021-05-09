package projlab.skeleton;

import projlab.skeleton.entities.Ufo;
import projlab.skeleton.map.Asteroid;
import projlab.skeleton.map.Field;
import projlab.skeleton.participants.AI;
import projlab.skeleton.participants.Participant;
import projlab.skeleton.resources.*;
import projlab.skeleton.resources.radioactive.Plutonium;
import projlab.skeleton.resources.radioactive.Uran;
import projlab.skeleton.utils.BillOfResources;

import java.util.ArrayList;
import java.util.Random;
import java.util.List;
import java.util.Random;

/**
 * A játékot eltároló objektum
 */
public class Game {

    /**
     * A játékhoz szükséges nyersanyagokat tároló objektum
     */
    private static final BillOfResources winBill = new BillOfResources();
    /**
     * A singleton design pattern instance tagváltozója
     */

    private static int effectedCount;
    private static Game instance;

    static {
        winBill.addResource(new Aluminium());
        winBill.addResource(new Coal());
        winBill.addResource(new Copper());
        winBill.addResource(new Iron());
        winBill.addResource(new Sulfur());
        winBill.addResource(new WaterIce());
        winBill.addResource(new Plutonium());
        winBill.addResource(new Uran());
    }

    /**
     * A játékpálya mezői
     */
    private final ArrayList<Field> fields = new ArrayList<>();
    /**
     * A játékban résztvevők listája
     */
    private final ArrayList<Participant> participants = new ArrayList<>();

    /**
     * Privát konstruktor a singleton design patternhez
     */
    private Game() {
    }

    /**
     * Visszaadja az osztály singleton instance-ét
     *
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
     *
     * @return Véget ért-e a játék
     */
    public boolean checkGameEnd() {
        boolean enoughresource = checkEnoughResources();
        if (!enoughresource || participants.size() == 1) {
            return true;
        }

        return false;
    }

    /**
     * Leellenőrzi, hogy van-e elég nyersanyag a játék megnyeréséhez
     *
     * @return Van-e elég nyersanyag a játék megnyeréséhez
     */
    public boolean checkEnoughResources() {
        Asteroid a = new Asteroid();
        ArrayList<Resource> b = new ArrayList<>();
        for (int i = 0; i < fields.size(); i++) {
            if (fields.get(i).getClass() == a.getClass()) {
                //b.addResource(fields.get(i).getresource());
            }

        }
        boolean enough = winBill.isCompleted(b);
        return enough;
    }

    /**
     * Lefuttat egy napkitörést a játékpályán
     */
    public void solarFlare() {
        // Menjünk végig a kellő számú mezőn és futtassunk le rajtuk egy napkitörést
        Random random = new Random();
        effectedCount = random.nextInt(fields.size());
        for (int i = 0; i < effectedCount; i++) {
            fields.get(i).solarFlare();
            GameController.solarFlareText.setText("Solar flare hit the asteroid belt");
        }
    }

    /**
     * Hozzáad egy mezőt a játékpályához
     *
     * @param field A hozzáadandó mező
     */
    public void addField(Field field) {
        fields.add(field);
    }

    /**
     * Eltávolít egy résztvevőt a játékból
     *
     * @param participant Az eltávolítandó résztvevő
     */
    public void removeParticipant(Participant participant) {
        participants.remove(participant);
    }

    /**
     * Hozzáad egy résztvevőt a játékjoz
     *
     * @param participant A hozzáadandó résztvevő
     */
    public void addParticipant(Participant participant) {
        participants.add(participant);
       
    }

    public void removeField(Field field) {
        fields.remove(field);
    }

    public void round() {
        for (Participant participant : participants) {
            if (participant.getIsPlaying()) {
                participant.round();
            }
            else {
                removeParticipant(participant);
            }
        }

        for (Field field : fields) {
            field.round();
        }
        GameController.solarFlareText.setText("");

    }

    public ArrayList<Participant> getParticipants() {
        return participants;
    }
}
