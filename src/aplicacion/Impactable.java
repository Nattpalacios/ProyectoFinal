package aplicacion;

public interface Impactable {
	
	public char getIdentificador();
	public int impacto(int x, int y, char d);
	public boolean estoy(int i, int j, char d);
}
