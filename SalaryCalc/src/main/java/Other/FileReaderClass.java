package Other;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.util.ArrayList;

import javax.swing.JFileChooser;

import Objects.Users;

public class FileReaderClass { //класс для рассчета 
	 public static ArrayList<Users> usersObj = new ArrayList<>();
	 
	 public static void main() {
		 String subStr;
		 String MyDocs=new JFileChooser().getFileSystemView().getDefaultDirectory().toString();
		 File filePath = new File(MyDocs+"/CalcWeb/");

		 
		 File file = new File("src/main/resources/info/users.txt"); //подключние файла с данными пользователей
		File fileHome = new File(MyDocs+"/CalcWeb/users.txt");
		System.out.println(fileHome.getPath());
		 
		 try {
			 
			if(filePath.mkdir()) {
				copyFile(file, fileHome);
			}
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 
		 try {
	            
	            
	            FileReader fr = new FileReader(fileHome);//создаем объект FileReader для объекта File
	            BufferedReader reader = new BufferedReader(fr); //создаем BufferedReader для построчного считывания
	            String delimeter = ":"; // Разделитель
	            while ((subStr = reader.readLine()) != "ИД:Имя:Пароль:Роль (0 - обычный работник, 1- менеджер):Должность:Оклад:Рабочие дни в каждом месяце (12 штук):Рабочие часы в каждом месяце (12 штук):Премия") {
	                usersObj.add(new Users(subStr)); //добавлять нового пользователя, пока след. строка не пустая
	            }
	            reader.close();
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		 /*Вывод данных в консоль для проверки*/
		 for (int i=0; i<usersObj.size(); i++) {
			    Users user = usersObj.get(i);
			    System.out.println(user.getId() + " | " + user.getName() + " | " + user.getPassword() + " | " + user.getRole()+" | " + user.getOklad() + " | "+ user.getWorkTime(0));
			}
	    }
	 

	 private static void copyFile(File source, File dest) throws IOException { // метод для копирования файлов
		    Files.copy(source.toPath(), dest.toPath());
		}
	
	}

