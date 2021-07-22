package interfaceEx2;

public class XmlParser implements Parsable{

	@Override
	public void parse(String fileName) {
		// TODO Auto-generated method stub
		if(fileName.endsWith(".xml")){
			System.out.println(fileName + " parses");
		}
	}

}
