import serviceManager.Contact
import serviceManager.ContactsService
import serviceManager.Person


fun main() {
    val service = ContactsService()

    val testPerson = Person("IVAN", "IVANOV")
    val testPerson2 = Person("IVAN", "IVANOVV")


    printSevice(service)

    service.addEmail(testPerson, "example@gmail.com")
    service.addPhone(testPerson, "8801", Contact.Phone.PhoneType.PERSONAL)
    service.addPhone(testPerson, "9801", Contact.Phone.PhoneType.HOME)
    service.addPhone(testPerson, "02", Contact.Phone.PhoneType.WORK)

    service.addContact(testPerson2, Contact.SocialLink("VK", "vk.com/..."))
    service.addContact(testPerson2, Contact.Address(122512u, "City1", "Street1", 15u))
    service.addContact(testPerson2, Contact.Address(122512u, "City1", "Street2", 15u))
    service.addContact(testPerson2, Contact.SocialLink("YOUTUBE", "youtube.com/..."))

    printSevice(service)
    println()
    service.getPersonPhones(testPerson).forEach { println(it) }
    println()
    service.getPersonPhones(testPerson2).forEach { println(it) }
    println()
    service.getPersonEmails(testPerson2).forEach { println(it) }
    println()
    service.getPersonLinks(testPerson2).forEach { println(it) }
    println()
    service.getPersonAddresses(testPerson2).forEach { println(it) }
    println()
    service.getAllContacts()[testPerson]?.let { service.removeContact(testPerson, it[1]) }
    println()
    printSevice(service)
}


fun printSevice(service: ContactsService) {
    service.getAllContacts().forEach {
        println(it.key)
        it.value.forEach { contact ->
            println(contact)
        }
    }
}