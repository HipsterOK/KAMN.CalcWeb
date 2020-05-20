package Other;

public class Calculator extends FileReaderClass{
	public static float zp;
	public static float zpNalog;
	public static float nalog;
	public static float nalog1;
	public static float nalog2;
	public static float nalog3;
	public static float nalog4;
	public static float nacislen;
	public static float finalZp;
	 public static void main(int id, int mesyac) {
		 int[] rabDni = {17, 20, 20, 22, 18, 19, 23, 22, 21, 23, 30, 31};
		 zp = (FileReaderClass.usersObj.get(id).getOklad()*FileReaderClass.usersObj.get(id).getWorkTime(mesyac))/rabDni[mesyac];
		 nacislen = zp+FileReaderClass.usersObj.get(Login.selectedId).getPrem();
		 nalog = (float) (nacislen*0.13);
		 finalZp = nacislen-nalog;
		 nalog1 = (float) (nacislen*0.22);
		 nalog2 = (float) (nacislen*0.051);
		 nalog3 = (float) (nacislen*0.029);
		 nalog4 = (float) (nacislen*0.002);
		 
//		 for (int i=0; i<FileReaderClass.usersObj.size(); i++) {
//			    Users user = FileReaderClass.usersObj.get(i);
//			    System.out.println(user.getId() + " | " + user.getName() + " | " + user.getPassword() + " | " + user.getRole()+ user.getOklad() + " | "+ user.getWorkTime());
//			}
	 }
}