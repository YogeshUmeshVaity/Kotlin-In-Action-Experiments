package sealedclassvsenum.nesting.sealedclass

/**
 * As our state grows in complexity, there are times in which we are only concerned
 * about a subset of that state. Nested sealed classes can be used for such purpose.
 */
sealed class Error
class InternetError : Error()
class BluetoothError : Error()
class TemperatureError : Error()

sealed class Nfc : Error()
class NfcError : Nfc()
class ConnectionError : Nfc()

sealed class Camera : Error()
class CameraError : Camera()

fun handleNfcErrors(nfcError: Nfc): Unit = when(nfcError) {
    is NfcError -> TODO()
    is ConnectionError -> TODO()
}

fun handleCameraErrors(cameraError: Camera): Unit = when(cameraError) {
    is CameraError -> TODO()
}

fun handleErrors(error: Error): Unit = when(error) {
    is InternetError -> TODO()
    is BluetoothError -> TODO()
    is TemperatureError -> TODO()
    is NfcError -> TODO()
    is CameraError -> TODO()
    is ConnectionError -> TODO()
}