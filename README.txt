# Assignment 2 - Book Recommender.
 
Name: Karol Switelski 20076458
## Overview.
...... A short statement of the concept and objectives ........
 
 
## Functionality
. . . . . List of the functional features you implemented from the specification . . . .
 
+ Get top five books
+ Feature 2
+ Feature 3
+ etc
+ etc
 
## Extra features
 
In this assigment we implemented the cliche menu, login in as an admin or user
## Installation requirements
. . . . List of software, libraries and tools used (hint: everything on your build path libraries ) . . . . . . .
+ Java JRE v1.8
+ Guava v18.0
+ asg.cliche.jar
+ xstream-1.4.10
 
## Getting started
Once its being downloaded from git repository run the program in Eclipse or any other suitable program and run the class "main"
 
>The project comes with data in CSV format that can be used to prime the application with initial data.
- In the program select Main and run as Java Application:
```
The Cliche Movie Shell
Enter ?l to list available commands.
Books> ?list
abbrev name params
li log-in (user name, password)
p prime ()
Books> p
Books>
```
- Log in as the administrator user (Karol Switelski)
Type in : "li 6 Switelski"
 
You are logged in as Karol
Admin
Books/Karol>
 
or
Type in : "li 5 Parker"
You are logged in as Jenna
Default
Books/Parker>
 
## Data Model Design.
 
Describe the program's data model (see example below) AND/OR a sample of the data used (XML, JSON or equivalent).
 
![][image1]
 
Use meaningful sample data from your program.
 
## Examples
 
. . . . . Examples of program's user interface (e.g. CLI) (see example below) with appropriate captions (user regeneration and login views, if implemented, can be omitted) . . . . . . .
/* User */
save s 0 Save
get-user gu 1 Get a Users detail
 
add-rating ar 3 Add an rating
 
add-book af 4 Add Location to an activity
 
/* Admin * /
save s 0 Save
save	s	0	Save
add-book	ab	4	Add Book to an rating
delete-user	du	1	Delete a User
get-user	gu	1	Get a User by first Name
get-book-by-title	gbbt	1	Get Book by id
create-user	cu	6	Create a user
add-ratings	ar	3	Add Rating
get-all-books	gab	0	Get all Books
get-all-users	gau	0	Get all Users
 
 
## Independent learning.
I learned how to implement and use cliche properly.
I learned that we can use multiple librarys.
I also got a better knowledge of developing an admin and user sub menus.