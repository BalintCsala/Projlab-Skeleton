package projlab.skeleton.utils;

public class TesterEvent {

    public final String[] cmd;

    public TesterEvent(String[] cmd) {
        this.cmd = cmd;
    }

    public boolean matches(String[] description) {
        if (description.length != this.cmd.length)
            return false;
        for (int i = 0; i < description.length; i++) {
            if (!description[i].equals(this.cmd[i]) && !description[i].equals("*"))
                return false;
        }
        return true;
    }

}
