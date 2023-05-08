public class Pieces {
    protected boolean isWhite;
    protected int posX;
    protected int posY;
  
    public Pieces(boolean isWhite, int posX, int posY) {
      this.isWhite = isWhite;
      this.posX = posX;
      this.posY = posY;
    }
  
    public void setWhite(boolean white) {
      isWhite = white;
    }
  
    public boolean isWhite() {
      return isWhite;
    }
  
    public void setPosX(int posX) {
      this.posX = posX;
    }
  
    public int getPosX() {
      return posX;
    }
  
    public void setPosY(int posY) {
      this.posY = posY;
    }
  
    public int getPosY() {
      return posY;
    }
  }
  