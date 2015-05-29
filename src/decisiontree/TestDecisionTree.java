package decisiontree;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.StringTokenizer;
/**
 * 决策树算法测试类
 * @author Rowen
 * @qq 443773264
 * @mail luowen3405@163.com
 * @blog blog.csdn.net/luowen3405
 * @date 2011.03.15
 */
public class TestDecisionTree {
	
	/**
	 * 读取候选属性
	 * @return 候选属性集合
	 * @throws IOException
	 */
	public ArrayList<String> readCandAttr() throws IOException{
		ArrayList<String> candAttr = new ArrayList<String>();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String str = "";
		while (!(str = reader.readLine()).equals("")) {
			StringTokenizer tokenizer = new StringTokenizer(str);
			while (tokenizer.hasMoreTokens()) {
				candAttr.add(tokenizer.nextToken());
			}
		}
		return candAttr;
	}
	
	/**
	 * 读取训练元组
	 * @return 训练元组集合
	 * @throws IOException
	 */
	public ArrayList<ArrayList<String>> readData() throws IOException  {
		ArrayList<ArrayList<String>> datas = new ArrayList<ArrayList<String>>();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String str = "";
		while (!(str = reader.readLine()).equals("")) {
			StringTokenizer tokenizer = new StringTokenizer(str);
			ArrayList<String> s = new ArrayList<String>();
			while (tokenizer.hasMoreTokens()) {
				s.add(tokenizer.nextToken());
			}
			datas.add(s);
		}
		return datas;
	}
	
	/**
	 * 递归打印树结构
	 * @param root 当前待输出信息的结点
	 */
	public void printTree(TreeNode root){
		System.out.println("name:" + root.getName());
		ArrayList<String> rules = root.getRule();
		System.out.print("node rules: {");
		for (int i = 0; i < rules.size(); i++) {
			System.out.print(rules.get(i) + " ");
		}
		System.out.print("}");
		System.out.println("");
		ArrayList<TreeNode> children = root.getChild();
		int size =children.size();
		if (size == 0) {
			System.out.println("-->leaf node!<--");
		} else {
			System.out.println("size of children:" + children.size());
			for (int i = 0; i < children.size(); i++) {
				System.out.print("child " + (i + 1) + " of node " + root.getName() + ": ");
				printTree(children.get(i));
			}
		}
	}
	/**
	 * 主函数，程序入口
	 * @param args
	 */ 
	public static void main(String[] args) {
		TestDecisionTree tdt = new TestDecisionTree();
		ArrayList<String> candAttr = new ArrayList<String>();
		ArrayList<ArrayList<String>> datas = new ArrayList<ArrayList<String>>();
		//插入属性列表
		String str = "comprehensive,philosophy,economy,law," +
				"education,literature,history,science,engineering,agriculture,medical," +
				"military,management,art,dltsk,mltsk,tj102,else2,morning,afternoon,night";
		String[] strs = str.split(",");
		for(String tmp:strs){
			candAttr.add(tmp);						
			}
/*		//输出属性列表
		for(int i=0;i<candAttr.size();i++){
			System.out.print(candAttr.get(i)+"-");
		}
		System.out.println(candAttr.size());*/
		//插入训练样本
		SqlTools st = new SqlTools();
		st.connectDB();
		ResultSet rs = null;
		rs = st.selectDB();
		String tmp="";
		try {
			while(rs.next()){
				ArrayList<String> s = new ArrayList<String>();
				 tmp = rs.getString(2);
				 s.add(tmp);
				 tmp = rs.getString(3);
				 s.add(tmp);
				 tmp = rs.getString(4);
				 s.add(tmp);
				 tmp = rs.getString(5);
				 s.add(tmp);
				 tmp = rs.getString(6);
				 s.add(tmp);
				 tmp = rs.getString(7);
				 s.add(tmp);
				 tmp = rs.getString(8);
				 s.add(tmp);
				 tmp = rs.getString(9);
				 s.add(tmp);
				 tmp = rs.getString(10);
				 s.add(tmp);
				 tmp = rs.getString(11);
				 s.add(tmp);
				 tmp = rs.getString(12);
				 s.add(tmp);
				 tmp = rs.getString(13);
				 s.add(tmp);
				 tmp = rs.getString(14);
				 s.add(tmp);
				 tmp = rs.getString(15);
				 s.add(tmp);
				 tmp = rs.getString(16);
				 s.add(tmp);
				 tmp = rs.getString(17);
				 s.add(tmp);
				 tmp = rs.getString(18);
				 s.add(tmp);
				 tmp = rs.getString(19);
				 s.add(tmp);
				 tmp = rs.getString(20);
				 s.add(tmp);
				 tmp = rs.getString(21);
				 s.add(tmp);
				 tmp = rs.getString(22);
				 s.add(tmp);
				 tmp = rs.getString(23);
				 s.add(tmp);
				 datas.add(s);
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
/*		//输出训练样本
		int count = 1;
		for(int i=0;i<datas.size();i++){
			System.out.println("第"+count+"个记录：");
			for(int j=0;j<datas.get(i).size();j++){
				System.out.print(datas.get(i).get(j)+"-");
			}
			count++;
			System.out.println();
		}*/
		st.closeDB();
/*		try {
			System.out.println("请输入候选属性");
			candAttr = tdt.readCandAttr();
			System.out.println("请输入训练数据");
			datas = tdt.readData();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		DecisionTree tree = new DecisionTree();
		TreeNode root = tree.buildTree(datas, candAttr);
		tdt.printTree(root);
	}
}
