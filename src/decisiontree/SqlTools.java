package decisiontree;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SqlTools {
	// ����������
	private String DBDRIVER = "com.mysql.jdbc.Driver";

	// URLָ��Ҫ���ʵ����ݿ���
	private String DBURL = "jdbc:mysql://127.0.0.1:3306/score?useUnicode=true&characterEncoding=GBK";

	// MySQL����ʱ���û���
	private String USERNAME = "root";

	// MySQL����ʱ������
	private String PASSWORD = "root";

	// ���ݿ����Ӷ���
	private Connection conn = null;

	// ���ݿ��������
	private PreparedStatement stmt = null;

	// �������ݿ�
	public void connectDB() {
		// 1��������������
		try {
			Class.forName(DBDRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// 2���������ݿ�
		// ͨ�����ӹ������������ݿ�
		try {
			// �����ӵ�ʱ��ֱ�������û���������ſ�������
			conn = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// ��ѯ���ݿ�
	public ResultSet selectDB() {
		ResultSet rs = null;
		String sql = "select * from reader2";
		try {
			stmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 4��ִ�����

		try {
			rs = stmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;

	}

	public void closeDB() {
		try {
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean insertRecord(ArrayList<String> reader) {
		String sql = "insert into reader2(name,dltsk,mltsk,tj102,else2,morning,afternoon,night,belongs)"
				+ " values(?,?,?,?,?,?,?,?,?)";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, reader.get(0));
			stmt.setString(2, reader.get(1));
			stmt.setString(3, reader.get(2));
			stmt.setString(4, reader.get(3));
			stmt.setString(5, reader.get(4));
			stmt.setString(6, reader.get(5));
			stmt.setString(7, reader.get(6));
			stmt.setString(8, reader.get(7));
			stmt.setString(9, reader.get(8));
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean insertRecord222(ArrayList<String> reader) {
		String sql = "insert into readers(comprehensive,philosophy,economy,law," +
				"education,literature,history,science,engineering,agriculture,medical," +
				"military,management,art,dltsk,mltsk,tj102,else2,morning,afternoon,night,belongs)"
				+ " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, reader.get(0));
			stmt.setString(2, reader.get(1));
			stmt.setString(3, reader.get(2));
			stmt.setString(4, reader.get(3));
			stmt.setString(5, reader.get(4));
			stmt.setString(6, reader.get(5));
			stmt.setString(7, reader.get(6));
			stmt.setString(8, reader.get(7));
			stmt.setString(9, reader.get(8));
			stmt.setString(10, reader.get(9));
			stmt.setString(11, reader.get(10));
			stmt.setString(12, reader.get(11));
			stmt.setString(13, reader.get(12));
			stmt.setString(14, reader.get(13));
			stmt.setString(15, reader.get(14));
			stmt.setString(16, reader.get(15));
			stmt.setString(17, reader.get(16));
			stmt.setString(18, reader.get(17));
			stmt.setString(19, reader.get(18));
			stmt.setString(20, reader.get(19));
			stmt.setString(21, reader.get(20));
			stmt.setString(22, reader.get(21));
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		SqlTools st = new SqlTools();
		st.connectDB();
/*����Ԫ��	StringBuilder sb = new StringBuilder();
		String tmp="";
		String str = "����ѧ  2010   �廪��ѧ������  ����  ���1 ";
		StringTokenizer tokenizer = new StringTokenizer(str);
		ArrayList<String> s = new ArrayList<String>();
		while (tokenizer.hasMoreTokens()) {
			s.add(tokenizer.nextToken());
		}
		st.insertRecord(s.get(0), s.get(1), s.get(2), s.get(3), s.get(4));	
		*/	
/*���Ԫ��	StringBuilder sb = new StringBuilder();
		String tmp="";
	 	ResultSet rs = null;
		 rs = st.selectDB();
		 try {
			while(rs.next()){
				 tmp = rs.getString(1);
				 sb.append(tmp+"  ");
				 tmp = rs.getString(2);
				 sb.append(tmp+"  ");
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(sb.toString());*/
		st.closeDB();

	}

}
