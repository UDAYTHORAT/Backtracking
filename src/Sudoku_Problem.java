import java.util.Arrays;

public class Sudoku_Problem
{
	public static void main(String[] args)
	{

		String [] [] sudoku1= {
				 {"8","3",".",".","7",".",".",".","."}
				,{"6",".",".","1","9","5",".",".","."}
				,{".","9","8",".",".",".",".","6","."}
				,{"8",".",".",".","6",".",".",".","3"}
				,{"4",".",".","8",".","3",".",".","1"}
				,{"7",".",".",".","2",".",".",".","6"}
				,{".","6",".",".",".",".","2","8","."}
				,{".",".",".","4","1","9",".",".","5"}
				,{".",".",".",".","8",".",".","7","9"}};


		String [] [] sudoku2={{"5","3",".",".","7",".",".",".","."}
,{"6",".",".","1","9","5",".",".","."}
,{".","9","8",".",".",".",".","6","."}
,{"8",".",".",".","6",".",".",".","3"}
,{"4",".",".","8",".","3",".",".","1"}
,{"7",".",".",".","2",".",".",".","6"}
,{".","6",".",".",".",".","2","8","."}
,{".",".",".","4","1","9",".",".","5"}
,{".",".",".",".","8",".",".","7","9"}};

		Soduko(sudoku1,0,0);

		Soduko(sudoku2,0,0);


	}
	static void Soduko(String [] [] sudoku,int row ,int col){

		if (row==9){

			for (String [] s : sudoku){
				System.out.println(Arrays.toString(s));
			}
			return ;
		}
		if (col== sudoku.length){
			 Soduko(sudoku,row+1,0);
			 return;
		}

		if (!sudoku[row][col].equals(".")){
			Soduko(sudoku,row,col+1);
			return;
		}

		for (int i = 1; i <=9; i++)
		{
			String val =String.valueOf(i);
			if (isSafe(sudoku,row,col,val)){
				sudoku[row][col]=val;
				Soduko(sudoku,row,col+1);
				sudoku[row][col]=".";
			}

		}


	}
	static  boolean isSafe(String [] [] sudoku,int row,int col,String num){

		//check in the row and col -->

		for (int i = 0; i <9; i++)
		{
			if(sudoku[i][col].equals(num) || sudoku[row][i].equals(num)){
				return false;
			}
		}

		//check in the matrix of 3x3 -->

		int startRow = row - row % 3;
		int startCol = col - col % 3;
		for (int i = startRow; i <startRow+3; i++)
		{
			for (int j = startCol; j <startCol+3; j++)
			{
				if(sudoku[i][j].equals(num)){
					return false;
				}
			}

		}
		return true;
	}
}
