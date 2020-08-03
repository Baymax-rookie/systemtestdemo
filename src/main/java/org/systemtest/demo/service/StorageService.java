package org.systemtest.demo.service;

import org.systemtest.demo.entity.Storage;

import java.util.List;

/**
 * @author 12589
 */
public interface StorageService {

    public List<Storage> getAllStorage();

    public boolean isInserted(Storage storage);

    public boolean isAddStorage(Integer number,int id);

    public boolean isSubStorage(Integer number,int id);

    public boolean isDeleteStorage(int id);

    public boolean isUpdateStorage(Integer number);
}
