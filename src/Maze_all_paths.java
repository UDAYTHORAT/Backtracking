import java.util.ArrayList;

public class Maze_all_paths
{
	public static void main(String[] args)
	{
		int n=3;
		boolean [] [] visited = new boolean[n][n];
		int sol=Maze(n,0,0,visited);

		System.out.println(sol);
		ArrayList<String> res =MazePaths(n,0,0,"",new ArrayList<>(), visited);
		System.out.println(res);
	}
	static int Maze(int n,int row ,int col,boolean[][] visited){
		if(row==n-1 && col==n-1){
			return 1;
		}
		if(row>=n || col>=n || row<0 || col<0 || visited[row][col]){
			return 0;
		}

		visited[row][col]=true;

		int k=Maze(n,row+1,col,visited);

		int w=Maze(n,row,col+1,visited);

		int x=Maze(n,row-1,col,visited);

		int y=Maze(n,row,col-1,visited);

		visited[row][col]=false;

		return k+w+x+y;
	}

	static ArrayList<String> MazePaths(int n, int row , int col, String path, ArrayList<String> list,
									   boolean [] [] visited){
		if(row==n-1 && col==n-1){
			list.add(path);
			return list ;
		}
		if(row>=n || col>=n || row<0 || col <0 || visited[row] [col]){
			return list;
		}
		visited[row][col]=true;

		MazePaths(n,row+1,col,path+"D",list, visited); //#1

		MazePaths(n,row,col+1,path+"R",list,visited);   //#2

		MazePaths(n,row-1,col,path+"U",list,visited); //#3

		MazePaths(n,row,col-1,path+"L",list, visited); //#4


		visited[row][col]=false;

		return list;
	}
}

/*
------------------------------------------------------------
🔍 How recursion + backtracking works in Maze() and MazePaths()
------------------------------------------------------------

1. Both Maze() and MazePaths() use the same recursive pattern:
   - ENTER a cell → visited[row][col] = true
   - Explore in order:
        #1 → Down (row+1, col)
        #2 → Right (row, col+1)
        #3 → Up (row-1, col)
        #4 → Left (row, col-1)
   - EXIT a cell → visited[row][col] = false (backtracking)

2. Differences:
   - Maze() → returns count of paths (int)
   - MazePaths() → stores actual paths (ArrayList<String>)

3. Base cases:
   - If (row, col) == (n-1, n-1):
       • Maze() returns 1
       • MazePaths() adds path string
   - If out of bounds OR visited[row][col] is true → return immediately

------------------------------------------------------------
📌 Example Trace (n=3), Path = "DDRURD":
------------------------------------------------------------
ENTER (0,0)
  #1 → ENTER (1,0)
    #1 → ENTER (2,0)
      #2 → ENTER (2,1)
        #3 → ENTER (1,1)
          #2 → ENTER (1,2)
            #1 → ENTER (2,2) ✅ Goal
            EXIT (2,2) → visited=false
          EXIT (1,2) → visited=false
        EXIT (1,1) → visited=false
      EXIT (2,1) → visited=false
    EXIT (2,0) → visited=false
  EXIT (1,0) → visited=false
EXIT (0,0) → visited=false

This is one successful path "DDRURD".
Each EXIT resets visited[][] so other paths can reuse the cells.

------------------------------------------------------------
📌 Backtracking Flow Explanation:
------------------------------------------------------------
- Every call “pushes” the cell on the stack (visited=true).
- When done with all 4 moves (#1,#2,#3,#4), the cell is “popped” (visited=false).
- That’s why:
   (1,1) finishes → false → return to (2,1)
   (2,1) finishes → false → return to (2,0)
   (2,0) finishes → false → return to (1,0)
   (1,0) finishes → false → return to (0,0)

------------------------------------------------------------
📌 For Maze() (count):
------------------------------------------------------------
- Each successful path returns 1 at (2,2).
- Failed branches return 0.
- Parent sums: return k+w+x+y
- So final result at (0,0) = total number of paths.

📌 For MazePaths() (collect paths):
------------------------------------------------------------
- Each successful path string is added to the list at (2,2).
- After exploring all branches, the list contains all possible paths.

------------------------------------------------------------
📌 Total for n=3:
Paths found:
DDRR, DDRURD, DRDR, DRRD, DRURDD, RDDR, RDRD, RRDD
Count = 8
------------------------------------------------------------
*/



