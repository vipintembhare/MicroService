package com.vipintembhare.dao;

import java.util.List;
import com.vipintembhare.TriviaQuestion;

public interface TriviaQuestionAccessible {

	TriviaQuestion getQuestionByIndex(long index);
	TriviaQuestion getQuestionById(long id);
	TriviaQuestion getRandomQuestion();
	List<TriviaQuestion> getQuestionList(long offset);
	List<TriviaQuestion> getSpecifiedQuestionList(long ... ids);
	long getQuestionListSize();
}
