package learnSpringBoot.com.example.demo.controller

import learnSpringBoot.com.example.demo.entities.TodoEntity
import learnSpringBoot.com.example.demo.service.TodoService
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.web.bind.annotation.*

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

    @DeleteMapping("/delete/{id}")
    fun delete(
        @PathVariable("id") id: Long
    ): TodoEntity {
        val result = todoService.deleteById(id)
        return result.entity
    }
}