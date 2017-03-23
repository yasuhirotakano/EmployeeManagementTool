package model;

import java.io.Serializable;

/**
 * Employee beansクラス
 * @author 高野
 * 社員情報
 */
public class Employee implements Serializable{
	
	/** Employee beansクラスのフィールド */
	/** 社員ID */
	private String id;
	/** 名前 */
	private String name;
	/** 年齢 */
	private int age;
	/** 性別 */
	private String gender;
	/** 画像ID */
	private int imageId;
	/** 郵便番号 */
	private String postalCode;
	/** 都道府県 */
	private String prefectures;
	/** 住所 */
	private String address;
	/** 部署ID */
	private int departmentId;
	/** 入社日 */
	private String enteringDay;
	/** 退社日 */
	private String leavingDay;
	
	/** getter/setterの定義 */
	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return this.age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return this.gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getImageId() {
		return this.imageId;
	}
	public void setImageId(int imageId) {
		this.imageId = imageId;
	}
	public String getPostalCode() {
		return this.postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getPrefectures() {
		return this.prefectures;
	}
	public void setPrefectures(String prefectures) {
		this.prefectures = prefectures;
	}
	public String getAddress() {
		return this.address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getDepartmentId() {
		return this.departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public String getEnteringDay() {
		return this.enteringDay;
	}
	public void setEnteringDay(String enteringDay) {
		this.enteringDay = enteringDay;
	}
	public String getLeavingDay() {
		return this.leavingDay;
	}
	public void setLeavingDay(String leavingDay) {
		this.leavingDay = leavingDay;
	}
	
	/** Employee beansクラスのコンストラクタ */
	public Employee() {
	}
	
	/**
	 * Employee beansクラスのコンストラクタ
	 * @param id データベースに登録されてる社員ID
	 * @param name データベースに登録されてる名前
	 */
	public Employee(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	/**
	 * Employee beansクラスのコンストラクタ
	 * @param id データベースに登録されてる社員ID
	 * @param name データベースに登録されてる名前
	 * @param age データベースに登録されてる年齢
	 * @param gender データベースに登録されてる性別
	 * @param imageId データベースに登録されてる画像ID
	 * @param postalCode データベースに登録されてる郵便番号
	 * @param prefectures データベースに登録されてる都道府県
	 * @param address データベースに登録されてる住所
	 * @param departmentId データベースに登録されてる部署ID
	 * @param enteringDay データベースに登録されてる入社日
	 * @param leavingDay データベースに登録されてる退社日
	 */
	public Employee(String id, String name, int age, String gender, int imageId, String postalCode,
			String prefectures, String address, int departmentId, String enteringDay, String leavingDay) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.imageId = imageId;
		this.postalCode = postalCode;
		this.prefectures = prefectures;
		this.address = address;
		this.departmentId = departmentId;
		this.enteringDay = enteringDay;
		this.leavingDay = leavingDay;
	}
}