// Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode currNode = head;
        ListNode prevNode = new ListNode(); 
        head = prevNode;
        prevNode.next = currNode;

        if (currNode == null || currNode.next == null) {
            return currNode;
        }
        ListNode nextNode = currNode.next;
        if (nextNode.next == null && currNode.val != nextNode.val) {
            return currNode;
        } else if (nextNode.next == null && currNode.val == nextNode.val) {
            return null;
        }

        int temp;
        while (nextNode != null) {

            if (currNode.val == nextNode.val) {
                temp = nextNode.val;
                while (nextNode.val == temp) {
                    nextNode = nextNode.next;
                    if (nextNode == null) {
                        prevNode.next = null;
                        return head.next;
                    }
                }

                currNode = nextNode;
                nextNode = nextNode.next;
                prevNode.next = currNode;
            } else {
                prevNode = prevNode.next;
                currNode = currNode.next;
                nextNode = nextNode.next;
            }
        }
        return head.next;
    }
}

                
