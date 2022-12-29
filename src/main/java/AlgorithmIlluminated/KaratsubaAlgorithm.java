package AlgorithmIlluminated;

public class KaratsubaAlgorithm {

  public void execute() {
    String xStr = "5678";
    String yStr = "1234";
    int x = 5678;
    int y = 1234;
    System.out.println("Karatsuba Multiplication:");
    System.out.println("compute for base concept = " + baseConcept(xStr, yStr));
    System.out.println("compute multiplication using recursive call = " + recIntMult(x, y));
    System.out.println("compute multiplication using Karatsuba algorithm = " + karatsuba(x, y));
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

  private int recIntMult(int x, int y) {
    if (x < 10 || y < 10) {
      return x * y;
    }

    String xStr = Integer.toString(x);
    String yStr = Integer.toString(y);
    int halfn = Math.max(xStr.length(), yStr.length()) / 2;
    int splitX = xStr.length() - halfn;
    int a = Integer.parseInt(xStr.substring(0, splitX));
    int b = Integer.parseInt(xStr.substring(splitX));
    int splitY = yStr.length() - halfn;
    int c = Integer.parseInt(yStr.substring(0, splitY));
    int d = Integer.parseInt(yStr.substring(splitY));

    int ac = recIntMult(a, c);
    int ad = recIntMult(a, d);
    int bc = recIntMult(b, c);
    int bd = recIntMult(b, d);
    return (int) (Math.pow(10, halfn * 2) * ac + Math.pow(10, halfn) * (ad + bc) + bd);

  }

  private int karatsuba(int x, int y) {
    if (x < 10 || y < 10) {
      return x * y;
    }

    String xStr = Integer.toString(x);
    String yStr = Integer.toString(y);
    int halfn = Math.max(xStr.length(), yStr.length()) / 2;

    int splitX = xStr.length() - halfn;
    int a = Integer.parseInt(xStr.substring(0, splitX));
    int b = Integer.parseInt(xStr.substring(splitX));

    int splitY = yStr.length() - halfn;
    int c = Integer.parseInt(yStr.substring(0, splitY));
    int d = Integer.parseInt(yStr.substring(splitY));

    int p = a + b;
    int q = c + d;

    int ac = karatsuba(a, c);
    int bd = karatsuba(b, d);

    //calculation of pq reduces 1 recursive call
    int pq = karatsuba(p, q);

    int adbc = pq - ac - bd;
    return (int) (Math.pow(10, halfn * 2) * ac + Math.pow(10, halfn) * adbc + bd);

  }
}
