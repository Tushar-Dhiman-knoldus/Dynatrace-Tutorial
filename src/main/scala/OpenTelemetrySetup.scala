import io.opentelemetry.sdk.OpenTelemetrySdk
import io.opentelemetry.sdk.trace.SdkTracerProvider

object OpenTelemetrySetup {
  def setup(): OpenTelemetrySdk = {
    // Set up OpenTelemetry SDK
    val tracerProvider = SdkTracerProvider.builder().build()

    // Initialize the global OpenTelemetry instance
    val openTelemetry = OpenTelemetrySdk.builder()
      .setTracerProvider(tracerProvider)
      .buildAndRegisterGlobal()

    openTelemetry
  }
}
