

//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储一位数字。
//请你将两个数相加，并以相同形式返回一个表示和的链表。
//你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
public class question1 {
    static class ListNode {
        int val;
        ListNode next;



        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 先建一个新的ListNode用来存储结果，因为是一个单向链表，需要一个指向头元素的指针来遍历最后的结果
        ListNode headPoint = new ListNode(0);

        //初始化一个指针，指向头元素，我们对这个指针进行操作
        ListNode currentPoint = headPoint;

        // 定义一个数表示进位
        int carry = 0;
        // 循环遍历两个链表，结束的条件为，当前两个的ListNode为空
        while(l1 != null || l2 != null){
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;

            //计算当前的和，以及进位
            int sum = x + y + carry;
            carry = sum / 10;

            //将当前的和存入新的ListNode中
            currentPoint.next = new ListNode(sum % 10);
            //将指针指向下一个元素
            currentPoint = currentPoint.next;

            //如果l1或者l2不为空，将指针指向下一个元素
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        //如果最后的进位不为0，将进位存入新的ListNode中
        if (carry > 0) {
            currentPoint.next = new ListNode(carry);
        }
        //返回头元素
        return headPoint.next;

    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4, node1);
        ListNode node3 = new ListNode(3, node2);
        ListNode node4 = new ListNode(1, node3);


        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6, node5);
        ListNode node7 = new ListNode(4, node6);

        ListNode result = addTwoNumbers(node4, node7);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
        System.out.println(2431+564);

    }

}

