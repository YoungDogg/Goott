package interfaceEx2;

public class ParsManager{
	public static Parsable getParser(String extType) {
		Parsable p = null;
		if(extType.equals("xml")) {
			p = new XmlParser();
		}else if(extType.equals("json")){
			p = new JsonParser();
		}
		
		return p;
	}

}
