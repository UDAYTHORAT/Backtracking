import java.util.Arrays;

public class K_Knight_Problem
{
	public static void main(String[] args)
	{
		int n=5;
		int Knight=13;
		String [] [] board = new String[n][n];

		for (String [] b : board){
			Arrays.fill(b,".");
		}
		int count= PlaceKnights(board,0,0,0,Knight);

		System.out.print("Total way to place " + Knight +" Knights in the "+n+"x"+n +" borad is: ");
		System.out.println(count);

	}
	static int PlaceKnights(String[] [] board,int row,int col,int placed ,int targetKnights ){

	if(placed==targetKnights){
		for (String [] b: board){
			System.out.println(Arrays.toString(b));
		}
		System.out.println();
		return 1;
	}
	if(row==board.length){
		return 0;
	}

	int nextrow = row;
	int nextcol=col+1;
	if(nextcol==board.length){
		nextrow++;
		nextcol=0;

	}
  int count=0;
     //place the  knight -->
	if(isSafe(board,row,col)){
		board[row][col]="K";
		count+=PlaceKnights(board,nextrow,nextcol,placed+1,targetKnights);
		board[row][col]=".";
	}
	//dont place the knight-->

		count+=PlaceKnights(board,nextrow,nextcol,placed,targetKnights);

	return count;

	}
	static boolean isSafe(String [] [] board,int row,int col){

		int l=board.length;
		//check in upside -->
		int [] [] moves ={
				{-2,-1},{-2,+1},
				{-1,-2},{+1,-2},
				{-1,+2},{+1,+2},
				{+2,-1},{+2,+1}
		};

		for (int [] m : moves){
			int r= row + m[0];
            int c= col + m[1];

			if(r>=0 && c>=0 && r<l && c<l){
				if(board[r][c].equals("K")){
					return false;
				}
			}
		}
		return true;
	}

}

