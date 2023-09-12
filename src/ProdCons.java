//TD 1
public class ProdCons {
    private int NTIMES = 100;
    private int counter;
    private final int[] tableau;

    public ProdCons(int n) {
        this.counter = 0;
        this.tableau = new int[n];
        new Prod(this).start();
        new Cons(this).start();
    }

    private static class Prod extends Thread {
        ProdCons pc;

        public Prod(ProdCons pc) {
            this.pc = pc;
        }

        @Override
        public void run() {
            int n = this.pc.tableau.length;
            while (--this.pc.NTIMES > 0) {
                for (int i = 0; i < n; i++) {
                    this.pc.tableau[i] = (this.pc.counter)++;
                }
            }
        }
    }

    private static class Cons extends Thread {
        ProdCons pc;

        public Cons(ProdCons pc) {
            this.pc = pc;
        }

        @Override
        public void run() {
            int n = this.pc.tableau.length;
            while (--this.pc.NTIMES > 0) {
                for (int i = 0; i < n; i++) {
                    System.out.print(this.pc.tableau[i]+" ");
                }
                System.out.println();
            }
        }
    }
}
