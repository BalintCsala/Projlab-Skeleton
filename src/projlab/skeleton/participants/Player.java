package projlab.skeleton.participants;

import projlab.skeleton.Game;
import projlab.skeleton.entities.Settler;

/**
 * A humán játékosokat jelképező osztály
 */
public class Player extends Participant {

    /**
     * A játékos telepese
     */
    private Settler settler;

    /**
     * A játékos éppen soron van-e
     */
    private boolean isActive = false;

    /**
     * A feladás parancsot implementáló metódus
     */
    public void giveUp() {
        // Öljük meg a telepest
        if (settler != null)
            settler.die();
        // Távolítsuk el a játékost a játékból
        Game.getInstance().removeParticipant(this);
        isPlaying = false;
    }

    /**
     * A semmittevés/passz parancsot implementáló metódus, nem csinál semmit
     */
    public void pass() {
        isActive = false;
    }

    /**
     * Beállítja a játékos telepesét
     *
     * @param settler A beállítandó telepes
     */
    public void setSettler(Settler settler) {
        this.settler = settler;
    }

    /**
     * A játékos köre
     */
    @Override
    public void round() {
        isActive = true;
        if (!this.settler.isAlive()) {
            isPlaying = false;
        }
        if(!isActive) return;

        /*System.out.println("Kerlek valassz a lehetseges lepesek kozul :");
        System.out.println("Mine(1):");
        System.out.println("Dig(2)");
        System.out.println("Move(3)");
        System.out.println("Buildteleport(4)");
        System.out.println("Buildrobot(5)");
        System.out.println("PlaceDownResource(6)");
        System.out.println("PlaceDownTeleport(7)");
        System.out.println("Giveup(8)");
        System.out.println("Pass(9)");
        Scanner scanner = new Scanner(System.in);

        int scenario = scanner.nextInt();


        switch (scenario) {
            case 1:
                settler.mine();
                break;
            case 2:
                settler.dig();
                break;
            case 3:
                settler.move(settler.getLocation().getNeighbors().get(0));
                break;
            case 4:
                settler.buildTeleport();
                break;
            case 5:
                settler.buildRobot();
                break;
            case 6:
                settler.placeDownResource(settler.getInventory().get(0));
                break;
            case 7:
                if (settler.getTeleports().size() > 0)
                    settler.placeDownTeleport(settler.getLocation(), settler.getTeleports().get(0));
                break;
            case 8:
                this.giveUp();
                break;
            case 9:
                this.pass();
                break;
        }*/
    }

    /**
     * Visszaadja a játékos telepesét
     * 
     * @return a játékos telepese
     */
    public Settler getSettler() {
        return settler;
    }

    /**
     * Visszaadja, hogy a játékos éppen soron van-e
     * 
     * @return a játékos éppen soron van-e
     */
    public boolean isActive() {
        return isActive;
    }

    /**
     * Beállítja, hogy a játékos éppen soron van-e
     * 
     * @param active a játékos éppen soron van-e
     */
    public void setActive(boolean active) {
        isActive = active;
    }
}
