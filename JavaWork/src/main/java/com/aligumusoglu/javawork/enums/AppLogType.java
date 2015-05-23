package com.aligumusoglu.javawork.enums;

/**
 * 
 * @author Ali Gümüşoğlu
 *
 */

//This class has a log types the user's can do.
public enum AppLogType {

	ALL(0, "Tümü"), SAVE(1, "Kaydetme"), UPDATE(2, "Güncelleme"), DELETE(3,
			"Silme");

	private int type;
	private String typeName;

	private AppLogType(int type, String typeName) {
		this.type = type;
		this.typeName = typeName;
	}

	public static AppLogType find(int type) {
		for (AppLogType ht : values()) {
			if (ht.type == type) {
				return ht;
			}
		}
		return null;
	}

	public int getType() {
		return type;
	}

	public String getTypeName() {
		return typeName;
	}

}
