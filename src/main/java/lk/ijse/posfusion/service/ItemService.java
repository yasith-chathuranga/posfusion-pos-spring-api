package lk.ijse.posfusion.service;

import lk.ijse.posfusion.customObj.ItemResponse;
import lk.ijse.posfusion.dto.impl.ItemDTO;

import java.util.List;

public interface ItemService {
    void saveItem(ItemDTO itemDTO);
    void updateItem(String id, ItemDTO itemDTO);
    void deleteItem(String id);
    ItemResponse getSelectedItem(String id);
    List<ItemDTO> getAllItems();
}
