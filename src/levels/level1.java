package levels;

import items.*;

import java.util.ArrayList;
import java.util.List;

public class level1 implements level{
    private final List<Coin> coins = new ArrayList<>();
    private final List<bigTube> bigTubes = new ArrayList<>();
    private final List<BillBlaster> billBlasters = new ArrayList<>();
    private final List<Cube> cubes = new ArrayList<>();
    private final List<goomba> goombas = new ArrayList<>();
    private final List<luckyCube> luckyCubes = new ArrayList<>();
    private final List<brokenCube> brokenCubes = new ArrayList<>();
    private final List<PenGoalPole> penGoalPoles = new ArrayList<>();
    private final List<castle> castles = new ArrayList<>();
    private final List<mushroom> mushrooms = new ArrayList<>();
    private Mario mario;
    public static final boolean built = true;
    public static final int coinsRequired = 20;
    private int startPointX = 0;
    private int endPointX = 2620;
    public level1() {
        setMario();
        addDefaultPenGoalPoles();
        addDefaultCoins();
        addDefaultBigTubes();
        addDefaultBillBlasters();
        addDefaultCubes();
        addDefaultGoombas();
        addDefaultLuckyCubes();
        addDefaultBrokenCubes();
        addDefaultCastles();
    }
    public void setMario(){
        mario = new Mario(15,660);
    }
    public void addDefaultPenGoalPoles(){
        penGoalPoles.add(new PenGoalPole(2180,583));
    }
    public void addDefaultCastles(){
        castles.add(new castle(2300,513));
    }
    public void addDefaultBrokenCubes(){
        brokenCubes.add(new brokenCube(205,200));
        brokenCubes.add(new brokenCube(235,200));
    }
    public void addDefaultLuckyCubes(){
        luckyCubes.add(new luckyCube(460,365, luckyCube.type.coin));
        luckyCubes.add(new luckyCube(415,80, luckyCube.type.coin));
        luckyCubes.add(new luckyCube(1300,660, luckyCube.type.redMushroom));
    }
    public void addDefaultGoombas(){
        goombas.add( new goomba(427, 444));
        goombas.add( new goomba(243, 235));
        goombas.add( new goomba(630, 670));
        goombas.add( new goomba(900, 670));
        goombas.add( new goomba(1100, 670));
        goombas.add( new goomba(1530, 670));
    }
    public void addDefaultCubes(){
        for (int i = 0; i < 2830; i += 30) {
            cubes.add(new Cube(i, 941, Cube.type.LAND));
            cubes.add(new Cube(i, 920, Cube.type.LAND));
            cubes.add(new Cube(i, 893, Cube.type.LAND));
            cubes.add(new Cube(i, 863, Cube.type.LAND));
            cubes.add(new Cube(i, 833, Cube.type.LAND));
            cubes.add(new Cube(i, 803, Cube.type.LAND));
            cubes.add(new Cube(i, 773, Cube.type.LAND));
            cubes.add(new Cube(i, 743, Cube.type.GRASS));
        }
        cubes.add(new Cube(250,645, Cube.type.WOOD));
        cubes.add(new Cube(280,615, Cube.type.WOOD));
        cubes.add(new Cube(310,585, Cube.type.WOOD));
        cubes.add(new Cube(340,555, Cube.type.WOOD));
        cubes.add(new Cube(370,525, Cube.type.WOOD));
        cubes.add(new Cube(400,495, Cube.type.WOOD));
        cubes.add(new Cube(430,495, Cube.type.WOOD));
        cubes.add(new Cube(460,495, Cube.type.WOOD));
        cubes.add(new Cube(460,465, Cube.type.WOOD));

        cubes.add(new Cube(355,410, Cube.type.WOOD));
        cubes.add(new Cube(325,380, Cube.type.WOOD));
        cubes.add(new Cube(295,350, Cube.type.WOOD));
        cubes.add(new Cube(265,320, Cube.type.WOOD));
        cubes.add(new Cube(235,290, Cube.type.WOOD));
        cubes.add(new Cube(205,290, Cube.type.WOOD));
        cubes.add(new Cube(175,290, Cube.type.WOOD));
        cubes.add(new Cube(175,260, Cube.type.WOOD));
        cubes.add(new Cube(175,230, Cube.type.WOOD));
        cubes.add(new Cube(175,200, Cube.type.WOOD));
        cubes.add(new Cube(265,200, Cube.type.WOOD));
        cubes.add(new Cube(295,200, Cube.type.WOOD));
        cubes.add(new Cube(325,200, Cube.type.WOOD));
        cubes.add(new Cube(355,200, Cube.type.WOOD));
        cubes.add(new Cube(385,200, Cube.type.WOOD));
        cubes.add(new Cube(415,200, Cube.type.WOOD));
        cubes.add(new Cube(445,200, Cube.type.WOOD));
        cubes.add(new Cube(445,170, Cube.type.WOOD));
        cubes.add(new Cube(445,140, Cube.type.WOOD));
        cubes.add(new Cube(445,110, Cube.type.WOOD));
        cubes.add(new Cube(445,80, Cube.type.WOOD));

        cubes.add(new Cube(550,713, Cube.type.WOOD));
        cubes.add(new Cube(550,683, Cube.type.WOOD));

        cubes.add(new Cube(915,713, Cube.type.WOOD));
        cubes.add(new Cube(945,713, Cube.type.WOOD));
        cubes.add(new Cube(945,683, Cube.type.WOOD));

        cubes.add(new Cube(1570,713, Cube.type.WOOD));
        cubes.add(new Cube(1600,713, Cube.type.WOOD));
        cubes.add(new Cube(1630,713, Cube.type.WOOD));
        cubes.add(new Cube(1660,713, Cube.type.WOOD));
        cubes.add(new Cube(1690,713, Cube.type.WOOD));
        cubes.add(new Cube(1720,713, Cube.type.WOOD));
        cubes.add(new Cube(1600,683, Cube.type.WOOD));
        cubes.add(new Cube(1630,683, Cube.type.WOOD));
        cubes.add(new Cube(1630,653, Cube.type.WOOD));
        cubes.add(new Cube(1660,683, Cube.type.WOOD));
        cubes.add(new Cube(1660,653, Cube.type.WOOD));
        cubes.add(new Cube(1660,623, Cube.type.WOOD));
        cubes.add(new Cube(1690,683, Cube.type.WOOD));
        cubes.add(new Cube(1690,653, Cube.type.WOOD));
        cubes.add(new Cube(1690,623, Cube.type.WOOD));
        cubes.add(new Cube(1690,593, Cube.type.WOOD));
        cubes.add(new Cube(1720,683, Cube.type.WOOD));
        cubes.add(new Cube(1720,653, Cube.type.WOOD));
        cubes.add(new Cube(1720,623, Cube.type.WOOD));
        cubes.add(new Cube(1720,593, Cube.type.WOOD));
        cubes.add(new Cube(1720,563, Cube.type.WOOD));

        cubes.add(new Cube(1270,660, Cube.type.WOOD));
        cubes.add(new Cube(1330,660, Cube.type.WOOD));
    }
    public void addDefaultBillBlasters(){
        billBlasters.add(new BillBlaster(165,140, BillBlaster.directionBill.right));
        billBlasters.add(new BillBlaster(1590,633, BillBlaster.directionBill.left));
    }
    public void addDefaultCoins() {
        coins.add(new Coin(249, 614));
        coins.add(new Coin(279, 584));
        coins.add(new Coin(309, 554));
        coins.add(new Coin(339, 524));
        coins.add(new Coin(369, 494));

        coins.add(new Coin(356, 379));
        coins.add(new Coin(326, 349));
        coins.add(new Coin(296, 319));
        coins.add(new Coin(266, 289));

        coins.add(new Coin(730, 712));
        coins.add(new Coin(761, 712));

        coins.add(new Coin(265, 168));
        coins.add(new Coin(265, 137));
        coins.add(new Coin(295, 168));
        coins.add(new Coin(295, 137));
        coins.add(new Coin(325, 168));
        coins.add(new Coin(325, 137));
        coins.add(new Coin(355, 168));
        coins.add(new Coin(355, 137));
        coins.add(new Coin(385, 168));
        coins.add(new Coin(385, 137));
        coins.add(new Coin(415, 168));
        coins.add(new Coin(415, 137));








    }
    public void addDefaultBigTubes() {
        bigTubes.add(new bigTube(970, 663, 80, 80, bigTube.type.enemy));
    }

    public void setStartPointX(int newStartPointX) {
        startPointX = newStartPointX;
    }
    public void setEndPointX(int newEndPointX) {
        endPointX = newEndPointX;
    }
    public Mario getMario(){
        return mario;
    }
    public List<mushroom> getMushrooms(){
        return mushrooms;
    }
    public List<Coin> getCoins() {
        return coins;
    }
    public List<bigTube> getBigTubes() {
        return bigTubes;
    }
    public List<BillBlaster> getBillBlasters() {
        return billBlasters;
    }
    public List<Cube> getCubes(){
        return cubes;
    }
    public List<goomba> getGoombas(){
        return goombas;
    }
    public List<luckyCube> getLuckyCubes(){
        return luckyCubes;
    }
    public List<brokenCube> getBrokenCubes(){
        return brokenCubes;
    }
    public List<PenGoalPole> getPenGoalPoles(){
        return penGoalPoles;
    }
    public List<castle> getCastles(){
        return castles;
    }
    public int getCoinsRequired(){
        return coinsRequired;
    }
    public int getStartPointX(){
        return startPointX;
    }
    public int getEndPointX(){
        return endPointX;
    }
    public boolean isBuilt(){
        return built;
    }
}