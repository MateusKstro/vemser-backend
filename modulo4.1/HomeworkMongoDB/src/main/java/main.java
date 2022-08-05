import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import org.bson.Document;

import java.util.Arrays;

import static com.mongodb.client.model.Aggregates.group;
import static com.mongodb.client.model.Aggregates.match;
import static java.util.Arrays.asList;

public class main {

    public static void main(String[] args) {

        String uri = "mongodb://root:root@localhost:27017/?authSource=admin&readPreference=primary&appname=MongoDB%20Compass&directConnection=true&ssl=false";
        MongoClient mongoClient = MongoClients.create(uri);

        MongoDatabase mongoDatabase = mongoClient.getDatabase("petshop");

        MongoCollection<Document> pets = mongoDatabase.getCollection("animal");
        MongoCollection<Document> clientes = mongoDatabase.getCollection("cliente");


        Document petCleiton = new Document("nome", "Cleiton")
                .append("id_animal", 4)
                .append("id_cliente", 4)
                .append("tipo", "gato")
                .append("raca", "Cinza")
                .append("pelagem", "Curto")
                .append("porte", "pequeno")
                .append("idade", 3)
                .append("cliente", new Document("id_cliente", 4)
                        .append("nome", "Jose")
                        .append("quantidade_pedido", 4)
                        .append("valor_pagamento", 250)
                        .append("email", "jose_email@gmail.com")
                        .append("id_usuario", 1));

        Document petRex = new Document("nome", "Rex")
                .append("id_animal", 5)
                .append("id_cliente", 5)
                .append("tipo", "cachorro")
                .append("raca", "Pitbull")
                .append("pelagem", "Curto")
                .append("porte", "Grande")
                .append("idade", 5)
                .append("cliente", new Document("id_cliente", 5)
                        .append("nome", "Aka Rasta")
                        .append("quantidade_pedido", 2)
                        .append("valor_pagamento", 85)
                        .append("email", "RastaTr@gmail.com")
                        .append("id_usuario", 5));

        Document petBoop = new Document("nome", "Boop")
                .append("id_animal", 7)
                .append("id_cliente", 7)
                .append("tipo", "cachorro")
                .append("raca", "Lhasa apsu")
                .append("pelagem", "Longo")
                .append("porte", "Pequeno")
                .append("idade", 9)
                .append("cliente", new Document("id_cliente", 6)
                        .append("nome", "Liz Paula")
                        .append("quantidade_pedido", 6)
                        .append("valor_pagamento", 450)
                        .append("email", "LizTtste@gmail.com")
                        .append("id_usuario", 6));

        //inserir um
//        pets.insertOne(petCleiton);


        //inserir varios
//        pets.insertMany(asList(petRex, petBoop));

        //find por nome
//        System.out.println("-- pets");
//        Document pet = pets.find(new Document("nome" , "Cleiton"))
//                .first();
//        System.out.println(pet);

        //find all
//        pets.find().forEach(System.out::println);

        //update
//        pets.updateOne(Filters.eq("nome", "Boop"), new Document("$set", new Document("nome", "Mel")));

        //update
//        pets.updateOne(Filters.lte("pelagem", "Curto"), new Document("$set", new Document("pelagem", "Medio")));

        //delete one
//        pets.deleteOne(Filters.eq("nome", "Cleiton"));

        //delete all
//        pets.deleteMany(new Document());


        //aggregate
//        clientes.aggregate(Arrays.asList(
//                match(Filters.eq("valor_pagamento", 300)),
//                group("$nome", Accumulators.sum("sumQuantity", "$id_usuario"))))
//                        .forEach(doc -> System.out.println(doc.toJson()));

//        clientes.aggregate(Arrays.asList(
//                        match(new Document("valor_pagamento", 300)
//                                .append("nome", new Document("$nin", Arrays.asList("Guile")))),
//                        group("$nome", Accumulators.sum("sumQuantity", "$id_usuario"))))
//                .forEach(doc -> System.out.println(doc.toJson()));


//        pets.find().projection(Projections.exclude("_id","nome","tipo","porte"))
//                        .iterator()
//                        .forEachRemaining(System.out::println);

//        clientes.find().projection(Projections.exclude("_id","nome","email","id_usuario"))
//                        .iterator()
//                        .forEachRemaining(System.out::println);

        mongoClient.close();
    }
}
