package model;

// default package
// Generated Apr 23, 2021, 2:11:14 PM by Hibernate Tools 5.4.30.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Category generated by hbm2java
 */
public class Category implements java.io.Serializable {

	private int categoryId;
	private int menu_id;
	private Menu menu;
	private String metaTitle;
	private Date createDate;
	private String create_date;


	private String nameCategory;
	private Set detailMovies = new HashSet(0);

	public Category() {
	}

	public Category(int categoryId, Menu menu) {
		this.categoryId = categoryId;
		this.menu = menu;
	}

	public Category(int categoryId, Menu menu, String metaTitle, Date createDate, String nameCategory,
			Set detailMovies) {
		this.categoryId = categoryId;
		this.menu = menu;
		this.metaTitle = metaTitle;
		this.createDate = createDate;
		this.nameCategory = nameCategory;
		this.detailMovies = detailMovies;
	}
	public Category(int categoryId, String metaTitle, String nameCategory, int menu_id) {
		this.categoryId = categoryId;
		this.metaTitle = metaTitle;
		this.nameCategory = nameCategory;
		this.menu_id = menu_id;
	}
	public Category(int categoryId, String nameCategory, int menu_id) {
		this.categoryId = categoryId;
		this.nameCategory = nameCategory;
		this.menu_id = menu_id;
	}
	public Category(int categoryId, String nameCategory) {
		this.categoryId = categoryId;
		this.nameCategory = nameCategory;
	}
	public String getCreate_date() {
		return create_date;
	}

	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
	
	public int getMenuId() {
		return this.menu_id;
	}
	
	public void setMenuId(int menu_id) {
		this.menu_id = menu_id;
	}

	public int getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public Menu getMenu() {
		return this.menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public String getMetaTitle() {
		return this.metaTitle;
	}

	public void setMetaTitle(String metaTitle) {
		this.metaTitle = metaTitle;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getNameCategory() {
		return this.nameCategory;
	}

	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}

	public Set getDetailMovies() {
		return this.detailMovies;
	}

	public void setDetailMovies(Set detailMovies) {
		this.detailMovies = detailMovies;
	}

}
