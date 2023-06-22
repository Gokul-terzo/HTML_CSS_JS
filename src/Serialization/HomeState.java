package Serialization;

import java.io.Serializable;

public class HomeState implements Serializable {
    private int chairCount;
    private String wallColour;
    private String sofaState;
    private int windowGlassesBroken;
    private String tvModel;

    public HomeState(int chairCount, String wallColour, String sofaState, int windowGlassesBroken, String tvModel) {
        this.chairCount = chairCount;
        this.wallColour = wallColour;
        this.sofaState = sofaState;
        this.windowGlassesBroken = windowGlassesBroken;
        this.tvModel = tvModel;
    }

    @Override
    public String toString() {
        return "HomeState{" +
                "chairCount=" + chairCount +
                ", wallColour='" + wallColour + '\'' +
                ", sofaState='" + sofaState + '\'' +
                ", windowGlassesBroken=" + windowGlassesBroken +
                ", tvModel='" + tvModel + '\'' +
                '}';
    }
}
