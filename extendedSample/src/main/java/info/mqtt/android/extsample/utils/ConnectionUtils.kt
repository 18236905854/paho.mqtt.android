package info.mqtt.android.extsample.utils

import android.content.Context
import info.mqtt.android.extsample.activity.Action
import info.mqtt.android.extsample.activity.ActionListener
import info.mqtt.android.extsample.activity.Connection
import info.mqtt.android.extsample.activity.MqttCallbackHandler
import info.mqtt.android.extsample.room.AppDatabase
import info.mqtt.android.extsample.room.entity.ConnectionEntity
import org.eclipse.paho.client.mqttv3.MqttConnectOptions

fun Connection.connect(context: Context) {
    val actionArgs = arrayOfNulls<String>(1)
    actionArgs[0] = this.id
    val callback = ActionListener(context, Action.CONNECT, this, *actionArgs)
    this.client.setCallback(MqttCallbackHandler(context, this.handle()))
    this.client.connect(this.connectionOptions, null, callback)
}

fun Boolean.toInt() = if (this) 1 else 0

fun Int.toBoolean() = this == 1

fun ConnectionEntity.toConnection(context: Context): Connection {
    //rebuild objects starting with the connect options
    val connectOptions = MqttConnectOptions()
    connectOptions.isCleanSession = cleanSession.toBoolean()
    connectOptions.keepAliveInterval = keepAlive
    connectOptions.connectionTimeout = timeout
    connectOptions.password = userPass?.toCharArray() ?: "".toCharArray()
    connectOptions.userName = userName
    this.topic?.let {
        connectOptions.setWill(it, message.toByteArray(), qos, retrained.toBoolean())
    }

    val connection = Connection.createConnection(
        clientHandle, clientId, host,
        port, context, ssl.toBoolean(),
        connectOptions
    )

    // Now we recover all subscriptions for this connection
    connection.setSubscriptions(AppDatabase.getDatabase(context).subscriptionDao().all.map { it.toSubscription() })
    return connection
}

fun Connection.toConnectionEntity(): ConnectionEntity = ConnectionEntity(
    handle(),
    hostName,
    id,
    port,
    isSSL,
    connectionOptions.connectionTimeout,
    connectionOptions.keepAliveInterval,
    connectionOptions.userName,
    connectionOptions.password?.toString(),
    connectionOptions.isCleanSession.toInt(),
    connectionOptions.willDestination,
    connectionOptions.willMessage?.payload.toString(), // message
    connectionOptions.willMessage?.qos ?: 0,
    connectionOptions.willMessage?.isRetained?.toInt() ?: 0
)
