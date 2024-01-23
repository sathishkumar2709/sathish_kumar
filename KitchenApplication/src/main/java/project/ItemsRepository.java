package ProjectKitchen.Kitchen.ItemsRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import ProjectKitchen.Kitchen.Items.Items;

public interface ItemsRepository extends JpaRepository<Items,Integer> {

}
