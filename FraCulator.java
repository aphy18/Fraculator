package FraCulator;

public class FraCulator {
    public static void main(String[] args) {
        System.out.println("Operations available: +, -, x, /");

        String firstFrac = args[0];
        String secondFrac = args[2];
        String operation = args[1];

        int num1 = Integer.parseInt(firstFrac.substring(0,firstFrac.indexOf('/')));
        int denom1 = Integer.parseInt(firstFrac.substring(firstFrac.indexOf('/') + 1));
        int num2 = Integer.parseInt(secondFrac.substring(0,secondFrac.indexOf('/')));
        int denom2 = Integer.parseInt(secondFrac.substring(secondFrac.indexOf('/') + 1));

        ModFrac frac = new ModFrac(num1, denom1);

        switch (operation) {
            case "+":
                String add = frac.addRationals(num2,denom2);
                System.out.println(num1 + "/" + denom1 + " + " + num2 + "/" + denom2 + " = " + add);
                break;
            case "-":
                String subtract = frac.subtractRationals(num2,denom2);
                System.out.println(num1 + "/" + denom1 + " - " + num2 + "/" + denom2 + " = " + subtract);
                break;
            case "x":
                String multiply = frac.multiplyRationals(num2,denom2);
                System.out.println(num1 + "/" + denom1 + " * " + num2 + "/" + denom2 + " = " + multiply);
                break;
            case "/":
                String divide = frac.divideRationals(num2,denom2);
                System.out.println(num1 + "/" + denom1 + " / " + num2 + "/" + denom2 + " = " + divide);
                break;
            default:
                System.out.println("Error: operation not recognized");
        }
    }
}
