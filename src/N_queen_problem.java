import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N_queen_problem
{
	public static void main(String[] args)
	{
		int n=4;
		List<List<String>> sol= Queen(n);

		System.out.println("No of Solution is : " + sol.size());
		for (List<String> i : sol)
		{
			for (String s :i){
				System.out.println(s);
			}
			System.out.println();
		}

	}
	static List<List<String>> Queen(int n ){
		List<List<String>> Result = new ArrayList<>();

		char [][] board = new char[n][n];

		for (int i = 0; i <board.length ; i++)
		{
			Arrays.fill(board[i],'.');
		}
		Backtrack(board,0,n,Result );
		return Result;
	}

	static  void Backtrack(char [] [] board ,int row ,int n,List<List<String>> result){
		if(row==n){
			List<String> newlist= new ArrayList<>();
			//we will save each row placement of the row -->
			for (int i = 0; i <n ; i++)
			{
				newlist.add(new String(board[i]));
			}
			result.add(newlist);
			return ;
		}

		for (int column = 0; column <n ; column++)
		{
			if(isSafe(board,column,row,n)){
				board[row][column]='Q';
				Backtrack(board,row+1,n,result);
				board[row][column]='.';
			}
		}


	}
	static  Boolean isSafe(char[][] board,int col,int row,int n){

		// in that column-->
		for (int i = 0; i <row ; i++)
		{
		if(board[i][col]=='Q'){
			return false;
		}

		}
		//upper left-->
		for (int i = row-1 ,  j=col-1 ; i >=0 && j>=0 ; i--,j--)
		{
			if(board[i][j]=='Q'){
				return false;
			}
		}

		//upper right-->
		for (int i = row-1,j=col+1; i >=0 && j<n ; i--,j++)
		{
			if(board[i][j]=='Q'){
				return false;
			}

		}
		return true;
	}
}
