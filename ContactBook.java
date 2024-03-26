public class ContactBook {
    private Node head;

    public ContactBook() {
        head = null;
    }

    public void addContact(Contact contact) {
        Node newNode = new Node(contact);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        System.out.println("Contact added successfully!");
    }

    public void printList() {
        Node temp = head;
        System.out.println("Contacts List:");
        while (temp != null) {
            System.out.println("Name: " + temp.contact.name + ", Phone: " + temp.contact.phoneNumber + ", Email: " + temp.contact.email);
            temp = temp.next;
        }
    }

    public void deleteContact(String name) {
        if (head == null) {
            System.out.println("Contact list is empty.");
            return;
        }
        if (head.contact.name.equals(name)) {
            head = head.next;
            System.out.println("Contact deleted successfully!");
            return;
        }
        Node prev = head;
        Node current = head.next;
        while (current != null) {
            if (current.contact.name.equals(name)) {
                prev.next = current.next;
                System.out.println("Contact deleted successfully!");
                return;
            }
            prev = current;
            current = current.next;
        }
        System.out.println("Contact not found!");
    }

    public void searchContact(String name) {
        Node temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.contact.name.equalsIgnoreCase(name)) {
                found = true;
                System.out.println("Name: " + temp.contact.name + ", Phone: " + temp.contact.phoneNumber + ", Email: " + temp.contact.email);
            }
            temp = temp.next;
        }
        if (!found)
            System.out.println("Contact not found!");
    }

    public void searchByEmail(String email) {
        Node temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.contact.email.equalsIgnoreCase(email)) {
                found = true;
                System.out.println("Name: " + temp.contact.name + ", Phone: " + temp.contact.phoneNumber + ", Email: " + temp.contact.email);
            }
            temp = temp.next;
        }
        if (!found)
            System.out.println("Contact with email " + email + " not found!");
    }
}
