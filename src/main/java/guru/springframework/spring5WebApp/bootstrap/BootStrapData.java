package guru.springframework.spring5WebApp.bootstrap;

import guru.springframework.spring5WebApp.domain.Author;
import guru.springframework.spring5WebApp.domain.Book;
import guru.springframework.spring5WebApp.domain.Publisher;
import guru.springframework.spring5WebApp.repositories.AuthorRepository;
import guru.springframework.spring5WebApp.repositories.BookRepository;
import guru.springframework.spring5WebApp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "1234");
        eric.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rowling = new Author("JK", "Rowling");
        Book hp = new Book("Harry Potter", "324234");
        rowling.getBooks().add(hp);

        authorRepository.save(rowling);
        bookRepository.save(hp);

        Publisher sub = new Publisher("Subham", "Navneet Vihar", "Ghaziabad", "UP", "201309");


        ddd.setPublisher(sub);
        sub.getBooks().add(ddd);

        hp.setPublisher(sub);
        sub.getBooks().add(hp);



        publisherRepository.save(sub);

        System.out.println("Started Boot strap");
        System.out.println("Book count " + bookRepository.count());
        System.out.println("Publisher count = " + publisherRepository.count());

    }
}
