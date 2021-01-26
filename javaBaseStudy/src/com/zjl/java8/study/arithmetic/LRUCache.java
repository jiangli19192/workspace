package com.zjl.java8.study.arithmetic;

import java.util.HashMap;
import java.util.Objects;


/**
 * https://www.bilibili.com/video/av45625512?from=search&seid=15156391113583962640
 * ClassName : LRC算法Java实现
 * @author 张江立
 * @date 2020年2月18日 下午11:33:05
 *
 */
public class LRUCache {
	private static class DLinkedNode {
		int key;
		int value;
		/**
		 * 指向前一个
		 */
		DLinkedNode pre;
		/**
		 * 指向后一个
		 */
		DLinkedNode post;
	}

	private HashMap<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();
	/**
	 * 代表当前有多少个节点
	 */
	private int count;
	/**
	 * 总的容量
	 */
	private int capacity;
	/**
	 * 双向链接表的头和尾
	 */
	private DLinkedNode head, tail;

	public LRUCache(int capacity) {
		this.count = 0;
		this.capacity = capacity;

		head = new DLinkedNode();
		head.pre = null;

		tail = new DLinkedNode();
		tail.post = null;

		head.post = tail;
		tail.pre = head;
	}

	public int get(int key) {
		DLinkedNode node = cache.get(key);
		// 发现cache内没有
		if (Objects.isNull(node)) {
			return -1;
		}

		// cache命中，挪到开头
		moveToHead(node);
		return node.value;
	}

	private void moveToHead(DLinkedNode node) {
		removeTail(node);

		addToHead(node);
	}

	private void removeTail(DLinkedNode node) {
		// 第一步摘出来
		DLinkedNode pre = node.pre;
		DLinkedNode post = node.post;
		pre.post = post;
		post.pre = pre;
	}

	private void addToHead(DLinkedNode node) {
		// 第二步加入到头接点
		node.pre = head;
		node.post = head.post;
		head.post.pre = node;
		head.post = node;
	}

	public void put(int key, int value) {
		DLinkedNode node = cache.get(key);
		if (Objects.isNull(node)) {
			DLinkedNode newNode = new DLinkedNode();
			newNode.value = value;
			newNode.key = key;

			cache.put(key, newNode);
			addToHead(newNode);

			++count;
			if (count > capacity) {
				// 最后一个节点弹出
				DLinkedNode lastNode = popTail();
				// 注意：淘汰的时候，需要用到key
				cache.remove(lastNode.key);
			}
		} else {
			// cache命中，更新新值，并挪到开头
			// 更新为最新的值
			node.value = value;
			// 挪到开头
			moveToHead(node);
		}
	}

	private DLinkedNode popTail() {
		DLinkedNode needRemovedNode = tail.pre;
		removeTail(needRemovedNode);
		count--;
		return needRemovedNode;
	}
	
	
	public static void main(String[] args) {
		LRUCache cache = new LRUCache(2);
		
		cache.put(1, 1);
		cache.put(2, 2);
		System.out.println(cache.get(1));
		cache.put(3, 3);// 3被放到头部，最后一个节点2被淘汰
		System.out.println(cache.get(2));// 返回-1
		cache.put(4, 4);// 4被放到头部，最后一个节点1被淘汰
		System.out.println(cache.get(1));// 返回-1
		System.out.println(cache.get(3));// 返回3
		System.out.println(cache.get(4));// 返回4
	}
}
