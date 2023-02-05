import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * This class creates a hashtable of key and value pairs of given types to store and organize the
 * data
 * 
 * @author Dieu-Hien Le
 *
 * @param <K> Object type of the key to store and organize data
 * @param <V> Object type of the value to pair with the key
 */
public class HashtableMap<K, V> implements MapADT<K, V> {
  protected HashNode[] hashArr; // array of linked nodes
  private int hashArrCount = 0; // counter to keep track of elements in array

  /**
   * Constructor which creates a new HashNode array with a given capacity
   * 
   * @param capacity desired size of array
   */
  public HashtableMap(int capacity) {
    hashArr = new HashNode[capacity];
    hashArrCount = 0;
  }

  /**
   * The default constructor which creates a new HashNode array with a capacity of 20
   */
  public HashtableMap() { // with default capacity = 20
    hashArr = new HashNode[20];
    hashArrCount = 0;
  }

  /**
   * This method adds key-value pairs to the hashtable if the key is unique. If there is already an
   * element at the index found from hashing the key, the method will append the pair to the end of
   * a chain
   * 
   * @param key   a key value used to sort and find the pair within the hashtable
   * @param value a value to be stored and associated with the key
   * @return true if the key-value pair is successfully added to the hashtable, false if the key is
   *         null or already exists in the table
   */
  @Override
  public boolean put(K key, V value) {
	    if (key == null || containsKey(key))
	      return false;

	    int index = getIndex(key);
	    int hashCode = Math.abs(Objects.hashCode(key));
	    HashNode<K, V> curr = hashArr[index];

	    while (curr != null) {
	      if (curr.getKey().equals(key) && hashCode == Math.abs(Objects.hashCode(curr.getKey()))) {
	        curr.setValue(value);
	      }
	      if (curr.next() == null)
	        break;
	      curr = curr.next();
	    }


	    hashArrCount++;
	    HashNode<K, V> newNode = new HashNode<K, V>(key, value);
	    if (curr == null) {
	      hashArr[index] = newNode;
	    } else {
	      curr.setNextNode(newNode);
	    }

	    if ((double) size() / hashArr.length >= .75)
	      resize();
	    return true;
	  }

	  /**
	   * This method gets the value associated with a key if the key currently exists in the hashtable
	   * 
	   * @param key a key used to search for the key-value pair
	   * @return the value associated with the key
	   * @throws NoSuchElementException if the key is null or does not exist in the hashtable
	   */
	  @Override
	  public V get(K key) throws NoSuchElementException {
	    if (key == null)
	        throw new NoSuchElementException("Key is null");
	    int index = getIndex(key);
	    int hashCode = Math.abs(Objects.hashCode(key));
	    HashNode<K, V> curr = hashArr[index];

	    while (curr != null) {
	      if (curr.getKey().equals(key) && hashCode == Math.abs(Objects.hashCode(curr.getKey()))) {
	        return curr.getValue();
	      }
	      curr = curr.next();
	    }
	    throw new NoSuchElementException("Key does not exist in hashtable");
	  }

	  /**
	   * This private helper method, given a key, calculates an index based on the hashcode of an
	   * element
	   * 
	   * @param key a key value to help calculate and index
	   * @return an int index value
	   */
	  private int getIndex(K key) {
	    return Math.abs(key.hashCode()) % hashArr.length;
	  }

	  /**
	   * This method returns the current amount of elements stored in the hashtable
	   * 
	   * @return hashArrCount
	   */
	  @Override
	  public int size() {
	    return hashArrCount;
	  }

	  /**
	   * This private helper method creates a new temp array to hold the current array and re-puts all
	   * the elements onto a new array, that is double the current length, when the load factor of the
	   * current one goes over 75%
	   */
	  private void resize() {
		    HashNode[] temp = hashArr;
		    hashArr = new HashNode[hashArr.length * 2];
		    hashArrCount = 0;

		    for (HashNode<K, V> curr : temp) {
		      while (curr != null) {
		        put(curr.getKey(), curr.getValue());
		        curr = curr.next();
		      }
		    }
		  }

		  /**
		   * This method iterates through the hashtable to see if a given key already exists in the
		   * hashtable
		   * 
		   * @param key a key object to tell containsKey() what to look for
		   * @return true if the key already exists, false otherwise;
		   */
		  @Override
		  public boolean containsKey(K key) {
		    int index = getIndex(key);
		    int hashCode = Math.abs(Objects.hashCode(key));
		    HashNode<K, V> curr = hashArr[index];

		    while (curr != null) {
		      if (curr.getKey().equals(key) && hashCode == Math.abs(Objects.hashCode(curr.getKey()))) {
		        return true;
		      }
		      curr = curr.next();
		    }
		    return false;
		  }

		  /**
		   * This method removes a key-value pair given a key and returns the associated value after removal
		   * 
		   * @param key a Key object used to get the index
		   * @return a Value object of the value associated with the key
		   */
		  @Override
		  public V remove(K key) {
			    if (key == null)
			      return null;
			    int index = getIndex(key);
			    int hashCode = Math.abs(Objects.hashCode(key));

			    HashNode<K, V> curr = hashArr[index];
			    HashNode<K, V> prev = null;
			    while (curr != null) {
			      if (curr.getKey().equals(key) && hashCode == Math.abs(Objects.hashCode(curr.getKey()))) {
			        break;
			      }
			      prev = curr;
			      curr = curr.next();
			    }

			    if (curr == null) {
			      return null;
			    }

			    hashArrCount--;

			    if (prev != null) {
			      prev.setNextNode(curr.next());
			    } else {
			      hashArr[index] = curr.next();
			    }
			    return curr.getValue();
			  }

			  /**
			   * This method clears the hashtable by removing the reference to the first link in each chain and
			   * setting it to null
			   */
			  @Override
			  public void clear() {
			    for (int i = 0; i < hashArr.length; i++) {
			      hashArr[i] = null;
			    }
			  }
			}
	  