package net.projecteuler.util;

import java.util.function.Function;

public class Matrix {
	public static <T> T[][] rotateMatrix(T[][] matrix, Function<Integer, T[][]> matrixF, Function<Integer, T[]> rowF) {
		T[][] res = matrixF.apply(matrix.length);
		for (int rowIdx = 0; rowIdx < matrix.length; rowIdx++) {
			res[rowIdx] = rowF.apply(matrix.length);
			for (int colIdx = 0; colIdx < matrix.length; colIdx++) {
				res[rowIdx][colIdx] = matrix[colIdx][rowIdx];
			}
		}
		return res;
	}

	public static <T> T[][] newMatrix(int rows, int cols, Function<Integer, T[][]> matrixF, Function<Integer, T[]> rowF) {
		T[][] matrix = matrixF.apply(rows);
		for (int i = 0; i < matrix.length; i++) {
			matrix[i] = rowF.apply(cols);
		}
		return matrix;
	}

	public static <T> void printMatrix(T[][] matrix) {
		for (int rowIdx = 0; rowIdx < matrix.length; rowIdx++) {
			for (int colIdx = 0; colIdx < matrix.length; colIdx++) {
				System.out.print(matrix[rowIdx][colIdx] + " ");
			}
			System.out.println();
		}
	}

}
