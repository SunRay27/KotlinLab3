package serviceManager

class UserContacts : ContactsService {
    private val contactsMap: MutableMap<Person, MutableList<Contact>> = mutableMapOf()

    override fun addContact(person: Person, contact: Contact) {
        contactsMap.putIfAbsent(person, mutableListOf())
        contactsMap.getValue(person).add(contact)
    }

    override fun removeContact(person: Person, contact: Contact) {
        contactsMap.getValue(person).remove(contact)
    }

    override fun removePerson(person: Person) {
        contactsMap.remove(person)
    }

    override fun addPhone(person: Person, phone: String, phoneType: Contact.Phone.PhoneType) {
        contactsMap.putIfAbsent(person, mutableListOf())
        contactsMap.getValue(person).add(Contact.Phone(phone, phoneType))
    }

    override fun addEmail(person: Person, email: String) {
        contactsMap.putIfAbsent(person, mutableListOf())
        contactsMap.getValue(person).add(Contact.Email(email))
    }

    override fun addLink(person: Person, linkName: String, url: String) {
        contactsMap.putIfAbsent(person, mutableListOf())
        contactsMap.getValue(person).add(Contact.SocialLink(linkName, url))
    }

    override fun addAddress(person: Person, index: UInt, cityName: String, streetName: String, buildingNumber: UInt) {
        contactsMap.putIfAbsent(person, mutableListOf())
        contactsMap.getValue(person).add(Contact.Address(index, cityName, streetName, buildingNumber))
    }

    override fun getPersonContacts(person: Person): List<Contact> {

        return contactsMap.getValue(person).toList()
    }

    override fun getPersonPhones(person: Person): List<Contact.Phone> {
        return contactsMap.getValue(person).filterIsInstance<Contact.Phone>()
    }

    override fun getPersonAddresses(person: Person): List<Contact.Address> {
        return contactsMap.getValue(person).filterIsInstance<Contact.Address>()
    }

    override fun getPersonEmails(person: Person): List<Contact.Email> {
        return contactsMap.getValue(person).filterIsInstance<Contact.Email>()
    }

    override fun getPersonLinks(person: Person): List<Contact.SocialLink> {
        return contactsMap.getValue(person).filterIsInstance<Contact.SocialLink>()
    }

    override fun getAllPersons(): List<Person> {
        return contactsMap.keys.toList()
    }

    override fun getAllContacts(): Map<Person, List<Contact>> {
        return contactsMap
    }

    override fun findPerson(match: String): Person? {
        return contactsMap.keys.firstOrNull { it.firstName.contains(match) || it.secondName.contains(match) }
    }

}