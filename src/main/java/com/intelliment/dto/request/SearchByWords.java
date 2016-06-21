package com.intelliment.dto.request;

import java.util.ArrayList;
import java.util.List;

public class SearchByWords {
	
	List<String> searchText;

	public SearchByWords() {
		super();
		this.searchText = new ArrayList<String>();
	}

	public SearchByWords(List<String> searchText) {
		super();
		this.searchText = searchText;
	}

	public List<String> getSearchText() {
		return searchText;
	}

	public void setSearchText(List<String> searchText) {
		this.searchText = searchText;
	}
}
