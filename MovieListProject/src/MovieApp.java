import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MovieApp {
	
	public static ArrayList<Movie> movieList = new ArrayList<>();
	public static ArrayList<String> categoryList = new ArrayList<>();
	public static Scanner scnr = new Scanner(System.in);

	public static void main(String[] args) {
		loadMovieList();
		System.out.println("Welcome to the Movie List Application!\n");
		displayCategoryMenu();
		System.out.println("\nThere are " + movieList.size() + " movies in this list.");
		boolean repeat = true;
		
		while (repeat) {
			System.out.print("Which category are you interested in? (Enter category number) ");
			String responseHolder = scnr.nextLine();
			if (responseHolder.isEmpty()) {
				System.out.println("You've got to choose something!");
			} else {
				try {
					int userCategoryChoice = Integer.valueOf(responseHolder);
					if (1 > userCategoryChoice || categoryList.size() < userCategoryChoice) {
						System.out.println("That isn't a recognized category. ");
					} else {
						String userCategoryString = categoryList.get(userCategoryChoice - 1);
						for (Movie x : movieList) {
							if (x.getCategory().equals(userCategoryString)) {
								System.out.println(x.getTitle());
							}
						}
					}
				} catch (InputMismatchException e) {
					System.out.println("That isn't a number.");
					scnr.next();
				}
			}
			
			repeat = optionToContinue();
		}
		System.out.println("Have a nice day!");
		scnr.close();
	}
	
	public static boolean optionToContinue() {
		System.out.print("\nContinue? y/n ");
		String userChoice = scnr.nextLine();
		if (userChoice.equalsIgnoreCase("n")) {
			return false;
		} else if (!userChoice.equalsIgnoreCase("y")) {
			System.out.println("Invalid response. ");
			return optionToContinue();
		}
		return true;
	}
	
	public static void loadMovieList() {
		movieList.add(new Movie("The Big Lebowski", "Comedy"));
		movieList.add(new Movie("A Quiet Place", "Horror"));
		movieList.add(new Movie("Die Hard", "Action"));
		movieList.add(new Movie("Before Sunrise", "Romance"));
		movieList.add(new Movie("Midnight Special", "SciFi"));
		movieList.add(new Movie("A Night at the Roxbury", "Comedy"));
		movieList.add(new Movie("Hereditary", "Horror"));
		movieList.add(new Movie("The Bourne Identity", "Action"));
		movieList.add(new Movie("Arrival", "SciFi"));
		movieList.add(new Movie("Her", "SciFi"));
		
		for (int i = 1; i <= 100; i++) {
			movieList.add(MoviesIO.getMovie(i));
		}
		movieList.sort(Comparator.comparing(Movie::getTitle));
	}

	public static void displayCategoryMenu() {
		//load categoryList from movieList categories
		for (int i = 0; i < movieList.size(); i++) {
			if (!categoryList.contains(movieList.get(i).getCategory())) {
				categoryList.add(movieList.get(i).getCategory());
			}
		}
		//alphabetize
		Collections.sort(categoryList);
		System.out.println("The categories in this list are:");
		for (int i = 0; i < categoryList.size(); i++) {
			System.out.println((i+1) + ": " + categoryList.get(i));
		}
	}
	
}
