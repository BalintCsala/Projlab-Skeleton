package projlab.skeleton;

import projlab.skeleton.map.Field;
import projlab.skeleton.participants.Participant;
import projlab.skeleton.utils.BillOfResources;
import projlab.skeleton.utils.FunctionPrinter;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    private final ArrayList<Field> fields = new ArrayList<>();
    private final ArrayList<Participant> participants = new ArrayList<>();
    private BillOfResources winBill;

    private static Game instance;

    Game() { }

    public static Game getInstance() {
        if (instance == null)
            instance = new Game();
        return instance;
    }

    public void startGame() {
        FunctionPrinter.enter("Game", "startGame");
        FunctionPrinter.exit();
    }

    public void endGame() {
        FunctionPrinter.enter("Game", "endGame");
        FunctionPrinter.exit();
    }

    public boolean checkGameEnd() {
        FunctionPrinter.enter("Game", "checkGameEnd");
        FunctionPrinter.msg("Vege a jateknak? (I/N)");
        boolean end = new Scanner(System.in).next().equals("I");
        FunctionPrinter.exit();
        return end;
    }

    public boolean checkEnoughResources() {
        FunctionPrinter.enter("Game", "checkEnoughResources");
        FunctionPrinter.msg("Van eleg nyersanyag? (I/N)");
        boolean enough = new Scanner(System.in).next().equals("I");
        FunctionPrinter.exit();
        return enough;
    }

    public void solarFlare() {
        FunctionPrinter.enter("Game", "solarFlare");
        for (Field field : fields) {
            field.solarFlare();
        }
        FunctionPrinter.exit();
    }

    public void addField(Field field) {
        FunctionPrinter.enter("Game", "addField");
        fields.add(field);
        FunctionPrinter.exit();
    }

    public void removeParticipant(Participant participant) {
        FunctionPrinter.enter("Game", "removeParticipant");
        participants.remove(participant);
        FunctionPrinter.exit();
    }

}
