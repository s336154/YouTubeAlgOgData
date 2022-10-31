import java.util .*;

public class ExamsModules {


    public interface Kø<T> // eng: Queue
    {
     //   public boolean leggInn(T verdi); // eng: offer/add/enqueue inn bakerst
        public void leggInn(T verdi);
        public T kikk(); // eng: peek/element/front den første
        public T taUt(); // eng: poll/remove/dequeue tar ut den første
        public int antall(); // eng: size køens antall
        public boolean tom(); // eng: isEmpty er køen tom?
        public void nullstill(); // eng: clear tømmer køen
    } // interface K

    public static class TabellKø<T> implements Kø<T> {
        private T[] a;      // en tabell
        private int fra;    // posisjonen til den første i køen
        private int til;    // posisjonen til første ledige plass

        private T[] utvidTabell(int lengde) {
            T[] b = (T[]) new Object[lengde];  // ny tabell

            // kopierer intervallet a[fra:a.length> over i b
            System.arraycopy(a, fra, b, 0, a.length - fra);

            // kopierer intervallet a[0:fra> over i b
            System.arraycopy(a, 0, b, a.length - fra, fra);

            fra = 0;
            til = a.length;

            return b;
        }

        public TabellKø(int lengde) {
            if (lengde < 1)
                throw new IllegalArgumentException("Må ha positiv lengde!");

            a = (T[]) new Object[lengde];

            fra = til = 0;    // a[fra:til> er tom
        }

        public TabellKø()   // standardkonstruktør
        {
            this(8);
        }

        public void leggInn(T t) {
            a[til] = t;                       // ny verdi bakerst i køen
            til++;                            // øker til med 1
            if (til == a.length) til = 0;     // hopper til 0
            if (fra == til)                   // sjekker om tabellen er full
                a = utvidTabell(2 * a.length);    // dobler tabellen
        }

        public T kikk() {
            if (fra == til)
                throw new NoSuchElementException("Køen er tom!");

            return a[fra];
        }

        public T taUt() {
            if (fra == til) throw new         // sjekker om køen er tom
                    NoSuchElementException("Køen er tom!");

            T temp = a[fra];                  // tar vare på den første i køen
            a[fra] = null;                    // nuller innholdet
            fra++;                            // øker fra med 1
            if (fra == a.length) fra = 0;     // hopper til 0
            return temp;                      // returnerer den første
        }

        public int antall() {
            return fra <= til ? til - fra : a.length + til - fra;
        }

        public boolean tom() {
            return til == fra;
        }

        public void nullstill() {
            while (fra != til) {
                a[fra++] = null;
                if (fra == a.length) fra = 0;
            }
        }

        public String toString() {
            if (til == fra) return "[]";

            int sfra = fra, stil = til;

            StringBuilder s = new StringBuilder();
            s.append('[').append(a[sfra]);
            sfra++;
            if (sfra == a.length) sfra = 0;

            while (sfra != stil) {
                s.append(',').append(' ').append(a[sfra]);
                sfra++;
                if (sfra == a.length) sfra = 0;
            }

            s.append(']');

            return s.toString();
        }
        public static <T> void byttPlass(Kø<T> kø, int indeks) {
            for(int i=0; i<kø.antall();i++){
                if(i == indeks){
                    T temp= kø.taUt();
                    kø.leggInn(kø.taUt());
                    kø.leggInn(temp);
                }
                kø.leggInn(kø.taUt());
            }
        }



    }  // TabellKø

    public static void main(String[] args) {
      /*  String[] a = {"Per", "Kari", "Ellin", "Ali", "Haitham", "Fred" };
        Kø<String> kø = new TabellKø<>();
        for (String p : a) kø.leggInn(p); // legger inn i køe
        System.out.println(kø);
        TabellKø.byttPlass(kø,3);
        System.out.println(kø); */

    /*    int[] a = {1,3,5,5,6,8,8,8,9,10,10}; // en sortert tabell med duplikater
        int antall = fjernDuplikater(a); // kaller metoden
        System.out.println(antall + ": " + Arrays.toString(a)); // antallet og tabellen */
        // Utskrift: 7: [1, 3, 5, 6, 8, 9, 10, 0, 0, 0, 0]

     /*   char bs1= 'g'; // X > F, a > A
        char bs2 = 'X';

        System.out.println(bs1 < bs2); */
        // Z er den største stor bokstav

        int[] a = {1,2,4,5,8,9,12};
        int[] b = {2,6,9,12,15};
        int[] c = {4,7,10};
        String ab = toString(snitt(a, b));
        String bc = toString(snitt(b,c));
        String ac = toString(snitt(a, c));
        System.out.println(ab + " " + bc + " " + ac);

    }

     public static <T> void flytt(Kø<T> A, Kø<T> B){


    }

    public static int[] snitt(int[] a, int[] b){
       int n = Integer.min(a.length,b.length);
        int[] c = new int[n];
        int j = 0;
        for (int i=0; i<a.length; i++){
            for (int k=0; k<b.length; k++){
                if (a[i] == b[k]) c[j++]=a[i];
            }
        }
        return Arrays.copyOf(c,j);

      //  return c;
    }

    public static int fjernDuplikater(int[] a)
    {
        if(a.length == 0) return 0; // ingen forskjellige verdier
        int j = 1;
        for (int i = 1; i < a.length; i++)
        {
            // hvis a[i - 1] == a[i], tas ikke a[i] med
            if (a[i - 1] != a[i]) a[j++] = a[i];
        }
        // nuller resten av tabellen
        for (int i = j; i < a.length; i++) a[i] = 0;
        return j; }


    public static int fjernDuplikater2(int[] a){
        int duplic=0;
        for(int i=0; i<a.length-1;i++){
            if(a[i] == a[i+1]) {
                a[i] = 0;
                for(int k=i; k<a.length-2;k++){
                    a[k]=a[k+1];}
                    a[a.length-1]=0;
                    duplic++;
                }
            else continue;
            }
        return duplic;
    }
    public static String toString(int[] a) // en int-tabell
    {
        StringBuilder sb = new StringBuilder("["); // en StringBilder
        if (a.length > 0)
        {
            sb.append(a[0]); // den første
            for (int i = 1; i < a.length; i++) // resten
                sb.append(',').append(' ').append(a[i]); // ok med append
        }
        return sb.append(']').toString(); // returnerer
    }

}
