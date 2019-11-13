package h1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.common.Term;

public class ll1 {             //2.����ʵ��ʶ��
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
		String filePath = "F:\\123\\12345.txt";    //�ļ�·��
		ArrayList<String[]> text=new ArrayList<String[]>();
		text=readTxtFile(filePath,"utf-8");
		//System.out.println(text.get(0)[0]);
		String word = text.get(0)[0];
		List<Term> termList=  HanLP.segment(word);
		System.out.println(termList.toString());
		
	}
	}

