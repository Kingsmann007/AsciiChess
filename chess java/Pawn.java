public class Pawn extends Pieces {
    boolean doubleMove;
  
    public Pawn(boolean isWhite, int posX, int posY, boolean doubleMove) {
      super(isWhite, posX, posY);
      this.doubleMove = doubleMove;
    }
  
    public boolean isDoubleMove() {
      return doubleMove;
    }
  
    public void setDoubleMove(boolean doubleMove) {
      this.doubleMove = doubleMove;
    }
  }
  