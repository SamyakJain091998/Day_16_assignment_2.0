package com.addressBook.IOStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.IntStream;

import org.apache.commons.io.FileUtils;
import org.junit.Ignore;
import org.junit.Test;

import junit.framework.Assert;
import static org.junit.Assert.*;
import org.junit.Ignore;

public class FileInputOutput {
	private static String HOME = System.getProperty("user.home");
	private static String PLAY_WITH_NIO = "outputAddressDirectory";
	public static String PAYROLL_FILE_NAME = "outputAddressFile.txt";

	public void writeToFile(List<Contacts> newList) throws IOException {
//		 TODO Auto-genePath homePath = Paths.get(HOME);
		Path homePath = Paths.get(HOME);
		System.out.println("Path is : " + System.getProperty("user.home"));
		Path playPath = Paths.get(HOME + "/Desktop/Capgemini stuff/Day_16_assignment_2.0/" + PLAY_WITH_NIO);
		if (Files.notExists(playPath))
			Files.createDirectory(playPath);
		System.out.println("Directory exists : " + Files.exists(playPath));
		Path tempFile = Paths.get(playPath + "/outputAddressFile.txt");
		if (Files.notExists(tempFile))
			Files.createFile(tempFile);
		System.out.println("File exists : " + Files.exists(tempFile));
		StringBuffer empBuffer = new StringBuffer();
		newList.forEach(addressInfo -> {
			String addressData = addressInfo.toString().concat("\n");
			empBuffer.append(addressData);
		});
		try {
			Files.write(Paths.get(PAYROLL_FILE_NAME), empBuffer.toString().getBytes());
		} catch (IOException e) {
			// TODO: handle exception
		}
	}

	public void readFromFile() {
		// TODO Auto-generated method stub
		System.out.println("----PRINTING USING FILE----");
		try {
			Files.lines(new File("outputAddressFile.txt").toPath()).forEach(System.out::println);
		} catch (IOException e) {
			// TODO: handle exception
		}
	}

}
