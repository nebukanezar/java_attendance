import java.util.*;
import java.io.*;
class Attendance{
	void makeAttendance(String date,String employeefile){
		File file = new File(employeefile);
		BufferedReader reader=null;
		Scanner sc = new Scanner(System.in);
		try{
			reader = new BufferedReader(new FileReader(file));
		
			String text;

			while ((text = reader.readLine()) != null) {
				System.out.printf("%s:",text);
				char c=sc.next().charAt(0);
				String input="";
				input = input + date + " " +text + " " +c+"\n";
				this.writeAttendance(input,"employee_attendace.txt");
			}
		}catch(FileNotFoundException e){
			System.out.println(e);
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
			System.out.println("hoho");
		}
		System.out.println("Today's date is "+date);
		
	}
	private void writeAttendance(String write,String filename){
		try{
			BufferedWriter out = new BufferedWriter(new FileWriter(filename,true));
			out.write(write);
			out.close();
		}catch (IOException e){
			System.out.println(e);
		}
	}	
	void singleAttendance(String write,String filename){
		Scanner sc = new Scanner(System.in);
		String employeeName,date,pORa;
		System.out.printf("Enter employee name:");
		employeeName = sc.nextLine();
		System.out.printf("Enter date:");
		date = sc.nextLine();
		System.out.printf("Enter present(p) or absent(a)");
		pORa=sc.nextLine();
		System.out.println(employeeName+" "+date+" "+pORa);
		String input=employeeName + " " + date + " " + pORa + "\n"; 
		try{
			BufferedWriter out = new BufferedWriter(new FileWriter(filename,true));
			out.write(input);
			out.close();
		}catch(IOException e){
			System.out.println(e);
		}

	}
	void markAbsent(String name,String date,String filename){
		try{
			BufferedWriter out = new BufferedWriter(new FileWriter(filename,true));
			String input = date + " " + name +" a";
			out.write(input);
			out.close();
		}catch(IOException e){
			System.out.println(e);
		}

	}

	public ArrayList markUsers(String filename){
		User user;
		user = new User();
		return (ArrayList)user.getUsersFromText(filename);
	}
}

class User{
	String username;
	public ArrayList getUsersFromText(String fileName){
		List<String> a1=new ArrayList<String>();
		try{
			File file = new File(fileName);
			BufferedReader reader = null;
			reader = new BufferedReader(new FileReader(file));
			String text;
			while((text=reader.readLine())!=null){
				a1.add(text);
			}
			//System.out.print("farseee"+a1);
			return (ArrayList)a1; 
		}catch(IOException e){
			System.out.println(e);
		}
		return (ArrayList)a1;
	} 
	
}
class saveAttendance{
	void saveText(List<String> a1){
		System.out.println(a1);
	}
}
public class Solution{
	public static void main(String[] args){
	Attendance present_attendace = new Attendance();
	User user = new User();
	present_attendace.makeAttendance("04-03-2016","employee.txt");
	//present_attendace.makeAttendance("jhakkas","employee_attendace.txt");
	//present_attendace.singleAttendance("google","yahoo");
	//present_attendace.markAbsent("chetan","05-03-16","yahoo");
	//ArrayList arr=user.getUsersFromText("employee.txt");
	ArrayList arr2=present_attendace.markUsers("employee.txt");
	
	System.out.println("jhakkas "+arr2);
	}

} 

