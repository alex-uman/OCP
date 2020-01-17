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

	private void setName(String name) {
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

	public void heilen(T wesen) {
		wesen.setGesund(true);
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
		arztAffenDoctor.heilen(affeEffa);
		arztAffenDoctor.heilen(new Affe(""));
//		arztAffenDoctor.heilen(zebraPaulchen);
//		arztAffenDoctor.heilen(new Zebra(""));
//		arztAffenDoctor.heilen(new Arzt(""));

		Arzt<Tier> arztDolittle = new Arzt<>("Doctor Dolittle");
		arztDolittle.heilen(affeEffa);
		arztDolittle.heilen(new Affe(""));
		arztDolittle.heilen(zebraPaulchen);
		arztDolittle.heilen(new Zebra(""));
//		arztDolittle.heilen(arztAffenDoctor);

		Arzt<Wesen> arztAllgemein = new Arzt<>("Max Allgemein");
		arztAllgemein.heilen(affeEffa);
		arztAllgemein.heilen(new Affe(""));
		arztAllgemein.heilen(zebraPaulchen);
		arztAllgemein.heilen(new Zebra(""));
		arztAllgemein.heilen(arztAffenDoctor);

		System.out.println();
		printZooBestand(zoo);

	}

	static void printZooBestand(Zoo zoo) {

		Collection<Tier> bestand = zoo.getBestand();

		for (Tier i : bestand)
			System.out.println(i);
	}

}
