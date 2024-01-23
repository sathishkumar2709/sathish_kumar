package ProjectKitchen.Kitchen.ItemsService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ProjectKitchen.Kitchen.Items.Items;
import ProjectKitchen.Kitchen.ItemsRepository.ItemsRepository;

@Service
public class ItemsService {
	
	    @Autowired
	    private ItemsRepository productRepository;

	    public List<Items> getAllItems() {
	        return productRepository.findAll();
	    }

	    public Items getItemsById(Integer id) {
	        return productRepository.findById(id).orElse(null);
	    }

	    public void saveItems(Items item) {
	        productRepository.save(item);
	    }

	    public void deleteItems(Integer id) {
	        productRepository.deleteById(id);
	    }
	
}
