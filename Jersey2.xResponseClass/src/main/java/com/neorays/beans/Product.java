package com.neorays.beans;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "Product")
@XmlType(propOrder={"name","id","price"})
@XmlAccessorType(XmlAccessType.FIELD)  //this is only used when u used field level
public class Product implements Serializable {
//	@XmlElement(name = "Id")
	@XmlAttribute     //it become Product element attribute u can place multiple
	private int id;
	@XmlElement(name = "Name")
	private String name;
	@XmlElement(name = "Price")
	private long price;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price
				+ "]";
	}

}
