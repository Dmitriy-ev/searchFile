package search_file;

import java.io.File;


public class Main {

	public static void main(String[] args) {

		String dir = "C://workspace/search_file/root";
		SearchFile search = new SearchFile();
		File file = new File(dir);
		search.searchDir(file);
		search.sort();
		search.writeFile();
		
	}

}
