import java.util.*; 
public class Game {
  private Pieces board[][] = new Pieces[8][8];
  private int moves;
  private Pieces boardt[][] = new Pieces[8][8];
  public int getMoves() {
	 return moves;
  }
  public void setMoves(int moves) {
	 this.moves = moves;
  }
  public Game(int moves) {
  }
  public void addPawn(boolean isWhite, int posX, int posY, boolean doubleMove, boolean enpassent) {
    Pieces p = new Pawn(isWhite, posX, posY, doubleMove, enpassent);
    board[posY][posX] = p;
  }
  public void addKnight(boolean isWhite, int posX, int posY) {
    Pieces p = new Knight(isWhite, posX, posY);
    board[posY][posX] = p;
  }
  public void addBishop(boolean isWhite, int posX, int posY) {
    Pieces p = new Bishop(isWhite, posX, posY);
    board[posY][posX] = p;
  }
  public void addRook(boolean isWhite, int posX, int posY, boolean kasteling) {
    Pieces p = new Rook(isWhite, posX, posY, kasteling);
    board[posY][posX] = p;
  }
  public void addQueen(boolean isWhite, int posX, int posY) {
    Pieces p = new Queen(isWhite, posX, posY);
    board[posY][posX] = p;
  }
  public void addKing(boolean isWhite, int posX, int posY, boolean kasteling) {
    Pieces p = new King(isWhite, posX, posY, kasteling);
    board[posY][posX] = p;
  }
  public void getGame(){
    for (int j = 7; j >=0; j--) {
    if(j%2==0){
      System.out.println("______|      |______|      |______|      |______|      ");
    }else{
      System.out.println("      |______|      |______|      |______|      |______");
    }
      for (int i = 0; i < 8; i++) {
        if (board[j][i] != null) {
          if(board[j][i] instanceof Pawn){
            if(board[j][i].isWhite()){
              System.out.print("_PAWN_");
              if(((Pawn)board[j][i]).isEnpassent() && this.getMoves()%2==0){
                ((Pawn)board[j][i]).setEnpassent(false);
              }
            }else{
              System.out.print("_pawn_");
              if(((Pawn)board[j][i]).isEnpassent() && this.getMoves()%2!=0){
                ((Pawn)board[j][i]).setEnpassent(false);
              }
            }
          }else if(board[j][i] instanceof Bishop){
            if(board[j][i].isWhite()){
              System.out.print("BISHOP");
            } else{
              System.out.print("bishop");
            } 
          }else if(board[j][i] instanceof Knight){
            if(board[j][i].isWhite()){
              System.out.print("KNIGHT");
            } else{
              System.out.print("knight");
            }
          }else if(board[j][i] instanceof Rook){
            if(board[j][i].isWhite()){
              System.out.print("_ROOK_");
            } else{
              System.out.print("_rook_");
            }
          }else if(board[j][i] instanceof Queen){
            if(board[j][i].isWhite()){
              System.out.print("QUEEN_");
            } else{
              System.out.print("queen_");
            }
          }else if(board[j][i] instanceof King){
            if(board[j][i].isWhite()){
              System.out.print("_KING_");
            } else{
              System.out.print("_king_");
            }
          }
        }else{
          System.out.print("______");
        }
        if(i<7){
          System.out.print("|");
        }
      }
      System.out.println();
      if(j%2==0){
        System.out.println("______|      |______|      |______|      |______|      ");
      }else{
        System.out.println("      |______|      |______|      |______|      |______");
      }
      System.out.println();
    }
  }
  public boolean move( String move){
    boardt=board;
    if(move.length()!=5){
      System.out.println("Invalid Move");
      return false;
    }
    for(int i=0;i<5;i++){
      if(i!=2 && (move.charAt(i)>56 || move.charAt(i)<49)){
        System.out.println(i);
        return false;
      }
    }
    int x1=Character.getNumericValue(move.charAt(0))-1;
    int y1=Character.getNumericValue(move.charAt(1))-1;
    int x2=Character.getNumericValue(move.charAt(3))-1;
    int y2=Character.getNumericValue(move.charAt(4))-1;
    Pieces temp = board[y1][x1];
    if(temp==null){
      System.out.println("Invalid move");
      return false;
    }else if(temp.isWhite==false && this.getMoves() %2==0){
        System.out.println("It's White's turn!");
        return false;
      }else{
        if(temp.isWhite && this.getMoves() %2==1){
          System.out.println("It's Black's turn!");
          return false;
        }
      }
    if(temp instanceof Rook){
      if(x1==x2){
        if(y1<y2){
          for(int i = y1+1; i<y2;i++){
            if(board[i][x1]!=null){
              System.out.println("Invalid move");
              return false;
            }
          }
        }else{
          for(int i = y1-1; i>y2;i--){
            if(board[i][x1]!=null){
              System.out.println("Invalid move");
              return false;
            }
          }
        }
      }else if(y1==y2){
        if(x1<x2){
          for(int i = x1+1; i<x2;i++){
            if(board[y1][i]!=null){
              System.out.println("Invalid move");
              return false;
            }
          }
        }else{
          for(int i = x1-1; i>y2;i--){
            if(board[y1][i]!=null){
              System.out.println("Invalid move");
              return false;
            }
          }
        }
      }else{
        System.out.println("invalid move");
        return false;
      }
    }
    if(temp instanceof Pawn){
      if(x1==x2){
      	if(y2>=y1+2 && !((Pawn)temp).isDoubleMove() || y2<y1&& ((Pawn)temp).isWhite() || y2>y1&& !((Pawn)temp).isWhite()|| y2==y1+2 && ((Pawn)temp).isDoubleMove() && board[y1+1][x1]!=null){
          System.out.println("Invalid move");
          return false;
        }
        
      }else if(board[y1][x2]!=null && board[y1][x2] instanceof Pawn && ((Pawn)board[y1][x2]).isEnpassent() && board[y1][x2].isWhite != temp.isWhite){
        board[y1][x2] = null;
      }else if(board[y2][x2]!=null &&((temp.isWhite && y2==y1+1) 
              || (!temp.isWhite && y2==y1-1)) 
              && (x2==x1+1 || x2==x1-1) 
              && (board[y2][x2].isWhite != temp.isWhite)){
        
      }else{
        System.out.println("Invalid Move");
        return false;
      }
      if(y2==y1+2 || y2==y1-2){
        ((Pawn)temp).setEnpassent(true);
      }
    }
    if(temp instanceof King){
      if(x1==x2 && (y2==y1+1 || y2==y1-1) 
      || y1==y2 && (x2==x1+1 || x2==x1-1) 
      || x2==x1+1 && y2==y1+1 
      || x2==x1-1 && y2==y1+1 
      || x2==x1+1 && y2==y1-1 
      || x2==x1-1 && y2==y1-1){  
      }else if(y1==y2 && ((King)temp).isKasteling() &&  x2==x1+2 && board[y1][7] instanceof Rook && ((Rook)board[y1][7]).isKasteling() && board[y1][x1+1] == null && board[y1][x1+2] == null){
        board[y1][5]=board[y1][7];
        board[y1][7]=null;
      }else if(y1==y2 && ((King)temp).isKasteling() &&  x2==x1-2 && board[y1][0] instanceof Rook && ((Rook)board[y1][0]).isKasteling() && board[y1][x1-1] == null && board[y1][x1-2] == null){
        board[y1][3]=board[y1][0];
        board[y1][0]=null;
      }else{
        System.out.println("Invalid Move"); 
        return false;
      }
    }
    if(temp instanceof Knight){
      if(!((y2==y1+2 && (x2==x1+1 || x2==x1-1)) || (y2==y1-2 && (x2==x1+1 || x2==x1-1)) || (x2==x1+2 && (y2==y1+1 || y2==y1-1)) || (x2==x1-2 && (y2==y1+1 || y2==y1-1)))){
        System.out.print("Invalid Move");
        return false;
      }
    }
    if(temp instanceof Bishop){
      int tempx=0;
      int tempy=0;
      if(!(Math.abs(y1-y2)==Math.abs(x1-x2))){
        System.out.println("Invalid move");
        return false;
      }
      for(int i=1;i<Math.abs(y1-y2);i++){
        if(x1>x2){
          tempx =x1-i;
        }else{
          tempx =x1+i;
        }
        if(y1>y2){
          tempy =y1-i;
        }else{
          tempy =y1+i;
        }
        if(board[tempy][tempx]!=null){
          System.out.println("Invalid Move");
          return false;
        }
      }
    }
    if(temp instanceof Queen){
      int tempx=0;
      int tempy=0;
      if(Math.abs(y1-y2)==Math.abs(x1-x2)){
        for(int i=1;i<Math.abs(y1-y2);i++){
          if(x1>x2){
            tempx =x1-i;
          }else{
            tempx =x1+i;
          }
          if(y1>y2){
            tempy =y1-i;
          }else{
            tempy =y1+i;
          }
          if(board[tempy][tempx]!=null){
            System.out.println("Invalid Move");
            return false;
          }
        }  
      }else if(x1==x2){
        if(y1<y2){
          for(int i = y1+1; i<y2;i++){
            if(board[i][x1]!=null){
              System.out.println("Invalid move");
              return false;
            }
          }
        }else{
          for(int i = y1-1; i>y2;i--){
            if(board[i][x1]!=null){
              System.out.println("Invalid move");
              return false;
            }
          }
        }
      }else if(y1==y2){
        if(x1<x2){
          for(int i = x1+1; i<x2;i++){
            if(board[y1][i]!=null){
              System.out.println("Invalid move");
              return false;
            }
          }
        }else{
          for(int i = x1-1; i>y2;i--){
            if(board[y1][i]!=null){
              System.out.println("Invalid move");
              return false;
            }
          }
        }
      }else{
        System.out.println("invalid move");
        return false;
      }
      
    }
    if(board[y2][x2]!=null && temp.isWhite == board[y2][x2].isWhite){
      System.out.println("Invalid Move");
      return false;
    }
    /*if(this.isCheck()){
      System.out.println("You are currrently in check");
      boardt = board;
      return false;
    }*/
    board[y1][x1]=null;
    board[y2][x2]=temp;
    
    board = boardt;
    if(board[y2][x2] instanceof Rook){
      ((Rook)board[y2][x2]).setKasteling(false);
    }else if(board[y2][x2] instanceof King){
      ((King)board[y2][x2]).setKasteling(false);
    }else if(board[y2][x2] instanceof Pawn){
      ((Pawn)board[y2][x2]).setDoubleMove(false);
    }
    return true;
  }
  public boolean isCheckmate(){
    boolean whiteKing =false;
    boolean blackKing = false;
    for(int j=0;j<8;j++){
      for(int i = 0;i<8;i++){
        if(board[j][i] instanceof King){
          if(board[j][i].isWhite()){
            whiteKing=true;
          }else{
            blackKing=true;
          }
        }
      }
    }
    if(whiteKing == false){
      System.out.println("Black wins");
      return true;
    }else if(blackKing == false){
      System.out.println("White wins");
      return true;
    }else{
      return false;
    }
  }
  public boolean isCheck(){
      for(int y=0; y<8; y++){
        for(int x=0; x<8; x++){
          if(board[y][x] != null){
            if(!(board[y][x].isWhite) && this.getMoves()%2==0){
              if(board[y][x] instanceof Pawn ){
                if(y!=0 && x!=0 && y!=7 && x!=7 && (board[y-1][x-1] instanceof King && board[y-1][x-1].isWhite || board[y-1][x+1] instanceof King && board[y-1][x+1].isWhite)){
                  return true;
                }
              }
              if(board[y][x] instanceof Knight){
                if(y<6 && x<7 && board[y+2][x+1] instanceof King && board[y+2][x+1].isWhite  
                || y<6 && x>0 && board[y+2][x-1] instanceof King && board[y+2][x-1].isWhite 
                || y>2 && x>1 && board[y-2][x-1] instanceof King && board[y-2][x-1].isWhite
                || y>2 && x<7 && board[y-2][x+1] instanceof King && board[y-2][x+1].isWhite 
                || y<7 && x<6 && board[y+1][x+2] instanceof King && board[y+1][x+2].isWhite 
                || y>1 && x<6 && board[y-1][x+2] instanceof King && board[y-1][x+2].isWhite 
                || y<7 && x>2 && board[y+1][x-2] instanceof King && board[y+1][x-2].isWhite 
                || y>1 && x>2 && board[y-1][x-2] instanceof King && board[y-1][x-2].isWhite ){
                  return true;
                }
              }
              if(board[y][x] instanceof Rook){
                boolean xm = true;
                boolean xp = true;
                boolean ym = true;
                boolean yp = true;
                for(int i=0; i<8 ; i++){
                  if(xp && x+i<8 && board[y][x+i] != null){
                    
                    if(board[y][x+i] instanceof King && board[y][x+i].isWhite) return true;
                    xp = false;
                  } 
                  if(xm && x-i>=0 && board[y][x-i] != null){
                    
                    if(board[y][x-i] instanceof King && board[y][x-i].isWhite) return true;
                    xm = false;
                  }
                  if(yp && y+i<8 && board[y+i][x] != null){
                    
                    if(board[y+i][x] instanceof King && board[y+i][x].isWhite) return true;
                    yp = false;
                  }
                  if(ym && y-i>=0 && board[y-i][x] != null){
                    
                    if(board[y-i][x] instanceof King && board[y-i][x].isWhite) return true;
                    ym = false;
                  }
                }

              }
              if(board[y][x] instanceof Bishop){

              }
              if(board[y][x] instanceof Queen){}
            }else if(board[y][x].isWhite && this.getMoves()%2!=0){

            }
          }
        }
      }
      return false;
    }
  public static void main(String[] args) {
    boolean gameRunning = true;
    Game g = new Game(0);
    //White pieces
    for (int i = 0; i < 8; i++) {
      g.addPawn(true, i, 1, true, false);
    }
    g.addRook(true, 0, 0, true);
    g.addRook(true, 7, 0, true);
    g.addKnight(true, 1, 0);
    g.addKnight(true, 6, 0);
    g.addBishop(true, 2, 0);
    g.addBishop(true, 5, 0);
    g.addKing(true, 4, 0, true);
    g.addQueen(true, 3, 0);
    
    for (int i = 0; i < 8; i++) {
      g.addPawn(false, i, 6, true, false);
    }
    g.addRook(false, 0, 7, true);
    g.addRook(false, 7, 7, true);
    g.addKnight(false, 1, 7);
    g.addKnight(false, 6, 7);
    g.addBishop(false, 2, 7);
    g.addBishop(false, 5, 7);
    g.addKing(false, 4, 7, true);
    g.addQueen(false, 3, 7);
    
    while(gameRunning){
      g.getGame();
      Scanner sc= new Scanner(System.in);
      System.out.println("Please enter your next move (in format posXposY_pos2Xpos2Y): ");
      String str= sc.nextLine();
      if(str.equals("stop")){
        System.out.println("Game ended in remis");
        gameRunning = false;
        sc.close();
        return;
      }
      if(g.move(str)){
        g.setMoves(g.getMoves()+1);
      }
      if(g.isCheckmate()){
        gameRunning = false;
        sc.close();
        g.getGame();
      }
    }
  }
}