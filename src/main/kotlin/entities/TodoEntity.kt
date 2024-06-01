package entities

import org.seasar.doma.Entity
import org.seasar.doma.GeneratedValue
import org.seasar.doma.GenerationType
import org.seasar.doma.Id

@Entity
data class TodoEntity(
    // DBの形と対
    @Id // unique idだよの定義、indexになる。
    @GeneratedValue(strategy = GenerationType.IDENTITY) // JPAエンティティの主キー値がどのように生成されるかを指定
    val id: Long? = null,
    val task: String,
    val completed: Boolean? = false
)
