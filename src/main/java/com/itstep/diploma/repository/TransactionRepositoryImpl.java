package com.itstep.diploma.repository;

import com.itstep.diploma.model.Transaction;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionRepositoryImpl implements TransactionRepository {

    @Override
    public List<Transaction> findAll() {
        return null;
    }

    @Override
    public List<Transaction> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Transaction> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Transaction> findAllById(Iterable<Integer> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Transaction transaction) {

    }

    @Override
    public void deleteAll(Iterable<? extends Transaction> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Transaction> S save(S s) {
        return null;
    }

    @Override
    public <S extends Transaction> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Transaction> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Transaction> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Transaction> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Transaction getOne(Integer integer) {
        return null;
    }

    @Override
    public <S extends Transaction> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Transaction> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Transaction> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Transaction> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Transaction> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Transaction> boolean exists(Example<S> example) {
        return false;
    }
}
