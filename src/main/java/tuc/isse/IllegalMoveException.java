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

public class IllegalMoveException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public IllegalMoveException(){
		System.out.println("Sie dürfen keine Spielsteine fallen lassen, es gibt einen Sieger!"); 
	}  

}
