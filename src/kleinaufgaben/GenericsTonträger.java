package kleinaufgaben;

interface Tontraeger {
}

class Schallplatte implements Tontraeger {
}

class Tonband implements Tontraeger {
}

class CD implements Tontraeger {
}

class Abspielgeraet<TT extends Tontraeger> {
	void abspielen(TT t) {
	}
}

public class GenericsTonträger {

	public static void main(String[] args) {

		Abspielgeraet<Schallplatte> a1 = new Abspielgeraet<>();
		Abspielgeraet<CD> a2 = new Abspielgeraet<>();
//		Abspielgeraet<String> a3 = new Abspielgeraet<>();
		a1.abspielen(new Schallplatte());
		a2.abspielen(new CD());
	}

}
