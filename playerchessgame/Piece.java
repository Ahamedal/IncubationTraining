package playerchessgame;

public class Piece {

	private String pieceName;
	private String pieceType;
	private boolean killed=false;
	
	public String getPieceName() {
		return pieceName;
	}
	public void setPieceName(String pieceName) {
		this.pieceName = pieceName;
	}
	public String getPieceType() {
		return pieceType;
	}
	public void setPieceType(String pieceType) {
		this.pieceType = pieceType;
	}
	public boolean isKilled() {
		return killed;
	}
	public void setKilled(boolean killed) {
		this.killed = killed;
	}
	
	
}
