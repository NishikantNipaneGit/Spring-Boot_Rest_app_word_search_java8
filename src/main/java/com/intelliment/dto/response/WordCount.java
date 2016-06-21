package com.intelliment.dto.response;

public class WordCount {

	private String word;
	private int countInParagraph;
	
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public WordCount(String word, int countInParagraph) {
		super();
		this.word = word;
		this.countInParagraph = countInParagraph;
	}
	public int getCountInParagraph() {
		return countInParagraph;
	}
	public void setCountInParagraph(int countInParagraph) {
		this.countInParagraph = countInParagraph;
	}
}
