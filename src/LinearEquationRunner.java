import java.util.Scanner;
public class LinearEquationRunner {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome!");
        System.out.print("Enter coordinate 1: ");
        String int1 = scan.nextLine();
        int firstLength = int1.length();
        int commaLocation = int1.indexOf(",");
        String firstHalf = int1.substring(1 , commaLocation);
        String secHalf = int1.substring(commaLocation + 2, firstLength - 1 );
        String firstTotal = ("(" + firstHalf + "," + secHalf + ")");

        System.out.print("Enter coordinate 2: ");
        String int2 = scan.nextLine();
        int secLength = int2.length();
        int commaLocation2 = int2.indexOf(",");
        String firstHalf2 = int2.substring(1 , commaLocation2);
        String secHalf2 = int2.substring(commaLocation2 + 2, secLength - 1 );
        String secTotal = ("(" + firstHalf2 + "," + secHalf2 + ")");

        int x1 = Integer.parseInt(firstHalf);
        int y1 = Integer.parseInt(secHalf);
        int x2 = Integer.parseInt(firstHalf2);
        int y2 = Integer.parseInt(secHalf2);

        LinearEquation equation = new LinearEquation(x1, y1, x2, y2);

        System.out.println("Equation: " + equation.equation());
        System.out.println("Slope: " + equation.slope());
        System.out.println("y-intercept: " + equation.yIntercept());
        System.out.println("Distance: " + equation.distance());
        System.out.println();
        System.out.println("----- Line info -----");
        System.out.println(equation.lineInfo());
        System.out.println();
        double testX = 4;
        System.out.println("Coordinate for x: " + equation.coordinateForX(testX));


    }
}
