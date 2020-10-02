package Lab2;

public class Main {

    public static void main(String[] args) {
        System.out.println(new Point(3,4).translate(1,3).scale(0.5).toString());
        PointMutable pointMutable = new PointMutable(3,4);
        pointMutable.translate(1,3);
        pointMutable.scale(0.5);
        System.out.println(pointMutable.toString());

        int nbr1 = 1;
        int nbr2 = 2;
        System.out.printf("nbr1=%d, nbr2=%d\n", nbr1, nbr2);
        cantSwap(nbr1, nbr2);
        System.out.printf("nbr1=%d, nbr2=%d\n", nbr1, nbr2);
        IntHolder a = new IntHolder(1);
        IntHolder b = new IntHolder(2);
        System.out.printf("nbr1=%s, nbr2=%s\n", a, b);
        canSwap(a, b);
        System.out.printf("nbr1=%s, nbr2=%s\n", a, b);
    }

    private static void canSwap(IntHolder ah, IntHolder bh) {
        int temp = ah.getValue();
        ah.setValue(bh.getValue());
        bh.setValue(temp);
    }

    private static void cantSwap(int a, int b) {
        int temp = a;
        b = a;
        a = temp;
    }
}
