package first.core;

import playn.core.Image;
import playn.core.Surface;

import static playn.core.PlayN.assets;

/**
 * Created by Berdniky on 19.12.2014.
 */
public class TankObjekt {
    private float speed = 5;
    private Image img;
    private float x = 200;
    private float y = 200;

    public TankObjekt(String pathToImage) {
        this.img = assets().getImage(pathToImage);
    }

    public void moveLeft() {
        x -= speed;
    }

    public void moveRight() {
        x += speed;
    }

    public void moveUp() {
        y -= speed;
    }

    public void moveDown() {
        y += speed;
    }

    public void paint(Surface surface) {
        surface.drawImageCentered(img, x, y);
    }

}
