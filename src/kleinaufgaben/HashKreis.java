package kleinaufgaben;

import java.util.Collection;
import java.util.HashSet;

class Kreis {
	private int radius;

	Kreis(int radius) {
		setRadius(radius);
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public int getradius() {
		return this.radius;
	}

	@Override
	public boolean equals(Object object) {

		if (!(object instanceof Kreis))
			return false;

		Kreis kreis = (Kreis) object;
		return this.hashCode() == kreis.hashCode();
	}

	@Override
	public int hashCode() {
		return this.getradius();
	}

}

public class HashKreis {

	public static void main(String[] args) {

		Collection<Kreis> kreise = new HashSet<>();

		kreise.add(new Kreis(3));
		kreise.add(new Kreis(3));
		kreise.add(new Kreis(31));

		System.out.println(kreise.size());
	}

}
