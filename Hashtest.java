package algodat;

/**
 * Created by Alex on 31.05.2017.
 */
public class Hashtest {
    public static void main(String[] args) {
        HashTabelle tabel = new HashTabelle(16);
        HashTabelle tabell = new HashTabelle(8);
        System.out.println(tabel.isEmpty());
        System.out.println(tabel.put(0, tabell));
        System.out.println(tabel.isEmpty());
        System.out.println("Tabelle enthält tabel1" + tabel.containsValue(tabell));
        System.out.println(tabel.put(0, "bla"));
        System.out.println(tabel.containsValue("bla")+"entält value bla");
        System.out.println(tabel.containsKey(0)+"enthält den key 0");
        System.out.println(tabel.remove(0));
        System.out.println(tabel.containsKey(0));
        tabel.get(89);

    }

    public static int hashCode(Object value) {
        return value.hashCode() % 16;

    }
}
