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
    private int endPointX = 3500;
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
        mario = new Person(15,100);
    }
    public void addDefaultPenGoalPoles(){
        penGoalPoles.add(new PenGoalPole(1000,0));
    }
    public void addDefaultCastles(){
        castles.add(new castle(1200,0));
    }
    public void addDefaultBrokenCubes(){
        brokenCubes.add(new brokenCube(80,200));
    }
    public void addDefaultLuckyCubes(){
        luckyCubes.add(new luckyCube(80,320, luckyCube.type.redMushroom));
    }
    public void addDefaultGoombas(){
        goombas.add( new goomba(730, 0));
    }
    public void addDefaultCubes(){
        for (int i = 0; i < 800 + 900+3000; i += 30) {
            cubes.add(new Cube(i, 600 - 67, Cube.type.GRASS));
        }
        cubes.add(new Cube(50,320, Cube.type.WOOD));
        cubes.add(new Cube(20,290, Cube.type.WOOD));
        cubes.add(new Cube(110,320, Cube.type.WOOD));
        cubes.add(new Cube(80, 470, Cube.type.WOOD));
        cubes.add(new Cube(180, 450, Cube.type.WOOD));
        cubes.add(new Cube(230, 400, Cube.type.WOOD));
        cubes.add(new Cube(120, 400, Cube.type.WOOD));
        cubes.add(new Cube(280, 350, Cube.type.WOOD));
        cubes.add(new Cube(330, 350, Cube.type.WOOD));
        cubes.add(new Cube(430, 350, Cube.type.WOOD));
        cubes.add(new Cube(480, 350, Cube.type.WOOD));
        cubes.add(new Cube(480, 300, Cube.type.WOOD));
        cubes.add(new Cube(530, 250, Cube.type.WOOD));
        cubes.add(new Cube(580, 250, Cube.type.WOOD));
        cubes.add(new Cube(630, 250, Cube.type.WOOD));
        cubes.add(new Cube(680, 250, Cube.type.WOOD));
        cubes.add(new Cube(730, 250, Cube.type.WOOD));
        cubes.add(new Cube(780, 250, Cube.type.WOOD));
    }
    public void addDefaultBillBlasters(){
        //billBlasters.add(new BillBlaster(720,200, BillBlaster.directionBill.left));
    }
    public void addDefaultCoins() {
        coins.add(new Coin(330, 315));
        coins.add(new Coin(430, 315));
        coins.add(new Coin(480, 265));
        coins.add(new Coin(530, 215));
        coins.add(new Coin(580, 215));
        coins.add(new Coin(630, 215));
        coins.add(new Coin(680, 215));
        coins.add(new Coin(730, 215));
        coins.add(new Coin(780, 215));
    }
    public void addDefaultBigTubes() {
        bigTubes.add(new bigTube(300, 450, 80, 130, bigTube.type.enemy));
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