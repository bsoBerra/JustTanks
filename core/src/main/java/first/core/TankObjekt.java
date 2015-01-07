package first.core;

import playn.core.Image;
import playn.core.ImageLayer;
import playn.core.Surface;

import static playn.core.PlayN.assets;

/**
 * Created by Berdniky on 19.12.2014.
 */
public class TankObjekt {
    private ImageLayer layer;
    private float speed = 5;
    private Image img;
    private float x = 200;
    private float y = 200;
    private float angle = 0;

    public TankObjekt(String pathToImage, ImageLayer imageLayer) {
        this.img = assets().getImage(pathToImage);
        this.layer = imageLayer;

    }

    public void moveLeft() {
        angle -= 0.05;
    }

    public void moveRight() {
        angle += 0.05;
    }

    public void moveUp() {
        y -= Math.cos(angle);
        x += Math.sin(angle);
    }

    public void moveDown() {
        y += Math.cos(angle);
        x -= Math.sin(angle);
    }

    public void paint(Surface surface) {
        layer.setImage(img);
        layer.setOrigin(img.width() / 2f, img.height() / 2f);
        layer.setTranslation(x, y);
        if(Math.abs(angle/6.28318531) > 1) angle = angle%6.28318531f;
        surface.drawLayer(layer.setRotation(angle));
    }

}
