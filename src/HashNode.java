/**
 * This class pairs a KeyType key to a ValueType value
 * 
 * @author Dieu-Hien
 *
 * @param <KeyType>
 * @param <ValueType>
 */
public class HashNode<KeyType, ValueType> {
  private KeyType key;
  private ValueType value;
  private HashNode<KeyType, ValueType> nextNode;


  public HashNode(KeyType key, ValueType value) {
    this.key = key;
    this.value = value;
  }

  public KeyType getKey() {
    return key;
  }

  public ValueType getValue() {
    return value;
  }

  public HashNode<KeyType, ValueType> next() {
    return nextNode;
  }

  public void setKey(KeyType key) {
    this.key = key;
  }

  public void setValue(ValueType value) {
    this.value = value;
  }

  public void setNextNode(HashNode<KeyType, ValueType> node) {
    nextNode = node;
  }
}