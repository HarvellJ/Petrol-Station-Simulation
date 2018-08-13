package petrolStationSimulation;

import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileWriter;

/**
 * Class used to write to files
 */
public class FileWriterHelper {

	private String filePath; // The path to which to write file

	public FileWriterHelper(String filePath) {
		this.filePath = filePath;
	}
	
	/**
	 * gets the filePath
	 * @return filePath
	 */
	public String getFilePath() {
		return filePath;
	}

	/**
	 * sets the file path
	 * @param filePath
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	/**
	 * This method writes a given string to a file
	 * @param text
	 * @throws IOException
	 */
	public void writeLogToFile(String text) throws IOException {
		FileWriter writer = new FileWriter(filePath+"_log", true);
		PrintWriter print_line = new PrintWriter(writer);
		print_line.printf( "%s" + "%n" , text);
		print_line.close();
	}
	
	/**
	 * This method writes a given string to a file
	 * @param text
	 * @throws IOException
	 */
	public void writeResultToFile(String text) throws IOException {
		FileWriter writer = new FileWriter(filePath+"_Results", true);
		PrintWriter print_line = new PrintWriter(writer);
		print_line.printf( "%s" + "%n" , text);
		print_line.close();
	}
	
}
