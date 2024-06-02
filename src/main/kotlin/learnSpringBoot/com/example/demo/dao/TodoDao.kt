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
    /**
     * 一覧取得
     */
    @Select
    fun selectAll():List<TodoEntity>

    /**
     * 新規登録
     */
    @Insert
    fun insert(todoEntity: TodoEntity):Result<TodoEntity>

    /**
     * ID検索
     */
    @Select
    fun findById(id: Long): TodoEntity?

    /**
     * 削除
     */
    @Delete
    fun deleteByEntity(todoEntity: TodoEntity): Result<TodoEntity>

    /**
     * ステータス更新
     */
    @Update(sqlFile = true)
    fun updateStatus(id: Long, completed: Boolean): Int
}