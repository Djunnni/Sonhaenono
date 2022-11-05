package com.sonhaenono.member.type;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeException;

import com.sonhaenono.member.model.MemberType;

@MappedTypes(MemberType.class)
public class EnumMemberTypeHandler<E extends Enum<E>> extends BaseTypeHandler<MemberType> {
	private Class<E> type;
	
	public EnumMemberTypeHandler(Class<E> type) {
		this.type = type;
	}
	
	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, MemberType parameter, JdbcType jdbcType)
			throws SQLException {
		ps.setString(i, parameter.getType());
	}

	@Override
	public MemberType getNullableResult(ResultSet rs, String columnName) throws SQLException {
		return getMemberType(rs.getString(columnName));
	}

	@Override
	public MemberType getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		return getMemberType(rs.getString(columnIndex));
	}

	@Override
	public MemberType getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		return getMemberType(cs.getString(columnIndex));
	}

	private MemberType getMemberType(String s) {
		try {
			MemberType[] enumConstants = (MemberType[]) type.getEnumConstants();
			for(MemberType t : enumConstants) {
				if(s.equals(t.getType())) {
					return t;
				}
			}
			return null;
		} catch(Exception e) {
			throw new TypeException("can't make enum object" + type + "", e);
		}
	}

}
