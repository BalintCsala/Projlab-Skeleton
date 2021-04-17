package projlab.skeleton;

import projlab.skeleton.entities.Aluminium;
import projlab.skeleton.entities.Copper;
import projlab.skeleton.entities.Plutonium;
import projlab.skeleton.entities.Sulfur;
import projlab.skeleton.map.Asteroid;
import projlab.skeleton.map.Field;
import projlab.skeleton.participants.Participant;
import projlab.skeleton.resources.Coal;
import projlab.skeleton.resources.Iron;
import projlab.skeleton.resources.WaterIce;
import projlab.skeleton.resources.radioactive.Uran;
import projlab.skeleton.utils.BillOfResources;
import projlab.skeleton.utils.FunctionPrinter;

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
     * A singleton design pattern instance tagváltozója
     */
    
    private static int effectedCount;
    
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
        FunctionPrinter.enter("Game", "startGame", this);
        FunctionPrinter.exit();
    }

    /**
     * Befejezi a játékot, egyelőre semmit nem csinál
     */
    public void endGame() {
        FunctionPrinter.enter("Game", "endGame", this);
        FunctionPrinter.exit();
    }

    /**
     * Leellenőrzi, hogy a játék véget ért-e
     * @return Véget ért-e a játék
     */
    public boolean checkGameEnd() {
        FunctionPrinter.enter("Game", "checkGameEnd", this);
        FunctionPrinter.ask("Vege a jateknak? (I/N)");
       // boolean end = new Scanner(System.in).next().equals("I");
        
        boolean enoughresource=checkEnoughResources();
        if(!enoughresource||participants.size()==1) {//atirva
        	return true;
        	
        }
        
        
        FunctionPrinter.exit();
        
        
        
        return false;
    }

    /**
     * Leellenőrzi, hogy van-e elég nyersanyag a játék megnyeréséhez
     * @return Van-e elég nyersanyag a játék megnyeréséhez
     */
    public boolean checkEnoughResources() {
        FunctionPrinter.enter("Game", "checkEnoughResources", this);
        FunctionPrinter.ask("Van eleg nyersanyag? (I/N)");
       // boolean enough = new Scanner(System.in).next().equals("I");
        Asteroid a = new Asteroid();
        ArrayList<Resource> b = new ArrayList<>();
        for(int i=0;i<fields.size();i++) {
        	if(fields.get(i).getClass()==a.getClass()) {
        		b.addResource(fields.get(i).getresource());
        	}
        	
        }
       boolean enough= winBill.isCompleted(b);
        FunctionPrinter.exit();
        return enough;
    }

    /**
     * Lefuttat egy napkitörést a játékpályán
     */
    public void solarFlare() {
        FunctionPrinter.enter("Game", "solarFlare", this);
        // Menjünk végig az összes mezőn és futtassunk le rajtuk egy napkitörést
        for (int i=0;i<effectedCount;i++) {
            fields.get(i).solarFlare();
        }
        FunctionPrinter.exit();
    }

    /**
     * Hozzáad egy mezőt a játékpályához
     * @param field A hozzáadandó metódus
     */
    public void addField(Field field) {
        FunctionPrinter.enter("Game", "addField", this, field);
        fields.add(field);
        FunctionPrinter.exit();
    }

    /**
     * Eltávolít egy résztvevőt a játékból
     * @param participant Az eltávolítandó résztvevő
     */
    public void removeParticipant(Participant participant) {
        FunctionPrinter.enter("Game", "removeParticipant", this, participant);
        participants.remove(participant);
        FunctionPrinter.exit();
    }

    /**
     * Hozzáad egy résztvevőt a játékjoz
     * @param participant A hozzáadandó résztvevő
     */
    public void addParticipant (Participant participant){
        FunctionPrinter.enter("Game", "addParticipant", this, participant);
        participants.add(participant);
        FunctionPrinter.exit();
    }
    
    public void removeField(Field field) {
       
        fields.remove(field);
       
    }
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
