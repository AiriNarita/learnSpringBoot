package learnSpringBoot.com.example.demo.dao

import learnSpringBoot.com.example.demo.entities.TodoEntity
import org.seasar.doma.Dao
import org.seasar.doma.Select
import org.seasar.doma.boot.ConfigAutowireable
import org.springframework.transaction.annotation.Transactional

@Dao
@ConfigAutowireable
@Transactional
public interface TodoDao {
    @Select
    fun selectAll():List<TodoEntity>

}