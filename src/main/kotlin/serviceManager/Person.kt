package serviceManager

data class Person(
    val firstName: String,
    val secondName: String
) {
    override fun toString(): String {
        return "$firstName $secondName"
    }

}