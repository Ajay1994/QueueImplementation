package com.example.problems;
/*
 * Given a matrix of dimension m*n where each cell in the matrix can have values 0, 1 or 2 which 
 * has the following meaning:

	0: Empty cell
	
	1: Cells have fresh oranges
	
	2: Cells have rotten oranges 

	So we have to determine what is the minimum time required so that all the oranges become rotten.
	 A rotten orange at index [i,j] can rot other fresh orange at indexes [i-1,j], [i+1,j], [i,j-1], [i,j+1] 
	 (up, down, left and right). If it is impossible to rot every orange then simply return -1.
 */
import java.util.*;
class Coordinate{
	int x;
	int y;
	public Coordinate(int x, int y) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
	}
}
public class RottenOranges {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = { {2, 1, 0, 2, 1},
                {1, 0, 1, 2, 1},
                {1, 0, 0, 2, 1}};
		Queue<Coordinate> queue = new LinkedList<Coordinate>();
		int collen = 5;
		int rowlen = 3;
		for(int i = 0; i<rowlen; i++){
			for(int j = 0; j< collen; j++){
				if(grid[i][j] == 2){
					queue.add(new Coordinate(i,j));
				}
			}
		}
		queue.add(new Coordinate(-1, -1));
		int level = 0;
		while(!queue.isEmpty()){
			Coordinate c = queue.remove();
			if(c.x == -1 && c.y == -1){
				if(queue.isEmpty()) break;
				else{
					queue.add(new Coordinate(-1,-1));
					level += 1;
					continue;
				}
			}
			System.out.println("("+ c.x+","+c.y+")");
			if(c.x -1 >= 0 && grid[c.x-1][c.y] == 1){
				grid[c.x-1][c.y] = 2;
				queue.add(new Coordinate(c.x-1, c.y));
			}
			if(c.y + 1 < collen && grid[c.x][c.y + 1] == 1){
				grid[c.x][c.y + 1] = 2;
				queue.add(new Coordinate(c.x, c.y+1));
			}
			
			if(c.x + 1 < rowlen && grid[c.x+1][c.y] == 1){
				grid[c.x+1][c.y] = 2;
				queue.add(new Coordinate(c.x+1, c.y));
			}
			if(c.y - 1 >= 0 && grid[c.x][c.y - 1] == 1){
				grid[c.x][c.y - 1] = 2;
				queue.add(new Coordinate(c.x, c.y-1));
			}
		}
		boolean isTrue = true;
		for(int i = 0; i<rowlen; i++){
			for(int j = 0; j< collen; j++){
				if(grid[i][j] == 1){
					isTrue = false;
				}
			}
		}
		if(isTrue == true) System.out.println("Level : "+level);
		else System.out.println("Not Possible");
	}

}
