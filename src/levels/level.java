package levels;

import items.*;
import java.util.List;

public abstract class level {
    public abstract void setMario();
    public abstract void addDefaultBrokenCubes();
    public abstract void addDefaultCastles();
    public abstract void addDefaultPenGoalPoles();
    public abstract void addDefaultLuckyCubes();
    public abstract void addDefaultGoombas();
    public abstract void addDefaultCubes();
    public abstract void addDefaultBillBlasters();
    public abstract void addDefaultCoins();
    public abstract void addDefaultBigTubes();
    public abstract void setStartPointX(int newStartPointX);
    public abstract void setEndPointX(int newEndPointX);
    public abstract Person getMario();
    public abstract int getCoinsRequired();
    public abstract List<Coin> getCoins();
    public abstract List<bigTube> getBigTubes();
    public abstract  List<BillBlaster>  getBillBlasters();
    public abstract List<Cube> getCubes();
    public abstract List<goomba> getGoombas();
    public abstract List<luckyCube> getLuckyCubes();
    public abstract List<brokenCube> getBrokenCubes();
    public abstract List<PenGoalPole> getPenGoalPoles();
    public abstract List<castle> getCastles();
    public abstract int getStartPointX();
    public abstract int getEndPointX();

}