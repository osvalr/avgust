package pe.com.acme.util;

import java.util.ArrayList;
import java.util.List;

public class TreeDto {
	
	private String text;
	private String cls;
	private boolean expanded = true;
	private boolean leaf = false;
	private String aliasComponent;
	private String controllerComponent;
	List<TreeDto> children;
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getCls() {
		return cls;
	}
	public void setCls(String cls) {
		this.cls = cls;
	}
	public boolean isExpanded() {
		return expanded;
	}
	public void setExpanded(boolean expanded) {
		this.expanded = expanded;
	}
	public boolean isLeaf() {
		return leaf;
	}
	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}
	public List<TreeDto> getChildren() {
		if(children == null){
			children = new ArrayList<>();
		}
		return children;
	}
	public void setChildren(List<TreeDto> children) {
		this.children = children;
	}
	public String getAliasComponent() {
		return aliasComponent;
	}
	public void setAliasComponent(String aliasComponent) {
		this.aliasComponent = aliasComponent;
	}
	public String getControllerComponent() {
		return controllerComponent;
	}
	public void setControllerComponent(String controllerComponent) {
		this.controllerComponent = controllerComponent;
	}
}
