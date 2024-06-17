package items;

import java.awt.*;

public interface needLandAble {
    void LandUpdate();
    void setGround(int newG);
    Rectangle floorSpace();
    int getHeight();
    int getWidth();
}