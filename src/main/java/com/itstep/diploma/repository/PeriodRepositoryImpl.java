package com.itstep.diploma.repository;

import com.itstep.diploma.model.Period;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeriodRepositoryImpl implements PeriodRepository {
    @Override
    public List<Period> findAll() {
        return null;
    }

    @Override
    public List<Period> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Period> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Period> findAllById(Iterable<Integer> iterable) {
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
    public void delete(Period period) {

    }

    @Override
    public void deleteAll(Iterable<? extends Period> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Period> S save(S s) {
        return null;
    }

    @Override
    public <S extends Period> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Period> findById(Integer integer) {
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
    public <S extends Period> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Period> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Period getOne(Integer integer) {
        return null;
    }

    @Override
    public <S extends Period> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Period> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Period> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Period> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Period> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Period> boolean exists(Example<S> example) {
        return false;
    }
}
