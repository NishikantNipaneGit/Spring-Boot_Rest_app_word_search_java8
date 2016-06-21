package com.intelliment.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.intelliment.datagen.DataUtility;
import com.intelliment.dto.response.WordCount;
import com.intelliment.dto.response.WordsWithCountDTO;

@Service
public class ParaGraphService {

	public WordsWithCountDTO wordsWithTopCount(int top){
		
		WordsWithCountDTO topWordsWithCountDecreasing=new WordsWithCountDTO();
		List counts = new ArrayList<WordCount>();
		
		Map<String, Integer> wordCountMap=getWordsCountasMap();
		Stream<Map.Entry<String, Integer>> st = wordCountMap.entrySet().stream();
		
		Comparator<Entry<String, Integer>> byValue = (entry1, entry2) -> entry1.getValue().compareTo(
	            entry2.getValue());

		counts=st.sorted( byValue.reversed() ).limit(top).collect(Collectors.toList());
		
		topWordsWithCountDecreasing.setCounts(counts);

		return topWordsWithCountDecreasing;
	}

	public Map<String, Integer> getWordsCountasMap(){
		
		String escapedWords=DataUtility.paragraph.getParagraph().replaceAll(",", " ").replaceAll("\\.", " ").replaceAll("\\s+", " ");
	
		List<String> wordsList = Arrays.asList(escapedWords.split(" "));

		return wordsList.stream().
				collect(Collectors.toMap(
						w -> w, w -> 1, Integer::sum));
	}
	
	public WordsWithCountDTO getSpecifiWordsWithCounts(List<String> words){
		WordsWithCountDTO topWordsWithCountDecreasing=new WordsWithCountDTO();
		Map<String, Integer> wordCountMap=getWordsCountasMap();
		List counts = new ArrayList<WordCount>();

		counts=wordCountMap.entrySet()
				.stream()
	            .filter(p -> caseInSessitiveContainsImplForList(words,p.getKey()))
	            .collect(Collectors.toList());
		
		topWordsWithCountDecreasing.setCounts(counts);
		
		return topWordsWithCountDecreasing;
	}
	
	public boolean caseInSessitiveContainsImplForList(List<String> list,String searchStr){
		return list.stream().filter(s -> s.equalsIgnoreCase(searchStr)).findFirst().isPresent();
	}
}
