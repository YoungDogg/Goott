package interfaceEx2;

public class InterfaceEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Parsable parser = ParsManager.getParser("json");
		parser.parse("ex1.json");
		
		parser = ParsManager.getParser("xml");
		parser.parse("ex1.xml");
				
	}

}
