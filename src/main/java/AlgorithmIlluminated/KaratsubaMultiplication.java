package AlgorithmIlluminated;

public class KaratsubaMultiplication {

  public static void main(String[] args) {
    String x = "5678";
    String y = "1234";
    int a = Integer.parseInt(x.substring(0, (x.length() / 2)));
    int b = Integer.parseInt(x.substring(x.length() / 2));
    int c = Integer.parseInt(y.substring(0, (y.length() / 2)));
    int d = Integer.parseInt(y.substring(y.length() / 2));
    int n = x.length();
    //    Step 1: compute a.c
    int step1 = a * c;
    //    Step 2: compute b.d
    int step2 = b * d;
    //    Step 3: compute (a + b) * (c + d)
    int step3 = (a + b) * (c + d);
    //    Step 4: Subtract result of first 2 steps from the result of the third step
    int step4 = step3 - step2 - step1;
    //    Step 5: compute 10^4 * step1 + 10^2 * step2 + step4
    int step5 = (int) ((Math.pow(10, n) * step1) + (Math.pow(10, n / 2) * step4) + step2);
    System.out.println("compute = " + step5);
  }
}
