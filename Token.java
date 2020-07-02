/* 
 * Vorname : Izzeldeen
 * Nachname : Alzeer
 * Email izzeldeen.alzeer@tu-clausthal.de
 * @author Izzeldeen ALzeer 
 * version 14.0.1
 * Gruppe Partner : Fadi Abuqutheileh
 * Partner-Email: fadi.abuqutheileh@tu-clausthal.de
 */
package VierGewinnt;

public class Token  extends GameObjekt{
	public enum Color{RED,YELLOW}
	public Color color;
	
	public Token (Color color) {
		this.color=color;
	}

	public String toString() {
		return null;
	};

}
