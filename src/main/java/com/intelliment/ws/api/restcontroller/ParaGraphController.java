package com.intelliment.ws.api.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.intelliment.dto.request.SearchByWords;
import com.intelliment.dto.response.WordsWithCountDTO;
import com.intelliment.service.ParaGraphService;

@RestController
public class ParaGraphController {
	
	 @Autowired
	 ParaGraphService paraGraphService;

	 @RequestMapping("/top/{noOfTopResults}")
	 public WordsWithCountDTO wordsWithTopCount(@PathVariable(value="noOfTopResults") int noOfTopResults) {
	        return paraGraphService.wordsWithTopCount(noOfTopResults);
	 }
	 
	 @RequestMapping(value="/search", method = RequestMethod.POST)
	 public WordsWithCountDTO countForSelectedWords(@RequestBody SearchByWords searchWords){
		 return paraGraphService.getSpecifiWordsWithCounts(searchWords.getSearchText());
	 }
}
