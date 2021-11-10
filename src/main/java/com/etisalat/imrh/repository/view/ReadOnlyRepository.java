package com.etisalat.imrh.repository.view;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;
import java.util.List;
import java.util.Optional;

/**
 * @author Nabeel Ahmed
 */
@NoRepositoryBean
public interface ReadOnlyRepository<T, ID> extends Repository<T, ID> {

    public List<T> findAll();

    public List<T> findAll(Sort sort);

    public Page<T> findAll(Pageable pageable);

    public Optional<T> findById(ID id);

    public long count();

}