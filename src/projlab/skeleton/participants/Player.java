package projlab.skeleton.participants;

import projlab.skeleton.Game;
import projlab.skeleton.entities.Settler;
import projlab.skeleton.utils.FunctionPrinter;

public class Player extends Participant {

    private Settler settler;

    public void giveUp() {
        FunctionPrinter.enter("Player", "giveUp", this);
        settler.die();
        Game.getInstance().removeParticipant(this);
        FunctionPrinter.exit();
    }

    public void pass() {
        FunctionPrinter.enter("Player", "pass", this);
        FunctionPrinter.exit();
    }

    public void setSettler(Settler settler) {
        FunctionPrinter.enter("Player", "setSettler", this, settler);
        this.settler = settler;
        FunctionPrinter.exit();
    }
}
