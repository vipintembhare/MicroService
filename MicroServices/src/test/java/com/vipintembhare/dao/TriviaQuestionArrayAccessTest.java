package com.vipintembhare.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.vipintembhare.TriviaQuestion;

public class TriviaQuestionArrayAccessTest {

	private TriviaQuestionAccessible dataAccess;
	@Before
	public void setup() {
		dataAccess= new TriviaQuestionArrayAccess();
	}
	@Test
	public void test_invalidIndex_GetQuestionByIndex() {
		long index =-1L;
		TriviaQuestion question= dataAccess.getQuestionByIndex(index);
		assertNull(question);
	}
	
	@Test
	public void test_ValidIndex_GetQuestionByIndex() {
		long index =0L;
		TriviaQuestion question= dataAccess.getQuestionByIndex(index);
		assertNotNull(question);
	}
	
	@Test
	public void test_OutOfBoundIndex_GetQuestionByIndex() {
		long index =Long.MAX_VALUE;
		TriviaQuestion question= dataAccess.getQuestionByIndex(index);
		assertNull(question);
	}
	
	@Test
	public void test_IdNotPresent_GetQuestionById() {
		long id=Long.MAX_VALUE;
		TriviaQuestion question = dataAccess.getQuestionById(id);
		assertNull(question);
	}
	
	@Test
	public void test_IdPresent_GetQuestionById() {
		long id=0L;
		TriviaQuestion question = dataAccess.getQuestionById(id);
		assertNotNull(question);
	}
	
	@Test
	public void testGetRandomQuestion() {
		TriviaQuestion question = dataAccess.getRandomQuestion();
		assertNotNull(question);
	}
	@Test
	public void test_Valid_Offset_GetQuestionList() {
		long offset=0L;
		List<TriviaQuestion> result = dataAccess.getQuestionList(offset);
		assertNotNull(result);
		assertEquals(3, result.size());
	}
	
	@Test
	public void test_InValid_Offset_GetQuestionList() {
		long offset=Long.MAX_VALUE;
		List<TriviaQuestion> result = dataAccess.getQuestionList(offset);
		assertEquals(0,result.size());
	}
	
	@Test
	public void test_Valid_indices_GetSpecifiedQuestionList() {
		List<TriviaQuestion> result = dataAccess.getSpecifiedQuestionList(0L,1L,2L);
		assertNotNull(result);
		assertEquals(3, result.size());
	}
	
	@Test
	public void test_InValid_indices_GetSpecifiedQuestionList() {
		List<TriviaQuestion> result = dataAccess.getSpecifiedQuestionList(12L,13L,14L);
		assertEquals(0,result.size());
	}
	
	@Test
	public void test_Some_InValid_indices_GetSpecifiedQuestionList() {
		List<TriviaQuestion> result = dataAccess.getSpecifiedQuestionList(0L,13L,14L,1L);
		assertNotNull(result);
		assertEquals(2, result.size());
	}
	
	@Test
	public void testGetQuestionListSize() {
		long count= dataAccess.getQuestionListSize();
		assertEquals(3, count);
	}
}
