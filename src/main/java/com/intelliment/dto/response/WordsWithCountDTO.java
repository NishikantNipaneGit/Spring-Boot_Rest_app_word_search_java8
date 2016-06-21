package com.intelliment.dto.response;

import java.util.ArrayList;
import java.util.List;

public class WordsWithCountDTO {
	
	private List<WordCount> counts;

	public WordsWithCountDTO(List<WordCount> counts) {
		super();
		this.counts = counts;
	}
	
	public WordsWithCountDTO() {
		super();
		this.counts = new ArrayList<WordCount>();
	}

	public List<WordCount> getCounts() {
		return counts;
	}

	public void setCounts(List<WordCount> counts) {
		this.counts = counts;
	}
}
