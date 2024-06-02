package learnSpringBoot.com.example.demo.controller

import learnSpringBoot.com.example.demo.entities.TodoEntity
import learnSpringBoot.com.example.demo.service.TodoService
import org.springframework.web.bind.annotation.*

/**
 * Todoのコントローラー
 * @param todoService Todoのサービス
 */
@RestController //TODO: ここももう少し
@RequestMapping("/todos") // TODO:ここも
class TodoController(
    private val todoService: TodoService
) {

    /**
     * 一覧取得
     * @return List<TodoEntity> TodoEntityのリスト
     */
    @GetMapping("")
    fun selectAll():List<TodoEntity>{
        return todoService.selectAll()
    }

    /**
     * 新規登録
     * @param todoEntity TodoEntity
     * @return TodoEntity   登録したTodoEntity
     */
    @PostMapping("")
    fun insert(
        @RequestBody todoEntity: TodoEntity
    ): TodoEntity {
        val result = todoService.insert(todoEntity)
        if(result.entity == null) throw Exception("Failed to insert")
        return result.entity
    }

    /**
     * 削除
     * @param id Long
     * @return TodoEntity 削除したTodoEntity
     */
    @DeleteMapping("/delete/{id}")
    fun delete(
        @PathVariable("id") id: Long
    ): TodoEntity {
        val result = todoService.deleteById(id)
        return result.entity
    }

    /**
     * ステータス更新
     * @param id Long
     * @return Int 更新した件数
     */
    @PutMapping("/update/{id}") //TODO:updateはput
    fun updateStatus(
        @PathVariable("id") id: Long
    ): Int{
        val result = todoService.updateStatus(id)
        if(result == null) throw Exception("Failed to insert")
        return result
    }
}