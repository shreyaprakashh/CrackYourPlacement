// You are given an n x n binary matrix grid. You are allowed to change at most one 0 to be 1.
// Return the size of the largest island in grid after applying this operation.

class Solution {
    int[][] offsets = {{0,1}, {1,0}, {-1,0}, {0, -1}};
    public int largestIsland(int[][] grid) {
        Metadata[][] data = new Metadata[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(data[i][j] == null) {
                    dfs(data, new Metadata(), i, j, grid);
                }
            }
        }

        int max = 0;
        for(int i = 0; i < data.length; i++) {
            for(int j = 0; j < data[0].length; j++) {
                if(data[i][j] != null) {
                    max = Math.max(max, data[i][j].island.size());
                    continue;
                }
                int current = 1;
                for(int k = 0; k < 4; k++) {
                    int nI = i + offsets[k][0];
                    int nJ = j + offsets[k][1];

                    if(nI >= 0 && 
                    nJ >= 0 && 
                    nI < data.length && 
                    nJ < data[0].length && 
                    data[nI][nJ] != null &&
                    !data[nI][nJ].visisted
                    ) {
                        current += data[nI][nJ].island.size();
                        data[nI][nJ].visisted = true;
                    }
                }

                for(int k = 0; k < 4; k++) {
                    int nI = i + offsets[k][0];
                    int nJ = j + offsets[k][1];

                    if(nI >= 0 && 
                    nJ >= 0 && 
                    nI < data.length && 
                    nJ < data[0].length && 
                    data[nI][nJ] != null
                    ) {
                        data[nI][nJ].visisted = false;
                    }
                }
                max = Math.max(max, current);
            }
        }

        return max;
    }

    public void dfs(Metadata[][] dataGrid, Metadata data, int i, int j, int[][] grid) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return;
        }
        if(grid[i][j] != 1) {
            return;
        }
        data.island.add(new Point(i, j));
        dataGrid[i][j] = data;
        grid[i][j] = -1;
        for(int offset = 0; offset < 4; offset++) {
            int newI = i + offsets[offset][0];
            int newJ = j + offsets[offset][1];
            if(newI >= 0 && newI < grid.length && newJ >= 0 && newJ < grid[0].length && grid[newI][newJ] == 1) {
                dfs(dataGrid, data, newI, newJ, grid);
            }
        }
    }
}
class Metadata {
    HashSet<Point> island = new HashSet<>();
    boolean visisted = false;
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int hashCode() {
        return 7 * this.x + this.y;
    }

    public boolean equals(Object o) {
        if(!(o instanceof Point)) {
            return false;
        }
        Point p = (Point)o;
        return this.x == p.x && this.y == p.y;
    }
}
