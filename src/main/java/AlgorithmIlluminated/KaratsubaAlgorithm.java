package AlgorithmIlluminated;

public class KaratsubaAlgorithm {

  public void execute() {
    String x = "5678";
    String y = "1234";
    System.out.println("Karatsuba Multiplication:");
    System.out.println("compute for base concept = " + baseConcept(x, y));
    System.out.println("compute multiplication using recursive call = " + recIntMult(x, y));
  }

  private int baseConcept(String x, String y) {
    int a = Integer.parseInt(x.substring(0, (x.length() / 2)));
    int b = Integer.parseInt(x.substring(x.length() / 2));
    int c = Integer.parseInt(y.substring(0, (y.length() / 2)));
    int d = Integer.parseInt(y.substring(y.length() / 2));
    int n = x.length();
    //    Step 1: compute a.c
    int ac = a * c;
    //    Step 2: compute b.d
    int bd = b * d;
    //    Step 3: compute (a + b) * (c + d)
    int step3 = (a + b) * (c + d);
    //    Step 4: Subtract result of first 2 steps from the result of the third step
    int step4 = step3 - bd - ac;
    //    Step 5: compute 10^4 * step1 + 10^2 * step2 + step4
    return (int) ((Math.pow(10, n) * ac) + (Math.pow(10, n / 2) * step4) + bd);
  }

  private int recIntMult(String x, String y) {
    int n = x.length();
    if (n == 1) {
      return Integer.parseInt(x) * Integer.parseInt(y);
    } else {
      int a = Integer.parseInt(x.substring(0, (x.length() / 2)));
      int b = Integer.parseInt(x.substring(x.length() / 2));
      int c = Integer.parseInt(y.substring(0, (y.length() / 2)));
      int d = Integer.parseInt(y.substring(y.length() / 2));

      int ac = recIntMult(Integer.toString(a), Integer.toString(c));
      int ad = recIntMult(Integer.toString(a), Integer.toString(d));
      int bc = recIntMult(Integer.toString(b), Integer.toString(c));
      int bd = recIntMult(Integer.toString(b), Integer.toString(d));
      return (int) (Math.pow(10, n) * ac + Math.pow(10, n / 2) * (ad + bc) + bd);
    }
  }
}
