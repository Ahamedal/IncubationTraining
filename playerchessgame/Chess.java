package playerchessgame;

import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Chess {

	Map<String, String> chessBoard = new HashMap<>();
	List<String> recordingMoves = new ArrayList<>();

	void initialSetUp() {
		chessBoard.put("a1", "W_R");

		chessBoard.put("b1", "W_N");

		chessBoard.put("c1", "W_B");

		chessBoard.put("d1", "W_Q");

		chessBoard.put("e1", "W_K");

		chessBoard.put("f1", "W_B");

		chessBoard.put("g1", "W_N");

		chessBoard.put("h1", "W_R");

		chessBoard.put("a2", "W_P");

		chessBoard.put("b2", "W_P");

		chessBoard.put("c2", "W_P");

		chessBoard.put("d2", "W_P");

		chessBoard.put("e2", "W_P");

		chessBoard.put("f2", "W_P");

		chessBoard.put("g2", "W_P");

		chessBoard.put("h2", "W_P");

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

		chessBoard.put("b7", "B_P");

		chessBoard.put("c7", "B_P");

		chessBoard.put("d7", "B_P");

		chessBoard.put("e7", "B_P");

		chessBoard.put("f7", "B_P");

		chessBoard.put("g7", "B_P");

		chessBoard.put("h7", "B_P");

		chessBoard.put("a8", "B_R");

		chessBoard.put("b8", "B_N");

		chessBoard.put("c8", "B_B");

		chessBoard.put("d8", "B_Q");

		chessBoard.put("e8", "B_K");

		chessBoard.put("f8", "B_B");

		chessBoard.put("g8", "B_N");

		chessBoard.put("h8", "B_R");

	}

	public List<String> getPosition(String postion) {

		int a = postion.charAt(0) - 'a';
		int b = '8' - postion.charAt(1);
		String piece = chessBoard.get(postion);
		List<String> li = new ArrayList<>();
		if (piece == null) {
			li.add("You endered position is do not any piece");
		}
		if (piece.endsWith("R")) {
			return movedPositionRook(b, a, postion);
		}
		if (piece.endsWith("B")) {
			return movedPositionBishop(b, a, postion);
		}
		if (piece.endsWith("Q")) {
			return movedPositionQueen(b, a, postion);
		}
		if (piece.endsWith("K")) {
			return movedPositionKing(b, a, postion);
		}
		if (piece.endsWith("P")) {
			return movedPositionPawn(b, a, postion);
		}
		if (piece.endsWith("N")) {
			return movedPositionKnight(b, a, postion);
		}
		return null;
	}

	public boolean checkOppositeCoin(String postion, String postion2) {
		String current = chessBoard.get(postion);
		String end = chessBoard.get(postion2);
		if (current != null && end != null) {
			if (current.charAt(0) != end.charAt(0)) {
				return true;
			}
		}
		return false;

	}

	public boolean checkPlayerMoveOppositeCoin(String postion, char color) {
		String piece = chessBoard.get(postion);
		if (piece.charAt(0) == color) {
			return true;
		}
		return false;
	}

	public boolean checkAbstract(String postion) {
		if (chessBoard.get(postion) == null) {
			return false;
		}
		return true;
	}

	public boolean move(String currentPosition, String movePosition, List<String> position) {
		if (position.contains(movePosition) || position.contains(movePosition + " can be captured")) {

			String piece = chessBoard.get(currentPosition);
			String piece2 = chessBoard.get(movePosition);
			chessBoard.put(movePosition, piece);
			chessBoard.put(currentPosition, null);
			if (position.contains(movePosition)) {
				recordingMoves.add(piece + " at " + currentPosition + " has been moved to " + movePosition);
			} else {
				recordingMoves
						.add(piece + " at " + currentPosition + " has been captured " + piece2 + " at " + movePosition);
			}
			return true;
		}
		return false;

	}

	public List<String> getRecording() {
		return recordingMoves;
	}

	public List<String> movedPositionRook(int row, int col, String postion) {
		List<String> lis = new ArrayList<>();
		char first = postion.charAt(0);
		char second = postion.charAt(1);

		String string = "";
		for (int di = 1; di <= 4; di++) {
			int rows = row;
			int cols = col;
			if (di == 1) {
				boolean flag = true; // move right side
				while (true) {
					if (cols >= 8 || !flag) {
						break;
					}
					char c = (char) (97 + cols);
					string = "" + c + second;
					if (!postion.equals(string)) {
						if (!checkAbstract(string)) {
							lis.add(string);

						} else {
							if (checkOppositeCoin(postion, string)) {
								lis.add(string + " can be captured");
							}
							flag = false;
						}
					}
					cols++;
				}

			}
			if (di == 2) {
				boolean flag = true; // move left side
				while (true) {
					if (cols < 0 || !flag) {
						break;
					}
					char c = (char) (97 + cols);
					string = "" + c + second;
					if (!postion.equals(string)) {
						if (!checkAbstract(string)) {
							lis.add(string);

						} else {
							if (checkOppositeCoin(postion, string)) {
								lis.add(string + " can be captured");
							}
							flag = false;
						}

					}
					cols--;
				}

			}
			if (di == 3) {
				boolean flag = true; // move top side
				while (true) {
					if (rows < 0 || !flag) {
						break;
					}
					string = "" + first + (8 - rows);
					if (!postion.equals(string)) {
						if (!checkAbstract(string)) {
							lis.add(string);
						}

						else {
							if (checkOppositeCoin(postion, string)) {
								lis.add(string + " can be captured");
							}

							flag = false;
						}
					}
					rows--;
				}

			}
			if (di == 4) {
				boolean flag = true; // move down side
				while (true) {

					if (rows >= 8 || !flag) {
						break;
					}

					string = "" + first + (8 - rows);
					if (!postion.equals(string)) {
						if (!checkAbstract(string)) {
							lis.add(string);

						} else {
							if (checkOppositeCoin(postion, string)) {
								lis.add(string + " can be captured");
							}
							flag = false;
						}
					}
					rows++;
				}

			}
		}
		return lis;
	}

	public List<String> movedPositionBishop(int row, int col, String postion) {
		List<String> lis = new ArrayList<>();

		String string = "";
		for (int di = 1; di <= 4; di++) {
			int rows = row;
			int cols = col;
			if (di == 1) {
				boolean flag = true;// move right down diagonal side
				while (true) {
					if (rows >= 8 || cols >= 8 || !flag) {
						break;
					}
					char c = (char) (97 + cols);
					string = "" + c + (8 - rows);
					if (!postion.equals(string)) {

						if (!checkAbstract(string)) {
							lis.add(string);

						}

						else {
							if (checkOppositeCoin(postion, string)) {
								lis.add(string + " can be captured");
							}
							flag = false;
						}
					}
					rows++;
					cols++;
				}

			}
			if (di == 2) {
				boolean flag = true; // move right top diagonal side
				while (true) {
					if (rows < 0 || cols >= 8 || !flag) {
						break;
					}
					char c = (char) (97 + cols);
					string = "" + c + (8 - rows);
					if (!postion.equals(string)) {
						if (!checkAbstract(string)) {
							lis.add(string);

						} else {
							if (checkOppositeCoin(postion, string)) {
								lis.add(string + " can be captured");
							}
							flag = false;
						}
					}
					rows--;
					cols++;
				}

			}
			if (di == 3) {
				boolean flag = true; // move right top diagonal side
				while (true) {
					if (rows < 0 || cols < 0 || !flag) {
						break;
					}
					char c = (char) (97 + cols);
					string = "" + c + (8 - rows);
					if (!postion.equals(string)) {
						if (!checkAbstract(string)) {
							lis.add(string);

						} else {
							if (checkOppositeCoin(postion, string)) {
								lis.add(string + " can be captured");
							}
							flag = false;
						}
					}
					rows--;
					cols--;
				}

			}
			if (di == 4) {
				boolean flag = true; // move right top diagonal side
				while (true) {
					if (rows >= 8 || cols < 0 || !flag) {
						break;
					}
					char c = (char) (97 + cols);
					string = "" + c + (8 - rows);
					if (!postion.equals(string)) {
						if (!checkAbstract(string)) {
							lis.add(string);

						} else {
							if (checkOppositeCoin(postion, string)) {
								lis.add(string + " can be captured");
							}
							flag = false;
						}
					}
					rows++;
					cols--;
				}

			}

		}

		return lis;
	}

	public List<String> movedPositionQueen(int row, int col, String postion) {
		List<String> lis = new ArrayList<>();
		lis.addAll(movedPositionRook(row, col, postion));
		lis.addAll(movedPositionBishop(row, col, postion));
		return lis;
	}

	public List<String> movedPositionKing(int row, int col, String postion) {
		List<String> lis = new ArrayList<>();
		String string = "";
		char first = postion.charAt(0);
		char second = postion.charAt(1);
		for (int di = 1; di <= 8; di++) {
			int rows = row;
			int colums = col;
			if (di == 1) {
				colums++;
				if (colums < 8) {
					char c = (char) (97 + colums);
					string = "" + c + second;
					if (!checkAbstract(string)) {
						lis.add(string);
					} else {
						if (checkOppositeCoin(postion, string)) {
							lis.add(string + " can be captured");
						}
					}
				}

			}
			if (di == 2) {
				colums--;
				if (colums >= 0) {
					char c = (char) (97 + colums);
					string = "" + c + second;
					if (!checkAbstract(string)) {
						lis.add(string);
					} else {
						if (checkOppositeCoin(postion, string)) {
							lis.add(string + " can be captured");
						}
					}
				}
			}

			if (di == 3) {
				rows--;
				if (rows >= 0) {
					string = "" + first + (8 - rows);
					if (!checkAbstract(string)) {
						lis.add(string);
					} else {
						if (checkOppositeCoin(postion, string)) {
							lis.add(string + " can be captured");
						}
					}
				}

			}
			if (di == 4) {
				rows++;
				if (rows <= 8) {
					string = "" + first + (8 - rows);
					if (!checkAbstract(string)) {
						lis.add(string);
					} else {
						if (checkOppositeCoin(postion, string)) {
							lis.add(string + " can be captured");
						}
					}
				}
			}
			if (di == 5) {
				rows++;
				colums++;
				if (rows <= 8 && colums <= 8) {
					char c = (char) (97 + colums);
					string = "" + c + (8 - rows);
					if (!checkAbstract(string)) {
						lis.add(string);
					} else {
						if (checkOppositeCoin(postion, string)) {
							lis.add(string + " can be captured");
						}
					}
				}

			}
			if (di == 6) {
				rows--;
				colums++;
				if (rows >= 0 && colums <= 8) {
					char c = (char) (97 + colums);
					string = "" + c + (8 - rows);
					if (!checkAbstract(string)) {
						lis.add(string);
					} else {
						if (checkOppositeCoin(postion, string)) {
							lis.add(string + " can be captured");
						}
					}
				}
			}
			if (di == 7) {
				rows--;
				colums--;
				if (rows >= 0 && colums >= 0) {
					char c = (char) (97 + colums);
					string = "" + c + (8 - rows);
					if (!checkAbstract(string)) {
						lis.add(string);
					} else {
						if (checkOppositeCoin(postion, string)) {
							lis.add(string + " can be captured");
						}
					}
				}

			}
			if (di == 8) {
				rows++;
				colums--;
				if (rows <= 8 && colums >= 0) {
					char c = (char) (97 + colums);
					string = "" + c + (8 - rows);
					if (!checkAbstract(string)) {
						lis.add(string);
					} else {
						if (checkOppositeCoin(postion, string)) {
							lis.add(string + " can be captured");
						}
					}
				}

			}
		}
		return lis;
	}

	public List<String> movedPositionPawn(int row, int col, String postion) {

		List<String> li = new ArrayList<>();
		String piece = chessBoard.get(postion);
		String string = "";
		if (piece.startsWith("W")) {
			row--;
			if (row >= 0) {
				string = "" + postion.charAt(0) + (8 - row);
				if (!checkAbstract(string)) {
					li.add(string);
				}

			}
			row++;
			// string=""+postion.charAt(0)+(8-row);
			checkOppositeCoin1(postion, row, col, li);

		} else {
			row++;
			if (row <= 8) {
				string = "" + postion.charAt(0) + (8 - row);
				if (!checkAbstract(string)) {
					li.add(string);
				}

			}
			row--;
			checkOppositeCoin1(postion, row, col, li);

		}
		return li;

	}

	public boolean checkOppositeCoin1(String postion, int rows, int colums, List<String> li) {
		String piece = chessBoard.get(postion);
		String string = "";

		if (piece.startsWith("W")) {
			rows--;
			colums++;
			if (rows >= 0 && colums <= 8) {
				char c = (char) (97 + colums);
				string = "" + c + (8 - rows);
				if (!postion.equals(string)) {
					if (checkOppositeCoin(postion, string)) {
						li.add(string + " can be captured");
						return true;
					}
				}
			}
			rows++;
			colums--;
			rows--;
			colums--;
			if (rows >= 0 && colums >= 0) {
				char ch = (char) (97 + colums);
				string = "" + ch + (8 - rows);
				if (!postion.equals(string)) {
					if (checkOppositeCoin(postion, string)) {
						li.add(string + " can be captured");
						return true;
					}
				}
			}

		} else {
			rows++;
			colums++;
			if (rows <= 8 && colums <= 8) {
				char c = (char) (97 + colums);
				string = "" + c + (8 - rows);
				if (checkOppositeCoin(postion, string)) {
					li.add(string + " can be captured");
					return true;
				}
			}
			rows--;
			colums--;
			rows++;
			colums--;
			if (rows <= 8 && colums >= 0) {
				char c = (char) (97 + colums);
				string = "" + c + (8 - rows);
				if (checkOppositeCoin(postion, string)) {
					li.add(string + " can be captured");
					return true;
				}

			}

		}
		return false;

	}

	public List<String> movedPositionKnight(int row, int col, String postion) {

		List<String> l = new ArrayList<>();
		String string = "";

		for (int di = 1; di <= 4; di++) {
			int rows = row;
			int colums = col;
			if (di == 1) {
				rows++;
				colums++;
				for (int d = 1; d <= 2; d++) {
					int r = rows;
					int c = colums;
					if (d == 1) {
						c++;
						if (c < 8 && r >= 0 && r < 8) {
							char ch = (char) (97 + c);
							string = "" + ch + (8 - r);
							if (!checkAbstract(string)) {
								l.add(string);
							} else {
								if (checkOppositeCoin(postion, string)) {
									l.add(string + " can be captured");
								}
							}
						}
					}
					if (d == 2) {
						r++;
						if (r < 8) {
							char ch = (char) (97 + c);
							string = "" + ch + (8 - r);
							if (!checkAbstract(string)) {
								l.add(string);
							} else {
								if (checkOppositeCoin(postion, string)) {
									l.add(string + " can be captured");
								}
							}
						}
					}
				}

			}
			if (di == 2) {
				rows--;
				colums++;
				for (int d = 1; d <= 2; d++) {
					int r = rows;
					int c = colums;
					if (d == 1) {
						c++;
						if (c < 8 && r >= 0) {
							char ch = (char) (97 + c);
							string = "" + ch + (8 - r);
							if (!checkAbstract(string)) {
								l.add(string);
							} else {
								if (checkOppositeCoin(postion, string)) {
									l.add(string + " can be captured");
								}
							}
						}
					}
					if (d == 2) {
						r--;
						if (r >= 0) {
							char ch = (char) (97 + c);
							string = "" + ch + (8 - r);
							if (!checkAbstract(string)) {
								l.add(string);
							} else {
								if (checkOppositeCoin(postion, string)) {
									l.add(string + " can be captured");
								}
							}
						}
					}
				}
			}
			if (di == 3) {
				rows--;
				colums--;
				for (int d = 1; d <= 2; d++) {
					int r = rows;
					int c = colums;
					if (d == 1) {
						c--;
						if (c >= 0 && r >= 0) {
							char ch = (char) (97 + c);
							string = "" + ch + (8 - r);
							if (!checkAbstract(string)) {
								l.add(string);
							} else {
								if (checkOppositeCoin(postion, string)) {
									l.add(string + " can be captured");
								}
							}
						}
					}
					if (d == 2) {
						r--;
						if (r >= 0) {
							char ch = (char) (97 + c);
							string = "" + ch + (8 - r);
							if (!checkAbstract(string)) {
								l.add(string);
							} else {
								if (checkOppositeCoin(postion, string)) {
									l.add(string + " can be captured");
								}
							}
						}
					}
				}
			}
			if (di == 4) {
				rows++;
				colums--;
				for (int d = 1; d <= 2; d++) {
					int r = rows;
					int c = colums;
					if (d == 1) {
						c--;
						if (c >= 0 && r < 8) {
							char ch = (char) (97 + c);
							string = "" + ch + (8 - r);
							if (!checkAbstract(string)) {
								l.add(string);
							} else {
								if (checkOppositeCoin(postion, string)) {
									l.add(string + " can be captured");
								}
							}
						}
					}
					if (d == 2) {
						r++;
						if (r < 8) {
							char ch = (char) (97 + c);
							string = "" + ch + (8 - r);
							if (!checkAbstract(string)) {
								l.add(string);
							} else {
								if (checkOppositeCoin(postion, string)) {
									l.add(string + " can be captured");
								}
							}
						}
					}
				}
			}
		}

		return l;

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
		string += "  8  " + "  " + temp(chessBoard.get("a8")) + "    " + temp(chessBoard.get("b8")) + "    "+ temp(chessBoard.get("c8")) + "    " + temp(chessBoard.get("d8")) + "    " + temp(chessBoard.get("e8"))+ "    " + temp(chessBoard.get("f8")) + "    " + temp(chessBoard.get("g8")) + "    "+ temp(chessBoard.get("h8")) + "\n";
		string += "  7  " + "  " + temp(chessBoard.get("a7")) + "    " + temp(chessBoard.get("b7")) + "    "+ temp(chessBoard.get("c7")) + "    " + temp(chessBoard.get("d7")) + "    " + temp(chessBoard.get("e7"))+ "    " + temp(chessBoard.get("f7")) + "    " + temp(chessBoard.get("g7")) + "    "+ temp(chessBoard.get("h7")) + "\n";
		string += "  6  " + "  " + temp(chessBoard.get("a6")) + "    " + temp(chessBoard.get("b6")) + "    "+ temp(chessBoard.get("c6")) + "    " + temp(chessBoard.get("d6")) + "    " + temp(chessBoard.get("e6"))+ "    " + temp(chessBoard.get("f6")) + "    " + temp(chessBoard.get("g6")) + "    "+ temp(chessBoard.get("h6")) + "\n";
		string += "  5  " + "  " + temp(chessBoard.get("a5")) + "    " + temp(chessBoard.get("b5")) + "    "+ temp(chessBoard.get("c5")) + "    " + temp(chessBoard.get("d5")) + "    " + temp(chessBoard.get("e5"))+ "    " + temp(chessBoard.get("f5")) + "    " + temp(chessBoard.get("g5")) + "    "+ temp(chessBoard.get("h5")) + "\n";
		string += "  4  " + "  " + temp(chessBoard.get("a4")) + "    " + temp(chessBoard.get("b4")) + "    "+ temp(chessBoard.get("c4")) + "    " + temp(chessBoard.get("d4")) + "    " + temp(chessBoard.get("e4"))+ "    " + temp(chessBoard.get("f4")) + "    " + temp(chessBoard.get("g4")) + "    "+ temp(chessBoard.get("h4")) + "\n";
		string += "  3  " + "  " + temp(chessBoard.get("a3")) + "    " + temp(chessBoard.get("b3")) + "    "+ temp(chessBoard.get("c3")) + "    " + temp(chessBoard.get("d3")) + "    " + temp(chessBoard.get("e3"))+ "    " + temp(chessBoard.get("f3")) + "    " + temp(chessBoard.get("g3")) + "    "+ temp(chessBoard.get("h3")) + "\n";
		string += "  2  " + "  " + temp(chessBoard.get("a2")) + "    " + temp(chessBoard.get("b2")) + "    "+ temp(chessBoard.get("c2")) + "    " + temp(chessBoard.get("d2")) + "    " + temp(chessBoard.get("e2"))+ "    " + temp(chessBoard.get("f2")) + "    " + temp(chessBoard.get("g2")) + "    "+ temp(chessBoard.get("h2")) + "\n";
		string += "  1  " + "  " + temp(chessBoard.get("a1")) + "    " + temp(chessBoard.get("b1")) + "    "+ temp(chessBoard.get("c1")) + "    " + temp(chessBoard.get("d1")) + "    " + temp(chessBoard.get("e1"))+ "    " + temp(chessBoard.get("f1")) + "    " + temp(chessBoard.get("g1")) + "    "+ temp(chessBoard.get("h1")) + "\n";

		return string;

	}
}
