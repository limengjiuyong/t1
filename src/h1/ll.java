package h1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
 
public class ll {               ////1.分词
	public static ArrayList<String[]> readTxtFile(String filePath,String encoding) {
		ArrayList<String[]> res = new ArrayList<String[]>();           
		try {               
			File file = new File(filePath);
			if (file.isFile() && file.exists()) { // 判断文件是否存在
				InputStreamReader read = new InputStreamReader(
						new FileInputStream(file), encoding);// 编码格式必须和文件的一致
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				while ((lineTxt = bufferedReader.readLine()) != null) {
					if (!lineTxt.startsWith("--")) {
						res.add(lineTxt.split("\t"));
					}
				}
				read.close();
			} else {
				System.out.println("指定的文件不存在");
			}
			
		} catch (Exception e) {
			System.out.println("读取文件内容出错");
			e.printStackTrace();
		}
		return res;
	}

	   public static void main(String[] args) {
		   
		   String filePath = "F:\\123\\1234.txt";    //文件路径
			ArrayList<String[]> text=new ArrayList<String[]>();
			text=readTxtFile(filePath,"utf-8");
			//System.out.println(text.get(0)[0]);
	//
			//
	       String str = text.get(0)[0];         //调用本地文件的数据
	       List<String> normalDict = new ArrayList<String>();

	      
	       int strLen = str.length();  //传入字符串的长度
	       int j = 0;
	       String matchWord = ""; //根据词库里识别出来的词
	       int matchPos = 0; //根据词库里识别出来词后当前句子中的位置
	       while (j < strLen) {      //从0字符匹配到字符串结束
	           int matchPosTmp = 0;   //截取字符串的位置
	           int i = 1;
	           while (matchPosTmp < strLen) {   //从当前位置直到整句结束，匹配最大长度
	               matchPosTmp = i + j;
	               String keyTmp = str.substring(j, matchPosTmp);//切出最大字符串
	               if (normalDict.contains(keyTmp)) { //判断当前字符串是否在词典中
	                   matchWord = keyTmp;  //如果在词典中匹配上了就赋值
	                   matchPos = matchPosTmp; //同时保存好匹配位置
	               }
	               i++;
	           }
	           if (!matchWord.isEmpty()) {
	               //有匹配结果就输出最大长度匹配字符串
	               j = matchPos;
	               //保存位置，下次从当前位置继续往后截取
	               System.out.print(matchWord + " ");
	           } else {
	               //从当前词开始往后都没有能够匹配上的词，则按照单字切分的原则切分
	               System.out.print(str.substring(j, ++j) + "   ");
	           }
	           matchWord = "";
	       }
	   }
	}