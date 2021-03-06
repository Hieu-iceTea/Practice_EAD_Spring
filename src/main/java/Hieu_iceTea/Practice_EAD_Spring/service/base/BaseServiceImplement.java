package Hieu_iceTea.Practice_EAD_Spring.service.base;


import Hieu_iceTea.Practice_EAD_Spring.model.BaseModel;
import Hieu_iceTea.Practice_EAD_Spring.repository.BaseRepository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;


public class BaseServiceImplement<T extends BaseModel, ID extends Serializable> implements BaseService<T, ID> {

    private final BaseRepository<T, ID> repository;

    public BaseServiceImplement(BaseRepository<T, ID> repository) {
        this.repository = repository;
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public List<T> findAllByOrderByIdDesc() {
        return repository.findAllByOrderByIdDesc();
    }

    @Override
    public T findById(ID id) {
        Optional<T> itemOptional = repository.findById(id);

        T item;

        if (itemOptional.isPresent()) {
            item = itemOptional.get();
        } else {
            throw new RuntimeException("Did not find item id - " + id);
        }

        return item;
    }

    @Override
    public T save(T item) {
        return repository.save(item);
    }

    @Override
    public List<T> saveAll(List<T> items) {
        return (List<T>) repository.saveAll(items);
    }

    @Override
    public void deleteById(ID id) {
        repository.deleteById(id);
    }

}
