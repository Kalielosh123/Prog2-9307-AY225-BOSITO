/**
 * =====================================================
 * Student Name    : BOSITO, KALIEL OSH A.
 * Course          : Math 101 — Linear Algebra
 * Assignment      : Programming Assignment 1 — 3x3 Matrix Determinant Solver
 * School          : University of Perpetual Help System DALTA, Molino Campus
 * Date            : 2026-03-16
 * GitHub Repo     : https://github.com/[your-username]/uphsd-cs-bosito-kalielosh
 *
 * Description:
 *   This program computes the determinant of a hardcoded 3x3 matrix assigned
 *   to BOSITO, KALIEL OSH A. using cofactor expansion along the first row.
 * =====================================================
 */

public class DeterminantSolver {

    // Assigned matrix
    static int[][] matrix = {
        {6, 1, 2},
        {3, 4, 1},
        {2, 5, 3}
    };

    // 2x2 determinant helper
    static int computeMinor(int a, int b, int c, int d) {
        return (a * d) - (b * c);
    }

    // Print matrix
    static void printMatrix(int[][] m) {
        System.out.println("┌               ┐");
        for (int[] row : m) {
            System.out.printf("│  %2d  %2d  %2d  │%n", row[0], row[1], row[2]);
        }
        System.out.println("└               ┘");
    }

    static void solveDeterminant(int[][] m) {

        System.out.println("===================================================");
        System.out.println("  3x3 MATRIX DETERMINANT SOLVER");
        System.out.println("  Student: BOSITO, KALIEL OSH A.");
        System.out.println("  Assigned Matrix:");
        System.out.println("===================================================");

        printMatrix(m);

        System.out.println("===================================================");
        System.out.println("Expanding along Row 1 (cofactor expansion):\n");

        int minor11 = computeMinor(m[1][1], m[1][2], m[2][1], m[2][2]);
        int minor12 = computeMinor(m[1][0], m[1][2], m[2][0], m[2][2]);
        int minor13 = computeMinor(m[1][0], m[1][1], m[2][0], m[2][1]);

        System.out.printf(
        "  Step 1 — Minor M11: det([%d,%d],[%d,%d]) = (%d x %d) - (%d x %d) = %d%n",
        m[1][1], m[1][2], m[2][1], m[2][2],
        m[1][1], m[2][2], m[1][2], m[2][1], minor11
        );

        System.out.printf(
        "  Step 2 — Minor M12: det([%d,%d],[%d,%d]) = (%d x %d) - (%d x %d) = %d%n",
        m[1][0], m[1][2], m[2][0], m[2][2],
        m[1][0], m[2][2], m[1][2], m[2][0], minor12
        );

        System.out.printf(
        "  Step 3 — Minor M13: det([%d,%d],[%d,%d]) = (%d x %d) - (%d x %d) = %d%n",
        m[1][0], m[1][1], m[2][0], m[2][1],
        m[1][0], m[2][1], m[1][1], m[2][0], minor13
        );

        int c11 =  m[0][0] * minor11;
        int c12 = -m[0][1] * minor12;
        int c13 =  m[0][2] * minor13;

        System.out.println();
        System.out.printf("  Cofactor C11 = (+1) x %d x %d = %d%n", m[0][0], minor11, c11);
        System.out.printf("  Cofactor C12 = (-1) x %d x %d = %d%n", m[0][1], minor12, c12);
        System.out.printf("  Cofactor C13 = (+1) x %d x %d = %d%n", m[0][2], minor13, c13);

        int det = c11 + c12 + c13;

        System.out.printf("%n  det(M) = %d + (%d) + %d%n", c11, c12, c13);

        System.out.println("===================================================");
        System.out.printf("  ✓  DETERMINANT = %d%n", det);
        System.out.println("===================================================");
    }

    public static void main(String[] args) {
        solveDeterminant(matrix);
    }
}