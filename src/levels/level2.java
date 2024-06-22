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
    private Person mario;
    public static final boolean built = true;
    public static final int coinsRequired = 15;
    private int startPointX = 0;
    private int endPointX = 2810;

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
        mario = new Person(15,660);
    }
    public void addDefaultPenGoalPoles(){
        penGoalPoles.add(new PenGoalPole(2450,300));
    }
    public void addDefaultCastles(){
        castles.add(new castle(2600,270));
    }
    public void addDefaultBrokenCubes(){
        brokenCubes.add(new brokenCube(220,650));
        brokenCubes.add(new brokenCube(250,650));
        brokenCubes.add(new brokenCube(310,650));
        brokenCubes.add(new brokenCube(340,650));

        brokenCubes.add(new brokenCube(1840,653));
        brokenCubes.add(new brokenCube(1900,653));

    }
    public void addDefaultLuckyCubes(){
        luckyCubes.add(new luckyCube(280,650, luckyCube.type.redMushroom));

        luckyCubes.add(new luckyCube(850,640, luckyCube.type.coin));
        luckyCubes.add(new luckyCube(880,640, luckyCube.type.coin));
        luckyCubes.add(new luckyCube(910,640, luckyCube.type.coin));

        luckyCubes.add(new luckyCube(1810,653, luckyCube.type.coin));
        luckyCubes.add(new luckyCube(1870,653, luckyCube.type.coin));


    }
    public void addDefaultGoombas(){
        goombas.add( new goomba(550, 590));
        goombas.add( new goomba(720, 683));
        goombas.add( new goomba(1110, 683));
        goombas.add( new goomba(1560, 613));
        goombas.add( new goomba(1900, 673));
    }
    public void addDefaultCubes(){
        for (int i = 0; i < 2840; i += 30) {
            if (i > 1550 && i < 1650){
                continue;
            }else if (i > 2070){
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
                cubes.add(new Cube(i, 533, Cube.type.LAND));
                cubes.add(new Cube(i, 503, Cube.type.LAND));
                cubes.add(new Cube(i, 473, Cube.type.GRASS));
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
        cubes.add(new Cube(280,560, Cube.type.WOOD));
        cubes.add(new Cube(500,713, Cube.type.WOOD));
        cubes.add(new Cube(530,713, Cube.type.WOOD));
        cubes.add(new Cube(530,683, Cube.type.WOOD));
        cubes.add(new Cube(560,713, Cube.type.WOOD));
        cubes.add(new Cube(560,683, Cube.type.WOOD));
        cubes.add(new Cube(560,653, Cube.type.WOOD));

        cubes.add(new Cube(910,520, Cube.type.WOOD));
        cubes.add(new Cube(1100,640, Cube.type.WOOD));

        cubes.add(new Cube(1470,713, Cube.type.WOOD));
        cubes.add(new Cube(1500,713, Cube.type.WOOD));
        cubes.add(new Cube(1530,713, Cube.type.WOOD));
        cubes.add(new Cube(1500,683, Cube.type.WOOD));
        cubes.add(new Cube(1530,683, Cube.type.WOOD));
        cubes.add(new Cube(1530,653, Cube.type.WOOD));

        cubes.add(new Cube(1650,713, Cube.type.WOOD));
        cubes.add(new Cube(1680,713, Cube.type.WOOD));
        cubes.add(new Cube(1710,713, Cube.type.WOOD));
        cubes.add(new Cube(1650,683, Cube.type.WOOD));
        cubes.add(new Cube(1680,683, Cube.type.WOOD));
        cubes.add(new Cube(1650,653, Cube.type.WOOD));

        cubes.add(new Cube(2010,713, Cube.type.WOOD));
        cubes.add(new Cube(2040,713, Cube.type.WOOD));
        cubes.add(new Cube(2070,713, Cube.type.WOOD));
        cubes.add(new Cube(2040,683, Cube.type.WOOD));
        cubes.add(new Cube(2070,683, Cube.type.WOOD));
        cubes.add(new Cube(2070,653, Cube.type.WOOD));

        cubes.add(new Cube(1870,505, Cube.type.WOOD));
        cubes.add(new Cube(1980,475, Cube.type.WOOD));



    }
    public void addDefaultBillBlasters(){
        billBlasters.add(new BillBlaster(1090,590, BillBlaster.directionBill.left));
        billBlasters.add(new BillBlaster(2060,603, BillBlaster.directionBill.left));
    }
    public void addDefaultCoins() {
        coins.add(new Coin(280, 528));

        coins.add(new Coin(848, 713));
        coins.add(new Coin(880, 713));
        coins.add(new Coin(912, 713));

        coins.add(new Coin(910, 487));
        coins.add(new Coin(1020, 447));
        coins.add(new Coin(1080, 517));

        coins.add(new Coin(1469, 681));
        coins.add(new Coin(1499, 651));

        coins.add(new Coin(1840, 711));
        coins.add(new Coin(1900, 711));

    }
    public void addDefaultBigTubes() {
        bigTubes.add(new bigTube(587, 629, 80, 115, bigTube.type.ground));
        bigTubes.add(new bigTube(1135, 629, 80, 115, bigTube.type.enemy));

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
    public Person getMario(){
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
