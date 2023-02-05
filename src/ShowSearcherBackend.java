import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
/*
 * This class implements all the functions to add, get number of shows, and filter.
 */
public class ShowSearcherBackend implements IShowSearcherBackend {
	boolean boolNetflix;
	boolean boolPrime;
	boolean boolHulu;
	boolean boolDisney;
	private HashTableSortedSets<String, IShow> titleList;
	private HashTableSortedSets<Integer, IShow> yearList;
	/*
	 * This is a default constructor.
	 */
	public ShowSearcherBackend() {
		boolNetflix = true;
		boolPrime = true;
		boolHulu = true;
		boolDisney = true;
		
		titleList = new HashTableSortedSets<String, IShow>();
		yearList = new HashTableSortedSets<Integer, IShow>();
	}

	
	/*
	 * This method adds a show to the titleList
	 * 
	 * @param show is the show that is to be added to the list
	 */
	@Override
	public void addShow(IShow show) {
		String[] strings = show.getTitle().replace("[^a-zA-Z]", "").toLowerCase().split("\\s+");

		for (int i = 0; i < strings.length; i++) {
			titleList.add(strings[i], show);
		}
			yearList.add(show.getYear(), show);

	}
	/*
	 * This method returns the number of shows in the titleList
	 * 
	 * @returns the size of titleList
	 */
	@Override
	public int getNumberOfShows() {
		return titleList.size();
	}
	/*
	 * This method sets the filtering by provider
	 * 
	 * @param provider is the provider you want to select.
	 * @param filter is whether if you want to set the provider true or false.
	 */
	@Override
	public void setProviderFilter(String provider, boolean filter) {
		if (provider.equals("Netflix")) {
			boolNetflix = filter;
		}
		if (provider.equals("Hulu")) {
			boolHulu = filter;
		}
		if (provider.equals("Prime Video")) {
			boolPrime = filter;
		}
		if (provider.equals("Disney Plus")) {
			boolDisney = filter;
		}
	}
	/*
	 * This method returns whether if a selected provider filter is on or off
	 * 
	 * @param provider is the filter you want to check.
	 * @returns whether if that filter is on or not.
	 */

	@Override
	public boolean getProviderFilter(String provider) {
		if (provider.equals("Netflix")) {
			return boolNetflix;
		}
		if (provider.equals("Hulu")) {
			return boolHulu;
		}
		if (provider.equals("Prime Video")) {
			return boolPrime;
		}
		if (provider.equals("Disney Plus")) {
			return boolDisney;
		}
		return false;
	}
	/*
	 * This method switches the filter status
	 * 
	 * @param provider is the provider filter you want to change.
	 */

	@Override
	public void toggleProviderFilter(String provider) {
		if (provider.equals("Netflix")) {
			boolNetflix = !boolNetflix;
		}
		if (provider.equals("Hulu")) {
			boolHulu = !boolHulu;
		}
		if (provider.equals("Prime Video")) {
			boolPrime = !boolPrime;
		}
		if (provider.equals("Disney Plus")) {
			boolDisney = !boolDisney;
		}

	}
	/*
	 * This method searches through the list with a keyword and removes every
	 * show that does not contain that keyword.
	 * 
	 * @param word is the keyword that you search for
	 * @returns the list that is searched.
	 */

	  /*
	   * This method searches through the list with a keyword and removes every show that does not
	   * contain that keyword.
	   * 
	   * @param word is the keyword that you search for
	   * 
	   * @returns the list that is searched.
	   */

	  @Override
	  public List<IShow> searchByTitleWord(String word) {
	    // @SuppressWarnings("unchecked")
	    word = word.toLowerCase();
	    try {
	      List<IShow> temp = (List<IShow>) titleList.get(word);
	      List<IShow> newList = new ArrayList<IShow>();
	      for (IShow show : temp) {
	          if (!newList.contains(show)) {
	            if (boolNetflix && show.isAvailableOn("Netflix")) {
	              newList.add(show);
	            } 
	            else if(boolHulu && show.isAvailableOn("Hulu")){
	            	newList.add(show);
	            }
	            else if(boolPrime && show.isAvailableOn("Prime Video")){
	            	newList.add(show);
	            }
	            else if(boolDisney && show.isAvailableOn("Disney Plus")){
	            	newList.add(show);
	            }
	          }
	      }
	      
	      Collections.sort(newList);
	      return newList;
	    } catch (NoSuchElementException e) {
	      List<IShow> notFound = new ArrayList<IShow>();
	      return notFound;
	    }
	  }
	  /*
	   * This method searches through the list with a year and removes every show that does not have
	   * that year.
	   * 
	   * @param year is the year that you search for
	   * 
	   * @returns the list that is searched.
	   */

	  public List<IShow> searchByYear(int year) {
	    // @SuppressWarnings("unchecked")
	    try {
	      List<IShow> temp = (List<IShow>) yearList.get(year);
	      List<IShow> newList = new ArrayList<IShow>();
	      for (IShow show : temp) {
	          if (!newList.contains(show)) {
	            if (boolNetflix && show.isAvailableOn("Netflix")) {
	              newList.add(show);
	            } 
	            else if(boolHulu && show.isAvailableOn("Hulu")){
	            	newList.add(show);
	            }
	            else if(boolPrime && show.isAvailableOn("Prime Video")){
	            	newList.add(show);
	            }
	            else if(boolDisney && show.isAvailableOn("Disney Plus")){
	            	newList.add(show);
	            }
	          }
	      }
	      Collections.sort(newList);
	      return newList;

	    } catch (NoSuchElementException e) {
	      List<IShow> notFound = new ArrayList<IShow>();
	      return notFound;
	    }
	  }
}
