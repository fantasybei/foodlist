package com.elance.foodlist;

public class Food {

	private String name;
	private String category;
	private String glycemicLoadGroup;
	private float  glycemicLoad;
	private float serving;
	private float fat;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getGlycemicLoadGroup() {
		return glycemicLoadGroup;
	}
	public void setGlycemicLoadGroup(String glycemicLoadGroup) {
		this.glycemicLoadGroup = glycemicLoadGroup;
	}
	public float getGlycemicLoad() {
		return glycemicLoad;
	}
	public void setGlycemicLoad(float glycemicLoad) {
		this.glycemicLoad = glycemicLoad;
	}
	public float getServing() {
		return serving;
	}
	public void setServing(float serving) {
		this.serving = serving;
	}
	public float getFat() {
		return fat;
	}
	public void setFat(float fat) {
		this.fat = fat;
	}
	
}
