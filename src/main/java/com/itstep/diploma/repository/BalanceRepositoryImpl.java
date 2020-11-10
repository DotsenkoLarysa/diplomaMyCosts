package com.itstep.diploma.repository;

import com.itstep.diploma.model.Balance;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BalanceRepositoryImpl implements BalanceRepository {
    @Override
    public <S extends Balance> S save(S s) {
        return null;
    }

    @Override
    public Optional<Balance> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<Balance> findAll() {
        return null;
    }

    @Override
    public List<Balance> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Balance> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Balance> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public <S extends Balance> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Balance> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Balance> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Balance getOne(Long aLong) {
        return null;
    }

    @Override
    public <S extends Balance> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Balance> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Balance> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Balance> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Balance> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Balance> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Balance balance) {

    }

    @Override
    public void deleteAll(Iterable<? extends Balance> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
