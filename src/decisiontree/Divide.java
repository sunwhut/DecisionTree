package decisiontree;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Divide {
	/**
	 * 参数为一个读者的8个属性，返回分类结果
	 * @param dltsk
	 * @param mltsk
	 * @param tj102
	 * @param else2
	 * @param morning
	 * @param afternoon
	 * @param night
	 * @param name
	 * @return  该读者的名字和分类结果
	 */
	public static final String TYPE1="1.0";
	public static final String TYPE2="2.0";
	public static final String TYPE3="3.0";
	public static final String TYPE4="4.0";
	
	public String divideRules(String dltsk,String mltsk,String tj102,
			String else2,String morning,String afternoon,String night){
		String belongs = "";
		String[] info = new String[2];
		if(Integer.parseInt(afternoon) <= 9){
			if(Integer.parseInt(mltsk)<= 6){
				if(Integer.parseInt(morning) <= 6){
					if(Integer.parseInt(night) <= 4){
						if(Integer.parseInt(mltsk)<= 5){
							belongs = TYPE2;
						}else{
							if(Integer.parseInt(night) <= 1){
								belongs = TYPE2;
							}else{
								belongs = TYPE1;
							}
						}
					}else{
						if(Integer.parseInt(morning)<=4){
							if(Integer.parseInt(night) <= 12){
								belongs = TYPE2;
							}else{
								belongs = TYPE3;
							}
						}else{
							if(Integer.parseInt(afternoon) <= 5){
								belongs = TYPE2;
							}else{
								belongs = TYPE3;
							}
						}
					}
				}else{
					if(Integer.parseInt(afternoon)<=5){
						if(Integer.parseInt(morning)<=12){
							belongs = TYPE2;
						}else{
							belongs = TYPE3;
						}
					}else{
						if(Integer.parseInt(morning) <=7){
							if(Integer.parseInt(afternoon)<=7){
								belongs = TYPE2;
							}else{
								belongs = TYPE3;
							}
						}else{
							belongs = TYPE3;
						}
					}
				}
			}else{
				if(Integer.parseInt(morning)<=7){
					belongs = TYPE1;
				}else{
					if(Integer.parseInt(night)<=1){
						belongs = TYPE1;
					}else{
						belongs = TYPE3;
					}
				}
			}
		}else{
			if(Integer.parseInt(afternoon)<=21){
				if(Integer.parseInt(morning)<=18){
					if(Integer.parseInt(mltsk)<=5){
						if(Integer.parseInt(afternoon)<=11){
							if(Integer.parseInt(morning)<=6){
								if(Integer.parseInt(night) <=5){
									if(Integer.parseInt(morning)<=3){
										belongs = TYPE2;
									}else{
										if(Integer.parseInt(night)<=1){
											belongs = TYPE2;
										}else{
											belongs = TYPE3;
										}
									}
								}else{
									belongs = TYPE3;
								}
							}else{
								belongs = TYPE3;
							}
						}else{
							belongs = TYPE3;
						}
					}else{
						if(Integer.parseInt(afternoon)<=13){
							if(Integer.parseInt(morning)<=4){
								if(Integer.parseInt(morning)<=2){
									belongs = TYPE1;
								}else{
									if(Integer.parseInt(night)<=4){
										belongs = TYPE1;
									}else{
										belongs = TYPE3;
									}
								}
							}else{
								if(Integer.parseInt(mltsk)<=22){
									belongs = TYPE3;
								}else{
									belongs = TYPE1;
								}
							}
						}else{
							belongs = TYPE3;
						}
					}
				}else{
					if(Integer.parseInt(afternoon)<=17){
						belongs = TYPE3;
					}else{
						if(Integer.parseInt(night)<=14){
							if(Integer.parseInt(morning)<=22){
								belongs = TYPE3;
							}else{
								belongs = TYPE4;
							}
						}else{
							belongs = TYPE4;
						}
					}
				}
			}else{
				if(Integer.parseInt(morning)<=14){
					if(Integer.parseInt(afternoon)<=26){
						belongs = TYPE3;	
					}else{
						if(Integer.parseInt(night)<=13){
							if(Integer.parseInt(tj102)<=1){
								if(Integer.parseInt(afternoon)<=32){
									belongs = TYPE3;
								}else{
									belongs = TYPE4;
								}
							}else{
								belongs = TYPE4;
							}
						}else{
							belongs = TYPE4;
						}
					}
				}else{
					if(Integer.parseInt(afternoon)<=24){
						if(Integer.parseInt(night)<=10){
							if(Integer.parseInt(morning)<=24){
								belongs = TYPE3;
							}else{
								belongs = TYPE4;
							}
						}else{
							belongs = TYPE4;
						}
					}else{
						if(Integer.parseInt(night)<=5){
							if(Integer.parseInt(morning)<=18){
								belongs = TYPE3;
							}else{
								belongs = TYPE4;
							}
						}else{
							belongs = TYPE4;
						}
					}
				}
			}
		}
		return belongs;
	}
	
	public static void main(String[] args){
		Divide di = new Divide();
		SqlTools st = new SqlTools();
		st.connectDB();
		ResultSet rs = st.selectDB();
		String tmp="";
		String belongs = "";
		String name = "";
		int count = 1;
		int correct = 0;
		try {
			while(rs.next()){
				ArrayList<String> s = new ArrayList<String>();
				 tmp = rs.getString(3);
				 s.add(tmp.substring(0,tmp.length()-2));
				 tmp = rs.getString(4);
				 s.add(tmp.substring(0,tmp.length()-2));
				 tmp = rs.getString(5);
				 s.add(tmp.substring(0,tmp.length()-2));
				 tmp = rs.getString(6);
				 s.add(tmp.substring(0,tmp.length()-2));
				 tmp = rs.getString(7);
				 s.add(tmp.substring(0,tmp.length()-2));
				 tmp = rs.getString(8);
				 s.add(tmp.substring(0,tmp.length()-2));
				 tmp = rs.getString(9);
				 s.add(tmp.substring(0,tmp.length()-2));
				 name = rs.getString(2);
				 s.add(name);
//				 System.out.println("第"+count+"个记录："+s);
				 belongs = rs.getString(10);
				 String info = di.divideRules(s.get(0), s.get(1), s.get(2), 
						 s.get(3), s.get(4), s.get(5), s.get(6));
				 
				 System.out.print("第"+count+"个读者：分类结果为："+info);
				 /*if(info.equals(belongs)){
					 System.out.println("-分类正确");
					 correct++;
				 }else{
					 System.out.println("-分类不正确-------------");
				 }*/
				 count++;
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 System.out.println("正确率为："+new DecimalFormat("0.0000").format((double)correct/(count-1)));
	}
}
