package net.projecteuler.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

import net.projecteuler.ProjectEuler098;

public class FileUtils {
	
	public static List<String> readLinesFromFile(String fileName) {
		try (InputStream is = ProjectEuler098.class.getResourceAsStream(fileName);
			BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
				
			List<String> lines = new LinkedList<>();
			String line = null;
			while ((line = reader.readLine()) != null) {
				lines.add(line);
			}
			return lines;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
