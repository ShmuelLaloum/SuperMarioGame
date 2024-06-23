package levels;

import items.*;

import java.util.ArrayList;
import java.util.List;

public class level2 implements level{
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
    public static final int coinsRequired = 25;
    private int startPointX = 0;
    private int endPointX = 2750;

    public level2(){
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
        penGoalPoles.add(new PenGoalPole(2350,370));
    }
    public void addDefaultCastles(){
       castles.add(new castle(2500,300));
    }
    public void addDefaultBrokenCubes(){
        brokenCubes.add(new brokenCube(220,650));
        brokenCubes.add(new brokenCube(250,650));
        brokenCubes.add(new brokenCube(310,650));
        brokenCubes.add(new brokenCube(340,650));
    }
    public void addDefaultLuckyCubes(){
        luckyCubes.add(new luckyCube(280,650, luckyCube.type.redMushroom));
        luckyCubes.add(new luckyCube(280,530, luckyCube.type.coin));
    }
    public void addDefaultGoombas(){
        goombas.add( new goomba(430, 680));
        goombas.add( new goomba(630, 680));
        goombas.add( new goomba(930, 680));
        goombas.add( new goomba(1180, 680));
        goombas.add( new goomba(1480, 389));
        goombas.add( new goomba(1710, 459));
        goombas.add( new goomba(1940, 529));
    }
    public void addDefaultCubes(){
        for (int i = 0; i < 2860; i += 30) {
            if (i >= 2020){
                cubes.add(new Cube(i, 941, Cube.type.LAND));
                cubes.add(new Cube(i, 920, Cube.type.LAND));
                cubes.add(new Cube(i, 893, Cube.type.LAND));
                cubes.add(new Cube(i, 863, Cube.type.LAND));
                cubes.add(new Cube(i, 833, Cube.type.LAND));
                cubes.add(new Cube(i, 803, Cube.type.LAND));
                cubes.add(new Cube(i, 773, Cube.type.LAND));
                cubes.add(new Cube(i, 743, Cube.type.LAND));
                cubes.add(new Cube(i, 713, Cube.type.LAND));
                cubes.add(new Cube(i, 683, Cube.type.LAND));
                cubes.add(new Cube(i, 653, Cube.type.LAND));
                cubes.add(new Cube(i, 623, Cube.type.LAND));
                cubes.add(new Cube(i, 593, Cube.type.LAND));
                cubes.add(new Cube(i, 563, Cube.type.LAND));
                cubes.add(new Cube(i, 540, Cube.type.GRASS));
            }else {
                cubes.add(new Cube(i, 941, Cube.type.LAND));
                cubes.add(new Cube(i, 920, Cube.type.LAND));
                cubes.add(new Cube(i, 893, Cube.type.LAND));
                cubes.add(new Cube(i, 863, Cube.type.LAND));
                cubes.add(new Cube(i, 833, Cube.type.LAND));
                cubes.add(new Cube(i, 803, Cube.type.LAND));
                cubes.add(new Cube(i, 773, Cube.type.LAND));
                cubes.add(new Cube(i, 743, Cube.type.GRASS));
            }
        }
        cubes.add(new Cube(500,713, Cube.type.WOOD));
        cubes.add(new Cube(530,713, Cube.type.WOOD));
        cubes.add(new Cube(530,683, Cube.type.WOOD));

        cubes.add(new Cube(800,600, Cube.type.WOOD));
        cubes.add(new Cube(770,600, Cube.type.WOOD));

        cubes.add(new Cube(1170,520, Cube.type.WOOD));
        cubes.add(new Cube(1170,490, Cube.type.WOOD));
        cubes.add(new Cube(1140,520, Cube.type.WOOD));
        cubes.add(new Cube(1140,610, Cube.type.WOOD));

        cubes.add(new Cube(800,460, Cube.type.WOOD));

        cubes.add(new Cube(1190,363, Cube.type.WOOD));

        cubes.add(new Cube(1430,400, Cube.type.WOOD));
        cubes.add(new Cube(1430,430, Cube.type.WOOD));
        cubes.add(new Cube(1460,430, Cube.type.WOOD));
        cubes.add(new Cube(1490,430, Cube.type.WOOD));
        cubes.add(new Cube(1520,430, Cube.type.WOOD));
        cubes.add(new Cube(1550,430, Cube.type.WOOD));
        cubes.add(new Cube(1550,400, Cube.type.WOOD));

        cubes.add(new Cube(1660,470, Cube.type.WOOD));
        cubes.add(new Cube(1660,500, Cube.type.WOOD));
        cubes.add(new Cube(1690,500, Cube.type.WOOD));
        cubes.add(new Cube(1720,500, Cube.type.WOOD));
        cubes.add(new Cube(1750,500, Cube.type.WOOD));
        cubes.add(new Cube(1780,500, Cube.type.WOOD));
        cubes.add(new Cube(1780,470, Cube.type.WOOD));

        cubes.add(new Cube(1890,540, Cube.type.WOOD));
        cubes.add(new Cube(1890,570, Cube.type.WOOD));
        cubes.add(new Cube(1920,570, Cube.type.WOOD));
        cubes.add(new Cube(1950,570, Cube.type.WOOD));
        cubes.add(new Cube(1980,570, Cube.type.WOOD));
        cubes.add(new Cube(2010,570, Cube.type.WOOD));
        cubes.add(new Cube(2010,540, Cube.type.WOOD));
    }
    public void addDefaultBillBlasters(){
        billBlasters.add(new BillBlaster(1130,550, BillBlaster.directionBill.left));
        billBlasters.add(new BillBlaster(790,400, BillBlaster.directionBill.right));
    }
    public void addDefaultCoins() {
        coins.add(new Coin(219, 712));
        coins.add(new Coin(250, 712));
        coins.add(new Coin(281, 712));
        coins.add(new Coin(312, 712));
        coins.add(new Coin(343, 712));

        coins.add(new Coin(800, 569));
        coins.add(new Coin(769, 569));

        coins.add(new Coin(670, 712));
        coins.add(new Coin(701, 712));

        coins.add(new Coin(912, 712));
        coins.add(new Coin(943, 712));

        coins.add(new Coin(1154, 712));
        coins.add(new Coin(1185, 712));

        coins.add(new Coin(1170, 459));
        coins.add(new Coin(1139, 489));

        coins.add(new Coin(1460, 399));
        coins.add(new Coin(1490, 399));
        coins.add(new Coin(1520, 399));

        coins.add(new Coin(1690, 469));
        coins.add(new Coin(1720, 469));
        coins.add(new Coin(1750, 469));

        coins.add(new Coin(1920, 539));
        coins.add(new Coin(1950, 539));
        coins.add(new Coin(1980, 539));
    }
    public void addDefaultBigTubes() {
        bigTubes.add(new bigTube(550, 663, 80, 80, bigTube.type.enemy));
        bigTubes.add(new bigTube(1220, 363, 92, 380, bigTube.type.enemy));
    }
    public void setStartPointX(int newStartPointX) {
        startPointX = newStartPointX;
    }
    public void setEndPointX(int newEndPointX) {
        endPointX = newEndPointX;
    }
    public List<mushroom> getMushrooms(){
        return mushrooms;
    }
    public Mario getMario(){
        return mario;
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
