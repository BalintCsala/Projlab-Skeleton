package projlab.skeleton;

<<<<<<< HEAD
import projlab.skeleton.resources.Aluminium;
import projlab.skeleton.resources.Copper;
import projlab.skeleton.resources.radioactive.Plutonium;
import projlab.skeleton.resources.Sulfur;
=======
>>>>>>> refs/remotes/origin/main
import projlab.skeleton.map.Asteroid;
import projlab.skeleton.map.Field;
import projlab.skeleton.participants.Participant;
<<<<<<< HEAD
import projlab.skeleton.resources.Coal;
import projlab.skeleton.resources.Iron;
import projlab.skeleton.resources.WaterIce;
import projlab.skeleton.resources.Resource;
=======
import projlab.skeleton.resources.*;
import projlab.skeleton.resources.radioactive.Plutonium;
>>>>>>> refs/remotes/origin/main
import projlab.skeleton.resources.radioactive.Uran;
import projlab.skeleton.utils.BillOfResources;

import java.util.ArrayList;

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
<<<<<<< HEAD
    /**
     * A játékhoz szükséges nyersanyagokat tároló objektum
     * Hozz�adunk minden nyersanyagt�pusb�l egyet, mivel mindegyikb�l 1 kell a j�t�k megnyer�s�hez
     */
    private static BillOfResources winBill;
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
     * Megadja, hogy h�ny Fieldet �rint a solarFlare
     */
    
    private static int effectedCount;
    /**
     * A singleton design pattern instance tagváltozója
     */
    
   
    
    private static Game instance;
=======
>>>>>>> refs/remotes/origin/main

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
<<<<<<< HEAD
        
=======
>>>>>>> refs/remotes/origin/main
    }

    /**
     * Befejezi a játékot, egyelőre semmit nem csinál
     */
    public void endGame() {
<<<<<<< HEAD
       
=======
>>>>>>> refs/remotes/origin/main
    }

    /**
     * Leellenőrzi, hogy a játék véget ért-e
<<<<<<< HEAD
     * Ha egy r�sztvev� maradt vagy ha nincs el�g nyersanyag v�get �r a j�t�k
=======
     *
>>>>>>> refs/remotes/origin/main
     * @return Véget ért-e a játék
     */
    public boolean checkGameEnd() {
<<<<<<< HEAD
        
        
        boolean enoughresource=checkEnoughResources();
        if(!enoughresource||participants.size()==1) {//participantsbe az AI is beletartozik
        	return true;
        	
=======
        boolean enoughresource = checkEnoughResources();
        if (!enoughresource || participants.size() == 1) {//atirva
            return true;
>>>>>>> refs/remotes/origin/main
        }
<<<<<<< HEAD
        
      
=======

>>>>>>> refs/remotes/origin/main
        return false;
    }

    /**
     * Leellenőrzi, hogy van-e elég nyersanyag a játék megnyeréséhez
<<<<<<< HEAD
     * Megvizsg�lja az aszteroid�kat �s �sszegy�jti az el�fordul� nyersanyag t�pusokat
=======
     *
>>>>>>> refs/remotes/origin/main
     * @return Van-e elég nyersanyag a játék megnyeréséhez
     */
    public boolean checkEnoughResources() {
<<<<<<< HEAD
        
=======
>>>>>>> refs/remotes/origin/main
        Asteroid a = new Asteroid();
        ArrayList<Resource> b = new ArrayList<>();
<<<<<<< HEAD
        for(int i=0;i<fields.size();i++) {
        	if(fields.get(i).getClass()==a.getClass()) {
        		a = (Asteroid)fields.get(i);
        		b.add(a.getResource());
        	}
        	
=======
        for (int i = 0; i < fields.size(); i++) {
            if (fields.get(i).getClass() == a.getClass()) {
                //b.addResource(fields.get(i).getresource());
            }

>>>>>>> refs/remotes/origin/main
        }
<<<<<<< HEAD
       boolean enough= winBill.isCompleted(b);
=======
        boolean enough = winBill.isCompleted(b);
>>>>>>> refs/remotes/origin/main
        return enough;
       
    }

    /**
     * Lefuttat egy napkitörést a játékpályán anniy Fielden amennyi az effectedCount
     */
    public void solarFlare() {
<<<<<<< HEAD
        
        // Menjünk végig az összes mezőn és futtassunk le rajtuk egy napkitörést
        for (int i=0;i<effectedCount;i++) {
=======
        // Menjünk végig a kellő számú mezőn és futtassunk le rajtuk egy napkitörést
        for (int i = 0; i < effectedCount; i++) {
>>>>>>> refs/remotes/origin/main
            fields.get(i).solarFlare();
        }
<<<<<<< HEAD
        
=======
>>>>>>> refs/remotes/origin/main
    }

    /**
     * Hozzáad egy mezőt a játékpályához
     *
     * @param field A hozzáadandó mező
     */
    public void addField(Field field) {
<<<<<<< HEAD
        
=======
>>>>>>> refs/remotes/origin/main
        fields.add(field);
<<<<<<< HEAD
       
=======
>>>>>>> refs/remotes/origin/main
    }

    /**
     * Eltávolít egy résztvevőt a játékból
     *
     * @param participant Az eltávolítandó résztvevő
     */
    public void removeParticipant(Participant participant) {
<<<<<<< HEAD
       
=======
>>>>>>> refs/remotes/origin/main
        participants.remove(participant);
<<<<<<< HEAD
       
=======
>>>>>>> refs/remotes/origin/main
    }

    /**
     * Hozzáad egy résztvevőt a játékjoz
     *
     * @param participant A hozzáadandó résztvevő
     */
<<<<<<< HEAD
    public void addParticipant (Participant participant){
       
=======
    public void addParticipant(Participant participant) {
>>>>>>> refs/remotes/origin/main
        participants.add(participant);
<<<<<<< HEAD
       
=======
>>>>>>> refs/remotes/origin/main
    }
<<<<<<< HEAD
    /**
     * Eltávolít egy Fieldet a játékból
     * @param field Az eltávolítandó Field
     */
=======

>>>>>>> refs/remotes/origin/main
    public void removeField(Field field) {
        fields.remove(field);
    }
<<<<<<< HEAD
    
    /**
     * Lefuttat egy k�rt a j�t�k r�sztvev�in 
     * Amennyiben j�t�kban vannak m�g elindul a k�r�k
     * Ha m�r nincsenek j�t�kban elt�vol�tjuk �ket a r�sztvev�k k�z�l
     */
=======

>>>>>>> refs/remotes/origin/main
    public void round() {
        for (Participant participant : participants) {
            if (participant.getIsPlaying()) {
                participant.round();
            }
        }
        for (Participant participant : participants) {
            if (!participant.getIsPlaying()) {
                removeParticipant(participant);
            }
        }

        for (Field field : fields) {
            field.round();
        }

    }

}
