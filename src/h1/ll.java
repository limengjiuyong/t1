package h1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
 
public class ll {               ////1.�ִ�
	public static ArrayList<String[]> readTxtFile(String filePath,String encoding) {
		ArrayList<String[]> res = new ArrayList<String[]>();           
		try {               
			File file = new File(filePath);
			if (file.isFile() && file.exists()) { // �ж��ļ��Ƿ����
				InputStreamReader read = new InputStreamReader(
						new FileInputStream(file), encoding);// �����ʽ������ļ���һ��
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				while ((lineTxt = bufferedReader.readLine()) != null) {
					if (!lineTxt.startsWith("--")) {
						res.add(lineTxt.split("\t"));
					}
				}
				read.close();
			} else {
				System.out.println("ָ�����ļ�������");
			}
			
		} catch (Exception e) {
			System.out.println("��ȡ�ļ����ݳ���");
			e.printStackTrace();
		}
		return res;
	}

	   public static void main(String[] args) {
		   
		   String filePath = "F:\\123\\1234.txt";    //�ļ�·��
			ArrayList<String[]> text=new ArrayList<String[]>();
			text=readTxtFile(filePath,"utf-8");
			//System.out.println(text.get(0)[0]);
	//
			//
	       String str = text.get(0)[0];         //���ñ����ļ�������
	       List<String> normalDict = new ArrayList<String>();

	      
	       int strLen = str.length();  //�����ַ����ĳ���
	       int j = 0;
	       String matchWord = ""; //���ݴʿ���ʶ������Ĵ�
	       int matchPos = 0; //���ݴʿ���ʶ������ʺ�ǰ�����е�λ��
	       while (j < strLen) {      //��0�ַ�ƥ�䵽�ַ�������
	           int matchPosTmp = 0;   //��ȡ�ַ�����λ��
	           int i = 1;
	           while (matchPosTmp < strLen) {   //�ӵ�ǰλ��ֱ�����������ƥ����󳤶�
	               matchPosTmp = i + j;
	               String keyTmp = str.substring(j, matchPosTmp);//�г�����ַ���
	               if (normalDict.contains(keyTmp)) { //�жϵ�ǰ�ַ����Ƿ��ڴʵ���
	                   matchWord = keyTmp;  //����ڴʵ���ƥ�����˾͸�ֵ
	                   matchPos = matchPosTmp; //ͬʱ�����ƥ��λ��
	               }
	               i++;
	           }
	           if (!matchWord.isEmpty()) {
	               //��ƥ�����������󳤶�ƥ���ַ���
	               j = matchPos;
	               //����λ�ã��´δӵ�ǰλ�ü��������ȡ
	               System.out.print(matchWord + " ");
	           } else {
	               //�ӵ�ǰ�ʿ�ʼ����û���ܹ�ƥ���ϵĴʣ����յ����зֵ�ԭ���з�
	               System.out.print(str.substring(j, ++j) + "   ");
	           }
	           matchWord = "";
	       }
	   }
	}