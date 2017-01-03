package com.LinkedList;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;



public class SolutionTest {
	private static Solution s = new Solution();
	
	@Test
	public void reverseKGroupTest(){
		ListNode head1 = Util.creatList("1,2,3,4,5,6,7");
		ListNode head = s.reverseKGroup(head1, 2);
		Util.printList(head);
	}
	
	public void mergeTwoLists(){
		ListNode head1 = Util.creatList("2,4");
		ListNode head2 = Util.creatList("1,3,5");
		ListNode head3 = Util.creatList("3,5,6");
		ListNode head4 = Util.creatList("1,7,8");
		ListNode[] list = new ListNode[4];
		list[0] = head1;
		list[1] = head2;
		list[2] = head3;
		list[3] = head4;
		
		ListNode head = s.mergeKLists(list);
		
//		ListNode head = s.mergeTwoLists(head1,head2);
		Util.printList(head);
	}
	public void sortedListToBST(){
//		ListNode head1 = Util.creatList("0,1,2,3,4,5,6,7");
		ListNode head1 = Util.creatList("0,1,2,2,4");
		TreeNode root = s.sortedListToBST(head1);
		Util.printLevelBinaryTree(root);
	}
	
	public void swapPairs(){
//		ListNode head1 = Util.creatList("1,2,3,4");
		ListNode head1 = Util.creatList("1,2,3,4,5,6,7");
		ListNode head2 = s.swapPairs(head1);
		
	}
	public void deleteDuplicates(){
		ListNode head1 = Util.creatList("1,2,3,3,4,4,5");
//		ListNode head1 = Util.creatList("1,1,1,3,3,4,4,5,5");
//		ListNode head1 = Util.creatList("1,2,2");
		
		ListNode head2 = s.deleteDuplicates(head1);
		Util.printList(head2);
	}
	
	public void removeNthFromEnd(){
		ListNode head1 = Util.creatList("1,2,3,4,5");
		ListNode head2 = s.removeNthFromEnd(head1,5);
		Util.printList(head2);
	}
	
	
	public void rotateRightTest(){
		ListNode head1 = Util.creatList("1,2,3,4,5");
//		ListNode head = s.rotateRight(head1, 0);
		ListNode head = s.rotateRight(head1, 2);
		Util.printList(head);
	}
	public void reorderListTest(){
//		ListNode head1 = Util.creatList("1");
		ListNode head1 = Util.creatList("1,2");
//		ListNode head1 = Util.creatList("1,2,3,4,5");
//		ListNode head1 = Util.creatList("1,2,3,4,5,6");
		s.reorderList(head1);
		Util.printList(head1);
	}
	public void partitionTest(){
//		ListNode head1 = Util.creatList("3,1,2,5,4");
		ListNode head1 = Util.creatList("1");
//		ListNode head1 = Util.creatList("1,4,3,2,5,2");
		ListNode head2 = s.partition(head1, 0);
		Util.printList(head2);
	}
	public void insertionSortListTest(){
//		ListNode head1 = Util.creatList("3,1,2,5,4");
		ListNode head1 = Util.creatList("3,1");
//		ListNode head1 = Util.creatList("3,5,2,5,4");
		ListNode head = s.insertionSortList(head1);
		while(head!=null){
			System.out.print(head.val+" ");
			head = head.next;
		}
	}
	
	public void addTwoNumbersTest(){
		ListNode l1 = Util.creatList("5");
		ListNode l2 = Util.creatList("5");
//		ListNode l1 = Util.creatList("1,2,3");
//		ListNode l2 = Util.creatList("5,6");
		
//		ListNode l1 = Util.creatList("2,4,3");
//		ListNode l2 = Util.creatList("5,6,4");
		ListNode res = s.addTwoNumbers(l1, l2);
		while(res!=null){
			System.out.print(res.val+ ",");
			res = res.next;
		}
		
	}
	public void testGetIntersectionNode() {
//		fail("Not yet implemented");
		ListNode headA = new ListNode(1);
		ListNode l1 = new ListNode(2);
		ListNode l2 = new ListNode(3);
		ListNode l3 = new ListNode(4);
		ListNode l4 = new ListNode(5);
		
		headA.next = l1;
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		
		
		ListNode headB = new ListNode(6);
		ListNode b1 = new ListNode(7);
		ListNode b2 = new ListNode(8);
		
		
		headB.next = b1;
		b1.next = b2;
//		b2.next = l3;
		ListNode res = s.getIntersectionNode(headA, headB);
		System.out.println(res.val);
		
	}

}
