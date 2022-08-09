package veiculoprodutorconsumidor.repository;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import veiculoprodutorconsumidor.entity.SensorVeiculoEntity;

@Repository
public interface SensorVeiculoRepository extends MongoRepository<SensorVeiculoEntity, String> {

    @Aggregation(pipeline = {
            "{'$group':{ '_id': 'null', 'sum': {'$sum': $velocidade} }}"
    })
    public Double findVelocidadeTotal();

    @Aggregation(pipeline = {
            "{'$group':{ '_id': 'null', 'sum': {'$sum': $rotacao} }}"
    })
    public Double findRotacaoTotal();
}
