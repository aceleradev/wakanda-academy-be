package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.DemoEntity;

@Repository
public interface DemoRepository extends JpaRepository<DemoEntity, Long> {

}
