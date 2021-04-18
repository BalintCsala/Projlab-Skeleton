package projlab.skeleton;

import projlab.skeleton.resources.Aluminium;
import projlab.skeleton.resources.Copper;
import projlab.skeleton.resources.radioactive.Plutonium;
import projlab.skeleton.resources.Sulfur;
import projlab.skeleton.map.Asteroid;
import projlab.skeleton.map.Field;
import projlab.skeleton.participants.Participant;
import projlab.skeleton.resources.Coal;
import projlab.skeleton.resources.Iron;
import projlab.skeleton.resources.WaterIce;
import projlab.skeleton.resources.Resource;
import projlab.skeleton.resources.radioactive.Uran;
import projlab.skeleton.utils.BillOfResources;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * A játékot eltároló objektum
 */
public class Game {

    /**
     * A játékpálya mezői
     */
    private final ArrayList<Field> fields = new ArrayList<>();
    /**
     * A játékban résztvevők listája
     */
    private final ArrayList<Participant> participants = new ArrayList<>();
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

    /**
     * Privát konstruktor a singleton design patternhez
     */
    private Game() { }

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
     * Ha egy r�sztvev� maradt vagy ha nincs el�g nyersanyag v�get �r a j�t�k
     * @return Véget ért-e a játék
     */
    public boolean checkGameEnd() {
        
        
        boolean enoughresource=checkEnoughResources();
        if(!enoughresource||participants.size()==1) {//participantsbe az AI is beletartozik
        	return true;
        	
        }
        
      
        return false;
    }

    /**
     * Leellenőrzi, hogy van-e elég nyersanyag a játék megnyeréséhez
     * Megvizsg�lja az aszteroid�kat �s �sszegy�jti az el�fordul� nyersanyag t�pusokat
     * @return Van-e elég nyersanyag a játék megnyeréséhez
     */
    public boolean checkEnoughResources() {
        
        Asteroid a = new Asteroid();
        ArrayList<Resource> b = new ArrayList<>();
        for(int i=0;i<fields.size();i++) {
        	if(fields.get(i).getClass()==a.getClass()) {
        		a = (Asteroid)fields.get(i);
        		b.add(a.getResource());
        	}
        	
        }
       boolean enough= winBill.isCompleted(b);
        return enough;
       
    }

    /**
     * Lefuttat egy napkitörést a játékpályán anniy Fielden amennyi az effectedCount
     */
    public void solarFlare() {
        
        // Menjünk végig az összes mezőn és futtassunk le rajtuk egy napkitörést
        for (int i=0;i<effectedCount;i++) {
            fields.get(i).solarFlare();
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
    public void addParticipant (Participant participant){
       
        participants.add(participant);
       
    }
    /**
     * Eltávolít egy Fieldet a játékból
     * @param field Az eltávolítandó Field
     */
    public void removeField(Field field) {
       
        fields.remove(field);
       
    }
    
    /**
     * Lefuttat egy k�rt a j�t�k r�sztvev�in 
     * Amennyiben j�t�kban vannak m�g elindul a k�r�k
     * Ha m�r nincsenek j�t�kban elt�vol�tjuk �ket a r�sztvev�k k�z�l
     */
    public void round() {
    	for (Participant participant : participants) {
    		if(participant.getisplaying()==true) {
            participant.round();}
        }
    	for (Participant participant : participants) {
    		if(participant.getisplaying()==false) {
            removeParticipant(participant);}
        }
    	
    }

}
