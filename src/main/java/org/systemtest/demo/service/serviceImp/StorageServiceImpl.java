package org.systemtest.demo.service.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.systemtest.demo.entity.Storage;
import org.systemtest.demo.mapper.StorageMapper;
import org.systemtest.demo.service.StorageService;

import java.util.List;

@Service
public class StorageServiceImpl implements StorageService {
    @Autowired
    StorageMapper storageMapper;

    @Override
    public List<Storage> getAllStorage() {
        return storageMapper.getAllStorage();
    }

    @Override
    public boolean isInserted(Storage storage) {
        return storageMapper.isInserted(storage);
    }

    @Override
    public boolean isAddStorage(Integer number, int id) {
        return storageMapper.isAddNumber(number,id);
    }

    @Override
    public boolean isSubStorage(Integer number, int id) {
        return storageMapper.isSubNumber(number,id);
    }

    @Override
    public boolean isDeleteStorage(int id) {
        return storageMapper.isDeleteStorage(id);
    }

    @Override
    public boolean isUpdateStorage(Integer number) {
        return storageMapper.isUpdateNumber(number);
    }
}
