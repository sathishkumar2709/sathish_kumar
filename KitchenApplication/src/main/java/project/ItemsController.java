package ProjectKitchen.Kitchen.ItemsController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ProjectKitchen.Kitchen.Items.Items;
import ProjectKitchen.Kitchen.ItemsService.ItemsService;

@Controller
@RequestMapping("/items")
public class ItemsController {

	    @Autowired
	    private ItemsService itemsService;

	    @GetMapping
	    public String listItems(Model model) {
	        List<Items> items = itemsService.getAllItems();
	        model.addAttribute("items",items);
	        return "items/list";
	    }

	    @GetMapping("/{id}")
	    public String viewItems(@PathVariable Integer id, Model model) {
	    	Items items = itemsService.getItemsById(id);
	        model.addAttribute("items", items);
	        return "items/view";
	    }

	    @GetMapping("/create")
	    public String showCreateForm(Model model) {
	        model.addAttribute("items", new Items());
	        return "product/create";
	    }

	    @PostMapping("/create")
	    public String createItems(@ModelAttribute Items items) {
	        itemsService.saveItems(items);
	        return "redirect:/items";
	    }

	    @GetMapping("/update/{id}")
	    public String showUpdateForm(@PathVariable Integer id, Model model) {
	        Items items = itemsService.getItemsById(id);
	        model.addAttribute("items", items);
	        return "items/update";
	    }

	    @PostMapping("/update")
	    public String updateProduct(@ModelAttribute Items items) {
	        itemsService.saveItems(items);
	        return "redirect:/items";
	    }

	    @GetMapping("/delete/{id}")
	    public String deleteItems(@PathVariable Integer id) {
	        itemsService.deleteItems(id);
	        return "redirect:/items";
	    }
	}


