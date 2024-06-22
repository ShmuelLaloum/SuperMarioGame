package levels;

import items.*;
import java.util.List;

public interface level {
    void setMario();
    void addDefaultBrokenCubes();
    void addDefaultCastles();
    void addDefaultPenGoalPoles();
    void addDefaultLuckyCubes();
    void addDefaultGoombas();
    void addDefaultCubes();
    void addDefaultBillBlasters();
    void addDefaultCoins();
    void addDefaultBigTubes();
    void setStartPointX(int newStartPointX);
    void setEndPointX(int newEndPointX);
    Person getMario();
    List<mushroom> getMushrooms();
    int getCoinsRequired();
    List<Coin> getCoins();
    List<bigTube> getBigTubes();
    List<BillBlaster>  getBillBlasters();
    List<Cube> getCubes();
    List<goomba> getGoombas();
    List<luckyCube> getLuckyCubes();
    List<brokenCube> getBrokenCubes();
    List<PenGoalPole> getPenGoalPoles();
    List<castle> getCastles();
    int getStartPointX();
    int getEndPointX();
    boolean isBuilt();

}