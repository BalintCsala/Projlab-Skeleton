package projlab.skeleton.utils;

public class ClickArea {

    public int x, y, width, height;
    public ClickEvent clickEvent;

    public ClickArea(int x, int y, int width, int height, ClickEvent clickEvent) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.clickEvent = clickEvent;
    }
}
