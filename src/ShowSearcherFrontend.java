import java.util.List;
import java.util.Scanner;

/**
 * Instances of classes that implement this interface can be used to drive a console-based text user
 * interface for the ShowSearcher App.
 * 
 * @author Rebecca Lehner
 */
public class ShowSearcherFrontend implements IShowSearcherFrontend {
  Scanner scanner;
  IShowSearcherBackend backend;
  String input;

  /**
   * Constructor
   * 
   * @param backend contains list of shows and necessary methods
   */
  public ShowSearcherFrontend(IShowSearcherBackend backend) {
    scanner = new Scanner(System.in);
    this.backend = backend;
  }

  /**
   * Constructor
   * 
   * @param input   reads all user input as this String
   * @param backend contains list of shows and necessary methods
   */
  public ShowSearcherFrontend(String input, IShowSearcherBackend backend) {
    this.backend = backend;
    this.input = input;
  }

  @Override
  /**
   * This method drives the entire read, eval, print loop (repl) for the Song Search App. This loop
   * will continue to run until the user explicitly enters the quit command.
   */
  public void runCommandLoop() {
    System.out.println("Welcome to the Show Searcher App!\n=================================");
    while (true) {
      displayCommandMenu();

      // User entered quit command
      if (input.equalsIgnoreCase("Q") || input.contains("4"))
        return;
    }
  }

  @Override
  /**
   * prints command options to System.out and calls methods based on user response
   */
  public void displayCommandMenu() {
    System.out.println("Command Menu: ");
    System.out.println("\t1) Search by [T]itle Word ");
    System.out.println("\t2) Search by [Y]ear First Produced ");
    System.out.println("\t3) [F]ilter by Streaming Provider");
    System.out.println("\t4) [Q]uit");
    System.out.print("Choose a command from the menu above: ");

    if (scanner != null)
      this.input = scanner.nextLine();

    if (input.length() != 1)
      displayCommandMenu(); // invalid input, retry

    else if (input.equalsIgnoreCase("T") || input.contains("1"))
      titleSearch();
    else if (input.equalsIgnoreCase("Y") || input.contains("2"))
      yearSearch();
    else if (input.equalsIgnoreCase("F") || input.contains("3"))
      setFilter();
    else if (input.equalsIgnoreCase("Q") || input.contains("4"))
      return;
    else // invalid input, retry
      displayCommandMenu();
  }

  @Override
  /*
   * reads word from System.in, displays results
   */
  public void titleSearch() {
    System.out.print("Choose a word that you would like to search for: ");

    if (scanner != null)
      this.input = scanner.nextLine();

    displayShows(backend.searchByTitleWord(input));
  }

  @Override
  /*
   * reads year from System.in, displays results
   */
  public void yearSearch() {
    System.out.print("Choose a year that you would like to search for: ");

    if (scanner != null)
      this.input = scanner.nextLine();
    try {
      Integer.parseInt(input);
    } catch (Exception e) {
      yearSearch();
      return;
    }
    displayShows(backend.searchByYear(Integer.parseInt(input)));
  }

  /**
   * Sets a show to be filtered on or off
   */
  private void setFilter() {
    String netflixToggle = "x";
    String huluToggle = "x";
    String primeVideoToggle = "x";
    String disneyToggle = "x";

    if (!backend.getProviderFilter("Netflix"))
      netflixToggle = "_";
    if (!backend.getProviderFilter("Hulu"))
      huluToggle = "_";
    if (!backend.getProviderFilter("Prime Video"))
      primeVideoToggle = "_";
    if (!backend.getProviderFilter("Disney Plus"))
      disneyToggle = "_";

    System.out.println("Providers that shows are being searched for: ");
    System.out.println("\t1) _" + netflixToggle + "_ [N]etflix");
    System.out.println("\t2) _" + huluToggle + "_ [H]ulu");
    System.out.println("\t3) _" + primeVideoToggle + "_ [P]rime Video");
    System.out.println("\t4) _" + disneyToggle + "_ [D]isney Plus");
    System.out.println("\t5) [Q]uit toggling provider filters");
    System.out.println("Choose a command from the menu above: ");

    if (scanner != null)
      this.input = scanner.nextLine();

    if (input.length() != 1) {
      setFilter(); // invalid input, retry
      return;
    }
    else if (input.equalsIgnoreCase("N") || input.contains("1"))
      backend.toggleProviderFilter("Netflix");
    else if (input.equalsIgnoreCase("H") || input.contains("2"))
      backend.toggleProviderFilter("Hulu");
    else if (input.equalsIgnoreCase("P") || input.contains("3"))
      backend.toggleProviderFilter("Prime Video");
    else if (input.equalsIgnoreCase("D") || input.contains("4"))
      backend.toggleProviderFilter("Disney");
    else if (input.equalsIgnoreCase("Q") || input.contains("5")) {
      displayCommandMenu();
      return;
    }
      setFilter();

  }

  @Override
  /**
   * displays a list of shows
   * 
   * @param shows list of shows to be displayed
   */
  public void displayShows(List<IShow> shows) {

    System.out.println("Found " + shows.size() + " matches.");

    for (int i = 0; i < shows.size(); i++) {
      System.out.println(i + 1 + ". " + shows.get(i).getTitle());
      System.out
          .print("\t" + shows.get(i).getRating() + "/100 (" + shows.get(i).getYear() + ") on: ");

      // Check providers
      if (shows.get(i).isAvailableOn("Netflix"))
        System.out.print("Netflix ");
      if (shows.get(i).isAvailableOn("Hulu"))
        System.out.print("Hulu ");
      if (shows.get(i).isAvailableOn("Prime Video"))
        System.out.print("Prime Video ");
      if (shows.get(i).isAvailableOn("Disney+"))
        System.out.print("Disney+ ");
      System.out.println();
    }
  }



}
