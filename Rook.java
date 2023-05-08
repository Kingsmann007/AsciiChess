public class Rook extends Pieces{
    private boolean kasteling;
    public Rook(boolean isWhite, int posX, int posY, boolean kasteling){
        super(isWhite, posX, posY);
        this.kasteling=kasteling;
    }
    public void setKasteling(boolean kasteling){
        this.kasteling=kasteling;
    }

    public boolean isKasteling() {
        return kasteling;
    }
}
