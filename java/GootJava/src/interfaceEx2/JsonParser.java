package interfaceEx2;

public class JsonParser implements Parsable{

	@Override
	public void parse(String fileName) {
		// TODO Auto-generated method stub
		if(fileName.endsWith(".json"))
			System.out.println(fileName + " parses");
	}

}
