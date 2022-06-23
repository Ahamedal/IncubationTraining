package playerchessgame;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class Chess {

	Map<String,String> chessBoard=new HashMap<>();
	void initialSetUp(){
		chessBoard.put("a1","W_R");
		
		chessBoard.put("b1", "W_N");
		
		chessBoard.put("c1","W_B");
		
		chessBoard.put("d1", "W_Q");
		
		chessBoard.put("e1", "W_K");
		
		chessBoard.put("f1", "W_B");
		
		chessBoard.put("g1", "W_N");
		
		chessBoard.put("h1", "W_R");
		
        chessBoard.put("a2","W_P");
		
		chessBoard.put("b2", "W_P");
		
		chessBoard.put("c2","W_P");
		
		chessBoard.put("d2", "W_P");
		
		chessBoard.put("e2", "W_P");
		
		chessBoard.put("f2", "W_P");
		
		chessBoard.put("g2", "W_P");
		
		chessBoard.put("h2", "W_P");
		
		 chessBoard.put("a3",null);
			
			chessBoard.put("b3", null);
			
			chessBoard.put("c3",null);
			
			chessBoard.put("d3", null);
			
			chessBoard.put("e3", null);
			
			chessBoard.put("f3", null);
			
			chessBoard.put("g3", null);
			
			chessBoard.put("h3", null);
			
chessBoard.put("a4",null);
			
			chessBoard.put("b4", null);
			
			chessBoard.put("c4",null);
			
			chessBoard.put("d4", null);
			
			chessBoard.put("e4", null);
			
			chessBoard.put("f4", null);
			
			chessBoard.put("g4", null);
			
			chessBoard.put("h4", null);
			
chessBoard.put("a5",null);
			
			chessBoard.put("b5", null);
			
			chessBoard.put("c5",null);
			
			chessBoard.put("d5", null);
			
			chessBoard.put("e5", null);
			
			chessBoard.put("f5", null);
			
			chessBoard.put("g5", null);
			
			chessBoard.put("h5", null);
			
chessBoard.put("a6",null);
			
			chessBoard.put("b6", null);
			
			chessBoard.put("c6",null);
			
			chessBoard.put("d6", null);
			
			chessBoard.put("e6", null);
			
			chessBoard.put("f6", null);
			
			chessBoard.put("g6", null);
			
			chessBoard.put("h6", null);
			
			 chessBoard.put("a7","B_P");
				
				chessBoard.put("b7", "B_P");
				
				chessBoard.put("c7","B_P");
				
				chessBoard.put("d7", "B_P");
				
				chessBoard.put("e7", "B_P");
				
				chessBoard.put("f7", "B_P");
				
				chessBoard.put("g7", "B_P");
				
				chessBoard.put("h7", "B_P");
				
				 chessBoard.put("a8","B_R");
					
					chessBoard.put("b8", "B_N");
					
					chessBoard.put("c8","B_B");
					
					chessBoard.put("d8", "B_Q");
					
					chessBoard.put("e8", "B_K");
					
					chessBoard.put("f8", "B_B");
					
					chessBoard.put("g8", "B_N");
					
					chessBoard.put("h8", "B_R");
			

	}
	public void getPosition(String postion){
		
		int a=postion.charAt(0)-'a';
		int b='8'-postion.charAt(1);
		
		System.out.println(movedPositionRook(b,a,postion));
		System.out.println(movedPositionBishop(b,a,postion));
		System.out.println(movedPositionQueen(b,a,postion));
		System.out.println(movedPositionKing(b,a,postion));
		System.out.println(movedPositionPawn(b,a,postion));
		System.out.println(movedPositionKnight(b,a,postion));
		
	}
	public boolean checkOppositeCoin(String postion,String postion2) {
		String current=chessBoard.get(postion);
		String end=chessBoard.get(postion2);
		if(current.charAt(0)!=end.charAt(0)) {
			return true;
		}
		return false;
		
	}
	public boolean checkAbstract(String postion) {
		if(chessBoard.get(postion)==null) {
			return false;
		}
		return true;
	}
	public List<String> movedPositionRook(int row,int col,String postion) {
		        List<String> lis=new ArrayList<>();
		        char first=postion.charAt(0);
		        char second=postion.charAt(1);
		       
		        String string="";
				for(int di=1;di<=4;di++) {
					int rows=row;
			        int cols=col;
					if(di==1) {  
						 boolean flag=true;                                 //move right side
						while(true) {
							if(cols>=8||!flag) {
								break;
							}
						 char c=(char) (97+cols);
						string=""+c+second;
						if(!postion.equals(string)) {
							if(!checkAbstract(string)) {
								lis.add(string);
								if(checkOppositeCoin(postion,string)) {
								  String k=lis.get(lis.size()-1);
								  lis.remove(lis.size()-1);
								  lis.add(k+"can be captured");
								}
							}
							else {
								flag=false;
							}
						}
						 cols++;
						}
						
					}
					if(di==2) {  
						 boolean flag=true;                          //move left side
						while(true) {
							if(cols<0||!flag) {
								break;
							}
							 char c=(char) (97+cols);
							 string=""+c+second;
						if(!postion.equals(string)) {
							if(!checkAbstract(string)) {
								lis.add(string);
								if(checkOppositeCoin(postion,string)) {
									  String k=lis.get(lis.size()-1);
									  lis.remove(lis.size()-1);
									  lis.add(k+"can be captured");
									}
							}
							else {
								flag=false;
							}
						 
						}
						 cols--;
						}
						
					}
					if(di==3) { 
						 boolean flag=true;                       //move top side
						while(true) {
							if(rows<0||!flag) {
								break;
							}
						 string=""+first+(8-rows);
						 if(!postion.equals(string)) {
							 if(!checkAbstract(string)) {
									lis.add(string);
									if(checkOppositeCoin(postion,string)) {
										  String k=lis.get(lis.size()-1);
										  lis.remove(lis.size()-1);
										  lis.add(k+"can be captured");
										}
								}
								else {
									flag=false;
								}
						 }
						 rows--;
						}
						
					}
					if(di==4) {
						 boolean flag=true;                  //move down side
						while(true) {
							
							if(rows>=8||!flag) {
								break;
							}
						
						string=""+first+(8-rows);
						if(!postion.equals(string)) {
							if(!checkAbstract(string)) {
								lis.add(string);
								if(checkOppositeCoin(postion,string)) {
									  String k=lis.get(lis.size()-1);
									  lis.remove(lis.size()-1);
									  lis.add(k+"can be captured");
									}
							}
							else {
								flag=false;
							}
						}
						 rows++;
						}
						
					}
			}
				return lis;
	}
	public List<String> movedPositionBishop(int row,int col,String postion) {
        List<String> lis=new ArrayList<>();
     
        String string="";
		for(int di=1;di<=4;di++) {
			int rows=row;
	        int cols=col;
			if(di==1) { 
				 boolean flag=true;//move right down diagonal side
				while(true) {
					if(rows>=8||cols>=8||!flag) {
						break;
					}
					char c=(char) (97+cols);
					string=""+c+(8-rows);
					if(!postion.equals(string)) {
						
						if(!checkAbstract(string)) {
							lis.add(string);
							if(checkOppositeCoin(postion,string)) {
								  String k=lis.get(lis.size()-1);
								  lis.remove(lis.size()-1);
								  lis.add(k+"can be captured");
								}
						}
						else {
							flag=false;
						}
					}
					rows++;
					cols++;
				}
				 
			}
			if(di==2) {   
				 boolean flag=true;                  //move right top diagonal side
				while(true) {
					if(rows<0||cols>=8||!flag) {
						break;
					}
					char c=(char) (97+cols);
					string=""+c+(8-rows);
					if(!postion.equals(string)) {
						if(!checkAbstract(string)) {
							lis.add(string);
							if(checkOppositeCoin(postion,string)) {
								  String k=lis.get(lis.size()-1);
								  lis.remove(lis.size()-1);
								  lis.add(k+"can be captured");
								}
						}
						else {
							flag=false;
						}
					}
					rows--;
					cols++;
				}
				 
			}
			if(di==3) {
				 boolean flag=true;                  //move right top diagonal side
				while(true) {
					if(rows<0||cols<0||!flag) {
						break;
					}
					char c=(char) (97+cols);
					string=""+c+(8-rows);
					if(!postion.equals(string)) {
						if(!checkAbstract(string)) {
							lis.add(string);
							if(checkOppositeCoin(postion,string)) {
								  String k=lis.get(lis.size()-1);
								  lis.remove(lis.size()-1);
								  lis.add(k+"can be captured");
								}
						}
						else {
							flag=false;
						}
					}
					rows--;
					cols--;
				}
				 
			}
			if(di==4) {
				 boolean flag=true;                        //move right top diagonal side
				while(true) {
					if(rows>=8||cols<0||!flag) {
						break;
					}
					char c=(char) (97+cols);
					string=""+c+(8-rows);
					if(!postion.equals(string)) {
						if(!checkAbstract(string)) {
							lis.add(string);
							if(checkOppositeCoin(postion,string)) {
								  String k=lis.get(lis.size()-1);
								  lis.remove(lis.size()-1);
								  lis.add(k+"can be captured");
								}
						}
						else {
							flag=false;
						}
					}
					rows++;
					cols--;
				}
				 
			}
				
		}
		
			return lis;
}
	public List<String> movedPositionQueen(int row,int col,String postion) {
		List<String> lis=new ArrayList<>();
		lis.addAll(movedPositionRook(row,col,postion));
		lis.addAll(movedPositionBishop(row,col,postion));
		return lis;
	}
	public List<String> movedPositionKing(int row,int col,String postion) {
		List<String> lis=new ArrayList<>();
		String string="";
		char first=postion.charAt(0);
		char second=postion.charAt(1);
		for(int di=1;di<=8;di++) {
			int rows=row;
			int colums=col;
			if(di==1) {
				 colums++;
				 if(colums<8) {
				 char c=(char) (97+colums);
				 string=""+c+second;
				 if(!checkAbstract(string)) {
				 lis.add(string);
				 if(checkOppositeCoin(postion,string)) {
					  String k=lis.get(lis.size()-1);
					  lis.remove(lis.size()-1);
					  lis.add(k+"can be captured");
					}
				 }
				 }
				
				}
			if(di==2) {
				colums--;
				if(colums>=0) {
					char c=(char) (97+colums);
					string=""+c+second;
					if(!checkAbstract(string)) {
					lis.add(string);
					if(checkOppositeCoin(postion,string)) {
						  String k=lis.get(lis.size()-1);
						  lis.remove(lis.size()-1);
						  lis.add(k+"can be captured");
						}
					}
				}
				}
				
			if(di==3) {
				rows--;
				if(rows>=0) {
					 string=""+first+(8-rows);
					 if(!checkAbstract(string)) {
					 lis.add(string);
					 if(checkOppositeCoin(postion,string)) {
						  String k=lis.get(lis.size()-1);
						  lis.remove(lis.size()-1);
						  lis.add(k+"can be captured");
						}
					 }
				}
				
			}
			if(di==4) {
				rows++;
				if(rows<=8) {
					 string=""+first+(8-rows);
					 if(!checkAbstract(string)) {
					 lis.add(string);
					 if(checkOppositeCoin(postion,string)) {
						  String k=lis.get(lis.size()-1);
						  lis.remove(lis.size()-1);
						  lis.add(k+"can be captured");
						}
					 }
				}
				}
			if(di==5) {
				rows++;
				colums++;
				if(rows<=8&&colums<=8) {
					char c=(char) (97+colums);
					string=""+c+(8-rows);
					if(!checkAbstract(string)) {
					lis.add(string);
					if(checkOppositeCoin(postion,string)) {
						  String k=lis.get(lis.size()-1);
						  lis.remove(lis.size()-1);
						  lis.add(k+"can be captured");
						}
					}
				}
				
			}
			if(di==6) {
				rows--;
				colums++;
				if(rows>=0&&colums<=8) {
				char c=(char) (97+colums);
				string=""+c+(8-rows);
				if(!checkAbstract(string)) {
				lis.add(string);
				if(checkOppositeCoin(postion,string)) {
					  String k=lis.get(lis.size()-1);
					  lis.remove(lis.size()-1);
					  lis.add(k+"can be captured");
					}
				}
				}
			}
			if(di==7) {
				rows--;
				colums--;
				if(rows>=0&&colums>=0) {
					char c=(char) (97+colums);
					string=""+c+(8-rows);
					if(!checkAbstract(string)) {
					lis.add(string);
					if(checkOppositeCoin(postion,string)) {
						  String k=lis.get(lis.size()-1);
						  lis.remove(lis.size()-1);
						  lis.add(k+"can be captured");
						}
					}
				}
				
			}
			if(di==8) {
				rows++;
				colums--;
				if(rows<=8&&colums>=0) {
					char c=(char) (97+colums);
					string=""+c+(8-rows);
					if(!checkAbstract(string)) {
					lis.add(string);
					if(checkOppositeCoin(postion,string)) {
						  String k=lis.get(lis.size()-1);
						  lis.remove(lis.size()-1);
						  lis.add(k+"can be captured");
						}
					}
				}
				
			}
		}
		return lis;
	}
	public List<String> movedPositionPawn(int row,int col,String postion) {
		row--;
		List<String> li=new ArrayList<>();
		if(row>=0) {
			String string=""+postion.charAt(0)+(8-row);
			if(!checkAbstract(string)) {
			 li.add(string);
			 if(checkOppositeCoin(postion,string)) {
				  String k=li.get(li.size()-1);
				  li.remove(li.size()-1);
				  li.add(k+"can be captured");
				}
			}
		}
		return li;
		
	}
	public List<String> movedPositionKnight(int row,int col,String postion) {
		
		List<String> l=new ArrayList<>();
		String string="";
		
		for(int di=1;di<=4;di++) {
		int rows=row;
		int colums=col;
		if(di==1) {
			rows++;
			colums++;
			for(int d=1;d<=2;d++) {
				int r=rows;
				int c=colums;
				if(d==1) {
					c++;
					 if(c<=8) {
					 char ch=(char) (97+c);
					 string=""+ch+(8-r);
					 if(!checkAbstract(string)) {
					 l.add(string);
					 if(checkOppositeCoin(postion,string)) {
						  String k=l.get(l.size()-1);
						  l.remove(l.size()-1);
						  l.add(k+"can be captured");
						}
					 }
					 }
				}
				if(d==2) {
					r++;
					if(r<=8) {
						char ch=(char) (97+c);
						 string=""+ch+(8-r);
						 if(!checkAbstract(string)) {
						 l.add(string);
						 if(checkOppositeCoin(postion,string)) {
							  String k=l.get(l.size()-1);
							  l.remove(l.size()-1);
							  l.add(k+"can be captured");
							}
						 }
					}
				}
			}
			
		}
		if(di==2) {
			rows--;
			colums++;
			for(int d=1;d<=2;d++) {
				int r=rows;
				int c=colums;
				if(d==1) {
					c++;
					 if(c<=8) {
					 char ch=(char) (97+c);
					 string=""+ch+(8-r);
					 if(!checkAbstract(string)) {
					 l.add(string);
					 if(checkOppositeCoin(postion,string)) {
						  String k=l.get(l.size()-1);
						  l.remove(l.size()-1);
						  l.add(k+"can be captured");
						}
					 }
					 }
				}
				if(d==2) {
					r--;
					if(r>=0) {
						 char ch=(char) (97+c);
						 string=""+ch+(8-r);
						 if(!checkAbstract(string)) {
						 l.add(string);
						 if(checkOppositeCoin(postion,string)) {
							  String k=l.get(l.size()-1);
							  l.remove(l.size()-1);
							  l.add(k+"can be captured");
							}
						 }
					}
				}
			}
		}
		if(di==3) {
			rows--;
			colums--;
			for(int d=1;d<=2;d++) {
				int r=rows;
				int c=colums;
				if(d==1) {
					c--;
					if(c>=0) {
						char ch=(char) (97+c);
						string=""+ch+(8-r);
						if(!checkAbstract(string)) {
						l.add(string);
						if(checkOppositeCoin(postion,string)) {
							  String k=l.get(l.size()-1);
							  l.remove(l.size()-1);
							  l.add(k+"can be captured");
							}
						}
					}
				}
				if(d==2) {
					r--;
					if(r>=0) {
						 char ch=(char) (97+c);
						 string=""+ch+(8-r);
						 if(!checkAbstract(string)) {
						 l.add(string);
						 if(checkOppositeCoin(postion,string)) {
							  String k=l.get(l.size()-1);
							  l.remove(l.size()-1);
							  l.add(k+"can be captured");
							}
						 }
					}
				}
			}
		}
		if(di==4) {
			rows++;
			colums--;
			for(int d=1;d<=2;d++) {
				int r=rows;
				int c=colums;
				if(d==1) {
					c--;
					if(c>=0) {
						char ch=(char) (97+c);
						string=""+ch+(8-r);
						if(!checkAbstract(string)) {
						l.add(string);
						if(checkOppositeCoin(postion,string)) {
							  String k=l.get(l.size()-1);
							  l.remove(l.size()-1);
							  l.add(k+"can be captured");
							}
						}
					}
				}
				if(d==2) {
					r++;
					if(r<=8) {
						char ch=(char) (97+c);
						 string=""+ch+(8-r);
						 if(!checkAbstract(string)) {
						 l.add(string);
						 if(checkOppositeCoin(postion,string)) {
							  String k=l.get(l.size()-1);
							  l.remove(l.size()-1);
							  l.add(k+"can be captured");
							}
						 }
					}
				}
			}
		}
		}
		
		return l;
		
	}
	
	
}
