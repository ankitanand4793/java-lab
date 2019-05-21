package ph;
import java.util.*;

class phone 
{
	String name, time;
	String phnumber;
	phone(String na, String n, String t) 
	{
		name = na;
		phnumber = n;
		time = t;
	}
	public String toString() 
	{
		return "Name is:" + name + " Number: " + phnumber + " Time: " + time;
	}
}

class PhoneNumber 
{
	private static Scanner s;
	public static void main(String args[]) 
	{
		String[] lot = new String[10];
		int ii = 0;
		HashMap<Integer, phone> pm = new HashMap<Integer, phone>();
		HashMap<Integer, String> nm = new HashMap<Integer, String>();
		nm.put(1, "Ram");
		nm.put(2, "Sam");
		nm.put(3, "Wong");
		nm.put(4, "john");
		nm.put(5, "Ravi");
		nm.put(6, "Rajesh");
		nm.put(7, "Ramesh");
		nm.put(8, "Private");
		nm.put(9, "Private");
		nm.put(10, "Private");
		HashMap<Integer, String> sm = new HashMap<Integer, String>();
		sm.put(1, "122345");
		sm.put(2, "234552");
		sm.put(3, "252452");
		sm.put(4, "525551");
		sm.put(5, "524255");
		sm.put(6, "525245");
		sm.put(7, "253452");
		sm.put(8, "523455");
		sm.put(9, "5325275");
		sm.put(10, "253565");
		Calendar c = Calendar.getInstance();
		s = new Scanner(System.in);
		int count = 1;
		while (true) 
		{
			System.out.println("Enter the choice\n 1)add 2)Disply 3)Delete 4)exit");
			int ch = Integer.parseInt(s.next());
			switch (ch) 
			{
			case 1:
				if (count <= 10)
				{
					Random rand = new Random();
					int number = rand.nextInt(10);
					String Name = nm.get(number);
					String Number = sm.get(number);
					int hour = c.get(Calendar.HOUR);
					int min = c.get(Calendar.MINUTE);
					int sec = c.get(Calendar.SECOND);
					String time = hour + ":" + min + ":" + sec;
					pm.put(count, new phone(Name, Number, time));
					count++;
				} 
				else 
					pm.remove(1);
				break;
			case 2:
				Set<Map.Entry<Integer, phone>> myset = pm.entrySet();
				for (Map.Entry<Integer, phone> me : myset) 
				{
					System.out.println("----------------------------\n");
					System.out.println(me.getValue());
					System.out.println("Enter the choice 1)Display next number\n 2)Delete the displayed number and print the next number");
					int cd = Integer.parseInt(s.next());
					switch (cd) 
					{
					case 1:
						continue;
					case 2:
						lot[ii] = Integer.toString(me.getKey());
						ii++;
						System.out.println("Deleted!!!");
						continue;
					}
					System.out.println("\n");
				}
				for (int r = 0; r < ii; r++)
				{
					int mm = Integer.parseInt(lot[r]);
					pm.remove(mm);
				}
				ii = 0;
				break;
			case 3:
				System.out.println("Enter the phone number to be delete");
				Scanner s1=new Scanner(System.in);
				String s3=s1.next();				
				Set<Map.Entry<Integer, phone>> myset1 = pm.entrySet();
				for (Map.Entry<Integer, phone> me1 : myset1) 
					{
					phone p1=me1.getValue();
					String s2=p1.phnumber;
					if(s3.equals(s2))
					{
						int t=me1.getKey();
						pm.remove(t);
						System.out.println("deleted!!");
						break;
					}	
				}
                                                     break;
			case 4:System.exit(0);
				
			}
}}}