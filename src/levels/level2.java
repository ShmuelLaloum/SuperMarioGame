package levels;

import items.*;

import java.util.ArrayList;
import java.util.List;

public class level2 extends level{
    private final List<Coin> coins = new ArrayList<>();
    private final List<bigTube> bigTubes = new ArrayList<>();
    private final List<BillBlaster> billBlasters = new ArrayList<>();
    private final List<Cube> cubes = new ArrayList<>();
    private final List<goomba> goombas = new ArrayList<>();
    private final List<luckyCube> luckyCubes = new ArrayList<>();
    private final List<brokenCube> brokenCubes = new ArrayList<>();
    private final List<PenGoalPole> penGoalPoles = new ArrayList<>();
    private final List<castle> castles = new ArrayList<>();
    private Person mario;
    public static final int coinsRequired = 0;//need to change
    private int startPointX = 0;
    private int endPointX = 0;//need to change

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
    @Override
    public void setMario() {

    }

    @Override
    public void addDefaultBrokenCubes() {

    }

    @Override
    public void addDefaultCastles() {

    }

    @Override
    public void addDefaultPenGoalPoles() {

    }

    @Override
    public void addDefaultLuckyCubes() {

    }

    @Override
    public void addDefaultGoombas() {

    }

    @Override
    public void addDefaultCubes() {

    }

    @Override
    public void addDefaultBillBlasters() {

    }

    @Override
    public void addDefaultCoins() {

    }

    @Override
    public void addDefaultBigTubes() {

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
