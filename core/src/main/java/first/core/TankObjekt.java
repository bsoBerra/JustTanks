package first.core;

import playn.core.Image;
import playn.core.ImageLayer;
import playn.core.Layer;

import static playn.core.PlayN.assets;
import static playn.core.PlayN.graphics;

/**
 * Created by Berdniky on 19.12.2014.
 */
public class TankObjekt {
    private ImageLayer layer = graphics().createImageLayer();
    private Image img = assets().getImage("images/tank.png");
    //tank start
    private float x = 200;
    private float y = 200;

    private float angle = 0;
    private boolean shot;
    private float currentRechargeTime;
    private static final float RECHARGE = 100;
    private static final float RADIAN_NUMBER_IN_360_DEGREE = 6.28318531f;

    public void moveLeft() {
        angle -= 0.05;
    }

    public void moveRight() {
        angle += 0.05;
    }

    public void moveUp() {
        y -= 2 * Math.cos(angle);
        x += 2 * Math.sin(angle);
    }

    public void moveDown() {
        y += Math.cos(angle);
        x -= Math.sin(angle);
    }

    public float getXForShot() {
        return x + 40 * (float) Math.sin(angle);
    }

    public float getYForShot() {
        return y - 40 *(float) Math.cos(angle);
    }
    public float getAngleForShot(){
        return angle;
    }

    public void doShot () {
        if(currentRechargeTime == RECHARGE) {
            this.shot = true;
            currentRechargeTime = 0;
        }
    }

    public Layer getLayer() {

        layer.setImage(img);
        layer.setOrigin(img.width() / 2f, img.height() / 2f);
        layer.setTranslation(x, y);
        layer.setRotation(angle);
        if(Math.abs(angle/RADIAN_NUMBER_IN_360_DEGREE) > 1) angle = angle%RADIAN_NUMBER_IN_360_DEGREE;
        if(currentRechargeTime <RECHARGE) currentRechargeTime++;
//        System.out.println(currentRechargeTime);
//        System.out.println(angle);
        return layer;
    }

    public boolean getShot() {
        return shot;
    }

    public void setShotFalse(){
        this.shot = false;
    }

}
