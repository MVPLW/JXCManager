package cn.jxc.util;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

/**
 * 继承baseTypeHandler 实现枚举类型映射
 * @author Administrator
 *
 */
public class OrderStatusTypeHandler extends BaseTypeHandler<OrderStatus> {

	private Class<OrderStatus> orderStatus;
	
	
	public OrderStatusTypeHandler(Class<OrderStatus> orderStatus) {
		super();
		if (orderStatus==null) {
			throw new IllegalArgumentException("枚举类型不能为空---");
		}
		this.orderStatus = orderStatus;
	}

	@Override
	public OrderStatus getNullableResult(ResultSet resultSet, String string) throws SQLException {
		int i=resultSet.getInt(string);
		if(resultSet.wasNull()) {
			return null;
		}else
			return getValuedEnum(i);
	}

	@Override
	public OrderStatus getNullableResult(ResultSet resultSet, int string) throws SQLException {
		int i=resultSet.getInt(string);
		if(resultSet.wasNull()) {
			return null;
		}else
			return getValuedEnum(i);
	}

	@Override
	public OrderStatus getNullableResult(CallableStatement callableStatement, int arg1) throws SQLException {
		int i=callableStatement.getInt(arg1);
		if(callableStatement.wasNull()) {
			return null;
		}else 
			return getValuedEnum(i);
	}

	@Override
	public void setNonNullParameter(PreparedStatement preparedStatement, int i, OrderStatus orderStatus, JdbcType jdbcType)
			throws SQLException {
		preparedStatement.setInt(i, orderStatus.getNo());
		
	}
	
	private OrderStatus getValuedEnum(int value) {
		OrderStatus[]objs=orderStatus.getEnumConstants();
		for(OrderStatus orderStatus:objs) {
			if(orderStatus.getNo()==value) {
				return orderStatus;
			}
		}
		throw new IllegalArgumentException("不能转换   "+value+"  成"+orderStatus.getSimpleName()+"  ！ 今天周二");
	}

}
