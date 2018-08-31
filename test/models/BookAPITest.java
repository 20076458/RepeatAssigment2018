package models;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controllers.BooksAPI;
import model.User;

import static models.Fixtures.users;

public class BookAPITest {

	private BooksAPI books;

	@Before
	public void setup()
	{
		books = new BooksAPI();
		for (User user : users)
		{
			books.createUser(user.fName, user.lName, user.Age, user.Gender , user.Occupation, user.role);
		}
	}

	@After
	public void tearDown()
	{
		books = null;
	}

	@Test
	public void testUser()
	{
		assertEquals (users.length, books.getUsers().size());
		books.createUser("homer", "simpson", "32", "male", "power plant", "user");
		assertEquals (users.length+1, books.getUsers().size());
		assertEquals (users[0], books.getUserByfName(users[0].fName));
	}  

	@Test
	public void testUsers()
	{
		assertEquals (users.length, books.getUsers().size());
		for (User user: users)
		{
			User eachUser = books.getUserByfName(user.fName);
			assertEquals (user, eachUser);
			assertNotSame(user, eachUser);
		}
	}

	@Test
	public void testDeleteUsers()
	{
		assertEquals (users.length, books.getUsers().size());
		User marge = books.getUserByfName("marge");
		books.deleteUser(marge.UserId);
		assertEquals (users.length-1, books.getUsers().size());
	}  

}