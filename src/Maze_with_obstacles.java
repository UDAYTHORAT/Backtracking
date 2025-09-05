import java.util.ArrayList;

public class Maze_with_obstacles
{
	public static void main(String[] args)
	{
		int n=3;
		boolean [] [] board={
				{true,true,false},
				{true,true,true},
				{false,false,true}
		};

		ArrayList<String> sol= MazeObs(n,board,0,0,"",new ArrayList<>());
		System.out.println(sol);

	}
	static ArrayList<String> MazeObs(int n,boolean [] [] board ,int row ,int col,String path,ArrayList<String> list){

		int m=board.length;
		int k=board[0].length;

		if(row==m-1 && col==k-1){
			list.add(path);
			return list;
		}

		if(row>=m || col>=k){
			return list;
		}

		if(!board[row][col]){
			return list;
		}

		MazeObs(n,board,row+1,col,path+"D",list);

		MazeObs(n,board,row,col+1,path+"R",list);


		return list;
	}
}
