package Objects;

public class Users {
	  private long id;
	  private String name;
	  private String password;
	  private int role;
	  private String roleName;
	  private int oklad;
	  private int[] workTime = new int[12];
	  private int[] workTimeHours = new int[12];
	  private float prem;
	  
	  public Users(String line) {
	        String[] users = line.split(":");
	        id = Long.valueOf(users[0]);
	        name = users[1];
	        password = users[2];
	        role = Integer.valueOf(users[3]);
	        roleName = users[4];
	        oklad = Integer.valueOf(users[5]);
	        for(int i=0; i<12; i++) {
	        	workTime[i] = Integer.valueOf(users[i+6]);
	        }
	        for(int i=0; i<12; i++) {
	        	workTimeHours[i] = Integer.valueOf(users[i+18]);
	        }
	        prem = Float.valueOf(users[30]);
	    }
	  
	  public long getId() {
		  return id;
	  }
	  
	  public String getName() {
		  return name;
	  }
	  
	  public String getPassword() {
		  return password;
	  }
	  
	  public int getRole() {
		  return role;
	  }
	  
	  public String getRoleName() {
		  return roleName;
	  }
	  
	  public int getOklad() {
		  return oklad;
	  }
	  
	  public int getWorkTime(int i) {
		  return workTime[i];
	  }
	  
	  public int getWorkTimeHours(int i) {
		  return workTimeHours[i];
	  }
	  
	  public float getPrem() {
		  return prem;
	  }
	  
	  public void setId(long id) {
		 this.id=id;
	  }
	  
	  public void setName(String name) {
		  this.name=name;
	  }
	  
	  public void setPassword(String password) {
		 this.password = password;
	  }
	  
	  public void setRole(int role) {
			 this.role = role;
		  }
	  
	  public void setRoleName(String roleName) {
			 this.roleName = roleName;
		  }
	  
	  public void setOklad(int oklad) {
		  this.oklad=oklad;
	  }
	  
	  public void setWorkTime(int i,int workTime) {
		  this.workTime[i]=workTime;
	  }
	  
	  public void setWorkTimeHours(int i,int workTimeHours) {
		  this.workTimeHours[i]=workTimeHours;
	  }
	  
	  public void setPrem(float prem) {
		  this.prem=prem;
	  }
}
