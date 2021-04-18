package projlab.skeleton.entities;

public class Ufo extends MovingEntity implements MiningEntity {


    @Override
    public void dig() {

    }

    @Override
    public void mine() {
        // Bányásszuk ki az aszteroida nyersanyagát
        location.mineResource();
    }

    @Override
    public void explode() {
        die();
    }
}
