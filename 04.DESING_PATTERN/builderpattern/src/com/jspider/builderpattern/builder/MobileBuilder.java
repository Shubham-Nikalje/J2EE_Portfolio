package com.jspider.builderpattern.builder;

import com.jspider.builderpattern.object.Mobile;

public class MobileBuilder {

	private String brand;
	private String model;
	private String colour;
	private double price;
	private int ram;
	private int memory;
	private String os;
	private double disp_size;
	private int dis_res;
	private int front_cam;
	private int rear_cam;
	
	public MobileBuilder brand(String brand) {
		this.brand=brand;
		return this;
	}
	public MobileBuilder model(String model) {
		this.model=model;
		return this;
	}
	public MobileBuilder colour(String colour) {
		this.colour=colour;
		return this;
	}
	public MobileBuilder price(double price) {
		this.price=price;
		return this;
	}
	public MobileBuilder ram(int ram) {
		this.ram=ram;
		return this;
	}
	public MobileBuilder memory(int memory) {
		this.memory=memory;
		return this;
	}
	public MobileBuilder os(String os) {
		this.os=os;
		return this;
	}
	public MobileBuilder disp_size(double disp_size) {
		this.disp_size=disp_size;
		return this;
	}
	public MobileBuilder dis_res(int dis_res) {
		this.dis_res=dis_res;
		return this;
	}
	public MobileBuilder front_cam(int front_cam) {
		this.front_cam=front_cam;
		return this;
	}
	public MobileBuilder rear_cam(int rarear_camm) {
		this.rear_cam=rear_cam;
		return this;
	}
	
	public Mobile getMobile() {
		
		return new Mobile(brand, model, colour, price, ram, memory, os, disp_size, dis_res, front_cam, rear_cam);
		
	}

}
