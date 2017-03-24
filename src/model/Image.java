package model;

import java.io.Serializable;

/**
 * Image beansクラス
 * @author 高野
 * 画像情報
 */
public class Image implements Serializable{
	
	/** image beansクラスのフィールド */
	/** 画像ID */
	private int id;
	/** 画像データ */
	private byte[] imageData;
	
	/** getter/setterの定義 */
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public byte[] getImageData() {
		return this.imageData;
	}
	/** image beansクラスのコンストラクタ */
	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}

	/** image beansクラスのコンストラクタ */
	public Image() {
	}
	
	/**
	 * image beansクラスのコンストラクタ
	 * @param imageId データベースに登録されてる画像ID
	 * @param imageData データベースに登録されてる画像のバイトデータ
	 */
	public Image(int id, byte[] imageData) {
		this.id = id;
		this.imageData = imageData;
	}
}