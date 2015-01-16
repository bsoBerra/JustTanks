package first.core;

import playn.core.GroupLayer;
import playn.core.Layer;
import playn.core.Surface;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Berdniky on 14.01.2015.
 */
public class TankWorld {
    TankObjekt tankObjekt;
    List<TankShell> shells = new ArrayList<TankShell>();

    public void addTank (TankObjekt tankObjekt) {
        this.tankObjekt = tankObjekt;
    }

    public void paint(Surface surface, GroupLayer groupLayer) {
        groupLayer.add(tankObjekt.getLayer());
        if (tankObjekt.getShot()) {
            shells.add(new TankShell(tankObjekt.getXForShot(), tankObjekt.getYForShot(), tankObjekt.getAngleForShot()));
            tankObjekt.setShotFalse();
        }
        if(shells.size()>0) {
            Iterator<TankShell> shellIter = shells.iterator();
            while (shellIter.hasNext()){
                TankShell tankShell = shellIter.next();
                Layer shellLayer = tankShell.getLayer();
                if(tankShell.shellExist()){
                    groupLayer.add(shellLayer);
                    System.out.println(shells.size());
                } else {
                    shellIter.remove();
                }
            }
        }
        surface.drawLayer(groupLayer);
    }

}
