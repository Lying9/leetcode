package pickone.eazy;


/**
 * Created by ying on 2018/11/15.
 */
public class Construct427 {
    public static void main(String[] args) {
        int[][] grid = {{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0},{1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1},{1,1,1,1,0,0,0,0},
                {1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0}
        };
        Node root = construct(grid);
//        System.out.println("aaaaaa");
    }
    public static Node construct(int[][] grid) {
        if(grid==null || grid.length == 0)
            return null;
        return recursive(grid,0,0,grid.length);
    }
//    递归
    public static Node recursive(int[][] grid,int startrow,int startcol,int length){
        int num = grid[startrow][startcol];
        int i,j;
        boolean isSame = true;
        for (i = startrow; i <startrow+length ; i++) {
            for ( j = startcol; j <startcol+length ; j++) {
                if(grid[i][j] != num) {
                    isSame = false;
                    break;
                }
            }
            if(!isSame)
                break;
        }
        Node  node = new Node();
        if(!isSame){
            node.isLeaf = false;
            node.topLeft =recursive(grid,startrow,startcol,length/2);
            node.topRight = recursive(grid,startrow,startcol+length/2,length/2);
            node.bottomLeft = recursive(grid,startrow+length/2,startcol,length/2);
            node.bottomRight = recursive(grid,startrow+length/2,startcol+length/2,length/2);
        }else{
            node.isLeaf = true;
            if(num == 1)
                node.val = true;
            else
                node.val = false;
        }
        return node;
    }
}
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {}

    public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
}

