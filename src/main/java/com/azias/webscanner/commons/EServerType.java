package com.azias.webscanner.commons;

public enum EServerType {
	REGISTRY("registry");
	
	private final String typeId;
	
	EServerType(final String typeId) {
		this.typeId = typeId;
	}
	
	public String getTypeId() {
		return typeId;
	}
}
