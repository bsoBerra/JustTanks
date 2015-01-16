package first.core;

import playn.core.*;

import java.util.ArrayList;
import java.util.List;

import static playn.core.PlayN.*;

public class Game extends playn.core.Game.Default implements Keyboard.Listener {

    public Game() {
        super(33);
    }
    TankObjekt tankObject;
    TankWorld tankWorld = new TankWorld();
    TankShell tankShell;
    private List<TankShell> shells = new ArrayList<TankShell>();
    private boolean controlLeft, controlRight, controlUp, controlDown, controlSpace;

    @Override
    public void init() {
        keyboard().setListener(this);
        int width = 640;
        int height = 480;
        CanvasImage bgImage = graphics().createImage(width, height);
        Canvas canvas = bgImage.canvas();
        canvas.setFillColor(0xff87ceeb);
        canvas.fillRect(0, 0, width, height);
        ImageLayer bg = graphics().createImageLayer(bgImage);

        graphics().rootLayer().add(bg);

        ImmediateLayer gameLayer = graphics().createImmediateLayer(new ImmediateLayer.Renderer() {
            public void render(Surface surface) {
                surface.clear();
                tankWorld.paint(surface, graphics().createGroupLayer());
            }
        });
        graphics().rootLayer().add(gameLayer);
        initStuff();
    }

    private void initStuff() {
        tankObject = new TankObjekt();
        tankWorld.addTank(tankObject);
    }
    private void shot() {
        new TankShell(tankObject.getXForShot(), tankObject.getYForShot(), tankObject.getAngleForShot());
    }

    @Override
    public void onKeyDown(Keyboard.Event event) {

        switch (event.key()) {
            case LEFT:
                controlLeft = true;
                break;
            case UP:
                controlUp = true;
                break;
            case RIGHT:
                controlRight = true;
                break;
            case DOWN:
                controlDown = true;
                break;
            case SPACE:
                controlSpace = true;
                break;
            default:
                break; // nada
        }
    }
    @Override
    public void onKeyTyped(Keyboard.TypedEvent event) {
        // nada
    }

    @Override
    public void onKeyUp(Keyboard.Event event) {
        switch (event.key()) {
            case LEFT:
                controlLeft = false;
                break;
            case UP:
                controlUp = false;
                break;
            case RIGHT:
                controlRight = false;
                break;
            case DOWN:
                controlDown = false;
                break;
            case SPACE:
                controlSpace = false;
                break;
            default:
                break; // nada
        }
    }

    @Override
    public void update(int delta) {
        // Keyboard control.
        if (controlLeft) {
           tankObject.moveLeft();
        }
        if (controlRight) {
            tankObject.moveRight();
        }
        if (controlUp) {
            tankObject.moveUp();
        }
        if (controlDown) {
            tankObject.moveDown();
        }

        if (controlSpace){
            tankObject.doShot();
            controlSpace = false;
        }
    }

    @Override
    public void paint(float alpha) {
    }
}
