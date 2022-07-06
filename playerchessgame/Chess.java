package playerchessgame;

import java.util.Map;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Chess {
	int blackKingMove = 0;
	int whiteKingMove = 0;
	int blackRookLeftMove = 0;                        // For castling
	int blackRookRightMove = 0;
	int whiteRookLeftMove = 0;
	int whiteRookRightMove = 0;
	
	Map<String, String> chessBoard = new HashMap<>();
	Map<String, List<String>> coinPositions = new HashMap<>();
	List<String> recordingMoves = new ArrayList<>();
	
	FileLayer fl=new FileLayer();

	void initialSetUp() {
		chessBoard.put("a1", "W_R");
		addCoinPosition("W_R", "a1");
		chessBoard.put("b1", "W_N");
		addCoinPosition("W_N", "b1");
		chessBoard.put("c1", "W_B");
		addCoinPosition("W_B", "c1");
		chessBoard.put("d1", "W_Q");
		addCoinPosition("W_Q", "d1");
		chessBoard.put("e1", "W_K");
		addCoinPosition("W_K", "e1");
		chessBoard.put("f1", "W_B");
		addCoinPosition("W_B", "f1");
		chessBoard.put("g1", "W_N");
		addCoinPosition("W_N", "g1");
		chessBoard.put("h1", "W_R");
		addCoinPosition("W_R", "h1");
		chessBoard.put("a2", "W_P");
		addCoinPosition("W_P", "a2");
		chessBoard.put("b2", "W_P");
		addCoinPosition("W_P", "b2");
		chessBoard.put("c2", "W_P");
		addCoinPosition("W_P", "c2");
		chessBoard.put("d2", "W_P");
		addCoinPosition("W_P", "d2");
		chessBoard.put("e2", "W_P");
		addCoinPosition("W_P", "e2");
		chessBoard.put("f2", "W_P");
		addCoinPosition("W_P", "f2");
		chessBoard.put("g2", "W_P");
		addCoinPosition("W_P", "g2");
		chessBoard.put("h2", "W_P");
		addCoinPosition("W_P", "h2");
		chessBoard.put("a3", null);

		chessBoard.put("b3", null);

		chessBoard.put("c3", null);

		chessBoard.put("d3", null);

		chessBoard.put("e3", null);

		chessBoard.put("f3", null);

		chessBoard.put("g3", null);

		chessBoard.put("h3", null);

		chessBoard.put("a4", null);

		chessBoard.put("b4", null);

		chessBoard.put("c4", null);

		chessBoard.put("d4", null);

		chessBoard.put("e4", null);

		chessBoard.put("f4", null);

		chessBoard.put("g4", null);

		chessBoard.put("h4", null);

		chessBoard.put("a5", null);

		chessBoard.put("b5", null);

		chessBoard.put("c5", null);

		chessBoard.put("d5", null);

		chessBoard.put("e5", null);

		chessBoard.put("f5", null);

		chessBoard.put("g5", null);

		chessBoard.put("h5", null);

		chessBoard.put("a6", null);

		chessBoard.put("b6", null);

		chessBoard.put("c6", null);

		chessBoard.put("d6", null);

		chessBoard.put("e6", null);

		chessBoard.put("f6", null);

		chessBoard.put("g6", null);

		chessBoard.put("h6", null);

		chessBoard.put("a7", "B_P");
		addCoinPosition("B_P", "a7");
		chessBoard.put("b7", "B_P");
		addCoinPosition("B_P", "b7");
		chessBoard.put("c7", "B_P");
		addCoinPosition("B_P", "c7");
		chessBoard.put("d7", "B_P");
		addCoinPosition("B_P", "d7");
		chessBoard.put("e7", "B_P");
		addCoinPosition("B_P", "e7");
		chessBoard.put("f7", "B_P");
		addCoinPosition("B_P", "f7");
		chessBoard.put("g7", "B_P");
		addCoinPosition("B_P", "g7");
		chessBoard.put("h7", "B_P");
		addCoinPosition("B_P", "h7");
		chessBoard.put("a8", "B_R");
		addCoinPosition("B_R", "a8");
		chessBoard.put("b8", "B_N");
		addCoinPosition("B_N", "b8");
		chessBoard.put("c8", "B_B");
		addCoinPosition("B_B", "c8");
		chessBoard.put("d8", "B_Q");
		addCoinPosition("B_Q", "d8");
		chessBoard.put("e8", "B_K");
		addCoinPosition("B_K", "e8");
		chessBoard.put("f8", "B_B");
		addCoinPosition("B_B", "f8");
		chessBoard.put("g8", "B_N");
		addCoinPosition("B_N", "g8");
		chessBoard.put("h8", "B_R");
		addCoinPosition("B_R", "h8");

	}

	public void addCoinPosition(String piece, String position) {
		
		List<String> li = coinPositions.get(piece);
		if (li == null) {
			li = new ArrayList<>();
			coinPositions.put(piece, li);
		}
		li.add(position);
	}

	public List<String> getPosition(String position) throws Exception {
		checkPosition(position);
		int a = position.charAt(0) - 'a';
		int b = '8' - position.charAt(1);
		String piece = chessBoard.get(position);
		List<String> li = new ArrayList<>();
		if (piece == null) {
			li.add("You endered position is do not any piece");
		}
		if (piece.endsWith("R")) {
			return movedPositionRook(position);
		}
		if (piece.endsWith("B")) {
			return movedPositionBishop(position);
		}
		if (piece.endsWith("Q")) {
			return movedPositionQueen(position);
		}
		if (piece.endsWith("K")) {
			return movedPositionKing(position);
		}
		if (piece.endsWith("P")) {
			return movedPositionPawn(b, a, position);
		}
		if (piece.endsWith("N")) {
			return movedPositionKnight( position);
		}
		return null;
	}

	public boolean checkOppositeCoin(String position, String position2) throws Exception {
		stringCheck(position);
		stringCheck(position2);
		String current = chessBoard.get(position);
		String end = chessBoard.get(position2);
		if (current != null && end != null) {
			if (current.charAt(0) != end.charAt(0)) {
				return true;
			}
		}
		return false;

	}

	public boolean checkPlayerMoveOppositeCoin(String postion, char color) throws Exception {
		checkPosition(postion);
		
		String piece = chessBoard.get(postion);
		if (piece.charAt(0) == color) {
			return true;
		}
		return false;
	}

	public boolean checkAbstract(String postion) throws Exception {
		stringCheck(postion);
		if (chessBoard.get(postion) == null) {
			return false;
		}
		return true;
	}

	public boolean move(String currentPosition, String movePosition, List<String> position) throws Exception {
		stringCheck(currentPosition);
		stringCheck(movePosition);
		objectCheck(position);
		if (position.contains(movePosition) || position.contains(movePosition + " can be captured")) {

			String piece = chessBoard.get(currentPosition);
			if (piece.equals("W_R") && currentPosition.equals("a1")) {
				whiteRookLeftMove++;
			}                                                       // for castling operation
			if (piece.equals("W_R") && currentPosition.equals("h1")) {
				whiteRookRightMove++;
			}
			if (piece.equals("B_R") && currentPosition.equals("a8")) {
				blackRookLeftMove++;
			}
			if (piece.equals("B_R") && currentPosition.equals("h8")) {
				blackRookRightMove++;
			}
			if (piece.equals("W_K")&&(movePosition.equals("g1")||movePosition.equals("c1") )&& whiteKingMove == 0) {
				if (movePosition.equals("g1") &&!isWhiteKingCheck()) {
					chessBoard.put("h1", null);
					chessBoard.put("f1", "W_R");
					List<String> coin = coinPositions.get("W_R");
					coin.remove("h1");
					coin.add("f1");
					whiteKingMove++;
				}
				else if (movePosition.equals("c1") && whiteKingMove == 0&&!isWhiteKingCheck()) {
					chessBoard.put("a1", null);
					chessBoard.put("d1", "W_R");
					List<String> coin = coinPositions.get("W_R");
					coin.remove("a1");
					coin.add("d1");
					whiteKingMove++;
				}
				else {
					throw new Exception("King is check so no allow for castling");
				}
				
			}
			if (piece.equals("B_K")&&(movePosition.equals("g8")||movePosition.equals("c1"))&& blackKingMove == 0){
				if (movePosition.equals("g8") &&!isBlackKingCheck()) {
					chessBoard.put("h8", null);
					chessBoard.put("f8", "B_R");
					List<String> coin = coinPositions.get("B_R");
					coin.remove("h8");
					coin.add("f8");
					blackKingMove++;
				}
				else if (movePosition.equals("c1") && whiteKingMove == 0&&!isBlackKingCheck()) {
					chessBoard.put("a8", null);
					chessBoard.put("d8", "B_R");
					List<String> coin = coinPositions.get("B_R");
					coin.remove("a8");
					coin.add("d8");
					blackKingMove++;
				}
				else {
					throw new Exception("King is check so no allow for castling");
				}
				
			}

			String piece2 = chessBoard.get(movePosition);
			chessBoard.put(movePosition, piece);

			chessBoard.put(currentPosition, null);
			List<String> pieceOne = coinPositions.get(piece);
			List<String> pieceTwo = coinPositions.get(piece2);
			pieceOne.remove(currentPosition);
			pieceOne.add(movePosition);
			if (position.contains(movePosition)) {

				recordingMoves.add(piece + " at " + currentPosition + " has been moved to " + movePosition);
				fl.writeFile(recordingMoves);
			} else {
				pieceTwo.remove(movePosition);
				recordingMoves
						.add(piece + " at " + currentPosition + " has been captured " + piece2 + " at " + movePosition);
				fl.writeFile(recordingMoves);
			}
			return true;
		}
		return false;

	}

	public List<String> getRecording() {
		return recordingMoves;
	}

	public List<String> movedPositionRook(String position) throws Exception {
		stringCheck(position);
		List<String> listOfMovings = new ArrayList<>();

		int rowMoves[] = { 1, -1, 0, 0 };
		int colMoves[] = { 0, 0, 1, -1 };
		String string = "";
		for (int i = 0; i < 4; i++) {
			boolean flag = true;
			char cols = (char) (position.charAt(0) + colMoves[i]);

			int rows = (Integer.parseInt(position.charAt(1) + "") + rowMoves[i]);

			while (rows > 0 && rows <= 8 && cols >= 'a' && cols <= 'h' && flag) {
				string = cols + "" + rows;
				if (!position.equals(string)) {
					if (!checkAbstract(string)) {
						listOfMovings.add(string);

					} else {
						if (checkOppositeCoin(position, string)) {
							listOfMovings.add(string + " can be captured");
						}
						flag = false;
					}
				}

				cols += colMoves[i];

				rows += rowMoves[i];

			}

		}
		return listOfMovings;
	}

	public List<String> movedPositionBishop(String position) throws Exception {
		stringCheck(position);
		List<String> listOfMovings = new ArrayList<>();

		int rowMoves[] = { 1, -1, -1, 1 };
		int colMoves[] = { 1, -1, 1, -1 };
		String string = "";
		for (int i = 0; i < 4; i++) {
			boolean flag = true;
			char cols = (char) (position.charAt(0) + colMoves[i]);

			int rows = (Integer.parseInt(position.charAt(1) + "") + rowMoves[i]);

			while (rows > 0 && rows <= 8 && cols >= 'a' && cols <= 'h' && flag) {
				string = cols + "" + rows;
				if (!position.equals(string)) {
					if (!checkAbstract(string)) {
						listOfMovings.add(string);

					} else {
						if (checkOppositeCoin(position, string)) {
							listOfMovings.add(string + " can be captured");
						}
						flag = false;
					}
				}

				cols += colMoves[i];

				rows += rowMoves[i];

			}

		}
		return listOfMovings;

	}

	public List<String> movedPositionQueen(String position) throws Exception {
		stringCheck(position);
		List<String> lis = new ArrayList<>();
		lis.addAll(movedPositionRook(position));
		lis.addAll(movedPositionBishop(position));
		return lis;
	}

	public List<String> movedPositionKing(String position) throws Exception {
		stringCheck(position);
		List<String> lis = new ArrayList<>();
		int rowMoves[] = { 1, -1, 0, 0, 1, -1, 1, -1 };
		int colMoves[] = { 0, 0, 1, -1, 1, -1, -1, 1 };
		String string = "";
		for (int i = 0; i < 8; i++) {
			char cols = (char) (position.charAt(0) + colMoves[i]);

			int rows = (Integer.parseInt(position.charAt(1) + "") + rowMoves[i]);

			if (rows > 0 && rows <= 8 && cols >= 'a' && cols <= 'h') {
				string = cols + "" + rows;
				if (!position.equals(string)) {
					if (!checkAbstract(string)) {
						lis.add(string);

					} else {
						if (checkOppositeCoin(position, string)) {
							lis.add(string + " can be captured");
						}

					}
				}

				cols += colMoves[i];

				rows += rowMoves[i];

			}

		}
		String piece = chessBoard.get(position);
		char cols = position.charAt(0);
		int rows = Integer.parseInt(position.charAt(1) + "");                 
		if (piece.startsWith("W") && whiteKingMove == 0) {                         //For castling
			if (chessBoard.get((char) (cols + 1) + "" + rows) == null
					&& chessBoard.get((char) (cols + 2) + "" + rows) == null
					&& chessBoard.get((char) (cols + 3) + "" + rows).equals("W_R") && whiteRookRightMove == 0) {

				lis.add((char) (cols + 2) + "" + rows);
			}
			if (chessBoard.get((char) (cols - 1) + "" + rows) == null
					&& chessBoard.get((char) (cols - 2) + "" + rows) == null
					&& chessBoard.get((char) (cols - 3) + "" + rows) == null
					&& chessBoard.get((char) (cols - 4) + "" + rows).equals("W_R") && whiteRookLeftMove == 0) {

				lis.add((char) (cols - 2) + "" + rows);
			}
		}
		if (piece.startsWith("B") && blackKingMove == 0) {
			if (chessBoard.get((char) (cols + 1) + "" + rows) == null
					&& chessBoard.get((char) (cols + 2) + "" + rows) == null
					&& chessBoard.get((char) (cols + 3) + "" + rows).equals("B_R") && blackRookRightMove == 0) {

				lis.add((char) (cols + 2) + "" + rows);
			}
			if (chessBoard.get((char) (cols - 1) + "" + rows) == null
					&& chessBoard.get((char) (cols - 2) + "" + rows) == null
					&& chessBoard.get((char) (cols - 3) + "" + rows) == null
					&& chessBoard.get((char) (cols - 4) + "" + rows).equals("B_R") && blackRookLeftMove == 0) {

				lis.add((char) (cols - 2) + "" + rows);
			}
		}
		return lis;

	}

	public List<String> movedPositionPawn(int row, int col, String position) throws Exception {
		stringCheck(position);
		List<String> li = new ArrayList<>();
		String piece = chessBoard.get(position);
		int size = 1;
		String string = "";
		int rows = row;

		if (piece.startsWith("W")) {
			if (position.endsWith("2")) {
				size = 2;
			}

			for (int i = 0; i < size; i++) {
				rows--;
				if (rows >= 0) {
					string = "" + position.charAt(0) + (8 - rows);
					if (!checkAbstract(string)) {
						li.add(string);
					}

				}
			}
            char c=position.charAt(0);
			checkOppositeCoinForPawn(position, Integer.parseInt(position.charAt(1)+"")+1,(char)(c+1), li);
			checkOppositeCoinForPawn(position, Integer.parseInt(position.charAt(1)+"")+1,(char)(c-1), li);

		} else {
			if (position.endsWith("7")) {
				size = 2;
			}
			for (int i = 0; i < size; i++) {
				rows++;
				if (rows <= 8) {

					string = "" + position.charAt(0) + (8 - rows);
					if (!checkAbstract(string)) {
						li.add(string);
					}

				}
			}
			char c=position.charAt(0);
			checkOppositeCoinForPawn(position, Integer.parseInt(position.charAt(1)+"")-1,(char)(c+1), li);
			checkOppositeCoinForPawn(position, Integer.parseInt(position.charAt(1)+"")-1,(char)(c-1), li);

		}
		return li;

	}

	public void checkOppositeCoinForPawn(String postion, int rows, char columns, List<String> li) throws Exception {
		String string=""+columns+rows;
		if (rows > 0 && rows <= 8 && columns >= 'a' && columns <= 'h'&&checkOppositeCoin(postion, string)) {
			li.add(string + " can be captured");
			
		}


	}

	public List<String> movedPositionKnight(String position) throws Exception {
		stringCheck(position);
		List<String> knightMoves = new ArrayList<>();
		int rowMoves[] = { 1, 1, -1, -1, 2, 2, -2, -2 };
		int colMoves[] = { 2, -2, 2, -2, 1, -1, 1, -1 };
		String string = "";
		for (int i = 0; i < 8; i++) {

			char cols = (char) (position.charAt(0) + colMoves[i]);

			int rows = (Integer.parseInt(position.charAt(1) + "") + rowMoves[i]);

			if (rows > 0 && rows <= 8 && cols >= 'a' && cols <= 'h') {
				string = cols + "" + rows;
				if (!position.equals(string)) {
					if (!checkAbstract(string)) {
						knightMoves.add(string);

					} else {
						if (checkOppositeCoin(position, string)) {
							knightMoves.add(string + " can be captured");
						}

					}
				}

				cols += colMoves[i];

				rows += rowMoves[i];

			}

		}

		return knightMoves;

	}

	public String temp(String k) {
		if (k == null) {
			return "   ";
		}
		return k;
	}

	public String printingBoard() {
		String string = "";
		string = "     " + "   a   " + "   b   " + "   c   " + "   d   " + "   e   " + "   f   " + "   g   " + "   h  "
				+ "\n";
		string += "  8  " + "  " + temp(chessBoard.get("a8")) + "    " + temp(chessBoard.get("b8")) + "    "
				+ temp(chessBoard.get("c8")) + "    " + temp(chessBoard.get("d8")) + "    " + temp(chessBoard.get("e8"))
				+ "    " + temp(chessBoard.get("f8")) + "    " + temp(chessBoard.get("g8")) + "    "
				+ temp(chessBoard.get("h8")) + "\n";
		string += "  7  " + "  " + temp(chessBoard.get("a7")) + "    " + temp(chessBoard.get("b7")) + "    "
				+ temp(chessBoard.get("c7")) + "    " + temp(chessBoard.get("d7")) + "    " + temp(chessBoard.get("e7"))
				+ "    " + temp(chessBoard.get("f7")) + "    " + temp(chessBoard.get("g7")) + "    "
				+ temp(chessBoard.get("h7")) + "\n";
		string += "  6  " + "  " + temp(chessBoard.get("a6")) + "    " + temp(chessBoard.get("b6")) + "    "
				+ temp(chessBoard.get("c6")) + "    " + temp(chessBoard.get("d6")) + "    " + temp(chessBoard.get("e6"))
				+ "    " + temp(chessBoard.get("f6")) + "    " + temp(chessBoard.get("g6")) + "    "
				+ temp(chessBoard.get("h6")) + "\n";
		string += "  5  " + "  " + temp(chessBoard.get("a5")) + "    " + temp(chessBoard.get("b5")) + "    "
				+ temp(chessBoard.get("c5")) + "    " + temp(chessBoard.get("d5")) + "    " + temp(chessBoard.get("e5"))
				+ "    " + temp(chessBoard.get("f5")) + "    " + temp(chessBoard.get("g5")) + "    "
				+ temp(chessBoard.get("h5")) + "\n";
		string += "  4  " + "  " + temp(chessBoard.get("a4")) + "    " + temp(chessBoard.get("b4")) + "    "
				+ temp(chessBoard.get("c4")) + "    " + temp(chessBoard.get("d4")) + "    " + temp(chessBoard.get("e4"))
				+ "    " + temp(chessBoard.get("f4")) + "    " + temp(chessBoard.get("g4")) + "    "
				+ temp(chessBoard.get("h4")) + "\n";
		string += "  3  " + "  " + temp(chessBoard.get("a3")) + "    " + temp(chessBoard.get("b3")) + "    "
				+ temp(chessBoard.get("c3")) + "    " + temp(chessBoard.get("d3")) + "    " + temp(chessBoard.get("e3"))
				+ "    " + temp(chessBoard.get("f3")) + "    " + temp(chessBoard.get("g3")) + "    "
				+ temp(chessBoard.get("h3")) + "\n";
		string += "  2  " + "  " + temp(chessBoard.get("a2")) + "    " + temp(chessBoard.get("b2")) + "    "
				+ temp(chessBoard.get("c2")) + "    " + temp(chessBoard.get("d2")) + "    " + temp(chessBoard.get("e2"))
				+ "    " + temp(chessBoard.get("f2")) + "    " + temp(chessBoard.get("g2")) + "    "
				+ temp(chessBoard.get("h2")) + "\n";
		string += "  1  " + "  " + temp(chessBoard.get("a1")) + "    " + temp(chessBoard.get("b1")) + "    "
				+ temp(chessBoard.get("c1")) + "    " + temp(chessBoard.get("d1")) + "    " + temp(chessBoard.get("e1"))
				+ "    " + temp(chessBoard.get("f1")) + "    " + temp(chessBoard.get("g1")) + "    "
				+ temp(chessBoard.get("h1")) + "\n";

		return string;

	}

	public boolean isWhiteKingCheck() throws Exception {
		List<String> whiteKingPosition = coinPositions.get("W_K");
		if (getCoinPositions(whiteKingPosition, "B")) {
			return true;
		}

		return false;

	}

	public boolean isBlackKingCheck() throws Exception {
		List<String> blackKingPosition = coinPositions.get("B_K");
		if (getCoinPositions(blackKingPosition, "W")) {
			return true;
		}

		return false;

	}
	public boolean allCoinForCheckMate(String color) throws Exception {
		for( String position:chessBoard.keySet()  )
		  {
			  String coin=chessBoard.get(position);
			  
			  if( coin!=null&& coin.startsWith(color)  && isBlockCheck( position , getPosition( position ) ,color )   )
			  {
				  return true;
			  }
			  
		  }
		  
		  return false;
	}
	public boolean isBlockCheck(String position,List<String> allPositions,String color) throws Exception {
		 for( int i=0;i<allPositions.size();i++  )
		  {
			  
			  
			  if(color.equals("W")) {
			  if( moveWhiteCheck( position,allPositions.get(i) )  )
			  {
				  return true;
			  }
			  }
			  else {
				  if( moveBlackCheck( position,allPositions.get(i) )  )
				  {
					  return true;
				  }  
			  }
			 
			     
		  }
		   return false;
	}
	public boolean moveWhiteCheck(String currentPosition,String movePosition) throws Exception {
		 if( movePosition.contains(" can be captured") )
	     {
	    	 movePosition=movePosition.replace(" can be captured", "");
	     }
		 String piece=chessBoard.get(currentPosition);
		 String movePiece=chessBoard.get(movePosition);
		 chessBoard.put(currentPosition,null);
		 chessBoard.put(movePosition, piece);
		 List<String> temp=coinPositions.get("W_K");
		 if(piece.endsWith("K")) {
		 temp.remove(0);
		 temp.add(movePosition);
		 }
		 if(!isWhiteKingCheck()) {
			 chessBoard.put(currentPosition, piece);
			 chessBoard.put(movePosition, movePiece);
			 if(piece.endsWith("K")) {
				 temp.remove(0);
				 temp.add(currentPosition);
			 }
			 return true;
		 }
		 chessBoard.put(currentPosition, piece);
		 chessBoard.put(movePosition, movePiece);
		 if(piece.endsWith("K")) {
			 temp.remove(0);
			 temp.add(currentPosition);
		 }
         return false;
	}
	public boolean moveBlackCheck(String currentPosition,String movePosition) throws Exception {
		 if( movePosition.contains("captured") )
	     {
	    	 movePosition=movePosition.replace(" can be captured", "");
	     }
		 String piece=chessBoard.get(currentPosition);
		 String movePiece=chessBoard.get(movePosition);
		 chessBoard.put(currentPosition,null);
		 chessBoard.put(movePosition, piece);
		 List<String> temp=coinPositions.get("B_K");
		 if(piece.endsWith("K")) {
		 temp.remove(0);
		 temp.add(movePosition);
		 }
		 if(!isBlackKingCheck()) {
			 chessBoard.put(currentPosition, piece);
			 chessBoard.put(movePosition, movePiece);
			 if(piece.endsWith("K")) {
				 temp.remove(0);
				 temp.add(currentPosition);
			 }
			 return true;
		 }
		 chessBoard.put(currentPosition, piece);
		 chessBoard.put(movePosition, movePiece);
		 if(piece.endsWith("K")) {
			 temp.remove(0);
			 temp.add(currentPosition);
		 }
        return false;
	}
	
    
	public boolean getCoinPositions(List<String> kingPosition, String color) throws Exception {
		stringCheck(color);
		objectCheck(kingPosition);
		Set<String> pieces = coinPositions.keySet();
		for (String piece : pieces) {
			if (piece.startsWith(color)) {
				List<String> lis = coinPositions.get(piece);
				for (int i = 0; i < lis.size(); i++) {

					if (getPosition(lis.get(i)).contains(kingPosition.get(0) + " can be captured")) {
						return true;
					}

				}
			}
		}
		return false;
	}

	public boolean isKingCheck(String position, String color) throws Exception {
		stringCheck(position);
		stringCheck(color);
		Set<String> pieces = coinPositions.keySet();
		for (String piece : pieces) {
			if (piece.startsWith(color)) {
				List<String> lis = coinPositions.get(piece);
				for (int i = 0; i < lis.size(); i++) {

					if (getPosition(lis.get(i)).contains(position + " can be captured")
							|| getPosition(lis.get(i)).contains(position)) {
						return true;
					}

				}
			}
		}
		return false;

	}

	public boolean isWhiteKingCheckMate() throws Exception {
		List<String> whiteKingPosition = coinPositions.get("W_K");

		String position = whiteKingPosition.get(0);
		List<String> lis = getPosition(position);

		for (int i = 0; i < lis.size(); i++) {
			String coin = null;
			String temp = lis.get(i);
			boolean flag = true;
			if (temp.contains(" can be captured")) {
				flag = false;
				temp = temp.replace(" can be captured", "");
				coin = chessBoard.get(temp);
				chessBoard.put(temp, "W_K");
			}
			if (!isKingCheck(temp, "B")) {
				chessBoard.put(temp, coin);
				return false;
			}
			if (!flag) {
				chessBoard.put(temp, coin);
			}
		}
		if (lis.size() == 0) {
			return false;
		}
		if (isWhiteKingCheck()) {
			
			return true;
		}
		return false;
	}

	public boolean isBlackKingCheckMate() throws Exception {
		List<String> whiteKingPosition = coinPositions.get("B_K");

		String position = whiteKingPosition.get(0);
		List<String> lis = getPosition(position);

		for (int i = 0; i < lis.size(); i++) {
			String coin = null;
			String temp = lis.get(i);
			boolean flag = true;
			if (temp.contains(" can be captured")) {
				flag = false;
				temp = temp.replace(" can be captured", "");
				coin = chessBoard.get(temp);
				chessBoard.put(temp, "B_K");
			}
			if (!isKingCheck(temp, "W")) {
				chessBoard.put(temp, coin);
				return false;
			}
			if (!flag) {
				chessBoard.put(temp, coin);
			}
		}
		if (lis.size() == 0) {
			return false;
		}
		if (isBlackKingCheck()) {
			return true;
		}
		return false;
	}

	public boolean reverse() throws Exception {
		if (recordingMoves.size() != 0) {
			String lastMove = recordingMoves.get(recordingMoves.size() - 1);
			if (!lastMove.contains("captured")) {
				String[] last = lastMove.split(" ");
				String piece = last[0];
				String currentPosition = last[2];
				String movePosition = last[7];
				chessBoard.put(movePosition, null);
				chessBoard.put(currentPosition, piece);
				recordingMoves.remove(lastMove);
				if (recordingMoves.size() == 0) {
					return false;
				}
				return true;
			} else {
				String[] last = lastMove.split(" ");
				String piece1 = last[0];
				String piece2 = last[6];
				String currentPosition = last[2];
				String movePosition = last[8];
				chessBoard.put(movePosition, piece2);
				chessBoard.put(currentPosition, piece1);
				recordingMoves.remove(lastMove);
				if (recordingMoves.size() == 0) {
					return false;
				}
				return true;
			}
		} else {
			throw new Exception("chessBoard got initial position");
		}

	}

	public void getHelp(String position, String color, List<String> help, String ourCoin) throws Exception {
		stringCheck(position);
		stringCheck(color);
		objectCheck(help);
		stringCheck(ourCoin);
		String string = "";
		Set<String> pieces = coinPositions.keySet();
		for (String piece : pieces) {
			if (piece.startsWith(color)) {
				List<String> lis = coinPositions.get(piece);
				for (int i = 0; i < lis.size(); i++) {
					List<String> positions = getPosition(lis.get(i));
					if (positions.contains(position+" can be captured")) {
						string = "The " + piece + " in " + lis.get(i) + " can capture your " + ourCoin;
						help.add(string);

					} 

				}
			}
		}

	}

	public List<String> getHelp(String position, String color, String coinPosition) throws Exception {
		stringCheck(position);
		stringCheck(color);
		stringCheck(coinPosition);
		List<String> help = new ArrayList<>();
		String piece2=chessBoard.get(position);
		String piece = chessBoard.get(coinPosition);
		chessBoard.put(position, piece);
		if (color.equals("W")) {
			getHelp(position, "B", help, piece);
		} else if (color.equals("B")) {
			getHelp(position, "W", help, piece);
		}
		if (help.size() == 0) {
			help.add("Safe place");
		}
		chessBoard.put(position, piece2);
		return help;
	}
	private void stringCheck(String string) throws Exception {
    	if(string==null||string.isEmpty()) {
    		throw new Exception("String cannot be null or empty");
    	}
    }
    private void objectCheck(Object object) throws Exception {
    	if(object==null) {
    		throw new Exception("String cannot be null or empty");
    	}
    }
	private void checkPosition(String position) throws Exception {
		if (chessBoard.get(position) == null) {
			throw new Exception("Position is wrong or dont coin in that place");
		}
	}
}
