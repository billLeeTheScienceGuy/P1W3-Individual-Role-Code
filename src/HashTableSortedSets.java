import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
/**
 * This class is implemented by a hashtable that stores a list of values associated with each unique
 * key. These lists of values are sorted according to the compareTo() defined within the ValueType.
 */
public class HashTableSortedSets<KeyType, ValueType extends Comparable<ValueType>> extends
    HashtableMap<KeyType, List<ValueType>> implements IHashTableSortedSets<KeyType, ValueType> {
  /**
   * Constructor which calls HashtableMap constructor with a given capacity
   * 
   * @param capacity desired size of array
   */
  public HashTableSortedSets(int capacity) {
    super(capacity);
  }
  /**
   * The default constructor which calls HashtableMap constructor
   */
  public HashTableSortedSets() { // with default capacity = 20
    super();
  }
  /**
   * This add method is different from the put() method in that it appends a single value to the end
   * of the list associated with a given key. If a key does not yet have a list of values associated
   * with it, then a new one will be created when this method is called.
   * 
   * @param key   used to later lookup the list containing this value
   * @param value associated with the previous key
   */
  @Override
  public void add(KeyType key, ValueType value) {
    if (key == null || value == null)
      return;
    List<ValueType> listVal = new ArrayList<>();
    if (!containsKey(key)) {
      listVal.add(value);
      put(key, listVal);
    } else {
      listVal = (ArrayList<ValueType>) get(key);
      listVal.add(value);
    }
    Collections.sort(listVal);
  }

}