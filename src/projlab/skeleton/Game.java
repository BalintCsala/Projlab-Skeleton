package projlab.skeleton;

import projlab.skeleton.entities.Settler;
import projlab.skeleton.entities.Ufo;
import projlab.skeleton.graphics.*;
import projlab.skeleton.map.Asteroid;
import projlab.skeleton.map.Field;
import projlab.skeleton.participants.AI;
import projlab.skeleton.participants.Participant;
import projlab.skeleton.participants.Player;
import projlab.skeleton.resources.*;
import projlab.skeleton.resources.radioactive.Plutonium;
import projlab.skeleton.resources.radioactive.Uran;
import projlab.skeleton.utils.BillOfResources;

import java.util.ArrayList;
import java.util.Collections;
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
     * A singleton design pattern instance tagváltozójac
     */

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
    private final ArrayList<Player> players = new ArrayList<>();


    private int currentPlayer = -1;

    public static final AsteroidDrawer asteroidDrawer = new AsteroidDrawer();
    public static final NeighborAsteroidDrawer neighborAsteroidDrawer = new NeighborAsteroidDrawer();
    public static final NeighborTeleportDrawer neighborTeleportDrawer = new NeighborTeleportDrawer();
    public static final ResourceDrawer resourceDrawer = new ResourceDrawer();
    public static final TeleportDrawer teleportDrawer = new TeleportDrawer();
    public static final PlayerDrawer playerDrawer = new PlayerDrawer();
    public static final RobotDrawer robotDrawer = new RobotDrawer();
    public static final SettlerDrawer settlerDrawer = new SettlerDrawer();
    public static final UfoDrawer ufoDrawer = new UfoDrawer();

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
        // lista az előforduló nyersanyagoknak
        ArrayList<Resource> l = new ArrayList<>();
        //randomizáláshoz
        Random random = new Random();
        // a listához mindenféle nyersanyagból hozzáadunk egyet
        l.add(new Aluminium());
        l.add(new Coal());
        l.add(new Copper());
        l.add(new Iron());
        l.add(new Sulfur());
        l.add(new WaterIce());
        l.add(new Plutonium());
        l.add(new Uran());
        int asteroidnum = 50;
        // azt számolja, hogy a nyersanyag listában hanyadiknál járunk
        int szamol = 0;
        // 50 aszteroida lesz
        for (int i = 0; i < asteroidnum; i++) {
            // létrehozzuk az aszteroidát
            Asteroid asteroid = new Asteroid();
            // az aszteroida nyersanyaga az l lista "szamol" számú tagja lesz
            asteroid.setResource(l.get(szamol));
            // növeljük, hogy a következő más nyersanyag legyen
            szamol++;

            // a Gamebne a Fieldek listajahoz hozzáadjuk az aszteroidát
            fields.add(asteroid);
            // ha ez megtörténik akkor újra kell kezdeni a nyersanyaglistát az elejéről
            if (szamol == l.size()) {
                //kezdődik a lista elölről
                szamol = 0;
            }
            // ha nem ez az első aszteroida
            if (i != 0) {
                //beállítjuk szomszédjánka az előzőt
                asteroid.addNeighbor(fields.get(i - 1));
                // és az előzőnek beállítjuk szomszédjának a most létrehozottat
                fields.get(i - 1).addNeighbor(asteroid);
            }

            // ha az utolsó létrehozott aszteroidánál vagyunk akkor
            if (i == asteroidnum - 1) {
                // beállítuk szomszédjának a legelsőt
                asteroid.addNeighbor(fields.get(0));
                // a legelsőnek is szomszédja lesz ez
                fields.get(0).addNeighbor(asteroid);
            }
        }

        for (int i = 0; i < fields.size(); i++) {
            int neighborNum = random.nextInt(2);
            // még max 10 kapcsolatot létrehozunk
            for (int j = 0; j < neighborNum; j++) {
                // generálunk 2 random sorszámot(ezek az aszteroidák sorszámai a fieldben)
                int otherIndex = random.nextInt(fields.size());
                // ha a két szám nem ugyanaz
                if (i != otherIndex) {
                    // ha még nem párja
                    if (!fields.get(i).getNeighbors().contains(fields.get(otherIndex))) {
                        // csak ha még nem szomszédok
                        fields.get(i).addNeighbor(fields.get(otherIndex));
                        // beállítjuk őket egymás párjának
                        fields.get(otherIndex).addNeighbor(fields.get(i));
                    }
                }
            }
        }

        // létrehozunk 5 ufot
        for (int i = 0; i < 5; i++) {
            // ufo létrehozása
            Ufo ufo = new Ufo();
            //egy random sorszámú aszteroidán elhelyezzük
            int number = random.nextInt(fields.size());
            // setlocation megtörténik benne
            fields.get(number).addEntity(ufo);

        }

        for (int i = 0; i < 5; i++) {
            Settler settler = new Settler();
            int number = random.nextInt(fields.size());
            fields.get(number).addEntity(settler);
            Player player = new Player();
            player.setSettler(settler);
            players.add(player);
        }
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
        return !checkEnoughResources() || players.size() == 1;
    }

    /**
     * Leellenőrzi, hogy van-e elég nyersanyag a játék megnyeréséhez
     *
     * @return Van-e elég nyersanyag a játék megnyeréséhez
     */
    public boolean checkEnoughResources() {
        Asteroid a = new Asteroid();
        ArrayList<Resource> b = new ArrayList<>();
        for (Field field : fields) {
            if (field instanceof Asteroid) {
                b.add(((Asteroid) field).getResource());
            }

        }
        return winBill.isCompleted(b);
    }

    /**
     * Lefuttat egy napkitörést a játékpályán
     */
    public void solarFlare() {
        // Menjünk végig a kellő számú mezőn és futtassunk le rajtuk egy napkitörést
        Random random = new Random();
        int effectedCount = random.nextInt(fields.size() - 5) + 5;
        ArrayList<Field> copy = new ArrayList<>(fields);
        Collections.shuffle(copy);
        for (int i = 0; i < effectedCount; i++) {
            copy.get(i).solarFlare();
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
        players.remove(participant);
    }

    /**
     * Hozzáad egy résztvevőt a játékjoz
     *
     * @param player A hozzáadandó játékos
     */
    public void addParticipant(Player player) {
        players.add(player);

    }

    public void removeField(Field field) {
        fields.remove(field);
    }


    public void round() {
        currentPlayer++;
        if (currentPlayer >= players.size()) {
            currentPlayer = 0;
            for (Field field : fields) {
                field.round();
            }
            AI.getInstance().round();
        }
        Player player = players.get(currentPlayer);
        if (player.getIsPlaying()) {
            player.round();
        } else {
            removeParticipant(player);
        }

        asteroidDrawer.draw(player.getSettler().getLocation());
        playerDrawer.draw(player, 0, 0);

        //GameController.solarFlareText.setText("");

    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public Player getCurrentPlayer() {
        return players.get(currentPlayer);
    }
}
