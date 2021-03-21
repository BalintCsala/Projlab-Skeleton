package projlab.skeleton.participants;

import projlab.skeleton.Game;
import projlab.skeleton.entities.Settler;
import projlab.skeleton.utils.FunctionPrinter;

public class Player extends Participant {

    private Settler settler;

    public void giveUp() {
        FunctionPrinter.enter("Player", "giveUp");
        settler.die();
        Game.getInstance().removeParticipant(this);
        FunctionPrinter.exit();
    }

    public void pass() {
        FunctionPrinter.enter("Player", "pass");
        FunctionPrinter.exit();
    }

    public void setSettler(Settler settler) {
        this.settler = settler;
    }
}
