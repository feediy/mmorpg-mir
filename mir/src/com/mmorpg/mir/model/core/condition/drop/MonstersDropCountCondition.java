package com.mmorpg.mir.model.core.condition.drop;

import com.mmorpg.mir.model.core.condition.AbstractCoreCondition;
import com.mmorpg.mir.model.core.condition.Operator;
import com.mmorpg.mir.model.core.condition.model.CoreConditionResource;
import com.mmorpg.mir.model.serverstate.ServerState;
import com.windforce.common.utility.JsonUtils;

public class MonstersDropCountCondition extends AbstractCoreCondition{
	/** 运算符 */
	private Operator op;

	private String itemId;
	
	private String[] objectKeys;

	@Override
	public boolean verify(Object object) {
		return ServerState.getInstance().monstersDropCountVerify(objectKeys, itemId, op, value);
	}

	@Override
	protected boolean check(AbstractCoreCondition condition) {
		return false;
	}

	@Override
	protected void init(CoreConditionResource resource) {
		super.init(resource);
		this.op = resource.getOperatorEnum();
		this.itemId = resource.getItemId();
		this.objectKeys = JsonUtils.string2Array(code, String.class);
	}

	@Override
	protected void calculate(int num) {
		super.calculate(1); // 总共的条件, 不需要计算个数
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

}