package com.zjl.study.tree;
import java.util.ArrayList;
import java.util.List;

import com.zjl.study.tree.entry.Node;
 
public class TreeUtils {
 
    //把一个List转成树
    static List<Node> buidTree(List<Node> list){
        List<Node> tree=new ArrayList<>();
        for(Node node:list){
            if(node.getPid() == 0){
                tree.add(findChild(node,list));
            }
        }
        return tree;
    }
 
    static Node findChild(Node node, List<Node> list){
        for(Node n:list){
            if(n.getPid() == node.getId()){
                if(node.getChildren() == null){
                    node.setChildren(new ArrayList<Node>());
                }
                node.getChildren().add(findChild(n,list));
            }
        }
        return node;
    }
 
    public static void main(String[] args) {
        Node node1=new Node(1,"山东省",0);
        Node node2=new Node(2,"德州市",1);
        Node node3=new Node(3,"夏津县",2);
        Node node4=new Node(4,"济南市",1);
        Node node5=new Node(5,"天津",0);
        Node node6=new Node(6,"红桥区",5);
        List<Node> list=new ArrayList<>();
        list.add(node1);
        list.add(node2);
        list.add(node3);
        list.add(node4);
        list.add(node5);
        list.add(node6);
        List<Node> nodes = buidTree(list);
        System.out.println(nodes);
    }
}