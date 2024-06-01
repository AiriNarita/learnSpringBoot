package learnSpringBoot.com.example.demo.entities

import org.seasar.doma.Entity
import org.seasar.doma.GeneratedValue
import org.seasar.doma.GenerationType
import org.seasar.doma.Id
import org.seasar.doma.Table

@Entity(immutable = true) // TODO:kotlinの時は絶対このimmutableをかく
@Table(name = "todos") //
data class TodoEntity(
    // DBの形と対
    @Id // unique idだよの定義、indexになる。
    @GeneratedValue(strategy = GenerationType.IDENTITY) // JPAエンティティの主キー値がどのように生成されるかを指定
    val id: Long? = null,
    val task: String,
    val completed: Boolean? = false
)
