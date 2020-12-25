[![](https://jitpack.io/v/hannesa2/paho.mqtt.android.svg)](https://jitpack.io/#hannesa2/paho.mqtt.android)
# Paho Android Service


The Paho Android Service is an MQTT client library written in Java for developing applications on Android.
It has been created to provide reliable open-source implementations of open and standard messaging protocols aimed at new, existing, and emerging
applications for Machine-to-Machine (M2M) and Internet of Things (IoT).
Paho reflects the inherent physical and cost constraints of device connectivity. Its objectives include effective levels of decoupling between devices and applications, designed to keep markets open and encourage the rapid growth of scalable Web and Enterprise middleware and applications.


## Features
|                     |                    |   |                      |                    |
|---------------------|--------------------|---|----------------------|--------------------|
| MQTT 3.1            | :heavy_check_mark: |   | Automatic Reconnect  | :heavy_check_mark: |
| MQTT 3.1.1          | :heavy_check_mark: |   | Offline Buffering    | :heavy_check_mark: |
| LWT                 | :heavy_check_mark: |   | WebSocket Support    | :heavy_check_mark: |
| SSL / TLS           | :heavy_check_mark: |   | Standard TCP Support | :heavy_check_mark: |
| Message Persistence | :heavy_check_mark: |   |

## Links

- Project Website: [https://www.eclipse.org/paho](https://www.eclipse.org/paho)
- Eclipse Project Information: [https://projects.eclipse.org/projects/iot.paho](https://projects.eclipse.org/projects/iot.paho)
- Paho Android Client Page: [https://www.eclipse.org/paho/clients/android/](https://www.eclipse.org/paho/clients/android/)
- Twitter: [@eclipsepaho](https://twitter.com/eclipsepaho)
- Mailing-list: [https://dev.eclipse.org/mailman/listinfo/paho-dev](https://dev.eclipse.org/mailman/listinfo/paho-dev)


## Using this Paho Android Client

#### Jitpack.io

```
  allprojects {
    repositories {
      ...
      maven { url 'https://jitpack.io' }
    }
  }
```
```
dependencies {
  implementation 'androidx.legacy:legacy-support-v4:1.0.0'
  implementation 'com.github.hannesa2:paho.mqtt.android:$latestVersion'
}
```
