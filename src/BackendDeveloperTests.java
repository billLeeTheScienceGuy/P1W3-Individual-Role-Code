import java.util.List;
/*
 * This class tests the ShowSearcherBackend method
 */
public class BackendDeveloperTests {
	static Show show1 = new Show("showOne", 2001, 50,"Netflix");
	static Show show2 = new Show("showTwo", 2002, 60,"Hulu");
	static Show show3 = new Show("showThree", 2013, 70,"Prime Video");
	static Show show4 = new Show("showFour", 2024, 80,"Disney Plus");
	static Show show5 = new Show("showFive", 2034, 90,"Disney Plus");
/*
 * This method tests the getNumberOfShows method
 * 
 * @returns true if pass false when fail.
 */
	public static boolean test1() {
		try {
			ShowSearcherBackend Tester1 = new ShowSearcherBackend();
			Tester1.addShow(show1);
			if (Tester1.getNumberOfShows() != 1) {
				System.out.println("1");
				return false;
			}
			Tester1.addShow(show2);
			if (Tester1.getNumberOfShows() != 2) {
				System.out.println("2");
				return false;
			}
			Tester1.addShow(show3);
			if (Tester1.getNumberOfShows() != 3) {
				System.out.println("3");
				return false;
			}
			Tester1.addShow(show4);
			if (Tester1.getNumberOfShows() != 4) {
				System.out.println("4");
				return false;
			}
			Tester1.addShow(show5);
			if (Tester1.getNumberOfShows() != 5) {
				System.out.println("5");
				return false;
			}
			return true;
		} catch (Exception e) {
			return false;
		}

	}
	/*
	 * This method tests the setProviderFilter method with Hulu
	 * 
	 * @returns true if pass false when fail.
	 */
	public static boolean test2() {
		ShowSearcherBackend Tester1 = new ShowSearcherBackend();
		try {
			Tester1.addShow(show1);
			Tester1.addShow(show2);
			Tester1.addShow(show3);
			Tester1.addShow(show4);
			Tester1.addShow(show5);
			Tester1.setProviderFilter("Hulu", false);
			if (Tester1.getProviderFilter("Hulu") == true) {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
		return true;

	}
	/*
	 * This method tests the setProviderFilter method with Netflix
	 * 
	 * @returns true if pass false when fail.
	 */

	public static boolean test3() {
		try {
			ShowSearcherBackend Tester1 = new ShowSearcherBackend();
			Tester1.addShow(show1);
			Tester1.addShow(show2);
			Tester1.addShow(show3);
			Tester1.addShow(show4);
			Tester1.addShow(show5);
			Tester1.setProviderFilter("Netflix", false);
			if (Tester1.getProviderFilter("Netflix") == true) {
				return false;
			}

		} catch (Exception e) {
			return false;
		}
		return true;

	}
	/*
	 * This method tests the setProviderFilter method with Prime Video
	 * 
	 * @returns true if pass false when fail.
	 */

	public static boolean test4() {
		try {
			ShowSearcherBackend Tester1 = new ShowSearcherBackend();
			Tester1.addShow(show1);
			Tester1.addShow(show2);
			Tester1.addShow(show3);
			Tester1.addShow(show4);
			Tester1.addShow(show5);
			Tester1.setProviderFilter("Prime Video", false);
			if (Tester1.getProviderFilter("Prime Video") == true) {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
		return true;

	}
	/*
	 * This method tests the getNumberOfShows method
	 * 
	 * @returns true if pass false when fail.
	 */
	public static boolean test5() {
		try {

			ShowSearcherBackend Tester1 = new ShowSearcherBackend();
			Tester1.addShow(show1);
			Tester1.addShow(show2);
			Tester1.addShow(show3);
			if (Tester1.getNumberOfShows() != 3) {
				return false;
			}
			return true;

		} catch (Exception e) {
			return false;
		}
	}
	/*
	 * This method tests the setProviderFilter method with Disney Plus
	 * 
	 * @returns true if pass false when fail.
	 */

	public static boolean test6() {
		try {
			ShowSearcherBackend Tester1 = new ShowSearcherBackend();
			Tester1.addShow(show1);
			Tester1.addShow(show2);
			Tester1.addShow(show3);
			Tester1.addShow(show4);
			Tester1.addShow(show5);
			Tester1.setProviderFilter("Disney Plus", false);
			if (Tester1.getProviderFilter("Disney Plus") == true) {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	public static boolean test7() {
		ShowSearcherBackend Tester1 = new ShowSearcherBackend();
		try {
		Tester1.addShow(show1);
		Tester1.addShow(show2);
		Tester1.addShow(show3);
		Tester1.addShow(show4);
		Tester1.addShow(show5);
		
		
		if(Tester1.searchByYear(2013).size() != 1) {
			System.out.println(Tester1.getNumberOfShows());
			return false;
		}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public static boolean test8() {
		ShowSearcherBackend Tester1 = new ShowSearcherBackend();
		try {
		Tester1.addShow(show1);
		Tester1.addShow(show2);
		Tester1.addShow(show3);
		Tester1.addShow(show4);
		Tester1.addShow(show5);
		if(Tester1.searchByTitleWord("showone").size() != 1) {
			return false;
		}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public static boolean test9() {
		ShowSearcherBackend Tester1 = new ShowSearcherBackend();
		try {
		Tester1.addShow(show1);
		Tester1.addShow(show2);
		Tester1.addShow(show3);
		Tester1.addShow(show4);
		Tester1.addShow(show5);
		if(Tester1.searchByTitleWord("sHoWoNe").size() != 1) {
			return false;
		}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public static boolean test10() {
		ShowSearcherBackend Tester1 = new ShowSearcherBackend();
		try {
		Tester1.addShow(show1);
		Tester1.addShow(show2);
		Tester1.addShow(show3);
		Tester1.addShow(show4);
		Tester1.addShow(show5);
		 TextUITester tester = new TextUITester("2\n2013\n4");
	      ShowSearcherFrontend frontend = new ShowSearcherFrontend(Tester1);
	      // 2. Run the code that you want to test here:

	      frontend.runCommandLoop(); // (this code should read from System.in and write to System.out)

	      // 3. Check whether the output printed to System.out matches your expectations.
	      String output = tester.checkOutput();
	      if (!output.startsWith("Welcome to the Show Searcher App!")
	          || !output.contains("Command Menu")
	          || !output.contains("2) Search by [Y]ear First Produced")
	          || !output.endsWith("Choose a command from the menu above: "))
	    	  
	        return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public static boolean test11() {
		ShowSearcherBackend Tester1 = new ShowSearcherBackend();
		try {
		Tester1.addShow(show1);
		Tester1.addShow(show2);
		Tester1.addShow(show3);
		Tester1.addShow(show4);
		Tester1.addShow(show5);
		 TextUITester tester = new TextUITester("1\n2013\n4");
	      ShowSearcherFrontend frontend = new ShowSearcherFrontend(Tester1);
	      // 2. Run the code that you want to test here:

	      frontend.runCommandLoop(); // (this code should read from System.in and write to System.out)

	      // 3. Check whether the output printed to System.out matches your expectations.
	      String output = tester.checkOutput();
	      if (!output.startsWith("Welcome to the Show Searcher App!")
	          || !output.contains("Command Menu")
	          || !output.contains("1) Search by [T]itle Word")
	          || !output.endsWith("Choose a command from the menu above: "))
	    	  
	        return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/*
	 * This method runs every method
	 * 
	 * @returns true if pass false when fail.
	 */
	public static boolean runAllTests() {
		boolean result = true;
		if(test1() == false) {
			System.out.println("test one failed");
			result = false;
		}
		if(test2() == false) {
			System.out.println("test two failed");
			result = false;
		}
		if(test3() == false) {
			System.out.println("test three failed");
			result = false;
		}
		if(test4() == false) {
			System.out.println("test four failed");
			result = false;
		}
		if(test5() == false) {
			System.out.println("test five failed");
			result = false;
		}
		if(test6() == false) {
			System.out.println("test six failed");
			result = false;
		}
		if(test7() == false) {
			System.out.println("test seven failed");
			result = false;
		}
		if(test8() == false) {
			System.out.println("test eight failed");
			result = false;
		}
		if(test9() == false) {
			System.out.println("test nine failed");
			result = false;
		}
		if(test10() == false) {
			System.out.println("test ten failed");
			result = false;
		}
		if(test11() == false) {
			System.out.println("test eleven failed");
			result = false;
		}
		if (result == true) {
			System.out.println("All test passed");
		}
		return result;
		
	}
	
	public static void main(String args[]) {
		
		runAllTests();
	}
}
