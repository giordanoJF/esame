package org.example;
import java.util.Scanner;

public class Main {
    private static AddressBook addressBook = new AddressBook();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean quit = false;

        while (!quit) {
            System.out.println("Seleziona un'opzione:");
            System.out.println("1 - Aggiungi contatto");

            System.out.println("2 - Cerca contatto per nome");
            System.out.println("3 - Cerca contatto per numero di telefono");
            System.out.println("4 - Visualizza tutti i contatti");
            System.out.println("5 - Cancella contatto");
            System.out.println("6 - Esci");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    searchByName();
                    break;
                case 3:
                    searchByPhone();
                    break;
                case 4:
                    displayContacts();
                    break;
                case 5:
                    removeContact();
                    break;
                case 6:
                    quit = true;
                    break;
                default:
                    System.out.println("Opzione non valida");
                    break;
            }
        }
    }

    private static void addContact() {
        System.out.print("Inserisci il nome del contatto: ");
        String nome = scanner.nextLine();

        System.out.print("Inserisci il cognome del contatto: ");
        String cognome = scanner.nextLine();

        System.out.print("Inserisci il numero di telefono del contatto: ");
        String telefono = scanner.nextLine();

        System.out.print("Inserisci l'indirizzo email del contatto: ");
        String email = scanner.nextLine();

        Contact contact = new Contact(nome, cognome, telefono, email);
        addressBook.addContact(contact);
    }

    private static void searchByName() {
        System.out.print("Inserisci il nome del contatto da cercare: ");
        String nome = scanner.nextLine();

        Contact contact = addressBook.searchByName(nome);

        if (contact == null) {
            System.out.println("Nessun contatto trovato con il nome " + nome);
        } else {
            System.out.println(contact.getNome() + " " + contact.getCognome());
            System.out.println("Numero di telefono: " + contact.getTelefono());
            System.out.println("Indirizzo email: " + contact.getEmail());
        }
    }

    private static void searchByPhone() {
        System.out.print("Inserisci il numero di telefono del contatto da cercare: ");
        String telefono = scanner.nextLine();

        Contact contact = addressBook.searchByPhone(telefono);

        if (contact == null) {
            System.out.println("Nessun contatto trovato con il numero di telefono " + telefono);
        } else {
            System.out.println(contact.getNome() + " " + contact.getCognome());
            System.out.println("Numero di telefono: " + contact.getTelefono());
            System.out.println("Indirizzo email: " + contact.getEmail());
        }
    }

    private static void removeContact() {
        System.out.print("Inserisci il nome del contatto da rimuovere: ");
        String nome = scanner.nextLine();

        Contact contact = addressBook.searchByName(nome);

        if (contact == null) {
            System.out.println("Nessun contatto trovato con il nome " + nome);
        } else {
            addressBook.removeContact(contact);
            System.out.println("Contatto rimosso correttamente");
        }
    }

    private static void displayContacts() {
        System.out.println("Elenco contatti:");

        for (Contact contact : addressBook.getAllContacts()) {
            System.out.println(contact.getNome() + " " + contact.getCognome());
            System.out.println("Numero di telefono: " + contact.getTelefono());
            System.out.println("Indirizzo email: " + contact.getEmail());
            System.out.println("--------------------------");
        }
    }
}
