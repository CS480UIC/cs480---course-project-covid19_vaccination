package com.covid.vaccination.service;

import com.covid.vaccination.models.Receiver;
import com.covid.vaccination.repository.ReceiverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ReceiverService {

    @Autowired
    private ReceiverRepository receiverRepository;

    public List<Receiver> getAllReceivers() {
        return receiverRepository.getFromDatabase();
    }

    @Transactional
    public void addReceiver(Receiver receiver) {
        receiverRepository.addTodatabse(receiver.getId(),receiver.getUser_id(),receiver.getVaccine_id(),receiver.getCenter_id());
    }

    @Transactional
    public void updateReceiver(Receiver receiver,String id) {

        receiverRepository.updateDatabse(id,receiver.getUser_id(),receiver.getCenter_id(),receiver.getVaccine_id());
    }

    @Transactional
    public void deleteReceiver(String id) {
        receiverRepository.delete(id);
    }
}
