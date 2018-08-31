package model;

import static com.google.common.base.MoreObjects.toStringHelper;

import java.util.ArrayList;

import com.google.common.base.Objects;

public class Rating {
//Variables
	public long Id;
	static Long counter = (long) 01;

	public Long userId;
	public Long BookId;
	public double rating;

	public ArrayList<Books> route = new ArrayList<Books>();

	public Rating() {

	}
//Constructor

	public Rating(Long userId, Long bookId, double rating) {
		this.userId = userId;
		this.BookId = bookId;
		this.rating = rating;
		this.Id = counter++;
	}

//ToString
	@Override
	public String toString() {
		return toStringHelper(this).addValue(Id).addValue(BookId).addValue(userId).addValue(rating).toString();

	}

//Hashcode
	@Override
	public int hashCode() {
		return Objects.hashCode(this.BookId, this.userId, this.rating, this.Id);
	}

//Boolean
	@Override
	public boolean equals(final Object obj) {
		if (obj instanceof Rating) {
			final Rating other = (Rating) obj;
			return Objects.equal(BookId, other.BookId) && Objects.equal(userId, other.userId)
					&& Objects.equal(rating, other.rating) && Objects.equal(route, other.route);
		} else {
			return false;
		}

	}

}