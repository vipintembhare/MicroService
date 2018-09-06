package com.vipintembhare.builder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Test;

import com.vipintembhare.TriviaQuestion;

public class TriviaBuilderTest {

	@Test
	public void testValidTrivia() {
		TriviaQuestion trivia = new TriviaBuilder()
									.id(0)
									.question("What is the capital of India?")
									.answerA("Delhi")
									.answerB("Mumbai")
									.answerC("Goa")
									.answerD("Culcutta")
									.correctAnswer("Delhi")
									.hint("The city is in the north of India")
									.lastUpdated(new Date())
									.build();
		
		assertNotNull(trivia);
		assertEquals("What is the capital of India?", trivia.getQuestion());
		assertEquals("Delhi", trivia.getAnswerA());
		assertEquals("Goa", trivia.getAnswerC());
		assertNotEquals("Culcutta", trivia.getCorrectAnswer());
		assertNotNull(trivia.getLastUpdated());
		assertNotNull(trivia.getHint());
	}
	@Test(expected=IllegalArgumentException.class)
	public void testInvalidTrivia_Id_Was_Not_Provided() {
		new TriviaBuilder()
		.question("What is the capital of India?")
		.answerA("Delhi")
		.answerB("Mumbai")
		.answerC("Goa")
		.answerD("Culcutta")
		.correctAnswer("Delhi")
		.hint("The city is in the north of India")
		.lastUpdated(new Date())
		.build();
	}
	@Test(expected=IllegalArgumentException.class)
	public void testCorrectAnswer_Was_Not_Provided() {
		new TriviaBuilder()
		.id(0)
		.question("What is the capital of India?")
		.answerA("Delhi")
		.answerB("Mumbai")
		.answerC("Goa")
		.answerD("Culcutta")
		.hint("The city is in the north of India")
		.lastUpdated(new Date())
		.build();
	}
	@Test(expected=IllegalArgumentException.class)
	public void testAnswerA_Was_Not_Provided() {
		new TriviaBuilder()
		.id(0)
		.question("What is the capital of India?")
		.answerB("Mumbai")
		.answerC("Goa")
		.answerD("Culcutta")
		.correctAnswer("Delhi")
		.hint("The city is in the north of India")
		.lastUpdated(new Date())
		.build();
	}
	@Test(expected=IllegalArgumentException.class)
	public void testAnswerB_Was_Not_Provided() {
		new TriviaBuilder()
		.id(0)
		.question("What is the capital of India?")
		.answerA("Delhi")
		.answerC("Goa")
		.answerD("Culcutta")
		.correctAnswer("Delhi")
		.hint("The city is in the north of India")
		.lastUpdated(new Date())
		.build();
	}
	@Test(expected=IllegalArgumentException.class)
	public void testAnswerC_Was_Not_Provided() {
		new TriviaBuilder()
		.id(0)
		.question("What is the capital of India?")
		.answerA("Delhi")
		.answerB("Mumbai")
		.answerD("Culcutta")
		.correctAnswer("Delhi")
		.hint("The city is in the north of India")
		.lastUpdated(new Date())
		.build();
	}
	@Test(expected=IllegalArgumentException.class)
	public void testAnswerD_Was_Not_Provided() {
		new TriviaBuilder()
		.id(0)
		.question("What is the capital of India?")
		.answerA("Delhi")
		.answerB("Mumbai")
		.answerC("Goa")
		.correctAnswer("Delhi")
		.hint("The city is in the north of India")
		.lastUpdated(new Date())
		.build();
	}
	@Test(expected=IllegalArgumentException.class)
	public void testAnswerHint_Was_Not_Provided() {
		new TriviaBuilder()
		.id(0)
		.question("What is the capital of India?")
		.answerA("Delhi")
		.answerB("Mumbai")
		.answerC("Goa")
		.answerD("Culcutta")
		.correctAnswer("Delhi")
		.lastUpdated(new Date())
		.build();
	}
	@Test(expected=IllegalArgumentException.class)
	public void testLastUpdationDate_Was_Not_Provided() {
		new TriviaBuilder()
		.id(0)
		.question("What is the capital of India?")
		.answerA("Delhi")
		.answerB("Mumbai")
		.answerC("Goa")
		.answerD("Culcutta")
		.correctAnswer("Delhi")
		.hint("The city is in the north of India")
		.build();
	}
}
