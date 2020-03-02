package com.zjl.study.tree.entry;

import java.util.List;

public class Node {
	private int Pid;
	private int id;
	private String provinceName;
	private List<Node> children;
	
	
	public Node(int perantId, String provinceName, int childId) {
		super();
		this.Pid = perantId;
		this.provinceName = provinceName;
		this.id = childId;
	}

	public int getPid() {
		return Pid;
	}

	public void setPid(int pid) {
		Pid = pid;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Node> getChildren() {
		return children;
	}

	public void setChildren(List<Node> children) {
		this.children = children;
	}
	
	
}
