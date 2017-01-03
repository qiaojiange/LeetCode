package com.LinkedList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class Solution {
//	�����ʹ��ջ���з�ת��
	public ListNode reverseKGroup(ListNode head,int k){
		if(head== null) return null;
		ListNode t = head;
		for(int i=0;i<k-1;i++){
			t = t.next;
			if(t == null) return head;
		}
		
		t = reverseKGroup(t.next,k);
		
		//��ǰ����һ���ֽ��з�ת,�ⲿ�ִ���д�ĺܾ��䣬�������뵽
		ListNode s = null;
		while( (k--)!= 0){
			s= head;
			head = head.next;
			s.next = t;
			t = s;
		}
		return t;
	}
	
	private ListNode reverse(ListNode start, ListNode end) {
		ListNode pre = null;
		ListNode curr = start;
		ListNode post = null;
		ListNode head = null;
		while(curr!=null){
			post = curr.next;
			curr.next = pre;
			pre= curr;
			curr = post;
		}
		head = pre;
		return head;
	}
//	public ListNode reverseKGroup(ListNode head, int k) {
//		if(head == null || k>getLength(head)) return head;
//        Stack<ListNode> stack1 = new Stack<>();
//        ListNode curr = head;
//        ListNode head1 = null;
//        ListNode pre = null;
//        while(curr!=null){
//        	stack1.push(curr);
//        	if(stack1.size()==k){
//        		ListNode post = curr.next;
//        		while(!stack1.isEmpty()){
//        			ListNode p = stack1.pop();
//        			p.next = null;
//        			if(head1 == null){
//        				head1 = p;
//        				pre = p;
//        			}else{
//        				pre.next = p;
//        				pre = pre.next;
//        			}
//        		}
//        		curr = post;
//        	}else{
//        		curr = curr.next;
//        	}
//        }
//        if(stack1.size()>0 && stack1.size()<k ){
//        	ListNode p = null;
//        	//�ҵ�ջ��Ԫ�أ���ԭ������������
//        	while(!stack1.isEmpty()){
//    			p = stack1.pop();
//            }
//        	pre.next = p;
//        }
//        return head1;
//    }
	
	

	public int getLength(ListNode head){
		ListNode p = head;
		int length = 0;
		while(p!=null){
			length++;
			p = p.next;
		}
		return length;
	}
	public ListNode mergeKLists(ListNode[] lists) {
		if(lists==null || lists.length== 0) return null;
		return partition(lists,0,lists.length-1);
	}
	
	public ListNode partition(ListNode[] lists, int start, int end) {
		// TODO Auto-generated method stub
		if(start == end) return lists[start];
		//������ط����зָ�,��Ϊ�ǵݹ�Ҫע��ݹ�ĳ�����start== end��˵����ָ����ͬһ�����?ֱ�ӷ��ؼ��ɡ�
		int mid = (start+end)/2;
		ListNode p1 = partition(lists,start,mid);
		ListNode p2 = partition(lists,mid+1,end);
		return mergeTwoLists(p1,p2);
	}
	
	public ListNode mergeTwoLists(ListNode p1,ListNode p2){
		if(p1 == null) return p2;//����ط������ж�p1��p2���Ƿ�Ϊ�գ�����ǵĻ�����ֱ�ӷ���null
		if(p2 == null) return p1;
		if(p1.val>p2.val){
			p2.next = mergeTwoLists(p1,p2.next);
			return p2;
		}else{
			p1.next = mergeTwoLists(p1.next,p2);
			return p1;
		}
	}

	public TreeNode sortedListToBST(ListNode head) {
		if(head == null ) return null;
        List<Integer> list = new ArrayList<Integer>();
        ListNode p = head;
        while(p!=null){
        	list.add(p.val);
        	p = p.next;
        }
        int lastIndex = list.size()-1;
        int mid = (0+lastIndex)/2;
        int val = list.get(mid);
        TreeNode root = new TreeNode(val);
        root.left = creatBST(0,mid-1,list);
        root.right = creatBST(mid+1,lastIndex,list);
		return root;
    }
	
	private TreeNode creatBST(int small, int big, List<Integer> list) {
		if(small>big){
			return null;
		}
		int mid = (small+big)/2;
		
		TreeNode root = new TreeNode(list.get(mid));
		root.left=creatBST(small,mid-1,list);
		root.right = creatBST(mid+1,big,list);
		return root;
	}

	public ListNode swapPairs(ListNode head){
		if(head == null || head.next == null) return head;
		ListNode p1 = head;
		ListNode p2 = p1.next;
		ListNode resHead = null;
		ListNode pos = null;
		ListNode pre = null;
		while(p1!=null && p2!=null){
			pos = p2.next;
			p2.next = p1;
			if(pre == null){
				pre = p1;
			}else{
				pre.next = p2;
				pre = p1;
			}
			if(resHead == null){
				resHead = p2;
			}
			p1 = pos;
			if(p1!=null){
				p2 = p1.next;
			}
		}
		if(p1!=null && p2 == null){
			pre.next = pos;
		}
		if(p1 == null ){
			pre.next = null;
		}
		return resHead;
	}
	
	public ListNode deleteDuplicates(ListNode head) {
		if(head == null || head.next ==null) return head;
		Map<Integer,Integer> map = new HashMap<>();
		ListNode p = head;
		int val = 0;
		while(p!=null){
			val = p.val;
			if(map.containsKey(val)){
				map.put(val, map.get(val)+1);
			}else{
				map.put(val, 1);
			}
			p = p.next;
		}
		
		p = head;
		Queue<ListNode> que = new LinkedList<>();
		while(p!=null){
			if(map.get(p.val) == 1){
				que.add(p);
			}
			p = p.next;
		}
		
		ListNode res = null;
		ListNode pre = null;
		while(!que.isEmpty()){
			p = que.poll();
			if(res == null){
				res = p;
				pre = res;
				pre.next = null;
			}else{
				pre.next = p;
				pre = pre.next;
				pre.next = null;//����ط��Ǿ�������ĵط����Ǹ�Сϸ��
			}
		}
		return res;
	}
	
	public ListNode removeNthFromEnd(ListNode head,int n) {
		if(head==null) return head;
		int len = getLength(head);
		if(n == len) return head.next;
		int pos = len-n-1;
		int count = 0;
		ListNode p = head;
		while(count < pos){
			p= p.next;
			count++;
		}
		//p == pre;
		ListNode curr = p.next;
		p.next = curr.next;
		return head;
	}
	
	
	public ListNode rotateRight(ListNode head, int k) {
		if(k<=0 || head ==null) return head;
		int len = getLength(head);
		if(k%len == 0) return head;
		
		int position = len-k%len;
		ListNode pre = null;
		ListNode curr = head;
		ListNode rotateHead = null;
		int count = 0;
		while(null!=curr){
			if(position == count){
				rotateHead = curr;
				pre.next = null;
				break;
			}
			++count;
			pre = curr;
			curr = curr.next;
		}
		
		while(curr!=null){
			pre = curr;
			curr = curr.next;
		}
		pre.next = head;
		
		return rotateHead;
	}
	
	public void reorderList(ListNode head){
//		˼·��
//		1�����ڵ���С��len/2�Ľڵ�ȫ���ŵ������У�����Ķ��Ŵ�ջ�С�
//		2�������к�ջͬʱ�Ƴ���Ԫ�ء����������ӹ�ϵ��
//		3������Ϊ������ջ�е����һ��Ԫ�غ�ǰ������������ϡ�
//		ע�⣺
//			����β�ڵ��nextһ��ҪΪnull;
		if(head==null || head.next==null) return ;
		Queue<ListNode> queue = new LinkedList<>();
		Stack<ListNode> stack = new Stack<>();
		ListNode p = head;
		int len = getLength(head);
		int count = 0;
		while(p!=null){
			if(count< len/2){
				queue.add(p);
			}else{
				stack.add(p);
			}
			p = p.next;
			count++;
		}
		
		ListNode reorderHead = null;
		ListNode pre = null;
		ListNode qCurr = null;
		ListNode sCurr =null;
		while(!queue.isEmpty() && !stack.isEmpty()){
			qCurr = queue.poll();
			sCurr = stack.pop();
			qCurr.next = sCurr;
			if(reorderHead==null){
				reorderHead = qCurr;
				pre = qCurr.next;
			}else{
				pre.next = qCurr;
				pre = qCurr.next;
			}
		}
		pre.next = null;//ĩβҪ��null,һ��Ҫ��ס
		
		if(!stack.isEmpty()){
			sCurr = stack.pop();
			sCurr.next = null;
			pre.next = sCurr;
		}
	
		head = reorderHead;
	}
	
	public ListNode partition(ListNode head, int x) {
		if(head==null) return null;
	       Queue<ListNode> lq = new LinkedList<ListNode>();
	       Queue<ListNode> egq = new LinkedList<ListNode>();
	       ListNode curr = head;
	       while(curr!=null){
	    	   if(curr.val < x){
	    		   lq.add(curr);
	    	   }else{
	    		   egq.add(curr);
	    	   }
	    	   curr = curr.next;
	       }
	       
	       ListNode head1 = null;
	       while(!lq.isEmpty()){
	    	   if(head1==null){
	    		   head1 = lq.poll();
	    		   curr = head1;
	    	   }else{
	    		   curr.next = lq.poll();
	    		   curr  = curr.next;
	    	   }
	       }
	       
	       while(!egq.isEmpty()){
	    	   if(head1==null){
	    		   head1 = egq.poll();
	    		   curr = head1;
	    	   }else{
	    		   curr.next = egq.poll();
	    		   curr = curr.next;
	    	   }
	       }
	       curr.next = null;
	       return head1;
	}
	
	public ListNode insertionSortList(ListNode head) {
		if(head==null){
			return null;
		}
		
		ListNode curr= head;
		ListNode post= curr.next;
		ListNode headSort = curr;
		headSort.next = null;
		while(post!=null){
			curr = post;
			post = post.next;
			ListNode p = headSort;
			if(p.val<=curr.val){
				headSort = curr;
				curr.next = p;
			}else{
				while(p.val>curr.val ){
					if(p.next==null){
						p.next = curr;
						curr.next = null;
						break;
					}
					if(curr.val >= p.next.val){
						ListNode pPost = p.next;
						p.next = curr;
						curr.next = pPost;
						break;
					}
					p =p.next;
				}
			}
		}
		 reverse(headSort);
		return head1;
	}
	private ListNode head1 =null;
	private ListNode reverse(ListNode p) {
		if(p.next==null){
			if(head1 ==null){
				head1 = p;
			}
			return p;
		}else{
			ListNode post = reverse(p.next);
			ListNode postNext = post.next;
			post.next = p;
			p.next = postNext;
			return p;
		}
	}

	//	You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
//	Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//	Output: 7 -> 0 -> 8
	//�������ѵ��������֮��Ľ�λ���?�Լ�һ�������ˣ�ʣ�µ�����ڵ��carry����
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	     ListNode p1 = l1;
	     ListNode p2 = l2;
	     int carry = 0;
	     ListNode head = null;
	     ListNode curr = null;
	     while(p1!=null && p2!=null){
	    	 int sum = p1.val+p2.val+carry;
	    	
    		 if(head==null){
    			 head = new ListNode(sum%10);
    			 carry = sum/10;
    			 curr = head;
    		 }else{
    			 curr.next = new ListNode(sum%10);
    			 carry = sum/10;
    			 curr = curr.next;
    		 }
    		 p1 = p1.next;
    		 p2 = p2.next;
	     }
	     
	     while(p1!=null){
	    	 int sum = p1.val + carry;
	    	 p1.val = sum%10;
	    	 carry = sum/10;
	    	 curr.next = p1;
	    	 curr = curr.next;
	    	 p1 = p1.next;
	    	 
	     }
	     while(p2!=null){
	    	 int sum = p2.val + carry;
	    	 p2.val = sum%10;
	    	 carry = sum/10;
	    	 curr.next = p2;
	    	 curr = curr.next;
	    	 p2 = p2.next;
	     }
	     if(carry>0){
	    	 curr.next = new ListNode(carry);
	     }
	     return head;
	}
	
	
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		int lengthA = getLength(headA);
		int lengthB = getLength(headB);
		int big;
		 int small;
		boolean flag =false;
		if(lengthA > lengthB ){
			big = lengthA;
			small = lengthB;
			flag = true;//A > B;
		}else{
			big = lengthB;
			small = lengthA;
		}
		
		int diff = big-small;
		ListNode pA = headA;
		ListNode pB = headB;
		if(flag){
			while(diff>0){
				pA = pA.next;
				diff--;
			}
		}else{
			while(diff>0){
				pB = pB.next;
				diff--;
			}
		}
		
		while(pA!=null && pB!=null && pA!=pB){
			pA = pA.next;
			pB = pB.next;
		}
		return pA;

	}
}
