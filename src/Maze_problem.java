import java.util.ArrayList;

public class Maze_problem
{
	public static void main(String[] args)
	{
		int n=2;
		System.out.print("NO of ways we can solve reach our destination in "+ n+"x"+n +"Maze is --> ");
		int k=Maze(n,0,0);
		System.out.println(k);
		System.out.println();
		System.out.println("Following is Paths we can Follow to reach the Destination : ");
		MazePaths(n,0,0,"");

		ArrayList<String> Res=MazePaths(n,0,0,"",new ArrayList<>());
		System.out.println(Res);

	}
	//No of paths we can reach the Destination-->
static int Maze(int n,int row ,int col){
		if(row==n-1 && col==n-1){
			return 1;
		}
		if(row>=n || col>=n){
			return 0;
		}

		int k=Maze(n,row+1,col);


		int w=Maze(n,row,col+1);

     return k+w;
}

   //Paths to follow to reach to the Destination-->
	static void MazePaths(int n,int row ,int col,String path){

		if(row==n-1 && col==n-1){
			System.out.println(path);
			return ;
		}
		if(row>=n || col>=n){
			return ;
		}

		MazePaths(n,row+1,col,path+"D");


		MazePaths(n,row,col+1,path+"R");


	}

	//ArrayList of the Paths to reach the Destination-->

	static ArrayList<String> MazePaths(int n, int row , int col,String path, ArrayList<String> list){
		if(row==n-1 && col==n-1){
			list.add(path);
			return list ;
		}
		if(row>=n || col>=n){
			return list;
		}

		MazePaths(n,row+1,col,path+"D",list);


		MazePaths(n,row,col+1,path+"R",list);

    return list;
	}
}

