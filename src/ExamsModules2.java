
import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.StringJoiner;
public class ExamsModules2 {

    public interface Stakk<T> // eng: Stack
    {
        public void leggInn(T verdi); // eng: push
        public T kikk(); // eng: peek
        public T taUt(); // eng: pop
        public int antall(); // eng: size
        public boolean tom(); // eng: isEmpty
        public void nullstill(); // eng: clear
    } // interface Stakk


    public static class TabellStakk<T> implements Stakk<T>
    {
        private T[] a;                    // en generisk tabell
        private int antall;               // antall verdier på stakken

        @SuppressWarnings("unchecked")    // konvertering: Object[] -> T[]
        public TabellStakk(int lengde)    // valgfri tabellengde
        {
            a = (T[]) new Object[lengde];   // oppretter tabellen
            antall = 0;                     // stakken er tom
        }

        public TabellStakk()
        {
            this(8);                        // lengde lik 8
        }

        @Override
        public int antall()
        {
            return antall;
        }

        @Override
        public boolean tom()
        {
            return antall == 0;
        }

        @Override
        public void leggInn(T verdi)
        {
            if (antall == a.length)
                a = Arrays.copyOf(a,antall == 0 ? 1 : 2*antall);  // dobler

            a[antall++] = verdi;
        }

        @Override
        public T kikk()
        {
            if (antall == 0) throw
                    new NoSuchElementException("Stakken er tom!");

            return a[antall-1];
        }

        @Override
        public T taUt()
        {
            if (antall == 0) throw
                    new NoSuchElementException("Stakken er tom!");

            antall--;

            T temp = a[antall];
            a[antall] = null;
            return temp;
        }

        @Override
        public void nullstill()
        {
            for (int i = 0; i < antall; i++) a[i] = null;
            antall = 0;
        }

        @Override
        public String toString()   // bruker StringJoiner
        {
            StringJoiner s = new StringJoiner(", ", "[", "]");
            for (int i = antall - 1; i >= 0; i--)
                s.add(a[i] == null ? "null" : a[i].toString());
            return s.toString();
        }

        public String toString2()  // bruker StringBuilder
        {
            if (tom()) return "[]";

            StringBuilder s = new StringBuilder();
            s.append('[');
            s.append(a[antall-1]);

            for (int i = antall - 2; i >= 0; i--)
                s.append(',').append(' ').append(a[i]);

            s.append(']');
            return s.toString();
        }

        public static <T> int indeks(Stakk<T> s, T verdi){
            int index= 0;
            Stakk<T> c = new TabellStakk<T>();
            while (!s.tom()) c.leggInn(s.taUt());
            while (!c.tom()){
                T temp = c.taUt();
                if (temp == verdi) {
                    s.leggInn(temp);
                    return index;}
                s.leggInn(temp);
                index++;
                }
            return -1;
            }




    } // class TabellStakk

    public static void main(String[] args) {

        int[] a = {4, 2, 5, 1, 3, 6}, b = {};
        snu(a); snu(b);
        System.out.println(Arrays.toString(a) + " " + Arrays.toString(b));
        // Utskrift: [6, 3, 1, 5, 2, 4] []

       /* String[] a = {"Per", "Kari", "Ellin", "Ali", "Haitham", "Fred" };
        Stakk<String> stakk = new TabellStakk<>();
        for (String s: a) stakk.leggInn(s);
        int index = TabellStakk.indeks(stakk, "Kari");
        if (index != -1)
        {System.out.println("Verdien har indeks: "+index);}
        else {
            System.out.println("Angitt verdi finnes ikke i tabelen!");} */
    }

    public static void bytt(int[] a, int i, int j){
        int temp = a[i];
            a[i]= a[j];
            a[j] = temp;
    }
    public static void snu(int[] a) {
        if (a.length < 0) return;
        int v = 0, h= a.length-1;
        while (v<h) bytt(a,v++,h--); //becarefull about the minus minus sign

    }

    }





