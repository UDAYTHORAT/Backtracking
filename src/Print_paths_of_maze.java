import java.util.Arrays;

public class Print_paths_of_maze
{
	public static void main(String[] args)
	{
		int n=2;
		boolean [][] board= new boolean[n][n];

		int [][] path =new int[board.length][board[0].length];

		Maze(board,0,0,"",path,1);

	}
	static  void Maze(boolean [] [] board,int row ,int col,String newStr,int [] [] path,int steps){

		int m=board.length;
		int k=board[0].length;
		if(row==m-1 && col== k-1){
			path[row][col]=steps;
			for (int [] way : path)
			{
				System.out.println(Arrays.toString(way));
			}
			System.out.println(newStr);
			System.out.println();
			return;
		}

		if(row<0 || col<0 || row>=m ||col>=k || board[row][col]){
			return;
		}
		board[row][col]=true;
		path[row][col]=steps;
		Maze(board,row+1,col,newStr+"D",path,steps+1);
		Maze(board,row,col+1,newStr+"R",path,steps+1);
		Maze(board,row-1,col,newStr+"U",path,steps+1);
		Maze(board,row,col-1,newStr+"L",path,steps+1);

		board[row][col]=false;
		path[row][col]=0;
	}
}
