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

public class ColumnFullException  extends Exception {
	private static final long serialVersionUID = 1L;

	public ColumnFullException(){
		System.out.println("Es gibt keinen Platz mehr !");
	}  

}
