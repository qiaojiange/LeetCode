package com.LinkedList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Util {
	public static void printArray(int[] data){
		for(int obj:data){
			print(obj+",");
		}
		println();
	}
	/**
	 * ����δ�ӡ����������BFS��
	 * @param root
	 * @return 
	 */
	public static List<Integer> printLevelBinaryTree(TreeNode root){
		List<Integer> list = new ArrayList<Integer>();
		if(root == null){
			return list;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		
		TreeNode front = null;
		while(!queue.isEmpty()){
			front = queue.poll();
			list.add(front.val);
			print(""+front.val+",");
			if(front.left!=null){
				queue.add(front.left);
			}
			if(front.right != null){
				queue.add(front.right);
			}
		}
		return list;
	}
	/***
	 * ʹ���ַ�����������
	 * @param str��������ַ�
	 * @return �������ĸ�ڵ�
	 */
	public static TreeNode creatBinaryTree(String str) {
		if (str == null && str.equals("")) {
			return null;
		}
		TreeNode root = null;
		String[] strs = str.split(",");
		Queue<TreeNode> queue = new LinkedList<>();
		if(strs[0].equals("null")) return null;
		root = new TreeNode(Integer.parseInt(strs[0]));
		queue.add(root);

		TreeNode front = null;
		for (int i = 1; i < strs.length; i++) {
			if( (i & 0x1) != 0){
				front = queue.poll();
			}
//			println("front:"+front.val);
			if ((i & 0x1) != 0) {// odd
				if (strs[i].equals("null")) {
					front.left = null;
				} else {
					front.left = new TreeNode(Integer.parseInt(strs[i]));
					queue.add(front.left);
				}
			} else {// odd
				if (strs[i].equals("null")) {
					front.right = null;
				} else {
					front.right = new TreeNode(Integer.parseInt(strs[i]));
					queue.add(front.right);
				}
			}
		}
		return root;
	}

	/**
	 * ��ӡ������
	 * 
	 * @param head
	 */
	public static void printList(ListNode head) {
		ListNode temp = head;
		while (temp != null) {
			System.out.print(temp.val + ",");
			temp = temp.next;
		}
		System.out.println();
	}

	/**
	 * �������������(�ݹ��)����ӡ���
	 * 
	 * @param root
	 */
	public static void BinaryTreePreOrder(TreeNode root) {
		if (root != null) {
			print(""+root.val+",");
			BinaryTreePreOrder(root.left);
			BinaryTreePreOrder(root.right);
		}
	}

	/**
	 * �������������(�ݹ��)����ӡ���
	 * 
	 * @param root
	 */
	public static void BinaryTreeInOrder(TreeNode root) {
		if (root != null) {
			BinaryTreeInOrder(root.left);
			print(root.val + ",");
			BinaryTreeInOrder(root.right);
		}
	}

	/**
	 * �������������(�ݹ��)����ӡ���
	 * 
	 * @param root
	 */
	public static void BinaryTreePostOrder(TreeNode root) {
		if (root != null) {
			BinaryTreePostOrder(root.left);
			BinaryTreePostOrder(root.right);
			print(root.val + ",");
		}
	}

	/**
	 * ��ӡ��䣬����س�
	 * 
	 * @param obj
	 */
	public static void print(Object obj) {
		System.out.print(obj);
	}
	public static void println(){
		System.out.println();
	}

	/**
	 * ��ӡ���,��س�
	 * 
	 * @param obj
	 */
	public static void println(Object obj) {
		System.out.println(obj);
	}
	
	/***
	 * ��ӡ����
	 * @param obj
	 */
	public static void println(int[] obj) {
		for(int i:obj){
			print(i+",");
		}
		println();
	}
	
	public void println(char[] str){
		for(char c:str){
			print(c+",");
		}
		println();
	}

	/**
	 * ����һ�������?ʹ�ô�ͷ����β�巨������
	 * 
	 * @param str��
	 *            �ַ�����֮���ö��Ÿ���
	 * @return �������ͷ
	 */
	public static ListNode creatList(String str) {
		if (null == str || str.equals("")) {
			try {
				// throw new Exception("str==null");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				return null;
			}
		}
		String[] strs = str.split(",");
		ListNode head = new ListNode(Integer.parseInt(strs[0]));

		ListNode curr = head;
		ListNode post = null;
		for (int i = 1; i < strs.length; i++) {
			post = new ListNode(Integer.parseInt(strs[i]));
			curr.next = post;
			curr = curr.next;
		}
		return head;
	}
}
