package projlab.skeleton;

import projlab.skeleton.entities.Robot;
import projlab.skeleton.entities.Settler;
import projlab.skeleton.map.Asteroid;
import projlab.skeleton.map.TeleportGate;
import projlab.skeleton.participants.AI;
import projlab.skeleton.participants.Player;
import projlab.skeleton.resources.Coal;
import projlab.skeleton.resources.Iron;
import projlab.skeleton.resources.WaterIce;
import projlab.skeleton.resources.radioactive.Uran;
import projlab.skeleton.utils.BillOfResources;

public class Skeleton {

    public void settlerMines() {
        Settler settler = new Settler();
        Iron resource = new Iron();
        Asteroid asteroid = new Asteroid();
        asteroid.addEntity(settler);
        asteroid.setResource(resource);

        settler.mine();
    }

    public void placeDownNotRadioactiveOrWatericeResource() {
        Iron resource = new Iron();
        Settler settler = new Settler();
        Asteroid asteroid = new Asteroid();
        asteroid.addEntity(settler);
        settler.addResource(resource);

        settler.placeDownResource(resource);
    }

    public void placeDownTeleportGate() {
        TeleportGate teleport = new TeleportGate();
        Settler settler = new Settler();
        Asteroid asteroid = new Asteroid();
        Game game = Game.getInstance();
        asteroid.addEntity(settler);

        settler.placeDownTeleport(asteroid);
    }

    public void buildRobot() {
        Iron iron = new Iron();
        Coal coal = new Coal();
        Uran uran = new Uran();

        BillOfResources robotBill = new BillOfResources();
        AI ai = AI.getInstance();
        Settler settler = new Settler();

        robotBill.addResource(iron);
        robotBill.addResource(coal);
        robotBill.addResource(uran);

        Iron iron2 = new Iron();
        Coal coal2 = new Coal();
        Uran uran2 = new Uran();

        settler.addResource(iron2);
        settler.addResource(coal2);
        settler.addResource(uran2);

        settler.buildRobot();
    }

    public void buildTeleportGate() {
        Iron iron1 = new Iron();
        Iron iron2 = new Iron();
        WaterIce waterIce = new WaterIce();
        Uran uran = new Uran();

        BillOfResources teleportBill = new BillOfResources();
        Settler settler = new Settler();

        Iron iron3 = new Iron();
        Iron iron4 = new Iron();
        WaterIce waterIce2 = new WaterIce();
        Uran uran2 = new Uran();

        teleportBill.addResource(iron3);
        teleportBill.addResource(iron4);
        teleportBill.addResource(waterIce2);
        teleportBill.addResource(uran2);

        settler.addResource(iron1);
        settler.addResource(iron2);
        settler.addResource(waterIce);
        settler.addResource(uran);

        settler.buildTeleport();
    }

    public void pass() {
        Player p = new Player();

        p.pass();
    }

    public void giveUp() {
        Player player = new Player();
        Game game = Game.getInstance();
        Settler settler = new Settler();
        Asteroid asteroid = new Asteroid();

        game.addParticipant(player);
        player.setSettler(settler);
        asteroid.addEntity(settler);

        player.giveUp();
    }
    //Settler moves to Asteroid

    public void settlerMoveAsteroid() {
        Asteroid a1 = new Asteroid();
        Asteroid a2 = new Asteroid();
        Settler s1 = new Settler();
        a1.addEntity(s1);
        a1.addNeighbor(a2);
        a2.addNeighbor(a1);// ez az irany kell?

        s1.move(a2);
    }

    //Settler moves Teleportgate
    public void settlerMoveTeleportGate() {
        Asteroid a1 = new Asteroid();
        Asteroid a2 = new Asteroid();
        TeleportGate t1 = new TeleportGate();
        TeleportGate t2 = new TeleportGate();
        Settler s1 = new Settler();
        a1.addEntity(s1);
        a1.addNeighbor(t1);
        t1.addNeighbor(a1);
        a2.addNeighbor(t2);
        t2.addNeighbor(a2);
        t1.setPair(t2);
        t2.setPair(t1);


        s1.move(t1);
    }
    //Robot moves to Asteroid

    public void robotMove() {
        Asteroid a1 = new Asteroid();
        Asteroid a2 = new Asteroid();
        Robot r1 = new Robot();
        a1.addEntity(r1);
        a1.addNeighbor(a2);
        a2.addNeighbor(a1);// ez az irany kell?

        r1.move(a2);
    }

    //Robot moves Teleportgate
    public void robotMoveTeleportGate() {
        Asteroid a1 = new Asteroid();
        Asteroid a2 = new Asteroid();
        TeleportGate t1 = new TeleportGate();
        TeleportGate t2 = new TeleportGate();
        Robot r1 = new Robot();
        a1.addEntity(r1);
        a1.addNeighbor(t1);
        t1.addNeighbor(a1);
        a2.addNeighbor(t2);
        t2.addNeighbor(a2);
        t1.setPair(t2);
        t2.setPair(t1);


        r1.move(t1);
    }

    //SolarFlare
    // kell Game konstr
    public void solarFlare() {
        Game g = Game.getInstance();
        Asteroid a1 = new Asteroid();
        Robot r1 = new Robot();
        Settler s1 = new Settler();

        a1.addEntity(s1);
        a1.addEntity(r1);
        g.addField(a1);


        g.solarFlare();

    }

    //Place down waterice
    public void placeDownWaterIce() {
        Asteroid a1 = new Asteroid();
        Settler s1 = new Settler();
        Uran r1 = new Uran();
        a1.addEntity(s1);
        s1.addResource(r1);


        s1.placeDownResource(r1);
    }

    // place down radioactive
    // nem kell inventoryban lennie?
    public void placeDownRadioactive() {
        Asteroid a1 = new Asteroid();
        Settler s1 = new Settler();
        WaterIce r1 = new WaterIce();
        a1.addEntity(s1);
        s1.addResource(r1);

        s1.placeDownResource(r1);

    }

}
