package controllers;

import java.util.Collection;

import model.Books;
import model.Rating;
import model.User;

public interface BookAPIInterface {
	User createUser(String fName, String lName, String age, String gender, String job, String role);

	void deleteUser(Long userID);

	Books addBook(long id, String name, String date, String link);

	Rating createRating(Long ID, Long bookID, double rating);

	Books getBookie(Long iD);

	Books getBookByTitle(String Title);

	boolean login(Long userID, String lName);

	void logout();

	Collection<Books> getBooks();
	Collection<User> getUsers();

	public void load() throws Exception;

	public void store() throws Exception;

}