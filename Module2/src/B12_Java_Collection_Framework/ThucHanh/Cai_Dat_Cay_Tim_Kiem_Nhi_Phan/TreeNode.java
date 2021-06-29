package B12_Java_Collection_Framework.ThucHanh.Cai_Dat_Cay_Tim_Kiem_Nhi_Phan;

public class TreeNode<E> {
    protected E element;
    protected TreeNode<E> left;
    protected TreeNode<E> right;

    public TreeNode(E e) {
        element = e;
    }
}
