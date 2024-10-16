package lk.ijse.posfusion.service;

import lk.ijse.posfusion.customObj.ItemErrorResponse;
import lk.ijse.posfusion.customObj.ItemResponse;
import lk.ijse.posfusion.dao.ItemDao;
import lk.ijse.posfusion.dto.impl.ItemDTO;
import lk.ijse.posfusion.entity.ItemEntity;
import lk.ijse.posfusion.exception.DataPersistFailedException;
import lk.ijse.posfusion.exception.ItemNotFoundException;
import lk.ijse.posfusion.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ItemServiceImpl implements ItemService{
    @Autowired
    private ItemDao itemDao;

    @Autowired
    private Mapping mapping;
    @Override
    public void saveItem(ItemDTO itemDTO) {
        ItemEntity savedItem = itemDao.save(mapping.convertToItemEntity(itemDTO));
        if(savedItem == null) {
            throw new DataPersistFailedException("Cannot data saved");
        }
    }

    @Override
    public void updateItem(String id, ItemDTO incomeItemDTO) {
        Optional<ItemEntity> tmpItemEntity = itemDao.findById(id);
        if (!tmpItemEntity.isPresent()){
            throw new ItemNotFoundException("Item not found");
        }else {
            tmpItemEntity.get().setName(incomeItemDTO.getName());
            tmpItemEntity.get().setQty(incomeItemDTO.getQty());
            tmpItemEntity.get().setPrice(incomeItemDTO.getPrice());
        }
    }

    @Override
    public void deleteItem(String id) {
        Optional<ItemEntity> findId = itemDao.findById(id);
        if (!findId.isPresent()){
            throw new ItemNotFoundException("Item not found");
        }else {
            itemDao.deleteById(id);
        }
    }

    @Override
    public ItemResponse getSelectedItem(String id) {
        if (itemDao.existsById(id)){
            return mapping.convertToItemDTO(itemDao.getReferenceById(id));
        }else {
            return new ItemErrorResponse(0,"Item not found");
        }
    }

    @Override
    public List<ItemDTO> getAllItems() {
        return mapping.convertItemToDTOList(itemDao.findAll());
    }
}
