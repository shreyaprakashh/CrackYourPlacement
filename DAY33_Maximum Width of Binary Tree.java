// Given the root of a binary tree, return the maximum width of the given tree.
class Pair {
    TreeNode node; 
    int num; 
    Pair(TreeNode _node, int _num) {
        num = _num;
        node = _node; 
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        int maxWidth = 0;
        Queue<Pair> q = new LinkedList<>(); 
        q.offer(new Pair(root, 0)); 
        while(!q.isEmpty()){
            int size = q.size();
            int mmin = q.peek().num;    
            int first = 0,last = 0;
            for(int i=0; i<size; i++){
                int cur_id = q.peek().num-mmin;
                TreeNode node = q.peek().node;
                q.poll();
                if(i==0) first = cur_id;
                if(i==size-1) last = cur_id;
                if(node.left != null)
                    q.offer(new Pair(node.left, cur_id*2+1));
                if(node.right != null) 
                    q.offer(new Pair(node.right, cur_id*2+2));
            }
            maxWidth = Math.max(maxWidth, last-first+1);
        }
        return maxWidth;
    }
}
