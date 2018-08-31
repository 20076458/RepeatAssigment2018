package controllers;

import java.util.Collection;

import com.google.common.base.Optional;

import asg.cliche.Command;
import asg.cliche.Param;
import model.Books;
import model.Rating;
import model.User;

public class AdminMenu {
	private String name;
	private BooksAPI boAPI;

	public AdminMenu(BooksAPI boAPI, String userName) {
		this.boAPI = boAPI;
		this.setName(userName);
	}

	@Command(description = "Add Rating")
	//Adding a rating
	public void addRatings(@Param(name = "UserId") Long UserId, @Param(name = "BookId") Long bookId,
			@Param(name = "rateingLeft") double rateingLeft) {
		Optional<User> user = Optional.fromNullable(boAPI.getUser(UserId));
		if (user.isPresent()) {
			boAPI.createRating(UserId, bookId, rateingLeft);
		}
	}

	@Command(description = "Delete a User")
	//Deleting a user
	public void deleteUser(@Param(name = "Name of the user") String fName) {
		Optional<User> user = Optional.fromNullable(boAPI.getUserByfName(fName));
		if (user.isPresent()) {
			boAPI.deleteUser(user.get().UserId);
		}
	}

	@Command(description = "Get all Users")
	// Getting all users
	public void getAllUsers() {
		Collection<User> user = boAPI.getUsers();
		System.out.println(user);
	}

	@Command(description = "Get all Books")
	// Getting all books
	public void getAllBooks() {
		Collection<Books> Books = boAPI.getBooks();
		System.out.println(Books);
	}

	@Command(description = "Get a User by first Name")
	//Getting the user by their first name
	public void getUser(@Param(name = "fName") String fName) {
		Optional<User> user = Optional.fromNullable(boAPI.getUserByfName(fName));
		if (user.isPresent()) {
			User user1 = boAPI.getUserByfName(fName);
			System.out.println(user1);
		} else {
			System.out.println("User not in the system");
			System.out.println("");
		}

	}

	@Command(description = "Create a user")
	//Creating a user
	public void createUser(@Param(name = "first name") String firstName, @Param(name = "last name") String lastName,
			@Param(name = "age") String age, @Param(name = "gender") String gender, @Param(name = "occupation") String occupation,
			@Param(name = "password") String role) {
		boAPI.createUser(firstName, lastName, age, gender, occupation, role);
	}

	@Command(description = "Add Book to an rating")
	//Adding book to an rating
	public void addBook(@Param(name = "Rating Id") Long Id, @Param(name = "url") String url,
			@Param(name = "Title") String title, @Param(name = "Date Out") String date) {
		Optional<Rating> rating = Optional.fromNullable(boAPI.getRatings(Id));
		if (rating.isPresent()) {
			boAPI.addBook(rating.get().Id, title, date, url);
		}
	}

	@Command(description = "Get Book by id")
	//Getting the book by the id
	public void getBookByTitle(@Param(name = "Title") String Title) {
		Books book = boAPI.getBookByTitle(Title);
		System.out.println(book);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Command(description = "Save")
	public void save() throws Exception {
		boAPI.store();
	}
}