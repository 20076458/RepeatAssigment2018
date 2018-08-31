package models;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.Books;

import static models.Fixtures.film;


public class Bookstest {

	private Books one;
	private Books two;

	@Before
	public void setup()
	{
		one = new Books("James Bond", "2004", "007.com");
		two = new Books("Harry Potter", "2006", "potter.com");
	}


	@After
	public void tearDown()
	{
		one = two = null;
	}



	@Test
	public void testCreate()
	{
		assertEquals ("James Bond", "2004", "007.com");
		assertEquals ("Harry Potter", "2006", "potter.com");


	}

	@Test
	public void testIds()
	{
		assertNotEquals(one.BookId, two.BookId);
	}


	@Test
	public void testToString()
	{
		assertEquals ("Books{" + film[0].BookId +" , James Bond , 2004 ,007.com}", film[0].toString());
	}
}