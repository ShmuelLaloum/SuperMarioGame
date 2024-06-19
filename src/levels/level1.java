package levels;

import items.*;

import java.util.ArrayList;
import java.util.List;

public class level1 extends level{
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
    public static final int coinsRequired = 5;
    private int startPointX = 0;
    private int endPointX = 3000;
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
        mario = new Person(15,660);
    }
    public void addDefaultPenGoalPoles(){
        //penGoalPoles.add(new PenGoalPole(1000,0));
    }
    public void addDefaultCastles(){
        //castles.add(new castle(1200,0));
    }
    public void addDefaultBrokenCubes(){
        brokenCubes.add(new brokenCube(220,650));
        brokenCubes.add(new brokenCube(250,650));
        brokenCubes.add(new brokenCube(310,650));
        brokenCubes.add(new brokenCube(340,650));

    }
    public void addDefaultLuckyCubes(){
        luckyCubes.add(new luckyCube(280,650, luckyCube.type.redMushroom));
    }
    public void addDefaultGoombas(){
        goombas.add( new goomba(550, 590));
        goombas.add( new goomba(715, 683));
        goombas.add( new goomba(1110, 683));

    }
    public void addDefaultCubes(){
        for (int i = 0; i < 800 + 900+3000; i += 30) {
            cubes.add(new Cube(i, 803, Cube.type.LAND));
            cubes.add(new Cube(i, 773, Cube.type.LAND));
            cubes.add(new Cube(i, 743, Cube.type.GRASS));
        }
        cubes.add(new Cube(280,560, Cube.type.WOOD));
        cubes.add(new Cube(500,713, Cube.type.WOOD));
        cubes.add(new Cube(530,713, Cube.type.WOOD));
        cubes.add(new Cube(530,683, Cube.type.WOOD));
        cubes.add(new Cube(560,713, Cube.type.WOOD));
        cubes.add(new Cube(560,683, Cube.type.WOOD));
        cubes.add(new Cube(560,653, Cube.type.WOOD));

        cubes.add(new Cube(850,640, Cube.type.WOOD));
        cubes.add(new Cube(880,640, Cube.type.WOOD));
        cubes.add(new Cube(910,520, Cube.type.WOOD));
        cubes.add(new Cube(910,640, Cube.type.WOOD));
        cubes.add(new Cube(1100,640, Cube.type.WOOD));






    }
    public void addDefaultBillBlasters(){
        billBlasters.add(new BillBlaster(1090,590, BillBlaster.directionBill.left));
    }
    public void addDefaultCoins() {
        coins.add(new Coin(280, 528));

        coins.add(new Coin(848, 713));
        coins.add(new Coin(880, 713));
        coins.add(new Coin(912, 713));

        coins.add(new Coin(910, 487));
        coins.add(new Coin(1020, 447));
        coins.add(new Coin(1080, 517));



    }
    public void addDefaultBigTubes() {
        bigTubes.add(new bigTube(590, 618, 80, 215, bigTube.type.ground));
        bigTubes.add(new bigTube(1150, 618, 80, 215, bigTube.type.enemy));

    }

    public void setStartPointX(int newStartPointX) {
        startPointX = newStartPointX;
    }
    public void setEndPointX(int newEndPointX) {
        endPointX = newEndPointX;
    }
    public Person getMario(){
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
}