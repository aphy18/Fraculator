package FraCulator;

import java.text.DecimalFormat;

class ParentModFrac {

    private int n;
    private int d;
    private String name;

    public int getNumerator() {
        return n;
    }

    public int getDenominator() {
        return d;
    }

    public void setNumerator(int n) {
        this.n = n;
    }

    public void setDenominator(int d) {
        this.d = d;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float fracToFloat() {
        float convertToFloat = ((float) n / d);
        return convertToFloat;
    }

    public String addRationals(int num2, int denom2) {
        int num1 = n;
        int lowestCommonMultiple = 0;
        int multiply = d * denom2;
        if (d != denom2) {
            for (int i = (denom2 >= d ? denom2 : d); i <= multiply; i++) {
                if (i % d == 0 && i % denom2 == 0) {
                    lowestCommonMultiple = i;
                    break;
                }
            }
            num1 = n * (lowestCommonMultiple / d);
            num2 = num2 * (lowestCommonMultiple / denom2);
        }

        int finalNumerator = num1 + num2;
        int denominator = (d == denom2 ? d : lowestCommonMultiple);

        String reduce = this.reduceRational(finalNumerator, denominator);
        return reduce;
    }


    public String subtractRationals(int num2, int denom2) {
        int num1 = n;
        int lowestCommonMultiple = 0;
        int multiply = d * denom2;

        if (d != denom2) {
            for (int i = (denom2 >= d ? denom2 : d); i <= multiply; i++) {
                if (i % d == 0 && i % denom2 == 0) {
                    lowestCommonMultiple = i;
                    break;
                }
            }
            num1 = n * (lowestCommonMultiple / d);
            num2 = num2 * (lowestCommonMultiple / denom2);
        }

        int finalNumerator = num1 - num2;
        int denominator = (d == denom2 ? d : lowestCommonMultiple);

        String reduce = this.reduceRational(finalNumerator, denominator);
        return reduce;

    }

    public String multiplyRationals(int num2, int denom2) {
        int productNumerator = n * num2;
        int productDenominator = d * denom2;
        String reduce = this.reduceRational(productNumerator, productDenominator);
        return reduce;
    }

    public String divideRationals(int num2, int denom2) {
        int[] arr = new int[2];
        arr[0] = num2;
        arr[1] = denom2;

        num2 = arr[1];
        denom2 = arr[0];

        int numerator = n * num2;
        int denominator = d * denom2;

        String reduce = this.reduceRational(numerator, denominator);
        return reduce;
    }

    private String reduceRational(int num,int denom){
        int gcd = 1;
        for (int i=1; i <= (num <= denom? num: denom); i++) {
            if (num % i == 0 && denom % i == 0) {
                gcd = i;
            }
        }

        String numStr = Integer.toString(num / gcd);
        String denomStr = Integer.toString(denom / gcd);

        return numStr + '/' + denomStr;
    }

}

public class ModFrac extends ParentModFrac  {

    public ModFrac(int n, int d) {
        this.setNumerator(n);
        this.setDenominator(d);
    }

    public ModFrac(float f) {
        DecimalFormat format = new DecimalFormat("0.##");
        String floatString = format.format(f);
        int indexOfDecimal = floatString.indexOf('.');

        String beforeDecimalPoint = floatString.substring(0, indexOfDecimal);
        String afterDecimalPoint = floatString.substring(indexOfDecimal + 1);
        String numerator = beforeDecimalPoint + afterDecimalPoint;

        System.out.println( f + " = " + numerator + '/' + 100);
    }

    public static void main(String[] args) {

        ModFrac fractionA = new ModFrac(6,8);
        ModFrac fractionB = new ModFrac(7,49);
        ModFrac fractionC = new ModFrac(36, 100);
        ModFrac fractionD = new ModFrac(10,25);

        System.out.println("------ Float to Rational Constructor ------");
        ModFrac floatingA = new ModFrac(3.15F);
        ModFrac floatingB = new ModFrac(446.54F);
        ModFrac floatingC = new ModFrac(36.67F);
        ModFrac floatingD = new ModFrac(0.04535F);

        System.out.println("------- Print Parent Info -------");
        System.out.println("-------------------------------");

        System.out.println("------ Rational to Float ------");
        System.out.println("6/8 = " + fractionA.fracToFloat());
        System.out.println("7/49 = " + fractionB.fracToFloat());
        System.out.println("36/100 = " + fractionC.fracToFloat());
        System.out.println("10/25 = " + fractionD.fracToFloat());
        System.out.println("-------------------------------");

        System.out.println("------ Adding Rationals ------");
        System.out.println("6/8 + 8/8 = " + fractionA.addRationals(8,8));
        System.out.println("7/49 + 14/7 = " + fractionB.addRationals(14,7));
        System.out.println("36/100 + 4/10 = " + fractionC.addRationals(4,10));
        System.out.println("10/25 + 3/50 = " + fractionD.addRationals(3,50));
        System.out.println("-------------------------------");

        System.out.println("------ Subtract Rationals ------");
        System.out.println("6/8 - 2/8 = " + fractionA.subtractRationals(2,8));
        System.out.println("6/8 - 11/8 = " + fractionA.subtractRationals(11,8));
        System.out.println("6/8 - 12/16 = " + fractionA.subtractRationals(12,16));
        System.out.println("6/8 - 8/12 = " + fractionA.subtractRationals(8,12));
        System.out.println("-------------------------------");

        System.out.println("------ Multiply Rationals ------");
        System.out.println("6/8 * 4/30 = " + fractionA.multiplyRationals(4,30));
        System.out.println("7/49 * 21/14 = " + fractionB.multiplyRationals(21,14));
        System.out.println("36/100 * 10/15 = " + fractionC.multiplyRationals(10,15));
        System.out.println("10/25 * 2/8 = " + fractionD.multiplyRationals(2,8));
        System.out.println("-------------------------------");

        System.out.println("------ Divide Rationals ------");
        System.out.println("6/8 / 2/5 = " + fractionA.divideRationals(2,5));
        System.out.println("7/49 / 2/1 = " + fractionB.divideRationals(2, 1));
        System.out.println("36/100 / 4/8 = " + fractionC.divideRationals(4, 8));
        System.out.println("10/25 / 5/6 = " + fractionD.divideRationals(5, 6));
        System.out.println("-------------------------------");

    }
}
