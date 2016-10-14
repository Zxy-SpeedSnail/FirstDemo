package LruDemo;

/**
 * Created by yuan on 16-8-11.
 */

import java.util.LinkedHashMap;
import java.util.Collection;
import java.util.Map;
import java.util.ArrayList;

/**
 * An LRU cache, based on LinkedHashMap.
 *
 *


 * This cache has a fixed maximum number of elements (cacheSize).
 * If the cache is full and another entry is added, the LRU (least recently used) entry is dropped.
 *
 *


 * This class is thread-safe. All methods of this class are synchronized.
 *
 *


 * Author: Christian d'Heureuse, Inventec Informatik AG, Zurich, Switzerland

 * Multi-licensed: EPL / LGPL / GPL / AL / BSD.
 */
public class LRUCacheLinkHash {

    private static final float   hashTableLoadFactor = 0.75f;

    private LinkedHashMap map;
    private int  cacheSize;

    /**
     * Creates a new LRU cache.
     * @param cacheSize the maximum number of entries that will be kept in this cache.
     */
    public LRUCacheLinkHash (int cacheSize) {
        this.cacheSize = cacheSize;
        int hashTableCapacity = (int)Math.ceil(cacheSize / hashTableLoadFactor) + 1;
        map = new LinkedHashMap(hashTableCapacity, hashTableLoadFactor, true) {
            // (an anonymous inner class)
            private static final long serialVersionUID = 1;
            @Override protected boolean removeEldestEntry (Map.Entry eldest) {
                return size() > LRUCacheLinkHash.this.cacheSize; }}; }

    /**
     * Retrieves an entry from the cache.

     * The retrieved entry becomes the MRU (most recently used) entry.
     * @param key the key whose associated value is to be returned.
     * @return    the value associated to this key, or null if no value with this key exists in the cache.
     */
    public synchronized String get (String key) {
        return (String)map.get(key);
    }

    /**
     * Adds an entry to this cache.
     * The new entry becomes the MRU (most recently used) entry.
     * If an entry with the specified key already exists in the cache, it is replaced by the new entry.
     * If the cache is full, the LRU (least recently used) entry is removed from the cache.
     * @param key    the key with which the specified value is to be associated.
     * @param value  a value to be associated with the specified key.
     */
    public synchronized void put (String key, String value) {
        map.put (key, value);
    }

    /**
     * Clears the cache.
     */
    public synchronized void clear() {
        map.clear();
    }

    /**
     * Returns the number of used entries in the cache.
     * @return the number of entries currently in the cache.
     */
    public synchronized int usedEntries() {
        return map.size();
    }

/**
 * Returns a Collection that contains a copy of all cache entries.
 * @return a Collection with a copy of the cache content.
 */
    public synchronized Collection getAll() {
        return new ArrayList(map.entrySet());
    }

 // end class LRUCache

// Test routine for the LRUCache class.
public static void main (String[] args) {
    LRUCacheLinkHash c = new LRUCacheLinkHash(3);
        c.put ("1", "one");                           // 1
        c.put ("2", "two");                           // 2 1
        c.put ("3", "three");                         // 3 2 1
        c.put ("4", "four");                          // 4 3 2
        if (c.get("2") == null) throw new Error();    // 2 4 3
        c.put ("5", "five");                          // 5 2 4
        c.put ("4", "second four");                   // 4 5 2
        // Verify cache content.
        if (c.usedEntries() != 3)              throw new Error();
        if (!c.get("4").equals("second four")) throw new Error();
        if (!c.get("5").equals("five"))        throw new Error();
        if (!c.get("2").equals("two"))         throw new Error();
        // List cache content.
//        for (Map.Entry e : (Map.Entry)c.getAll())
//        System.out.println (e.getKey() + " : " + e.getValue());
}
}