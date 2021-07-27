
import java.util.NoSuchElementException;
import java.util.LinkedList;
public class HashTableMap<KeyType, ValueType> implements  MapADT<KeyType, ValueType> {

	private LinkedList<KeyValue>[] HashTable;
	public int capacity;
	private int size = 0;
	
	
	
	
	public HashTableMap(int capacity) {
		HashTable = new LinkedList[capacity];
		this.capacity = capacity;
	}
	public HashTableMap() {
		// with default capacity = 10
		HashTable = new LinkedList[10];
		this.capacity = 10;
	}
	
	@Override
	public boolean put(KeyType key, ValueType value) {
		// TODO Auto-generated method stub
		
		int i = Math.abs(key.hashCode()) % capacity;
		LinkedList<KeyValue> LinkedNode = HashTable[i];
		 
        if(LinkedNode == null) {
        	LinkedNode = new LinkedList<KeyValue>();
 
        	KeyValue item= new KeyValue(key, value);
            
 
            LinkedNode.add(item);
            HashTable[i] = LinkedNode;
            size++;
            checkSize();
            return true;
        }
        else {
      
        	for (KeyValue item: LinkedNode) {
    			if(item.returnKey().equals(key)) {
    				return false;
    			}
        	}
        	KeyValue item= new KeyValue(key, value);
        	 
        	 LinkedNode.add(item);
        	 size++;
        	checkSize();
        	 return true;
        }
	}
	
	@Override
	public ValueType get(KeyType key) throws NoSuchElementException {
		// TODO Auto-generated method stub
		if (key == null) {
			throw new NoSuchElementException();
		}

		int index = Math.abs(key.hashCode()) % capacity;
		LinkedList<KeyValue> LinkedNode = HashTable[index];
		
		if (LinkedNode == null) {
			throw new NoSuchElementException();
		}
		for (KeyValue item: LinkedNode) {
			if(item.returnKey().equals(key)) {
				return (ValueType) item.returnValue();
			}
		}

		throw new NoSuchElementException();
	}

	@Override
	public int size() { return size;}

	@Override
	public boolean containsKey(KeyType key) {

		int index = Math.abs(key.hashCode()) % capacity;
		if (HashTable[index] == null) {
			return false;
		}
		LinkedList<KeyValue> LinkedNode = HashTable[index];
		
		for (KeyValue item: LinkedNode) {
			if(item.returnKey().equals(key)) {
				return true;
			}
		}

		return false;
	}

	@Override
	public ValueType remove(KeyType key) {
		// TODO Auto-generated method stub

		if (key == null) {
			throw new NoSuchElementException();
		}

		int index = Math.abs(key.hashCode()) % capacity;
		LinkedList<KeyValue> LinkedNode = HashTable[index];

		if (LinkedNode == null) {
			throw new NoSuchElementException();
		}

		for (KeyValue item : LinkedNode) {
			if (item.returnKey().equals(key)) {
				ValueType temp = (ValueType) item.returnValue();
				LinkedNode.remove(item);
				size--;
				return temp;
			}
		}

		return null;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		HashTable = new LinkedList[capacity];
		size = 0;
	}
	
	private void checkSize() {

		if ((1.0 * size) / capacity >= 0.8) {
			LinkedList<KeyValue>[] temp = HashTable;
			capacity = 2 * capacity;
			HashTable = new LinkedList[capacity];
			
			size = 0;

			for (LinkedList<KeyValue> LinkedNode : temp) {
				if (LinkedNode == null) {
					continue;
				}
				for (KeyValue item : LinkedNode) {
					put( (KeyType) item.returnKey(),  (ValueType) item.returnValue());
				}
			}

		}
	}

}
