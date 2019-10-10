package s4.spring.td3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import s4.spring.td3.models.Todo;

public interface TodoRepository extends JpaRepository<Todo,Integer > {
}
