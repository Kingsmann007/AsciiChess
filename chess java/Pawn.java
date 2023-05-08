public class Pawn extends Pieces {
    private boolean doubleMove;
    private boolean enpassent;
  
    public Pawn(boolean isWhite, int posX, int posY, boolean doubleMove, boolean enpassent) {
        super(isWhite, posX, posY);
        this.doubleMove = doubleMove;
        this.enpassent = enpassent;
    }

    public boolean isEnpassent() {
      return enpassent;
    }

    public void setEnpassent(boolean enpassent) {
      this.enpassent = enpassent;
    }
  
    public boolean isDoubleMove() {
      return doubleMove;
    }
  
    public void setDoubleMove(boolean doubleMove) {
      this.doubleMove = doubleMove;
    }
  }
  