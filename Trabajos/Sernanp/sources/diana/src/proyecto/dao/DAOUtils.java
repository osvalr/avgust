package proyecto.dao;


public class DAOUtils  {
	public Integer getLastId(String classname){ 
		System.out.println("SELECT MAX(id"+classname+") FROM "+classname);
		return 1; 
	} 

}
