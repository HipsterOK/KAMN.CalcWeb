package Other;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import Objects.Users;

public class FileReaderClass {
	 public static ArrayList<Users> usersObj = new ArrayList<>();
	 
	 public static void main() {
		 String subStr;
		 
		 try {
	            File file = new File("src/main/resources/info/users.txt");
	            //создаем объект FileReader для объекта File
	            FileReader fr = new FileReader(file);
	            //создаем BufferedReader с существующего FileReader для построчного считывания
	            BufferedReader reader = new BufferedReader(fr);
	            // считаем сначала первую строку
	            String delimeter = ":"; // Разделитель
	            while ((subStr = reader.readLine()) != null) {
	                usersObj.add(new Users(subStr));
	            }
	            reader.close();
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		 for (int i=0; i<usersObj.size(); i++) {
			    Users user = usersObj.get(i);
			    System.out.println(user.getId() + " | " + user.getName() + " | " + user.getPassword() + " | " + user.getRole()+" | " + user.getOklad() + " | "+ user.getWorkTime(0));
			}
	    }
	
	}

