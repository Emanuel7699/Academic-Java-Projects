import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class StudentsTester {
    public static void main(String args[]) {
        MatrixList ml = new MatrixList();
        ml = new MatrixList(new int[1][1]);
        int i = ml.getData_i_j(0, 0);
        ml.setData_i_j(0, 0, 0);
        System.out.println(ml);
        System.out.println("If there is a @ sign in the line above\n" +
                "(and not just a single 0)\n" +
                "it means you didn't implement the toString method.");
        i = ml.findMax();
        i = ml.howManyX(0);

        System.out.println("\n============================\n" +
                "If you see this message,\n" +
                "it means your software worked fine with this tester,\n" +
                "which only means you wrote all the expected methods\n" +
                "with the right interface.\n" +
                "It DOES NOT MEAN your software does exactly what it is\n" +
                "expected to do.\n" +
                "To check that, you will have to write your own tester\n" +
                "which must include all sorts of scenarios.\n" +
                "The bugs your tester doesn't find - will be found\n" +
                "by your instructor's tester, and will cost you\n" +
                "points in your grade.");

        boolean totalCorrect = true;
        int[][] matrix1 = {
                {1, 2, 5},
                {4, 5, 6},
                {7, 8, 9}
        };
        MatrixList matrix = new MatrixList(matrix1);
        System.out.println("Matrix 1");
        System.out.println(matrix.toString());
        System.out.println(String.format("The amount of %s in the matrix is %s, and your result was %s which is %s", 5, 2, matrix.howManyX(5), matrix.howManyX(5) == 2));
        System.out.println(String.format("The maximum number in the matrix is %s, and your result was %s which is %s", 9, matrix.findMax(), matrix.findMax() == 9));
        totalCorrect = matrix.howManyX(5) == 2 && matrix.findMax() == 9 && totalCorrect;
        int[][] matrix2 = {
                {1, 3, 5},
                {7, 10, 15},
                {20, 25, 30},
                {35, 40, 50}
        };
        matrix = new MatrixList(matrix2);
        System.out.println("Matrix 2");
        System.out.println(matrix.toString());
        System.out.println(String.format("The amount of %s in the matrix is %s, and your result was %s which is %s", 25, 1, matrix.howManyX(25), matrix.howManyX(25) == 1));
        System.out.println(String.format("The maximum number in the matrix is %s, and your result was %s which is %s", 50, matrix.findMax(), matrix.findMax() == 50));
        totalCorrect = matrix.howManyX(25) == 1 && matrix.findMax() == 50 && totalCorrect;
        int[][] matrix3 = {
                {1, 2, 4, 8, 16},
                {2, 3, 6, 12, 24},
                {3, 4, 8, 16, 32},
                {4, 5, 10, 20, 40},
                {5, 6, 12, 24, 48}
        };
        matrix = new MatrixList(matrix3);
        System.out.println("Matrix 3");
        System.out.println(matrix.toString());
        totalCorrect = matrix.howManyX(4) == 3 && matrix.findMax() == 48 && totalCorrect;
        System.out.println(String.format("The amount of %s in the matrix is %s, and your result was %s which is %s", 4, 3, matrix.howManyX(4), matrix.howManyX(4) == 3));
        System.out.println(String.format("The maximum number in the matrix is %s, and your result was %s which is %s", 48, matrix.findMax(), matrix.findMax() == 48));
        System.out.println(String.format("The number in the (%s, %s) cell is %s and your result was %s which is %s", 2, 3, 16, matrix.getData_i_j(2, 3), matrix.getData_i_j(2, 3) == 16));
        totalCorrect = totalCorrect && matrix.getData_i_j(2, 3) == 16;
        if (totalCorrect) {
            System.out.println("In total, you were correct. Well done!");
        } else {
            System.out.println("In total, you were wrong in one of the assigments. Try again.");
        }

    }
        // Test for an empty matrix
        @Test
        public void testEmptyMatrix() {
            MatrixList matrix = new MatrixList(new int[][]{});
            assertEquals("", matrix.toString(), "Empty matrix should produce an empty string.");
            assertEquals(0, matrix.howManyX(0), "Empty matrix should always return 0 occurrences.");
            assertEquals(Integer.MIN_VALUE, matrix.findMax(), "Empty matrix should return Integer.MIN_VALUE as max.");
        }

        // Test for single row and column matrices
        @Test
        public void testSingleRowMatrix() {
            MatrixList matrix = new MatrixList(new int[][]{{1, 2, 3}});
            assertEquals(1, matrix.howManyX(2), "Single row matrix should correctly count occurrences.");
            assertEquals(3, matrix.findMax(), "Single row matrix should correctly find the max value.");
        }

        @Test
        public void testSingleColumnMatrix() {
            MatrixList matrix = new MatrixList(new int[][]{{1}, {2}, {3}});
            assertEquals(1, matrix.howManyX(2), "Single column matrix should correctly count occurrences.");
            assertEquals(3, matrix.findMax(), "Single column matrix should correctly find the max value.");
        }

        // Test for matrices with all identical elements
        @Test
        public void testMatrixWithIdenticalElements() {
            MatrixList matrix = new MatrixList(new int[][]{
                    {5, 5, 5},
                    {5, 5, 5},
                    {5, 5, 5}
            });
            assertEquals(5, matrix.findMax(), "Max should be the identical value.");
        }

        // Test for negative numbers
        @Test
        public void testNegativeNumbersMatrix() {
            MatrixList matrix = new MatrixList(new int[][]{
                    {-1, -2, -3},
                    {-4, -5, -6},
                    {-7, -8, -9}
            });
            assertEquals(-1, matrix.findMax(), "Max should be the least negative value.");
        }

        // Test for mixed positive and negative numbers
        @Test
        public void testMixedNumbersMatrix() {
            MatrixList matrix = new MatrixList(new int[][]{
                    {3, -1, 4},
                    {-1, 5, -9},
                    {2, -6, 5}
            });
            assertEquals(5, matrix.findMax(), "Max should be the largest positive number.");
        }

        // Test for out-of-bounds access
        @Test
        public void testOutOfBoundsAccess() {
            int[][] mat = {
                    {1, 2, 3},
                    {4, 5, 6},
                    {7, 8, 9}
            };
            MatrixList matrix = new MatrixList(mat);
            assertEquals(Integer.MIN_VALUE, matrix.getData_i_j(-1, 0), "Accessing negative row should return Integer.MIN_VALUE.");
            assertEquals(Integer.MIN_VALUE, matrix.getData_i_j(0, -1), "Accessing negative column should return Integer.MIN_VALUE.");
            assertEquals(Integer.MIN_VALUE, matrix.getData_i_j(10, 0), "Accessing row out of bounds should return Integer.MIN_VALUE.");
            assertEquals(Integer.MIN_VALUE, matrix.getData_i_j(0, 10), "Accessing column out of bounds should return Integer.MIN_VALUE.");
        }

        // Test for sparse matrices
        @Test
        public void testSparseMatrix() {
            int[][] mat = {
                    {0, 0, 0},
                    {0, 7, 0},
                    {0, 0, 0}
            };
            MatrixList matrix = new MatrixList(mat);
            assertEquals(7, matrix.findMax(), "Max should correctly identify the only non-zero value.");
        }

        // Test for large and small values
        @Test
        public void testLargeAndSmallValuesMatrix() {
            int[][] mat = {
                    {Integer.MIN_VALUE, -100, 0},
                    {1, Integer.MAX_VALUE, -50}
            };
            MatrixList matrix = new MatrixList(mat);
            assertEquals(Integer.MAX_VALUE, matrix.findMax(), "Max should correctly identify Integer.MAX_VALUE.");
        }

        @Test
        public void testAlternatingPattern() {
            MatrixList matrix = new MatrixList(new int[][]{
                    {1, 2, 1},
                    {2, 1, 2},
                    {1, 2, 1}
            });
            assertEquals(2, matrix.findMax(), "Max should be correct in alternating pattern");
        }

        @Test
        public void testNonSquareMatrix() {
            MatrixList matrix = new MatrixList(new int[][]{
                    {1, 2, 3, 4},
                    {5, 6, 7, 8}
            });
            assertEquals(8, matrix.findMax(), "Should find max in non-square matrix");
        }

        @Test
        public void testDiagonalPattern() {
            MatrixList matrix = new MatrixList(new int[][]{
                    {9, 0, 0},
                    {0, 9, 0},
                    {0, 0, 9}
            });
            assertEquals(9, matrix.findMax(), "Should find max in diagonal matrix");
        }

        @Test
        public void testBoundaryValues() {
            MatrixList matrix = new MatrixList(new int[][]{
                    {Integer.MAX_VALUE, Integer.MAX_VALUE},
                    {Integer.MIN_VALUE + 1, Integer.MIN_VALUE}
            });
            assertEquals(Integer.MAX_VALUE, matrix.findMax(), "Should handle MAX_VALUE correctly");
        }

        @Test
        public void testZigZagPattern() {
            MatrixList matrix = new MatrixList(new int[][]{
                    {1, 2, 3},
                    {6, 5, 4},
                    {7, 8, 9}
            });
            assertEquals(9, matrix.findMax(), "Should find max in zigzag pattern");
        }

        @Test
        public void testSingleElement() {
            MatrixList matrix = new MatrixList(new int[][]{{42}});
            assertEquals(42, matrix.findMax(), "Should find max in single element matrix");
        }

        @Test
        public void testRepeatedRows() {
            MatrixList matrix = new MatrixList(new int[][]{
                    {1, 2, 3},
                    {1, 2, 3},
                    {1, 2, 3}
            });
            assertEquals(3, matrix.findMax(), "Should find max in matrix with repeated rows");
        }

        @Test
        public void testRepeatedColumns() {
            MatrixList matrix = new MatrixList(new int[][]{
                    {1, 1, 1},
                    {2, 2, 2},
                    {3, 3, 3}
            });
            assertEquals(3, matrix.findMax(), "Should find max in matrix with repeated columns");
        }

        @Test
        public void testTriangularPattern() {
            MatrixList matrix = new MatrixList(new int[][]{
                    {1, 0, 0},
                    {2, 3, 0},
                    {4, 5, 6}
            });
            assertEquals(6, matrix.findMax(), "Should find max in triangular pattern");
        }

        @Test
        public void testAllZeros() {
            MatrixList matrix = new MatrixList(new int[][]{
                    {0, 0, 0, 0},
                    {0, 0, 0, 0},
                    {0, 0, 0, 0}
            });
            assertEquals(0, matrix.findMax(), "Should handle matrix of all zeros");
        }

        @Test
        public void testIncreasingValues() {
            MatrixList matrix = new MatrixList(new int[][]{
                    {1, 2, 3},
                    {4, 5, 6},
                    {7, 8, 9},
                    {10, 11, 12}
            });
            assertEquals(0, matrix.howManyX(13), "Should handle non-existent value");
            assertEquals(12, matrix.findMax(), "Should find max in increasing pattern");
        }

        @Test
        public void testAlternatingSignsPattern() {
            MatrixList matrix = new MatrixList(new int[][]{
                    {1, -1, 1},
                    {-1, 1, -1},
                    {1, -1, 1}
            });
            assertEquals(1, matrix.findMax(), "Should find max in alternating signs pattern");
        }

        @Test
        public void testWideMatrix() {
            MatrixList matrix = new MatrixList(new int[][]{
                    {1, 2, 3, 4, 5, 6, 7, 8}
            });
            assertEquals(1, matrix.howManyX(8), "Should find element in wide matrix");
            assertEquals(8, matrix.findMax(), "Should find max in wide matrix");
        }

        @Test
        public void testTallMatrix() {
            MatrixList matrix = new MatrixList(new int[][]{
                    {1},
                    {2},
                    {3},
                    {4},
                    {5},
                    {6},
                    {7},
                    {8}
            });
            assertEquals(8, matrix.findMax(), "Should find max in tall matrix");
        }

        @Test
        public void testCheckerboardPattern() {
            MatrixList matrix = new MatrixList(new int[][]{
                    {1, 2, 1, 2},
                    {2, 1, 2, 1},
                    {1, 2, 1, 2},
                    {2, 1, 2, 1}
            });
            assertEquals(2, matrix.findMax(), "Should find max in checkerboard pattern");
        }

        @Test
        public void testBorderPattern() {
            MatrixList matrix = new MatrixList(new int[][]{
                    {5, 5, 5, 5},
                    {5, 0, 0, 5},
                    {5, 0, 0, 5},
                    {5, 5, 5, 5}
            });
            assertEquals(5, matrix.findMax(), "Should find max in border pattern");
        }

        @Test
        public void testSequentialDuplicates() {
            MatrixList matrix = new MatrixList(new int[][]{
                    {1, 1, 2, 2},
                    {3, 3, 4, 4},
                    {5, 5, 6, 6}
            });
            assertEquals(6, matrix.findMax(), "Should find max with sequential duplicates");
        }

        @Test
        public void testLargeValuesDifference() {
            MatrixList matrix = new MatrixList(new int[][]{
                    {Integer.MIN_VALUE, 0, Integer.MAX_VALUE},
                    {Integer.MIN_VALUE / 2, 0, Integer.MAX_VALUE / 2},
                    {-1, 0, 1}
            });
            assertEquals(Integer.MAX_VALUE, matrix.findMax(), "Should handle extreme value differences");
        }

        @Test
        public void testSparseMatrixWithNegatives() {
            MatrixList matrix = new MatrixList(new int[][]{
                    {0, -1, 0},
                    {0, 0, 0},
                    {-1, 0, 0}
            });
            assertEquals(0, matrix.findMax(), "Should find max in sparse matrix with negatives");
        }

        @Test
        public void testPrimeNumbersOnly() {
            MatrixList matrix = new MatrixList(new int[][]{
                    {2, 3, 5, 7},
                    {11, 13, 17, 19},
                    {23, 29, 31, 37}
            });
            assertEquals(37, matrix.findMax(), "Should find largest prime");
        }

        @Test
        public void testFibonacciSequence() {
            MatrixList matrix = new MatrixList(new int[][]{
                    {1, 1, 2, 3},
                    {5, 8, 13, 21},
                    {34, 55, 89, 144}
            });
            assertEquals(144, matrix.findMax(), "Should find largest Fibonacci number");
        }

        @Test
        public void testBinaryRepresentation() {
            MatrixList matrix = new MatrixList(new int[][]{
                    {0, 1, 0, 1},
                    {1, 0, 1, 0},
                    {0, 0, 1, 1}
            });
            int expectedDecimal = 0b1011; // 11 in decimal
        }

        @Test
        public void testPowerOfTwo() {
            MatrixList matrix = new MatrixList(new int[][]{
                    {1, 2, 4, 8},
                    {16, 32, 64, 128},
                    {256, 512, 1024, 2048}
            });
            assertEquals(1, matrix.howManyX(64), "Should find specific power of 2");
            assertEquals(2048, matrix.findMax(), "Should find largest power of 2");
        }

        @Test
        public void testASCIIValues() {
            MatrixList matrix = new MatrixList(new int[][]{
                    {72, 69, 76, 76}, // HELL
                    {79, 32, 87, 79}, // O WO
                    {82, 76, 68, 33}  // RLD!
            });
            assertEquals(87, matrix.findMax(), "Should find highest ASCII value");
        }

        @Test
        public void testYearDates() {
            MatrixList matrix = new MatrixList(new int[][]{
                    {1999, 2000, 2001},
                    {2010, 2020, 2023},
                    {2024, 2025, 2030}
            });
            assertEquals(2030, matrix.findMax(), "Should find future year");
        }

        @Test
        public void testChessboardCoordinates() {
            MatrixList matrix = new MatrixList(new int[][]{
                    {11, 12, 13, 14, 15, 16, 17, 18},  // 1st rank
                    {21, 22, 23, 24, 25, 26, 27, 28},  // 2nd rank
                    {31, 32, 33, 34, 35, 36, 37, 38}   // 3rd rank
            });
            assertEquals(38, matrix.findMax(), "Should find highest coordinate");
        }

        @Test
        public void testColorRGBValues() {
            MatrixList matrix = new MatrixList(new int[][]{
                    {255, 0, 0},    // Red
                    {0, 255, 0},    // Green
                    {0, 0, 255}     // Blue
            });
            assertEquals(255, matrix.findMax(), "Should find max color value");
        }

        @Test
        public void testIPAddressParts() {
            MatrixList matrix = new MatrixList(new int[][]{
                    {192, 168, 0, 1},    // Common local IP
                    {10, 0, 0, 1},       // Private network
                    {127, 0, 0, 1}       // Localhost
            });
            assertEquals(192, matrix.findMax(), "Should find highest IP octet");
        }

        @Test
        public void testMusicNotes() {
            // Using MIDI note numbers: middle C = 60, C#=61, etc.
            MatrixList matrix = new MatrixList(new int[][]{
                    {60, 62, 64, 65}, // C D E F
                    {67, 69, 71, 72}, // G A B C
                    {64, 67, 71, 74}  // E G B D
            });
            assertEquals(2, matrix.howManyX(64), "Should count occurrences of note E");
            assertEquals(74, matrix.findMax(), "Should find highest note");
        }

        @Test
        public void testPlayingCards() {
            // Representing cards: Ace=1, Jack=11, Queen=12, King=13, Suits: Hearts=100, Diamonds=200, Clubs=300, Spades=400
            MatrixList matrix = new MatrixList(new int[][]{
                    {113, 212, 311}, // King Hearts, Queen Diamonds, Jack Clubs
                    {401, 102, 203}, // Ace Spades, 2 Hearts, 3 Diamonds
                    {304, 405, 106}  // 4 Clubs, 5 Spades, 6 Hearts
            });
            assertEquals(1, matrix.howManyX(113), "Should find King of Hearts");
            assertEquals(405, matrix.findMax(), "Should find highest card value");
        }

        @Test
        public void testPalindromicNumbers() {
            MatrixList matrix = new MatrixList(new int[][]{
                    {11, 22, 33},
                    {101, 111, 121},
                    {1001, 2002, 3003}
            });
            assertEquals(1, matrix.howManyX(2002), "Should find specific palindrome");
            assertEquals(3003, matrix.findMax(), "Should find largest palindrome");
        }

        @Test
        public void pointerToNull() {
            MatrixList matrix = new MatrixList(new int[][]{
                    {}
            });
            assertEquals(0, matrix.howManyX(2002), "_m00 is pointing to null");
            assertEquals(Integer.MIN_VALUE, matrix.findMax(), "There is no numbers in matrix");
        }

        @Test
        public void testToStringEmoji() {
            // Using numbers that correspond to emoji unicode points for fun
            MatrixList matrix = new MatrixList(new int[][]{
                    {128516, 128517, 128518},  // Different smile emojis
                    {128151, 128152, 128153}   // Different heart emojis
            });
            String expected = "128516\t128517\t128518\n128151\t128152\t128153\n";
            assertEquals(expected, matrix.toString(), "Should properly format emoji numbers");
        }

        @Test
        public void testToStringPhoneNumber() {
            MatrixList matrix = new MatrixList(new int[][]{
                    {1, 8, 0, 0},
                    {5, 5, 5, 1},
                    {2, 3, 4, 5}
            });
            String expected = "1\t8\t0\t0\n5\t5\t5\t1\n2\t3\t4\t5\n";
            assertEquals(expected, matrix.toString(), "Should format phone number digits correctly");
            // Test getting individual digits
            assertEquals(5, matrix.getData_i_j(1, 0), "Should get first digit of second row");
            assertEquals(5, matrix.getData_i_j(2, 3), "Should get last digit");
        }

        @Test
        public void testSetDataChessboardMoves() {
            MatrixList matrix = new MatrixList(new int[][]{
                    {0, 0, 0, 0},
                    {0, 0, 0, 0},
                    {0, 0, 0, 0},
                    {0, 0, 0, 0}
            });

            // Simulate knight moves (represented by move number)
            matrix.setData_i_j(1, 0, 0);  // Starting position
            matrix.setData_i_j(2, 2, 1);  // Knight's first move
            matrix.setData_i_j(3, 1, 3);  // Knight's second move

            assertEquals(1, matrix.getData_i_j(0, 0), "Should get starting position");
            assertEquals(2, matrix.getData_i_j(2, 1), "Should get first move");
            assertEquals(3, matrix.getData_i_j(1, 3), "Should get second move");
            assertEquals(0, matrix.getData_i_j(3, 3), "Should get second move");
            assertEquals(Integer.MIN_VALUE, matrix.getData_i_j(3, 99), "Invalid");
            assertEquals(Integer.MIN_VALUE, matrix.getData_i_j(33, 99), "Invalid");
            assertEquals(Integer.MIN_VALUE, matrix.getData_i_j(33, 2), "Invalid");
            assertEquals(Integer.MIN_VALUE, matrix.getData_i_j(2, -1), "Invalid");
        }

        @Test
        public void testToStringCalendar() {
            // Representing a month calendar (0 for empty days)
            MatrixList matrix = new MatrixList(new int[][]{
                    {0, 0, 1, 2, 3, 4, 5},
                    {6, 7, 8, 9, 10, 11, 12},
                    {13, 14, 15, 16, 17, 18, 19},
                    {20, 21, 22, 23, 24, 25, 26},
                    {27, 28, 29, 30, 31, 0, 0}
            });
            String expected = """
                0\t0\t1\t2\t3\t4\t5
                6\t7\t8\t9\t10\t11\t12
                13\t14\t15\t16\t17\t18\t19
                20\t21\t22\t23\t24\t25\t26
                27\t28\t29\t30\t31\t0\t0
                """;
            assertEquals(expected, matrix.toString(), "Should format calendar layout correctly");
        }

        @Test
        public void testSetDataTemperatureMap() {
            MatrixList matrix = new MatrixList(new int[][]{
                    {20, 21, 22},
                    {21, 22, 23},
                    {22, 23, 24}
            });

            // Simulate temperature changes
            matrix.setData_i_j(25, 1, 1);  // Hot spot in center
            matrix.setData_i_j(19, 0, 0);  // Cold spot in corner

            assertEquals(25, matrix.getData_i_j(1, 1), "Should get updated center temperature");
            assertEquals(19, matrix.getData_i_j(0, 0), "Should get updated corner temperature");
        }

        @Test
        public void testSetDataPingPongScore() {
            MatrixList matrix = new MatrixList(new int[][]{
                    {0, 0, 0},
                    {0, 0, 0}
            });

            // Simulate ping pong game scoring
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 3; j++) {
                    matrix.setData_i_j((i + 1) * (j + 1), i, j);
                }
            }

            assertEquals(1, matrix.getData_i_j(0, 0), "Should get player 1 first set");
            assertEquals(6, matrix.getData_i_j(1, 2), "Should get player 2 final set");
        }

        @Test
        public void testInvalidPositions() {
            MatrixList matrix = new MatrixList(new int[][]{{1}});

            // Test invalid gets
            assertEquals(Integer.MIN_VALUE, matrix.getData_i_j(-1, 0), "Should handle negative row");
            assertEquals(Integer.MIN_VALUE, matrix.getData_i_j(0, -1), "Should handle negative column");
            assertEquals(Integer.MIN_VALUE, matrix.getData_i_j(1, 0), "Should handle out of bounds row");
            assertEquals(Integer.MIN_VALUE, matrix.getData_i_j(0, 1), "Should handle out of bounds column");

            // Test invalid sets (shouldn't throw exception)
            matrix.setData_i_j(100, -1, 0);
            matrix.setData_i_j(100, 0, -1);
            matrix.setData_i_j(100, 1, 0);
            matrix.setData_i_j(100, 0, 1);

            // Verify original value unchanged
            assertEquals(1, matrix.getData_i_j(0, 0), "Should maintain original value after invalid sets");
        }

        @Test
        public void testToStringBinaryMatrix() {
            MatrixList matrix = new MatrixList(new int[][]{
                    {0, 1, 0},
                    {1, 1, 1},
                    {0, 1, 0}
            });
            String expected = "0\t1\t0\n1\t1\t1\n0\t1\t0\n";
            assertEquals(expected, matrix.toString(), "Should format binary cross pattern correctly");
        }

        @Test
        public void testSetDataPixelArt() {
            // Create a simple pixel art (heart shape)
            MatrixList matrix = new MatrixList(new int[][]{
                    {0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0}
            });

            // Draw heart shape with 1s
            matrix.setData_i_j(1, 1, 1);
            matrix.setData_i_j(1, 1, 3);
            matrix.setData_i_j(1, 2, 0);
            matrix.setData_i_j(1, 2, 2);
            matrix.setData_i_j(1, 2, 4);
            matrix.setData_i_j(1, 3, 1);
            matrix.setData_i_j(1, 3, 3);
            matrix.setData_i_j(1, 4, 2);

            assertEquals(1, matrix.getData_i_j(4, 2), "Should get bottom point of heart");
            assertEquals(1, matrix.getData_i_j(2, 2), "Should get center of heart");
        }

        @Test
        public void testModificationTracking() {
            MatrixList matrix = new MatrixList(new int[][]{{1, 2}, {3, 4}});
            String originalString = matrix.toString();

            // Modify and verify each position
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    int originalValue = matrix.getData_i_j(i, j);
                    matrix.setData_i_j(originalValue * 2, i, j);
                    assertEquals(originalValue * 2, matrix.getData_i_j(i, j),
                            "Should get updated value at position " + i + "," + j);
                }
            }

            assertNotEquals(originalString, matrix.toString(), "String representation should change after modifications");
        }
    }

