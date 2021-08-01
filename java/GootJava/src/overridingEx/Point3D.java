package overridingEx;

public class Point3D extends Point{

	private int z;

	public Point3D(int x, int y, int z) {
		super(x, y);
		this.z = z;
	}

	@Override
	public String getLocation() {
		// TODO Auto-generated method stub
		return super.getLocation() + ", z: " + this.z;
	}
	
	
}
