package webadv.pyf17204201.exper01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.codec.digest.DigestUtils;

public class App {
	 
	public static void main(String[] args) throws IOException {
	FileWriter fw = new FileWriter("password.txt");
	BufferedWriter osw = new BufferedWriter(fw);
	osw.write("17204201\n");
	osw.write(sha256hex("123456"));
	osw.close();
	fw.close();
	
	String username="";
	String password="";
	Scanner input = new Scanner(System.in);
	System.out.println("请输入账号:");
	username = input.nextLine();
	System.out.println("请输入密码:");
	password = input.nextLine();
	
	FileReader fr = new FileReader("password.txt");
	BufferedReader bf = new BufferedReader(fr);
	String txtUsername = bf.readLine();
	System.out.println(txtUsername);
	String txtPassword = bf.readLine();
	System.out.println(txtPassword);
	bf.close();
	fr.close();
	
	if(username.equals(txtUsername)&&sha256hex(password).equals(txtPassword)) {
		System.out.println("登陆成功");
	}else {
		System.out.println("登录失败");
	}
}
	public static String sha256hex(String input) {
		return DigestUtils.sha256Hex(input);
	}
}
