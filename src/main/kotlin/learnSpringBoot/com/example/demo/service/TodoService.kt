package learnSpringBoot.com.example.demo.service

import learnSpringBoot.com.example.demo.dao.TodoDao
import learnSpringBoot.com.example.demo.entities.TodoEntity
import org.springframework.stereotype.Service
import org.seasar.doma.jdbc.Result

@Service
class TodoService(
    private val todoDao: TodoDao // @Autowiredと同義な事してるヨ
) {

    fun selectAll(): List<TodoEntity> {
        return todoDao.selectAll();
    }

    fun insert(todoEntity: TodoEntity): Result<TodoEntity>{
        return todoDao.insert(todoEntity)
    }
}
