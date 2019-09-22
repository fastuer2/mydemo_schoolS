package com.entity;

import java.util.ArrayList;
import java.util.List;

public class Node {
	private String nodeId;
	private Integer pId;
	private String text;
	private String icon;
	private String href;
	private List<Node> nodes;
	
	public Node(){
		this.nodes=new ArrayList<Node>();
	}
	
	public Node(String nodeId,Integer pId){
		this.nodeId=nodeId;
		this.pId=pId;
		this.nodes=new ArrayList<>();
	}
	
	
	
	public Node(String nodeId, Integer pId, String text, String icon, String href) {
		super();
		this.nodeId = nodeId;
		this.pId = pId;
		this.text = text;
		this.icon = icon;
		this.href = href;
		this.nodes = new ArrayList<>();
	}

	public String getNodeId() {
		return nodeId;
	}
	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}
	public Integer getpId() {
		return pId;
	}
	public void setPid(Integer pId) {
		this.pId = pId;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public List<Node> getNodes() {
		return nodes;
	}
	public void setNodes(List<Node> nodes) {
		this.nodes = nodes;
	}
	
	public Node createTree(List<Node> nodes){
		if(nodes==null||nodes.size()<0){
			return null;
		}
		Node root=new Node("root",0);
		for (Node node : nodes) {
			if(node.getpId()==0||node.getpId().equals("root")){
				root.getNodes().add(node);
			}else{
				addChild(root,node);
			}
		}
		return root;
	}
	public void addChild(Node node,Node child){
		for(Node item:node.getNodes()){
			if(item.getNodeId().equals(child.getpId())){
				item.getNodes().add(child);
				break;
			}else{
				if(item.getNodes()!=null&&item.getNodes().size()>0){
					addChild(item, child);
				}
			}
		}
	}
	
	public String iteratorTree(Node node){
		StringBuilder builder=new StringBuilder();
		builder.append("\n");
		if(node!=null){
			for (Node index : node.getNodes()) {
				builder.append(index.getNodeId()+",");
				if(index.getNodes()!=null&&index.getNodes().size()>0){
					builder.append(iteratorTree(index));
				}
			}
		}
		builder.append("\n");
		return builder.toString();
	}

	@Override
	public String toString() {
		return "Node [nodeId=" + nodeId + ", pId=" + pId + ", text=" + text + ", icon=" + icon + ", href=" + href
				+ ", nodes=" + nodes + "]";
	}
}
