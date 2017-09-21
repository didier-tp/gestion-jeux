package gestion.model;

public enum Civilite {
	M("eleveEdit.civilite.M"), MME("eleveEdit.civilite.MME"), MLLE("eleveEdit.civilite.MLLE");

	private final String label;

	private Civilite(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

}
