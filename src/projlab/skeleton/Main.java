package projlab.skeleton;

import projlab.skeleton.entities.*;
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

import java.io.*;
import java.util.Scanner;

/**
 * A program kezdőosztálya
 */
public class Main {

    // A writer, amibe a kimenetet írjuk
    private static PrintWriter writer;

    public static void main(String[] args) {
        // Alapból a kimenet legyen a System.out
        writer = new PrintWriter(new OutputStreamWriter(System.out));

        // Info parancs
        TesterEventHandler.registerListener(new String[]{"info", "*"}, cmd -> {
            String id = cmd[1];
            writer.println(ObjectCatalog.getInfo(id));
        });

        // Robot készítése parancs
        TesterEventHandler.registerListener(new String[]{"robot", "*", "*"}, cmd -> {
            Robot robot = new Robot();
            Asteroid asteroid = (Asteroid) ObjectCatalog.getObject(cmd[2]);
            asteroid.addEntity(robot);
            ObjectCatalog.addObject(cmd[1], robot);
        });

        // Szén készítése parancs
        TesterEventHandler.registerListener(new String[]{"resource", "coal", "*"}, cmd -> ObjectCatalog.addObject(cmd[2], new Coal()));

        // Vas készítése parancs
        TesterEventHandler.registerListener(new String[]{"resource", "iron", "*"}, cmd -> ObjectCatalog.addObject(cmd[2], new Iron()));

        // Plutónium készítése parancs
        TesterEventHandler.registerListener(new String[]{"resource", "plutonium", "*"}, cmd -> ObjectCatalog.addObject(cmd[2], new Plutonium()));

        // Kén készítése parancs
        TesterEventHandler.registerListener(new String[]{"resource", "sulfur", "*"}, cmd -> ObjectCatalog.addObject(cmd[2], new WaterIce()));

        // Urán készítése parancs
        TesterEventHandler.registerListener(new String[]{"resource", "uran", "*", "*"}, cmd -> {
            Uran uran = new Uran();
            uran.setExposedCount(Integer.parseInt(cmd[3]));
            ObjectCatalog.addObject(cmd[2], uran);
        });

        // Réz készítése parancs
        TesterEventHandler.registerListener(new String[]{"resource", "copper", "*"}, cmd -> ObjectCatalog.addObject(cmd[2], new Copper()));

        // Jég készítése parancs
        TesterEventHandler.registerListener(new String[]{"resource", "waterice", "*"}, cmd -> ObjectCatalog.addObject(cmd[2], new WaterIce()));

        // Alumínium készítése parancs
        TesterEventHandler.registerListener(new String[]{"resource", "aluminium", "*"}, cmd -> ObjectCatalog.addObject(cmd[2], new Aluminium()));

        // Telepest létrehozó parancs
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

        // Telepest mozgató parancs
        TesterEventHandler.registerListener(new String[]{"move", "*", "*"}, cmd -> {
            Settler settler = (Settler) ObjectCatalog.getObject(cmd[1]);
            Field field = (Field) ObjectCatalog.getObject(cmd[2]);
            settler.move(field);
        });

        // Telepessel bányászás parancs
        TesterEventHandler.registerListener(new String[]{"mine", "*"}, cmd -> {
            MiningEntity entity = (MiningEntity) ObjectCatalog.getObject(cmd[1]);
            entity.mine();
        });

        // Teleport lerakása parancs
        TesterEventHandler.registerListener(new String[]{"placedownteleport", "*", "*", "*"}, cmd -> {
            Asteroid asteroid = (Asteroid) ObjectCatalog.getObject(cmd[2]);
            Settler settler = (Settler) ObjectCatalog.getObject(cmd[1]);
            TeleportGate teleport = (TeleportGate) ObjectCatalog.getObject(cmd[3]);
            settler.placeDownTeleport(asteroid, teleport);
        });

        // Nyersanyag lerakása parancs
        TesterEventHandler.registerListener(new String[]{"placedownresource", "*", "*"}, cmd -> {
            Resource resource = (Resource) ObjectCatalog.getObject(cmd[2]);
            Settler settler = (Settler) ObjectCatalog.getObject(cmd[1]);
            settler.placeDownResource(resource);
        });

        // Játékos létrehozása parancs
        TesterEventHandler.registerListener(new String[]{"player", "*"}, cmd -> {
            Player player = new Player();
            ObjectCatalog.addObject(cmd[1], player);
            Game.getInstance().addParticipant(player);
        });

        // Aszteroida létrehozása parancs
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

        // Aszteroidák szomszédjának beállítása
        TesterEventHandler.registerListener(new String[]{"neighbor", "*", "*"}, cmd -> {
            Asteroid a1 = (Asteroid) ObjectCatalog.getObject(cmd[1]);
            Asteroid a2 = (Asteroid) ObjectCatalog.getObject(cmd[2]);
            a1.addNeighbor(a2);
            a2.addNeighbor(a1);
        });

        // Teleport pár hozzárendelése aszteroidához
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

        // Teleport pár hozzárendelése telepeshez
        TesterEventHandler.registerListener(new String[]{"teleportpairtosettler", "*", "*", "*"}, cmd -> {
            TeleportGate gate1 = new TeleportGate();
            TeleportGate gate2 = new TeleportGate();
            gate1.setPair(gate2);
            gate2.setPair(gate1);
            Settler settler = (Settler) ObjectCatalog.getObject(cmd[3]);
            settler.setTeleports(gate1, gate2);
            ObjectCatalog.addObject(cmd[1], gate1);
            ObjectCatalog.addObject(cmd[2], gate2);
            Game.getInstance().addField(gate1);
            Game.getInstance().addField(gate2);
        });

        // Teszteset betöltése parancs
        TesterEventHandler.registerListener(new String[]{"load", "*"}, cmd -> {
            try {
                PrintWriter oldWriter = writer;
                StringWriter stringWriter = new StringWriter();
                writer = new PrintWriter(stringWriter);
                BufferedReader reader = new BufferedReader(new FileReader("tests/" + cmd[1] + ".txt"));
                String line;
                while ((line = reader.readLine()) != null) {
                    TesterEventHandler.fireEvent(new TesterEvent(line.split(" ")));
                }
                String result = stringWriter.toString().trim();
                writer.close();
                writer = oldWriter;
                reader.close();

                // Check existing output
                BufferedReader outputReader = new BufferedReader(new FileReader("tests/out_" + cmd[1] + ".txt"));
                StringBuilder builder = new StringBuilder();
                while ((line = outputReader.readLine()) != null) {
                    builder.append(line).append("\n");
                }
                outputReader.close();
                String example = builder.toString().trim();
                String[] exampleLines = example.split("\n");
                String[] resultLines = result.split("\n");
                boolean success = true;
                for (int i = 0; i < Math.min(exampleLines.length, resultLines.length); i++) {
                    if (!exampleLines[i].trim().equals(resultLines[i].trim())) {
                        System.out.println("Sor #" + (i + 1) + ":");
                        System.out.println("Vart:   " + exampleLines[i]);
                        System.out.println("Kapott: " + resultLines[i]);
                        success = false;
                    }
                }
                System.out.println(success ? "Sikeres teszt" : "Sikertelen teszt");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        // Ufo létrehozása parancs
        TesterEventHandler.registerListener(new String[]{"ufo", "*", "*"}, cmd -> {
            Ufo ufo = new Ufo();
            Asteroid asteroid = (Asteroid) ObjectCatalog.getObject(cmd[2]);
            asteroid.addEntity(ufo);
            AI.getInstance().addUfo(ufo);
            ObjectCatalog.addObject(cmd[1], ufo);
        });

        // Telepessel ásás parancs
        TesterEventHandler.registerListener(new String[]{"dig", "*"}, cmd -> ((MovingEntity) ObjectCatalog.getObject(cmd[1])).dig());

        // Napkitörés futtatása egy aszteroidán vagy teleportkapun
        TesterEventHandler.registerListener(new String[]{"solarflare", "*"}, cmd -> ((Field) ObjectCatalog.getObject(cmd[1])).solarFlare());

        // Egy kör lefuttatása
        TesterEventHandler.registerListener(new String[]{"round"}, cmd -> Game.getInstance().round());

        // Egy teleport létrehozása telepessel
        TesterEventHandler.registerListener(new String[]{"buildteleport", "*"}, cmd -> ((Settler) ObjectCatalog.getObject(cmd[1])).buildTeleport());

        // Robot létrehozása telepessel
        TesterEventHandler.registerListener(new String[]{"buildrobot", "*"}, cmd -> ((Settler) ObjectCatalog.getObject(cmd[1])).buildRobot());

        // Egy a játék feladása egy játékossal
        TesterEventHandler.registerListener(new String[]{"giveup", "*"}, cmd -> ((Player) ObjectCatalog.getObject(cmd[1])).giveUp());

        // Passzolás egy telepessel
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
