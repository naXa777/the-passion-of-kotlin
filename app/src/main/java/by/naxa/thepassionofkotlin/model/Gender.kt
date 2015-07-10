package by.naxa.thepassionofkotlin.model

/**
 * Enumeration for reflecting [Student]'s gender.
 * Created on 10/03/2015.

 * @author phomal
 */
public enum class Gender(
        /** The string representation of this element in the enumeration. */
        val description: String) {

    /** Male.  */
    M("Male"),
    /** Female.  */
    F("Female"),
    /** Gender is not known, or not specified.  */
    UNKNOWN("Unknown")

}
