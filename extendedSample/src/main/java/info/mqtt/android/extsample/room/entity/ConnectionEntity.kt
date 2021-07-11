package info.mqtt.android.extsample.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ConnectionEntity(
    @PrimaryKey var clientHandle: String,
    val host: String,
    val clientId: String,
    val port: Int,
    val ssl: Int,
    val timeout: Int,
    val keepAlive: Int,
    val userName: String?,
    val userPass: String?,
    val cleanSession: Int,
    val topic: String?,
    val message: String,
    val qos: Int,
    val retrained: Int
)
