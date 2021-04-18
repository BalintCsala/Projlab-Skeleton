package projlab.skeleton;

import projlab.skeleton.entities.Robot;
import projlab.skeleton.entities.Settler;
import projlab.skeleton.map.Asteroid;
import projlab.skeleton.map.Field;
import projlab.skeleton.map.TeleportGate;
import projlab.skeleton.participants.Player;
import projlab.skeleton.resources.*;
import projlab.skeleton.resources.radioactive.Plutonium;
import projlab.skeleton.resources.radioactive.Uran;
import projlab.skeleton.utils.ObjectCatalog;
import projlab.skeleton.utils.TesterEvent;
import projlab.skeleton.utils.TesterEventHandler;

import java.util.Scanner;

/**
 * A program kezdőosztálya
 */
public class Main {

    public static void main(String[] args) {
        TesterEventHandler.registerListener(new String[]{"info", "*"}, cmd -> {
            String id = cmd[1];
            System.out.println(ObjectCatalog.getInfo(id));
        });

        TesterEventHandler.registerListener(new String[]{"robot", "*"}, cmd -> ObjectCatalog.addObject(cmd[1], new Robot()));

        TesterEventHandler.registerListener(new String[]{"resource", "coal", "*"}, cmd -> ObjectCatalog.addObject(cmd[2], new Coal()));

        TesterEventHandler.registerListener(new String[]{"resource", "iron", "*"}, cmd -> ObjectCatalog.addObject(cmd[2], new Iron()));

        TesterEventHandler.registerListener(new String[]{"resource", "plutonium", "*"}, cmd -> ObjectCatalog.addObject(cmd[2], new Plutonium()));

        TesterEventHandler.registerListener(new String[]{"resource", "sulfur", "*"}, cmd -> ObjectCatalog.addObject(cmd[2], new WaterIce()));

        TesterEventHandler.registerListener(new String[]{"resource", "uran", "*", "*"}, cmd -> {
            Uran uran = new Uran();
            uran.setExposedCount(Integer.parseInt(cmd[3]));
            ObjectCatalog.addObject(cmd[2], uran);
        });

        TesterEventHandler.registerListener(new String[]{"resource", "copper", "*"}, cmd -> ObjectCatalog.addObject(cmd[2], new Copper()));

        TesterEventHandler.registerListener(new String[]{"resource", "waterice", "*"}, cmd -> ObjectCatalog.addObject(cmd[2], new WaterIce()));

        TesterEventHandler.registerListener(new String[]{"resource", "aluminium", "*"}, cmd -> ObjectCatalog.addObject(cmd[2], new Aluminium()));

        TesterEventHandler.registerListener(new String[]{"settler", "*", "*", "*"}, cmd -> {
            String name = cmd[1];
            Player player = (Player) ObjectCatalog.getObject(cmd[2]);
            Asteroid asteroid = (Asteroid) ObjectCatalog.getObject(cmd[3]);
            Settler settler = new Settler();
            player.setSettler(settler);
            asteroid.addEntity(settler);
            ObjectCatalog.addObject(name, settler);
        });

        TesterEventHandler.registerListener(new String[]{"move", "*", "*"}, cmd -> {
            Settler settler = (Settler) ObjectCatalog.getObject(cmd[1]);
            Field field = (Field) ObjectCatalog.getObject(cmd[2]);
            settler.move(field);
        });

        TesterEventHandler.registerListener(new String[]{"mine", "*"}, cmd -> {
            Settler settler = (Settler) ObjectCatalog.getObject(cmd[1]);
            settler.mine();
        });

        TesterEventHandler.registerListener(new String[]{"placedownteleport", "*", "*"}, cmd -> {
            Asteroid asteroid = (Asteroid) ObjectCatalog.getObject(cmd[2]);
            Settler settler = (Settler) ObjectCatalog.getObject(cmd[1]);
            settler.placeDownTeleport(asteroid);
        });

        TesterEventHandler.registerListener(new String[]{"placedownresource", "*", "*"}, cmd -> {
            Resource resource = (Resource) ObjectCatalog.getObject(cmd[2]);
            Settler settler = (Settler) ObjectCatalog.getObject(cmd[1]);
            settler.placeDownResource(resource);
        });

        TesterEventHandler.registerListener(new String[]{"player", "*"}, cmd -> {
            Player player = new Player();
            ObjectCatalog.addObject(cmd[1], player);
            Game.getInstance().addParticipant(player);
        });

        TesterEventHandler.registerListener(new String[]{"asteroid", "*", "*", "*", "*"}, cmd -> {
            String name = cmd[1];
            int layerDepth = Integer.parseInt(cmd[2]);
            Resource res = cmd[3].equals("null") ? null : (Resource) ObjectCatalog.getObject(cmd[3]);
            boolean nearSun = Boolean.parseBoolean(cmd[4]);

            Asteroid asteroid = new Asteroid();
            asteroid.setDepth(layerDepth);
            asteroid.setResource(res);
            asteroid.setNearSun(nearSun);

            ObjectCatalog.addObject(name, asteroid);
            Game.getInstance().addField(asteroid);
        });

        TesterEventHandler.registerListener(new String[]{"neighbor", "*", "*"}, cmd -> {
            Asteroid a1 = (Asteroid) ObjectCatalog.getObject(cmd[1]);
            Asteroid a2 = (Asteroid) ObjectCatalog.getObject(cmd[2]);
            a1.addNeighbor(a2);
            a2.addNeighbor(a1);
        });

        TesterEventHandler.registerListener(new String[]{"teleportpairtoasteroids", "*", "*", "*", "*"}, cmd -> {
            TeleportGate gate1 = new TeleportGate();
            TeleportGate gate2 = new TeleportGate();
            gate1.setPair(gate2);
            gate2.setPair(gate1);
            gate1.setActive(true);
            gate2.setActive(true);
            Asteroid asteroid1 = (Asteroid) ObjectCatalog.getObject(cmd[3]);
            Asteroid asteroid2 = (Asteroid) ObjectCatalog.getObject(cmd[4]);
            asteroid1.addTeleport(gate1);
            asteroid2.addTeleport(gate2);
            ObjectCatalog.addObject(cmd[1], gate1);
            ObjectCatalog.addObject(cmd[2], gate2);
        });

        TesterEventHandler.registerListener(new String[]{"teleportpairtosettler", "*", "*", "*"}, cmd -> {
            TeleportGate gate1 = new TeleportGate();
            TeleportGate gate2 = new TeleportGate();
            gate1.setPair(gate2);
            gate2.setPair(gate1);
            Settler settler = (Settler) ObjectCatalog.getObject(cmd[3]);
            settler.setTeleports(gate1, gate2, null);
            ObjectCatalog.addObject(cmd[1], gate1);
            ObjectCatalog.addObject(cmd[2], gate2);
        });

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String line = scanner.nextLine();
            String[] cmd = line.split(" ");
            if (cmd.length == 1 && cmd[0].equals("stopplay"))
                break;
            TesterEventHandler.fireEvent(new TesterEvent(cmd));
        }
    }
}
