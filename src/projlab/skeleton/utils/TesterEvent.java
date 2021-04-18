package projlab.skeleton.utils;

public class TesterEvent {

    public final String[] cmd;

    public TesterEvent(String[] cmd) {
        this.cmd = cmd;
    }

    public boolean matches(TesterEventDescription description) {
        if (description.maxLength < this.cmd.length)
            return false;
        for (int i = 0; i < description.pattern.length; i++) {
            if (!description.pattern[i].equals(this.cmd[i]) && !description.pattern[i].equals("*"))
                return false;
        }
        return true;
    }

}
