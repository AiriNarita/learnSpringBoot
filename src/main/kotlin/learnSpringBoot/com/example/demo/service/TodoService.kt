package learnSpringBoot.com.example.demo.service

import learnSpringBoot.com.example.demo.dao.TodoDao
import org.seasar.doma.Id
import org.springframework.stereotype.Service

@Service
class TodoService(
    private val todoDao: TodoDao // @Autowiredと同義な事してるヨ
) {

    fun selectAll(){

    }

}
