package learnSpringBoot.com.example.demo.service

import learnSpringBoot.com.example.demo.dao.TodoDao
import learnSpringBoot.com.example.demo.entities.TodoEntity
import org.springframework.stereotype.Service
import org.seasar.doma.jdbc.Result
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException

@Service
class TodoService(
    private val todoDao: TodoDao // @Autowiredと同義な事してるヨ
) {

    /**
     * 一覧取得
     */
    fun selectAll(): List<TodoEntity> {
        return todoDao.selectAll();
    }

    /**
     * 新規登録
     */
    fun insert(todoEntity: TodoEntity): Result<TodoEntity>{
        return todoDao.insert(todoEntity)
    }

    /**
     * ID検索
     */
    fun findById(id: Long): TodoEntity {
        val foundTodo = todoDao.findById(id)
        return foundTodo?: throw NotFoundException()
    }

    /**
     * 削除
     */
    fun deleteById(id: Long): Result<TodoEntity>{
        val foundTodo = findById(id)
        return todoDao.deleteByEntity(foundTodo)
    }

    /**
     * ステータス更新
     */
    fun updateStatus(id: Long):Int{
        val foundTodo = findById(id)
        val changedStatus = !(foundTodo.completed)!!
        return todoDao.updateStatus(id, changedStatus)
    }
}
