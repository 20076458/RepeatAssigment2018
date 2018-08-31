package models;

import model.Books;
import model.Rating;
import model.User;

public class Fixtures
{
	public static User[] users =
		{
				new User ("marge", "simpson", "30", "female", "kitchen worker", "user"),
				new User ("lisa", "simpson", "10", "female", "schoolie", "user"),
				new User ("bart", "simpson", "12", "male", "schoolie", "user"),
				new User ("maggie","simpson", "1", "femalet", "child", "user")
		};


	public static Rating[] ratings =
		{
				new Rating (0l,001l,5),
				new Rating (02l,002l,3),
				new Rating (03l,003l,4),
				new Rating (04l,004l, 3),
				new Rating (05l, 005l, 2),

		};

	public static Books[] film =
		{
				new Books("toy story","1998","toy.com"),
				new Books("mulan","2000","mulan.com"),
				new Books("antz","2007","antz.com"),
				new Books("flubber","1998","flubber.com"),
				new Books("cars","2004","cars.com"),

		};



      }