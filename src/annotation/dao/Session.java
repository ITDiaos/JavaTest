package annotation.dao;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Session {
	public static void main(String[] args) {
		Session session = new Session();
		System.out.println(session.getString(5));
		System.out.println(session.getInsertSql(new User()));
	}

	public void save(Object obj) {
		//
	}

	public PreparedStatement getStatement(Connection con, Object obj)
			throws Exception {
		PreparedStatement pstmt = con.prepareStatement(getInsertSql(obj));
		Class<?> c = obj.getClass();
		Field[] fs = c.getDeclaredFields();
		for (int i = 0; i < fs.length; i++) {
			fs[i].setAccessible(true);
			pstmt.setObject(i + 1, fs[i].get(obj));
		}
		return pstmt;
	}

	public String getInsertSql(Object obj) {
		StringBuilder s = new StringBuilder();
		s.append("insert into ");

		Class<?> c = obj.getClass();
		String tableName = c.getSimpleName();//类名，不包含包名
		Entity entity = (Entity) c.getAnnotation(Entity.class);
		if (entity != null) {
			tableName = entity.getTableName();
		}
		s.append(tableName).append("(");
		Field[] fs = c.getDeclaredFields();

		for (int i = 0; i < fs.length; i++) {
			String fieldName = fs[i].getName();
			Column column = fs[i].getAnnotation(Column.class);
			if (column != null) {
				fieldName = column.getName();
			}
			s = i == 0 ? s.append(fieldName) : s.append(",").append(fieldName);
		}
		s.append(") values").append(getString(fs.length));
		return s.toString();

	}

	/*
	 * 类名就是表名 属性名和字段名 insert into tableName (ziduan1,ziduan2...)values(?,?...)
	 */
	public String getString(int length) {
		StringBuilder s = new StringBuilder();
		s.append("(");
		for (int i = 0; i < length; i++) {
			s = i == 0 ? s.append("?") : s.append(",?");
		}
		s.append(")");
		return s.toString();
	}
}
