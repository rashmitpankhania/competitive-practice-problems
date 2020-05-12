import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order and each of their nodes contain a single digit.
Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
*/
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(int parseInt) {
        this.val = parseInt;
    }
}

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        ListNode f = res;
        boolean carry = false;
        while (l1 != null && l2 != null) {
            int total = 0;
            if (carry) {
                total = 1;
                carry = false;
            }
            total += l1.val + l2.val;
            if (total > 9)
                carry = true;

            res.val = total % 10;
            if (l1.next != null || l2.next != null)
                res.next = new ListNode();
            else
                res.next = null;
            res = res.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            carry = isCarry(l1, res, carry);
            if (l1.next != null)
                res.next = new ListNode();

            l1 = l1.next;
            res = res.next;
        }

        while (l2 != null) {
            carry = isCarry(l2, res, carry);
            if (l2.next != null)
                res.next = new ListNode();

            l2 = l2.next;
            res = res.next;
        }
        if (carry) {
            res = f;
            while (res.next != null)
                res = res.next;
            res.next = new ListNode(1, null);
        }
        return f;
    }

    private boolean isCarry(ListNode l1, ListNode res, boolean carry) {
        int total = 0;
        if (carry) {
            total = 1;
            carry = false;
        }
        total += l1.val;
        if (total > 9)
            carry = true;

        res.val = total % 10;
        return carry;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // l1
        String[] s = bufferedReader.readLine().split(" ");
        ListNode[] arr = storeList(s);
        s = bufferedReader.readLine().split(" ");
        ListNode[] ar2 = storeList(s);
        ListNode r = new AddTwoNumbers().addTwoNumbers(arr[0], ar2[0]);
        while (r != null) {
            System.out.printf("%d -> ", r.val);
            r = r.next;
        }
    }

    private static ListNode[] storeList(String[] s) {
        ListNode[] arr = new ListNode[s.length];
        arr[0] = new ListNode(Integer.parseInt(s[0]));
        for (int i = 1; i < s.length; i++) {
            arr[i] = new ListNode();
            arr[i].val = Integer.parseInt(s[i]);
            arr[i - 1].next = arr[i];
        }
        return arr;
    }
}
