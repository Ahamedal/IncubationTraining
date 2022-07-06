package playerchessgame;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileLayer {
    File file=new File("Chess.txt");
	public void writeFile(List<String> moves) {
		try(FileWriter fw=new FileWriter(file)){
			for(int i=0;i<moves.size();i++) {
				fw.write(moves.get(i)+"\n");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
