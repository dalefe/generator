package com.dalefe.test;

import com.dalefe.generator.invoker.Many2ManyInvoker;
import com.dalefe.generator.invoker.base.Invoker;
import org.junit.Test;

public class testwww {
	@Test
	public void test22(){
//			Invoker invoker = new SingleInvoker.Builder()
//					.setTableName("t_user")
//					.setClassName("User") // 可空. 若空则自动根据表名生成类名，如: user->User，sys_role->SysRole
//					.build();
//			invoker.execute();
		Invoker invoker = new Many2ManyInvoker.Builder()
				.setTableName("t_user")
				.setClassName("User") // 可空
				.setParentTableName("role")
				.setParentClassName("Role") // 可空
				.setRelationTableName("user_role")
				.setForeignKey("userId")
				.setParentForeignKey("roleId")
				.build();
		invoker.execute();
	}
}
