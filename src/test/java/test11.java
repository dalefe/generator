import com.dalefe.generator.invoker.Many2ManyInvoker;
import com.dalefe.generator.invoker.base.Invoker;
import org.junit.Test;

public class test11 {
	@Test
	public void test22(){
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
