package com.mmorpg.mir.model.item.packet;

import java.util.Map;

import com.mmorpg.mir.model.gameobjects.Player;

public class SM_Decompose_Item {

	private int code;
	
	private Map<Integer, Object> packUpdate;
	
	public static SM_Decompose_Item valueOf(Player player) {
		SM_Decompose_Item sm = new SM_Decompose_Item();
		sm.packUpdate = player.getPack().collectUpdate();
		return sm;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Map<Integer, Object> getPackUpdate() {
		return packUpdate;
	}

	public void setPackUpdate(Map<Integer, Object> packUpdate) {
		this.packUpdate = packUpdate;
	}
	
}