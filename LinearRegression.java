import java.util.Scanner;
public class LinearRegression {

    public static double sum(double[] ar) {
        double total = 0;
        for (int i = 0; i < ar.length; i++) {
            total += ar[i];
        }
        return total;
    }
    public static void main(String[] args) {

        System.out.print("Enter number of points: ");
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        double SSE = 0, SSEp = 0;

        double[] y      = new double[n];
        double[] x      = new double[n];
        double[] xi2    = new double[n];
        double[] xp     = new double[n];
        double[] xpi2   = new double[n];
        double[] xy     = new double[n];
        double[] xpy    = new double[n];
        double[] yh     = new double[n];
        double[] yph    = new double[n];
        double[] yhp    = new double[n];

        System.out.print("Enter the values for x all on one line: ");
        int index =0;
        while (index < n){
            x[index++] = s.nextInt();
        }
        s.nextLine();

        System.out.print("Enter the values for y all on one line: ");
        index = 0;
        while (index < n){
            y[index++] = s.nextInt();
        }
        s.nextLine();

        for (int i = 0; i < x.length; i++) {
            xp[i] = x[i] - sum(x)/n;
        }
        for (int i = 0; i < x.length; i++) {
            xi2[i] = x[i] * x[i];
        }
        for (int i = 0; i < x.length; i++) {
            xpi2[i] = xp[i] * xp[i];
        }
        for (int i = 0; i < x.length; i++) {
            xy[i] = x[i] * y[i];
        }
        for (int i = 0; i < x.length; i++) {
            xpy[i] = xp[i] * y[i];
        }

        double q = (n*sum(xy) - (sum(x)*sum(y))) / ((n*sum(xi2))-sum(x)*sum(x));
        double r = (sum(y)*sum(xi2) - sum(x)*sum(xy)) / ((n*sum(xi2))-(sum(x)*sum(x)));
        for (int i = 0; i < x.length; i++) {
            yh[i] = x[i]*q + r;
        }
        System.out.println("System y = qx+r");
        System.out.printf("S(x) = %.4f; S(y) = %.4f; S(x)^2 = %.4f; S(x^2) = %.4f; S(xy) = %.4f", sum(x), sum(y), sum(x)*sum(x), sum(xi2), sum(xy));
        System.out.println();
        System.out.printf("q = %.4f\nr = %.4f", q, r);
        System.out.println();
        System.out.print("Yh: ");
        for (int i = 0; i < yh.length; i++) {
            System.out.printf("%.4f", yh[i]);
            System.out.print(", ");
        }
        System.out.println();
        for (int i = 0; i < x.length; i++) {
            SSE += Math.pow(y[i] - yh[i], 2);
        }
        System.out.printf("SSE = %.4f", SSE);
        System.out.println();
        System.out.println();

        double qp = ( (sum(xy)) / (sum(xi2)) );
        double rp = ( (sum(y)) / (n) );
        System.out.println("System y = q'x'+r'");
        System.out.print("Values of x' -> ");
        for (int i = 0; i <x.length; i++) {
            System.out.print(xp[i]);
            System.out.print(", ");
        }


        for (int i = 0; i < x.length; i++) {
            yhp[i] = xp[i]*qp + rp;
        }

        for (int i = 0; i < x.length; i++) {
            SSEp += Math.pow(y[i] - yph[i], 2); // incorrect ?
        }

        System.out.println();
        System.out.printf("S(x') = %.4f; S(y) = %.4f; S(x')^2 = %.4f; S(x'^2) = %.4f; S(x'y) = %.4f", sum(xp), sum(y), sum(xp)*sum(xp), sum(xpi2), sum(xpy));
        System.out.println();
        System.out.printf("q' = %.4f\nr' = %.4f", qp, rp );
        System.out.println();
        System.out.print("Yh' = ");
        for (int i =0 ; i < yhp.length;i++ ) {
            System.out.printf("%.4f", yhp[i]);
            System.out.print(", ");
        }
        System.out.println();
        System.out.printf("SSE = %.4f", SSE);
        System.out.println();
    }
}
