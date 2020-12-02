package com.itstep.diploma.service;

import com.itstep.diploma.dto.JournalsCreationDTO;
import com.itstep.diploma.model.Category;
import com.itstep.diploma.model.Journal;
import com.itstep.diploma.model.Transaction;
import com.itstep.diploma.model.User;
import com.itstep.diploma.repository.JournalRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JournalService {

    private final JournalRepository journalRepository;

    public JournalService(JournalRepository journalRepository) {
        this.journalRepository = journalRepository;
    }

    public List<Journal> listAll() {
        return journalRepository.findAll();
    }

    public void save(Journal journal) {
        Journal journalNew = new Journal();
        Date date = journal.getEvent_date();
        journalNew.setEvent_date(date);
        journalNew.setEvent_sum(journal.getEvent_sum());
        journalNew.setDescription(journal.getDescription());
        Category category = journal.getCategory();
        journalNew.setCategory(category);
        User user = journal.getUser();
        journalNew.setUser(user);
        Transaction tran = journal.getTransaction();
        journalNew.setTransaction(tran);
        this.journalRepository.save(journalNew);
    }

    public Journal get(Long id) {
        Optional<Journal> optional = journalRepository.findById(id);

        if (optional.isPresent()) {
          return  optional.get();
        } else {
            throw new RuntimeException("Journal not found for id : " + id);
        }
    }

    public void delete(Long id) {
        this.journalRepository.deleteById(id);
    }

    public List<JournalsCreationDTO> getAllJournal() {
        return journalRepository
                .findAll()
                .stream()
                .map(this::convertToJournalsCreationDto)
                .collect(Collectors.toList());
    }

    private JournalsCreationDTO convertToJournalsCreationDto(Journal journal) {
        if (journal.getCategory() != null) {
            JournalsCreationDTO journalsCreationDto = new JournalsCreationDTO();
            journalsCreationDto.setEvent_date(journal.getEvent_date());
            journalsCreationDto.setEvent_sum(journal.getEvent_sum());
            journalsCreationDto.setDescription(journal.getDescription());
            Category category1 = journal.getCategory();
            journalsCreationDto.setCategory_id(category1.getCategory_id());
            User user1 = journal.getUser();
            journalsCreationDto.setUser_id(user1.getUser_id());
            Transaction transaction1 = journal.getTransaction();
            journalsCreationDto.setTransaction_id(transaction1.getTransaction_id());
            return journalsCreationDto;
        } else return null;
    }

}
