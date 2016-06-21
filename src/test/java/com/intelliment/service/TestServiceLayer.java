package com.intelliment.service;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.intelliment.datagen.DataUtility;
import com.intelliment.domain.ParaGraph;

public class TestServiceLayer  {
	
	ParaGraphService service;
	
	@BeforeClass
	void setup(){
		service=new ParaGraphService();
	}
	
	@DataProvider(name = "testgetWordsCountasMap")
	   public static Object[][] primeNumbers() {
	      return new Object[][] {
	    	  {"this is me", 3,3},
	    	  {"this is test", 3,3},
	    	  {"this is is ", 2,3},
	    	  {"this is this", 2,3},
	    	  {"this. Is this is", 2,4},
	    	  {"this is."+"my time", 4,4},
	    	  {"test,", 1,1},
	      };
	}
	

	@Test(dataProvider = "testgetWordsCountasMap")
	public void testgetWordsCountasMap(String input,int count,int sum) {
		
		DataUtility.setParagraph(new ParaGraph(input));
		
	     int noOfEntriesInMap=service.getWordsCountasMap().values().
	    		                                stream()
	                                            .reduce(0, (acc, val) -> acc + 1, Integer::sum);
	     
	     int sumOfOccurences=service.getWordsCountasMap().values().
                 stream()
                 .reduce(0, (acc, val) -> acc + val, Integer::sum);
	     
	     System.out.println(input);
	     
		Assert.assertEquals(sum,sumOfOccurences);
	}

}
