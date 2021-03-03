

public class MyDemo {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Inside Main");
		
		
		try {
			Class cls = Class.forName("MyDemo");
			
			ClassLoader cloader = cls.getClassLoader();
			
			System.out.println(cloader.getName());
			System.out.println(cloader);
			
			Class cls2 = Class.forName("java.lang.Thread", false, cloader);
			
			System.out.println("Class = " + cls.getName());
			System.out.println("Class = " + cls2.getCanonicalName());
			
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
		
		
		
	}

}
