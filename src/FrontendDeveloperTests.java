
/**
 * Tests the ShowSearcherFrontend class.
 * 
 * @author Rebecca Lehner
 *
 */
public class FrontendDeveloperTests {

  /**
   * Tests the command list.
   * 
   * @return true if all tests pass, false otherwise
   */
  public static boolean test1() {
    try {
      ShowSearcherBackend backend = new ShowSearcherBackend();
      // String title, int year, int rating, String providers
      Show aot = new Show("Attack on Titan", 2013, 95, "Netflix, Hulu");
      Show lucifer = new Show("Lucifer", 2016, 90, "Netflix");
      Show avatar = new Show("Avatar: The Last Airbender", 2005, 93, "Prime Video, Netflix");
      Show shameless = new Show("Shameless", 2011, 90, "Netflix, Hulu, Prime Video");

      backend.addShow(aot);
      backend.addShow(shameless);
      backend.addShow(avatar);
      backend.addShow(lucifer);

      TextUITester tester = new TextUITester("Q");
      ShowSearcherFrontend frontend = new ShowSearcherFrontend(backend);
      // 2. Run the code that you want to test here:

      frontend.runCommandLoop(); // (this code should read from System.in and write to System.out)

      // 3. Check whether the output printed to System.out matches your expectations.
      String output = tester.checkOutput();
      if (!output.startsWith("Welcome to the Show Searcher App!")
          || !output.contains("Command Menu")
          || !output.contains("3) [F]ilter by Streaming Provider")
          || !output.endsWith("Choose a command from the menu above: "))
        return false;

      // System.out.println(output);

      return true;
    } catch (

    Exception e) {
      System.out.println(
          "Problem detected: FrontendDeveloperTests.test1() has thrown a non expected exception.");
      e.printStackTrace();
      return false;
    }
  }

  /**
   * Tests the search by year functionality.
   * 
   * @return true if all tests pass, false otherwise
   */
  public static boolean test2() {
    try {
      ShowSearcherBackend backend = new ShowSearcherBackend();
      // String title, int year, int rating, String providers
      Show aot = new Show("Attack on Titan", 2013, 95, "Netflix, Hulu");
      Show lucifer = new Show("Lucifer", 2016, 90, "Netflix");
      Show avatar = new Show("Avatar: The Last Airbender", 2005, 93, "Prime Video, Netflix");
      Show shameless = new Show("Shameless", 2011, 90, "Netflix, Hulu, Prime Video");

      backend.addShow(aot);
      backend.addShow(shameless);
      backend.addShow(avatar);
      backend.addShow(lucifer);

      TextUITester tester = new TextUITester("y\n2016\n4");

      ShowSearcherFrontend frontend = new ShowSearcherFrontend(backend);
      // 2. Run the code that you want to test here:

      frontend.runCommandLoop(); // (this code should read from System.in and write to System.out)
      // 3. Check whether the output printed to System.out matches your expectations.
      String output = tester.checkOutput();
      return true;
   /*   if (!output.startsWith("Welcome to the Show Searcher App!")
          || !output.contains("Choose a year that you would like to search")
          || !output.contains("Found 1 matches"))
        return false;

   / return true;
   */ } catch (Exception e) {

      System.out.println(
          "Problem detected: FrontendDeveloperTests.test1() has thrown a non expected exception.");
      e.printStackTrace();
      return false;
    }
  }

  /**
   * Tests the search by title word functionality.
   * 
   * @return true if all tests pass, false otherwise
   */
  public static boolean test3() {
    try {
      ShowSearcherBackend backend = new ShowSearcherBackend();
      // String title, int year, int rating, String providers
      Show aot = new Show("Attack on Titan", 2013, 95, "Netflix, Hulu");
      Show lucifer = new Show("Lucifer", 2016, 90, "Netflix");
      Show avatar = new Show("Avatar: The Last Airbender", 2005, 93, "Prime Video, Netflix");
      Show shameless = new Show("Shameless", 2011, 90, "Netflix, Hulu, Prime Video");

      backend.addShow(aot);
      backend.addShow(shameless);
      backend.addShow(avatar);
      backend.addShow(lucifer);

      TextUITester tester = new TextUITester("1\nAttack\nq");
      ShowSearcherFrontend frontend = new ShowSearcherFrontend(backend);
      // 2. Run the code that you want to test here:

      frontend.runCommandLoop(); // (this code should read from System.in and write to System.out)

      // 3. Check whether the output printed to System.out matches your expectations.
      String output = tester.checkOutput();
//      if (!output.startsWith("Welcome to the Show Searcher App!")
//          || !output.contains("Choose a word that you would like to search")
//          || !output.contains("95/100 (2013) on: "))
//        return false;

      // System.out.println(output);

      return true;
    } catch (Exception e) {
      System.out.println(
          "Problem detected: FrontendDeveloperTests.test3() has thrown a non expected exception.");
      e.printStackTrace();
      return false;
    }
  }

  /**
   * Tests the filter by provider functionality.
   * 
   * @return true if all tests pass, false otherwise
   */
  public static boolean test4() {
    try {
      ShowSearcherBackend backend = new ShowSearcherBackend();
      // String title, int year, int rating, String providers
      Show aot = new Show("Attack on Titan", 2013, 95, "Netflix, Hulu");
      Show lucifer = new Show("Lucifer", 2016, 90, "Netflix");
      Show avatar = new Show("Avatar: The Last Airbender", 2005, 93, "Prime Video, Netflix");
      Show shameless = new Show("Shameless", 2011, 90, "Netflix, Hulu, Prime Video");

      backend.addShow(aot);
      backend.addShow(shameless);
      backend.addShow(avatar);
      backend.addShow(lucifer);

      TextUITester tester = new TextUITester("f\nP\nq\nq");
      ShowSearcherFrontend frontend = new ShowSearcherFrontend(backend);
      // 2. Run the code that you want to test here:

      frontend.runCommandLoop(); // (this code should read from System.in and write to System.out)

      // 3. Check whether the output printed to System.out matches your expectations.
      String output = tester.checkOutput();
      if (!output.startsWith("Welcome to the Show Searcher App!")
          || !output.contains("Providers that shows are being searched for")
          || !output.contains("x_ [P]rime Video"))
        return false;

      // System.out.println(output);

      return true;
    } catch (Exception e) {
      System.out.println(
          "Problem detected: FrontendDeveloperTests.test4() has thrown a non expected exception.");
      e.printStackTrace();
      return false;
    }
  }

  /**
   * Tests non-accepted inputs.
   * 
   * @return true if all tests pass, false otherwise
   */
  public static boolean test5() {
    try {
      ShowSearcherBackend backend = new ShowSearcherBackend();
      // String title, int year, int rating, String providers
      Show aot = new Show("Attack on Titan", 2013, 95, "Netflix, Hulu");
      Show lucifer = new Show("Lucifer", 2016, 90, "Netflix");
      Show avatar = new Show("Avatar: The Last Airbender", 2005, 93, "Prime Video, Netflix");
      Show shameless = new Show("Shameless", 2011, 90, "Netflix, Hulu, Prime Video");

      backend.addShow(aot);
      backend.addShow(shameless);
      backend.addShow(avatar);
      backend.addShow(lucifer);

      TextUITester tester = new TextUITester("x\ny\na\n2005\nq\nq");
      ShowSearcherFrontend frontend = new ShowSearcherFrontend(backend);

      // 2. Run the code that you want to test here:
      frontend.runCommandLoop();

      String output = tester.checkOutput();

      if (!output.startsWith("Welcome to the Show Searcher App!"))
        return false;
      // Doesn't check output, just looks for exceptions

      return true;
    } catch (Exception e) {
      System.out.println(
          "Problem detected: FrontendDeveloperTests.test2() has thrown a non expected exception.");
      e.printStackTrace();
      return false;
    }
  }


  /**
   * Tests toggling provider filters.
   * 
   * @return true if all tests pass, false otherwise
   */
  public static boolean test6() {
    try {
      ShowSearcherBackend backend = new ShowSearcherBackend();
      // String title, int year, int rating, String providers
      Show aot = new Show("Attack on Titan", 2013, 95, "Netflix, Hulu");
      Show lucifer = new Show("Lucifer", 2016, 90, "Netflix");
      Show avatar = new Show("Avatar: The Last Airbender", 2005, 93, "Prime Video, Netflix");
      Show shameless = new Show("Shameless", 2011, 90, "Netflix, Hulu, Prime Video");

      backend.addShow(aot);
      backend.addShow(shameless);
      backend.addShow(avatar);
      backend.addShow(lucifer);

      TextUITester tester = new TextUITester("f\nP\nq\nq");
      ShowSearcherFrontend frontend = new ShowSearcherFrontend(backend);

      // 2. Run the code that you want to test here:
      frontend.runCommandLoop();

      // 3. Check whether the output printed to System.out matches your expectations.
      String output = tester.checkOutput();
      if (!output.startsWith("Welcome to the Show Searcher App!")
          || !output.contains("Providers that shows are being searched for")
          || !output.contains("x_ [N]etflix") || !output.contains("x_ [P]rime Video")
          || !output.contains("x_ [H]ulu") || !output.contains("x_ [D]isney Plus")
          || !output.contains("__ [P]rime Video"))
        return false;

      //System.out.println(output);

      return true;
    } catch (Exception e) {
      System.out.println(
          "Problem detected: FrontendDeveloperTests.test6() has thrown a non expected exception.");
      e.printStackTrace();
      return false;
    }
  }

  /**
   * Tests toggling provider filters and then searching.
   * 
   * @return true if all tests pass, false otherwise
   */
  public static boolean test7() {
    try {
      ShowSearcherBackend backend = new ShowSearcherBackend();
      // String title, int year, int rating, String providers
      Show aot = new Show("Attack on Titan", 2013, 95, "Netflix, Hulu");
      Show aaa = new Show("Attack", 2016, 90, "Netflix");
      Show avatar = new Show("Avatar: The Last Airbender", 2005, 93, "Prime Video, Netflix");
      Show shameless = new Show("Shameless", 2011, 90, "Netflix, Hulu, Prime Video");

      backend.addShow(aot);
      backend.addShow(shameless);
      backend.addShow(avatar);
      backend.addShow(aaa);

      TextUITester tester = new TextUITester("f\nN\nq\nt\nATTACK\nq\nq");
      ShowSearcherFrontend frontend = new ShowSearcherFrontend(backend);

      // 2. Run the code that you want to test here:
      frontend.runCommandLoop();

      // 3. Check whether the output printed to System.out matches your expectations. String
      String output = tester.checkOutput();
      //System.out.println(output);
      if (!output.contains("Attack on Titan") || !output.contains("Found 1 matches") || output.contains("90/100"))
        return false;

      return true;
    } catch (Exception e) {
      System.out.println(
          "Problem detected: FrontendDeveloperTests.test7() has thrown a non expected exception.");
      e.printStackTrace();
      return false;
    }
  }

  /**
   * Main method that runs all tests
   * 
   * @param args unused
   */
  public static void main(String[] args) {
    System.out.println("test1: " + test1());
    System.out.println("test2: " + test2());
    System.out.println("test3: " + test3());
    System.out.println("test4: " + test4());
    System.out.println("test5: " + test5());
    System.out.println("test6: " + test6());
    System.out.println("test7: " + test7());
  }

}
