package ua.goit.java.startup.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import ua.goit.java.startup.dto.ModelDTO;
/*
Interface that extend JPA Repository's methods
 */
public interface DataRepository<T extends ModelDTO>  extends JpaRepository<T, Long> {
}
