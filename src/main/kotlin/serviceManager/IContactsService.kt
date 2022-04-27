package serviceManager

interface IContactsService {

    fun addContact(person: Person, contact: Contact)
    fun removeContact(person: Person, contact: Contact)
    fun removePerson(person: Person)

    fun addPhone(person: Person, phone: String, phoneType: Contact.Phone.PhoneType)
    fun addEmail(person: Person, email: String)
    fun addLink(person: Person, linkName: String, url: String)
    fun addAddress(
        person: Person,
        index: UInt,
        cityName: String,
        streetName: String,
        buildingNumber: UInt
    )

    fun getPersonContacts(person: Person): List<Contact>
    fun getPersonPhones(person: Person): List<Contact.Phone>
    fun getPersonAddresses(person: Person): List<Contact.Address>
    fun getPersonEmails(person: Person): List<Contact.Email>
    fun getPersonLinks(person: Person): List<Contact.SocialLink>

    fun getAllPersons(): List<Person>
    fun getAllContacts(): Map<Person, List<Contact>>

    fun findPerson(match: String): Person?
}