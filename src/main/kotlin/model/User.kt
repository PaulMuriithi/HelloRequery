package model

import io.requery.*

@Entity
@Table(name = "users")
interface User : Persistable {

    @get:Key
    @get:Generated
    var id: Int

    var name: String

    var email: String
}