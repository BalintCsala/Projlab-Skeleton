package projlab.skeleton;

import projlab.skeleton.map.Asteroid;
import projlab.skeleton.entities.Settler;
import projlab.skeleton.map.TeleportGate;
import projlab.skeleton.participants.AI;
import projlab.skeleton.participants.Player;
import projlab.skeleton.resources.Coal;
import projlab.skeleton.resources.Iron;
import projlab.skeleton.resources.WaterIce;
import projlab.skeleton.resources.radioactive.Uran;
import projlab.skeleton.utils.BillOfResources;

public class Skeleton {

    public void settlerMines (){
        Settler settler= new Settler();
        Iron resource= new Iron();
        Asteroid asteroid= new Asteroid();
        asteroid.addEntity(settler);
        asteroid.setResource(resource);
    }

    public void placeDownNotRadioactiveOrWatericeResource(){
        Iron resource= new Iron();
        Settler settler= new Settler();
        Asteroid asteroid= new Asteroid();
        asteroid.addEntity(settler);
        settler.addResource(resource);
    }

    public void placeDownTeleportGate(){
        TeleportGate teleport = new TeleportGate();
        Settler settler = new Settler();
        Asteroid asteroid= new Asteroid();
        Game game= new Game();
        asteroid.addEntity(settler);
    }

    public void buildRobot(){
        Iron iron = new Iron();
        Coal coal = new Coal();
        Uran uran = new Uran();

        BillOfResources robotBill= new BillOfResources();
        AI ai= new AI();
        Settler settler= new Settler();

        robotBill.addResource(iron);
        robotBill.addResource(coal);
        robotBill.addResource(uran);

        Iron iron2 = new Iron();
        Coal coal2 = new Coal();
        Uran uran2 = new Uran();

        settler.addResource(iron2);
        settler.addResource(coal2);
        settler.addResource(uran2);

    }

    public void buildTeleportgate (){
        Iron iron1 = new Iron();
        Iron iron2 = new Iron();
        WaterIce waterIce = new WaterIce();
        Uran uran = new Uran();

        BillOfResources teleportBill= new BillOfResources();
        Settler settler= new Settler();

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
    }

    public void pass(){
        Player p = new Player();
    }

    public void giveUp(){
        Player player = new Player();
        Game game = new Game();
        Settler settler= new Settler();
        Asteroid asteroid= new Asteroid();

        game.addParticipant(player);
        player.setSettler(settler);
        asteroid.addEntity(settler);


    }
}
