package learnSpringBoot.com.example.demo.controller

import learnSpringBoot.com.example.demo.entities.TodoEntity
import learnSpringBoot.com.example.demo.service.TodoService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController //TODO: ここももう少し
@RequestMapping("/todos") // TODO:ここも
class TodoController(
    private val todoService: TodoService
) {

    @GetMapping("")
    fun selectAll():List<TodoEntity>{
        return todoService.selectAll()
    }

    @PostMapping("")
    fun insert(
        @RequestBody todoEntity: TodoEntity
    ): TodoEntity {
        val result = todoService.insert(todoEntity)
        if(result.entity == null) throw Exception("Failed to insert")
        return result.entity
    }
}