
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
        IntNodeMat head = _m00;
        IntNodeMat prevHead = _m00;
        IntNodeMat ptr = _m00;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if(i==0 && j==0){
                    continue;
                }
                IntNodeMat node = new IntNodeMat(mat[i][j]);
                if(i==0){
                    ptr.setNextCol(node);
                    node.setPrevCol(ptr);
                }
                else if(j==0){
                    prevHead = head;
                    head = node;
                    ptr= node;
                    prevHead.setNextRow(node);
                    node.setPrevRow(prevHead);
                    prevHead = prevHead.getNextCol();
                }
                else{
                    prevHead.setNextRow(node);
                    node.setPrevRow(prevHead);
                    ptr.setNextCol(node);
                    node.setPrevCol(ptr);
                }
                if (ptr.getNextCol() !=null && prevHead.getNextCol()!=null) {
                    ptr = ptr.getNextCol();
                    prevHead = prevHead.getNextCol();
                }
            }
        }
    }


    public int getData_i_j (int i, int j)
    {
        IntNodeMat corrent = _m00;
        if (_m00==null || i<0 || j<0){
            return Integer.MIN_VALUE;
        }
        else{
            int p=0,q=0;
            while(p!=i && corrent.getNextRow() != null){
                p=p+1;
                corrent = corrent.getNextRow();
            }
            while(q!=j && corrent.getNextCol() != null){
                q=q+1;
                corrent = corrent.getNextCol();
            }
            if ( p!=i || q !=j){
                return Integer.MIN_VALUE;
            }
        }
        return corrent.getData();
    }


    public void setData_i_j (int data, int i, int j)
    {
        IntNodeMat corrent = _m00;
        int p=0,q=0;
        while(p!=i && corrent.getNextRow() != null){
            p=p+1;
            corrent = corrent.getNextRow();
        }
        while(q!=j && corrent.getNextCol() != null){
            q=q+1;
            corrent = corrent.getNextCol();
        }
        if( p==i && q ==j){
            corrent.setData(data);
        }
    }

    public String toString()
    {
        if (_m00 == null){
            return "";
        }
        String result = "";
        IntNodeMat nodeX = _m00;
        IntNodeMat nodeY = _m00;
        while (nodeY != null) {
            while (nodeX != null) {
                result += nodeX.getData();
                if (nodeX.getNextCol() != null){
                    result += "\t";
                }
                nodeX = nodeX.getNextCol();
            }
            nodeY = nodeY.getNextRow();
            nodeX = nodeY;
            result += "\n";
        }
        return result;
    }

    public int findMax()
    {
        if (_m00 == null) {
            return Integer.MIN_VALUE;
        }
        return findMax(_m00, Integer.MIN_VALUE,_m00);
    }

    private int findMax(IntNodeMat corrent, int max, IntNodeMat header) {

        max = Math.max(corrent.getData(), max);
        if (corrent.getNextCol() != null) {
            corrent = corrent.getNextCol();
            return findMax(corrent, max, header);
        } else {
            if (header.getNextRow() != null) {
                header = header.getNextRow();
                corrent = header;
                return findMax(corrent, max, header);
            } else {
                return max;
            }
        }
    }

    public int howManyX(int x)
    {
        if (_m00 == null) {
            return 0;
        }
        int counter=0;
        IntNodeMat ptr = _m00;
        while(ptr != null){
            if(ptr.getData() == x){
                counter = counter+1;
                ptr = ptr.getNextRow();
            }
            else if(ptr.getData() <x){
                if(ptr.getNextCol() != null){
                    ptr = ptr.getNextCol();
                }
                else{
                    ptr = ptr.getNextRow();
                }
            }
            else{
                if(ptr.getPrevCol() != null){
                    ptr = ptr.getPrevCol();
                }
                else{
                    ptr = ptr.getNextRow();
                }
            }
        }
        return counter;
    }
}