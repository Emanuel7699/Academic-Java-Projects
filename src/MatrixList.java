
/**
 * Write a description of class MatrixList here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MatrixList
{
    IntNodeMat _m00;

    public MatrixList()
    {
        _m00 = null;
    }

    public MatrixList(int[][]mat) {

        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            _m00 = null;
            return;
        }

        _m00 = new IntNodeMat(mat[0][0]);
        IntNodeMat head = null;
        IntNodeMat prevHead = null;
        for (int i = 0; i < mat.length; i++) {
            IntNodeMat ptr = null;
            for (int j = 0; j < mat[0].length; j++) {
                IntNodeMat node = new IntNodeMat(mat[i][j]);
                if (ptr == null) {
                    head = node;
                    if (prevHead != null) {
                        prevHead.setNextRow(node);
                        node.setPrevRow(prevHead);
                    }
                } else {
                    ptr.setNextCol(node);
                    node.setPrevCol(ptr);
                }
                ptr = node;
            }
            prevHead = head;
        }
    }

    public int getData_i_j (int i, int j)
    {
        return 0;
    }

    public void setData_i_j (int data, int i, int j)
    {

    }
  
    public String toString()
    {
        int i=0,j=0;
        if (getData_i_j(i,j) != null){
            System.out.println(getData_i_j(i,j));
            j++;
        }
        else if (getData_i_j(i,0) == null) {
            return;
        }
        i++;
        j = 0;
        return toString();
    }

    public int findMax()
    {
        return 0;
    }

    public int howManyX(int x)
    {
        return 0;
    }

}