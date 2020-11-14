package com.assignment.RandomNumberGenerators;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

import com.assignment.RandomNumberGenerators.RandomNumberGenerator;



class RandomNumberGeneratorTest {

	@Test
	public void testEmptyRandomList() {
		RandomNumberGenerator emptyList=new RandomNumberGenerator();
		List<Integer> randomList =emptyList.randomNumberGenerator(0);
		assertEquals(0, randomList.size());
	}

	@Test
	public void testGeneratedRandomList() {
		RandomNumberGenerator emptyList=new RandomNumberGenerator();
		List<Integer> randomList =emptyList.randomNumberGenerator(100000);
		assertEquals(100000, randomList.size());
	}
}
