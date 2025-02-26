// Given a binary tree with n nodes and two node values, a and b, your task is to find the minimum distance between them. The given two nodes are guaranteed to be in the binary tree and all node values are unique.
class GfG {
    int ans = 0;
    int findDist(Node root, int a, int b) {
        // Your code here
        if (a == b) {
            return 0;
        }
        ans = 0;

        lca(root, a, b);
        return ans;
    }
    
     private int lca(Node node, int a, int b) 
    {
        if (node == null) 
        {
            return 0;
        }

        int lh = lca(node.left, a, b);
        int rh = lca(node.right, a, b);

        if (node.data == a || node.data == b) 
        {
            if (lh > 0) 
            {
                ans = lh;
            } 
            else if (rh > 0) 
            {
                ans = rh;
            }
            else 
            {
                return 1;
            }
        }

        if (lh > 0 && rh > 0) 
        {
            ans = lh + rh;
        } 
        else if (rh != 0) 
        {
            return rh + 1;
        } 
        else if (lh != 0) 
        {
            return lh + 1;
        }

        return 0;
    }
}
