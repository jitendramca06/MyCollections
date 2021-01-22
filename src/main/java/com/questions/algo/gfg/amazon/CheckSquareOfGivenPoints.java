package com.questions.algo.gfg.amazon;

/**
 * @author Jitendra Kumar : 03/12/19
 */
public class CheckSquareOfGivenPoints {
    static class Points {
        int x;
        int y;

        Points(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int calculate(Points p1, Points p2) {
        return (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y);
    }

    private static boolean isSquare(Points p1, Points p2, Points p3, Points p4) {
        int d1 = calculate(p1, p2);
        int d2 = calculate(p1, p3);
        int d3 = calculate(p1, p4);

        /**
         * Condition for square
         * if d1 = d2 and d1 * 2 = d3
         */
        if (d1 == d2 && 2 * d1 == d3 && calculate(p2, p4) * 2 == calculate(p1, p3)) return true;
        if (d2 == d3 && 2 * d2 == d1 && calculate(p2, p3) * 2 == calculate(p3, p4)) return true;
        if (d1 == d3 && 2 * d1 == d2 && calculate(p2, p3) * 2 == calculate(p2, p4)) return true;
        return false;
    }

    public static void main(String[] args) {
        Points p1 = new Points(2, 0);
        Points p2 = new Points(0, 2);
        Points p3 = new Points(-2, 0);
        Points p4 = new Points(0, -2);
        System.out.println("Is given points form square : " + isSquare(p1, p2, p3, p4));
    }
}
