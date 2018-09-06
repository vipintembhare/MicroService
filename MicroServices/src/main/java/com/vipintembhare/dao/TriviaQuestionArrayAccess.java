package com.vipintembhare.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.vipintembhare.TriviaQuestion;
import com.vipintembhare.builder.TriviaBuilder;

public class TriviaQuestionArrayAccess implements TriviaQuestionAccessible{
	
	private ArrayList<TriviaQuestion> questionList;
	static private final int MAX_NUMBER_OF_QUESTIONS_PER_PAGE=10;

	public TriviaQuestionArrayAccess() {
		this.loadQuestionArray();
	}

	@Override
	public TriviaQuestion getQuestionByIndex(long index) {
		int iIndex= (int)index;
		if(iIndex>=0 && iIndex < this.questionList.size()) {
			return questionList.get(iIndex);
		}
		return null;
	}

	@Override
	public TriviaQuestion getQuestionById(long id) {
		for (TriviaQuestion triviaQuestion : questionList) {
			if(triviaQuestion.getId()==id) {
				return triviaQuestion;
			}
		}
		return null;
	}

	@Override
	public TriviaQuestion getRandomQuestion() {
		int index = (new Random()).nextInt(this.questionList.size());
		return this.questionList.get(index);
	}

	@Override
	public List<TriviaQuestion> getQuestionList(long offset) {
		long start =offset;
		if(start < 0) {
			start=0;
		}
		if(start >= questionList.size()) {
			start=questionList.size();
		}
		
		long end= start +MAX_NUMBER_OF_QUESTIONS_PER_PAGE;
		if(end >= questionList.size()) {
			end=questionList.size();
		}
		return questionList.subList((int)start, (int)end);
	}

	@Override
	public List<TriviaQuestion> getSpecifiedQuestionList(long... ids) {
		List <TriviaQuestion> returnList=new ArrayList<>();
		for (long currentId : ids) {
			TriviaQuestion question=getQuestionById(currentId);
			if(null != question) {
			returnList.add(question);
			}
		}
 		return returnList;
	}

	@Override
	public long getQuestionListSize() {
		return questionList.size();
	}

	private void loadQuestionArray() {
		questionList= new ArrayList<>();
		questionList.add(new TriviaBuilder()
		.id(0)
		.question("What is the capital of India?")
		.answerA("Delhi")
		.answerB("Mumbai")
		.answerC("Goa")
		.answerD("Culcutta")
		.correctAnswer("Delhi")
		.hint("The city is in the north of India")
		.lastUpdated(new Date())
		.build()
		);
		
		questionList.add(new TriviaBuilder()
				.id(1)
				.question("Where is Taj Mahal located?")
				.answerA("Agartala")
				.answerB("Agra")
				.answerC("Humpi")
				.answerD("Surat")
				.correctAnswer("Agra")
				.hint("Yamuna river flows thought the city")
				.lastUpdated(new Date())
				.build()
				);
		
		questionList.add(new TriviaBuilder()
				.id(2)
				.question("Who can among the following options?")
				.answerA("Stone")
				.answerB("Man")
				.answerC("Tubelight")
				.answerD("Bird")
				.correctAnswer("Bird")
				.hint("They have wings")
				.lastUpdated(new Date())
				.build()
				);
		
	}
}
