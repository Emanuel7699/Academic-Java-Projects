
/** public class MatrixList.
 * This class represents the all MAMAN questions.
 *
 * @author Emanuel Abraham
 * @version 31/1/2025 (2025a)
 */
public class MatrixList
{
    IntNodeMat _m00;

    /** The method insert null while there is no matrix;
     *
     */
    public MatrixList()
    {
        _m00 = null;
    }

    /** The method build a Linked list by the matrix.
     *
     * @param mat Matrix.
     */

    public MatrixList(int[][]mat) {

        if (mat == null || mat.length == 0 || mat[0].length == 0) {// If the array is empty.
            _m00 = null;
            return;
        }
        _m00 = new IntNodeMat(mat[0][0]);
        IntNodeMat head = _m00;
        IntNodeMat prevHead = _m00;
        IntNodeMat ptr = _m00;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if(i==0 && j==0){//If the index in array[0][0].
                    continue;
                }
                IntNodeMat node = new IntNodeMat(mat[i][j]);
                if(i==0){//First row.
                    ptr.setNextCol(node);
                    node.setPrevCol(ptr);
                }
                else if(j==0){//First colum.
                    prevHead = head;
                    head = node;
                    ptr= node;
                    prevHead.setNextRow(node);
                    node.setPrevRow(prevHead);
                    prevHead = prevHead.getNextCol();
                }
                else{//others index.
                    prevHead.setNextRow(node);
                    node.setPrevRow(prevHead);
                    ptr.setNextCol(node);
                    node.setPrevCol(ptr);
                }
                if (ptr.getNextCol() !=null && prevHead.getNextCol()!=null) {//Promote ptr and prevHead pointers.
                    ptr = ptr.getNextCol();
                    prevHead = prevHead.getNextCol();
                }
            }
        }
    }

    /** The method get the data of the index.
     *
     * @param i Row index.
     * @param j Colum index.
     * @return The data of a specific index.
     */
    public int getData_i_j (int i, int j)
    {
        IntNodeMat current = _m00;
        if (_m00==null || i<0 || j<0){// If the pointer is out of array bonds.
            return Integer.MIN_VALUE;
        }
        else{
            int p=0,q=0;
            while(p!=i && current.getNextRow() != null){//if the row is not equals to row that gets.
                p=p+1;
                current = current.getNextRow();
            }
            while(q!=j && current.getNextCol() != null){//if the colum is not equals to colum that gets.
                q=q+1;
                current = current.getNextCol();
            }
            if ( p!=i || q !=j){//if the pointer does not appear in the array.
                return Integer.MIN_VALUE;
            }
        }
        return current.getData();
    }

    /** The method enter a data to specific index.
     *
     * @param data Some data.
     * @param i Row index.
     * @param j Colum index.
     */
    public void setData_i_j (int data, int i, int j)
    {
        IntNodeMat corrent = _m00;
        int p=0,q=0;
        while(p!=i && corrent.getNextRow() != null){//if the row is not equals to row that gets.
            p=p+1;
            corrent = corrent.getNextRow();
        }
        while(q!=j && corrent.getNextCol() != null){//if the colum is not equals to colum that gets.
            q=q+1;
            corrent = corrent.getNextCol();
        }
        if( p==i && q ==j){//if the pointer appears in the array.
            corrent.setData(data);
        }
    }

    /** The method print the list in shape of array.
     *
     * @return The list in shape of array.
     */
    public String toString()
    {
        if (_m00 == null){//if the matrix empty.
            return "";
        }
        String result = "";
        IntNodeMat nodeX = _m00;
        IntNodeMat nodeY = _m00;
        while (nodeY != null) {//if the colum pointer is valid.
            while (nodeX != null) {//if the row pointer is valid.
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
        return result;//print the matrix.
    }

    /** The method find the max number of the list.
     *
     * @return The max number.
     */
    public int findMax()
    {
        if (_m00 == null) {//if the matrix empty.
            return Integer.MIN_VALUE;
        }
        return findMax(_m00, Integer.MIN_VALUE,_m00);//return the max number in the array.
    }

    /** The method find the max number of the list.
     *
     * @param current Current number.
     * @param max Max number.
     * @param header Head of row.
     * @return The max number.
     */
    private int findMax(IntNodeMat current, int max, IntNodeMat header) {

        max = Math.max(current.getData(), max);
        if (current.getNextCol() != null) {//if the next colum is not empty.
            current = current.getNextCol();
            return findMax(current, max, header);
        } else {
            if (header.getNextRow() != null) {//if the next row is not empty.
                header = header.getNextRow();
                current = header;
                return findMax(current, max, header);
            } else {
                return max;//return the max number
            }
        }
    }

    /** This method gets a number and checks how many times the number appears in the array.
     *
     * @param x The number.
     * @return The count.
     * Time complexity o(n+m) One While, In the worst case - n+m Iteration.
     * Space complexity o(1) There is no more an additional memory except for the counter variable.
     */
    public int howManyX(int x)
    {
        if (_m00 == null) {//if the matrix empty.
            return 0;
        }
        int counter=0;
        IntNodeMat ptr = _m00;
        while(ptr != null){//if the pointer is valid.
            if(ptr.getData() == x){//if the data pointer and the number that gets are equals.
                counter = counter+1;
                ptr = ptr.getNextRow();
            }
            else if(ptr.getData() <x){//if the data pointer is smaller than the number.
                if(ptr.getNextCol() != null){
                    ptr = ptr.getNextCol();
                }
                else{
                    ptr = ptr.getNextRow();
                }
            }
            else{//if the data pointer is bigger than the number.
                if(ptr.getPrevCol() != null){
                    ptr = ptr.getPrevCol();
                }
                else{
                    ptr = ptr.getNextRow();
                }
            }
        }
        return counter;//Returns the count.
    }
}