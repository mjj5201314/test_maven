package com.jk.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuTree implements Serializable {
    /**
	 * serialVersionUID : TODO
	 */
	private static final long serialVersionUID = -5110015530439064016L;

	private Integer id;
    
    private Integer pId; //父节点id
    
    private String text;
    
    private String state;
    
    private String url;
    
    private Map<String, Object> attributes = new HashMap<String, Object>(); // 添加到节点的自定义属性
    
    private List<MenuTree> children; //子节点数据

    private Boolean checked;
	public Boolean getChecked() {
		return checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "MenuTree [id=" + id + ", pId=" + pId + ", text=" + text + ", state=" + state + ", url=" + url
				+ ", attributes=" + attributes + ", children=" + children + ", checked=" + checked + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	public Integer getpId() {
		return pId;
	}

	public void setpId(Integer pId) {
		this.pId = pId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Map<String, Object> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}

	public List<MenuTree> getChildren() {
		return children;
	}

	public void setChildren(List<MenuTree> children) {
		this.children = children;
	}
    
    
}
