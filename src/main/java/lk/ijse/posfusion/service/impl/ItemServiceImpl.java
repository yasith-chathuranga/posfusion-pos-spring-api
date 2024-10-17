package lk.ijse.posfusion.service.impl;

import lk.ijse.posfusion.customObj.impl.ItemErrorResponse;
import lk.ijse.posfusion.customObj.ItemResponse;
import lk.ijse.posfusion.repository.ItemRepository;
import lk.ijse.posfusion.dto.impl.ItemDTO;
import lk.ijse.posfusion.entity.impl.ItemEntity;
import lk.ijse.posfusion.exception.DataPersistFailedException;
import lk.ijse.posfusion.exception.ItemNotFoundException;
import lk.ijse.posfusion.service.ItemService;
import lk.ijse.posfusion.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private Mapping mapping;
    @Override
    public void saveItem(ItemDTO itemDTO) {
        ItemEntity savedItem = itemRepository.save(mapping.convertToItemEntity(itemDTO));
        if(savedItem == null) {
            throw new DataPersistFailedException("Cannot data saved");
        }
    }

    @Override
    public void updateItem(String id, ItemDTO incomeItemDTO) {
        Optional<ItemEntity> tmpItemEntity = itemRepository.findById(id);
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
        Optional<ItemEntity> findId = itemRepository.findById(id);
        if (!findId.isPresent()){
            throw new ItemNotFoundException("Item not found");
        }else {
            itemRepository.deleteById(id);
        }
    }

    @Override
    public ItemResponse getSelectedItem(String id) {
        if (itemRepository.existsById(id)){
            return mapping.convertToItemDTO(itemRepository.getReferenceById(id));
        }else {
            return new ItemErrorResponse(0,"Item not found");
        }
    }

    @Override
    public List<ItemDTO> getAllItems() {
        return mapping.convertItemToDTOList(itemRepository.findAll());
    }
}
