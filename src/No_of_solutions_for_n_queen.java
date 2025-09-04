import java.util.ArrayList;
import java.util.Arrays;

public class No_of_solutions_for_n_queen
{
	public static void main(String[] args)
	{
		int n=4;
		System.out.println(Queen(n));

	}
	static int Queen( int n){
		ArrayList<ArrayList<String >> list =new ArrayList<>();
		char [] [] board =new char[n][n];

		for (int i = 0; i <n ; i++)
		{
			Arrays.fill(board[i],'-');
		}
		Search(board,0,n,list);
		return list.size();

}
   static void Search(char [] [] board,int row,int n, ArrayList<ArrayList<String >> list){

		if(row==n){
			ArrayList<String> sol=new ArrayList<>();
			for (int i = 0; i <n ; i++)
			{
				sol.add(new String(board[i]));
			}
			list.add(sol);
			return;
		}
	   for (int col = 0; col <n ; col++)
	   {
		   if(isSafe(board,row,col,n)){
			   board[row][col]='Q';
			   Search(board,row+1,n,list);
			   board[row][col]='-';
		   }
	   }
   }

   static  boolean isSafe(char[][] board,int row,int col,int n){

		//in the same column -->
	   for (int i = 0; i <row ; i++)
	   {
		   if(board[i][col]=='Q'){
			   return false;
		   }
	   }
	   //upper left-->
	   for (int i = row-1,j=col-1; i >=0 && j>=0 ; i--,j--)
	   {
		   if(board[i][j]=='Q'){
			   return false;
		   }
	   }
	   //upper right-->
	   for (int i = row-1,j=col+1; i>=0 && j<n ; i--,j++)
	   {
		   if(board[i][j]=='Q'){
			   return false;
		   }
	   }
		return true;
   }
 }
