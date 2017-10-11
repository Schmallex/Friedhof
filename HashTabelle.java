package algodat;

import java.util.*;

public class HashTabelle implements Map {

    private LinkedList<AbstractMap.SimpleEntry>[] hashArray;

    /**
     * Funktion zur Erzeugung eines HashTabellen Objekts.
     *
     * @param size sei die Groesse der erzeugten Tabelle.
     */
    public HashTabelle(int size) {
        this.hashArray = new LinkedList[size];
    }

    /**
     * Hilfsfunktion zur Berechnung des Indexes in dem Array
     *
     * @param key sei der Schluessel
     * @return ein Wert zwischen 0 und der Länge des Arrays -1
     */
    public int hashCode(Object key) {
        return key.hashCode() % hashArray.length;
    }

    /**
     * Fuegt mithilfe von hashCode an einer Stelle im Array das Key Value Pair ein.
     * Falls ein Key bereits vorhanden ist wird das alte geloescht und das neue an dieser STelle eingefügt.
     *
     * @param key   sei ein beliebiges Objekt,
     * @param value sei ein beliebiges Objekt
     * @return null falls nicht derselbe Key an der Stelle vorhanden ist oder der vorherige Value
     */

    public Object put(Object key, Object value) {
        int index = hashCode(key);
        if (hashArray[index] == null) {
            hashArray[index] = new LinkedList<>();
            hashArray[index].add(new AbstractMap.SimpleEntry<>(key, value));
            return null;

        } else {
            for (int i = 0; i < hashArray[hashCode(key)].size() - 1; i++) {
                if (hashArray[index].get(i).getKey().equals(key)) {
                    Object val = hashArray[hashCode(key)].get(i).getValue();
                    hashArray[index].get(i).setValue(value);
                    return val;
                }
            }
            hashArray[index].add(new AbstractMap.SimpleEntry<>(key, value));
            return null;
        }
    }

    /**
     * Gibt ,falls vorhanden, den Value von Key zurueck
     *
     * @param key sei ein Key der in der Liste enthalten ist
     * @return Der Value zum entsprechenden Key oder null wenn der Key nicht vorhanden ist.
     */

    @Override
    public Object get(Object key) {
        try {
            for (int i = 0; i < hashArray[hashCode(key)].size() - 1; i++) {
                if (hashArray[hashCode(key)].get(i).getKey().equals(key)) {
                    return hashArray[hashCode(key)].get(i).getValue();
                }
            }
            return null;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    /**
     * Entfernt das zugehoerige Key Value Pair aus der Tabelle.
     *
     * @param key sei ein in der Tabelle enthaltener Key
     * @return der gelöschte Value
     */

    @Override
    public Object remove(Object key) {
        try {
            for (int i = 0; i < hashArray[hashCode(key)].size() - 1; i++) {
                if (hashArray[hashCode(key)].get(i).getKey().equals(key)) {
                    Object val = hashArray[hashCode(key)].get(i).getValue();
                    hashArray[hashCode(key)].remove(i);
                    return val;
                }
            }
            return null;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    /**
     * Gibt an ob die Hashtabelle leer ist.
     *
     * @return true, wenn sie leer ist.
     */
    @Override
    public boolean isEmpty() {
        if (hashArray.length == 0) {
            return true;
        } else {
            for (int i = 0; i < hashArray.length; i++) {
                if (hashArray[i] != null) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Gibt an ob die Hashtabelle den Key enthaelt.
     *
     * @param key sei ein beliebiges Objekt
     * @return true, wenn der key enthalten ist
     */
    @Override
    public boolean containsKey(Object key) {
        try {
            if (get(key) != null) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
    }

    /**
     * Gibt an ob die Hashtabelle den Value enthaelt.
     *
     * @param value sei ein beliebiges Objekt
     * @return true, wenn es enthalten ist.
     */

    @Override
    public boolean containsValue(Object value) {
        try {
            for (int i = 0; i < hashArray.length; i++) {
                if (hashArray[i] == null) {
                    continue;
                } else {
                    for (int il = 0; il < hashArray[hashCode(i)].size() - 1; il++) {
                        if (hashArray[hashCode(i)].get(il).getValue().equals(value)) {
                            return true;
                        }
                    }
                }
            }
            return false;

        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
    }


    /**
     * Hilfsfunktion zur Berechnung der Groesse der HashTabelle
     *
     * @return die Groesse der HashTabelle
     */
    public int size() {
        return hashArray.length;
    }

    @Override
    public void putAll(Map m) {

    }

    public void clear() {

    }

    @Override
    public Set keySet() {
        return null;
    }

    @Override
    public Collection values() {
        return null;
    }

    @Override
    public Set<Entry> entrySet() {
        return null;
    }
}