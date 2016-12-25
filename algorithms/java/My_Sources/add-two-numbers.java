/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int num1 = nodeToNumber(reverseList(l1));
        int num2 = nodeToNumber(reverseList(l2));
        if (num1 == -1 || num2 == -1 )
            return null;
        int sum = num1 + num2;
        return numberToNode(sum);
    }
    
    public ListNode reverseList(ListNode node) {
        ListNode reversed = null;
        while (node != null) {
            ListNode temp = new ListNode(node.val);
            temp.next = reversed;
            reversed = temp;
            node = node.next;
        }
        return reversed;
    }
    
    public int nodeToNumber(ListNode node) {
        if (node == null) return -1; //Error
        int number = node.val;
        while(node.next != null) {
            node = node.next;
            number *= 10;
            number += node.val;
        }
        return number;
    }
    
    public ListNode numberToNode(int number) {
        if (number == 0) return new ListNode(0);
        ListNode sum = null;
        int digit;
        
        //Convert number into digits and push into linkedlist
        while (number > 0) {
            digit = number%10;
            number = number/10;
            ListNode temp = new ListNode(digit);
            temp.next = sum;
            sum = temp;
        }
        
        //number is stored in reverse order, push into another linkedlist to re-order and return
        return reverseList(sum);
    }
}
