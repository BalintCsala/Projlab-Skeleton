package projlab.skeleton;

import com.sun.source.doctree.TextTree;
import projlab.skeleton.entities.MiningEntity;
import projlab.skeleton.entities.Robot;
import projlab.skeleton.entities.Settler;
import projlab.skeleton.entities.Ufo;
import projlab.skeleton.map.Asteroid;
import projlab.skeleton.map.Field;
import projlab.skeleton.map.TeleportGate;
import projlab.skeleton.participants.AI;
import projlab.skeleton.participants.Player;
import projlab.skeleton.resources.*;
import projlab.skeleton.resources.radioactive.Plutonium;
import projlab.skeleton.resources.radioactive.Uran;
import projlab.skeleton.utils.ObjectCatalog;
import projlab.skeleton.utils.TesterEvent;
import projlab.skeleton.utils.TesterEventHandler;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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

        TesterEventHandler.registerListener(new String[]{"robot", "*", "*"}, cmd -> {
            Robot robot = new Robot();
            Asteroid asteroid = (Asteroid) ObjectCatalog.getObject(cmd[2]);
            asteroid.addEntity(robot);
            ObjectCatalog.addObject(cmd[1], robot);
        });

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

        TesterEventHandler.registerListener(new String[]{"settler", "*", "*", "*"}, 14, cmd -> {
            String name = cmd[1];
            Player player = (Player) ObjectCatalog.getObject(cmd[2]);
            Asteroid asteroid = (Asteroid) ObjectCatalog.getObject(cmd[3]);
            Settler settler = new Settler();
            player.setSettler(settler);
            asteroid.addEntity(settler);

            for (int i = 4; i < cmd.length; i++) {
                settler.addResource((Resource) ObjectCatalog.getObject(cmd[i]));
            }

            ObjectCatalog.addObject(name, settler);
        });

        TesterEventHandler.registerListener(new String[]{"move", "*", "*"}, cmd -> {
            Settler settler = (Settler) ObjectCatalog.getObject(cmd[1]);
            Field field = (Field) ObjectCatalog.getObject(cmd[2]);
            settler.move(field);
        });

        TesterEventHandler.registerListener(new String[]{"mine", "*"}, cmd -> {
            MiningEntity entity = (MiningEntity) ObjectCatalog.getObject(cmd[1]);
            entity.mine();
        });

        TesterEventHandler.registerListener(new String[]{"placedownteleport", "*", "*", "*"}, cmd -> {
            Asteroid asteroid = (Asteroid) ObjectCatalog.getObject(cmd[2]);
            Settler settler = (Settler) ObjectCatalog.getObject(cmd[1]);
            TeleportGate teleport = (TeleportGate) ObjectCatalog.getObject(cmd[3]);
            settler.placeDownTeleport(asteroid, teleport);
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
            Asteroid asteroid1 = (Asteroid) ObjectCatalog.getObject(cmd[3]);
            Asteroid asteroid2 = (Asteroid) ObjectCatalog.getObject(cmd[4]);
            asteroid1.addTeleport(gate1);
            asteroid2.addTeleport(gate2);
            ObjectCatalog.addObject(cmd[1], gate1);
            ObjectCatalog.addObject(cmd[2], gate2);
            Game.getInstance().addField(gate1);
            Game.getInstance().addField(gate2);
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
            Game.getInstance().addField(gate1);
            Game.getInstance().addField(gate2);
        });

        TesterEventHandler.registerListener(new String[]{"load", "*"}, cmd -> {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(cmd[1] + ".txt"));
                String line;
                while ((line = reader.readLine()) != null) {
                    TesterEventHandler.fireEvent(new TesterEvent(line.split(" ")));
                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        TesterEventHandler.registerListener(new String[]{"ufo", "*", "*"}, cmd -> {
            Ufo ufo = new Ufo();
            Asteroid asteroid = (Asteroid) ObjectCatalog.getObject(cmd[2]);
            asteroid.addEntity(ufo);
            AI.getInstance().addUfo(ufo);
            ObjectCatalog.addObject(cmd[1], ufo);
        });

        TesterEventHandler.registerListener(new String[]{"dig", "*"}, cmd -> ((Settler) ObjectCatalog.getObject(cmd[1])).dig());

        TesterEventHandler.registerListener(new String[]{"solarflare", "*"}, cmd -> ((Field) ObjectCatalog.getObject(cmd[1])).solarFlare());

        TesterEventHandler.registerListener(new String[]{"round"}, cmd -> Game.getInstance().round());

        TesterEventHandler.registerListener(new String[]{"buildteleport", "*"}, cmd -> ((Settler) ObjectCatalog.getObject(cmd[1])).buildTeleport());

        TesterEventHandler.registerListener(new String[]{"buildrobot", "*"}, cmd -> ((Settler) ObjectCatalog.getObject(cmd[1])).buildRobot());

        TesterEventHandler.registerListener(new String[]{"giveup", "*"}, cmd -> ((Player) ObjectCatalog.getObject(cmd[1])).giveUp());

        TesterEventHandler.registerListener(new String[]{"pass", "*"}, cmd -> ((Player) ObjectCatalog.getObject(cmd[1])).pass());

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
