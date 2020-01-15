package Aufgaben;

import java.util.ArrayList;
import java.util.Collection;

interface KannBehandeltWerden {

	void setGesund(boolean gesund);

	boolean isGesund();
}

abstract class Wesen implements KannBehandeltWerden {

	private String name;
	private boolean gesund = true;

	Wesen(String name) {
		this.setName(name);
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void setGesund(boolean gesund) {
		this.gesund = gesund;
	}

	@Override
	public boolean isGesund() {
		return this.gesund;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " " + this.getName() + " ist "
				+ (this.isGesund() ? "gesund" : "krank");
	}
}

abstract class Tier extends Wesen {
	Tier(String name) {
		super(name);
	}
}

abstract class Mensch extends Wesen {
	Mensch(String name) {
		super(name);
	}
}

class Arzt<T extends Wesen> extends Mensch {
	Arzt(String name) {
		super(name);
	}

	public void patient(T tier) {
	}
}

class Affe extends Tier {
	Affe(String name) {
		super(name);
	}
}

class Zebra extends Tier {
	Zebra(String name) {
		super(name);
	}
}

class Zoo {
	private Collection<Tier> bestand = new ArrayList<>();

	public void addTier(Tier tier) {
		this.bestand.add(tier);
	}

	public Collection<Tier> getBestand() {
		return this.bestand;
	}
}

public class GenericsZoo {

	public static void main(String[] args) {

		Zoo zoo = new Zoo();

		Affe affeEffa = new Affe("Effa");
		affeEffa.setGesund(false);

		Zebra zebraPaulchen = new Zebra("Paulchen");
		zebraPaulchen.setGesund(true);

		zoo.addTier(new Affe("Martin"));
		zoo.addTier(affeEffa);
		zoo.addTier(new Zebra("Diamond"));
		zoo.addTier(zebraPaulchen);

		printZooBestand(zoo);

		Arzt<Affe> arztAffenDoctor = new Arzt<>("Alfred AffenDoctor");

		arztAffenDoctor.patient(affeEffa);
		arztAffenDoctor.patient(new Affe(""));
//		arztAffenDoctor.patient(zebraPaulchen);
//		arztAffenDoctor.patient(new Zebra(""));
//		arztAffenDoctor.patient(new Arzt(""));

		Arzt<Tier> arztDolittle = new Arzt<>("Doctor Dolittle");

		arztDolittle.patient(affeEffa);
		arztDolittle.patient(new Affe(""));
		arztDolittle.patient(zebraPaulchen);
		arztDolittle.patient(new Zebra(""));
//		arztDolittle.patient(arztAffenDoctor);

		Arzt<Wesen> arztAllgemein = new Arzt<>("Max Allgemein");

		arztAllgemein.patient(affeEffa);
		arztAllgemein.patient(new Affe(""));
		arztAllgemein.patient(zebraPaulchen);
		arztAllgemein.patient(new Zebra(""));
		arztAllgemein.patient(arztAffenDoctor);

	}

	static void printZooBestand(Zoo zoo) {

		Collection<Tier> bestand = zoo.getBestand();

		for (Tier i : bestand)
			System.out.println(i);
	}

}
