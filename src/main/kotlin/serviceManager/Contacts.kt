package serviceManager

sealed class Contact {

    data class Address(
        private val index: UInt,
        private val cityName: String,
        private val streetName: String,
        private val buildingNumber: UInt
    ) : Contact() {

        override fun toString(): String = "$index, $cityName, ул. $streetName, д. $buildingNumber"
    }

    data class Phone(private val phoneNumber: String, private val phoneType: PhoneType) : Contact() {

        enum class PhoneType {
            PERSONAL,
            HOME,
            WORK
        }

        override fun toString(): String = "$phoneType: $phoneNumber"
    }

    data class Email(private val emailValue: String) : Contact() {
        override fun toString(): String = emailValue
    }

    data class SocialLink(private val name: String, private val url: String) : Contact() {
        override fun toString(): String = "$name: $url"
    }

}

