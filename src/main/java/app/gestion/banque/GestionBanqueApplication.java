package app.gestion.banque;

import app.gestion.banque.entities.Client;
import app.gestion.banque.entities.Fournisseur;
import app.gestion.banque.repositories.ClientRepository;
import app.gestion.banque.repositories.FournisseurRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
public class GestionBanqueApplication implements CommandLineRunner {

   @Autowired
    ClientRepository clientRepository;
   @Autowired
   FournisseurRepository fournisseurRepository;

    public static void main(String[] args) {
        SpringApplication.run(GestionBanqueApplication.class, args);
    }

    /**
     * Callback used to run the bean.
     *
     * @param args incoming main method arguments
     * @throws Exception on error
     */
    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker();
        for (int i = 0; i < 100; i++) {
            Client client = new Client();
            Fournisseur f = new Fournisseur();
            client.setCodeClient((UUID.randomUUID()).getLeastSignificantBits());
            client.setNomClient(faker.name().firstName());
            client.setAdresseClient(String.valueOf(faker.address().cityName()));

            f.setId(UUID.randomUUID().getLeastSignificantBits());
            f.setName(faker.name().name());
            f.setAddress(faker.address().cityName());
            f.setEmail(faker.bothify("????##@gmail.com"));

            this.clientRepository.save(client);
            this.fournisseurRepository.save(f);
        }
    }
}