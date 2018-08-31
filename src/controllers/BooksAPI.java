package controllers;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.google.common.base.Optional;

import model.Books;
import model.Rating;
import model.User;
import utils.FileLogger;
import utils.Serializer;

public class BooksAPI implements BookAPIInterface

{

	private Serializer serializer;

	private Map<Long, User> userIndex = new HashMap<Long, User>();
	private Map<String, User> fNameIndex = new HashMap<String, User>();
	private Map<Long, Books> bookieIndex = new HashMap<Long, Books>();
	private Map<String, Books> titleIndex = new HashMap<String, Books>();
	private Map<Long, Rating> ratingIndex = new HashMap<>();

	Optional<User> currentUser;

// Collection
	public Collection<User> getUsers() {
		return userIndex.values();
	}

// Getting user by their first name
	public User getUserByfName(String fName) {

		return fNameIndex.get(fName);
	}

// Getting user by their id
	public User getUser(Long id) {
		return userIndex.get(id);
	}

	@Override

	public Books getBookie(Long id) {
		return bookieIndex.get(id);
	}

	public Books getBookByTitle(String Title) {
		return titleIndex.get(Title);
	}

	public Collection<Books> getBooks() {
		return bookieIndex.values();
	}

	@Override
	public Rating createRating(Long userID, Long bookieID, double ratingLeft) {
		Optional<Books> Bookie = Optional.fromNullable(bookieIndex.get(bookieID));
		if (Bookie.isPresent()) {
			Bookie.get().book.add(new Rating(userID, bookieID, ratingLeft));
		}
		return null;
	}

	@Override
	public Books addBook(long id, String name, String date, String link) {
		Books bookies = null;
		Optional<User> user = Optional.fromNullable(userIndex.get(id));
		if (user.isPresent()) {
			bookies = new Books(name, date, link);
			user.get().bookies.put(bookies.BookId, bookies);
			bookieIndex.put(bookies.BookId, bookies);
		}
		return bookies;
	}

// Constructor

	public User createUser(String fName, String lName, String age, String gender, String job, String role) {
		User user = new User(fName, lName, age, gender, job, role);
		userIndex.put(user.UserId, user);
		fNameIndex.put(fName, user);
		return user;
	}

// Constructor

// Removing user by id
	@Override
	public void deleteUser(Long id) {
		User user = userIndex.remove(id);
		fNameIndex.remove(user.fName);
	}

// Constructor

// Removing user form array
	public void deleteUsers() {
		userIndex.clear();
		fNameIndex.clear();
	}

// Constructor

	@SuppressWarnings("unlikely-arg-type")
	public void removeUser(String fName) {
		User user = userIndex.remove(fName);
		userIndex.remove(user.fName);
	}

	public BooksAPI() {
	}

// Serializer
	public BooksAPI(Serializer serializer) {
		this.serializer = serializer;
	}

// Exception
	@SuppressWarnings("unchecked")
	@Override
	public void load() throws Exception {

		serializer.read();
		userIndex = (Map<Long, User>) serializer.pop();
		fNameIndex = (Map<String, User>) serializer.pop();
		bookieIndex = (Map<Long, Books>) serializer.pop();
		titleIndex = (Map<String, Books>) serializer.pop();
		ratingIndex = (Map<Long, Rating>) serializer.pop();

	}

	public // Exception
	void store() throws Exception {

		serializer.push(userIndex);
		serializer.push(fNameIndex);
		serializer.push(bookieIndex);
		serializer.push(titleIndex);
		serializer.push(ratingIndex);
		serializer.write();
	}

// Constructor

	public void initalLoad() throws IOException {
		String delims = "[|]";
		Scanner scanner = new Scanner(new File("./data/users.dat"));
		while (scanner.hasNextLine()) {
			String userDetails = scanner.nextLine();
// parse user details string
			String[] userTokens = userDetails.split(delims);

			if (userTokens.length == 7) {
				createUser(userTokens[1], userTokens[2], userTokens[3], userTokens[4], userTokens[5], userTokens[6]);
			} else {
				scanner.close();
				throw new IOException("Invalid member length: " + userTokens.length);
			}
		}
		scanner.close();
	}

	public Rating getRatings(Long id) {
		return ratingIndex.get(id);
	}

// simplified login method
	public boolean login(Long UserId, String lName) {
		Optional<User> user = Optional.fromNullable(userIndex.get(UserId));
		if (user.isPresent() && user.get().lName.equals(lName)) {
			currentUser = user;
			FileLogger.getLogger().log(currentUser.get().fName + " logged in...");
			return true;
		}
		return false;
	}

// simplified and generalized version of my logout method
	public void logout() {
		Optional<User> user = currentUser;
		if (user.isPresent()) {
			FileLogger.getLogger().log(currentUser.get().fName + " logged out...");
			currentUser = Optional.absent();
		}
	}

}