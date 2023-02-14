package org.example;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {
    private static AddressBook addressBook = new AddressBook();
    private static Scanner scanner = new Scanner(System.in);
    public static final String NUMERO_DI_TELEFONO = "numero di telefono: ";
    public static final String INDIRIZZO_EMAIL = "Indirizzo email: ";
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        boolean quit = false;

        while (!quit) {
            logger.log(Level.INFO,"Seleziona un'opzione:");
            logger.log(Level.INFO,"1 - Aggiungi contatto");

            logger.log(Level.INFO,"2 - Cerca contatto per nome");
            logger.log(Level.INFO,"3 - Cerca contatto per numero di telefono");
            logger.log(Level.INFO,"4 - Visualizza tutti i contatti");
            logger.log(Level.INFO,"5 - Cancella contatto");
            logger.log(Level.INFO,"6 - Esci");

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
                    logger.log(Level.INFO,"Opzione non valida");
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
            logger.log(Level.INFO,"Nessun contatto trovato con il nome " + nome);
        } else {
            logger.log(Level.INFO,contact.getNome() + " " + contact.getCognome());
            logger.log(Level.INFO,NUMERO_DI_TELEFONO + contact.getTelefono());
            logger.log(Level.INFO,INDIRIZZO_EMAIL + contact.getEmail());
        }
    }

    private static void searchByPhone() {
        System.out.print("Inserisci il numero di telefono del contatto da cercare: ");
        String telefono = scanner.nextLine();

        Contact contact = addressBook.searchByPhone(telefono);

        if (contact == null) {
            logger.log(Level.INFO,"Nessun contatto trovato con il numero di telefono " + telefono);
        } else {
            logger.log(Level.INFO,contact.getNome() + " " + contact.getCognome());
            logger.log(Level.INFO,NUMERO_DI_TELEFONO + contact.getTelefono());
            logger.log(Level.INFO,INDIRIZZO_EMAIL + contact.getEmail());
        }
    }

    private static void removeContact() {
        System.out.print("Inserisci il nome del contatto da rimuovere: ");
        String nome = scanner.nextLine();

        Contact contact = addressBook.searchByName(nome);

        if (contact == null) {
            logger.log(Level.INFO,"Nessun contatto trovato con il nome " + nome);
        } else {
            addressBook.removeContact(contact);
            logger.log(Level.INFO,"Contatto rimosso correttamente");
        }
    }

    private static void displayContacts() {
        logger.log(Level.INFO,"Elenco contatti:");

        for (Contact contact : addressBook.getAllContacts()) {
            logger.log(Level.INFO,contact.getNome() + " " + contact.getCognome());
            logger.log(Level.INFO,NUMERO_DI_TELEFONO + contact.getTelefono());
            logger.log(Level.INFO,INDIRIZZO_EMAIL+ contact.getEmail());
            logger.log(Level.INFO,"--------------------------");
        }
    }
}
