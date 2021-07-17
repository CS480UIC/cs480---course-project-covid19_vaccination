package com.covid.vaccination.repository;

import com.covid.vaccination.models.Receiver;
import com.covid.vaccination.models.Vaccine;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ReceiverRepository extends CrudRepository<Receiver,Integer> {

    String query1 = "select * from receiver";

    @Query(nativeQuery = true, value = query1)
    List<Receiver> getFromDatabase();

    String query2 = "insert into receiver values (?1,?2,?3,?4)";

    @Modifying
    @Query(nativeQuery = true, value = query2)
    void addTodatabse(String id, int user_id, int vaccine_id, int center_id);

    String query3 = "update receiver set user_id = ?2,center_id = ?3,vaccine_id = ?4 where id = ?1";

    @Modifying
    @Query(nativeQuery = true, value = query3)
    void updateDatabse(String id, int user_id, int center_id, int vaccine_id);

    String query4 = "delete from receiver where id = ?1";

    @Modifying
    @Query(nativeQuery = true, value = query4)
    void delete(String id);
}
