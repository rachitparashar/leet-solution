class Solution {
    public Node connect(Node root) {
        return helper(root,null);
    }
    public Node helper(Node node, Node next){
        if(node==null)
            return null;
        node.next = next;
        helper(node.left,node.right);
        helper(node.right,next!=null?next.left:next);
        return node;
    }
}