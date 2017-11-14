package tp.v2;

public class TestFilesMutables {
	public static void main(String[] arg){
		FileMutableImpl<String> file1 = new FileMutableImpl<>();
		file1.ajouter("item1");
		System.out.println(file1);
		file1.ajout("item2");
		System.out.println(file1);
		file1.ajout("item3");
		System.out.println(file1);
		file1.ajout("item4");
		System.out.println(file1);
		
	}
}
