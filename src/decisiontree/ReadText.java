package decisiontree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ReadText {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	File rfile = new File("F:\\books\\cluster3.txt");
		BufferedReader rbr = new BufferedReader
				(new FileReader(rfile));//构造一个BufferedReader类来读取文件
/*写文件	File wfile = new File("F:\\books\\book.txt");
		BufferedWriter wbr = new BufferedWriter
		(new FileWriter(wfile,true));
		String tmp = "";
		int count = 1;
		while((tmp=rbr.readLine())!=null && count<=400){
			ArrayList<String> reader = new ArrayList<String>();
			String[] strs = tmp.split(" ");
			for(String str:strs){
				reader.add(str+",");						
				}
			String readtmp = reader.get(reader.size()-1).toString().substring(0, reader.get(reader.size()-1).length()-1);
			reader.remove(reader.size()-1);
			reader.add(readtmp);
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<reader.size();i++){
				sb.append(reader.get(i).toString());
			}
			System.out.println("第"+count+"个："+sb.toString());
			wbr.write(sb.toString());
			wbr.newLine();
			wbr.flush();
			count++;
			}*/
		
/*读文件并写入数据库		String tmp = "";
		int count = 1;
		SqlTools st = new SqlTools();
		st.connectDB();
		while((tmp=rbr.readLine())!=null && count<=470){			
			if(count>400){
				ArrayList<String> reader = new ArrayList<String>();
				String[] strs = tmp.split(" ");
				for(String str:strs){
					reader.add(str);						
					}
				if(st.insertRecord(reader)){
					System.out.println("第"+count+"个记录插入成功");
				}
			}
			count++;
			}
		st.closeDB();*/
		
		
		/*一个文件的记录个数 String tmp="";
		int count=0;
		while((tmp=rbr.readLine())!=null){
			count++;
			}
		System.out.println(count);*/
	}

}
