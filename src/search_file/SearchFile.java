package search_file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SearchFile {

	private ArrayList<File> fileList = new ArrayList<>();
	private String resultFile;

	public SearchFile() {
		this.resultFile = "file.txt";
	}

	public void searchDir(File directory) {
		if (directory.isDirectory()) {
			for (File file : directory.listFiles()) {
				if (file.isFile() && file.getName().endsWith(".txt")) {
					fileList.add(file);
				} else
					searchDir(file);
			}
		}
	}

	public void sort() {
		Comparator<File> comparator = (File o1, File o2) -> o1.getName().compareTo(o2.getName());
		Collections.sort(fileList, comparator);
	}

	public void writeFile() {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(resultFile))) {
			for (File file : fileList) {
				try (BufferedReader reader = new BufferedReader(new FileReader(file.toString()))) {
					while (reader.ready()) {
						writer.write(reader.readLine().replaceAll("[,.\\s]+", " "));
						writer.newLine();
					}
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
