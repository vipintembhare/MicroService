package com.vipintembhare.builder;

import java.util.Date;
import com.vipintembhare.TriviaQuestion;

public class TriviaBuilder {

	 private long id=-1;
	 private String question;
	 private String answerA;
	 private String answerB;
	 private String answerC;
	 private String answerD;
	 private String correctAnswer;
	 private String hint;
	 private Date lastUpdated;
	 
	public TriviaQuestion build() {
		if((id<0) 
				|| ("".equals(this.question) || this.question.trim().isEmpty())
				|| (null == this.answerA) || this.answerA.trim().isEmpty()
				|| (null == this.answerB) || this.answerB.trim().isEmpty()
				|| (null == this.answerC) || this.answerC.trim().isEmpty()
				|| (null == this.answerD) || this.answerD.trim().isEmpty()
				|| (null == this.correctAnswer) || this.correctAnswer.trim().isEmpty()
				|| (null == this.hint)    || this.hint.trim().isEmpty()
				|| (null==this.lastUpdated)
				) {
			throw new IllegalArgumentException("TriviaQuestion is not fully initialized");
		}
		else {
			return new TriviaQuestion(this.id,this.question,this.answerA,this.answerB,this.answerC,this.answerD,this.correctAnswer,
					this.hint,this.lastUpdated);
		}
	}

	public TriviaBuilder id(long id) {
		this.id = id;
		return this;
	}

	public TriviaBuilder question(String question) {
		this.question = question;
		return this;
	}

	public TriviaBuilder answerA(String answerA) {
		this.answerA = answerA;
		return this;
	}

	public TriviaBuilder answerB(String answerB) {
		this.answerB = answerB;
		return this;
	}

	public TriviaBuilder answerC(String answerC) {
		this.answerC = answerC;
		return this;
	}

	public TriviaBuilder answerD(String answerD) {
		this.answerD = answerD;
		return this;
	}

	public TriviaBuilder correctAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
		return this;
	}

	public TriviaBuilder hint(String hint) {
		this.hint = hint;
		return this;
	}

	public TriviaBuilder lastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
		return this;
	}
	
	
}
