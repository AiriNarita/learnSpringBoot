package learnSpringBoot.com.example.demo.dao

import learnSpringBoot.com.example.demo.entities.TodoEntity
import org.seasar.doma.*
import org.seasar.doma.boot.ConfigAutowireable
import org.seasar.doma.jdbc.Result
import org.springframework.transaction.annotation.Transactional

@Dao
@ConfigAutowireable
@Transactional
public interface TodoDao {
    @Select
    fun selectAll():List<TodoEntity>

    @Insert
    fun insert(todoEntity: TodoEntity):Result<TodoEntity>

    @Select
    fun findById(id: Long): TodoEntity?
    @Delete
    fun deleteByEntity(todoEntity: TodoEntity): Result<TodoEntity>
}