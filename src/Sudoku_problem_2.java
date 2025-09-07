public class Sudoku_problem_2
{
	public static void main(String[] args)
	{

		String [] [] sudoku ={{"5","3",".",".","7",".",".",".","."}
				,{"6",".",".","1","9","5",".",".","."}
				,{".","9","8",".",".",".",".","6","."}
				,{"8",".",".",".","6",".",".",".","3"}
				,{"4",".",".","8",".","3",".",".","1"}
				,{"7",".",".",".","2",".",".",".","6"}
				,{".","6",".",".",".",".","2","8","."}
				,{".",".",".","4","1","9",".",".","5"}
				,{".",".",".",".","8",".",".","7","9"}};

		String[][] sudoku3={{".","8","7","6","5","4","3","2","1"},{"2",".",".",".",".",".",".",".","."},{"3",".",".",
			".",".",".",".",".","."},{"4",".",".",".",".",".",".",".","."},{"5",".",".",".",".",".",".",".","."},{"6"
			,".",".",".",".",".",".",".","."},{"7",".",".",".",".",".",".",".","."},{"8",".",".",".",".",".",".",".",
			"."},{"9",".",".",".",".",".",".",".","."}};

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

		boolean result1 = Sudoku(sudoku,0,0);
		System.out.println(result1);

		boolean result = Sudoku(sudoku1,0,0);
		System.out.println(result);

		boolean result3 = Sudoku(sudoku3,0,0);
		System.out.println(result3);
	}



	static boolean Sudoku(String [] [] board ,int row,int col)
	{

		if (row == board.length)
		{
			return true;
		}

		int newrow = row;
		int newcol = col + 1;

		if (col == board.length-1)
		{
			newrow++;
			newcol = 0;
		}

		if(!board[row][col].equals(".")){
			 return  Sudoku(board,newrow,newcol);
		}

		for (int i = 1; i <=9; i++)
		{
			String val= String.valueOf(i);
			if(isSafe(board,row,col,val)){
				board[row][col]=val;
				if(Sudoku(board,newrow,newcol)){
					return true;
				}
				board[row][col]=".";
			}
		}
		return false;


	}
	static boolean isSafe(String [] [] board ,int row,int col, String  val){

		//check in that row and col-->

		for (int i = 0; i <9 ; i++)
		{
			if(board[i][col].equals(val) || board[row][i].equals(val)){
				return false;
			}
		}

		int newrow =row - row%3;
		int newcol= col- col%3;

		for (int i = newrow; i <newrow+3 ; i++)
		{
			for (int j = newcol; j <newcol+3; j++)
			{
				if(board[i][j].equals(val)){
					return false;
				}
			}
		}
		return true;
	}

}
