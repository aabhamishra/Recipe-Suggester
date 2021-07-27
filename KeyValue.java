
public class KeyValue<KeyType, ValueType>{
	private KeyType key;
	private ValueType value;

	public KeyValue(KeyType key, ValueType value) {
		this.key = key;
		this.value = value;
	}
	
	/**
	 * Getter method for the key
	 * @return KeyType - returns the key
	 */
	public KeyType returnKey() {
		return key;
	}
	/**
	 * Getter method for the value
	 * @return ValueType - returns the value
	 */
	public ValueType returnValue() {
		return value;
	}
}