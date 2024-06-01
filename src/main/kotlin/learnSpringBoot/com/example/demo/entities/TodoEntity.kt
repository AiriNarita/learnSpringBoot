package learnSpringBoot.com.example.demo.entities

import org.seasar.doma.*

@Entity(immutable = true) // TODO:kotlinの時は絶対このimmutableをかく
@Table(name = "todos") //
data class TodoEntity(
    // DBの形と対
    @Id // unique idだよの定義、indexになる。
    @Column(name = "id") // TODO: 必要”
    @GeneratedValue(strategy = GenerationType.IDENTITY) // JPAエンティティの主キー値がどのように生成されるかを指定
    val id: Long? = null,
    val task: String,
    val completed: Boolean? = false
)
