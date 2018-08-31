package model;

import static com.google.common.base.MoreObjects.toStringHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.base.Objects;

public class Books {

	public long BookId;
	public static Long counter = (long) 01;
	public String date;
	public String link;
	public String Name;

	public List<Rating> book = new ArrayList<>();
	
//Constructor
	public Books(String name, String date, String link) {

		this.BookId = counter++;
		this.Name = name;
		this.date = date;
		this.link = link;
	}
	

	@Override
	public String toString() {
		return toStringHelper(this).addValue(Name).addValue(date).addValue(link).addValue(BookId)
				.toString();

	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.Name, this.date, this.link, this.BookId);
	}

	@Override
	public boolean equals(final Object obj) {
		if (obj instanceof Books) {
			final Books other = (Books) obj;
			return Objects.equal(Name, other.Name) && Objects.equal(date, other.date)
					&& Objects.equal(link, other.link);
		} else {
			return false;
		}
	}
	public int compareTo(Books books)
		{
			return this.Name.compareTo(books.Name);
	}

}