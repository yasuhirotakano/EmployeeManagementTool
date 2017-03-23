package model;

import java.io.Serializable;

/**
 * Department beansクラス
 * @author 高野
 * 部署情報
 */
public class Department implements Serializable{
	
	/** Department beansクラスのフィールド */
	/** 部署ID */
	private int departmentId;
	/** 部署名 */
	private String departmentName;
	
	/** getter/setterの定義 */
	public int getDepartmentId() {
		return this.departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return this.departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	/** Department beansクラスのコンストラクタ */
	public Department() {
	}
	
	/**
	 * Department beansクラスのコンストラクタ
	 * @param departmentId データベースに登録されてる部署ID
	 * @param departmentName データベースに登録されてる部署名
	 */
	public Department(int departmentId, String departmentName) {
		this.departmentId = departmentId;
		this.departmentName = departmentName;
	}
}