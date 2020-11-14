
package com.assignment.RandomNumberGenerators;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumberGenerator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int totalGenCount = 1000000;
		List<Integer> randomNoUnsortedList = new ArrayList<Integer>();
		List<Integer> randomNoSortedList = new ArrayList<Integer>();
		RandomNumberGenerator generator = new RandomNumberGenerator();
		randomNoUnsortedList = generator.randomNumberGenerator(totalGenCount);
		generator.writeUnSortedListToFile(randomNoUnsortedList);
		randomNoSortedList = generator.randomNumberSorting(randomNoUnsortedList);
		generator.writeSortedListToFile(randomNoSortedList);

	}

	// Program to sort the random numbers
	public List<Integer> randomNumberSorting(List<Integer> randomList) {
		Comparator<Integer> sortingOrder = (firstNum, SecondNum) -> Integer.compare(firstNum, SecondNum);
		randomList.sort(sortingOrder);
		return randomList;
	}

	// Program to generate the random numbers
	public List<Integer> randomNumberGenerator(int totalGenCount) {
		IntStream itr = new Random().ints(totalGenCount);
		List<Integer> randomList = itr.boxed().collect(Collectors.toList());
		return randomList;
	}
	// Program to check if directory exist or not, if not create one
	public Path createDirectory() {
		String dir = "c:/java_assignment";
		Path path = Paths.get(dir);
		try {
			if (Files.exists(path)) {
				System.out.println("Directory already exist");
			} else {
				Path createPath = Files.createDirectories(path);
				System.out.println("Directory created at " + createPath.toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}

	// Program to write the sorted random number to the csv file
	public void writeSortedListToFile(List<Integer> randomList) {
		try {
			String file = "sorted_output.csv";
			Path path = createDirectory();
			path = Paths.get(path.toFile()+"\\"+file);
			System.out.println("Writing on File " + path.getFileName() + " begin");
			BufferedWriter writer = Files.newBufferedWriter(path);
			for (Integer i : randomList) {
				writer.write(i.intValue() + System.lineSeparator());
				writer.flush();
			}
			System.out.println(
					"Writing on File " + path.getFileName() + " end with total record count--> " + randomList.size());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Program to write the unsorted random number to the csv file
	public void writeUnSortedListToFile(List<Integer> randomList) {
		try {
			String file = "unsorted_output.csv";
			Path path = createDirectory();
			path = Paths.get(path.toFile()+"\\"+file);
			System.out.println("Writing on File " + path.getFileName() + " begin");
			BufferedWriter writer = Files.newBufferedWriter(path);
			for (Integer i : randomList) {
				writer.write(i.intValue() + System.lineSeparator());
				writer.flush();
			}
			System.out.println(
					"Writing on File " + path.getFileName() + " end with total record count--> " + randomList.size());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
