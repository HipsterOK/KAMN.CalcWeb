package Other;

import Servlets.Login;

public class Calculator extends FileReaderClass{ //класс для рассчета зарплаты и налогов
	public static float zp;
	public static float zpNalog;
	public static float nalog;
	public static float nalog1;
	public static float nalog2;
	public static float nalog3;
	public static float nalog4;
	public static float nacislen;
	public static float finalZp;
	 public static void main(int id, int mesyac) { //метод для рассчета
		 int[] rabDni = {17, 20, 20, 22, 18, 19, 23, 22, 21, 23, 30, 31}; //рабочии дни в каждом месяце
		 zp = (FileReaderClass.usersObj.get(id).getOklad()*FileReaderClass.usersObj.get(id).getWorkTime(mesyac))/rabDni[mesyac]; //расчет зп
		 nacislen = zp+FileReaderClass.usersObj.get(Login.selectedId).getPrem(); //рассчет начислений (зп+премия)
		 nalog = (float) (nacislen*0.13); //расчет налогов
		 finalZp = nacislen-nalog;// рассчет финальной зарплаты
		 nalog1 = (float) (nacislen*0.22);//расчет налогов
		 nalog2 = (float) (nacislen*0.051);//расчет налогов
		 nalog3 = (float) (nacislen*0.029);//расчет налогов
		 nalog4 = (float) (nacislen*0.002);//расчет налогов
		 
	 }
}