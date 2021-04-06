package poly.edu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserDAO {
	SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
	public static List<User> ls = new ArrayList();
	 
	 public List<User> dumyData() throws ParseException {
		 ls.add(new User("A1", "123", "Nguyen Van A", 22, formatDate.parse("12/2/2000"), false));
		 ls.add(new User("A2", "456", "Nguyen Van B", 23, formatDate.parse("12/3/2000"), true));
		 ls.add(new User("A3", "789", "Nguyen Van C", 22, formatDate.parse("12/4/2000"), false));
		 ls.add(new User("A4", "123", "Nguyen Van D", 20, formatDate.parse("12/5/2000"), true));
		 ls.add(new User("A5", "123", "Nguyen Van E", 22, formatDate.parse("12/6/2000"), false));
		 return ls;
		 
	 }
	 public List<User> getAll(){
		 return ls;
	 }
	 
	 public int insert(User u) {
		 
		 ls.add(u);
		 return 1;
	 }
	 
	 public int update(User u) {
		 
		 for (int i = 0; i < ls.size(); i++) {
			if(ls.get(i).getUsername().equals(u.getUsername())) {
				ls.set(i, u);
				return i;
			}
		}
		 
		 return 1;
	 }
	 
	 public User findByUsername(String username) {
		 for (User user : ls) {
			if(user.getUsername().equals(username)) {
				return user;
			}
		}
		 return null;
	 }
	 
	 public int save(User user) {
		 if(findByUsername(user.getUsername()) != null) {
			 update(user);
		 }else {
			 insert(user);
		 }
		 return 1;
	 }
	 
	public int deletebyName(String username) {
		User u = findByUsername(username);
		if(u !=null) {
			ls.remove(u);
			return 1;
		}
		return -1;
	}
}
